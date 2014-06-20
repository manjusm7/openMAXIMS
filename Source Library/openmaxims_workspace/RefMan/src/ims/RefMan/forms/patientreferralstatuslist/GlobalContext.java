// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.patientreferralstatuslist;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
		RefMan = new RefManContext(context);
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
		public boolean getCurrentCareContextIsNotNull()
		{
			return !cx_CoreCurrentCareContext.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVo getCurrentCareContext()
		{
			return (ims.core.vo.CareContextShortVo)cx_CoreCurrentCareContext.getValue(context);
		}
		public void setCurrentCareContext(ims.core.vo.CareContextShortVo value)
		{
			cx_CoreCurrentCareContext.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");

		private ims.framework.Context context;
	}
	public final class RefManContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private RefManContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getCatsReferralIsNotNull()
		{
			return !cx_RefManCatsReferral.getValueIsNull(context);
		}
		public ims.RefMan.vo.CatsReferralRefVo getCatsReferral()
		{
			return (ims.RefMan.vo.CatsReferralRefVo)cx_RefManCatsReferral.getValue(context);
		}
		public void setCatsReferral(ims.RefMan.vo.CatsReferralRefVo value)
		{
			cx_RefManCatsReferral.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManCatsReferral = new ims.framework.ContextVariable("RefMan.CatsReferral", "_cvp_RefMan.CatsReferral");
		public boolean getIsConsultationStartedIsNotNull()
		{
			return !cx_RefManIsConsultationStarted.getValueIsNull(context);
		}
		public Boolean getIsConsultationStarted()
		{
			return (Boolean)cx_RefManIsConsultationStarted.getValue(context);
		}
		public void setIsConsultationStarted(Boolean value)
		{
			cx_RefManIsConsultationStarted.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManIsConsultationStarted = new ims.framework.ContextVariable("RefMan.IsConsultationStarted", "_cv_RefMan.IsConsultationStarted");
		public boolean getIsClinicalContactStartedIsNotNull()
		{
			return !cx_RefManIsClinicalContactStarted.getValueIsNull(context);
		}
		public Boolean getIsClinicalContactStarted()
		{
			return (Boolean)cx_RefManIsClinicalContactStarted.getValue(context);
		}
		public void setIsClinicalContactStarted(Boolean value)
		{
			cx_RefManIsClinicalContactStarted.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManIsClinicalContactStarted = new ims.framework.ContextVariable("RefMan.IsClinicalContactStarted", "_cv_RefMan.IsClinicalContactStarted");
		public boolean getIsProviderCancellationIsNotNull()
		{
			return !cx_RefManIsProviderCancellation.getValueIsNull(context);
		}
		public Boolean getIsProviderCancellation()
		{
			return (Boolean)cx_RefManIsProviderCancellation.getValue(context);
		}
		public void setIsProviderCancellation(Boolean value)
		{
			cx_RefManIsProviderCancellation.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManIsProviderCancellation = new ims.framework.ContextVariable("RefMan.IsProviderCancellation", "_cvp_RefMan.IsProviderCancellation");
		public boolean getSpecimenWorkListItemForReportsIsNotNull()
		{
			return !cx_RefManSpecimenWorkListItemForReports.getValueIsNull(context);
		}
		public ims.ocrr.vo.SpecimenWorkListItemVo getSpecimenWorkListItemForReports()
		{
			return (ims.ocrr.vo.SpecimenWorkListItemVo)cx_RefManSpecimenWorkListItemForReports.getValue(context);
		}
		public void setSpecimenWorkListItemForReports(ims.ocrr.vo.SpecimenWorkListItemVo value)
		{
			cx_RefManSpecimenWorkListItemForReports.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManSpecimenWorkListItemForReports = new ims.framework.ContextVariable("RefMan.SpecimenWorkListItemForReports", "_cv_RefMan.SpecimenWorkListItemForReports");
		public boolean getReferralContractTypeForPatientIsNotNull()
		{
			return !cx_RefManReferralContractTypeForPatient.getValueIsNull(context);
		}
		public ims.core.vo.lookups.ReferralManagementContractType getReferralContractTypeForPatient()
		{
			return (ims.core.vo.lookups.ReferralManagementContractType)cx_RefManReferralContractTypeForPatient.getValue(context);
		}
		public void setReferralContractTypeForPatient(ims.core.vo.lookups.ReferralManagementContractType value)
		{
			cx_RefManReferralContractTypeForPatient.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManReferralContractTypeForPatient = new ims.framework.ContextVariable("RefMan.ReferralContractTypeForPatient", "_cvp_RefMan.ReferralContractTypeForPatient");
		public boolean getPatientElectiveListRefIsNotNull()
		{
			return !cx_RefManPatientElectiveListRef.getValueIsNull(context);
		}
		public ims.RefMan.vo.PatientElectiveListRefVo getPatientElectiveListRef()
		{
			return (ims.RefMan.vo.PatientElectiveListRefVo)cx_RefManPatientElectiveListRef.getValue(context);
		}
		public void setPatientElectiveListRef(ims.RefMan.vo.PatientElectiveListRefVo value)
		{
			cx_RefManPatientElectiveListRef.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManPatientElectiveListRef = new ims.framework.ContextVariable("RefMan.PatientElectiveListRef", "_cv_RefMan.PatientElectiveListRef");

		private ims.framework.Context context;
	}

	public CoreContext Core;
	public RefManContext RefMan;
}
