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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.forms.clinicalnotedrawing;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		COE = new COEContext(context);
		Core = new CoreContext(context);
		Nursing = new NursingContext(context);
		Clinical = new ClinicalContext(context);
		ProtoTemp = new ProtoTempContext(context);
		Assessment = new AssessmentContext(context);
	}
	public final class COEContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private COEContext(ims.framework.Context context)
		{
			this.context = context;

			SkinBodyChart = new SkinBodyChartContext(context);
		}
		public final class SkinBodyChartContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private SkinBodyChartContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getSelectedSkinAssessmentIsNotNull()
			{
				return !cx_COESkinBodyChartSelectedSkinAssessment.getValueIsNull(context);
			}
			public ims.nursing.vo.SkinAssessment getSelectedSkinAssessment()
			{
				return (ims.nursing.vo.SkinAssessment)cx_COESkinBodyChartSelectedSkinAssessment.getValue(context);
			}
		public void setSelectedSkinAssessment(ims.nursing.vo.SkinAssessment value)
		{
				cx_COESkinBodyChartSelectedSkinAssessment.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_COESkinBodyChartSelectedSkinAssessment = new ims.framework.ContextVariable("COE.SkinBodyChart.SelectedSkinAssessment", "_cv_COE.SkinBodyChart.SelectedSkinAssessment");
			public boolean getSkinAssessmentVOIsNotNull()
			{
				return !cx_COESkinBodyChartSkinAssessmentVO.getValueIsNull(context);
			}
			public ims.nursing.vo.SkinAssessment getSkinAssessmentVO()
			{
				return (ims.nursing.vo.SkinAssessment)cx_COESkinBodyChartSkinAssessmentVO.getValue(context);
			}
		public void setSkinAssessmentVO(ims.nursing.vo.SkinAssessment value)
		{
				cx_COESkinBodyChartSkinAssessmentVO.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_COESkinBodyChartSkinAssessmentVO = new ims.framework.ContextVariable("COE.SkinBodyChart.SkinAssessmentVO", "_cv_COE.SkinBodyChart.SkinAssessmentVO");
			public boolean getAreasIsNotNull()
			{
				return !cx_COESkinBodyChartAreas.getValueIsNull(context);
			}
			public ims.framework.controls.DrawingControlAreaCollection getAreas()
			{
				return (ims.framework.controls.DrawingControlAreaCollection)cx_COESkinBodyChartAreas.getValue(context);
			}
		public void setAreas(ims.framework.controls.DrawingControlAreaCollection value)
		{
				cx_COESkinBodyChartAreas.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_COESkinBodyChartAreas = new ims.framework.ContextVariable("COE.SkinBodyChart.Areas", "_cv_COE.SkinBodyChart.Areas");
			public boolean getFindingsVOIsNotNull()
			{
				return !cx_COESkinBodyChartFindingsVO.getValueIsNull(context);
			}
			public ims.nursing.vo.SkinAssessmentFindings getFindingsVO()
			{
				return (ims.nursing.vo.SkinAssessmentFindings)cx_COESkinBodyChartFindingsVO.getValue(context);
			}
		public void setFindingsVO(ims.nursing.vo.SkinAssessmentFindings value)
		{
				cx_COESkinBodyChartFindingsVO.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_COESkinBodyChartFindingsVO = new ims.framework.ContextVariable("COE.SkinBodyChart.FindingsVO", "_cv_COE.SkinBodyChart.FindingsVO");
			public boolean getGroupsIsNotNull()
			{
				return !cx_COESkinBodyChartGroups.getValueIsNull(context);
			}
			public ims.framework.controls.DrawingControlGroupCollection getGroups()
			{
				return (ims.framework.controls.DrawingControlGroupCollection)cx_COESkinBodyChartGroups.getValue(context);
			}
		public void setGroups(ims.framework.controls.DrawingControlGroupCollection value)
		{
				cx_COESkinBodyChartGroups.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_COESkinBodyChartGroups = new ims.framework.ContextVariable("COE.SkinBodyChart.Groups", "_cv_COE.SkinBodyChart.Groups");
			public boolean getReadOnlyAssessmentIsNotNull()
			{
				return !cx_COESkinBodyChartReadOnlyAssessment.getValueIsNull(context);
			}
			public ims.nursing.vo.SkinAssessment getReadOnlyAssessment()
			{
				return (ims.nursing.vo.SkinAssessment)cx_COESkinBodyChartReadOnlyAssessment.getValue(context);
			}
		public void setReadOnlyAssessment(ims.nursing.vo.SkinAssessment value)
		{
				cx_COESkinBodyChartReadOnlyAssessment.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_COESkinBodyChartReadOnlyAssessment = new ims.framework.ContextVariable("COE.SkinBodyChart.ReadOnlyAssessment", "_cv_COE.SkinBodyChart.ReadOnlyAssessment");
			private ims.framework.Context context;
		}


		public SkinBodyChartContext SkinBodyChart;
		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getClinicalNotingModeIsNotNull()
		{
			return !cx_CoreClinicalNotingMode.getValueIsNull(context);
		}
		public ims.core.vo.lookups.ClinicalNotingMode getClinicalNotingMode()
		{
			return (ims.core.vo.lookups.ClinicalNotingMode)cx_CoreClinicalNotingMode.getValue(context);
		}
		public void setClinicalNotingMode(ims.core.vo.lookups.ClinicalNotingMode value)
		{
			cx_CoreClinicalNotingMode.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreClinicalNotingMode = new ims.framework.ContextVariable("Core.ClinicalNotingMode", "_cv_Core.ClinicalNotingMode");
		public boolean getRecordingHCPIsNotNull()
		{
			return !cx_CoreRecordingHCP.getValueIsNull(context);
		}
		public ims.core.vo.HcpLiteVo getRecordingHCP()
		{
			return (ims.core.vo.HcpLiteVo)cx_CoreRecordingHCP.getValue(context);
		}
		public void setRecordingHCP(ims.core.vo.HcpLiteVo value)
		{
			cx_CoreRecordingHCP.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreRecordingHCP = new ims.framework.ContextVariable("Core.RecordingHCP", "_cvp_Core.RecordingHCP");
		public boolean getClinicalNotesShortIsNotNull()
		{
			return !cx_CoreClinicalNotesShort.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalNotesShortVo getClinicalNotesShort()
		{
			return (ims.core.vo.ClinicalNotesShortVo)cx_CoreClinicalNotesShort.getValue(context);
		}
		public void setClinicalNotesShort(ims.core.vo.ClinicalNotesShortVo value)
		{
			cx_CoreClinicalNotesShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreClinicalNotesShort = new ims.framework.ContextVariable("Core.ClinicalNotesShort", "_cv_Core.ClinicalNotesShort");
		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");
		public boolean getUserDefinedObjectSelectedIsNotNull()
		{
			return !cx_CoreUserDefinedObjectSelected.getValueIsNull(context);
		}
		public ims.assessment.vo.UserDefinedObjectVo getUserDefinedObjectSelected()
		{
			return (ims.assessment.vo.UserDefinedObjectVo)cx_CoreUserDefinedObjectSelected.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreUserDefinedObjectSelected = new ims.framework.ContextVariable("Core.UserDefinedObjectSelected", "_cv_Core.UserDefinedObjectSelected");
		public boolean getCurrentCareContextIsNotNull()
		{
			return !cx_CoreCurrentCareContext.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVo getCurrentCareContext()
		{
			return (ims.core.vo.CareContextShortVo)cx_CoreCurrentCareContext.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");
		public boolean getEpisodeofCareShortIsNotNull()
		{
			return !cx_CoreEpisodeofCareShort.getValueIsNull(context);
		}
		public ims.core.vo.EpisodeofCareShortVo getEpisodeofCareShort()
		{
			return (ims.core.vo.EpisodeofCareShortVo)cx_CoreEpisodeofCareShort.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreEpisodeofCareShort = new ims.framework.ContextVariable("Core.EpisodeofCareShort", "_cvp_Core.EpisodeofCareShort");

		private ims.framework.Context context;
	}
	public final class NursingContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private NursingContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getAssessmentComponentIsNotNull()
		{
			return !cx_NursingAssessmentComponent.getValueIsNull(context);
		}
		public ims.nursing.vo.AssessmentComponent getAssessmentComponent()
		{
			return (ims.nursing.vo.AssessmentComponent)cx_NursingAssessmentComponent.getValue(context);
		}

		private ims.framework.ContextVariable cx_NursingAssessmentComponent = new ims.framework.ContextVariable("Nursing.AssessmentComponent", "_cv_Nursing.AssessmentComponent");
		public boolean getAssessmentHeaderInfoIsNotNull()
		{
			return !cx_NursingAssessmentHeaderInfo.getValueIsNull(context);
		}
		public ims.nursing.vo.AssessmentHeaderInfo getAssessmentHeaderInfo()
		{
			return (ims.nursing.vo.AssessmentHeaderInfo)cx_NursingAssessmentHeaderInfo.getValue(context);
		}
		public void setAssessmentHeaderInfo(ims.nursing.vo.AssessmentHeaderInfo value)
		{
			cx_NursingAssessmentHeaderInfo.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_NursingAssessmentHeaderInfo = new ims.framework.ContextVariable("Nursing.AssessmentHeaderInfo", "_cv_Nursing.AssessmentHeaderInfo");

		private ims.framework.Context context;
	}
	public final class ClinicalContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalContext(ims.framework.Context context)
		{
			this.context = context;

			PatientAssessment = new PatientAssessmentContext(context);
		}
		public final class PatientAssessmentContext implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private PatientAssessmentContext(ims.framework.Context context)
			{
				this.context = context;
			}
			public boolean getEditComponentIsNotNull()
			{
				return !cx_ClinicalPatientAssessmentEditComponent.getValueIsNull(context);
			}
			public Boolean getEditComponent()
			{
				return (Boolean)cx_ClinicalPatientAssessmentEditComponent.getValue(context);
			}
		public void setEditComponent(Boolean value)
		{
				cx_ClinicalPatientAssessmentEditComponent.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_ClinicalPatientAssessmentEditComponent = new ims.framework.ContextVariable("Clinical.PatientAssessment.EditComponent", "_cv_Clinical.PatientAssessment.EditComponent");
			public boolean getEditedComponentIsNotNull()
			{
				return !cx_ClinicalPatientAssessmentEditedComponent.getValueIsNull(context);
			}
			public ims.assessment.configuration.vo.UserDefinedObjectComponentRefVo getEditedComponent()
			{
				return (ims.assessment.configuration.vo.UserDefinedObjectComponentRefVo)cx_ClinicalPatientAssessmentEditedComponent.getValue(context);
			}
		public void setEditedComponent(ims.assessment.configuration.vo.UserDefinedObjectComponentRefVo value)
		{
				cx_ClinicalPatientAssessmentEditedComponent.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_ClinicalPatientAssessmentEditedComponent = new ims.framework.ContextVariable("Clinical.PatientAssessment.EditedComponent", "_cv_Clinical.PatientAssessment.EditedComponent");
			public boolean getSelectedAssessmentIsNotNull()
			{
				return !cx_ClinicalPatientAssessmentSelectedAssessment.getValueIsNull(context);
			}
			public ims.assessment.instantiation.vo.PatientAssessmentRefVo getSelectedAssessment()
			{
				return (ims.assessment.instantiation.vo.PatientAssessmentRefVo)cx_ClinicalPatientAssessmentSelectedAssessment.getValue(context);
			}
		public void setSelectedAssessment(ims.assessment.instantiation.vo.PatientAssessmentRefVo value)
		{
				cx_ClinicalPatientAssessmentSelectedAssessment.setValue(context, value);
		}

			private ims.framework.ContextVariable cx_ClinicalPatientAssessmentSelectedAssessment = new ims.framework.ContextVariable("Clinical.PatientAssessment.SelectedAssessment", "_cv_Clinical.PatientAssessment.SelectedAssessment");
			private ims.framework.Context context;
		}

		public boolean getUnsavedSOAPINformationIsNotNull()
		{
			return !cx_ClinicalUnsavedSOAPINformation.getValueIsNull(context);
		}
		public ims.core.vo.SOAPVo getUnsavedSOAPINformation()
		{
			return (ims.core.vo.SOAPVo)cx_ClinicalUnsavedSOAPINformation.getValue(context);
		}
		public void setUnsavedSOAPINformation(ims.core.vo.SOAPVo value)
		{
			cx_ClinicalUnsavedSOAPINformation.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalUnsavedSOAPINformation = new ims.framework.ContextVariable("Clinical.UnsavedSOAPINformation", "_cv_Clinical.UnsavedSOAPINformation");
		public boolean getReturnToFormCDIDescriptionIsNotNull()
		{
			return !cx_ClinicalReturnToFormCDIDescription.getValueIsNull(context);
		}
		public String getReturnToFormCDIDescription()
		{
			return (String)cx_ClinicalReturnToFormCDIDescription.getValue(context);
		}
		public void setReturnToFormCDIDescription(String value)
		{
			cx_ClinicalReturnToFormCDIDescription.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalReturnToFormCDIDescription = new ims.framework.ContextVariable("Clinical.ReturnToFormCDIDescription", "_cv_Clinical.ReturnToFormCDIDescription");
		public boolean getReturnToFormModeIsNotNull()
		{
			return !cx_ClinicalReturnToFormMode.getValueIsNull(context);
		}
		public ims.framework.enumerations.FormMode getReturnToFormMode()
		{
			return (ims.framework.enumerations.FormMode)cx_ClinicalReturnToFormMode.getValue(context);
		}
		public void setReturnToFormMode(ims.framework.enumerations.FormMode value)
		{
			cx_ClinicalReturnToFormMode.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalReturnToFormMode = new ims.framework.ContextVariable("Clinical.ReturnToFormMode", "_cv_Clinical.ReturnToFormMode");
		public boolean getCurrentClinicalNoteIsNotNull()
		{
			return !cx_ClinicalCurrentClinicalNote.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalNotesVo getCurrentClinicalNote()
		{
			return (ims.core.vo.ClinicalNotesVo)cx_ClinicalCurrentClinicalNote.getValue(context);
		}
		public void setCurrentClinicalNote(ims.core.vo.ClinicalNotesVo value)
		{
			cx_ClinicalCurrentClinicalNote.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalCurrentClinicalNote = new ims.framework.ContextVariable("Clinical.CurrentClinicalNote", "_cvp_Clinical.CurrentClinicalNote");
		public boolean getReturnToFormCDITitleIsNotNull()
		{
			return !cx_ClinicalReturnToFormCDITitle.getValueIsNull(context);
		}
		public String getReturnToFormCDITitle()
		{
			return (String)cx_ClinicalReturnToFormCDITitle.getValue(context);
		}
		public void setReturnToFormCDITitle(String value)
		{
			cx_ClinicalReturnToFormCDITitle.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalReturnToFormCDITitle = new ims.framework.ContextVariable("Clinical.ReturnToFormCDITitle", "_cv_Clinical.ReturnToFormCDITitle");
		public boolean getReturnToFormNameIsNotNull()
		{
			return !cx_ClinicalReturnToFormName.getValueIsNull(context);
		}
		public ims.framework.FormName getReturnToFormName()
		{
			return (ims.framework.FormName)cx_ClinicalReturnToFormName.getValue(context);
		}
		public void setReturnToFormName(ims.framework.FormName value)
		{
			cx_ClinicalReturnToFormName.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalReturnToFormName = new ims.framework.ContextVariable("Clinical.ReturnToFormName", "_cv_Clinical.ReturnToFormName");
		public boolean getDialogFormNameIsNotNull()
		{
			return !cx_ClinicalDialogFormName.getValueIsNull(context);
		}
		public ims.framework.FormName getDialogFormName()
		{
			return (ims.framework.FormName)cx_ClinicalDialogFormName.getValue(context);
		}
		public void setDialogFormName(ims.framework.FormName value)
		{
			cx_ClinicalDialogFormName.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalDialogFormName = new ims.framework.ContextVariable("Clinical.DialogFormName", "_cv_Clinical.DialogFormName");
		public boolean getReturnToFormCDISubjectiveProblemIsNotNull()
		{
			return !cx_ClinicalReturnToFormCDISubjectiveProblem.getValueIsNull(context);
		}
		public Boolean getReturnToFormCDISubjectiveProblem()
		{
			return (Boolean)cx_ClinicalReturnToFormCDISubjectiveProblem.getValue(context);
		}
		public void setReturnToFormCDISubjectiveProblem(Boolean value)
		{
			cx_ClinicalReturnToFormCDISubjectiveProblem.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalReturnToFormCDISubjectiveProblem = new ims.framework.ContextVariable("Clinical.ReturnToFormCDISubjectiveProblem", "_cv_Clinical.ReturnToFormCDISubjectiveProblem");

		public PatientAssessmentContext PatientAssessment;
		private ims.framework.Context context;
	}
	public final class ProtoTempContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ProtoTempContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getCliniacalNoteDrawingTextIsNotNull()
		{
			return !cx_ProtoTempCliniacalNoteDrawingText.getValueIsNull(context);
		}
		public String getCliniacalNoteDrawingText()
		{
			return (String)cx_ProtoTempCliniacalNoteDrawingText.getValue(context);
		}
		public void setCliniacalNoteDrawingText(String value)
		{
			cx_ProtoTempCliniacalNoteDrawingText.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ProtoTempCliniacalNoteDrawingText = new ims.framework.ContextVariable("ProtoTemp.CliniacalNoteDrawingText", "_cv_ProtoTemp.CliniacalNoteDrawingText");
		public boolean getClinicalNoteDrawingReturnFormNameIsNotNull()
		{
			return !cx_ProtoTempClinicalNoteDrawingReturnFormName.getValueIsNull(context);
		}
		public ims.framework.FormName getClinicalNoteDrawingReturnFormName()
		{
			return (ims.framework.FormName)cx_ProtoTempClinicalNoteDrawingReturnFormName.getValue(context);
		}
		public void setClinicalNoteDrawingReturnFormName(ims.framework.FormName value)
		{
			cx_ProtoTempClinicalNoteDrawingReturnFormName.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ProtoTempClinicalNoteDrawingReturnFormName = new ims.framework.ContextVariable("ProtoTemp.ClinicalNoteDrawingReturnFormName", "_cv_ProtoTemp.ClinicalNoteDrawingReturnFormName");

		private ims.framework.Context context;
	}
	public final class AssessmentContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private AssessmentContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPatientUserDefinedObjectIsNotNull()
		{
			return !cx_AssessmentPatientUserDefinedObject.getValueIsNull(context);
		}
		public ims.assessment.vo.PatientUserDefinedObjectVo getPatientUserDefinedObject()
		{
			return (ims.assessment.vo.PatientUserDefinedObjectVo)cx_AssessmentPatientUserDefinedObject.getValue(context);
		}
		public void setPatientUserDefinedObject(ims.assessment.vo.PatientUserDefinedObjectVo value)
		{
			cx_AssessmentPatientUserDefinedObject.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AssessmentPatientUserDefinedObject = new ims.framework.ContextVariable("Assessment.PatientUserDefinedObject", "_cv_Assessment.PatientUserDefinedObject");

		private ims.framework.Context context;
	}

	public COEContext COE;
	public CoreContext Core;
	public NursingContext Nursing;
	public ClinicalContext Clinical;
	public ProtoTempContext ProtoTemp;
	public AssessmentContext Assessment;
}