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

package ims.RefMan.vo;

/**
 * Linked to RefMan.CancerTypeItemConfig business object (ID: 1096100072).
 */
public class CancerTypeItemConfigVo extends ims.RefMan.vo.CancerTypeItemConfigRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CancerTypeItemConfigVo()
	{
	}
	public CancerTypeItemConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public CancerTypeItemConfigVo(ims.RefMan.vo.beans.CancerTypeItemConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.cancertype = bean.getCancerType() == null ? null : ims.RefMan.vo.lookups.CancerType.buildLookup(bean.getCancerType());
		this.day31target = bean.getDay31Target();
		this.day62target = bean.getDay62Target();
		this.availablefornationalscreening = bean.getAvailableForNationalScreening();
		this.noreferralletterrequired = bean.getNoReferralLetterRequired();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.CancerTypeItemConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.cancertype = bean.getCancerType() == null ? null : ims.RefMan.vo.lookups.CancerType.buildLookup(bean.getCancerType());
		this.day31target = bean.getDay31Target();
		this.day62target = bean.getDay62Target();
		this.availablefornationalscreening = bean.getAvailableForNationalScreening();
		this.noreferralletterrequired = bean.getNoReferralLetterRequired();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.CancerTypeItemConfigVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.CancerTypeItemConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.CancerTypeItemConfigVoBean();
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
		if(fieldName.equals("CANCERTYPE"))
			return getCancerType();
		if(fieldName.equals("DAY31TARGET"))
			return getDay31Target();
		if(fieldName.equals("DAY62TARGET"))
			return getDay62Target();
		if(fieldName.equals("AVAILABLEFORNATIONALSCREENING"))
			return getAvailableForNationalScreening();
		if(fieldName.equals("NOREFERRALLETTERREQUIRED"))
			return getNoReferralLetterRequired();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCancerTypeIsNotNull()
	{
		return this.cancertype != null;
	}
	public ims.RefMan.vo.lookups.CancerType getCancerType()
	{
		return this.cancertype;
	}
	public void setCancerType(ims.RefMan.vo.lookups.CancerType value)
	{
		this.isValidated = false;
		this.cancertype = value;
	}
	public boolean getDay31TargetIsNotNull()
	{
		return this.day31target != null;
	}
	public Boolean getDay31Target()
	{
		return this.day31target;
	}
	public void setDay31Target(Boolean value)
	{
		this.isValidated = false;
		this.day31target = value;
	}
	public boolean getDay62TargetIsNotNull()
	{
		return this.day62target != null;
	}
	public Boolean getDay62Target()
	{
		return this.day62target;
	}
	public void setDay62Target(Boolean value)
	{
		this.isValidated = false;
		this.day62target = value;
	}
	public boolean getAvailableForNationalScreeningIsNotNull()
	{
		return this.availablefornationalscreening != null;
	}
	public Boolean getAvailableForNationalScreening()
	{
		return this.availablefornationalscreening;
	}
	public void setAvailableForNationalScreening(Boolean value)
	{
		this.isValidated = false;
		this.availablefornationalscreening = value;
	}
	public boolean getNoReferralLetterRequiredIsNotNull()
	{
		return this.noreferralletterrequired != null;
	}
	public Boolean getNoReferralLetterRequired()
	{
		return this.noreferralletterrequired;
	}
	public void setNoReferralLetterRequired(Boolean value)
	{
		this.isValidated = false;
		this.noreferralletterrequired = value;
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
	
		CancerTypeItemConfigVo clone = new CancerTypeItemConfigVo(this.id, this.version);
		
		if(this.cancertype == null)
			clone.cancertype = null;
		else
			clone.cancertype = (ims.RefMan.vo.lookups.CancerType)this.cancertype.clone();
		clone.day31target = this.day31target;
		clone.day62target = this.day62target;
		clone.availablefornationalscreening = this.availablefornationalscreening;
		clone.noreferralletterrequired = this.noreferralletterrequired;
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
		if (!(CancerTypeItemConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CancerTypeItemConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CancerTypeItemConfigVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CancerTypeItemConfigVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.cancertype != null)
			count++;
		if(this.day31target != null)
			count++;
		if(this.day62target != null)
			count++;
		if(this.availablefornationalscreening != null)
			count++;
		if(this.noreferralletterrequired != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.RefMan.vo.lookups.CancerType cancertype;
	protected Boolean day31target;
	protected Boolean day62target;
	protected Boolean availablefornationalscreening;
	protected Boolean noreferralletterrequired;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
