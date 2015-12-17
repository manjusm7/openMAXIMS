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

package ims.scheduling.vo.beans;

public class AppointmentOutcomeDetailsVoBean extends ims.vo.ValueObjectBean
{
	public AppointmentOutcomeDetailsVoBean()
	{
	}
	public AppointmentOutcomeDetailsVoBean(ims.scheduling.vo.AppointmentOutcomeDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionForClinicNameVoBean)vo.getSession().getBean();
		this.rttclockimpact = vo.getRTTClockImpact() == null ? null : new ims.vo.RefVoBean(vo.getRTTClockImpact().getBoId(), vo.getRTTClockImpact().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.AppointmentOutcomeDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.appointmentdate = vo.getAppointmentDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getAppointmentDate().getBean();
		this.apptstarttime = vo.getApptStartTime() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getApptStartTime().getBean();
		this.session = vo.getSession() == null ? null : (ims.scheduling.vo.beans.SessionForClinicNameVoBean)vo.getSession().getBean(map);
		this.rttclockimpact = vo.getRTTClockImpact() == null ? null : new ims.vo.RefVoBean(vo.getRTTClockImpact().getBoId(), vo.getRTTClockImpact().getBoVersion());
	}

	public ims.scheduling.vo.AppointmentOutcomeDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.AppointmentOutcomeDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.AppointmentOutcomeDetailsVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.AppointmentOutcomeDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.AppointmentOutcomeDetailsVo();
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
	public ims.framework.utils.beans.DateBean getAppointmentDate()
	{
		return this.appointmentdate;
	}
	public void setAppointmentDate(ims.framework.utils.beans.DateBean value)
	{
		this.appointmentdate = value;
	}
	public ims.framework.utils.beans.TimeBean getApptStartTime()
	{
		return this.apptstarttime;
	}
	public void setApptStartTime(ims.framework.utils.beans.TimeBean value)
	{
		this.apptstarttime = value;
	}
	public ims.scheduling.vo.beans.SessionForClinicNameVoBean getSession()
	{
		return this.session;
	}
	public void setSession(ims.scheduling.vo.beans.SessionForClinicNameVoBean value)
	{
		this.session = value;
	}
	public ims.vo.RefVoBean getRTTClockImpact()
	{
		return this.rttclockimpact;
	}
	public void setRTTClockImpact(ims.vo.RefVoBean value)
	{
		this.rttclockimpact = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean appointmentdate;
	private ims.framework.utils.beans.TimeBean apptstarttime;
	private ims.scheduling.vo.beans.SessionForClinicNameVoBean session;
	private ims.vo.RefVoBean rttclockimpact;
}