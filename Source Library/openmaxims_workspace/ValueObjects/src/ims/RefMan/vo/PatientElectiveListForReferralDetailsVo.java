// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo;

/**
 * Linked to RefMan.PatientElectiveList business object (ID: 1014100020).
 */
public class PatientElectiveListForReferralDetailsVo extends ims.RefMan.vo.PatientElectiveListRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientElectiveListForReferralDetailsVo()
	{
	}
	public PatientElectiveListForReferralDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientElectiveListForReferralDetailsVo(ims.RefMan.vo.beans.PatientElectiveListForReferralDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.electivelist = bean.getElectiveList() == null ? null : bean.getElectiveList().buildVo();
		this.dateonlist = bean.getDateOnList() == null ? null : bean.getDateOnList().buildDate();
		this.electiveliststatus = bean.getElectiveListStatus() == null ? null : bean.getElectiveListStatus().buildVo();
		if(bean.getTCIHistory() != null)
		{
			this.tcihistory = new ims.RefMan.vo.TCIForPatientElectiveListRefVoCollection();
			for(int tcihistory_i = 0; tcihistory_i < bean.getTCIHistory().length; tcihistory_i++)
			{
				this.tcihistory.add(new ims.RefMan.vo.TCIForPatientElectiveListRefVo(new Integer(bean.getTCIHistory()[tcihistory_i].getId()), bean.getTCIHistory()[tcihistory_i].getVersion()));
			}
		}
		this.tcidetails = bean.getTCIDetails() == null ? null : bean.getTCIDetails().buildVo();
		this.primaryprocedure = bean.getPrimaryProcedure() == null ? null : bean.getPrimaryProcedure().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.PatientElectiveListForReferralDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.electivelist = bean.getElectiveList() == null ? null : bean.getElectiveList().buildVo(map);
		this.dateonlist = bean.getDateOnList() == null ? null : bean.getDateOnList().buildDate();
		this.electiveliststatus = bean.getElectiveListStatus() == null ? null : bean.getElectiveListStatus().buildVo(map);
		if(bean.getTCIHistory() != null)
		{
			this.tcihistory = new ims.RefMan.vo.TCIForPatientElectiveListRefVoCollection();
			for(int tcihistory_i = 0; tcihistory_i < bean.getTCIHistory().length; tcihistory_i++)
			{
				this.tcihistory.add(new ims.RefMan.vo.TCIForPatientElectiveListRefVo(new Integer(bean.getTCIHistory()[tcihistory_i].getId()), bean.getTCIHistory()[tcihistory_i].getVersion()));
			}
		}
		this.tcidetails = bean.getTCIDetails() == null ? null : bean.getTCIDetails().buildVo(map);
		this.primaryprocedure = bean.getPrimaryProcedure() == null ? null : bean.getPrimaryProcedure().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.PatientElectiveListForReferralDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.PatientElectiveListForReferralDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.PatientElectiveListForReferralDetailsVoBean();
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
		if(fieldName.equals("ELECTIVELIST"))
			return getElectiveList();
		if(fieldName.equals("DATEONLIST"))
			return getDateOnList();
		if(fieldName.equals("ELECTIVELISTSTATUS"))
			return getElectiveListStatus();
		if(fieldName.equals("TCIHISTORY"))
			return getTCIHistory();
		if(fieldName.equals("TCIDETAILS"))
			return getTCIDetails();
		if(fieldName.equals("PRIMARYPROCEDURE"))
			return getPrimaryProcedure();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getElectiveListIsNotNull()
	{
		return this.electivelist != null;
	}
	public ims.RefMan.vo.PatientElectiveListConfigForReferralDetailsVo getElectiveList()
	{
		return this.electivelist;
	}
	public void setElectiveList(ims.RefMan.vo.PatientElectiveListConfigForReferralDetailsVo value)
	{
		this.isValidated = false;
		this.electivelist = value;
	}
	public boolean getDateOnListIsNotNull()
	{
		return this.dateonlist != null;
	}
	public ims.framework.utils.Date getDateOnList()
	{
		return this.dateonlist;
	}
	public void setDateOnList(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateonlist = value;
	}
	public boolean getElectiveListStatusIsNotNull()
	{
		return this.electiveliststatus != null;
	}
	public ims.RefMan.vo.ElectiveListStatusVo getElectiveListStatus()
	{
		return this.electiveliststatus;
	}
	public void setElectiveListStatus(ims.RefMan.vo.ElectiveListStatusVo value)
	{
		this.isValidated = false;
		this.electiveliststatus = value;
	}
	public boolean getTCIHistoryIsNotNull()
	{
		return this.tcihistory != null;
	}
	public ims.RefMan.vo.TCIForPatientElectiveListRefVoCollection getTCIHistory()
	{
		return this.tcihistory;
	}
	public void setTCIHistory(ims.RefMan.vo.TCIForPatientElectiveListRefVoCollection value)
	{
		this.isValidated = false;
		this.tcihistory = value;
	}
	public boolean getTCIDetailsIsNotNull()
	{
		return this.tcidetails != null;
	}
	public ims.RefMan.vo.ElectiveTCIForReferralDetailsVo getTCIDetails()
	{
		return this.tcidetails;
	}
	public void setTCIDetails(ims.RefMan.vo.ElectiveTCIForReferralDetailsVo value)
	{
		this.isValidated = false;
		this.tcidetails = value;
	}
	public boolean getPrimaryProcedureIsNotNull()
	{
		return this.primaryprocedure != null;
	}
	public ims.core.vo.ProcedureLiteVo getPrimaryProcedure()
	{
		return this.primaryprocedure;
	}
	public void setPrimaryProcedure(ims.core.vo.ProcedureLiteVo value)
	{
		this.isValidated = false;
		this.primaryprocedure = value;
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
		if(this.electivelist != null)
		{
			if(!this.electivelist.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.electiveliststatus != null)
		{
			if(!this.electiveliststatus.isValidated())
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
		if(this.electivelist == null)
			listOfErrors.add("ElectiveList is mandatory");
		if(this.electivelist != null)
		{
			String[] listOfOtherErrors = this.electivelist.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.dateonlist == null)
			listOfErrors.add("DateOnList is mandatory");
		if(this.electiveliststatus == null)
			listOfErrors.add("ElectiveListStatus is mandatory");
		if(this.electiveliststatus != null)
		{
			String[] listOfOtherErrors = this.electiveliststatus.validate();
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
	
		PatientElectiveListForReferralDetailsVo clone = new PatientElectiveListForReferralDetailsVo(this.id, this.version);
		
		if(this.electivelist == null)
			clone.electivelist = null;
		else
			clone.electivelist = (ims.RefMan.vo.PatientElectiveListConfigForReferralDetailsVo)this.electivelist.clone();
		if(this.dateonlist == null)
			clone.dateonlist = null;
		else
			clone.dateonlist = (ims.framework.utils.Date)this.dateonlist.clone();
		if(this.electiveliststatus == null)
			clone.electiveliststatus = null;
		else
			clone.electiveliststatus = (ims.RefMan.vo.ElectiveListStatusVo)this.electiveliststatus.clone();
		clone.tcihistory = this.tcihistory;
		if(this.tcidetails == null)
			clone.tcidetails = null;
		else
			clone.tcidetails = (ims.RefMan.vo.ElectiveTCIForReferralDetailsVo)this.tcidetails.clone();
		if(this.primaryprocedure == null)
			clone.primaryprocedure = null;
		else
			clone.primaryprocedure = (ims.core.vo.ProcedureLiteVo)this.primaryprocedure.clone();
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
		if (!(PatientElectiveListForReferralDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientElectiveListForReferralDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientElectiveListForReferralDetailsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientElectiveListForReferralDetailsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.electivelist != null)
			count++;
		if(this.dateonlist != null)
			count++;
		if(this.electiveliststatus != null)
			count++;
		if(this.tcihistory != null)
			count++;
		if(this.tcidetails != null)
			count++;
		if(this.primaryprocedure != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.RefMan.vo.PatientElectiveListConfigForReferralDetailsVo electivelist;
	protected ims.framework.utils.Date dateonlist;
	protected ims.RefMan.vo.ElectiveListStatusVo electiveliststatus;
	protected ims.RefMan.vo.TCIForPatientElectiveListRefVoCollection tcihistory;
	protected ims.RefMan.vo.ElectiveTCIForReferralDetailsVo tcidetails;
	protected ims.core.vo.ProcedureLiteVo primaryprocedure;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
