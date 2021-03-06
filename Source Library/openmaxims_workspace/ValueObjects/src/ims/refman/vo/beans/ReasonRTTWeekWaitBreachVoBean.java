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

public class ReasonRTTWeekWaitBreachVoBean extends ims.vo.ValueObjectBean
{
	public ReasonRTTWeekWaitBreachVoBean()
	{
	}
	public ReasonRTTWeekWaitBreachVoBean(ims.RefMan.vo.ReasonRTTWeekWaitBreachVo vo)
	{
		this.reason = vo.getReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getReason().getBean();
		this.comment = vo.getComment();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.ReasonRTTWeekWaitBreachVo vo)
	{
		this.reason = vo.getReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getReason().getBean();
		this.comment = vo.getComment();
	}

	public ims.RefMan.vo.ReasonRTTWeekWaitBreachVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.ReasonRTTWeekWaitBreachVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.ReasonRTTWeekWaitBreachVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.ReasonRTTWeekWaitBreachVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.ReasonRTTWeekWaitBreachVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.vo.LookupInstanceBean getReason()
	{
		return this.reason;
	}
	public void setReason(ims.vo.LookupInstanceBean value)
	{
		this.reason = value;
	}
	public String getComment()
	{
		return this.comment;
	}
	public void setComment(String value)
	{
		this.comment = value;
	}

	private ims.vo.LookupInstanceBean reason;
	private String comment;
}
