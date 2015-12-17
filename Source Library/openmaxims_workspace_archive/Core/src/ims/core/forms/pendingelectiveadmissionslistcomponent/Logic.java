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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.66 build 3261.22124)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.pendingelectiveadmissionslistcomponent;

import ims.configuration.gen.ConfigFlag;
import ims.core.forms.currentinpatientlistcomponent.GenForm;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.HcpFilter;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.LocMostVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.PatientAlertLiteVo;
import ims.core.vo.PatientShort;
import ims.core.vo.PendingElectiveAdmissionListFilterVo;
import ims.core.vo.PersonName;
import ims.core.vo.STHKPendingElectiveAdmissionListVo;
import ims.core.vo.STHKPendingElectiveAdmissionListVoCollection;
import ims.core.vo.lookups.AlertType;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.LocationType;
import ims.core.vo.lookups.LookupHelper;
import ims.core.vo.lookups.PatIdType;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.cn.data.TreeNode;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.SortMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.vo.LookupInstVo;

import java.util.ArrayList;
import java.util.Comparator;

public class Logic extends BaseLogic
{
	/**
	 * WDEV-13136
	 * @author George Josan
	 *	Comparator for manual sorting after estimated discharge date
	 */
	private static class DateTCIComparator implements Comparator<STHKPendingElectiveAdmissionListVo>
	{
		private int direction;

		public DateTCIComparator(SortOrder sortOrderEstimatedDischage)
		{
			if (SortOrder.ASCENDING.equals(sortOrderEstimatedDischage))
				direction = 1;
			else
				direction = -1;
		}

		/**
		 * Function used to compare two records after estimated discharge date
		 */
		public int compare(STHKPendingElectiveAdmissionListVo o1, STHKPendingElectiveAdmissionListVo o2)
		{
			if (o1.getTCIDateIsNotNull() && o2.getTCIDateIsNotNull())
			{
				return o1.getTCIDate().compareTo(o2.getTCIDate()) * direction;
			}
			
			if (o1.getTCIDateIsNotNull() && !o2.getTCIDateIsNotNull())
			{
				return direction;
			}
			
			if (o2.getTCIDateIsNotNull() && !o1.getTCIDateIsNotNull())
			{
				return -1 * direction;
			}
			
			return 0;
		}
	}

	/**
	 * WDEV-13136
	 * @author George Josan
	 *	Comparator for manual sorting after age
	 */
	private static class AgeComparator implements Comparator<STHKPendingElectiveAdmissionListVo>
	{
		private int direction;

		public AgeComparator(SortOrder sortOrderAge)
		{
			if (SortOrder.ASCENDING.equals(sortOrderAge))
				direction = 1;
			else
				direction = -1;
		}

		/**
		 * Function used to compare two records after age
		 */
		public int compare(STHKPendingElectiveAdmissionListVo o1, STHKPendingElectiveAdmissionListVo o2)
		{
			if (o1.getPasEventIsNotNull() && o1.getPasEvent().getPatientIsNotNull() && o1.getPasEvent().getPatient().getAgeIsNotNull()
					&& o2.getPasEventIsNotNull() && o2.getPasEvent().getPatientIsNotNull() && o2.getPasEvent().getPatient().getAgeIsNotNull())
			{
				return o1.getPasEvent().getPatient().getAge().compareTo(o2.getPasEvent().getPatient().getAge()) * direction;
			}
			
			if (o1.getPasEventIsNotNull() && o1.getPasEvent().getPatientIsNotNull() && o1.getPasEvent().getPatient().getAgeIsNotNull()
					&& (!o2.getPasEventIsNotNull() || !o2.getPasEvent().getPatientIsNotNull() || !o2.getPasEvent().getPatient().getAgeIsNotNull()) )
			{
				return direction;
			}
			
			if (o1.getPasEventIsNotNull() && o1.getPasEvent().getPatientIsNotNull() && o1.getPasEvent().getPatient().getAgeIsNotNull()
					&& (!o2.getPasEventIsNotNull() || !o2.getPasEvent().getPatientIsNotNull() || !o2.getPasEvent().getPatient().getAgeIsNotNull()) )
			{
				return -1 * direction;
			}

			return 0;
		}
	}

	/**
	 * WDEV-18011 
	 *	Comparator for manual sorting after alert image 
	 */
	private static class AlertComparator implements Comparator<STHKPendingElectiveAdmissionListVo>
	{
		private int direction;

		public AlertComparator(SortOrder sortOrderAlert)
		{
			if (SortOrder.ASCENDING.equals(sortOrderAlert))
				direction = 1;
			else
				direction = -1;
		}

