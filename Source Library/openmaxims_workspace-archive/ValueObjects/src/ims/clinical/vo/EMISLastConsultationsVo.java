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

package ims.clinical.vo;


public class EMISLastConsultationsVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EMISLastConsultationsVo()
	{
	}
	public EMISLastConsultationsVo(ims.clinical.vo.beans.EMISLastConsultationsVoBean bean)
	{
		this.consultation = bean.getConsultation();
		this.effectivedate = bean.getEffectiveDate();
		this.authorisinghcp = bean.getAuthorisingHCP();
		this.locationtypedescription = bean.getLocationTypeDescription();
		this.confidentialitypolicy = bean.getConfidentialityPolicy();
		this.consultationtypeoriginalterm = bean.getConsultationTypeOriginalTerm();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.EMISLastConsultationsVoBean bean)
	{
		this.consultation = bean.getConsultation();
		this.effectivedate = bean.getEffectiveDate();
		this.authorisinghcp = bean.getAuthorisingHCP();
		this.locationtypedescription = bean.getLocationTypeDescription();
		this.confidentialitypolicy = bean.getConfidentialityPolicy();
		this.consultationtypeoriginalterm = bean.getConsultationTypeOriginalTerm();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.EMISLastConsultationsVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.EMISLastConsultationsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.EMISLastConsultationsVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getConsultationIsNotNull()
	{
		return this.consultation != null;
	}
	public String getConsultation()
	{
		return this.consultation;
	}
	public static int getConsultationMaxLength()
	{
		return 255;
	}
	public void setConsultation(String value)
	{
		this.isValidated = false;
		this.consultation = value;
	}
	public boolean getEffectiveDateIsNotNull()
	{
		return this.effectivedate != null;
	}
	public String getEffectiveDate()
	{
		return this.effectivedate;
	}
	public static int getEffectiveDateMaxLength()
	{
		return 255;
	}
	public void setEffectiveDate(String value)
	{
		this.isValidated = false;
		this.effectivedate = value;
	}
	public boolean getAuthorisingHCPIsNotNull()
	{
		return this.authorisinghcp != null;
	}
	public String getAuthorisingHCP()
	{
		return this.authorisinghcp;
	}
	public static int getAuthorisingHCPMaxLength()
	{
		return 255;
	}
	public void setAuthorisingHCP(String value)
	{
		this.isValidated = false;
		this.authorisinghcp = value;
	}
	public boolean getLocationTypeDescriptionIsNotNull()
	{
		return this.locationtypedescription != null;
	}
	public String getLocationTypeDescription()
	{
		return this.locationtypedescription;
	}
	public static int getLocationTypeDescriptionMaxLength()
	{
		return 255;
	}
	public void setLocationTypeDescription(String value)
	{
		this.isValidated = false;
		this.locationtypedescription = value;
	}
	public boolean getConfidentialityPolicyIsNotNull()
	{
		return this.confidentialitypolicy != null;
	}
	public String getConfidentialityPolicy()
	{
		return this.confidentialitypolicy;
	}
	public static int getConfidentialityPolicyMaxLength()
	{
		return 255;
	}
	public void setConfidentialityPolicy(String value)
	{
		this.isValidated = false;
		this.confidentialitypolicy = value;
	}
	public boolean getConsultationTypeOriginalTermIsNotNull()
	{
		return this.consultationtypeoriginalterm != null;
	}
	public String getConsultationTypeOriginalTerm()
	{
		return this.consultationtypeoriginalterm;
	}
	public static int getConsultationTypeOriginalTermMaxLength()
	{
		return 255;
	}
	public void setConsultationTypeOriginalTerm(String value)
	{
		this.isValidated = false;
		this.consultationtypeoriginalterm = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof EMISLastConsultationsVo))
			return false;
		EMISLastConsultationsVo compareObj = (EMISLastConsultationsVo)obj;
		if(this.getConsultation() == null && compareObj.getConsultation() != null)
			return false;
		if(this.getConsultation() != null && compareObj.getConsultation() == null)
			return false;
		if(this.getConsultation() != null && compareObj.getConsultation() != null)
			return this.getConsultation().equals(compareObj.getConsultation());
		return super.equals(obj);
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		EMISLastConsultationsVo clone = new EMISLastConsultationsVo();
		
		clone.consultation = this.consultation;
		clone.effectivedate = this.effectivedate;
		clone.authorisinghcp = this.authorisinghcp;
		clone.locationtypedescription = this.locationtypedescription;
		clone.confidentialitypolicy = this.confidentialitypolicy;
		clone.consultationtypeoriginalterm = this.consultationtypeoriginalterm;
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
		if (!(EMISLastConsultationsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EMISLastConsultationsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		EMISLastConsultationsVo compareObj = (EMISLastConsultationsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getConsultation() == null && compareObj.getConsultation() != null)
				return -1;
			if(this.getConsultation() != null && compareObj.getConsultation() == null)
				return 1;
			if(this.getConsultation() != null && compareObj.getConsultation() != null)
			{
				if(caseInsensitive)
					retVal = this.getConsultation().toLowerCase().compareTo(compareObj.getConsultation().toLowerCase());
				else
					retVal = this.getConsultation().compareTo(compareObj.getConsultation());
			}
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
		if(this.consultation != null)
			count++;
		if(this.effectivedate != null)
			count++;
		if(this.authorisinghcp != null)
			count++;
		if(this.locationtypedescription != null)
			count++;
		if(this.confidentialitypolicy != null)
			count++;
		if(this.consultationtypeoriginalterm != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected String consultation;
	protected String effectivedate;
	protected String authorisinghcp;
	protected String locationtypedescription;
	protected String confidentialitypolicy;
	protected String consultationtypeoriginalterm;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
