// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.presentation;

import ims.framework.*;
import ims.framework.controls.*;
import ims.framework.enumerations.*;
import ims.framework.utils.RuntimeAnchoring;

public class GenForm extends FormBridge
{
	private static final long serialVersionUID = 1L;

	public boolean canProvideData(IReportSeed[] reportSeeds)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields()).canProvideData();
	}
	public boolean hasData(IReportSeed[] reportSeeds)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields()).hasData();
	}
	public IReportField[] getData(IReportSeed[] reportSeeds)
	{
		return getData(reportSeeds, false);
	}
	public IReportField[] getData(IReportSeed[] reportSeeds, boolean excludeNulls)
	{
		return new ReportDataProvider(reportSeeds, this.getFormReportFields(), excludeNulls).getData();
	}
	public static class lyr1Layer extends Layer
	{
		private static final long serialVersionUID = 1L;
		public static class tabPageLetterContainer extends LayerBridge
		{
			private static final long serialVersionUID = 1L;
			public void setTabActivatedEvent(ims.framework.delegates.TabActivated delegate)
			{
				super.container.setTabActivatedEvent(delegate);
			}
			public boolean isInitialized()
			{
				return super.container.isInitialized();
			}
			protected void setContext(Form form, ims.framework.interfaces.IAppForm appForm, Control control, FormLoader loader, Integer startControlID, ims.framework.utils.SizeInfo designSize, ims.framework.utils.SizeInfo runtimeSize, Integer startTabIndex, boolean skipContextValidation) throws Exception
			{
				if(form == null)
					throw new RuntimeException("Invalid form");
				if(appForm == null)
					throw new RuntimeException("Invalid application form");
				if(control == null); // this is to avoid eclipse warning only.
				if(loader == null); // this is to avoid eclipse warning only.
				if(startControlID == null)
					throw new RuntimeException("Invalid startControlID");
				if(designSize == null); // this is to avoid eclipse warning only.
				if(runtimeSize == null); // this is to avoid eclipse warning only.
				if(startTabIndex == null)
					throw new RuntimeException("Invalid startTabIndex");
		
		
				// Custom Controls
				ims.framework.CustomComponent instance1 = factory.getEmptyCustomComponent();
				RuntimeAnchoring anchoringHelper1 = new RuntimeAnchoring(designSize, runtimeSize, 0, 0, 888, 568, ims.framework.enumerations.ControlAnchoring.ALL);
				ims.framework.FormUiLogic m_ccUploadDocForm = loader.loadComponent(102264, appForm, startControlID * 10 + 1000, anchoringHelper1.getSize(), instance1, -1, skipContextValidation);
				//ims.framework.Control m_ccUploadDocControl = factory.getControl(CustomComponent.class, new Object[] { control, new Integer(startControlID.intValue() + 1000), new Integer(0), new Integer(0), new Integer(888), new Integer(568), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.ALL, new Integer(-1), m_ccUploadDocForm, instance1 } );
				ims.framework.Control m_ccUploadDocControl = factory.getControl(CustomComponent.class, new Object[] { control, new Integer(startControlID.intValue() + 1001),  new Integer(anchoringHelper1.getX()), new Integer(anchoringHelper1.getY()), new Integer(anchoringHelper1.getWidth()), new Integer(anchoringHelper1.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.ALL, new Integer(-1), m_ccUploadDocForm, instance1, Boolean.FALSE } );
				super.addControl(m_ccUploadDocControl);
				Menu[] menus1 = m_ccUploadDocForm.getForm().getRegisteredMenus();
				for(int x = 0; x < menus1.length; x++)
				{
					form.registerMenu(menus1[x]);
				}
			}

			public ims.core.forms.uploaddocument.IComponent ccUploadDoc()
			{
				return (ims.core.forms.uploaddocument.IComponent)((ims.framework.cn.controls.CustomComponent)super.getControl(0)).getLogic();
			}
			public void setccUploadDocValueChangedEvent(ims.framework.delegates.ValueChanged delegate)
			{
				((CustomComponent)super.getControl(0)).setValueChangedEvent(delegate);
			}
			public void setccUploadDocVisible(boolean value)
			{
				((ims.framework.Control)super.getControl(0)).setVisible(value);
			}
			public boolean isccUploadDocVisible()
			{
				return ((ims.framework.Control)super.getControl(0)).isVisible();
			}
			public void setccUploadDocEnabled(boolean value)
			{
				((ims.framework.Control)super.getControl(0)).setEnabled(value);
			}
			public boolean isccUploadDocEnabled()
			{
				return ((ims.framework.Control)super.getControl(0)).isEnabled();
			}
		}
		public static class tabPagePresentationCompContainer extends LayerBridge
		{
			private static final long serialVersionUID = 1L;
			public void setTabActivatedEvent(ims.framework.delegates.TabActivated delegate)
			{
				super.container.setTabActivatedEvent(delegate);
			}
			public boolean isInitialized()
			{
				return super.container.isInitialized();
			}
			protected void setContext(Form form, ims.framework.interfaces.IAppForm appForm, Control control, FormLoader loader, Integer startControlID, ims.framework.utils.SizeInfo designSize, ims.framework.utils.SizeInfo runtimeSize, Integer startTabIndex, boolean skipContextValidation) throws Exception
			{
				if(form == null)
					throw new RuntimeException("Invalid form");
				if(appForm == null)
					throw new RuntimeException("Invalid application form");
				if(control == null); // this is to avoid eclipse warning only.
				if(loader == null); // this is to avoid eclipse warning only.
				if(startControlID == null)
					throw new RuntimeException("Invalid startControlID");
				if(designSize == null); // this is to avoid eclipse warning only.
				if(runtimeSize == null); // this is to avoid eclipse warning only.
				if(startTabIndex == null)
					throw new RuntimeException("Invalid startTabIndex");
		
		
				// Custom Controls
				ims.framework.CustomComponent instance1 = factory.getEmptyCustomComponent();
				RuntimeAnchoring anchoringHelper2 = new RuntimeAnchoring(designSize, runtimeSize, 0, 0, 896, 576, ims.framework.enumerations.ControlAnchoring.ALL);
				ims.framework.FormUiLogic m_ccPresentationCompForm = loader.loadComponent(134114, appForm, startControlID * 10 + 2000, anchoringHelper2.getSize(), instance1, -1, skipContextValidation);
				//ims.framework.Control m_ccPresentationCompControl = factory.getControl(CustomComponent.class, new Object[] { control, new Integer(startControlID.intValue() + 1002), new Integer(0), new Integer(0), new Integer(896), new Integer(576), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.ALL, new Integer(-1), m_ccPresentationCompForm, instance1 } );
				ims.framework.Control m_ccPresentationCompControl = factory.getControl(CustomComponent.class, new Object[] { control, new Integer(startControlID.intValue() + 1003),  new Integer(anchoringHelper2.getX()), new Integer(anchoringHelper2.getY()), new Integer(anchoringHelper2.getWidth()), new Integer(anchoringHelper2.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.ALL, new Integer(-1), m_ccPresentationCompForm, instance1, Boolean.FALSE } );
				super.addControl(m_ccPresentationCompControl);
				Menu[] menus1 = m_ccPresentationCompForm.getForm().getRegisteredMenus();
				for(int x = 0; x < menus1.length; x++)
				{
					form.registerMenu(menus1[x]);
				}
			}

			public ims.RefMan.forms.presentationcomponent.IComponent ccPresentationComp()
			{
				return (ims.RefMan.forms.presentationcomponent.IComponent)((ims.framework.cn.controls.CustomComponent)super.getControl(0)).getLogic();
			}
			public void setccPresentationCompValueChangedEvent(ims.framework.delegates.ValueChanged delegate)
			{
				((CustomComponent)super.getControl(0)).setValueChangedEvent(delegate);
			}
			public void setccPresentationCompVisible(boolean value)
			{
				((ims.framework.Control)super.getControl(0)).setVisible(value);
			}
			public boolean isccPresentationCompVisible()
			{
				return ((ims.framework.Control)super.getControl(0)).isVisible();
			}
			public void setccPresentationCompEnabled(boolean value)
			{
				((ims.framework.Control)super.getControl(0)).setEnabled(value);
			}
			public boolean isccPresentationCompEnabled()
			{
				return ((ims.framework.Control)super.getControl(0)).isEnabled();
			}
		}

		protected void setContext(Form form, ims.framework.interfaces.IAppForm appForm, Control control, FormLoader loader, Integer startControlID, ims.framework.utils.SizeInfo designSize, ims.framework.utils.SizeInfo runtimeSize, Integer startTabIndex, boolean skipContextValidation) throws Exception
		{
			if(form == null)
				throw new RuntimeException("Invalid form");
			if(appForm == null)
				throw new RuntimeException("Invalid application form");
			if(control == null); // this is to avoid eclipse warning only.
			if(loader == null); // this is to avoid eclipse warning only.
			if(startControlID == null)
				throw new RuntimeException("Invalid startControlID");
			if(designSize == null); // this is to avoid eclipse warning only.
			if(runtimeSize == null); // this is to avoid eclipse warning only.
			if(startTabIndex == null)
				throw new RuntimeException("Invalid startTabIndex");
			RuntimeAnchoring anchoringHelper3 = new RuntimeAnchoring(designSize, runtimeSize, 0, 0, 896, 600, ims.framework.enumerations.ControlAnchoring.ALL);
			Container m_tabPageLetter = (Container)factory.getControl(Container.class, new Object[] { control, new Integer(startControlID.intValue() + 1004), new Integer(anchoringHelper3.getX()), new Integer(anchoringHelper3.getY()), new Integer(anchoringHelper3.getWidth()), new Integer(anchoringHelper3.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.ALL,"Letter", new Integer(startControlID.intValue() + 0), new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(false)});
			tabPageLetterContainer m_tabPageLetterContainer = (tabPageLetterContainer)LayerBridgeFlyweightFactory.getInstance().createLayerBridge(tabPageLetterContainer.class, m_tabPageLetter, factory);
			super.addContainer(m_tabPageLetter, m_tabPageLetterContainer);
			ims.framework.utils.SizeInfo m_tabPageLetterDesignSize = new ims.framework.utils.SizeInfo(896, 600);
			ims.framework.utils.SizeInfo m_tabPageLetterRuntimeSize = new ims.framework.utils.SizeInfo(anchoringHelper3.getWidth(), anchoringHelper3.getHeight());
			m_tabPageLetterContainer.setContext(form, appForm, m_tabPageLetter, loader, startControlID, m_tabPageLetterDesignSize, m_tabPageLetterRuntimeSize, startTabIndex, skipContextValidation);
			RuntimeAnchoring anchoringHelper4 = new RuntimeAnchoring(designSize, runtimeSize, 0, 0, 896, 600, ims.framework.enumerations.ControlAnchoring.ALL);
			Container m_tabPagePresentationComp = (Container)factory.getControl(Container.class, new Object[] { control, new Integer(startControlID.intValue() + 1005), new Integer(anchoringHelper4.getX()), new Integer(anchoringHelper4.getY()), new Integer(anchoringHelper4.getWidth()), new Integer(anchoringHelper4.getHeight()), ControlState.UNKNOWN, ControlState.UNKNOWN, ims.framework.enumerations.ControlAnchoring.ALL,"Presentation", new Integer(startControlID.intValue() + 0), new Boolean(false), new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(false)});
			tabPagePresentationCompContainer m_tabPagePresentationCompContainer = (tabPagePresentationCompContainer)LayerBridgeFlyweightFactory.getInstance().createLayerBridge(tabPagePresentationCompContainer.class, m_tabPagePresentationComp, factory);
			super.addContainer(m_tabPagePresentationComp, m_tabPagePresentationCompContainer);
			ims.framework.utils.SizeInfo m_tabPagePresentationCompDesignSize = new ims.framework.utils.SizeInfo(896, 600);
			ims.framework.utils.SizeInfo m_tabPagePresentationCompRuntimeSize = new ims.framework.utils.SizeInfo(anchoringHelper4.getWidth(), anchoringHelper4.getHeight());
			m_tabPagePresentationCompContainer.setContext(form, appForm, m_tabPagePresentationComp, loader, startControlID, m_tabPagePresentationCompDesignSize, m_tabPagePresentationCompRuntimeSize, startTabIndex, skipContextValidation);
		}
		public void hide()
		{
			tabPageLetter().setVisible(false);
			tabPagePresentationComp().setVisible(false);
		}
		public void settabPageLetterEnabled(boolean value)
		{
			tabPageLetter().setEnabled(value);
		}
		public void settabPagePresentationCompEnabled(boolean value)
		{
			tabPagePresentationComp().setEnabled(value);
		}
		public void showtabPageLetter()
		{
			tabPagePresentationComp().setVisible(false);
			tabPageLetter().setVisible(true);
		}
		public void showtabPagePresentationComp()
		{
			tabPageLetter().setVisible(false);
			tabPagePresentationComp().setVisible(true);
		}

		public tabPageLetterContainer tabPageLetter()
		{
			return (tabPageLetterContainer)super.layers.get(0);
		}
		public tabPagePresentationCompContainer tabPagePresentationComp()
		{
			return (tabPagePresentationCompContainer)super.layers.get(1);
		}
	}
	private void validateContext(ims.framework.Context context)
	{
		if(context == null)
			return;
		if(!context.isValidContextType(ims.RefMan.vo.CatsReferralRefVo.class))
			throw new ims.framework.exceptions.CodingRuntimeException("The type 'ims.RefMan.vo.CatsReferralRefVo' of the global context variable 'RefMan.CatsReferral' is not supported.");
		if(!context.isValidContextType(Boolean.class))
			throw new ims.framework.exceptions.CodingRuntimeException("The type 'Boolean' of the global context variable 'RefMan.IsProviderCancellation' is not supported.");
	}
	private void validateMandatoryContext(Context context)
	{
		if(new ims.framework.ContextVariable("RefMan.CatsReferral", "_cvp_RefMan.CatsReferral").getValueIsNull(context))
			throw new ims.framework.exceptions.FormMandatoryContextMissingException("The required context data 'RefMan.CatsReferral' is not available.");
	}
	public boolean supportsRecordedInError()
	{
		return false;
	}
	public ims.vo.ValueObject getRecordedInErrorVo()
	{
		return null;
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, Context context) throws Exception
	{
		setContext(loader, form, appForm, factory, context, Boolean.FALSE, new Integer(0), null, null, new Integer(0));
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, Context context, Boolean skipContextValidation) throws Exception
	{
		setContext(loader, form, appForm, factory, context, skipContextValidation, new Integer(0), null, null, new Integer(0));
	}
	protected void setContext(FormLoader loader, Form form, ims.framework.interfaces.IAppForm appForm, UIFactory factory, ims.framework.Context context, Boolean skipContextValidation, Integer startControlID, ims.framework.utils.SizeInfo runtimeSize, ims.framework.Control control, Integer startTabIndex) throws Exception
	{
		if(loader == null); // this is to avoid eclipse warning only.
		if(factory == null); // this is to avoid eclipse warning only.
		if(runtimeSize == null); // this is to avoid eclipse warning only.
		if(appForm == null)
			throw new RuntimeException("Invalid application form");
		if(startControlID == null)
			throw new RuntimeException("Invalid startControlID");
		if(control == null); // this is to avoid eclipse warning only.
		if(startTabIndex == null)
			throw new RuntimeException("Invalid startTabIndex");
		this.context = context;
		this.componentIdentifier = startControlID.toString();
		this.formInfo = form.getFormInfo();
		this.globalContext = new GlobalContext(context);
	
		if(skipContextValidation == null || !skipContextValidation.booleanValue())
		{
			validateContext(context);
			validateMandatoryContext(context);
		}
	
		super.setContext(form);

		ims.framework.utils.SizeInfo designSize = new ims.framework.utils.SizeInfo(896, 640);
		if(runtimeSize == null)
			runtimeSize = designSize;
		form.setWidth(runtimeSize.getWidth());
		form.setHeight(runtimeSize.getHeight());
		super.setGlobalContext(ContextBridgeFlyweightFactory.getInstance().create(GlobalContextBridge.class, context, false));
		super.setLocalContext(new LocalContext(context, form.getFormInfo(), componentIdentifier));


		// Layer Clasess
		lyr1Layer m_lyr1Layer = (lyr1Layer)LayerFlyweightFactory.getInstance().createLayer(lyr1Layer.class, this, factory);
		super.addLayer(m_lyr1Layer);
		m_lyr1Layer.setContext(form, appForm, control, loader, startControlID, designSize, runtimeSize, startTabIndex, skipContextValidation);

		// Button Controls
		RuntimeAnchoring anchoringHelper5 = new RuntimeAnchoring(designSize, runtimeSize, 816, 608, 75, 23, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT);
		super.addControl(factory.getControl(Button.class, new Object[] { control, new Integer(startControlID.intValue() + 1006), new Integer(anchoringHelper5.getX()), new Integer(anchoringHelper5.getY()), new Integer(anchoringHelper5.getWidth()), new Integer(anchoringHelper5.getHeight()), new Integer(startTabIndex.intValue() + 1), ControlState.HIDDEN, ControlState.ENABLED, ims.framework.enumerations.ControlAnchoring.BOTTOMRIGHT, "Close", Boolean.FALSE, null, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, null, ims.framework.utils.Color.Default, ims.framework.utils.Color.Default }));
	}


	public lyr1Layer lyr1()
	{
		return (lyr1Layer)super.getLayer(0);
	}
	public Button btnCancel()
	{
		return (Button)super.getControl(2);
	}
	public GlobalContext getGlobalContext()
	{
		return this.globalContext;
	}
	public static class GlobalContextBridge extends ContextBridge
	{
		private static final long serialVersionUID = 1L;
	}
	public LocalContext getLocalContext()
	{
		return (LocalContext)super.getLocalCtx();
	}
	public class LocalContext extends ContextBridge
	{
		private static final long serialVersionUID = 1L;
		
		public LocalContext(Context context, ims.framework.FormInfo formInfo, String componentIdentifier)
		{
			super.setContext(context);
			String prefix = formInfo.getLocalVariablesPrefix();
			cxl_PresentationReferralSummaryvo = new ims.framework.ContextVariable("PresentationReferralSummaryvo", prefix + "_lv_RefMan.Presentation.__internal_x_context__PresentationReferralSummaryvo_" + componentIdentifier + "");
		}
		
		public boolean getPresentationReferralSummaryvoIsNotNull()
		{
			return !cxl_PresentationReferralSummaryvo.getValueIsNull(context);
		}
		public ims.RefMan.vo.PresentationReferralSummaryVo getPresentationReferralSummaryvo()
		{
			return (ims.RefMan.vo.PresentationReferralSummaryVo)cxl_PresentationReferralSummaryvo.getValue(context);
		}
		public void setPresentationReferralSummaryvo(ims.RefMan.vo.PresentationReferralSummaryVo value)
		{
			cxl_PresentationReferralSummaryvo.setValue(context, value);
		}
		private ims.framework.ContextVariable cxl_PresentationReferralSummaryvo = null;
	}
	private IReportField[] getFormReportFields()
	{
		if(this.context == null)
			return null;
		if(this.reportFields == null)
			this.reportFields = new ReportFields(this.context, this.formInfo, this.componentIdentifier).getReportFields();
		return this.reportFields;
	}
	private class ReportFields
	{
		public ReportFields(Context context, ims.framework.FormInfo formInfo, String componentIdentifier)
		{
			this.context = context;
			this.formInfo = formInfo;
			this.componentIdentifier = componentIdentifier;
		}
		public IReportField[] getReportFields()
		{
			String prefix = formInfo.getLocalVariablesPrefix();
			IReportField[] fields = new IReportField[85];
			fields[0] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ID", "ID_Patient");
			fields[1] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SEX", "Sex");
			fields[2] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-DOB", "Dob");
			fields[3] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-DOD", "Dod");
			fields[4] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-RELIGION", "Religion");
			fields[5] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ISACTIVE", "IsActive");
			fields[6] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ETHNICORIGIN", "EthnicOrigin");
			fields[7] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-MARITALSTATUS", "MaritalStatus");
			fields[8] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SCN", "SCN");
			fields[9] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-SOURCEOFINFORMATION", "SourceOfInformation");
			fields[10] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-TIMEOFDEATH", "TimeOfDeath");
			fields[11] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-ISQUICKREGISTRATIONPATIENT", "IsQuickRegistrationPatient");
			fields[12] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientShort", "BO-1001100000-CURRENTRESPONSIBLECONSULTANT", "CurrentResponsibleConsultant");
			fields[13] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-ID", "ID_Patient");
			fields[14] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-SEX", "Sex");
			fields[15] = new ims.framework.ReportField(this.context, "_cvp_Core.PatientFilter", "BO-1001100000-DOB", "Dob");
			fields[16] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ID", "ID_ClinicalContact");
			fields[17] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-SPECIALTY", "Specialty");
			fields[18] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-CONTACTTYPE", "ContactType");
			fields[19] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-STARTDATETIME", "StartDateTime");
			fields[20] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ENDDATETIME", "EndDateTime");
			fields[21] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-CARECONTEXT", "CareContext");
			fields[22] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentClinicalContact", "BO-1004100003-ISCLINICALNOTECREATED", "IsClinicalNoteCreated");
			fields[23] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ID", "ID_Hcp");
			fields[24] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-HCPTYPE", "HcpType");
			fields[25] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISACTIVE", "IsActive");
			fields[26] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISHCPARESPONSIBLEHCP", "IsHCPaResponsibleHCP");
			fields[27] = new ims.framework.ReportField(this.context, "_cvp_Core.RecordingHCP", "BO-1006100000-ISARESPONSIBLEEDCLINICIAN", "IsAResponsibleEDClinician");
			fields[28] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ID", "ID_CareContext");
			fields[29] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-CONTEXT", "Context");
			fields[30] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ORDERINGHOSPITAL", "OrderingHospital");
			fields[31] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ESTIMATEDDISCHARGEDATE", "EstimatedDischargeDate");
			fields[32] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-STARTDATETIME", "StartDateTime");
			fields[33] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-ENDDATETIME", "EndDateTime");
			fields[34] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-LOCATIONTYPE", "LocationType");
			fields[35] = new ims.framework.ReportField(this.context, "_cvp_Core.CurrentCareContext", "BO-1004100019-RESPONSIBLEHCP", "ResponsibleHCP");
			fields[36] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-ID", "ID_EpisodeOfCare");
			fields[37] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-CARESPELL", "CareSpell");
			fields[38] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-SPECIALTY", "Specialty");
			fields[39] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-RELATIONSHIP", "Relationship");
			fields[40] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-STARTDATE", "StartDate");
			fields[41] = new ims.framework.ReportField(this.context, "_cvp_Core.EpisodeofCareShort", "BO-1004100018-ENDDATE", "EndDate");
			fields[42] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ID", "ID_ClinicalNotes");
			fields[43] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CLINICALNOTE", "ClinicalNote");
			fields[44] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-NOTETYPE", "NoteType");
			fields[45] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-DISCIPLINE", "Discipline");
			fields[46] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CLINICALCONTACT", "ClinicalContact");
			fields[47] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISDERIVEDNOTE", "IsDerivedNote");
			fields[48] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-FORREVIEW", "ForReview");
			fields[49] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-FORREVIEWDISCIPLINE", "ForReviewDiscipline");
			fields[50] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-REVIEWINGDATETIME", "ReviewingDateTime");
			fields[51] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISCORRECTED", "IsCorrected");
			fields[52] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-ISTRANSCRIBED", "IsTranscribed");
			fields[53] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-SOURCEOFNOTE", "SourceOfNote");
			fields[54] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-RECORDINGDATETIME", "RecordingDateTime");
			fields[55] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-INHOSPITALREPORT", "InHospitalReport");
			fields[56] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-CARECONTEXT", "CareContext");
			fields[57] = new ims.framework.ReportField(this.context, "_cvp_Clinical.CurrentClinicalNote", "BO-1011100000-NOTECLASSIFICATION", "NoteClassification");
			fields[58] = new ims.framework.ReportField(this.context, "_cvp_STHK.AvailableBedsListFilter", "BO-1014100009-ID", "ID_BedSpaceState");
			fields[59] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingEmergencyAdmissionsFilter", "BO-1014100011-ID", "ID_PendingEmergencyAdmission");
			fields[60] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingEmergencyAdmissionsFilter", "BO-1014100011-ADMISSIONSTATUS", "AdmissionStatus");
			fields[61] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingDischargesListFilter", "BO-1014100000-ID", "ID_InpatientEpisode");
			fields[62] = new ims.framework.ReportField(this.context, "_cvp_STHK.PendingDischargesListFilter", "BO-1014100000-ESTDISCHARGEDATE", "EstDischargeDate");
			fields[63] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-ID", "ID_ClinicalNotes");
			fields[64] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-FORREVIEW", "ForReview");
			fields[65] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-FORREVIEWDISCIPLINE", "ForReviewDiscipline");
			fields[66] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-NOTECLASSIFICATION", "NoteClassification");
			fields[67] = new ims.framework.ReportField(this.context, "_cvp_Clinical.ExtendedClinicalNotesListFilter", "BO-1011100000-CARECONTEXT", "CareContext");
			fields[68] = new ims.framework.ReportField(this.context, "_cvp_Core.PasEvent", "BO-1014100003-ID", "ID_PASEvent");
			fields[69] = new ims.framework.ReportField(this.context, "_cvp_Correspondence.CorrespondenceDetails", "BO-1052100001-ID", "ID_CorrespondenceDetails");
			fields[70] = new ims.framework.ReportField(this.context, "_cvp_RefMan.CatsReferral", "BO-1004100035-ID", "ID_CatsReferral");
			fields[71] = new ims.framework.ReportField(this.context, "_cv_savedPresentationReferralSummary", "BO-1096100001-ID", "ID_PresentationReferralSummary");
			fields[72] = new ims.framework.ReportField(this.context, "_cv_savedPresentationReferralSummary", "BO-1096100001-CATSREFERRAL", "CatsReferral");
			fields[73] = new ims.framework.ReportField(this.context, "_cv_savedPresentationReferralSummary", "BO-1096100001-AUTHORINGDATETIME", "AuthoringDateTime");
			fields[74] = new ims.framework.ReportField(this.context, "_cv_savedPresentationReferralSummary", "BO-1096100001-PRESENTINGISSUESNONINDICATED", "PresentingIssuesNonIndicated");
			fields[75] = new ims.framework.ReportField(this.context, "_cv_savedPresentationReferralSummary", "BO-1096100001-MEDICATIONNONINDICATED", "MedicationNonIndicated");
			fields[76] = new ims.framework.ReportField(this.context, "_cv_savedPresentationReferralSummary", "BO-1096100001-ALLERGIESISSUESNONINDICATED", "AllergiesIssuesNonIndicated");
			fields[77] = new ims.framework.ReportField(this.context, "_cv_savedPresentationReferralSummary", "BO-1096100001-COMORBIDITIESISSUESNONINDICATED", "ComorbiditiesIssuesNonIndicated");
			fields[78] = new ims.framework.ReportField(this.context, prefix + "_lv_RefMan.Presentation.__internal_x_context__PresentationReferralSummaryvo_" + componentIdentifier, "BO-1096100001-ID", "ID_PresentationReferralSummary");
			fields[79] = new ims.framework.ReportField(this.context, prefix + "_lv_RefMan.Presentation.__internal_x_context__PresentationReferralSummaryvo_" + componentIdentifier, "BO-1096100001-CATSREFERRAL", "CatsReferral");
			fields[80] = new ims.framework.ReportField(this.context, prefix + "_lv_RefMan.Presentation.__internal_x_context__PresentationReferralSummaryvo_" + componentIdentifier, "BO-1096100001-AUTHORINGDATETIME", "AuthoringDateTime");
			fields[81] = new ims.framework.ReportField(this.context, prefix + "_lv_RefMan.Presentation.__internal_x_context__PresentationReferralSummaryvo_" + componentIdentifier, "BO-1096100001-PRESENTINGISSUESNONINDICATED", "PresentingIssuesNonIndicated");
			fields[82] = new ims.framework.ReportField(this.context, prefix + "_lv_RefMan.Presentation.__internal_x_context__PresentationReferralSummaryvo_" + componentIdentifier, "BO-1096100001-MEDICATIONNONINDICATED", "MedicationNonIndicated");
			fields[83] = new ims.framework.ReportField(this.context, prefix + "_lv_RefMan.Presentation.__internal_x_context__PresentationReferralSummaryvo_" + componentIdentifier, "BO-1096100001-ALLERGIESISSUESNONINDICATED", "AllergiesIssuesNonIndicated");
			fields[84] = new ims.framework.ReportField(this.context, prefix + "_lv_RefMan.Presentation.__internal_x_context__PresentationReferralSummaryvo_" + componentIdentifier, "BO-1096100001-COMORBIDITIESISSUESNONINDICATED", "ComorbiditiesIssuesNonIndicated");
			return fields;
		}
		protected Context context = null;
		protected ims.framework.FormInfo formInfo;
		protected String componentIdentifier;
	}
	public String getUniqueIdentifier()
	{
		return null;
	}
	private Context context = null;
	private ims.framework.FormInfo formInfo = null;
	private String componentIdentifier;
	private GlobalContext globalContext = null;
	private IReportField[] reportFields = null;
}
