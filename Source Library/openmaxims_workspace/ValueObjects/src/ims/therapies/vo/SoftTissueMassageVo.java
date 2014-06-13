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

package ims.therapies.vo;

/**
 * Linked to therapies.treatment.SoftTissueMassage business object (ID: 1019100019).
 */
public class SoftTissueMassageVo extends ims.therapies.treatment.vo.SoftTissueMassageRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SoftTissueMassageVo()
	{
	}
	public SoftTissueMassageVo(Integer id, int version)
	{
		super(id, version);
	}
	public SoftTissueMassageVo(ims.therapies.vo.beans.SoftTissueMassageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.stmassagetype = bean.getSTMassageType() == null ? null : ims.spinalinjuries.vo.lookups.SoftTissueMassageType.buildLookup(bean.getSTMassageType());
		this.stmassagearea = bean.getSTMassageArea() == null ? null : ims.spinalinjuries.vo.lookups.SoftTissueMassageArea.buildLookup(bean.getSTMassageArea());
		this.stmassageareadescription = bean.getSTMassageAreaDescription();
		this.laterality = bean.getLaterality() == null ? null : ims.core.vo.lookups.LateralityLRB.buildLookup(bean.getLaterality());
		this.duration = bean.getDuration();
		this.notes = bean.getNotes();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.SoftTissueMassageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.stmassagetype = bean.getSTMassageType() == null ? null : ims.spinalinjuries.vo.lookups.SoftTissueMassageType.buildLookup(bean.getSTMassageType());
		this.stmassagearea = bean.getSTMassageArea() == null ? null : ims.spinalinjuries.vo.lookups.SoftTissueMassageArea.buildLookup(bean.getSTMassageArea());
		this.stmassageareadescription = bean.getSTMassageAreaDescription();
		this.laterality = bean.getLaterality() == null ? null : ims.core.vo.lookups.LateralityLRB.buildLookup(bean.getLaterality());
		this.duration = bean.getDuration();
		this.notes = bean.getNotes();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.SoftTissueMassageVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.SoftTissueMassageVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.SoftTissueMassageVoBean();
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
		if(fieldName.equals("STMASSAGETYPE"))
			return getSTMassageType();
		if(fieldName.equals("STMASSAGEAREA"))
			return getSTMassageArea();
		if(fieldName.equals("STMASSAGEAREADESCRIPTION"))
			return getSTMassageAreaDescription();
		if(fieldName.equals("LATERALITY"))
			return getLaterality();
		if(fieldName.equals("DURATION"))
			return getDuration();
		if(fieldName.equals("NOTES"))
			return getNotes();
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSTMassageTypeIsNotNull()
	{
		return this.stmassagetype != null;
	}
	public ims.spinalinjuries.vo.lookups.SoftTissueMassageType getSTMassageType()
	{
		return this.stmassagetype;
	}
	public void setSTMassageType(ims.spinalinjuries.vo.lookups.SoftTissueMassageType value)
	{
		this.isValidated = false;
		this.stmassagetype = value;
	}
	public boolean getSTMassageAreaIsNotNull()
	{
		return this.stmassagearea != null;
	}
	public ims.spinalinjuries.vo.lookups.SoftTissueMassageArea getSTMassageArea()
	{
		return this.stmassagearea;
	}
	public void setSTMassageArea(ims.spinalinjuries.vo.lookups.SoftTissueMassageArea value)
	{
		this.isValidated = false;
		this.stmassagearea = value;
	}
	public boolean getSTMassageAreaDescriptionIsNotNull()
	{
		return this.stmassageareadescription != null;
	}
	public String getSTMassageAreaDescription()
	{
		return this.stmassageareadescription;
	}
	public static int getSTMassageAreaDescriptionMaxLength()
	{
		return 30;
	}
	public void setSTMassageAreaDescription(String value)
	{
		this.isValidated = false;
		this.stmassageareadescription = value;
	}
	public boolean getLateralityIsNotNull()
	{
		return this.laterality != null;
	}
	public ims.core.vo.lookups.LateralityLRB getLaterality()
	{
		return this.laterality;
	}
	public void setLaterality(ims.core.vo.lookups.LateralityLRB value)
	{
		this.isValidated = false;
		this.laterality = value;
	}
	public boolean getDurationIsNotNull()
	{
		return this.duration != null;
	}
	public Integer getDuration()
	{
		return this.duration;
	}
	public void setDuration(Integer value)
	{
		this.isValidated = false;
		this.duration = value;
	}
	public boolean getNotesIsNotNull()
	{
		return this.notes != null;
	}
	public String getNotes()
	{
		return this.notes;
	}
	public static int getNotesMaxLength()
	{
		return 80;
	}
	public void setNotes(String value)
	{
		this.isValidated = false;
		this.notes = value;
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.vo.ClinicalContactShortVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.ClinicalContactShortVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
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
		if(this.stmassagetype == null)
			listOfErrors.add("STMassageType is mandatory");
		if(this.stmassagearea == null)
			listOfErrors.add("STMassageArea is mandatory");
		if(this.stmassageareadescription != null)
			if(this.stmassageareadescription.length() > 30)
				listOfErrors.add("The length of the field [stmassageareadescription] in the value object [ims.therapies.vo.SoftTissueMassageVo] is too big. It should be less or equal to 30");
		if(this.notes != null)
			if(this.notes.length() > 80)
				listOfErrors.add("The length of the field [notes] in the value object [ims.therapies.vo.SoftTissueMassageVo] is too big. It should be less or equal to 80");
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
	
		SoftTissueMassageVo clone = new SoftTissueMassageVo(this.id, this.version);
		
		if(this.stmassagetype == null)
			clone.stmassagetype = null;
		else
			clone.stmassagetype = (ims.spinalinjuries.vo.lookups.SoftTissueMassageType)this.stmassagetype.clone();
		if(this.stmassagearea == null)
			clone.stmassagearea = null;
		else
			clone.stmassagearea = (ims.spinalinjuries.vo.lookups.SoftTissueMassageArea)this.stmassagearea.clone();
		clone.stmassageareadescription = this.stmassageareadescription;
		if(this.laterality == null)
			clone.laterality = null;
		else
			clone.laterality = (ims.core.vo.lookups.LateralityLRB)this.laterality.clone();
		clone.duration = this.duration;
		clone.notes = this.notes;
		if(this.clinicalcontact == null)
			clone.clinicalcontact = null;
		else
			clone.clinicalcontact = (ims.core.vo.ClinicalContactShortVo)this.clinicalcontact.clone();
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
		if (!(SoftTissueMassageVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SoftTissueMassageVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		SoftTissueMassageVo compareObj = (SoftTissueMassageVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_SoftTissueMassage() == null && compareObj.getID_SoftTissueMassage() != null)
				return -1;
			if(this.getID_SoftTissueMassage() != null && compareObj.getID_SoftTissueMassage() == null)
				return 1;
			if(this.getID_SoftTissueMassage() != null && compareObj.getID_SoftTissueMassage() != null)
				retVal = this.getID_SoftTissueMassage().compareTo(compareObj.getID_SoftTissueMassage());
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
		if(this.stmassagetype != null)
			count++;
		if(this.stmassagearea != null)
			count++;
		if(this.stmassageareadescription != null)
			count++;
		if(this.laterality != null)
			count++;
		if(this.duration != null)
			count++;
		if(this.notes != null)
			count++;
		if(this.clinicalcontact != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.spinalinjuries.vo.lookups.SoftTissueMassageType stmassagetype;
	protected ims.spinalinjuries.vo.lookups.SoftTissueMassageArea stmassagearea;
	protected String stmassageareadescription;
	protected ims.core.vo.lookups.LateralityLRB laterality;
	protected Integer duration;
	protected String notes;
	protected ims.core.vo.ClinicalContactShortVo clinicalcontact;
	private boolean isValidated = false;
	private boolean isBusy = false;
}