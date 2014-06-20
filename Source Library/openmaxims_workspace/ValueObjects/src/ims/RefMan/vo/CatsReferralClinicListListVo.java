// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo;

/**
 * Linked to RefMan.CatsReferral business object (ID: 1004100035).
 */
public class CatsReferralClinicListListVo extends ims.RefMan.vo.CatsReferralRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CatsReferralClinicListListVo()
	{
	}
	public CatsReferralClinicListListVo(Integer id, int version)
	{
		super(id, version);
	}
	public CatsReferralClinicListListVo(ims.RefMan.vo.beans.CatsReferralClinicListListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.hasinvestigations = bean.getHasInvestigations();
		this.hasappointments = bean.getHasAppointments();
		this.hasreferralletter = bean.getHasReferralLetter();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.iscab = bean.getIsCAB();
		this.hasconsultationdetails = bean.getHasConsultationDetails();
		this.lastapptarriveddate = bean.getLastApptArrivedDate() == null ? null : bean.getLastApptArrivedDate().buildDate();
		this.onwardreferralstatus = bean.getOnwardReferralStatus() == null ? null : ims.RefMan.vo.lookups.OnwardReferralStatus.buildLookup(bean.getOnwardReferralStatus());
		this.referraldetails = bean.getReferralDetails() == null ? null : bean.getReferralDetails().buildVo();
		this.providercancellation = bean.getProviderCancellation() == null ? null : new ims.RefMan.vo.ProviderCancellationRefVo(new Integer(bean.getProviderCancellation().getId()), bean.getProviderCancellation().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.CatsReferralClinicListListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.hasinvestigations = bean.getHasInvestigations();
		this.hasappointments = bean.getHasAppointments();
		this.hasreferralletter = bean.getHasReferralLetter();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.iscab = bean.getIsCAB();
		this.hasconsultationdetails = bean.getHasConsultationDetails();
		this.lastapptarriveddate = bean.getLastApptArrivedDate() == null ? null : bean.getLastApptArrivedDate().buildDate();
		this.onwardreferralstatus = bean.getOnwardReferralStatus() == null ? null : ims.RefMan.vo.lookups.OnwardReferralStatus.buildLookup(bean.getOnwardReferralStatus());
		this.referraldetails = bean.getReferralDetails() == null ? null : bean.getReferralDetails().buildVo(map);
		this.providercancellation = bean.getProviderCancellation() == null ? null : new ims.RefMan.vo.ProviderCancellationRefVo(new Integer(bean.getProviderCancellation().getId()), bean.getProviderCancellation().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.CatsReferralClinicListListVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.CatsReferralClinicListListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.CatsReferralClinicListListVoBean();
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
		if(fieldName.equals("HASINVESTIGATIONS"))
			return getHasInvestigations();
		if(fieldName.equals("HASAPPOINTMENTS"))
			return getHasAppointments();
		if(fieldName.equals("HASREFERRALLETTER"))
			return getHasReferralLetter();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("ISCAB"))
			return getIsCAB();
		if(fieldName.equals("HASCONSULTATIONDETAILS"))
			return getHasConsultationDetails();
		if(fieldName.equals("LASTAPPTARRIVEDDATE"))
			return getLastApptArrivedDate();
		if(fieldName.equals("ONWARDREFERRALSTATUS"))
			return getOnwardReferralStatus();
		if(fieldName.equals("REFERRALDETAILS"))
			return getReferralDetails();
		if(fieldName.equals("PROVIDERCANCELLATION"))
			return getProviderCancellation();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getHasInvestigationsIsNotNull()
	{
		return this.hasinvestigations != null;
	}
	public Boolean getHasInvestigations()
	{
		return this.hasinvestigations;
	}
	public void setHasInvestigations(Boolean value)
	{
		this.isValidated = false;
		this.hasinvestigations = value;
	}
	public boolean getHasAppointmentsIsNotNull()
	{
		return this.hasappointments != null;
	}
	public Boolean getHasAppointments()
	{
		return this.hasappointments;
	}
	public void setHasAppointments(Boolean value)
	{
		this.isValidated = false;
		this.hasappointments = value;
	}
	public boolean getHasReferralLetterIsNotNull()
	{
		return this.hasreferralletter != null;
	}
	public Boolean getHasReferralLetter()
	{
		return this.hasreferralletter;
	}
	public void setHasReferralLetter(Boolean value)
	{
		this.isValidated = false;
		this.hasreferralletter = value;
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.RefMan.vo.CatsReferralStatusLiteVo getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.RefMan.vo.CatsReferralStatusLiteVo value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getIsCABIsNotNull()
	{
		return this.iscab != null;
	}
	public Boolean getIsCAB()
	{
		return this.iscab;
	}
	public void setIsCAB(Boolean value)
	{
		this.isValidated = false;
		this.iscab = value;
	}
	public boolean getHasConsultationDetailsIsNotNull()
	{
		return this.hasconsultationdetails != null;
	}
	public Boolean getHasConsultationDetails()
	{
		return this.hasconsultationdetails;
	}
	public void setHasConsultationDetails(Boolean value)
	{
		this.isValidated = false;
		this.hasconsultationdetails = value;
	}
	public boolean getLastApptArrivedDateIsNotNull()
	{
		return this.lastapptarriveddate != null;
	}
	public ims.framework.utils.Date getLastApptArrivedDate()
	{
		return this.lastapptarriveddate;
	}
	public void setLastApptArrivedDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.lastapptarriveddate = value;
	}
	public boolean getOnwardReferralStatusIsNotNull()
	{
		return this.onwardreferralstatus != null;
	}
	public ims.RefMan.vo.lookups.OnwardReferralStatus getOnwardReferralStatus()
	{
		return this.onwardreferralstatus;
	}
	public void setOnwardReferralStatus(ims.RefMan.vo.lookups.OnwardReferralStatus value)
	{
		this.isValidated = false;
		this.onwardreferralstatus = value;
	}
	public boolean getReferralDetailsIsNotNull()
	{
		return this.referraldetails != null;
	}
	public ims.RefMan.vo.ReferralLetterDetailsClinicListListVo getReferralDetails()
	{
		return this.referraldetails;
	}
	public void setReferralDetails(ims.RefMan.vo.ReferralLetterDetailsClinicListListVo value)
	{
		this.isValidated = false;
		this.referraldetails = value;
	}
	public boolean getProviderCancellationIsNotNull()
	{
		return this.providercancellation != null;
	}
	public ims.RefMan.vo.ProviderCancellationRefVo getProviderCancellation()
	{
		return this.providercancellation;
	}
	public void setProviderCancellation(ims.RefMan.vo.ProviderCancellationRefVo value)
	{
		this.isValidated = false;
		this.providercancellation = value;
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
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
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
	
		CatsReferralClinicListListVo clone = new CatsReferralClinicListListVo(this.id, this.version);
		
		clone.hasinvestigations = this.hasinvestigations;
		clone.hasappointments = this.hasappointments;
		clone.hasreferralletter = this.hasreferralletter;
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.RefMan.vo.CatsReferralStatusLiteVo)this.currentstatus.clone();
		clone.carecontext = this.carecontext;
		clone.iscab = this.iscab;
		clone.hasconsultationdetails = this.hasconsultationdetails;
		if(this.lastapptarriveddate == null)
			clone.lastapptarriveddate = null;
		else
			clone.lastapptarriveddate = (ims.framework.utils.Date)this.lastapptarriveddate.clone();
		if(this.onwardreferralstatus == null)
			clone.onwardreferralstatus = null;
		else
			clone.onwardreferralstatus = (ims.RefMan.vo.lookups.OnwardReferralStatus)this.onwardreferralstatus.clone();
		if(this.referraldetails == null)
			clone.referraldetails = null;
		else
			clone.referraldetails = (ims.RefMan.vo.ReferralLetterDetailsClinicListListVo)this.referraldetails.clone();
		clone.providercancellation = this.providercancellation;
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
		if (!(CatsReferralClinicListListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CatsReferralClinicListListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CatsReferralClinicListListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CatsReferralClinicListListVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.hasinvestigations != null)
			count++;
		if(this.hasappointments != null)
			count++;
		if(this.hasreferralletter != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.iscab != null)
			count++;
		if(this.hasconsultationdetails != null)
			count++;
		if(this.lastapptarriveddate != null)
			count++;
		if(this.onwardreferralstatus != null)
			count++;
		if(this.referraldetails != null)
			count++;
		if(this.providercancellation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected Boolean hasinvestigations;
	protected Boolean hasappointments;
	protected Boolean hasreferralletter;
	protected ims.RefMan.vo.CatsReferralStatusLiteVo currentstatus;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected Boolean iscab;
	protected Boolean hasconsultationdetails;
	protected ims.framework.utils.Date lastapptarriveddate;
	protected ims.RefMan.vo.lookups.OnwardReferralStatus onwardreferralstatus;
	protected ims.RefMan.vo.ReferralLetterDetailsClinicListListVo referraldetails;
	protected ims.RefMan.vo.ProviderCancellationRefVo providercancellation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
