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

package ims.RefMan.vo.beans;

public class BookTheatreSearchCriteriaVoBean extends ims.vo.ValueObjectBean
{
	public BookTheatreSearchCriteriaVoBean()
	{
	}
	public BookTheatreSearchCriteriaVoBean(ims.RefMan.vo.BookTheatreSearchCriteriaVo vo)
	{
		this.fromdate = vo.getFromDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getFromDate().getBean();
		this.todate = vo.getToDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getToDate().getBean();
		this.hospital = vo.getHospital() == null ? null : new ims.vo.RefVoBean(vo.getHospital().getBoId(), vo.getHospital().getBoVersion());
		this.service = vo.getService() == null ? null : new ims.vo.RefVoBean(vo.getService().getBoId(), vo.getService().getBoVersion());
		// Interface field type not supported.
		// Interface field type not supported.
		// Interface field type not supported.
		this.listtype = vo.getListType() == null ? null : (ims.vo.LookupInstanceBean)vo.getListType().getBean();
		this.theatretype = vo.getTheatreType() == null ? null : (ims.vo.LookupInstanceBean)vo.getTheatreType().getBean();
		this.anaesthetictype = vo.getAnaestheticType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAnaestheticType().getBean();
		this.timerequired = vo.getTimeRequired();
		this.allowoverbook = vo.getAllowOverBook();
		this.multiservicecase = vo.getMultiServiceCase();
		this.nogasessions = vo.getNoGASessions();
		this.theatre = vo.getTheatre() == null ? null : new ims.vo.RefVoBean(vo.getTheatre().getBoId(), vo.getTheatre().getBoVersion());
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.BookTheatreSearchCriteriaVo vo)
	{
		this.fromdate = vo.getFromDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getFromDate().getBean();
		this.todate = vo.getToDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getToDate().getBean();
		this.hospital = vo.getHospital() == null ? null : new ims.vo.RefVoBean(vo.getHospital().getBoId(), vo.getHospital().getBoVersion());
		this.service = vo.getService() == null ? null : new ims.vo.RefVoBean(vo.getService().getBoId(), vo.getService().getBoVersion());
		// Interface field type not supported.
		// Interface field type not supported.
		// Interface field type not supported.
		this.listtype = vo.getListType() == null ? null : (ims.vo.LookupInstanceBean)vo.getListType().getBean();
		this.theatretype = vo.getTheatreType() == null ? null : (ims.vo.LookupInstanceBean)vo.getTheatreType().getBean();
		this.anaesthetictype = vo.getAnaestheticType() == null ? null : (ims.vo.LookupInstanceBean)vo.getAnaestheticType().getBean();
		this.timerequired = vo.getTimeRequired();
		this.allowoverbook = vo.getAllowOverBook();
		this.multiservicecase = vo.getMultiServiceCase();
		this.nogasessions = vo.getNoGASessions();
		this.theatre = vo.getTheatre() == null ? null : new ims.vo.RefVoBean(vo.getTheatre().getBoId(), vo.getTheatre().getBoVersion());
	}

	public ims.RefMan.vo.BookTheatreSearchCriteriaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.BookTheatreSearchCriteriaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.BookTheatreSearchCriteriaVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.BookTheatreSearchCriteriaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.BookTheatreSearchCriteriaVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.framework.utils.beans.DateBean getFromDate()
	{
		return this.fromdate;
	}
	public void setFromDate(ims.framework.utils.beans.DateBean value)
	{
		this.fromdate = value;
	}
	public ims.framework.utils.beans.DateBean getToDate()
	{
		return this.todate;
	}
	public void setToDate(ims.framework.utils.beans.DateBean value)
	{
		this.todate = value;
	}
	public ims.vo.RefVoBean getHospital()
	{
		return this.hospital;
	}
	public void setHospital(ims.vo.RefVoBean value)
	{
		this.hospital = value;
	}
	public ims.vo.RefVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.vo.RefVoBean value)
	{
		this.service = value;
	}
	public ims.vo.LookupInstanceBean getListType()
	{
		return this.listtype;
	}
	public void setListType(ims.vo.LookupInstanceBean value)
	{
		this.listtype = value;
	}
	public ims.vo.LookupInstanceBean getTheatreType()
	{
		return this.theatretype;
	}
	public void setTheatreType(ims.vo.LookupInstanceBean value)
	{
		this.theatretype = value;
	}
	public ims.vo.LookupInstanceBean getAnaestheticType()
	{
		return this.anaesthetictype;
	}
	public void setAnaestheticType(ims.vo.LookupInstanceBean value)
	{
		this.anaesthetictype = value;
	}
	public Integer getTimeRequired()
	{
		return this.timerequired;
	}
	public void setTimeRequired(Integer value)
	{
		this.timerequired = value;
	}
	public Boolean getAllowOverBook()
	{
		return this.allowoverbook;
	}
	public void setAllowOverBook(Boolean value)
	{
		this.allowoverbook = value;
	}
	public Boolean getMultiServiceCase()
	{
		return this.multiservicecase;
	}
	public void setMultiServiceCase(Boolean value)
	{
		this.multiservicecase = value;
	}
	public Boolean getNoGASessions()
	{
		return this.nogasessions;
	}
	public void setNoGASessions(Boolean value)
	{
		this.nogasessions = value;
	}
	public ims.vo.RefVoBean getTheatre()
	{
		return this.theatre;
	}
	public void setTheatre(ims.vo.RefVoBean value)
	{
		this.theatre = value;
	}

	private ims.framework.utils.beans.DateBean fromdate;
	private ims.framework.utils.beans.DateBean todate;
	private ims.vo.RefVoBean hospital;
	private ims.vo.RefVoBean service;
	private ims.vo.LookupInstanceBean listtype;
	private ims.vo.LookupInstanceBean theatretype;
	private ims.vo.LookupInstanceBean anaesthetictype;
	private Integer timerequired;
	private Boolean allowoverbook;
	private Boolean multiservicecase;
	private Boolean nogasessions;
	private ims.vo.RefVoBean theatre;
}
