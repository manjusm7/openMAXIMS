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
// This code was generated by Andrei Stefan Bondar using IMS Development Environment (version 1.80 build 4035.27320)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.racpc.forms.racpcreferral;

import java.util.ArrayList;

import java.util.List;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.CommChannelVo;
import ims.core.vo.CommChannelVoCollection;
import ims.core.vo.GPPracticesLiteVo;
import ims.core.vo.GPPracticesLiteVoCollection;
import ims.core.vo.Hcp;
import ims.core.vo.PersonAddress;
import ims.core.vo.enums.MosType;
import ims.core.vo.lookups.ChannelType;
import ims.core.vo.lookups.HcpDisType;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.racpc.vo.CareContextForRACPCReferralVo;
import ims.racpc.vo.PASEventForRACPCReferralVo;
import ims.racpc.vo.RACPCReferralVo;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	
	private void initialize()
	{
		form.ccClinicDoctor().initialize(MosType.MEDIC);
		form.ccClinicDoctor().isRequired(true);
		form.ccCardiologist().initialize(MosType.MEDIC);
		form.ccCardiologist().isRequired(true);
	
		if (!form.getGlobalContext().Core.getCurrentCareContext().getPasEventIsNotNull())
			engine.showMessage("There is no PAS Event linked to the current care context","Warning",MessageButtons.OK,MessageIcon.WARNING);
	}
	
	private void open()
	{
		clearControls();
		
		form.getLocalContext().setCurrentRecord(domain.getRACPCReferral(form.getGlobalContext().Core.getCurrentCareContext()));
		
		populateScreenFromData(form.getLocalContext().getCurrentRecord());
		
		updateControlsState();

		form.setMode(FormMode.VIEW);
	}
	
	private void populateScreenFromData(RACPCReferralVo voRACPCReferral)
	{
		if (voRACPCReferral == null)
			return;
		
		form.dteReferralMade().setValue(voRACPCReferral.getDateReferralMade());
		form.dteReferralReceived().setValue(voRACPCReferral.getDateReferralReceived());
		
		if (voRACPCReferral.getWaitingTime() != null)
			form.intWaitingTime().setValue(voRACPCReferral.getWaitingTime().intValue());
		
		form.cmbReason().setValue(voRACPCReferral.getReferralReason());
		form.cmbReasonDelayed().setValue(voRACPCReferral.getDelayReason());
		form.ccCardiologist().setValue(voRACPCReferral.getCardiologist());
		form.ccClinicDoctor().setValue(voRACPCReferral.getClinicDoctor());
		
		if (form.getLocalContext().getCurrentRecordIsNotNull())	
		{
			if (voRACPCReferral.getCareContextIsNotNull())
				if (voRACPCReferral.getCareContext().getPasEventIsNotNull())
					populateFromPASEvent(voRACPCReferral.getCareContext().getPasEvent());
			
			if (voRACPCReferral.getAppointmentDateIsNotNull())
			{
				form.dteAppointment().setValue(voRACPCReferral.getAppointmentDate());
			}
			
			if (voRACPCReferral.getSourceofReferralIsNotNull())
			{
				form.cmbReferralSource().setValue(voRACPCReferral.getSourceofReferral());
			}
		}
	}
	
	private String setGPName(PASEventForRACPCReferralVo vo)
	{
		String value = "";
		
		if (vo.getReferringGPIsNotNull() && vo.getReferringGP().getNameIsNotNull())
		{
			if (vo.getReferringGP().getName().getForenameIsNotNull())
				value += vo.getReferringGP().getName().getForename() + " ";
			
			if (vo.getReferringGP().getName().getSurnameIsNotNull())
				value += vo.getReferringGP().getName().getSurname();
		}
		
		return value;
	}
	
	private void populateFromPASEvent(PASEventForRACPCReferralVo voPASEvent) 
	{
		form.dteAppointment().setValue(voPASEvent.getEventDateTimeIsNotNull() ? voPASEvent.getEventDateTime().getDate(): null);
		form.cmbReferralSource().setValue(voPASEvent.getSourceOfReferralIsNotNull() ? voPASEvent.getSourceOfReferral():null);			
		form.txtGPName().setValue(setGPName(voPASEvent));
		
		GPPracticesLiteVoCollection collection = null;
		
		if (voPASEvent != null)
			if (voPASEvent.getReferringGPIsNotNull())
				if (voPASEvent.getReferringGP().getPracticesIsNotNull())
					collection = voPASEvent.getReferringGP().getPractices();
		
		if (collection != null)
		{
			for (int i = 0; i < collection.size(); i++)
			{
				GPPracticesLiteVo row = collection.get(i);
				
				if (row != null)
				{
					if (row.getIsPrimaryPractice())
					{
						if (row.getPracticeIsNotNull())
						{
							form.txtGPAddress().setValue(getRefferingGPAddress(row.getPractice().getAddressIsNotNull() ? row.getPractice().getAddress():null));
							
							if (row.getPractice().getAddressIsNotNull())
								form.txtGPPostcode().setValue(row.getPractice().getAddress().getPostCodeIsNotNull() ? row.getPractice().getAddress().getPostCode():null);
							
							// populate phone from communication channel			
							form.txtGPPhone().setValue(getPracticePhoneNumber(row.getPractice().getCommChannels()));
							return;
						}
					}
				}
			}
		}
	}
	
	private String getPracticePhoneNumber(CommChannelVoCollection commChannels)
	{
		String value = "";
		
		if (commChannels == null)
			return "";
		
		if (commChannels != null)
		{
			for (int i = 0; i < commChannels.size(); i++)
			{
				CommChannelVo row = commChannels.get(i);
				
				if (row != null)
				{
					if (row.getChannelTypeIsNotNull())
						if (row.getChannelType().equals(ChannelType.GEN_PHONE))
						{
							value = row.getCommValue();
							break;
						}
				}
			}
		}
		
		return value;
	}
	
	private String getRefferingGPAddress(PersonAddress voAddress)
	{
		if (voAddress == null)
			return "";
		
		StringBuffer address = new StringBuffer();
		
		if (voAddress.getLine1IsNotNull()) 
			address.append(voAddress.getLine1().toString());
		if (voAddress.getLine2IsNotNull()) 
			address.append("\r\n" + voAddress.getLine2().toString());
		if (voAddress.getLine3IsNotNull()) 
			address.append("\r\n" + voAddress.getLine3().toString());
		if (voAddress.getLine4IsNotNull()) 
			address.append("\r\n" + voAddress.getLine4().toString());
		if (voAddress.getLine5IsNotNull()) 
			address.append("\r\n" + voAddress.getLine5().toString());
		
		return address.toString();
	}
	
	private void clearControls()
	{
		form.dteReferralMade().setValue(null);
		form.dteReferralReceived().setValue(null);
		form.dteAppointment().setValue(null);
		form.intWaitingTime().setValue(null);
		form.cmbReason().setValue(null);
		form.cmbReasonDelayed().setValue(null);
		form.ccCardiologist().setValue(null);
		form.cmbReferralSource().setValue(null);
		form.ccClinicDoctor().setValue(null);
		form.txtGPName().setValue(null);
		form.txtGPAddress().setValue(null);
		form.txtGPPostcode().setValue(null);
		form.txtGPPhone().setValue(null);
	}
	
	private void updateControlsState()
	{
		if (form.getMode().equals(FormMode.VIEW))
		{		
			boolean isReadOnly = domain.isRACPCSummaryComplete(form.getGlobalContext().Core.getCurrentCareContext());//	WDEV-13437
			
			form.btnNew().setVisible(!form.getLocalContext().getCurrentRecordIsNotNull() && form.getGlobalContext().Core.getCurrentCareContext().getPasEventIsNotNull() && !isReadOnly);//	WDEV-13437
			form.btnEdit().setVisible(form.getLocalContext().getCurrentRecordIsNotNull() && form.getGlobalContext().Core.getCurrentCareContext().getPasEventIsNotNull() && !isReadOnly);//	WDEV-13437
		}
	}
	
