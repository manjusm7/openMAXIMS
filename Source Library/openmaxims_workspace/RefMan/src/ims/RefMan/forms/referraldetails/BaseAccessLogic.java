// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.referraldetails;

import java.io.Serializable;
import ims.framework.Context;
import ims.framework.FormName;
import ims.framework.FormAccessLogic;

public class BaseAccessLogic extends FormAccessLogic implements Serializable
{
	private static final long serialVersionUID = 1L;

	public final void setContext(Context context, FormName formName)
	{
		form = new CurrentForm(new GlobalContext(context), new CurrentForms());
		engine = new CurrentEngine(formName);
	}
	public boolean isAccessible()
	{
		if(!form.getGlobalContext().RefMan.getCatsReferralIsNotNull())
			return false;
		if(!form.getGlobalContext().Core.getPatientShortIsNotNull())
			return false;

		return true;
	}
	public boolean isReadOnly()
	{
		return false;
	}

	public CurrentEngine engine;
	public CurrentForm form;

	public final static class CurrentForm implements Serializable
	{
		private static final long serialVersionUID = 1L;

		CurrentForm(GlobalContext globalcontext, CurrentForms forms)
		{
			this.globalcontext = globalcontext;
			this.forms = forms;
		}
		public final GlobalContext getGlobalContext()
		{
			return globalcontext;
		}
		public final CurrentForms getForms()
		{
			return forms;
		}
		private GlobalContext globalcontext;
		private CurrentForms forms;
	}
	public final static class CurrentEngine implements Serializable
	{
		private static final long serialVersionUID = 1L;

		CurrentEngine(FormName formName)
		{
			this.formName = formName;
		}
		public final FormName getFormName()
		{
			return formName;
		}
		private FormName formName;
	}
	public static final class CurrentForms implements Serializable
	{
		private static final long serialVersionUID = 1L;

		protected final class LocalFormName extends FormName
		{
			private static final long serialVersionUID = 1L;
		
			protected LocalFormName(int value)
			{
				super(value);
			}
		}

		private CurrentForms()
		{
			OCRR = new OCRRForms();
			RefMan = new RefManForms();
			Core = new CoreForms();
			ICP = new ICPForms();
			Pathways = new PathwaysForms();
		}
		public final class OCRRForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private OCRRForms()
			{
				SelectAndOrderDialog = new LocalFormName(116131);
				MyOrder = new LocalFormName(116111);
			}
			public final FormName SelectAndOrderDialog;
			public final FormName MyOrder;
		}
		public final class RefManForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private RefManForms()
			{
				RejectionReasondialog = new LocalFormName(134102);
				ChangeServiceDialog = new LocalFormName(134122);
				BookAppointment = new LocalFormName(134123);
				SecondOpinionDialog = new LocalFormName(134127);
				ReferralReviewDetails = new LocalFormName(134133);
				PrinterSelectionDialog = new LocalFormName(134145);
				BookTheatreSlot = new LocalFormName(134208);
			}
			public final FormName RejectionReasondialog;
			public final FormName ChangeServiceDialog;
			public final FormName BookAppointment;
			public final FormName SecondOpinionDialog;
			public final FormName ReferralReviewDetails;
			public final FormName PrinterSelectionDialog;
			public final FormName BookTheatreSlot;
		}
		public final class CoreForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private CoreForms()
			{
				ReferralDetailsNoteDialog = new LocalFormName(134130);
				UploadDocumentDialog = new LocalFormName(102268);
			}
			public final FormName ReferralDetailsNoteDialog;
			public final FormName UploadDocumentDialog;
		}
		public final class ICPForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private ICPForms()
			{
				ICPPatientSelect = new LocalFormName(118117);
			}
			public final FormName ICPPatientSelect;
		}
		public final class PathwaysForms implements Serializable
		{
			private static final long serialVersionUID = 1L;

			private PathwaysForms()
			{
				AdminEvent = new LocalFormName(132123);
			}
			public final FormName AdminEvent;
		}

		public OCRRForms OCRR;
		public RefManForms RefMan;
		public CoreForms Core;
		public ICPForms ICP;
		public PathwaysForms Pathways;
	}
}