		/**
		 * Function used to compare two records after alert image 
		 */
		public int compare(STHKPendingElectiveAdmissionListVo o1, STHKPendingElectiveAdmissionListVo o2)
		{
			if (o1.getPasEvent()!= null && o1.getPasEvent().getPatient() != null && o2.getPasEvent() != null && o2.getPasEvent().getPatient() != null)
			{
				Integer val1 = Boolean.TRUE.equals(o1.getActiveAlerts()) ? 1 : 0;
				Integer val2 = Boolean.TRUE.equals(o2.getActiveAlerts()) ? 1 : 0;
				
				if (val1 != 0 && val2 != 0)
				{
					return val1.compareTo(val2) * direction;
				}

				if (val1 != 0 && val2 == 0)
				{
					return direction;
				}

				if (val2 != 0 && val1 == 0)
				{
					return -1 * direction;
				}	
			}

		return 0;
		}
	}
	
	private static final long serialVersionUID = 1L;

	public static final Integer		COLSURNAME			= new Integer(0);
	public static final Integer		COLFORENAME			= new Integer(1);
	public static final Integer		COLHOSPNUM			= new Integer(-1);
	public static final Integer		COLAGE				= new Integer(-2);
	public static final Integer		COLSEX				= new Integer(-3);
	public static final Integer		COLALERTS			= new Integer(-4);
	public static final Integer		COLCONSULANT		= new Integer(-5);
	public static final Integer		COLWARD				= new Integer(-6);
	public static final Integer		COLSPECIALTY		= new Integer(-7);
	public static final Integer		COLPROCEDURE		= new Integer(-8);
	public static final Integer		COLTCIDATE			= new Integer(-9);
	public static final Integer		COLMANAGE			= new Integer(-10);
	public static final Integer		COLCOMMENT			= new Integer(-11);

