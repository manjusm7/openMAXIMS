// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.patientspecialtyassessments;

public final class FormInfo extends ims.framework.FormInfo
{
	private static final long serialVersionUID = 1L;
	public FormInfo(Integer formId)
	{
		super(formId);
	}
	public String getNamespaceName()
	{
		return "RefMan";
	}
	public String getFormName()
	{
		return "PatientSpecialtyAssessments";
	}
	public int getWidth()
	{
		return 808;
	}
	public int getHeight()
	{
		return 656;
	}
	public String[] getContextVariables()
	{
		return new String[] { "_cv_RefMan.IsComponentInEditMode", "_cv_Core.SelectedGraphicAssessmentLite", "_cv_Assessment.AssessmentsForSpecialtyCollection", "_cv_Core.SelectedUserAssessmentLite", "_cv_Assessment.GraphicAssessmentsForSpecialtyCollection" };
	}
	public String getLocalVariablesPrefix()
	{
		return "_lv_RefMan.PatientSpecialtyAssessments.__internal_x_context__" + String.valueOf(getFormId());
	}
	public ims.framework.FormInfo[] getComponentsFormInfo()
	{
		ims.framework.FormInfo[] componentsInfo = new ims.framework.FormInfo[2];
		componentsInfo[0] = new ims.assessment.forms.structuralassessment.FormInfo(127109);
		componentsInfo[1] = new ims.assessment.forms.graphicalassessment.FormInfo(127114);
		return componentsInfo;
	}
	public String getImagePath()
	{
		return "";
	}
}
