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

package ims.emergency.vo;

/**
 * Linked to emergency.Triage business object (ID: 1086100004).
 */
public class TriageForTrackingWhiteVo extends ims.emergency.vo.TriageRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TriageForTrackingWhiteVo()
	{
	}
	public TriageForTrackingWhiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public TriageForTrackingWhiteVo(ims.emergency.vo.beans.TriageForTrackingWhiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.mainpresentingproblem = bean.getMainPresentingProblem() == null ? null : bean.getMainPresentingProblem().buildVo();
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
		this.currenttriagepriority = bean.getCurrentTriagePriority() == null ? null : ims.emergency.vo.lookups.TriagePriority.buildLookup(bean.getCurrentTriagePriority());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.TriageForTrackingWhiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.mainpresentingproblem = bean.getMainPresentingProblem() == null ? null : bean.getMainPresentingProblem().buildVo(map);
		this.attendance = bean.getAttendance() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getAttendance().getId()), bean.getAttendance().getVersion());
		this.episode = bean.getEpisode() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisode().getId()), bean.getEpisode().getVersion());
		this.currenttriagepriority = bean.getCurrentTriagePriority() == null ? null : ims.emergency.vo.lookups.TriagePriority.buildLookup(bean.getCurrentTriagePriority());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.TriageForTrackingWhiteVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.TriageForTrackingWhiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.TriageForTrackingWhiteVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("MAINPRESENTINGPROBLEM"))
			return getMainPresentingProblem();
		if(fieldName.equals("ATTENDANCE"))
			return getAttendance();
		if(fieldName.equals("EPISODE"))
			return getEpisode();
		if(fieldName.equals("CURRENTTRIAGEPRIORITY"))
			return getCurrentTriagePriority();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getMainPresentingProblemIsNotNull()
	{
		return this.mainpresentingproblem != null;
	}
	public ims.emergency.vo.PatientProblemForClinicianWorklistVo getMainPresentingProblem()
	{
		return this.mainpresentingproblem;
	}
	public void setMainPresentingProblem(ims.emergency.vo.PatientProblemForClinicianWorklistVo value)
	{
		this.isValidated = false;
		this.mainpresentingproblem = value;
	}
	public boolean getAttendanceIsNotNull()
	{
		return this.attendance != null;
	}
	public ims.core.admin.vo.CareContextRefVo getAttendance()
	{
		return this.attendance;
	}
	public void setAttendance(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.attendance = value;
	}
	public boolean getEpisodeIsNotNull()
	{
		return this.episode != null;
	}
	public ims.core.admin.vo.EpisodeOfCareRefVo getEpisode()
	{
		return this.episode;
	}
	public void setEpisode(ims.core.admin.vo.EpisodeOfCareRefVo value)
	{
		this.isValidated = false;
		this.episode = value;
	}
	public boolean getCurrentTriagePriorityIsNotNull()
	{
		return this.currenttriagepriority != null;
	}
	public ims.emergency.vo.lookups.TriagePriority getCurrentTriagePriority()
	{
		return this.currenttriagepriority;
	}
	public void setCurrentTriagePriority(ims.emergency.vo.lookups.TriagePriority value)
	{
		this.isValidated = false;
		this.currenttriagepriority = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.mainpresentingproblem != null)
		{
			if(!this.mainpresentingproblem.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.mainpresentingproblem != null)
		{
			String[] listOfOtherErrors = this.mainpresentingproblem.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.attendance == null)
			listOfErrors.add("Attendance is mandatory");
		if(this.episode == null)
			listOfErrors.add("Episode is mandatory");
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		TriageForTrackingWhiteVo clone = new TriageForTrackingWhiteVo(this.id, this.version);
		
		if(this.mainpresentingproblem == null)
			clone.mainpresentingproblem = null;
		else
			clone.mainpresentingproblem = (ims.emergency.vo.PatientProblemForClinicianWorklistVo)this.mainpresentingproblem.clone();
		clone.attendance = this.attendance;
		clone.episode = this.episode;
		if(this.currenttriagepriority == null)
			clone.currenttriagepriority = null;
		else
			clone.currenttriagepriority = (ims.emergency.vo.lookups.TriagePriority)this.currenttriagepriority.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(TriageForTrackingWhiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TriageForTrackingWhiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TriageForTrackingWhiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TriageForTrackingWhiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.mainpresentingproblem != null)
			count++;
		if(this.attendance != null)
			count++;
		if(this.episode != null)
			count++;
		if(this.currenttriagepriority != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.emergency.vo.PatientProblemForClinicianWorklistVo mainpresentingproblem;
	protected ims.core.admin.vo.CareContextRefVo attendance;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episode;
	protected ims.emergency.vo.lookups.TriagePriority currenttriagepriority;
	private boolean isValidated = false;
	private boolean isBusy = false;
}