//	WDEV-13662
	private boolean isRACPCComplete() 
	{	
		boolean isRACPCSummaryComplete = domain.isRACPCSummaryComplete(form.getGlobalContext().Core.getCurrentCareContext());//	WDEV-13662
		
		if(isRACPCSummaryComplete)//	WDEV-13662
		{
			engine.showMessage("RACPC Summary has already been completed. The screen will be refreshed.");
			open();
			return true;
		}
		
		return false;
	}
	
	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
	}
	
	private void newInstance()
	{
		if(isRACPCComplete())//	WDEV-13662
			return;
		
		// populate Cardiologist and Clinic Doctor
		Object objectHcpUser = domain.getHcpUser();
		
		if (objectHcpUser instanceof Hcp)
		{
			Hcp hcpUser = (Hcp) objectHcpUser;
			
			if(HcpDisType.MEDICAL.equals(hcpUser.getHcpType()))
			{
				form.ccClinicDoctor().setValue(hcpUser);
				form.ccCardiologist().setValue(hcpUser);
			}
		}
		
		CareContextForRACPCReferralVo objRACPCReferralCareContext = domain.getCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		if (objRACPCReferralCareContext != null)
			if (objRACPCReferralCareContext.getPasEvent() != null)
				populateFromPASEvent(objRACPCReferralCareContext.getPasEvent());
		
		form.getLocalContext().setCurrentRecord(null);
		form.setMode(FormMode.EDIT);
	}
	
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		updateInstance();
	}

	private void updateInstance()
	{
		if(isRACPCComplete())//	WDEV-13662
			return;
		
		populateScreenFromData(form.getLocalContext().getCurrentRecord());
		form.setMode(FormMode.EDIT);
	}
	
	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save())
		{
			open();
		}
	}
	
	private boolean save()
	{
		if(isRACPCComplete())//	WDEV-13662
			return false;
		
		RACPCReferralVo voReferral = form.getLocalContext().getCurrentRecord();
		if (voReferral == null)
		{
			voReferral = new RACPCReferralVo();
			form.getLocalContext().setCurrentRecord(voReferral);
		}

		voReferral = populateDataFromScreen();

		voReferral.setPatient(form.getGlobalContext().Core.getPatientShort());
		voReferral.setCareContext(domain.getCareContext(form.getGlobalContext().Core.getCurrentCareContext()));
		
		String[] errors = voReferral.validate(validateUIRules());
		if (errors != null)
		{
			engine.showErrors(errors);
			return false;
		}

		try
		{
			form.getLocalContext().setCurrentRecord(domain.saveRACPCReferral(voReferral));
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		} 
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
			return false;
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	public String[] validateUIRules()
	{
		List<String> uiErrors = new ArrayList<String>();
		
		if(form.intWaitingTime().getValue() != null &&  form.intWaitingTime().getValue() < 0)
		{
			uiErrors.add("Waiting time can't be negative.");
		}

		if (form.dteReferralMade().getValue() != null && form.dteReferralReceived().getValue() != null)
			if (form.dteReferralMade().getValue().isGreaterThan(form.dteReferralReceived().getValue()))
				uiErrors.add("Referral Made date must be before Referral Received date");
			
		if (form.dteAppointment().getValue() != null)
		{
			if (form.dteReferralMade().getValue() != null)
				if (form.dteReferralMade().getValue().isGreaterThan(form.dteAppointment().getValue()))
					uiErrors.add("Referral Made date must be before Appointment date");

			if (form.dteReferralReceived().getValue() != null)
				if (form.dteReferralReceived().getValue().isGreaterThan(form.dteAppointment().getValue()))
					uiErrors.add("Referral Received date must be before Appointment date");
		}
		
		String[] voValidate = new String[uiErrors.size()];
		uiErrors.toArray(voValidate);
		
		return voValidate;
	}
	
	private RACPCReferralVo populateDataFromScreen()
	{		
		RACPCReferralVo voReferral = form.getLocalContext().getCurrentRecord();
		
		voReferral.setDateReferralMade(form.dteReferralMade().getValue());
		voReferral.setDateReferralReceived(form.dteReferralReceived().getValue());
		voReferral.setWaitingTime(form.intWaitingTime().getValue());
		voReferral.setReferralReason(form.cmbReason().getValue());
		voReferral.setDelayReason(form.cmbReasonDelayed().getValue());
		voReferral.setCardiologist((Hcp)form.ccCardiologist().getValue());
		voReferral.setClinicDoctor((Hcp)form.ccClinicDoctor().getValue());
		voReferral.setAppointmentDate(form.dteAppointment().getValue());
		voReferral.setSourceofReferral(form.cmbReferralSource().getValue());
		
		return voReferral;	
	}
	
	private Integer calculateWaintingTime(Date sd, Date ed)
	{
		if (sd != null && ed != null)	
			return (int)Date.daysBetween(sd, ed);
		
		return null;
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}

	@Override
	protected void onFormModeChanged() 
	{
		updateControlsState();	
	}

	private void populateWaitingTime() 
	{
		if (form.dteReferralMade().getValue() != null && form.dteAppointment().getValue() != null)
		{
			if (form.dteReferralMade().getValue().isGreaterThan(form.dteAppointment().getValue()))
			{
				engine.showMessage("Referral Made date must be before Appointment date", "Error", MessageButtons.OK, MessageIcon.ERROR);
				return;
			}
			
			form.intWaitingTime().setValue(calculateWaintingTime(form.dteReferralMade().getValue(), form.dteAppointment().getValue()));
		} else {
			form.intWaitingTime().setValue(null);
		}
	}

	protected void onDteReferralMadeValueChanged() throws PresentationLogicException 
	{
		populateWaitingTime();
	}

	@Override
	protected void onDteAppointmentValueChanged() throws PresentationLogicException 
	{
		populateWaitingTime();	
	}
}
