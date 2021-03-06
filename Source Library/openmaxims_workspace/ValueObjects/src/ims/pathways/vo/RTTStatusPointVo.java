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

package ims.pathways.vo;

/**
 * Linked to Pathways.Configuration.RTTStatusPoint business object (ID: 1089100012).
 */
public class RTTStatusPointVo extends ims.pathways.vo.RTTStatusPointLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public RTTStatusPointVo()
	{
	}
	public RTTStatusPointVo(Integer id, int version)
	{
		super(id, version);
	}
	public RTTStatusPointVo(ims.pathways.vo.beans.RTTStatusPointVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.nationalcode = bean.getNationalCode();
		this.description = bean.getDescription();
		this.localcode = bean.getLocalCode();
		this.children = ims.pathways.vo.RTTStatusPointVoCollection.buildFromBeanCollection(bean.getChildren());
		this.appointmentoutcomes = ims.scheduling.vo.lookups.ApptOutcomeCollection.buildFromBeanCollection(bean.getAppointmentOutcomes());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.pathways.vo.beans.RTTStatusPointVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.nationalcode = bean.getNationalCode();
		this.description = bean.getDescription();
		this.localcode = bean.getLocalCode();
		this.children = ims.pathways.vo.RTTStatusPointVoCollection.buildFromBeanCollection(bean.getChildren());
		this.appointmentoutcomes = ims.scheduling.vo.lookups.ApptOutcomeCollection.buildFromBeanCollection(bean.getAppointmentOutcomes());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.pathways.vo.beans.RTTStatusPointVoBean bean = null;
		if(map != null)
			bean = (ims.pathways.vo.beans.RTTStatusPointVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.pathways.vo.beans.RTTStatusPointVoBean();
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
		if(fieldName.equals("CHILDREN"))
			return getChildren();
		if(fieldName.equals("APPOINTMENTOUTCOMES"))
			return getAppointmentOutcomes();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getChildrenIsNotNull()
	{
		return this.children != null;
	}
	public ims.pathways.vo.RTTStatusPointVoCollection getChildren()
	{
		return this.children;
	}
	public void setChildren(ims.pathways.vo.RTTStatusPointVoCollection value)
	{
		this.isValidated = false;
		this.children = value;
	}
	public boolean getAppointmentOutcomesIsNotNull()
	{
		return this.appointmentoutcomes != null;
	}
	public ims.scheduling.vo.lookups.ApptOutcomeCollection getAppointmentOutcomes()
	{
		return this.appointmentoutcomes;
	}
	public void setAppointmentOutcomes(ims.scheduling.vo.lookups.ApptOutcomeCollection value)
	{
		this.isValidated = false;
		this.appointmentoutcomes = value;
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
		if(this.nationalcode == null)
			listOfErrors.add("NationalCode is mandatory");
		if(this.description == null || this.description.length() == 0)
			listOfErrors.add("Description is mandatory");
		else if(this.description.length() > 250)
			listOfErrors.add("The length of the field [description] in the value object [ims.pathways.vo.RTTStatusPointVo] is too big. It should be less or equal to 250");
		if(this.localcode != null)
			if(this.localcode.length() > 10)
				listOfErrors.add("The length of the field [localcode] in the value object [ims.pathways.vo.RTTStatusPointVo] is too big. It should be less or equal to 10");
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
	
		RTTStatusPointVo clone = new RTTStatusPointVo(this.id, this.version);
		
		clone.nationalcode = this.nationalcode;
		clone.description = this.description;
		clone.localcode = this.localcode;
		if(this.children == null)
			clone.children = null;
		else
			clone.children = (ims.pathways.vo.RTTStatusPointVoCollection)this.children.clone();
		if(this.appointmentoutcomes == null)
			clone.appointmentoutcomes = null;
		else
			clone.appointmentoutcomes = (ims.scheduling.vo.lookups.ApptOutcomeCollection)this.appointmentoutcomes.clone();
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
		if (!(RTTStatusPointVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A RTTStatusPointVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((RTTStatusPointVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((RTTStatusPointVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.children != null)
			count++;
		if(this.appointmentoutcomes != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 2;
	}
	protected ims.pathways.vo.RTTStatusPointVoCollection children;
	protected ims.scheduling.vo.lookups.ApptOutcomeCollection appointmentoutcomes;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
