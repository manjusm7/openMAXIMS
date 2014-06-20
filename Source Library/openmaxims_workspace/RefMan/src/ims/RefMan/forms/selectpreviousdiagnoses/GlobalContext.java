// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.selectpreviousdiagnoses;

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

		public boolean getSelectedPatientDiagnosisListVoCollectionIsNotNull()
		{
			return !cx_RefManSelectedPatientDiagnosisListVoCollection.getValueIsNull(context);
		}
		public ims.core.vo.PatientDiagnosisListVoCollection getSelectedPatientDiagnosisListVoCollection()
		{
			return (ims.core.vo.PatientDiagnosisListVoCollection)cx_RefManSelectedPatientDiagnosisListVoCollection.getValue(context);
		}
		public void setSelectedPatientDiagnosisListVoCollection(ims.core.vo.PatientDiagnosisListVoCollection value)
		{
			cx_RefManSelectedPatientDiagnosisListVoCollection.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManSelectedPatientDiagnosisListVoCollection = new ims.framework.ContextVariable("RefMan.SelectedPatientDiagnosisListVoCollection", "_cv_RefMan.SelectedPatientDiagnosisListVoCollection");

		private ims.framework.Context context;
	}

	public RefManContext RefMan;
}
