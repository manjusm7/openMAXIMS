// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseLinkReportNoteToTemplateImpl extends DomainImpl implements ims.RefMan.domain.LinkReportNoteToTemplate, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetReportNotePrintTemplateByType(ims.RefMan.vo.lookups.ReportNoteType type)
	{
		if(type == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'type' of type 'ims.RefMan.vo.lookups.ReportNoteType' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validatesave(ims.RefMan.vo.ReportNotePrintTemplateVo report)
	{
		if(report == null)
			throw new ims.domain.exceptions.DomainRuntimeException("The parameter 'report' of type 'ims.RefMan.vo.ReportNotePrintTemplateVo' cannot be null.");
	}

	@SuppressWarnings("unused")
	public void validateremoveLink(ims.RefMan.vo.ReportNotePrintTemplateVo report)
	{
	}
}
