// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.booktheatreslotdetaildialog;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbExceededReasonLookup();
	abstract protected void defaultcmbExceededReasonLookupValue();
	abstract protected void bindcmbElectiveListReasonLookup();
	abstract protected void defaultcmbElectiveListReasonLookupValue();
	abstract protected void bindcmbIntendedManagementLookup();
	abstract protected void defaultcmbIntendedManagementLookupValue();
	abstract protected void bindcmbAnaesTypeLookup();
	abstract protected void defaultcmbAnaesTypeLookupValue();
	abstract protected void onMessageBoxClosed(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnResourceClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnDashboardClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbExceededReasonValueSet(Object value);
	abstract protected void oncmbElectiveListReasonValueSet(Object value);
	abstract protected void onCmbElectiveListReasonValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbSelectElectiveListConfigClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbIntendedManagementValueSet(Object value);
	abstract protected void onDteToComeInValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbAnaesTypeValueSet(Object value);
	abstract protected void onCmbProcedureValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkErodValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnBookClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setMessageBoxClosedEvent(new MessageBoxClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(int messageBoxId, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onMessageBoxClosed(messageBoxId, result);
			}
		});
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen(args);
			}
		});
		this.form.setFormDialogClosedEvent(new FormDialogClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormDialogClosed(formName, result);
			}
		});
		this.form.btnResource().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnResourceClick();
			}
		});
		this.form.btnDashboard().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnDashboardClick();
			}
		});
		this.form.cmbExceededReason().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbExceededReasonValueSet(value);
			}
		});
		this.form.cmbElectiveListReason().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbElectiveListReasonValueSet(value);
			}
		});
		this.form.cmbElectiveListReason().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbElectiveListReasonValueChanged();
			}
		});
		this.form.imbSelectElectiveListConfig().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbSelectElectiveListConfigClick();
			}
		});
		this.form.cmbIntendedManagement().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbIntendedManagementValueSet(value);
			}
		});
		this.form.dteToComeIn().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onDteToComeInValueChanged();
			}
		});
		this.form.cmbAnaesType().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbAnaesTypeValueSet(value);
			}
		});
		this.form.cmbProcedure().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbProcedureValueChanged();
			}
		});
		this.form.chkErod().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkErodValueChanged();
			}
		});
		this.form.btnBook().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnBookClick();
			}
		});
		this.form.btnCancel().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnCancelClick();
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbExceededReasonLookup();
		bindcmbElectiveListReasonLookup();
		bindcmbIntendedManagementLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbExceededReasonLookup();
		bindcmbElectiveListReasonLookup();
		bindcmbIntendedManagementLookup();
		bindcmbAnaesTypeLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbExceededReasonLookupValue();
		defaultcmbElectiveListReasonLookupValue();
		defaultcmbIntendedManagementLookupValue();
		defaultcmbAnaesTypeLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIEngine engine;
	protected GenForm form;
}
