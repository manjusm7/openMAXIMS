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

package ims.ocrr.vo;


public class WardSpecimenCollectionSearchCriteriaVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public WardSpecimenCollectionSearchCriteriaVo()
	{
	}
	public WardSpecimenCollectionSearchCriteriaVo(ims.ocrr.vo.beans.WardSpecimenCollectionSearchCriteriaVoBean bean)
	{
		this.hospital = bean.getHospital() == null ? null : bean.getHospital().buildVo();
		this.ward = bean.getWard();
		this.datefrom = bean.getDateFrom() == null ? null : bean.getDateFrom().buildDate();
		this.dateto = bean.getDateTo() == null ? null : bean.getDateTo().buildDate();
		this.isall = bean.getIsAll();
		this.isforcollection = bean.getIsForCollection();
		this.isoutstanding = bean.getIsOutstanding();
		this.iscollected = bean.getIsCollected();
		this.iscollectioncancelled = bean.getIsCollectionCancelled();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.WardSpecimenCollectionSearchCriteriaVoBean bean)
	{
		this.hospital = bean.getHospital() == null ? null : bean.getHospital().buildVo(map);
		this.ward = bean.getWard();
		this.datefrom = bean.getDateFrom() == null ? null : bean.getDateFrom().buildDate();
		this.dateto = bean.getDateTo() == null ? null : bean.getDateTo().buildDate();
		this.isall = bean.getIsAll();
		this.isforcollection = bean.getIsForCollection();
		this.isoutstanding = bean.getIsOutstanding();
		this.iscollected = bean.getIsCollected();
		this.iscollectioncancelled = bean.getIsCollectionCancelled();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.WardSpecimenCollectionSearchCriteriaVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.WardSpecimenCollectionSearchCriteriaVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.WardSpecimenCollectionSearchCriteriaVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getHospitalIsNotNull()
	{
		return this.hospital != null;
	}
	public ims.core.vo.LocationLiteVo getHospital()
	{
		return this.hospital;
	}
	public void setHospital(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.hospital = value;
	}
	public boolean getWardIsNotNull()
	{
		return this.ward != null;
	}
	public Integer getWard()
	{
		return this.ward;
	}
	public void setWard(Integer value)
	{
		this.isValidated = false;
		this.ward = value;
	}
	public boolean getDateFromIsNotNull()
	{
		return this.datefrom != null;
	}
	public ims.framework.utils.Date getDateFrom()
	{
		return this.datefrom;
	}
	public void setDateFrom(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datefrom = value;
	}
	public boolean getDateToIsNotNull()
	{
		return this.dateto != null;
	}
	public ims.framework.utils.Date getDateTo()
	{
		return this.dateto;
	}
	public void setDateTo(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateto = value;
	}
	public boolean getIsAllIsNotNull()
	{
		return this.isall != null;
	}
	public Boolean getIsAll()
	{
		return this.isall;
	}
	public void setIsAll(Boolean value)
	{
		this.isValidated = false;
		this.isall = value;
	}
	public boolean getIsForCollectionIsNotNull()
	{
		return this.isforcollection != null;
	}
	public Boolean getIsForCollection()
	{
		return this.isforcollection;
	}
	public void setIsForCollection(Boolean value)
	{
		this.isValidated = false;
		this.isforcollection = value;
	}
	public boolean getIsOutstandingIsNotNull()
	{
		return this.isoutstanding != null;
	}
	public Boolean getIsOutstanding()
	{
		return this.isoutstanding;
	}
	public void setIsOutstanding(Boolean value)
	{
		this.isValidated = false;
		this.isoutstanding = value;
	}
	public boolean getIsCollectedIsNotNull()
	{
		return this.iscollected != null;
	}
	public Boolean getIsCollected()
	{
		return this.iscollected;
	}
	public void setIsCollected(Boolean value)
	{
		this.isValidated = false;
		this.iscollected = value;
	}
	public boolean getIsCollectionCancelledIsNotNull()
	{
		return this.iscollectioncancelled != null;
	}
	public Boolean getIsCollectionCancelled()
	{
		return this.iscollectioncancelled;
	}
	public void setIsCollectionCancelled(Boolean value)
	{
		this.isValidated = false;
		this.iscollectioncancelled = value;
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
		if(!(obj instanceof WardSpecimenCollectionSearchCriteriaVo))
			return false;
		WardSpecimenCollectionSearchCriteriaVo compareObj = (WardSpecimenCollectionSearchCriteriaVo)obj;
		if(this.getHospital() == null && compareObj.getHospital() != null)
			return false;
		if(this.getHospital() != null && compareObj.getHospital() == null)
			return false;
		if(this.getHospital() != null && compareObj.getHospital() != null)
			if(!this.getHospital().equals(compareObj.getHospital()))
				return false;
		if(this.getWard() == null && compareObj.getWard() != null)
			return false;
		if(this.getWard() != null && compareObj.getWard() == null)
			return false;
		if(this.getWard() != null && compareObj.getWard() != null)
			if(!this.getWard().equals(compareObj.getWard()))
				return false;
		if(this.getDateFrom() == null && compareObj.getDateFrom() != null)
			return false;
		if(this.getDateFrom() != null && compareObj.getDateFrom() == null)
			return false;
		if(this.getDateFrom() != null && compareObj.getDateFrom() != null)
			if(!this.getDateFrom().equals(compareObj.getDateFrom()))
				return false;
		if(this.getDateTo() == null && compareObj.getDateTo() != null)
			return false;
		if(this.getDateTo() != null && compareObj.getDateTo() == null)
			return false;
		if(this.getDateTo() != null && compareObj.getDateTo() != null)
			if(!this.getDateTo().equals(compareObj.getDateTo()))
				return false;
		if(this.getIsAll() == null && compareObj.getIsAll() != null)
			return false;
		if(this.getIsAll() != null && compareObj.getIsAll() == null)
			return false;
		if(this.getIsAll() != null && compareObj.getIsAll() != null)
			if(!this.getIsAll().equals(compareObj.getIsAll()))
				return false;
		if(this.getIsForCollection() == null && compareObj.getIsForCollection() != null)
			return false;
		if(this.getIsForCollection() != null && compareObj.getIsForCollection() == null)
			return false;
		if(this.getIsForCollection() != null && compareObj.getIsForCollection() != null)
			if(!this.getIsForCollection().equals(compareObj.getIsForCollection()))
				return false;
		if(this.getIsOutstanding() == null && compareObj.getIsOutstanding() != null)
			return false;
		if(this.getIsOutstanding() != null && compareObj.getIsOutstanding() == null)
			return false;
		if(this.getIsOutstanding() != null && compareObj.getIsOutstanding() != null)
			if(!this.getIsOutstanding().equals(compareObj.getIsOutstanding()))
				return false;
		if(this.getIsCollected() == null && compareObj.getIsCollected() != null)
			return false;
		if(this.getIsCollected() != null && compareObj.getIsCollected() == null)
			return false;
		if(this.getIsCollected() != null && compareObj.getIsCollected() != null)
			if(!this.getIsCollected().equals(compareObj.getIsCollected()))
				return false;
		if(this.getIsCollectionCancelled() == null && compareObj.getIsCollectionCancelled() != null)
			return false;
		if(this.getIsCollectionCancelled() != null && compareObj.getIsCollectionCancelled() == null)
			return false;
		if(this.getIsCollectionCancelled() != null && compareObj.getIsCollectionCancelled() != null)
			return this.getIsCollectionCancelled().equals(compareObj.getIsCollectionCancelled());
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
	
		WardSpecimenCollectionSearchCriteriaVo clone = new WardSpecimenCollectionSearchCriteriaVo();
		
		if(this.hospital == null)
			clone.hospital = null;
		else
			clone.hospital = (ims.core.vo.LocationLiteVo)this.hospital.clone();
		clone.ward = this.ward;
		if(this.datefrom == null)
			clone.datefrom = null;
		else
			clone.datefrom = (ims.framework.utils.Date)this.datefrom.clone();
		if(this.dateto == null)
			clone.dateto = null;
		else
			clone.dateto = (ims.framework.utils.Date)this.dateto.clone();
		clone.isall = this.isall;
		clone.isforcollection = this.isforcollection;
		clone.isoutstanding = this.isoutstanding;
		clone.iscollected = this.iscollected;
		clone.iscollectioncancelled = this.iscollectioncancelled;
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
		if (!(WardSpecimenCollectionSearchCriteriaVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A WardSpecimenCollectionSearchCriteriaVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		WardSpecimenCollectionSearchCriteriaVo compareObj = (WardSpecimenCollectionSearchCriteriaVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getHospital() == null && compareObj.getHospital() != null)
				return -1;
			if(this.getHospital() != null && compareObj.getHospital() == null)
				return 1;
			if(this.getHospital() != null && compareObj.getHospital() != null)
				retVal = this.getHospital().compareTo(compareObj.getHospital());
		}
		if (retVal == 0)
		{
			if(this.getWard() == null && compareObj.getWard() != null)
				return -1;
			if(this.getWard() != null && compareObj.getWard() == null)
				return 1;
			if(this.getWard() != null && compareObj.getWard() != null)
				retVal = this.getWard().compareTo(compareObj.getWard());
		}
		if (retVal == 0)
		{
			if(this.getDateFrom() == null && compareObj.getDateFrom() != null)
				return -1;
			if(this.getDateFrom() != null && compareObj.getDateFrom() == null)
				return 1;
			if(this.getDateFrom() != null && compareObj.getDateFrom() != null)
				retVal = this.getDateFrom().compareTo(compareObj.getDateFrom());
		}
		if (retVal == 0)
		{
			if(this.getDateTo() == null && compareObj.getDateTo() != null)
				return -1;
			if(this.getDateTo() != null && compareObj.getDateTo() == null)
				return 1;
			if(this.getDateTo() != null && compareObj.getDateTo() != null)
				retVal = this.getDateTo().compareTo(compareObj.getDateTo());
		}
		if (retVal == 0)
		{
			if(this.getIsAll() == null && compareObj.getIsAll() != null)
				return -1;
			if(this.getIsAll() != null && compareObj.getIsAll() == null)
				return 1;
			if(this.getIsAll() != null && compareObj.getIsAll() != null)
				retVal = this.getIsAll().compareTo(compareObj.getIsAll());
		}
		if (retVal == 0)
		{
			if(this.getIsForCollection() == null && compareObj.getIsForCollection() != null)
				return -1;
			if(this.getIsForCollection() != null && compareObj.getIsForCollection() == null)
				return 1;
			if(this.getIsForCollection() != null && compareObj.getIsForCollection() != null)
				retVal = this.getIsForCollection().compareTo(compareObj.getIsForCollection());
		}
		if (retVal == 0)
		{
			if(this.getIsOutstanding() == null && compareObj.getIsOutstanding() != null)
				return -1;
			if(this.getIsOutstanding() != null && compareObj.getIsOutstanding() == null)
				return 1;
			if(this.getIsOutstanding() != null && compareObj.getIsOutstanding() != null)
				retVal = this.getIsOutstanding().compareTo(compareObj.getIsOutstanding());
		}
		if (retVal == 0)
		{
			if(this.getIsCollected() == null && compareObj.getIsCollected() != null)
				return -1;
			if(this.getIsCollected() != null && compareObj.getIsCollected() == null)
				return 1;
			if(this.getIsCollected() != null && compareObj.getIsCollected() != null)
				retVal = this.getIsCollected().compareTo(compareObj.getIsCollected());
		}
		if (retVal == 0)
		{
			if(this.getIsCollectionCancelled() == null && compareObj.getIsCollectionCancelled() != null)
				return -1;
			if(this.getIsCollectionCancelled() != null && compareObj.getIsCollectionCancelled() == null)
				return 1;
			if(this.getIsCollectionCancelled() != null && compareObj.getIsCollectionCancelled() != null)
				retVal = this.getIsCollectionCancelled().compareTo(compareObj.getIsCollectionCancelled());
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
		if(this.hospital != null)
			count++;
		if(this.ward != null)
			count++;
		if(this.datefrom != null)
			count++;
		if(this.dateto != null)
			count++;
		if(this.isall != null)
			count++;
		if(this.isforcollection != null)
			count++;
		if(this.isoutstanding != null)
			count++;
		if(this.iscollected != null)
			count++;
		if(this.iscollectioncancelled != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.core.vo.LocationLiteVo hospital;
	protected Integer ward;
	protected ims.framework.utils.Date datefrom;
	protected ims.framework.utils.Date dateto;
	protected Boolean isall;
	protected Boolean isforcollection;
	protected Boolean isoutstanding;
	protected Boolean iscollected;
	protected Boolean iscollectioncancelled;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
