// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.beans;

public class ElectiveTCIForReferralDetailsVoBean extends ims.vo.ValueObjectBean
{
	public ElectiveTCIForReferralDetailsVoBean()
	{
	}
	public ElectiveTCIForReferralDetailsVoBean(ims.RefMan.vo.ElectiveTCIForReferralDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.tcidate = vo.getTCIDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTCIDate().getBean();
		this.tcitime = vo.getTCITime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTCITime().getBean();
		this.appointment = vo.getAppointment() == null ? null : (ims.scheduling.vo.beans.ReferralAppointmentDetailsBookingAppointmentVoBean)vo.getAppointment().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.ElectiveTCIForReferralDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.tcidate = vo.getTCIDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getTCIDate().getBean();
		this.tcitime = vo.getTCITime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTCITime().getBean();
		this.appointment = vo.getAppointment() == null ? null : (ims.scheduling.vo.beans.ReferralAppointmentDetailsBookingAppointmentVoBean)vo.getAppointment().getBean(map);
	}

	public ims.RefMan.vo.ElectiveTCIForReferralDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.ElectiveTCIForReferralDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.ElectiveTCIForReferralDetailsVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.ElectiveTCIForReferralDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.ElectiveTCIForReferralDetailsVo();
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
	public ims.framework.utils.beans.DateBean getTCIDate()
	{
		return this.tcidate;
	}
	public void setTCIDate(ims.framework.utils.beans.DateBean value)
	{
		this.tcidate = value;
	}
	public ims.framework.utils.beans.TimeBean getTCITime()
	{
		return this.tcitime;
	}
	public void setTCITime(ims.framework.utils.beans.TimeBean value)
	{
		this.tcitime = value;
	}
	public ims.scheduling.vo.beans.ReferralAppointmentDetailsBookingAppointmentVoBean getAppointment()
	{
		return this.appointment;
	}
	public void setAppointment(ims.scheduling.vo.beans.ReferralAppointmentDetailsBookingAppointmentVoBean value)
	{
		this.appointment = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean tcidate;
	private ims.framework.utils.beans.TimeBean tcitime;
	private ims.scheduling.vo.beans.ReferralAppointmentDetailsBookingAppointmentVoBean appointment;
}
