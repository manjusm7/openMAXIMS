// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo;

/**
 * Linked to core.configuration.CCGToContractConfig business object (ID: 1028100075).
 */
public class CCGToContractConfigVo extends ims.core.configuration.vo.CCGToContractConfigRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CCGToContractConfigVo()
	{
	}
	public CCGToContractConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public CCGToContractConfigVo(ims.RefMan.vo.beans.CCGToContractConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.ccgcode = bean.getCCGCode();
		this.isactive = bean.getIsActive();
		this.isedited = bean.getIsEdited();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.CCGToContractConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.ccgcode = bean.getCCGCode();
		this.isactive = bean.getIsActive();
		this.isedited = bean.getIsEdited();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.CCGToContractConfigVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.CCGToContractConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.CCGToContractConfigVoBean();
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
		if(fieldName.equals("CCGCODE"))
			return getCCGCode();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("ISEDITED"))
			return getIsEdited();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCCGCodeIsNotNull()
	{
		return this.ccgcode != null;
	}
	public String getCCGCode()
	{
		return this.ccgcode;
	}
	public static int getCCGCodeMaxLength()
	{
		return 5;
	}
	public void setCCGCode(String value)
	{
		this.isValidated = false;
		this.ccgcode = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getIsEditedIsNotNull()
	{
		return this.isedited != null;
	}
	public Boolean getIsEdited()
	{
		return this.isedited;
	}
	public void setIsEdited(Boolean value)
	{
		this.isValidated = false;
		this.isedited = value;
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
		if(this.ccgcode == null || this.ccgcode.length() == 0)
			listOfErrors.add("CCGCode is mandatory");
		else if(this.ccgcode.length() > 5)
			listOfErrors.add("The length of the field [ccgcode] in the value object [ims.RefMan.vo.CCGToContractConfigVo] is too big. It should be less or equal to 5");
		if(this.isactive == null)
			listOfErrors.add("IsActive is mandatory");
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
	
		CCGToContractConfigVo clone = new CCGToContractConfigVo(this.id, this.version);
		
		clone.ccgcode = this.ccgcode;
		clone.isactive = this.isactive;
		clone.isedited = this.isedited;
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
		if (!(CCGToContractConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CCGToContractConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CCGToContractConfigVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CCGToContractConfigVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.ccgcode != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.isedited != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected String ccgcode;
	protected Boolean isactive;
	protected Boolean isedited;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
