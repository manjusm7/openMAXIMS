//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.assessment.vo.beans;

public class PatientGraphicAssessmentFindingVoBean extends ims.vo.ValueObjectBean
{
	public PatientGraphicAssessmentFindingVoBean()
	{
	}
	public PatientGraphicAssessmentFindingVoBean(ims.assessment.vo.PatientGraphicAssessmentFindingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.drawingid = vo.getDrawingId();
		this.graphicfinding = vo.getGraphicFinding() == null ? null : (ims.core.vo.beans.DrawingGraphicFindingVoBean)vo.getGraphicFinding().getBean();
		this.areadrawn = vo.getAreaDrawn();
		this.areaname = vo.getAreaName();
		this.areadetails = vo.getAreaDetails();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.iscopied = vo.getIsCopied();
		this.stage = vo.getStage() == null ? null : vo.getStage().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.PatientGraphicAssessmentFindingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.drawingid = vo.getDrawingId();
		this.graphicfinding = vo.getGraphicFinding() == null ? null : (ims.core.vo.beans.DrawingGraphicFindingVoBean)vo.getGraphicFinding().getBean(map);
		this.areadrawn = vo.getAreaDrawn();
		this.areaname = vo.getAreaName();
		this.areadetails = vo.getAreaDetails();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.iscopied = vo.getIsCopied();
		this.stage = vo.getStage() == null ? null : vo.getStage().getBeanCollection();
	}

	public ims.assessment.vo.PatientGraphicAssessmentFindingVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.assessment.vo.PatientGraphicAssessmentFindingVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.PatientGraphicAssessmentFindingVo vo = null;
		if(map != null)
			vo = (ims.assessment.vo.PatientGraphicAssessmentFindingVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.assessment.vo.PatientGraphicAssessmentFindingVo();
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
	public Integer getDrawingId()
	{
		return this.drawingid;
	}
	public void setDrawingId(Integer value)
	{
		this.drawingid = value;
	}
	public ims.core.vo.beans.DrawingGraphicFindingVoBean getGraphicFinding()
	{
		return this.graphicfinding;
	}
	public void setGraphicFinding(ims.core.vo.beans.DrawingGraphicFindingVoBean value)
	{
		this.graphicfinding = value;
	}
	public String getAreaDrawn()
	{
		return this.areadrawn;
	}
	public void setAreaDrawn(String value)
	{
		this.areadrawn = value;
	}
	public String getAreaName()
	{
		return this.areaname;
	}
	public void setAreaName(String value)
	{
		this.areaname = value;
	}
	public String getAreaDetails()
	{
		return this.areadetails;
	}
	public void setAreaDetails(String value)
	{
		this.areadetails = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public Boolean getIsCopied()
	{
		return this.iscopied;
	}
	public void setIsCopied(Boolean value)
	{
		this.iscopied = value;
	}
	public ims.assessment.vo.beans.PatientGraphicalAssessmentStageVoBean[] getStage()
	{
		return this.stage;
	}
	public void setStage(ims.assessment.vo.beans.PatientGraphicalAssessmentStageVoBean[] value)
	{
		this.stage = value;
	}

	private Integer id;
	private int version;
	private Integer drawingid;
	private ims.core.vo.beans.DrawingGraphicFindingVoBean graphicfinding;
	private String areadrawn;
	private String areaname;
	private String areadetails;
	private ims.vo.SysInfoBean sysinfo;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private Boolean iscopied;
	private ims.assessment.vo.beans.PatientGraphicalAssessmentStageVoBean[] stage;
}