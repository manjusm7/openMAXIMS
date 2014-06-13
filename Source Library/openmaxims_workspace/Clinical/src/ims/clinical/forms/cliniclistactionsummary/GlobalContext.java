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

package ims.clinical.forms.cliniclistactionsummary;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		ICP = new ICPContext(context);
		CareUk = new CareUkContext(context);
		Scheduling = new SchedulingContext(context);
		Clinical = new ClinicalContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}
		public void setPatientShort(ims.core.vo.PatientShort value)
		{
			cx_CorePatientShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");

		private ims.framework.Context context;
	}
	public final class ICPContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ICPContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPatientICPRecordIsNotNull()
		{
			return !cx_ICPPatientICPRecord.getValueIsNull(context);
		}
		public ims.icps.instantiation.vo.PatientICPRefVo getPatientICPRecord()
		{
			return (ims.icps.instantiation.vo.PatientICPRefVo)cx_ICPPatientICPRecord.getValue(context);
		}
		public void setPatientICPRecord(ims.icps.instantiation.vo.PatientICPRefVo value)
		{
			cx_ICPPatientICPRecord.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ICPPatientICPRecord = new ims.framework.ContextVariable("ICP.PatientICPRecord", "_cv_ICP.PatientICPRecord");

		private ims.framework.Context context;
	}
	public final class CareUkContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CareUkContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPatientElectiveListRefIsNotNull()
		{
			return !cx_CareUkPatientElectiveListRef.getValueIsNull(context);
		}
		public ims.careuk.vo.PatientElectiveListRefVo getPatientElectiveListRef()
		{
			return (ims.careuk.vo.PatientElectiveListRefVo)cx_CareUkPatientElectiveListRef.getValue(context);
		}
		public void setPatientElectiveListRef(ims.careuk.vo.PatientElectiveListRefVo value)
		{
			cx_CareUkPatientElectiveListRef.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CareUkPatientElectiveListRef = new ims.framework.ContextVariable("CareUk.PatientElectiveListRef", "_cv_CareUk.PatientElectiveListRef");
		public boolean getCatsReferralIsNotNull()
		{
			return !cx_CareUkCatsReferral.getValueIsNull(context);
		}
		public ims.careuk.vo.CatsReferralRefVo getCatsReferral()
		{
			return (ims.careuk.vo.CatsReferralRefVo)cx_CareUkCatsReferral.getValue(context);
		}
		public void setCatsReferral(ims.careuk.vo.CatsReferralRefVo value)
		{
			cx_CareUkCatsReferral.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CareUkCatsReferral = new ims.framework.ContextVariable("CareUk.CatsReferral", "_cvp_CareUk.CatsReferral");

		private ims.framework.Context context;
	}
	public final class SchedulingContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private SchedulingContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getBookingAppointmentRefIsNotNull()
		{
			return !cx_SchedulingBookingAppointmentRef.getValueIsNull(context);
		}
		public ims.scheduling.vo.Booking_AppointmentRefVo getBookingAppointmentRef()
		{
			return (ims.scheduling.vo.Booking_AppointmentRefVo)cx_SchedulingBookingAppointmentRef.getValue(context);
		}
		public void setBookingAppointmentRef(ims.scheduling.vo.Booking_AppointmentRefVo value)
		{
			cx_SchedulingBookingAppointmentRef.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_SchedulingBookingAppointmentRef = new ims.framework.ContextVariable("Scheduling.BookingAppointmentRef", "_cv_Scheduling.BookingAppointmentRef");

		private ims.framework.Context context;
	}
	public final class ClinicalContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getClinicListActionSummarySearchCriteriaIsNotNull()
		{
			return !cx_ClinicalClinicListActionSummarySearchCriteria.getValueIsNull(context);
		}
		public ims.core.vo.IPandOPSearchCriteriaVo getClinicListActionSummarySearchCriteria()
		{
			return (ims.core.vo.IPandOPSearchCriteriaVo)cx_ClinicalClinicListActionSummarySearchCriteria.getValue(context);
		}
		public void setClinicListActionSummarySearchCriteria(ims.core.vo.IPandOPSearchCriteriaVo value)
		{
			cx_ClinicalClinicListActionSummarySearchCriteria.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalClinicListActionSummarySearchCriteria = new ims.framework.ContextVariable("Clinical.ClinicListActionSummarySearchCriteria", "_cvp_Clinical.ClinicListActionSummarySearchCriteria");

		private ims.framework.Context context;
	}
	public boolean getUKSHOutPatientWardViewSearchCriteriaIsNotNull()
	{
		return !cx_UKSHOutPatientWardViewSearchCriteria.getValueIsNull(context);
	}
	public ims.core.vo.IPandOPSearchCriteriaVo getUKSHOutPatientWardViewSearchCriteria()
	{
		return (ims.core.vo.IPandOPSearchCriteriaVo)cx_UKSHOutPatientWardViewSearchCriteria.getValue(context);
	}
		public void setUKSHOutPatientWardViewSearchCriteria(ims.core.vo.IPandOPSearchCriteriaVo value)
		{
		cx_UKSHOutPatientWardViewSearchCriteria.setValue(context, value);
		}

	private ims.framework.ContextVariable cx_UKSHOutPatientWardViewSearchCriteria = new ims.framework.ContextVariable("UKSHOutPatientWardViewSearchCriteria", "_cvp_UKSHOutPatientWardViewSearchCriteria");

	public CoreContext Core;
	public ICPContext ICP;
	public CareUkContext CareUk;
	public SchedulingContext Scheduling;
	public ClinicalContext Clinical;
}