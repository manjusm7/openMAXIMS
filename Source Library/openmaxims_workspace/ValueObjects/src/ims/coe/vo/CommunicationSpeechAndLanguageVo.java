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

package ims.coe.vo;

/**
 * Linked to coe.assessment.Communication SpeechAndLanguage business object (ID: 1012100014).
 */
public class CommunicationSpeechAndLanguageVo extends ims.coe.assessment.vo.CommunicationSpeechAndLanguageRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CommunicationSpeechAndLanguageVo()
	{
	}
	public CommunicationSpeechAndLanguageVo(Integer id, int version)
	{
		super(id, version);
	}
	public CommunicationSpeechAndLanguageVo(ims.coe.vo.beans.CommunicationSpeechAndLanguageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.speechlanguagedifficulty = bean.getSpeechLanguageDifficulty() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getSpeechLanguageDifficulty());
		this.spokenlanguage = bean.getSpokenLanguage() == null ? null : ims.core.vo.lookups.Language.buildLookup(bean.getSpokenLanguage());
		this.communicates = ims.coe.vo.lookups.CommunicatesCollection.buildFromBeanCollection(bean.getCommunicates());
		this.verbally = ims.coe.vo.lookups.VerballyCollection.buildFromBeanCollection(bean.getVerbally());
		this.speechandlanguageunderstanding = ims.coe.vo.CommunicationUnderstandingCollection.buildFromBeanCollection(bean.getSpeechAndLanguageUnderstanding());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.beans.CommunicationSpeechAndLanguageVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.speechlanguagedifficulty = bean.getSpeechLanguageDifficulty() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getSpeechLanguageDifficulty());
		this.spokenlanguage = bean.getSpokenLanguage() == null ? null : ims.core.vo.lookups.Language.buildLookup(bean.getSpokenLanguage());
		this.communicates = ims.coe.vo.lookups.CommunicatesCollection.buildFromBeanCollection(bean.getCommunicates());
		this.verbally = ims.coe.vo.lookups.VerballyCollection.buildFromBeanCollection(bean.getVerbally());
		this.speechandlanguageunderstanding = ims.coe.vo.CommunicationUnderstandingCollection.buildFromBeanCollection(bean.getSpeechAndLanguageUnderstanding());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.beans.CommunicationSpeechAndLanguageVoBean bean = null;
		if(map != null)
			bean = (ims.coe.vo.beans.CommunicationSpeechAndLanguageVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.coe.vo.beans.CommunicationSpeechAndLanguageVoBean();
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
		if(fieldName.equals("SPEECHLANGUAGEDIFFICULTY"))
			return getSpeechLanguageDifficulty();
		if(fieldName.equals("SPOKENLANGUAGE"))
			return getSpokenLanguage();
		if(fieldName.equals("COMMUNICATES"))
			return getCommunicates();
		if(fieldName.equals("VERBALLY"))
			return getVerbally();
		if(fieldName.equals("SPEECHANDLANGUAGEUNDERSTANDING"))
			return getSpeechAndLanguageUnderstanding();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getSpeechLanguageDifficultyIsNotNull()
	{
		return this.speechlanguagedifficulty != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getSpeechLanguageDifficulty()
	{
		return this.speechlanguagedifficulty;
	}
	public void setSpeechLanguageDifficulty(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.speechlanguagedifficulty = value;
	}
	public boolean getSpokenLanguageIsNotNull()
	{
		return this.spokenlanguage != null;
	}
	public ims.core.vo.lookups.Language getSpokenLanguage()
	{
		return this.spokenlanguage;
	}
	public void setSpokenLanguage(ims.core.vo.lookups.Language value)
	{
		this.isValidated = false;
		this.spokenlanguage = value;
	}
	public boolean getCommunicatesIsNotNull()
	{
		return this.communicates != null;
	}
	public ims.coe.vo.lookups.CommunicatesCollection getCommunicates()
	{
		return this.communicates;
	}
	public void setCommunicates(ims.coe.vo.lookups.CommunicatesCollection value)
	{
		this.isValidated = false;
		this.communicates = value;
	}
	public boolean getVerballyIsNotNull()
	{
		return this.verbally != null;
	}
	public ims.coe.vo.lookups.VerballyCollection getVerbally()
	{
		return this.verbally;
	}
	public void setVerbally(ims.coe.vo.lookups.VerballyCollection value)
	{
		this.isValidated = false;
		this.verbally = value;
	}
	public boolean getSpeechAndLanguageUnderstandingIsNotNull()
	{
		return this.speechandlanguageunderstanding != null;
	}
	public ims.coe.vo.CommunicationUnderstandingCollection getSpeechAndLanguageUnderstanding()
	{
		return this.speechandlanguageunderstanding;
	}
	public void setSpeechAndLanguageUnderstanding(ims.coe.vo.CommunicationUnderstandingCollection value)
	{
		this.isValidated = false;
		this.speechandlanguageunderstanding = value;
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
		if(this.speechandlanguageunderstanding != null)
		{
			if(!this.speechandlanguageunderstanding.isValidated())
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
		if(this.speechandlanguageunderstanding != null)
		{
			String[] listOfOtherErrors = this.speechandlanguageunderstanding.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
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
	
		CommunicationSpeechAndLanguageVo clone = new CommunicationSpeechAndLanguageVo(this.id, this.version);
		
		if(this.speechlanguagedifficulty == null)
			clone.speechlanguagedifficulty = null;
		else
			clone.speechlanguagedifficulty = (ims.core.vo.lookups.YesNoUnknown)this.speechlanguagedifficulty.clone();
		if(this.spokenlanguage == null)
			clone.spokenlanguage = null;
		else
			clone.spokenlanguage = (ims.core.vo.lookups.Language)this.spokenlanguage.clone();
		if(this.communicates == null)
			clone.communicates = null;
		else
			clone.communicates = (ims.coe.vo.lookups.CommunicatesCollection)this.communicates.clone();
		if(this.verbally == null)
			clone.verbally = null;
		else
			clone.verbally = (ims.coe.vo.lookups.VerballyCollection)this.verbally.clone();
		if(this.speechandlanguageunderstanding == null)
			clone.speechandlanguageunderstanding = null;
		else
			clone.speechandlanguageunderstanding = (ims.coe.vo.CommunicationUnderstandingCollection)this.speechandlanguageunderstanding.clone();
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
		if (!(CommunicationSpeechAndLanguageVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CommunicationSpeechAndLanguageVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CommunicationSpeechAndLanguageVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CommunicationSpeechAndLanguageVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.speechlanguagedifficulty != null)
			count++;
		if(this.spokenlanguage != null)
			count++;
		if(this.communicates != null)
			count++;
		if(this.verbally != null)
			count++;
		if(this.speechandlanguageunderstanding != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.vo.lookups.YesNoUnknown speechlanguagedifficulty;
	protected ims.core.vo.lookups.Language spokenlanguage;
	protected ims.coe.vo.lookups.CommunicatesCollection communicates;
	protected ims.coe.vo.lookups.VerballyCollection verbally;
	protected ims.coe.vo.CommunicationUnderstandingCollection speechandlanguageunderstanding;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
