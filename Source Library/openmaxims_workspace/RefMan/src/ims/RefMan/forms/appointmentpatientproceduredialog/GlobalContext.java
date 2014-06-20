// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.appointmentpatientproceduredialog;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		RefMan = new RefManContext(context);
	}
	public final class RefManContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private RefManContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getAppointmentPatientProcedureIsNotNull()
		{
			return !cx_RefManAppointmentPatientProcedure.getValueIsNull(context);
		}
		public ims.RefMan.vo.PatientProcedureApptDetailVo getAppointmentPatientProcedure()
		{
			return (ims.RefMan.vo.PatientProcedureApptDetailVo)cx_RefManAppointmentPatientProcedure.getValue(context);
		}
		public void setAppointmentPatientProcedure(ims.RefMan.vo.PatientProcedureApptDetailVo value)
		{
			cx_RefManAppointmentPatientProcedure.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManAppointmentPatientProcedure = new ims.framework.ContextVariable("RefMan.AppointmentPatientProcedure", "_cv_RefMan.AppointmentPatientProcedure");

		private ims.framework.Context context;
	}

	public RefManContext RefMan;
}
