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

package ims.clinical.vo.beans;

public class SpecimenIntraOpVoBean extends ims.vo.ValueObjectBean
{
	public SpecimenIntraOpVoBean()
	{
	}
	public SpecimenIntraOpVoBean(ims.clinical.vo.SpecimenIntraOpVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.theatreappointment = vo.getTheatreAppointment() == null ? null : new ims.vo.RefVoBean(vo.getTheatreAppointment().getBoId(), vo.getTheatreAppointment().getBoVersion());
		this.patientprocedure = vo.getPatientProcedure() == null ? null : (ims.core.vo.beans.PatientProcedureMinVoBean)vo.getPatientProcedure().getBean();
		this.specimendestination = vo.getSpecimenDestination() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecimenDestination().getBean();
		this.other = vo.getOther();
		this.details = vo.getDetails();
		this.noofspecimens = vo.getNoOfSpecimens();
		this.isdirect = vo.getIsDirect();
		this.isindirect = vo.getIsIndirect();
		this.typecomments = vo.getTypeComments();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.SpecimenIntraOpVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.theatreappointment = vo.getTheatreAppointment() == null ? null : new ims.vo.RefVoBean(vo.getTheatreAppointment().getBoId(), vo.getTheatreAppointment().getBoVersion());
		this.patientprocedure = vo.getPatientProcedure() == null ? null : (ims.core.vo.beans.PatientProcedureMinVoBean)vo.getPatientProcedure().getBean(map);
		this.specimendestination = vo.getSpecimenDestination() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecimenDestination().getBean();
		this.other = vo.getOther();
		this.details = vo.getDetails();
		this.noofspecimens = vo.getNoOfSpecimens();
		this.isdirect = vo.getIsDirect();
		this.isindirect = vo.getIsIndirect();
		this.typecomments = vo.getTypeComments();
	}

	public ims.clinical.vo.SpecimenIntraOpVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.SpecimenIntraOpVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.SpecimenIntraOpVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.SpecimenIntraOpVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.SpecimenIntraOpVo();
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
	public ims.vo.RefVoBean getTheatreAppointment()
	{
		return this.theatreappointment;
	}
	public void setTheatreAppointment(ims.vo.RefVoBean value)
	{
		this.theatreappointment = value;
	}
	public ims.core.vo.beans.PatientProcedureMinVoBean getPatientProcedure()
	{
		return this.patientprocedure;
	}
	public void setPatientProcedure(ims.core.vo.beans.PatientProcedureMinVoBean value)
	{
		this.patientprocedure = value;
	}
	public ims.vo.LookupInstanceBean getSpecimenDestination()
	{
		return this.specimendestination;
	}
	public void setSpecimenDestination(ims.vo.LookupInstanceBean value)
	{
		this.specimendestination = value;
	}
	public Boolean getOther()
	{
		return this.other;
	}
	public void setOther(Boolean value)
	{
		this.other = value;
	}
	public String getDetails()
	{
		return this.details;
	}
	public void setDetails(String value)
	{
		this.details = value;
	}
	public Integer getNoOfSpecimens()
	{
		return this.noofspecimens;
	}
	public void setNoOfSpecimens(Integer value)
	{
		this.noofspecimens = value;
	}
	public Boolean getIsDirect()
	{
		return this.isdirect;
	}
	public void setIsDirect(Boolean value)
	{
		this.isdirect = value;
	}
	public Boolean getIsIndirect()
	{
		return this.isindirect;
	}
	public void setIsIndirect(Boolean value)
	{
		this.isindirect = value;
	}
	public String getTypeComments()
	{
		return this.typecomments;
	}
	public void setTypeComments(String value)
	{
		this.typecomments = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean theatreappointment;
	private ims.core.vo.beans.PatientProcedureMinVoBean patientprocedure;
	private ims.vo.LookupInstanceBean specimendestination;
	private Boolean other;
	private String details;
	private Integer noofspecimens;
	private Boolean isdirect;
	private Boolean isindirect;
	private String typecomments;
}