	@Override
	protected void onQmbWardTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.cmbHospital().getValue() == null)
		{
			engine.showMessage("Please select a Hospital to find a Ward for.");
			return;
		}

		if (value != null)
		{
			LocationLiteVoCollection voColl = domain.listWards(form.cmbHospital().getValue().getID_Location(), value);

			voColl.sort();
			form.qmbWard().clear();
			for (int i = 0; i < voColl.size(); i++)
				form.qmbWard().newRow(voColl.get(i), voColl.get(i).getName());

			if (voColl.size() == 1)
				form.qmbWard().setValue(voColl.get(0));
			else if (voColl.size() > 1)
				form.qmbWard().showOpened();
		}
	}
	@Override
	protected void onQmbConsTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException
	{
		if (value != null)
		{
			HcpFilter voHCPFilter = new HcpFilter();
			PersonName name = new PersonName();
			name.setSurname(value);
			voHCPFilter.setQueryName(name);
			voHCPFilter.setHcpType(HcpDisType.MEDICAL);
			
			HcpLiteVoCollection voColl = domain.listHCPs(voHCPFilter);

			voColl.sort();
			form.qmbCons().clear();
			for (int i = 0; i < voColl.size(); i++)
			{
				form.qmbCons().newRow(voColl.get(i), voColl.get(i).getIHcpName());
			}
			if (voColl.size() == 1)
				form.qmbCons().setValue(voColl.get(0));
			else if (voColl.size() > 1)
				form.qmbCons().showOpened();	
		}
	}

	@Override
	/**
	 * WDEV-13136
	 * Event handler for column header clicked
	 */
	protected void onDyngrdPatientsColumnHeaderClicked(DynamicGridColumn column)
	{
		// Sort patients after selected column
		// Start on the assertion that column identifier is an Integer
		sortPatients((Integer) column.getIdentifier());
		
		// Update controls & context menu states
		updateContextMenus();
	}

	/**
	 * WDEV-13136
	 * Function used to sort patients (after Age & Date TCI)
	 */
	private void sortPatients(Object columnIdentifer)
	{
		// Get records from grid
		STHKPendingElectiveAdmissionListVoCollection gridValues = populateRecordsFromGrid();
		
		// Toggle sort order for column
		sortOrderToggle(columnIdentifer);
		
		// Determine column, sort records
		if (COLAGE.equals(columnIdentifer))
		{
			gridValues.sort(new AgeComparator(form.getLocalContext().getSortOrderAge()));
		}
		else if (COLTCIDATE.equals(columnIdentifer))
		{
			gridValues.sort(new DateTCIComparator(form.getLocalContext().getSortOrderTCIDate()));
		}
		
		//WDEV-18011 
		else if (COLALERTS.equals(columnIdentifer))
		{
			gridValues.sort(new AlertComparator(form.getLocalContext().getSortOrderAlerts()));
		}
		
		// Get selected record
		Object selectedValue = form.dyngrdPatients().getValue();
		
		// Refresh grid
		populateRecordsToGrid(gridValues);
		
		// Reselect value
		form.dyngrdPatients().setValue(selectedValue);
		
		updatePatientGlobalContextOnSelection(form.dyngrdPatients().getValue());
	}

	/**
	 * WDEV-13136
	 * Function used to retrieve records from grid
	 */
	private STHKPendingElectiveAdmissionListVoCollection populateRecordsFromGrid()
	{
		// Create collection to return
		STHKPendingElectiveAdmissionListVoCollection gridValues = new STHKPendingElectiveAdmissionListVoCollection();
		
		// Add each record from grid to collection
		for (int i = 0; i < form.dyngrdPatients().getRows().size(); i++)
		{
			DynamicGridRow row = form.dyngrdPatients().getRows().get(i);
			
			if (row.getValue() instanceof STHKPendingElectiveAdmissionListVo)
				gridValues.add((STHKPendingElectiveAdmissionListVo) row.getValue());
		}
		
		// Return collection grid
		return gridValues;
	}

	
	/**
	 * WDEV-13136
	 * Function used to toggle sort order for specified column
	 */
	private void sortOrderToggle(Object columnIdentifer)
	{
		// Age column
		if (COLAGE.equals(columnIdentifer))
		{
			if (SortOrder.ASCENDING.equals(form.getLocalContext().getSortOrderAge()))
				form.getLocalContext().setSortOrderAge(SortOrder.DESCENDING);
			else
				form.getLocalContext().setSortOrderAge(SortOrder.ASCENDING);
		}
		else
		{
			form.getLocalContext().setSortOrderAge(null);
		}
		
		// Estimate discharge column
		if (COLTCIDATE.equals(columnIdentifer))
		{
			if (SortOrder.ASCENDING.equals(form.getLocalContext().getSortOrderTCIDate()))
				form.getLocalContext().setSortOrderTCIDate(SortOrder.DESCENDING);
			else
				form.getLocalContext().setSortOrderTCIDate(SortOrder.ASCENDING);
			
		}
		else
		{
			form.getLocalContext().setSortOrderTCIDate(null);
		}
		
		// Alert column
		// WDEV-18011 
		if (COLALERTS.equals(columnIdentifer))
		{
			if (SortOrder.ASCENDING.equals(form.getLocalContext().getSortOrderAlerts()))
				form.getLocalContext().setSortOrderAlerts(SortOrder.DESCENDING);
			else
				form.getLocalContext().setSortOrderAlerts(SortOrder.ASCENDING);
			
		}
		else
		{
			form.getLocalContext().setSortOrderAlerts(null);
		}
	}


	/**
	 * WDEV-13136
	 * Function used to populate values to grid 
	 */
	private void populateRecordsToGrid(STHKPendingElectiveAdmissionListVoCollection gridValues)
	{
		// Clear records from grid
		form.dyngrdPatients().getRows().clear();
		
		// Terminate function if the collection is null
		if (gridValues == null)
			return;
		
		// Add each record from collection to grid
		for (int i = 0; i < gridValues.size(); i++)
		{
			addNewDynamicGridRow(gridValues.get(i), null);
		}
	}

	
	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.cmbHospital().setValue(null);
		form.cmbAlert().setValue(null);
		form.dteTCI().setValue(null);
		form.qmbCons().setValue(null);
		form.qmbWard().setValue(null);
		form.txtForename().setValue(null);
		form.txtSurname().setValue(null);
		form.txtIDNum().setValue(null);
		form.cmbSpecialty().setValue(null);
		
		form.chkTCIOnly().setVisible(false);

		form.dyngrdPatients().getRows().clear();
		form.lblTotal().setValue("Total : 0");
		form.getGlobalContext().STHK.setPendingElectiveAdmissionListFilter(null);
		form.getContextMenus().hideAllGenericGridMenuItems();

		//Clear the selected patient information in the Engine
		form.getGlobalContext().Core.setSelectingPatientForm(null);
		form.getGlobalContext().Core.setPatientShort(null);
		form.getGlobalContext().Core.setPatientToBeDisplayed(null);
		engine.setPatientInfo("Please enter Patient ID or Surname and/or Forename");
	}

	@Override
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		search(Boolean.TRUE, null);
	}

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException 
	{
		initialize();
	}

	private void loadAlerts()
	{
		form.cmbAlert().clear();
		
		TreeNode[] coll = LookupHelper.getAlertType(domain.getLookupService()).getRootNodes();
		
		if(coll != null)
		{
			for(int i = 0 ; i < coll.length ; i++)
			{
				AlertType item = (AlertType)coll[i];
				ArrayList<LookupInstVo> coll1 = item.getChildInstances();

				AlertType type = null;
				for(int j=0 ; j < coll1.size() ; j++)
				{
					type = (AlertType)coll1.get(j);
					if(type.isActive())
						form.cmbAlert().newRow((AlertType)coll1.get(j), coll1.get(j).toString());
				}
			}
		}
	}

	private void refreshSearchCriteria()
	{
		PendingElectiveAdmissionListFilterVo voFilter = form.getGlobalContext().STHK.getPendingElectiveAdmissionListFilter();
		
		if (voFilter != null)
		{
			form.txtIDNum().setValue(voFilter.getHospNum());
			form.cmbIDType().setValue(voFilter.getIDType());
			form.txtSurname().setValue(voFilter.getSurname());
			form.txtForename().setValue(voFilter.getForename());
			
			form.cmbHospital().setValue(null);
			for(int i = 0 ; voFilter.getHospitalIsNotNull() && i < form.cmbHospital().getValues().size() ; i++)
			{
				LocationLiteVo voHosp = (LocationLiteVo)form.cmbHospital().getValues().get(i);
				if (voHosp.getID_Location().equals(voFilter.getHospital().getID_Location()))
					form.cmbHospital().setValue((LocationLiteVo)form.cmbHospital().getValues().get(i));
			}
			if ( form.cmbHospital().getValue() == null && voFilter.getHospitalIsNotNull())
			{
				LocationLiteVo voHosp = domain.getHospital(voFilter.getHospital());
				form.cmbHospital().newRow(voHosp, voHosp.getName().toString());
				form.cmbHospital().setValue(voHosp);
			}

			for(int i = 0 ; voFilter.getConsultantIsNotNull() && i < form.qmbCons().getValues().size() ; i++)
			{
				HcpLiteVo voHCP = (HcpLiteVo)form.qmbCons().getValues().get(i);
				if (voHCP.getID_Hcp().equals(voFilter.getConsultant().getID_Hcp()))
					form.qmbCons().setValue((HcpLiteVo)form.qmbCons().getValues().get(i));
			}
			if ( form.qmbCons().getValue() == null && voFilter.getConsultantIsNotNull())
			{
				HcpLiteVo voHCP = domain.getHCP(voFilter.getConsultant().getID_Hcp());
				form.qmbCons().newRow(voHCP, voHCP.getMos().getName().toString());
				form.qmbCons().setValue(voHCP);
			}
			
			form.qmbWard().setValue(null);
			for(int i = 0 ; voFilter.getWardIsNotNull() && i < form.qmbWard().getValues().size() ; i++)
			{
				LocationLiteVo voWard = (LocationLiteVo)form.qmbWard().getValues().get(i);
				if (voWard.getID_Location().equals(voFilter.getWard().getID_Location()))
					form.qmbWard().setValue((LocationLiteVo)form.qmbWard().getValues().get(i));
			}
			if ( form.qmbWard().getValue() == null && voFilter.getWardIsNotNull())
			{
				LocationLiteVo voWard = domain.getWard(voFilter.getWard());
				form.qmbWard().newRow(voWard, voWard.getName());
				form.qmbWard().setValue(voWard);
			}
			form.dteTCI().setValue(voFilter.getTCI());
			form.cmbAlert().setValue(voFilter.getAlert());
			
			form.cmbSpecialty().setValue(voFilter.getSpecialty());
			if (voFilter.getTCIIsNotNull())		
				form.chkTCIOnly().setVisible(true);

			form.chkTCIOnly().setValue(voFilter.getTCIDateOnly());

			search(Boolean.FALSE, form.dyngrdPatients().getSelectedRow() != null ? (STHKPendingElectiveAdmissionListVo)form.dyngrdPatients().getValue() : null);
		}
	}
	
	private void search(Boolean fromButton, ims.core.vo.STHKPendingElectiveAdmissionListVo voPendingToFind) 
	{
		STHKPendingElectiveAdmissionListVo selectedRow = null;
		if (!fromButton && form.dyngrdPatients().getValue() instanceof STHKPendingElectiveAdmissionListVo)
			selectedRow = (STHKPendingElectiveAdmissionListVo) form.dyngrdPatients().getValue();
		
		form.dyngrdPatients().getRows().clear();
		form.lblTotal().setValue("Total : 0"); // WDEV-18099
		form.getContextMenus().hideAllGenericGridMenuItems();
		
		PendingElectiveAdmissionListFilterVo voFilter = new PendingElectiveAdmissionListFilterVo();
		voFilter.setHospNum(form.txtIDNum().getValue());
		voFilter.setIDType(form.cmbIDType().getValue());

		if (form.txtIDNum().getValue() != null
			&& form.cmbIDType().getValue() == null)
		{
			engine.showErrors(new String[]{"Please enter both an Identifier type as well as its value."});
			return;
		}

		//WDEV-13065 -- if (form.txtIDNum().getValue() == null)
		
		voFilter.setSurname(form.txtSurname().getValue());
		voFilter.setForename(form.txtForename().getValue());
		voFilter.setHospital(form.cmbHospital().getValue());
		voFilter.setWard(form.qmbWard().getValue());
		voFilter.setTCI(form.dteTCI().getValue());
		voFilter.setConsultant(form.qmbCons().getValue());
		voFilter.setAlert(form.cmbAlert().getValue());
		voFilter.setSpecialty(form.cmbSpecialty().getValue());
		voFilter.setTCIDateOnly(form.chkTCIOnly().getValue());

		form.getGlobalContext().STHK.setPendingElectiveAdmissionListFilter(voFilter);

		STHKPendingElectiveAdmissionListVoCollection voColl;
		
		if (voFilter.countFieldsWithValue() == 2 
			&& (voFilter.getTCIDateOnlyIsNotNull()
				&& voFilter.getIDTypeIsNotNull()) )
		{
			engine.showMessage("Please enter some valid search criteria.", "Invalid search cirteria", MessageButtons.OK, MessageIcon.ERROR);
			return;
		}

		if (voFilter.countFieldsWithValue() > 1)
		{
			voColl = domain.listPendingInpatients(voFilter);
		}
		else
		{
			engine.showErrors(new String[]{"Please enter some search criteria."});
			return;
		}
		
		if (voColl == null || voColl.size() == 0)
		{
			engine.showMessage("No matching records found");
			return;
		}
		if (voColl != null)
			form.lblTotal().setValue("Total : " + String.valueOf(voColl.size()));
			
		
		for (int i = 0 ; voColl != null && i < voColl.size() ; i++)
		{
			addNewDynamicGridRow(voColl.get(i), voPendingToFind);
		}
		
		form.dyngrdPatients().setValue(selectedRow);		
	}

	private void initialize() 
	{
		loadHospitals();
		if (form.cmbHospital().getValue() == null && engine.getCurrentLocation() != null)
		{
			//Try and load the logged in location as a ward
			LocMostVo voLoc = domain.getLocation((LocationRefVo)engine.getCurrentLocation());
			if (voLoc != null && voLoc.getTypeIsNotNull()
				&& voLoc.getType().equals(LocationType.WARD))
			{
				form.cmbHospital().setValue(voLoc.getParentLocation());
	
				form.qmbWard().newRow(voLoc, voLoc.getName());
				form.qmbWard().setValue(voLoc);
			}
		}

		loadAlerts();

		form.cmbIDType().setValue(PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue()));
		form.chkTCIOnly().setVisible(false);

		initializeDynamicGrid();
	}
	
	private void loadHospitals() 
	{
		LocationLiteVoCollection voColl = domain.listActiveHospitalsLite();
		for (int i = 0 ; voColl != null && i < voColl.size() ; i++)
		{
			form.cmbHospital().newRow(voColl.get(i), voColl.get(i).getName());
			
			if (engine.getCurrentLocation() != null 
				&& voColl.get(i).getID_Location().equals(engine.getCurrentLocation().getID()))
				form.cmbHospital().setValue(voColl.get(i));
		}
	}
	@Override
	protected void onCmbHospitalValueChanged() throws PresentationLogicException 
	{
		form.qmbWard().clear();
		
	}
	public void refresh()
	{
		if (form.getGlobalContext().STHK.getPendingElectiveAdmissionListFilterIsNotNull())
			refreshSearchCriteria();
	}
	private void addEditComment(DynamicGridCell cell) 
	{
		if (cell != null)
			form.dyngrdPatients().setSelectedRow(cell.getRow());

		if (form.dyngrdPatients().getSelectedRow() != null
			&& form.dyngrdPatients().getSelectedRow().getValue() != null)
		{
			STHKPendingElectiveAdmissionListVo voPending = domain.getCurrentPendingRecord(((STHKPendingElectiveAdmissionListVo)form.dyngrdPatients().getSelectedRow().getValue()));
			form.getGlobalContext().Core.setCommentDialogString(voPending.getComments());
			form.dyngrdPatients().getSelectedRow().setValue(voPending);
			updatePatientGlobalContextOnSelection(voPending);//WDEV-18065 
			engine.open(form.getForms().Core.CommentDialog);
		}
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if(formName.equals(form.getForms().Core.CommentDialog) && result.equals(DialogResult.OK))
		{
			STHKPendingElectiveAdmissionListVo voPE = ((STHKPendingElectiveAdmissionListVo)form.dyngrdPatients().getSelectedRow().getValue());
			voPE.setComments(form.getGlobalContext().Core.getCommentDialogString());
			
			String [] errors = voPE.validate();
			if (errors != null)
			{
				engine.showErrors(errors);
				return;
			}
			
			try 
			{
				domain.savePendingRecord(voPE);
			} 
			catch (DomainInterfaceException e) 
			{
				engine.showMessage(e.getMessage());
				return;
			} 
			catch (StaleObjectException e) 
			{
				engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			}
			
			search(false, voPE);
		}
		updateContextMenus(); // WDEV-18088 
	}
	
	@Override
	protected void onDyngrdPatientsCellButtonClicked(DynamicGridCell cell) 
	{
		addEditComment(cell);
	}
	
	private void updateContextMenus()
	{
		form.getContextMenus().hideAllGenericGridMenuItems();
		form.getContextMenus().getGenericGridAddItem().setText("Add/Edit Comment");
		form.getContextMenus().getGenericGridAddItem().setVisible(form.dyngrdPatients().getValue() != null);
	}


	@Override
	protected void onDyngrdPatientsRowSelectionChanged(DynamicGridRow row) 
	{
		if (row == null)
			updatePatientGlobalContextOnSelection(null);
		else
			updatePatientGlobalContextOnSelection(row.getValue());
		
		updateContextMenus();
	}
	
	
	/**
	 * WDEV-13136
	 * Function used to update global context for PatientShort and PatientToBeDisplayed
	 * when grid selection changes
	 */
	private void updatePatientGlobalContextOnSelection(Object value)
	{
		form.getGlobalContext().Core.setSelectingPatientForm(null);
		form.getGlobalContext().Core.setPatientToBeDisplayed(null);
		form.getGlobalContext().Core.setPatientShort(null);

		if (value == null)
			return;
			
		if ((value instanceof STHKPendingElectiveAdmissionListVo)
				&& ((STHKPendingElectiveAdmissionListVo) value).getPasEventIsNotNull()
				&& ((STHKPendingElectiveAdmissionListVo) value).getPasEvent().getPatientIsNotNull())
		{
			PatientShort ps = domain.getPatientShort(((STHKPendingElectiveAdmissionListVo)form.dyngrdPatients().getValue()).getPasEvent().getPatient());

			form.getGlobalContext().Core.setSelectingPatientForm(engine.getFormName());
			form.getGlobalContext().Core.setPatientToBeDisplayed(ps);
			form.getGlobalContext().Core.setPatientShort(ps);
		}
	}
	
	
	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add:
				addEditComment(null);
			break;
		}
	}

	private void addNewDynamicGridRow(STHKPendingElectiveAdmissionListVo voPendingElective, ims.core.vo.STHKPendingElectiveAdmissionListVo voPendingToFind) 
	{
		voPendingElective.setActiveAlerts(false);
		DynamicGridRow newRow = form.dyngrdPatients().getRows().newRow();
		if (voPendingElective.getPasEventIsNotNull() && voPendingElective.getPasEvent().getPatientIsNotNull())
			voPendingElective.getPasEvent().getPatient().calculateAge();
		
		if (voPendingElective.getPasEventIsNotNull() && voPendingElective.getPasEvent().getPatientIsNotNull() && voPendingElective.getPasEvent().getPatient().getNameIsNotNull())
		{
			DynamicGridCell snameCell = newRow.getCells().newCell(getColumn(COLSURNAME), DynamicCellType.LABEL);
			snameCell.setValue(voPendingElective.getPasEvent().getPatient().getName().getSurname());
			snameCell.setTooltip(voPendingElective.getPasEvent().getPatient().getName().getSurname());
			snameCell.setReadOnly(true);
			
			DynamicGridCell fnameCell = newRow.getCells().newCell(getColumn(COLFORENAME), DynamicCellType.LABEL);
			fnameCell.setValue(voPendingElective.getPasEvent().getPatient().getName().getForename());
			fnameCell.setTooltip(voPendingElective.getPasEvent().getPatient().getName().getForename());
			fnameCell.setReadOnly(true);	
		}	
		
		if (voPendingElective.getPasEventIsNotNull() 
			&& voPendingElective.getPasEvent().getPatientIsNotNull() 
			&& voPendingElective.getPasEvent().getPatient().getIdentifiersIsNotNull()
			&& voPendingElective.getPasEvent().getPatient().getIdentifiers().size() > 0
			&& voPendingElective.getPasEvent().getPatient().getPatId(PatIdType.HOSPNUM) != null
			&& voPendingElective.getPasEvent().getPatient().getPatId(PatIdType.HOSPNUM).getValueIsNotNull())
		{
			DynamicGridCell hospnumCell = newRow.getCells().newCell(getColumn(COLHOSPNUM), DynamicCellType.LABEL);
			hospnumCell.setValue(voPendingElective.getPasEvent().getPatient().getPatId(PatIdType.HOSPNUM).getValueIsNotNull() ? voPendingElective.getPasEvent().getPatient().getPatId(PatIdType.HOSPNUM).getValue().toString(): "");
			hospnumCell.setTooltip(voPendingElective.getPasEvent().getPatient().getPatId(PatIdType.HOSPNUM).getValueIsNotNull() ? voPendingElective.getPasEvent().getPatient().getPatId(PatIdType.HOSPNUM).getValue().toString(): "");
			hospnumCell.setReadOnly(true);
		}	
		
		if (voPendingElective.getPasEventIsNotNull() 
			&& voPendingElective.getPasEvent().getPatientIsNotNull() 
			&& voPendingElective.getPasEvent().getPatient().getAgeIsNotNull())
		{
			DynamicGridCell patientCell = newRow.getCells().newCell(getColumn(COLAGE), DynamicCellType.LABEL);
			patientCell.setValue(voPendingElective.getPasEvent().getPatient().getAge().toString());
			patientCell.setReadOnly(true);
		}	

		if (voPendingElective.getPasEventIsNotNull() 
			&& voPendingElective.getPasEvent().getPatientIsNotNull() 
			&& voPendingElective.getPasEvent().getPatient().getSexIsNotNull() )
		{
			DynamicGridCell patientCell = newRow.getCells().newCell(getColumn(COLSEX), DynamicCellType.LABEL);
			patientCell.setValue(voPendingElective.getPasEvent().getPatient().getSex().toString());
			patientCell.setTooltip(voPendingElective.getPasEvent().getPatient().getSex().toString());
			patientCell.setReadOnly(true);
		}	
		
		if (voPendingElective.getPasEventIsNotNull() 
			&& voPendingElective.getPasEvent().getPatientIsNotNull())
		{
			DynamicGridCell patientCell = newRow.getCells().newCell(getColumn(COLALERTS), DynamicCellType.IMAGE); //WDEV-18011 
			//wdev-11146
			if(voPendingElective.getPasEvent().getPatient().getPatientAlertsIsNotNull() && voPendingElective.getPasEvent().getPatient().getPatientAlerts().size() > 0 )
			{
				boolean tempBool = false;
				for(int i = 0; i < voPendingElective.getPasEvent().getPatient().getPatientAlerts().size();i++)
				{
					PatientAlertLiteVo patAlertLiteVo = voPendingElective.getPasEvent().getPatient().getPatientAlerts().get(i);
					if(patAlertLiteVo != null && patAlertLiteVo.getIsCurrentlyActiveAlert().equals(Boolean.TRUE))
					{
						tempBool = true;
						break;
					}
				}
				
				if (tempBool)
				{
					patientCell.setValue(form.getImages().Core.Alert16); //WDEV-18011 
					voPendingElective.setActiveAlerts(true); //WDEV-18011 
				}
			}
			//----------
			
			patientCell.setReadOnly(true);
		}	
		
		if (voPendingElective.getPasEventIsNotNull() 
		&& voPendingElective.getPasEvent().getConsultantIsNotNull())
		{
			DynamicGridCell patientCell = newRow.getCells().newCell(getColumn(COLCONSULANT), DynamicCellType.LABEL);
			patientCell.setValue(voPendingElective.getPasEvent().getConsultant().getName().toString());
			patientCell.setTooltip(voPendingElective.getPasEvent().getConsultant().getName().toString());
			patientCell.setReadOnly(true);
		}	

		if (voPendingElective.getAllocatedWardIsNotNull())
		{
			DynamicGridCell patientCell = newRow.getCells().newCell(getColumn(COLWARD), DynamicCellType.LABEL);
			patientCell.setValue(voPendingElective.getAllocatedWard().getName().toString());
			patientCell.setTooltip(voPendingElective.getAllocatedWard().getName().toString());
			patientCell.setReadOnly(true);
		}	
		
		//COLSPECIALTY
		if (voPendingElective.getPasEventIsNotNull()
			&& voPendingElective.getPasEvent().getSpecialtyIsNotNull())
		{
			DynamicGridCell patientCell = newRow.getCells().newCell(getColumn(COLSPECIALTY), DynamicCellType.LABEL);
			patientCell.setValue(voPendingElective.getPasEvent().getSpecialty().toString());
			patientCell.setTooltip(voPendingElective.getPasEvent().getSpecialty().toString());
			patientCell.setReadOnly(true);
		}	

		//COLPROCEDURE
		if (voPendingElective.getPasEventIsNotNull()
			&& voPendingElective.getProceduresIsNotNull()
			&& voPendingElective.getProcedures().size() > 0)
		{
			DynamicGridCell patientCell = newRow.getCells().newCell(getColumn(COLPROCEDURE), DynamicCellType.LABEL);
			patientCell.setValue(voPendingElective.getProcedures().get(0).getProcedureName().toString());
			patientCell.setTooltip(voPendingElective.getProcedures().get(0).getProcedureName().toString());
			patientCell.setReadOnly(true);
		}	

		if (voPendingElective.getTCIDateIsNotNull())
		{
			DynamicGridCell patientCell = newRow.getCells().newCell(getColumn(COLTCIDATE), DynamicCellType.LABEL);
			patientCell.setValue(voPendingElective.getTCIDate().toString());
			patientCell.setReadOnly(true);
		}	
		
		
		if (voPendingElective.getManagementIntentionIsNotNull())
		{
			DynamicGridCell patientCell = newRow.getCells().newCell(getColumn(COLMANAGE), DynamicCellType.LABEL);
			patientCell.setValue(voPendingElective.getManagementIntention().toString());
			patientCell.setTooltip(voPendingElective.getManagementIntention().toString());
			patientCell.setReadOnly(true);
		}	
		
		if (voPendingElective.getCommentsIsNotNull())
		{
			DynamicGridCell patientCell = newRow.getCells().newCell(getColumn(COLCOMMENT), DynamicCellType.IMAGEBUTTON);
			patientCell.setReadOnly(false);
			patientCell.setAutoPostBack(true);
			patientCell.setValue(form.getImages().Core.Memo);
			patientCell.setTooltip(voPendingElective.getComments());
		}	
		
		if(voPendingElective.getPasEvent().getPatient().getAssociatedPatientIsNotNull())
			newRow.setBackColor(ConfigFlag.UI.MERGED_COLOUR.getValue());
			
		if (voPendingElective.getPasEvent().getPatient().getDodIsNotNull())
			newRow.setBackColor(ConfigFlag.UI.RIP_COLOUR.getValue());			

		if (voPendingToFind != null 
			&& voPendingToFind.equals(voPendingElective))
			form.dyngrdPatients().setValue(voPendingToFind);

		newRow.setValue(voPendingElective);
	}

	private DynamicGridColumn getColumn(Integer identifier)
	{
		return form.dyngrdPatients().getColumns().getByIdentifier(identifier);
	}


	private void initializeDynamicGrid() 
	{
		form.dyngrdPatients().clear();
		form.dyngrdPatients().setSelectable(true);
		
		DynamicGridColumn surnameColumn = form.dyngrdPatients().getColumns().newColumn("Surname", COLSURNAME);
		surnameColumn.setSortMode(SortMode.AUTOMATIC);
		surnameColumn.setWidth(64);	

		DynamicGridColumn forenameColumn = form.dyngrdPatients().getColumns().newColumn("Forename", COLFORENAME);
		forenameColumn.setSortMode(SortMode.AUTOMATIC);
		forenameColumn.setWidth(64);	
			
		DynamicGridColumn hospnumColumn = form.dyngrdPatients().getColumns().newColumn("Hosp. No.", COLHOSPNUM);
		hospnumColumn.setSortMode(SortMode.AUTOMATIC);
		hospnumColumn.setWidth(62);
			
		DynamicGridColumn ageColumn = form.dyngrdPatients().getColumns().newColumn("Age", COLAGE);
		ageColumn.setSortMode(SortMode.AUTOMATIC);
		ageColumn.setWidth(35);
			
		DynamicGridColumn sexColumn = form.dyngrdPatients().getColumns().newColumn("Sex", COLSEX);
		sexColumn.setSortMode(SortMode.AUTOMATIC);
		sexColumn.setWidth(45);
			
		DynamicGridColumn alertColumn = form.dyngrdPatients().getColumns().newColumn("Alert", COLALERTS);
		alertColumn.setSortMode(SortMode.MANUAL); // WDEV-18011 
		alertColumn.setWidth(40);

		DynamicGridColumn consColumn = form.dyngrdPatients().getColumns().newColumn("Consultant", COLCONSULANT);
		consColumn.setSortMode(SortMode.AUTOMATIC);
		consColumn.setWidth(72);

		DynamicGridColumn wardColumn = form.dyngrdPatients().getColumns().newColumn("Ward", COLWARD);
		wardColumn.setSortMode(SortMode.AUTOMATIC);
		wardColumn.setWidth(62);
		
		DynamicGridColumn specColumn = form.dyngrdPatients().getColumns().newColumn("Specialty", COLSPECIALTY);
		specColumn.setSortMode(SortMode.AUTOMATIC);
		specColumn.setWidth(66);
			
		DynamicGridColumn procColumn = form.dyngrdPatients().getColumns().newColumn("Procedure", COLPROCEDURE);
		procColumn.setSortMode(SortMode.AUTOMATIC);
		procColumn.setWidth(66);
			
		DynamicGridColumn tciDateColumn = form.dyngrdPatients().getColumns().newColumn("TCI Date", COLTCIDATE);
		tciDateColumn.setSortMode(SortMode.AUTOMATIC);
		tciDateColumn.setWidth(65);
			
		DynamicGridColumn manageColumn = form.dyngrdPatients().getColumns().newColumn("Management", COLMANAGE);
		manageColumn.setSortMode(SortMode.AUTOMATIC);
		manageColumn.setWidth(84);
		
		DynamicGridColumn commentsColumn = form.dyngrdPatients().getColumns().newColumn("Comments", COLCOMMENT);
		 
		commentsColumn.setWidth(-1);	

		form.lblTotal().setValue("Total : 0");		
	}
	
	@Override
	protected void onDteTCIValueChanged() throws PresentationLogicException 
	{
		if (form.dteTCI().getValue() != null)
		{
			form.chkTCIOnly().setValue(false);
			form.chkTCIOnly().setVisible(true);
		}
		else
			form.chkTCIOnly().setVisible(false);
	}
}