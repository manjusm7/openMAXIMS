// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.beans;

public class SuspensionDetailsForPatientElectiveListVoBean extends ims.vo.ValueObjectBean
{
	public SuspensionDetailsForPatientElectiveListVoBean()
	{
	}
	public SuspensionDetailsForPatientElectiveListVoBean(ims.RefMan.vo.SuspensionDetailsForPatientElectiveListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.enddate = vo.getEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDate().getBean();
		this.initator = vo.getInitator() == null ? null : (ims.vo.LookupInstanceBean)vo.getInitator().getBean();
		this.comments = vo.getComments();
		this.suspensionreason = vo.getSuspensionReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getSuspensionReason().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.SuspensionDetailsForPatientElectiveListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.startdate = vo.getStartDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getStartDate().getBean();
		this.enddate = vo.getEndDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getEndDate().getBean();
		this.initator = vo.getInitator() == null ? null : (ims.vo.LookupInstanceBean)vo.getInitator().getBean();
		this.comments = vo.getComments();
		this.suspensionreason = vo.getSuspensionReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getSuspensionReason().getBean();
	}

	public ims.RefMan.vo.SuspensionDetailsForPatientElectiveListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.SuspensionDetailsForPatientElectiveListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.SuspensionDetailsForPatientElectiveListVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.SuspensionDetailsForPatientElectiveListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.SuspensionDetailsForPatientElectiveListVo();
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
	public ims.framework.utils.beans.DateBean getStartDate()
	{
		return this.startdate;
	}
	public void setStartDate(ims.framework.utils.beans.DateBean value)
	{
		this.startdate = value;
	}
	public ims.framework.utils.beans.DateBean getEndDate()
	{
		return this.enddate;
	}
	public void setEndDate(ims.framework.utils.beans.DateBean value)
	{
		this.enddate = value;
	}
	public ims.vo.LookupInstanceBean getInitator()
	{
		return this.initator;
	}
	public void setInitator(ims.vo.LookupInstanceBean value)
	{
		this.initator = value;
	}
	public String getComments()
	{
		return this.comments;
	}
	public void setComments(String value)
	{
		this.comments = value;
	}
	public ims.vo.LookupInstanceBean getSuspensionReason()
	{
		return this.suspensionreason;
	}
	public void setSuspensionReason(ims.vo.LookupInstanceBean value)
	{
		this.suspensionreason = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean startdate;
	private ims.framework.utils.beans.DateBean enddate;
	private ims.vo.LookupInstanceBean initator;
	private String comments;
	private ims.vo.LookupInstanceBean suspensionreason;
}
