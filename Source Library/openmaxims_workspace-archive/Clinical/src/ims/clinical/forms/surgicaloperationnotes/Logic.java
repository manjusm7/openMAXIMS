//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Aidan Mc Donnell using IMS Development Environment (version 1.70 build 3432.23566)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.clinical.forms.surgicaloperationnotes;


import ims.clinical.vo.SurgicalOperationSummaryVo;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.MedicVo;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.LayerBridge;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long	serialVersionUID	= 1L;
	


	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
			
			open();
			checkSUrgicalOpSummary();//wdev-15917
			
			

	}
	//wdev-15917
	private void checkSUrgicalOpSummary()
	{
		SurgicalOperationSummaryVo surgOpSummary = domain.getSurgicalOperationSummary(form.getGlobalContext().Core.getCurrentCareContext());
		form.getLocalContext().setSurgicalOperationSummary(surgOpSummary);
		if( surgOpSummary == null)
		{
			enableDisableAllTabs(false);
			setReadOnlyOnCc(true);	
		}
		else
			updateControlState();
		
	}

	@Override
	protected void onlyr1TabChanged(LayerBridge tab) {
		if (form.lyr1().tabGeneralInstructions().isVisible())
		{
			form.lyr1().tabGeneralInstructions().ccGeneralDetails().refresh();
			return;
		}
		if (form.lyr1().tabDiagram().isVisible())
		{
			form.lyr1().tabDiagram().ccDiagram().refresh();
			return;
		}
		if (form.lyr1().tabOperationDetails().isVisible())
		{
			form.lyr1().tabOperationDetails().ccOperationDetail().refresh();
			return;
		}
		if (form.lyr1().tabPostOp().isVisible())
		{
			form.lyr1().tabPostOp().ccPostOpInstruction().refresh();
			return;
		}
		if (form.lyr1().tabPreview().isVisible())
		{
			form.lyr1().tabPreview().ccPreview().refresh();
			return;
		}
	}

	
	public void open() throws PresentationLogicException {
		Object currUser =  domain.getHcpUser();
		
		if (currUser != null)	//wdev-16116
		{
			setReadOnlyOnCc(domain.getIsNotesCompleted(form.getGlobalContext().Core.getCurrentCareContext()));
		}
		else
		{
			setReadOnlyOnCc(true);
		}
		
		
		form.lyr1().showtabGeneralInstructions();
		form.lyr1().tabGeneralInstructions().ccGeneralDetails().refresh();
		updateControlState();
		
		
	}
	private void setReadOnlyOnCc(boolean isRead)
	{
		form.lyr1().tabGeneralInstructions().ccGeneralDetails().setReadOnly(isRead);
		form.lyr1().tabOperationDetails().ccOperationDetail().setReadOnly(isRead);
		form.lyr1().tabDiagram().ccDiagram().setReadOnly(isRead);
		form.lyr1().tabPostOp().ccPostOpInstruction().setReadOnly(isRead);
		//form.lyr1().tabPreview().ccPreview().setReadOnly(isRead);
	}
	private void enableDisableAllTabs(boolean enable)
	{
		
		form.lyr1().tabDiagram().setHeaderEnabled(enable);
		form.lyr1().tabGeneralInstructions().setHeaderEnabled(enable);
		form.lyr1().tabOperationDetails().setHeaderEnabled(enable);
		form.lyr1().tabPostOp().setHeaderEnabled(enable);
		form.lyr1().tabPreview().setHeaderEnabled(enable);
		updateControlState();
	}

	@Override
	protected void onCcDiagramValueChanged() throws PresentationLogicException {
		
		
		FormMode ccMode = form.lyr1().tabDiagram().ccDiagram().getMode();
		form.setMode(ccMode);
		enableDisableAllTabs(FormMode.VIEW.equals(ccMode));
		
	}

	@Override
	protected void onCcGeneralDetailsValueChanged()	throws PresentationLogicException {
		FormMode ccMode = form.lyr1().tabGeneralInstructions().ccGeneralDetails().getMode();
		form.setMode(ccMode);
		enableDisableAllTabs(FormMode.VIEW.equals(ccMode));
		
		
	}

	@Override
	protected void onCcOperationDetailValueChanged() throws PresentationLogicException {
		FormMode ccMode = form.lyr1().tabOperationDetails().ccOperationDetail().getMode();
		form.setMode(ccMode);
		enableDisableAllTabs(FormMode.VIEW.equals(ccMode));
		
	}

	@Override
	protected void onCcPostOpInstructionValueChanged() throws PresentationLogicException {
		FormMode ccMode = form.lyr1().tabPostOp().ccPostOpInstruction().getMode();
		form.setMode(ccMode);
		boolean viewMode = FormMode.VIEW.equals(ccMode);
		enableDisableAllTabs(viewMode);
		if (viewMode && domain.getIsNotesCompleted(form.getGlobalContext().Core.getCurrentCareContext()))
			setReadOnlyOnCc(true);
		else if(viewMode && Boolean.FALSE.equals(domain.getIsNotesCompleted(form.getGlobalContext().Core.getCurrentCareContext())))  //wdev-13658
		{
			Object currUser =  domain.getHcpUser();			//wdev-14074
			
			if (currUser != null)				//wdev-14074, wdev-6116	
				setReadOnlyOnCc(false);	//wdev-13658
			else
				setReadOnlyOnCc(true);	//wdev-14074
		}
		
	}
	private void updateControlState()
	{
		//form.lnkReturn().setVisible(form.getForms().Clinical.SurgicalOpNotes.equals(engine.getFormName()));
		form.lnkReturn().setVisible(FormMode.VIEW.equals(form.getMode()) && form.getLocalContext().getSurgicalOperationSummaryIsNotNull() && engine.getPreviousNonDialogFormName().equals(form.getForms().Clinical.SurgicalOpNotesList) ); //wdev-16093
		form.lnkReturn().setEnabled(FormMode.VIEW.equals(form.getMode()));
		form.btnStart().setVisible(!form.getLocalContext().getSurgicalOperationSummaryIsNotNull()); 		//wdev-15917
		form.btnStart().setEnabled(!form.getLocalContext().getSurgicalOperationSummaryIsNotNull());		//wdev-15917
	}
	@Override
	protected void onCcPreviewValueChanged() throws PresentationLogicException {
		boolean viewMode = FormMode.VIEW.equals(form.lyr1().tabPreview().ccPreview().getMode());
		enableDisableAllTabs(viewMode);
		
		
	}

	@Override
	protected void onLnkReturnClick() throws PresentationLogicException
	{
		engine.open(form.getForms().Clinical.SurgicalOpNotesList);
		
	}

	//wdev-15917
	protected void onBtnStartClick() throws PresentationLogicException 
	{
		SurgicalOperationSummaryVo surgOpSumm = new SurgicalOperationSummaryVo();
		surgOpSumm.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		surgOpSumm.setInitiatingHCP((HcpLiteVo)domain.getHcpLiteUser());
		
		if( surgOpSumm.getInitiatingHCP() == null)
		{
			engine.showMessage("The logged in user is not a HCP and so cannot Start this eOpNotes","Warning", MessageButtons.OK, MessageIcon.WARNING);
			return;
		}
		String[] str = surgOpSumm.validate();
		if (str != null && str.length > 0)
		{
			engine.showErrors(str);
			return;
		}

		try 
		{
			surgOpSumm = domain.saveSurgicalOperationSummary(surgOpSumm);
			form.getLocalContext().setSurgicalOperationSummary(surgOpSumm);
		} 
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
			form.setMode(FormMode.VIEW);			
			return;
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
		
			form.setMode(FormMode.VIEW);
			
		
		}
		open();
		checkSUrgicalOpSummary();
		
	}

	
}
