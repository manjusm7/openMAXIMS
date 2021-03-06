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

package ims.core.vo;

/**
 * Linked to core.resource.people.MemberOfStaff business object (ID: 1006100006).
 */
public class MemberOfStaffLiteVo extends ims.core.resource.people.vo.MemberOfStaffRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IMos
{
	private static final long serialVersionUID = 1L;

	public MemberOfStaffLiteVo()
	{
	}
	public MemberOfStaffLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public MemberOfStaffLiteVo(ims.core.vo.beans.MemberOfStaffLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName() == null ? null : bean.getName().buildVo();
		this.initials = bean.getInitials();
		this.signatureblock = bean.getSignatureBlock();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.MemberOfStaffLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName() == null ? null : bean.getName().buildVo(map);
		this.initials = bean.getInitials();
		this.signatureblock = bean.getSignatureBlock();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.MemberOfStaffLiteVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.MemberOfStaffLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.MemberOfStaffLiteVoBean();
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
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("INITIALS"))
			return getInitials();
		if(fieldName.equals("SIGNATUREBLOCK"))
			return getSignatureBlock();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public ims.core.vo.PersonName getName()
	{
		return this.name;
	}
	public void setName(ims.core.vo.PersonName value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getInitialsIsNotNull()
	{
		return this.initials != null;
	}
	public String getInitials()
	{
		return this.initials;
	}
	public static int getInitialsMaxLength()
	{
		return 5;
	}
	public void setInitials(String value)
	{
		this.isValidated = false;
		this.initials = value;
	}
	public boolean getSignatureBlockIsNotNull()
	{
		return this.signatureblock != null;
	}
	public String getSignatureBlock()
	{
		return this.signatureblock;
	}
	public static int getSignatureBlockMaxLength()
	{
		return 255;
	}
	public void setSignatureBlock(String value)
	{
		this.isValidated = false;
		this.signatureblock = value;
	}
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		if(this.name != null)
			sb.append(this.name);
		return sb.toString();
	}
	/**
	* IMos interface methods
	*/
	public Integer getIMosId()
	{
		return this.id;
	}
	public String getIMosName()
	{
		ims.core.vo.PersonName name = getName();
		if(name != null)
			return name.toString();
			
		return null;
	}
	public Integer getIMosHcpId()
	{
		return null;
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
		if(this.name != null)
		{
			if(!this.name.isValidated())
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
		if(this.name == null)
			listOfErrors.add("Name is mandatory");
		if(this.name != null)
		{
			String[] listOfOtherErrors = this.name.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.initials != null)
			if(this.initials.length() > 5)
				listOfErrors.add("The length of the field [initials] in the value object [ims.core.vo.MemberOfStaffLiteVo] is too big. It should be less or equal to 5");
		if(this.signatureblock != null)
			if(this.signatureblock.length() > 255)
				listOfErrors.add("The length of the field [signatureblock] in the value object [ims.core.vo.MemberOfStaffLiteVo] is too big. It should be less or equal to 255");
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
	
		MemberOfStaffLiteVo clone = new MemberOfStaffLiteVo(this.id, this.version);
		
		if(this.name == null)
			clone.name = null;
		else
			clone.name = (ims.core.vo.PersonName)this.name.clone();
		clone.initials = this.initials;
		clone.signatureblock = this.signatureblock;
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
		if (!(MemberOfStaffLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A MemberOfStaffLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		MemberOfStaffLiteVo compareObj = (MemberOfStaffLiteVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getName() == null && compareObj.getName() != null)
				return -1;
			if(this.getName() != null && compareObj.getName() == null)
				return 1;
			if(this.getName() != null && compareObj.getName() != null)
				retVal = this.getName().compareTo(compareObj.getName());
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
		if(this.name != null)
			count++;
		if(this.initials != null)
			count++;
		if(this.signatureblock != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.core.vo.PersonName name;
	protected String initials;
	protected String signatureblock;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
