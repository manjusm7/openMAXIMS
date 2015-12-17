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

public class TheatreSessionManagementVoBean extends ims.vo.ValueObjectBean
{
	public TheatreSessionManagementVoBean()
	{
	}
	public TheatreSessionManagementVoBean(ims.scheduling.vo.TheatreSessionManagementVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.sessiondate = vo.getSessionDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getSessionDate().getBean();
		this.starttm = vo.getStartTm() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getStartTm().getBean();
		this.endtm = vo.getEndTm() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getEndTm().getBean();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceShortVoBean)vo.getService().getBean();
		this.sessionstatus = vo.getSessionStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getSessionStatus().getBean();
		this.remainingslots = vo.getRemainingSlots();
		this.totalslots = vo.getTotalSlots();
		this.isfixed = vo.getIsFixed();
		this.remainingtime = vo.getRemainingTime();
		this.schlocation = vo.getSchLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getSchLocation().getBean();
		this.wassessionmoved = vo.getWasSessionMoved();
		this.sessioncomment = vo.getSessionComment();
		this.listtype = vo.getListType() == null ? null : (ims.vo.LookupInstanceBean)vo.getListType().getBean();
		this.responsiblehcp = vo.getResponsibleHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsibleHCP().getBean();
		this.slottype = vo.getSlotType() == null ? null : (ims.vo.LookupInstanceBean)vo.getSlotType().getBean();
		this.sessionprofiletype = vo.getSessionProfileType() == null ? null : (ims.vo.LookupInstanceBean)vo.getSessionProfileType().getBean();
		this.listowners = vo.getListOwners() == null ? null : vo.getListOwners().getBeanCollection();
		this.sessionmove = vo.getSessionMove() == null ? null : vo.getSessionMove().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.TheatreSessionManagementVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.name = vo.getName();
		this.sessiondate = vo.getSessionDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getSessionDate().getBean();
		this.starttm = vo.getStartTm() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getStartTm().getBean();
		this.endtm = vo.getEndTm() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getEndTm().getBean();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceShortVoBean)vo.getService().getBean(map);
		this.sessionstatus = vo.getSessionStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getSessionStatus().getBean();
		this.remainingslots = vo.getRemainingSlots();
		this.totalslots = vo.getTotalSlots();
		this.isfixed = vo.getIsFixed();
		this.remainingtime = vo.getRemainingTime();
		this.schlocation = vo.getSchLocation() == null ? null : (ims.core.vo.beans.LocationLiteVoBean)vo.getSchLocation().getBean(map);
		this.wassessionmoved = vo.getWasSessionMoved();
		this.sessioncomment = vo.getSessionComment();
		this.listtype = vo.getListType() == null ? null : (ims.vo.LookupInstanceBean)vo.getListType().getBean();
		this.responsiblehcp = vo.getResponsibleHCP() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getResponsibleHCP().getBean(map);
		this.slottype = vo.getSlotType() == null ? null : (ims.vo.LookupInstanceBean)vo.getSlotType().getBean();
		this.sessionprofiletype = vo.getSessionProfileType() == null ? null : (ims.vo.LookupInstanceBean)vo.getSessionProfileType().getBean();
		this.listowners = vo.getListOwners() == null ? null : vo.getListOwners().getBeanCollection();
		this.sessionmove = vo.getSessionMove() == null ? null : vo.getSessionMove().getBeanCollection();
	}

	public ims.scheduling.vo.TheatreSessionManagementVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.TheatreSessionManagementVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.TheatreSessionManagementVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.TheatreSessionManagementVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.TheatreSessionManagementVo();
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
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public ims.framework.utils.beans.DateBean getSessionDate()
	{
		return this.sessiondate;
	}
	public void setSessionDate(ims.framework.utils.beans.DateBean value)
	{
		this.sessiondate = value;
	}
	public ims.framework.utils.beans.TimeBean getStartTm()
	{
		return this.starttm;
	}
	public void setStartTm(ims.framework.utils.beans.TimeBean value)
	{
		this.starttm = value;
	}
	public ims.framework.utils.beans.TimeBean getEndTm()
	{
		return this.endtm;
	}
	public void setEndTm(ims.framework.utils.beans.TimeBean value)
	{
		this.endtm = value;
	}
	public ims.core.vo.beans.ServiceShortVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.beans.ServiceShortVoBean value)
	{
		this.service = value;
	}
	public ims.vo.LookupInstanceBean getSessionStatus()
	{
		return this.sessionstatus;
	}
	public void setSessionStatus(ims.vo.LookupInstanceBean value)
	{
		this.sessionstatus = value;
	}
	public Integer getRemainingSlots()
	{
		return this.remainingslots;
	}
	public void setRemainingSlots(Integer value)
	{
		this.remainingslots = value;
	}
	public Integer getTotalSlots()
	{
		return this.totalslots;
	}
	public void setTotalSlots(Integer value)
	{
		this.totalslots = value;
	}
	public Boolean getIsFixed()
	{
		return this.isfixed;
	}
	public void setIsFixed(Boolean value)
	{
		this.isfixed = value;
	}
	public Integer getRemainingTime()
	{
		return this.remainingtime;
	}
	public void setRemainingTime(Integer value)
	{
		this.remainingtime = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean getSchLocation()
	{
		return this.schlocation;
	}
	public void setSchLocation(ims.core.vo.beans.LocationLiteVoBean value)
	{
		this.schlocation = value;
	}
	public Boolean getWasSessionMoved()
	{
		return this.wassessionmoved;
	}
	public void setWasSessionMoved(Boolean value)
	{
		this.wassessionmoved = value;
	}
	public String getSessionComment()
	{
		return this.sessioncomment;
	}
	public void setSessionComment(String value)
	{
		this.sessioncomment = value;
	}
	public ims.vo.LookupInstanceBean getListType()
	{
		return this.listtype;
	}
	public void setListType(ims.vo.LookupInstanceBean value)
	{
		this.listtype = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getResponsibleHCP()
	{
		return this.responsiblehcp;
	}
	public void setResponsibleHCP(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.responsiblehcp = value;
	}
	public ims.vo.LookupInstanceBean getSlotType()
	{
		return this.slottype;
	}
	public void setSlotType(ims.vo.LookupInstanceBean value)
	{
		this.slottype = value;
	}
	public ims.vo.LookupInstanceBean getSessionProfileType()
	{
		return this.sessionprofiletype;
	}
	public void setSessionProfileType(ims.vo.LookupInstanceBean value)
	{
		this.sessionprofiletype = value;
	}
	public ims.scheduling.vo.beans.Session_ListOwnerVoBean[] getListOwners()
	{
		return this.listowners;
	}
	public void setListOwners(ims.scheduling.vo.beans.Session_ListOwnerVoBean[] value)
	{
		this.listowners = value;
	}
	public ims.scheduling.vo.beans.SessionMoveVoBean[] getSessionMove()
	{
		return this.sessionmove;
	}
	public void setSessionMove(ims.scheduling.vo.beans.SessionMoveVoBean[] value)
	{
		this.sessionmove = value;
	}

	private Integer id;
	private int version;
	private String name;
	private ims.framework.utils.beans.DateBean sessiondate;
	private ims.framework.utils.beans.TimeBean starttm;
	private ims.framework.utils.beans.TimeBean endtm;
	private ims.core.vo.beans.ServiceShortVoBean service;
	private ims.vo.LookupInstanceBean sessionstatus;
	private Integer remainingslots;
	private Integer totalslots;
	private Boolean isfixed;
	private Integer remainingtime;
	private ims.core.vo.beans.LocationLiteVoBean schlocation;
	private Boolean wassessionmoved;
	private String sessioncomment;
	private ims.vo.LookupInstanceBean listtype;
	private ims.core.vo.beans.HcpLiteVoBean responsiblehcp;
	private ims.vo.LookupInstanceBean slottype;
	private ims.vo.LookupInstanceBean sessionprofiletype;
	private ims.scheduling.vo.beans.Session_ListOwnerVoBean[] listowners;
	private ims.scheduling.vo.beans.SessionMoveVoBean[] sessionmove;
}