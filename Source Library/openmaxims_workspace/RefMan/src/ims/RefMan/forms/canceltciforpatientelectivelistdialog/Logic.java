//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.RefMan.forms.canceltciforpatientelectivelistdialog;

import ims.RefMan.vo.ElectiveTCIForReferralDetailsVo;
import ims.RefMan.vo.TCIOutcomeForPatientElectiveListVo;
import ims.RefMan.vo.lookups.AdmissionOfferOutcome;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.enums.MosType;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;
import ims.scheduling.vo.CancellationTypeReasonVo;
import ims.scheduling.vo.CancellationTypeReasonVoCollection;
import ims.scheduling.vo.lookups.CancelAppointmentReason;
import ims.scheduling.vo.lookups.Status_Reason;
import ims.vo.interfaces.IMos;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		initialize(args);
		open();
	}
	
	private void open()
	{
		if(form.getGlobalContext().RefMan.getTCIOutcomeForPatientElectiveList() != null && form.getGlobalContext().RefMan.getTCIOutcomeForPatientElectiveList().getID_TCIOutcomeForPatientElectiveList() != null)
		{
			populateScreenFromData(form.getGlobalContext().RefMan.getTCIOutcomeForPatientElectiveList());
		}
	}

	private void populateScreenFromData(TCIOutcomeForPatientElectiveListVo tciOutcomeForPatientElectiveList)
	{
		clear();
		
		if(tciOutcomeForPatientElectiveList == null)
			return;
		
		form.dtimCancelled().setValue(tciOutcomeForPatientElectiveList.getStatusDateTime());
		form.cmbCancellationType().setValue(getStatusReasonByOutcome(tciOutcomeForPatientElectiveList.getOutcome()));
		
		populateCancellationReason(form.cmbCancellationType().getValue());
		
		form.cmbCancellationReason().setValue(getCancellationConfig(tciOutcomeForPatientElectiveList.getCancellationReason()));
		form.ccMos().setValue(domain.getMemberOfStaff(tciOutcomeForPatientElectiveList.getChangeBy()));
		form.chkCancelledForNonMedicalReason().setValue(tciOutcomeForPatientElectiveList.getCancelledForNonMedicalReason());
		form.txtReasonCom().setValue(tciOutcomeForPatientElectiveList.getReasonComments());
	}

	private Status_Reason getStatusReasonByOutcome(AdmissionOfferOutcome outcome)
	{
		if(AdmissionOfferOutcome.ADMISSION_CANCELLED_BY_PATIENT_2.equals(outcome))
			return Status_Reason.PATIENTCANCELLED;
		
		if(AdmissionOfferOutcome.ADMISSION_CANCELLED_BY_HOSPITAL_BEFORE_6.equals(outcome) || AdmissionOfferOutcome.ADMISSION_CANCELLED_BY_HOSPITAL_ON_DAY_7.equals(outcome))
			return Status_Reason.HOSPITALCANCELLED;
		
		return null;
	}

	private CancellationTypeReasonVo getCancellationConfig(CancelAppointmentReason cancellationReason)
	{
		if(cancellationReason == null)
			return null;
		
		for(int i=0; i<form.cmbCancellationReason().getValues().size(); i++)
		{
			Object config = form.cmbCancellationReason().getValues().get(i);
			
			if(config instanceof CancellationTypeReasonVo)
			{
				if(cancellationReason.equals(((CancellationTypeReasonVo) config).getCancellationReason()))
					return (CancellationTypeReasonVo) config;
			}
		}
		
		return null;
	}

	private void clear()
	{
		form.dtimCancelled().setValue(null);
		form.cmbCancellationType().setValue(null);
		form.cmbCancellationReason().setValue(null);
		form.ccMos().setValue(null);
		form.chkCancelledForNonMedicalReason().setValue(null);
		form.txtReasonCom().setValue(null);
	}

	private void initialize(Object[] args)
	{
		form.ccMos().initialize(MosType.ALL);
		form.ccMos().isRequired(Boolean.TRUE);
		form.ccMos().setValue((IMos) domain.getMosUser());
		form.dtimCancelled().setValue(new DateTime());
		//  WDEV-19446 -- starts here 
		if (form.getGlobalContext().RefMan.getTCIOutcomeForPatientElectiveList() != null)
		{
			ElectiveTCIForReferralDetailsVo tciDetails = domain.getTCIDetails(form.getGlobalContext().RefMan.getTCIOutcomeForPatientElectiveList().getTciId());
			Boolean isAnyTimeRecordedAgainstCaseDetails = form.getGlobalContext().RefMan.getTheatreBookingAppointment()!=null ? domain.isAnyTimeRecordedAgainstCaseDetails(form.getGlobalContext().RefMan.getTheatreBookingAppointment()) : null; //WDEV-22778
			
			form.getLocalContext().setTCIForCancellationDetails(tciDetails);
			
			//WDEV-22778
			form.lblCancelTheatre().setVisible(Boolean.TRUE.equals(form.getGlobalContext().RefMan.getTCIOutcomeForPatientElectiveList().getTciHasFutureTheatreAppt()) && !Boolean.TRUE.equals(isAnyTimeRecordedAgainstCaseDetails));			
			form.chkCancelTheatre().setVisible(Boolean.TRUE.equals(form.getGlobalContext().RefMan.getTCIOutcomeForPatientElectiveList().getTciHasFutureTheatreAppt()) && !Boolean.TRUE.equals(isAnyTimeRecordedAgainstCaseDetails));
			form.chkCancelTheatre().setValue(Boolean.TRUE.equals(form.getGlobalContext().RefMan.getTCIOutcomeForPatientElectiveList().getCancelTheatreAppointment())); 
		}
		
		//populateCancelationType(form.getLocalContext().getTCIForCancellationDetails().getTCIDate(), form.dtimCancelled().getValue()); // WDEV-18390 
		bindCancellationType();
		populateCancellationReason(form.cmbCancellationType().getValue());
		
		if (form.cmbCancellationReason().getValue() != null)
			form.chkCancelledForNonMedicalReason().setValue(Boolean.TRUE.equals(form.cmbCancellationReason().getValue().getIsNonMedicalReason()));
		//  WDEV-19446 --- ends here
		
		//WDEV-22889 
		form.setMode((args != null && args.length > 0 &&  args[0] instanceof FormMode) ? (FormMode)args[0] : FormMode.EDIT);
		form.getLocalContext().setbCanEdit((args != null && args.length > 1 &&  args[1] instanceof Boolean) ? !(Boolean) args[1] : true);
	}
	
	private void bindCancellationType()
	{
		form.cmbCancellationType().clear();
		
		form.cmbCancellationType().newRow(Status_Reason.PATIENTCANCELLED, Status_Reason.PATIENTCANCELLED.getText());
		form.cmbCancellationType().newRow(Status_Reason.HOSPITALCANCELLED, Status_Reason.HOSPITALCANCELLED.getText());
	}

	//WDEV-19446
	/*
	private void populateCancelationType(Date tciDate, DateTime cancellationDate)
	{
		form.cmbCancellationType().clear();
		AdmissionOfferOutcomeCollection cancellationTypes = getCancellationTypes(tciDate, cancellationDate);
		for (int i = 0; cancellationTypes != null && i < cancellationTypes.size(); i++)
		{			
			form.cmbCancellationType().newRow(cancellationTypes.get(i), cancellationTypes.get(i).toString());
		}
		if (cancellationTypes.size() == 1)
			form.cmbCancellationType().setValue(cancellationTypes.get(0));
	}*/
	
	//WDEV-19446
	/*
	private AdmissionOfferOutcomeCollection getCancellationTypes(Date tciDate, DateTime cancellationDate)
	{
		AdmissionOfferOutcomeCollection cancellationTypes = ims.RefMan.vo.lookups.LookupHelper.getAdmissionOfferOutcome(domain.getLookupService());
		
		cancellationTypes.remove(AdmissionOfferOutcome.NOT_APPLICABLE_OR_REMOVED_ETC_9);
		cancellationTypes.remove(AdmissionOfferOutcome.PATIENT_ADMITTED);
		cancellationTypes.remove(AdmissionOfferOutcome.PATIENT_ADMITTED_COMMENCED_8);
		cancellationTypes.remove(AdmissionOfferOutcome.PATIENT_ADMITTED_COMPLETED_1);
		cancellationTypes.remove(AdmissionOfferOutcome.PATIENT_ADMITTED_TREATMENT_DEFERRED_5);
		cancellationTypes.remove(AdmissionOfferOutcome.PATIENT_FAILED_TO_ARRIVE_4);
		
		for (int i = 0; cancellationTypes != null && i < cancellationTypes.size(); i++)
		{
			if (cancellationDate != null)
			{	
				if (cancellationDate.getDate().isGreaterThan(tciDate))
				{		
					cancellationTypes.remove(AdmissionOfferOutcome.ADMISSION_CANCELLED_BY_HOSPITAL_BEFORE_6);
					cancellationTypes.remove(AdmissionOfferOutcome.ADMISSION_CANCELLED_BY_HOSPITAL_ON_DAY_7);	
				}	
				else if (cancellationDate.getDate().isLessThan(tciDate))
				{
					cancellationTypes.remove(AdmissionOfferOutcome.ADMISSION_CANCELLED_BY_HOSPITAL_ON_DAY_7);				
				}
				else
				{
					cancellationTypes.remove(AdmissionOfferOutcome.ADMISSION_CANCELLED_BY_HOSPITAL_BEFORE_6);

				}
			}
		}		
		return cancellationTypes;
	}*/
	//WDEV-19446 ----------------end
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (!validateUiRules())
			return;

		TCIOutcomeForPatientElectiveListVo tciOutcome = populateDataFromScreen(form.getGlobalContext().RefMan.getTCIOutcomeForPatientElectiveList());	
		if(tciOutcome.getID_TCIOutcomeForPatientElectiveList() != null)
		{
			String[] errors = tciOutcome.validate();
			if(errors != null && errors.length > 0)
			{
				engine.showErrors(errors);
				return; 
			}
			
			try
			{
				tciOutcome = domain.save(tciOutcome);
			}
			catch (StaleObjectException e)
			{
				e.printStackTrace();
				engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				engine.close(DialogResult.ABORT);
				return;
			}
		}
		
		form.getGlobalContext().RefMan.setTCIOutcomeForPatientElectiveList(tciOutcome);
		
		engine.close(DialogResult.OK);
	}

	private TCIOutcomeForPatientElectiveListVo populateDataFromScreen(TCIOutcomeForPatientElectiveListVo tciOutcomeForPatientElectiveList)
	{
		if (tciOutcomeForPatientElectiveList == null)
			tciOutcomeForPatientElectiveList = new TCIOutcomeForPatientElectiveListVo();

		tciOutcomeForPatientElectiveList.setCancelTheatreAppointment(Boolean.FALSE);
		tciOutcomeForPatientElectiveList.setChangeBy((MemberOfStaffLiteVo) form.ccMos().getValue());
		tciOutcomeForPatientElectiveList.setOutcome(getOutcomeByStatusReason(form.cmbCancellationType().getValue()));
		tciOutcomeForPatientElectiveList.setStatusDateTime(form.dtimCancelled().getValue());
		tciOutcomeForPatientElectiveList.setCancelledForNonMedicalReason(form.chkCancelledForNonMedicalReason().getValue());	//wdev-18419
		tciOutcomeForPatientElectiveList.setCancellationReason(form.cmbCancellationReason().getValue() != null ? form.cmbCancellationReason().getValue().getCancellationReason() : null);
		tciOutcomeForPatientElectiveList.setReasonComments(form.txtReasonCom().getValue());  //WDEV-19929 
		tciOutcomeForPatientElectiveList.setCancelTheatreAppointment(form.chkCancelTheatre().isVisible() ? form.chkCancelTheatre().getValue() : null);
		
		return tciOutcomeForPatientElectiveList;
	}

	private AdmissionOfferOutcome getOutcomeByStatusReason(Status_Reason statusReason)
	{
		if(statusReason == null)
			return null;
		
		if(Status_Reason.PATIENTCANCELLED.equals(statusReason))
			return AdmissionOfferOutcome.ADMISSION_CANCELLED_BY_PATIENT_2;
		
		if(form.dtimCancelled().getValue() != null && Status_Reason.HOSPITALCANCELLED.equals(statusReason) && form.getLocalContext().getTCIForCancellationDetails() != null)
		{
			if(form.getLocalContext().getTCIForCancellationDetails().getTCIDate().isGreaterThan(form.dtimCancelled().getValue().getDate()))
				return AdmissionOfferOutcome.ADMISSION_CANCELLED_BY_HOSPITAL_BEFORE_6;
			else if(form.getLocalContext().getTCIForCancellationDetails().getTCIDate().equals(form.dtimCancelled().getValue().getDate()))
				return AdmissionOfferOutcome.ADMISSION_CANCELLED_BY_HOSPITAL_ON_DAY_7;
		}
		
		return null;
	}

	private boolean validateUiRules()
	{
		ArrayList<String> listOfErrors = new ArrayList<String>();

		if (form.cmbCancellationType().getValue() == null)
		{
			listOfErrors.add("Cancellation Type is mandatory.");
		}
		
		if(form.cmbCancellationReason().getValue() == null)
		{
			listOfErrors.add("Cancellation Reason is mandatory");
		}

		if (form.ccMos().getValue() == null)
		{
			listOfErrors.add("Cancelled By is mandatory.");
		}

		if (form.dtimCancelled().getValue() == null)
		{
			listOfErrors.add("Cancelled Date/Time is mandatory.");
		}
		
		if (form.dtimCancelled().getValue() != null && form.getLocalContext().getTCIForCancellationDetails() != null && form.dtimCancelled().getValue().getDate().isGreaterThan(form.getLocalContext().getTCIForCancellationDetails().getTCIDate()))
		{
			listOfErrors.add("Cancelled Date cannot be later than TCI Date."); //WDEV-22867
		}

		int errorCount = listOfErrors.size();

		if (errorCount == 0)
			return true;
		
		String[] result = listOfErrors.toArray(new String[errorCount]);

		if (result != null && result.length > 0)
		{
			engine.showErrors(result);
			return false;
		}

		return true;
	}

	@Override
	protected void onMessageBoxClosed(int messageBoxId, DialogResult result) throws PresentationLogicException
	{
		if (DialogResult.YES.equals(result))
		{
			form.getGlobalContext().RefMan.getTCIOutcomeForPatientElectiveList().setCancelTheatreAppointment(Boolean.TRUE);
		}
		
		engine.close(DialogResult.OK);
	}

	@Override
	protected void onCmbCancellationReasonValueChanged() throws PresentationLogicException
	{
		form.chkCancelledForNonMedicalReason().setValue(form.cmbCancellationReason().getValue() != null && Boolean.TRUE.equals(form.cmbCancellationReason().getValue().getIsNonMedicalReason()));		
	}
	
	//WDEV-19446
	@Override
	protected void onCmbCancellationTypeValueChanged()	throws PresentationLogicException 
	{
		form.chkCancelledForNonMedicalReason().setValue(null);	//WDEV-19446 
		populateCancellationReason(form.cmbCancellationType().getValue());
		
	}
	
	//WDEV-19446
	private void populateCancellationReason(Status_Reason status_Reason)
	{
		form.cmbCancellationReason().clear();
		
		if (status_Reason == null)
			return;
		
		CancellationTypeReasonVoCollection cancelReasonsColl = domain.getCancellationReasons(status_Reason);
		
		if (cancelReasonsColl == null)
			return;
		for (int i=0;i<cancelReasonsColl.size();i++)
		{
			if (cancelReasonsColl.get(i) == null)
				continue;
			form.cmbCancellationReason().newRow(cancelReasonsColl.get(i), cancelReasonsColl.get(i).getCancellationReason().getText());			
		}
		if (cancelReasonsColl.size() == 1)
		{	
			form.cmbCancellationReason().setValue(cancelReasonsColl.get(0));
			form.chkCancelledForNonMedicalReason().setValue(cancelReasonsColl.get(0) != null && Boolean.TRUE.equals(cancelReasonsColl.get(0).getIsNonMedicalReason()));
		}	
	}
	
	//WDEV-22889 - start
	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();		
	}
	
	private void updateControlsState()
	{
		form.btnEdit().setVisible(FormMode.VIEW.equals(form.getMode()) && Boolean.TRUE.equals(form.getLocalContext().getbCanEdit()));
		form.btnSave().setVisible(FormMode.EDIT.equals(form.getMode()));		
		form.cmbCancellationType().setEnabled(FormMode.EDIT.equals(form.getMode()));
		form.cmbCancellationReason().setEnabled(FormMode.EDIT.equals(form.getMode()));
		form.dtimCancelled().setEnabled(FormMode.EDIT.equals(form.getMode()));
		form.ccMos().setEnabled(FormMode.EDIT.equals(form.getMode()));
		form.ccMos().isRequired(FormMode.EDIT.equals(form.getMode()));
		form.txtReasonCom().setEnabled(FormMode.EDIT.equals(form.getMode()));
		form.chkCancelTheatre().setEnabled(form.chkCancelTheatre().isVisible() && FormMode.EDIT.equals(form.getMode()));
		form.btnCancel().setText(FormMode.EDIT.equals(form.getMode()) ? "Cancel" : "Close");
	}

	@Override
	protected void onBtnEditClick() throws PresentationLogicException
	{
		updateInstance();		
	}

	private void updateInstance()
	{
		form.setMode(FormMode.EDIT);		
	}
	
	//WDEV-22889 -- end 
}
