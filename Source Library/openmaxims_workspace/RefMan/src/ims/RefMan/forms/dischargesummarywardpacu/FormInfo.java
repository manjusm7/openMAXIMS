// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.dischargesummarywardpacu;

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
		return "DischargeSummaryWardPacu";
	}
	public int getWidth()
	{
		return 776;
	}
	public int getHeight()
	{
		return 552;
	}
	public String[] getContextVariables()
	{
		return new String[] { "_cv_Scheduling.TheatreType", "_cv_Scheduling.TheatreService", "_cv_Scheduling.TheatreProcedure", "_cv_Scheduling.TheatreConsultant", "_cv_ChooseAndBook.isCABAppt", "_cv_Scheduling.ApptCancelStatus", "_cv_Scheduling.BookingActivity", "_cv_Scheduling.BookingAppointment", "_cv_Scheduling.BookingService", "_cv_Scheduling.BookingSession", "_cv_Scheduling.TheatreAppointment", "_cv_RefMan.PatientMedication", "_cv_Rotherham.AppointmentToLink", "_cv_RefMan.CatsReferralStatus", "_cv_Scheduling.BookingAppointmentRef" };
	}
	public String getLocalVariablesPrefix()
	{
		return "_lv_RefMan.DischargeSummaryWardPacu.__internal_x_context__" + String.valueOf(getFormId());
	}
	public ims.framework.FormInfo[] getComponentsFormInfo()
	{
		ims.framework.FormInfo[] componentsInfo = new ims.framework.FormInfo[1];
		componentsInfo[0] = new ims.core.forms.authoringinfo.FormInfo(102228);
		return componentsInfo;
	}
	public String getImagePath()
	{
		return "";
	}
}
