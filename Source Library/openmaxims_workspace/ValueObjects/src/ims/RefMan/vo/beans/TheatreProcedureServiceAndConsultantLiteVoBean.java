// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.beans;

public class TheatreProcedureServiceAndConsultantLiteVoBean extends ims.vo.ValueObjectBean
{
	public TheatreProcedureServiceAndConsultantLiteVoBean()
	{
	}
	public TheatreProcedureServiceAndConsultantLiteVoBean(ims.RefMan.vo.TheatreProcedureServiceAndConsultantLiteVo vo)
	{
		this.procedure = vo.getProcedure() == null ? null : (ims.core.vo.beans.ProcedureLiteVoBean)vo.getProcedure().getBean();
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean();
		// Interface field type not supported.
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.TheatreProcedureServiceAndConsultantLiteVo vo)
	{
		this.procedure = vo.getProcedure() == null ? null : (ims.core.vo.beans.ProcedureLiteVoBean)vo.getProcedure().getBean(map);
		this.service = vo.getService() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getService().getBean(map);
		// Interface field type not supported.
	}

	public ims.RefMan.vo.TheatreProcedureServiceAndConsultantLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.TheatreProcedureServiceAndConsultantLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.TheatreProcedureServiceAndConsultantLiteVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.TheatreProcedureServiceAndConsultantLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.TheatreProcedureServiceAndConsultantLiteVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.core.vo.beans.ProcedureLiteVoBean getProcedure()
	{
		return this.procedure;
	}
	public void setProcedure(ims.core.vo.beans.ProcedureLiteVoBean value)
	{
		this.procedure = value;
	}
	public ims.core.vo.beans.ServiceLiteVoBean getService()
	{
		return this.service;
	}
	public void setService(ims.core.vo.beans.ServiceLiteVoBean value)
	{
		this.service = value;
	}

	private ims.core.vo.beans.ProcedureLiteVoBean procedure;
	private ims.core.vo.beans.ServiceLiteVoBean service;
}
