// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.tltsummarynotescomponent;

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
		return "TLTSummaryNotesComponent";
	}
	public int getWidth()
	{
		return 800;
	}
	public int getHeight()
	{
		return 488;
	}
	public String[] getContextVariables()
	{
		return new String[] { "_cv_RefMan.IsComponentInEditMode" };
	}
	public String getLocalVariablesPrefix()
	{
		return "_lv_RefMan.TLTSummaryNotesComponent.__internal_x_context__" + String.valueOf(getFormId());
	}
	public ims.framework.FormInfo[] getComponentsFormInfo()
	{
		ims.framework.FormInfo[] componentsInfo = new ims.framework.FormInfo[0];
		return componentsInfo;
	}
	public String getImagePath()
	{
		return "";
	}
}
