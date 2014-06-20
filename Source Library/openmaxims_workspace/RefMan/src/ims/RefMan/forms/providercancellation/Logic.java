// This code was generated by Catalin Tomozei using IMS Development Environment (version 1.65 build 3223.30681)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.RefMan.forms.providercancellation;

import ims.RefMan.vo.CatsReferralProviderCancellationVo;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.CatsReferralStatusVo;
import ims.RefMan.vo.CatsReferralStatusVoCollection;
import ims.RefMan.vo.ProviderCancellationVo;
import ims.RefMan.vo.lookups.ReferralApptStatus;
import ims.RefMan.vo.lookups.ReferralNoteType;
import ims.configuration.gen.ConfigFlag;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.ReferralNoteVo;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.interfaces.IAppUser;
import ims.framework.utils.DateTime;
import ims.framework.utils.Time;

import java.util.ArrayList;
public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		//wdev-10367
		if(args[0] instanceof Boolean)
			form.getLocalContext().setNewOrEdit((Boolean)args[0]);
		//-----------
		form.getLocalContext().setIsCancelledAlready(false);
		initialize();
	}

	private void initialize()
	{
		clearControls();
		populateRecordingUserAndDateTime();
		populateScreenFromData(form.getGlobalContext().RefMan.getCatsReferral());
	}

	private void populateScreenFromData(CatsReferralRefVo catsReferral)
	{
		if (form.getGlobalContext().RefMan.getCatsReferral() == null)
			return;


		CatsReferralProviderCancellationVo vo = domain.getCatsReferral(form.getGlobalContext().RefMan.getCatsReferral());
		//wdev-10367
		form.getLocalContext().setCurrentProviderCancellation(vo);
		//--------------

		ProviderCancellationVo voProviderCancellation = vo.getProviderCancellation();
		if (voProviderCancellation == null)
			return;

		form.txtCancellingUser().setValue(voProviderCancellation.getSysInfoIsNotNull() ? voProviderCancellation.getSysInfo().getCreationUser() : null);
		form.dtimCancellation().setValue(voProviderCancellation.getCancellationDateTimeIsNotNull() ? voProviderCancellation.getCancellationDateTime() : null);
		form.cmbReason().setValue(voProviderCancellation.getReasonIsNotNull() ? voProviderCancellation.getReason() : null);
		form.txtNotes().setValue(voProviderCancellation.getCommentsIsNotNull() ? voProviderCancellation.getComments() : null);
		
		form.getLocalContext().setIsCancelledAlready(true);
		//wdev-10367
		if(form.getLocalContext().getNewOrEditIsNotNull() && form.getLocalContext().getNewOrEdit().equals(Boolean.TRUE) )
			engine.showMessage("This provider Cancellation has already been made by another user.");
		//--------
			
	}

	private void clearControls()
	{
		form.cmbReason().setValue(null);
		form.dtimCancellation().setValue(new DateTime());
		form.txtNotes().setValue(null);
	}

	private void populateRecordingUserAndDateTime()
	{
		IAppUser mos = engine.getLoggedInUser();
		if (mos != null)
		{
			String user = mos.getUsername();
			form.txtCancellingUser().setValue(user != null ? user : null);
		}
	}

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
		{
			engine.close(DialogResult.OK);
		}
	}

	private String[] getUIErrors()
	{
		ArrayList<String> errors = new ArrayList<String>();
		
		if (form.dtimCancellation().getValue() != null && form.dtimCancellation().getValue().isGreaterThan(new DateTime()))
		{
			errors.add("Cancellation Date cannot be in the future");
		}
		
		if (form.dtimCancellation().getValue() != null 
			&& domain.getReferralDate(form.getGlobalContext().RefMan.getCatsReferral()) != null
			&& form.dtimCancellation().getValue().isLessThan(new DateTime(domain.getReferralDate(form.getGlobalContext().RefMan.getCatsReferral()), new Time(0, 0, 0))))
		{
			errors.add("Cancellation Date cannot be set before referral date");
		}

		if (errors.size() > 0)
		{
			String[] err = new String[errors.size()];
			errors.toArray(err);
			engine.showErrors("Invalid Provider Cancellation", err);
			return err;
		}

		return null;
	}

	private boolean save()
	{
		if (form.getGlobalContext().RefMan.getCatsReferral() == null)
			return false;
		
		// WDEV-12336 - Use local context for referral record
		CatsReferralProviderCancellationVo voCatsReferral = populateCatsReferralVo(form.getLocalContext().getCurrentProviderCancellation());
		
		String[] errors = getUIErrors();
		String[] str = voCatsReferral.validate(errors);
		if (str != null && str.length > 0)
		{
			engine.showErrors(str);
			return false;
		}
		
		//WDEV-12088 - starts here
		ReferralNoteVo referralNote = populateReferralNote(voCatsReferral);
		String[] referralNotesErrors = referralNote.validate();

		if (referralNotesErrors != null && referralNotesErrors.length > 0)
		{
			engine.showErrors(referralNotesErrors);
			return false;
		}
		//WDEV-12088 - ends here
		
		try
		{
			CatsReferralProviderCancellationVo vo = domain.saveReferral(voCatsReferral, referralNote);
			form.getGlobalContext().RefMan.setCatsReferral(vo);
		}
		catch (StaleObjectException e)
		{
			// WDEV-12336 - On StaleObject exception close dialog (CANCEL) and show
			// standard stale message to user
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			e.getStaleObject();
			engine.close(DialogResult.CANCEL);
			return false;
		}
		catch (DomainInterfaceException e)
		{
			e.printStackTrace();
			engine.showMessage(e.getMessage());
			engine.close(DialogResult.CANCEL);
			return false;
		}

		return true;
	}

	//WDEV-12088
	private ReferralNoteVo populateReferralNote(CatsReferralProviderCancellationVo voCatsReferral) 
	{
		ReferralNoteVo voNote = new ReferralNoteVo();
		
		voNote.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		Object voMos = domain.getMosUser();
		if (voMos instanceof MemberOfStaffLiteVo)
			voNote.setRecordingUser((MemberOfStaffLiteVo) voMos);
		
		voNote.setRecordingDateTime(new DateTime());
		voNote.setNoteType(ReferralNoteType.NON_CLINICAL);	
		
		if(voCatsReferral != null && voCatsReferral.getProviderCancellation() != null)
		{
			ProviderCancellationVo voProviderCancellation = voCatsReferral.getProviderCancellation();
			
			String note = "PROVIDER CANCELLATION \n Reason : " + 
			(voProviderCancellation.getReasonIsNotNull() ? voProviderCancellation.getReason().getText() : "")
				+ "\n Comment : " + (voProviderCancellation.getCommentsIsNotNull() ? voProviderCancellation.getComments() : "");
			
			voNote.setNote(note);
		}
		
		return voNote;
	}
	//wdev-10367
	private CatsReferralProviderCancellationVo populateCatsReferralVo(CatsReferralProviderCancellationVo vo )
	{
		
		if (vo == null)
			return null;


		ProviderCancellationVo voProviderCancellation = vo.getProviderCancellation();
		CatsReferralStatusVoCollection voStatusHistoryColl = vo.getStatusHistory();

		CatsReferralStatusVo voCurrentStatus = vo.getCurrentStatus();
		if (voCurrentStatus == null || (voCurrentStatus != null && voCurrentStatus.getReferralStatusIsNotNull() && !voCurrentStatus.getReferralStatus().equals(ReferralApptStatus.REFERRAL_CANCELLED_BY_PROVIDER)))
			voCurrentStatus = new CatsReferralStatusVo();

		if (voProviderCancellation == null)
		{
			voCurrentStatus.setAuthoringUser((MemberOfStaffRefVo) domain.getMosUser());
			voCurrentStatus.setReferralStatus(ReferralApptStatus.REFERRAL_CANCELLED_BY_PROVIDER);
			voCurrentStatus.setStatusDateTime(new DateTime());
			voCurrentStatus.setComment(form.txtNotes().getValue());

			voProviderCancellation = new ProviderCancellationVo();

			if (voStatusHistoryColl == null)
				voStatusHistoryColl = new CatsReferralStatusVoCollection();

			voStatusHistoryColl.add(voCurrentStatus);

			vo.setCurrentStatus(voCurrentStatus);
			vo.setStatusHistory(voStatusHistoryColl);
		}

		voProviderCancellation.setReason(form.cmbReason().getValue());
		voProviderCancellation.setCancellationDateTime(form.dtimCancellation().getValue());
		voProviderCancellation.setComments(form.txtNotes().getValue());

		vo.setProviderCancellation(voProviderCancellation);

		return vo;
	}
}
