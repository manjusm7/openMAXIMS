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

package ims.core.vo;

/**
 * Linked to core.clinical.SocialHistoryMaritalStatus business object (ID: 1003100054).
 */
public class SocialHistoryMaritalStatusVo extends ims.core.clinical.vo.SocialHistoryMaritalStatusRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SocialHistoryMaritalStatusVo()
	{
	}
	public SocialHistoryMaritalStatusVo(Integer id, int version)
	{
		super(id, version);
	}
	public SocialHistoryMaritalStatusVo(ims.core.vo.beans.SocialHistoryMaritalStatusVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.maritalstatus = bean.getMaritalStatus() == null ? null : ims.core.vo.lookups.MaritalStatus.buildLookup(bean.getMaritalStatus());
		this.statusdate = bean.getStatusDate() == null ? null : bean.getStatusDate().buildPartialDate();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.SocialHistoryMaritalStatusVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.maritalstatus = bean.getMaritalStatus() == null ? null : ims.core.vo.lookups.MaritalStatus.buildLookup(bean.getMaritalStatus());
		this.statusdate = bean.getStatusDate() == null ? null : bean.getStatusDate().buildPartialDate();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.SocialHistoryMaritalStatusVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.SocialHistoryMaritalStatusVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.SocialHistoryMaritalStatusVoBean();
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
		if(fieldName.equals("MARITALSTATUS"))
			return getMaritalStatus();
		if(fieldName.equals("STATUSDATE"))
			return getStatusDate();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getMaritalStatusIsNotNull()
	{
		return this.maritalstatus != null;
	}
	public ims.core.vo.lookups.MaritalStatus getMaritalStatus()
	{
		return this.maritalstatus;
	}
	public void setMaritalStatus(ims.core.vo.lookups.MaritalStatus value)
	{
		this.isValidated = false;
		this.maritalstatus = value;
	}
	public boolean getStatusDateIsNotNull()
	{
		return this.statusdate != null;
	}
	public ims.framework.utils.PartialDate getStatusDate()
	{
		return this.statusdate;
	}
	public void setStatusDate(ims.framework.utils.PartialDate value)
	{
		this.isValidated = false;
		this.statusdate = value;
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
	
		SocialHistoryMaritalStatusVo clone = new SocialHistoryMaritalStatusVo(this.id, this.version);
		
		if(this.maritalstatus == null)
			clone.maritalstatus = null;
		else
			clone.maritalstatus = (ims.core.vo.lookups.MaritalStatus)this.maritalstatus.clone();
		if(this.statusdate == null)
			clone.statusdate = null;
		else
			clone.statusdate = (ims.framework.utils.PartialDate)this.statusdate.clone();
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
		if (!(SocialHistoryMaritalStatusVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SocialHistoryMaritalStatusVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		SocialHistoryMaritalStatusVo compareObj = (SocialHistoryMaritalStatusVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_SocialHistoryMaritalStatus() == null && compareObj.getID_SocialHistoryMaritalStatus() != null)
				return -1;
			if(this.getID_SocialHistoryMaritalStatus() != null && compareObj.getID_SocialHistoryMaritalStatus() == null)
				return 1;
			if(this.getID_SocialHistoryMaritalStatus() != null && compareObj.getID_SocialHistoryMaritalStatus() != null)
				retVal = this.getID_SocialHistoryMaritalStatus().compareTo(compareObj.getID_SocialHistoryMaritalStatus());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.maritalstatus != null)
			count++;
		if(this.statusdate != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.core.vo.lookups.MaritalStatus maritalstatus;
	protected ims.framework.utils.PartialDate statusdate;
	private boolean isValidated = false;
	private boolean isBusy = false;
}