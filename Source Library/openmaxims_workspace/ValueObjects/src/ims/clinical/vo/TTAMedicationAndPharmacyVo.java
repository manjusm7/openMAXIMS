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

/**
 * Linked to eDischarge.TTAMedicationAndPharmacy business object (ID: 1099100015).
 */
public class TTAMedicationAndPharmacyVo extends ims.clinical.vo.TTAMedicationAndPharmacyShortVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TTAMedicationAndPharmacyVo()
	{
	}
	public TTAMedicationAndPharmacyVo(Integer id, int version)
	{
		super(id, version);
	}
	public TTAMedicationAndPharmacyVo(ims.clinical.vo.beans.TTAMedicationAndPharmacyVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo();
		this.bodyweightkg = bean.getBodyWeightKg();
		this.clinicalcommentstopharmacy = bean.getClinicalCommentsToPharmacy();
		this.orderingdatetime = bean.getOrderingDateTime() == null ? null : bean.getOrderingDateTime().buildDateTime();
		this.clinicianbleepno = bean.getClinicianBleepNo();
		this.currentttastatus = bean.getCurrentTTAStatus() == null ? null : bean.getCurrentTTAStatus().buildVo();
		this.datesubmittedtopharmacy = bean.getDateSubmittedToPharmacy() == null ? null : bean.getDateSubmittedToPharmacy().buildDate();
		this.orderingclinician = bean.getOrderingClinician() == null ? null : bean.getOrderingClinician().buildVo();
		this.responsiblepharmacist = bean.getResponsiblePharmacist() == null ? null : bean.getResponsiblePharmacist().buildVo();
		this.ttastatushistory = ims.clinical.vo.TTAStatusVoCollection.buildFromBeanCollection(bean.getTTAStatusHistory());
		this.ttamedications = ims.clinical.vo.TTAMedicationDetailVoCollection.buildFromBeanCollection(bean.getTTAMedications());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.TTAMedicationAndPharmacyVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo(map);
		this.bodyweightkg = bean.getBodyWeightKg();
		this.clinicalcommentstopharmacy = bean.getClinicalCommentsToPharmacy();
		this.orderingdatetime = bean.getOrderingDateTime() == null ? null : bean.getOrderingDateTime().buildDateTime();
		this.clinicianbleepno = bean.getClinicianBleepNo();
		this.currentttastatus = bean.getCurrentTTAStatus() == null ? null : bean.getCurrentTTAStatus().buildVo(map);
		this.datesubmittedtopharmacy = bean.getDateSubmittedToPharmacy() == null ? null : bean.getDateSubmittedToPharmacy().buildDate();
		this.orderingclinician = bean.getOrderingClinician() == null ? null : bean.getOrderingClinician().buildVo(map);
		this.responsiblepharmacist = bean.getResponsiblePharmacist() == null ? null : bean.getResponsiblePharmacist().buildVo(map);
		this.ttastatushistory = ims.clinical.vo.TTAStatusVoCollection.buildFromBeanCollection(bean.getTTAStatusHistory());
		this.ttamedications = ims.clinical.vo.TTAMedicationDetailVoCollection.buildFromBeanCollection(bean.getTTAMedications());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.TTAMedicationAndPharmacyVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.TTAMedicationAndPharmacyVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.TTAMedicationAndPharmacyVoBean();
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
		if(fieldName.equals("TTASTATUSHISTORY"))
			return getTTAStatusHistory();
		if(fieldName.equals("TTAMEDICATIONS"))
			return getTTAMedications();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTTAStatusHistoryIsNotNull()
	{
		return this.ttastatushistory != null;
	}
	public ims.clinical.vo.TTAStatusVoCollection getTTAStatusHistory()
	{
		return this.ttastatushistory;
	}
	public void setTTAStatusHistory(ims.clinical.vo.TTAStatusVoCollection value)
	{
		this.isValidated = false;
		this.ttastatushistory = value;
	}
	public boolean getTTAMedicationsIsNotNull()
	{
		return this.ttamedications != null;
	}
	public ims.clinical.vo.TTAMedicationDetailVoCollection getTTAMedications()
	{
		return this.ttamedications;
	}
	public void setTTAMedications(ims.clinical.vo.TTAMedicationDetailVoCollection value)
	{
		this.isValidated = false;
		this.ttamedications = value;
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
		if(this.currentttastatus != null)
		{
			if(!this.currentttastatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.ttastatushistory != null)
		{
			if(!this.ttastatushistory.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.ttamedications != null)
		{
			if(!this.ttamedications.isValidated())
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.clinicalcommentstopharmacy != null)
			if(this.clinicalcommentstopharmacy.length() > 1500)
				listOfErrors.add("The length of the field [clinicalcommentstopharmacy] in the value object [ims.clinical.vo.TTAMedicationAndPharmacyVo] is too big. It should be less or equal to 1500");
		if(this.clinicianbleepno != null)
			if(this.clinicianbleepno.length() > 25)
				listOfErrors.add("The length of the field [clinicianbleepno] in the value object [ims.clinical.vo.TTAMedicationAndPharmacyVo] is too big. It should be less or equal to 25");
		if(this.currentttastatus != null)
		{
			String[] listOfOtherErrors = this.currentttastatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.ttastatushistory != null)
		{
			String[] listOfOtherErrors = this.ttastatushistory.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.ttamedications != null)
		{
			String[] listOfOtherErrors = this.ttamedications.validate();
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
	
		TTAMedicationAndPharmacyVo clone = new TTAMedicationAndPharmacyVo(this.id, this.version);
		
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientShort)this.patient.clone();
		if(this.carecontext == null)
			clone.carecontext = null;
		else
			clone.carecontext = (ims.core.vo.CareContextLiteVo)this.carecontext.clone();
		clone.bodyweightkg = this.bodyweightkg;
		clone.clinicalcommentstopharmacy = this.clinicalcommentstopharmacy;
		if(this.orderingdatetime == null)
			clone.orderingdatetime = null;
		else
			clone.orderingdatetime = (ims.framework.utils.DateTime)this.orderingdatetime.clone();
		clone.clinicianbleepno = this.clinicianbleepno;
		if(this.currentttastatus == null)
			clone.currentttastatus = null;
		else
			clone.currentttastatus = (ims.clinical.vo.TTAStatusVo)this.currentttastatus.clone();
		if(this.datesubmittedtopharmacy == null)
			clone.datesubmittedtopharmacy = null;
		else
			clone.datesubmittedtopharmacy = (ims.framework.utils.Date)this.datesubmittedtopharmacy.clone();
		if(this.orderingclinician == null)
			clone.orderingclinician = null;
		else
			clone.orderingclinician = (ims.core.vo.HcpLiteVo)this.orderingclinician.clone();
		if(this.responsiblepharmacist == null)
			clone.responsiblepharmacist = null;
		else
			clone.responsiblepharmacist = (ims.core.vo.HcpLiteVo)this.responsiblepharmacist.clone();
		if(this.ttastatushistory == null)
			clone.ttastatushistory = null;
		else
			clone.ttastatushistory = (ims.clinical.vo.TTAStatusVoCollection)this.ttastatushistory.clone();
		if(this.ttamedications == null)
			clone.ttamedications = null;
		else
			clone.ttamedications = (ims.clinical.vo.TTAMedicationDetailVoCollection)this.ttamedications.clone();
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
		if (!(TTAMedicationAndPharmacyVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TTAMedicationAndPharmacyVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TTAMedicationAndPharmacyVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TTAMedicationAndPharmacyVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.ttastatushistory != null)
			count++;
		if(this.ttamedications != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 2;
	}
	protected ims.clinical.vo.TTAStatusVoCollection ttastatushistory;
	protected ims.clinical.vo.TTAMedicationDetailVoCollection ttamedications;
	private boolean isValidated = false;
	private boolean isBusy = false;
}