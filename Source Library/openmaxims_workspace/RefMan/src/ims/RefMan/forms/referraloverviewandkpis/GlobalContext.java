// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.referraloverviewandkpis;

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
		public boolean getCatsReferralStatusHistoryIsNotNull()
		{
			return !cx_RefManCatsReferralStatusHistory.getValueIsNull(context);
		}
		public ims.RefMan.vo.CatsReferralStatusVoCollection getCatsReferralStatusHistory()
		{
			return (ims.RefMan.vo.CatsReferralStatusVoCollection)cx_RefManCatsReferralStatusHistory.getValue(context);
		}
		public void setCatsReferralStatusHistory(ims.RefMan.vo.CatsReferralStatusVoCollection value)
		{
			cx_RefManCatsReferralStatusHistory.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManCatsReferralStatusHistory = new ims.framework.ContextVariable("RefMan.CatsReferralStatusHistory", "_cv_RefMan.CatsReferralStatusHistory");

		private ims.framework.Context context;
	}

	public RefManContext RefMan;
}
