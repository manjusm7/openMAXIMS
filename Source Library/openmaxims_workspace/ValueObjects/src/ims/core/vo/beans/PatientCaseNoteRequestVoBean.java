//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
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
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.vo.beans;

public class PatientCaseNoteRequestVoBean extends ims.vo.ValueObjectBean
{
	public PatientCaseNoteRequestVoBean()
	{
	}
	public PatientCaseNoteRequestVoBean(ims.core.vo.PatientCaseNoteRequestVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.creationdate = vo.getCreationDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCreationDate().getBean();
		this.requeststatus = vo.getRequestStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getRequestStatus().getBean();
		this.requiredbydate = vo.getRequiredByDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRequiredByDate().getBean();
		this.reasonforrequest = vo.getReasonForRequest() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasonForRequest().getBean();
		this.cancelleddate = vo.getCancelledDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCancelledDate().getBean();
		this.cancellationreason = vo.getCancellationReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancellationReason().getBean();
		this.casenote = vo.getCaseNote() == null ? null : (ims.core.vo.beans.PatientCaseNoteTypeVoBean)vo.getCaseNote().getBean();
		this.requestedforlocation = vo.getRequestedForLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getRequestedForLocation().getBean();
		this.requestedby = vo.getRequestedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getRequestedBy().getBean();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientLite_IdentifiersVoBean)vo.getPatient().getBean();
		this.requestcomment = vo.getRequestComment() == null ? null : (ims.core.vo.beans.PatientCaseNoteCommentSaveVoBean)vo.getRequestComment().getBean();
		this.cancelledby = vo.getCancelledBy() == null ? null : new ims.vo.RefVoBean(vo.getCancelledBy().getBoId(), vo.getCancelledBy().getBoVersion());
		this.transferthatcompletedrequest = vo.getTransferThatCompletedRequest() == null ? null : new ims.vo.RefVoBean(vo.getTransferThatCompletedRequest().getBoId(), vo.getTransferThatCompletedRequest().getBoVersion());
		this.appointment = vo.getAppointment() == null ? null : new ims.vo.RefVoBean(vo.getAppointment().getBoId(), vo.getAppointment().getBoVersion());
		this.tcidetail = vo.getTCIDetail() == null ? null : new ims.vo.RefVoBean(vo.getTCIDetail().getBoId(), vo.getTCIDetail().getBoVersion());
		this.systeminformation = vo.getSystemInformation() == null ? null : (ims.vo.SysInfoBean)vo.getSystemInformation().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientCaseNoteRequestVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.creationdate = vo.getCreationDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCreationDate().getBean();
		this.requeststatus = vo.getRequestStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getRequestStatus().getBean();
		this.requiredbydate = vo.getRequiredByDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getRequiredByDate().getBean();
		this.reasonforrequest = vo.getReasonForRequest() == null ? null : (ims.vo.LookupInstanceBean)vo.getReasonForRequest().getBean();
		this.cancelleddate = vo.getCancelledDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCancelledDate().getBean();
		this.cancellationreason = vo.getCancellationReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancellationReason().getBean();
		this.casenote = vo.getCaseNote() == null ? null : (ims.core.vo.beans.PatientCaseNoteTypeVoBean)vo.getCaseNote().getBean(map);
		this.requestedforlocation = vo.getRequestedForLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getRequestedForLocation().getBean(map);
		this.requestedby = vo.getRequestedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getRequestedBy().getBean(map);
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientLite_IdentifiersVoBean)vo.getPatient().getBean(map);
		this.requestcomment = vo.getRequestComment() == null ? null : (ims.core.vo.beans.PatientCaseNoteCommentSaveVoBean)vo.getRequestComment().getBean(map);
		this.cancelledby = vo.getCancelledBy() == null ? null : new ims.vo.RefVoBean(vo.getCancelledBy().getBoId(), vo.getCancelledBy().getBoVersion());
		this.transferthatcompletedrequest = vo.getTransferThatCompletedRequest() == null ? null : new ims.vo.RefVoBean(vo.getTransferThatCompletedRequest().getBoId(), vo.getTransferThatCompletedRequest().getBoVersion());
		this.appointment = vo.getAppointment() == null ? null : new ims.vo.RefVoBean(vo.getAppointment().getBoId(), vo.getAppointment().getBoVersion());
		this.tcidetail = vo.getTCIDetail() == null ? null : new ims.vo.RefVoBean(vo.getTCIDetail().getBoId(), vo.getTCIDetail().getBoVersion());
		this.systeminformation = vo.getSystemInformation() == null ? null : (ims.vo.SysInfoBean)vo.getSystemInformation().getBean();
	}

	public ims.core.vo.PatientCaseNoteRequestVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientCaseNoteRequestVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientCaseNoteRequestVo vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientCaseNoteRequestVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientCaseNoteRequestVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCreationDate()
	{
		return this.creationdate;
	}
	public void setCreationDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.creationdate = value;
	}
	public ims.vo.LookupInstanceBean getRequestStatus()
	{
		return this.requeststatus;
	}
	public void setRequestStatus(ims.vo.LookupInstanceBean value)
	{
		this.requeststatus = value;
	}
	public ims.framework.utils.beans.DateTimeBean getRequiredByDate()
	{
		return this.requiredbydate;
	}
	public void setRequiredByDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.requiredbydate = value;
	}
	public ims.vo.LookupInstanceBean getReasonForRequest()
	{
		return this.reasonforrequest;
	}
	public void setReasonForRequest(ims.vo.LookupInstanceBean value)
	{
		this.reasonforrequest = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCancelledDate()
	{
		return this.cancelleddate;
	}
	public void setCancelledDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.cancelleddate = value;
	}
	public ims.vo.LookupInstanceBean getCancellationReason()
	{
		return this.cancellationreason;
	}
	public void setCancellationReason(ims.vo.LookupInstanceBean value)
	{
		this.cancellationreason = value;
	}
	public ims.core.vo.beans.PatientCaseNoteTypeVoBean getCaseNote()
	{
		return this.casenote;
	}
	public void setCaseNote(ims.core.vo.beans.PatientCaseNoteTypeVoBean value)
	{
		this.casenote = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getRequestedForLocation()
	{
		return this.requestedforlocation;
	}
	public void setRequestedForLocation(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.requestedforlocation = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getRequestedBy()
	{
		return this.requestedby;
	}
	public void setRequestedBy(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.requestedby = value;
	}
	public ims.core.vo.beans.PatientLite_IdentifiersVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientLite_IdentifiersVoBean value)
	{
		this.patient = value;
	}
	public ims.core.vo.beans.PatientCaseNoteCommentSaveVoBean getRequestComment()
	{
		return this.requestcomment;
	}
	public void setRequestComment(ims.core.vo.beans.PatientCaseNoteCommentSaveVoBean value)
	{
		this.requestcomment = value;
	}
	public ims.vo.RefVoBean getCancelledBy()
	{
		return this.cancelledby;
	}
	public void setCancelledBy(ims.vo.RefVoBean value)
	{
		this.cancelledby = value;
	}
	public ims.vo.RefVoBean getTransferThatCompletedRequest()
	{
		return this.transferthatcompletedrequest;
	}
	public void setTransferThatCompletedRequest(ims.vo.RefVoBean value)
	{
		this.transferthatcompletedrequest = value;
	}
	public ims.vo.RefVoBean getAppointment()
	{
		return this.appointment;
	}
	public void setAppointment(ims.vo.RefVoBean value)
	{
		this.appointment = value;
	}
	public ims.vo.RefVoBean getTCIDetail()
	{
		return this.tcidetail;
	}
	public void setTCIDetail(ims.vo.RefVoBean value)
	{
		this.tcidetail = value;
	}
	public ims.vo.SysInfoBean getSystemInformation()
	{
		return this.systeminformation;
	}
	public void setSystemInformation(ims.vo.SysInfoBean value)
	{
		this.systeminformation = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean creationdate;
	private ims.vo.LookupInstanceBean requeststatus;
	private ims.framework.utils.beans.DateTimeBean requiredbydate;
	private ims.vo.LookupInstanceBean reasonforrequest;
	private ims.framework.utils.beans.DateTimeBean cancelleddate;
	private ims.vo.LookupInstanceBean cancellationreason;
	private ims.core.vo.beans.PatientCaseNoteTypeVoBean casenote;
	private ims.core.vo.beans.LocationLiteVoBean requestedforlocation;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean requestedby;
	private ims.core.vo.beans.PatientLite_IdentifiersVoBean patient;
	private ims.core.vo.beans.PatientCaseNoteCommentSaveVoBean requestcomment;
	private ims.vo.RefVoBean cancelledby;
	private ims.vo.RefVoBean transferthatcompletedrequest;
	private ims.vo.RefVoBean appointment;
	private ims.vo.RefVoBean tcidetail;
	private ims.vo.SysInfoBean systeminformation;
}