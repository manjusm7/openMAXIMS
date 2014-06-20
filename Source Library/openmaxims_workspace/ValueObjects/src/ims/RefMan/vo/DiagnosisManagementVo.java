// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo;

/**
 * Linked to RefMan.DiagnosisManagement business object (ID: 1096100030).
 */
public class DiagnosisManagementVo extends ims.RefMan.vo.DiagnosisManagementLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DiagnosisManagementVo()
	{
	}
	public DiagnosisManagementVo(Integer id, int version)
	{
		super(id, version);
	}
	public DiagnosisManagementVo(ims.RefMan.vo.beans.DiagnosisManagementVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.RefMan.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.recordinginformation = bean.getRecordingInformation() == null ? null : bean.getRecordingInformation().buildVo();
		this.lastauthoringhcp = bean.getLastAuthoringHCP() == null ? null : bean.getLastAuthoringHCP().buildVo();
		this.diagnosis = ims.core.vo.PatientDiagnosisAtConsultationVoCollection.buildFromBeanCollection(bean.getDiagnosis());
		this.procedures = ims.core.vo.PatientProcedureShortVoCollection.buildFromBeanCollection(bean.getProcedures());
		this.firstdefinitivetreatmentdate = bean.getFirstDefinitiveTreatmentDate() == null ? null : bean.getFirstDefinitiveTreatmentDate().buildDate();
		this.investigationsandresults = bean.getInvestigationsAndResults();
		this.managementplan = bean.getManagementPlan();
		this.adviceandinfogiven = bean.getAdviceAndInfoGiven();
		this.actionrequiredbygp = bean.getActionRequiredByGP() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getActionRequiredByGP());
		this.actionrequiredbygpnotes = bean.getActionRequiredByGPNotes();
		this.patientconsent = bean.getPatientConsent() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getPatientConsent());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.DiagnosisManagementVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.RefMan.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.recordinginformation = bean.getRecordingInformation() == null ? null : bean.getRecordingInformation().buildVo(map);
		this.lastauthoringhcp = bean.getLastAuthoringHCP() == null ? null : bean.getLastAuthoringHCP().buildVo(map);
		this.diagnosis = ims.core.vo.PatientDiagnosisAtConsultationVoCollection.buildFromBeanCollection(bean.getDiagnosis());
		this.procedures = ims.core.vo.PatientProcedureShortVoCollection.buildFromBeanCollection(bean.getProcedures());
		this.firstdefinitivetreatmentdate = bean.getFirstDefinitiveTreatmentDate() == null ? null : bean.getFirstDefinitiveTreatmentDate().buildDate();
		this.investigationsandresults = bean.getInvestigationsAndResults();
		this.managementplan = bean.getManagementPlan();
		this.adviceandinfogiven = bean.getAdviceAndInfoGiven();
		this.actionrequiredbygp = bean.getActionRequiredByGP() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getActionRequiredByGP());
		this.actionrequiredbygpnotes = bean.getActionRequiredByGPNotes();
		this.patientconsent = bean.getPatientConsent() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getPatientConsent());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.DiagnosisManagementVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.DiagnosisManagementVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.DiagnosisManagementVoBean();
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
		if(fieldName.equals("DIAGNOSIS"))
			return getDiagnosis();
		if(fieldName.equals("PROCEDURES"))
			return getProcedures();
		if(fieldName.equals("FIRSTDEFINITIVETREATMENTDATE"))
			return getFirstDefinitiveTreatmentDate();
		if(fieldName.equals("INVESTIGATIONSANDRESULTS"))
			return getInvestigationsAndResults();
		if(fieldName.equals("MANAGEMENTPLAN"))
			return getManagementPlan();
		if(fieldName.equals("ADVICEANDINFOGIVEN"))
			return getAdviceAndInfoGiven();
		if(fieldName.equals("ACTIONREQUIREDBYGP"))
			return getActionRequiredByGP();
		if(fieldName.equals("ACTIONREQUIREDBYGPNOTES"))
			return getActionRequiredByGPNotes();
		if(fieldName.equals("PATIENTCONSENT"))
			return getPatientConsent();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDiagnosisIsNotNull()
	{
		return this.diagnosis != null;
	}
	public ims.core.vo.PatientDiagnosisAtConsultationVoCollection getDiagnosis()
	{
		return this.diagnosis;
	}
	public void setDiagnosis(ims.core.vo.PatientDiagnosisAtConsultationVoCollection value)
	{
		this.isValidated = false;
		this.diagnosis = value;
	}
	public boolean getProceduresIsNotNull()
	{
		return this.procedures != null;
	}
	public ims.core.vo.PatientProcedureShortVoCollection getProcedures()
	{
		return this.procedures;
	}
	public void setProcedures(ims.core.vo.PatientProcedureShortVoCollection value)
	{
		this.isValidated = false;
		this.procedures = value;
	}
	public boolean getFirstDefinitiveTreatmentDateIsNotNull()
	{
		return this.firstdefinitivetreatmentdate != null;
	}
	public ims.framework.utils.Date getFirstDefinitiveTreatmentDate()
	{
		return this.firstdefinitivetreatmentdate;
	}
	public void setFirstDefinitiveTreatmentDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.firstdefinitivetreatmentdate = value;
	}
	public boolean getInvestigationsAndResultsIsNotNull()
	{
		return this.investigationsandresults != null;
	}
	public String getInvestigationsAndResults()
	{
		return this.investigationsandresults;
	}
	public static int getInvestigationsAndResultsMaxLength()
	{
		return 5000;
	}
	public void setInvestigationsAndResults(String value)
	{
		this.isValidated = false;
		this.investigationsandresults = value;
	}
	public boolean getManagementPlanIsNotNull()
	{
		return this.managementplan != null;
	}
	public String getManagementPlan()
	{
		return this.managementplan;
	}
	public static int getManagementPlanMaxLength()
	{
		return 5000;
	}
	public void setManagementPlan(String value)
	{
		this.isValidated = false;
		this.managementplan = value;
	}
	public boolean getAdviceAndInfoGivenIsNotNull()
	{
		return this.adviceandinfogiven != null;
	}
	public String getAdviceAndInfoGiven()
	{
		return this.adviceandinfogiven;
	}
	public static int getAdviceAndInfoGivenMaxLength()
	{
		return 5000;
	}
	public void setAdviceAndInfoGiven(String value)
	{
		this.isValidated = false;
		this.adviceandinfogiven = value;
	}
	public boolean getActionRequiredByGPIsNotNull()
	{
		return this.actionrequiredbygp != null;
	}
	public ims.core.vo.lookups.YesNo getActionRequiredByGP()
	{
		return this.actionrequiredbygp;
	}
	public void setActionRequiredByGP(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.actionrequiredbygp = value;
	}
	public boolean getActionRequiredByGPNotesIsNotNull()
	{
		return this.actionrequiredbygpnotes != null;
	}
	public String getActionRequiredByGPNotes()
	{
		return this.actionrequiredbygpnotes;
	}
	public static int getActionRequiredByGPNotesMaxLength()
	{
		return 5000;
	}
	public void setActionRequiredByGPNotes(String value)
	{
		this.isValidated = false;
		this.actionrequiredbygpnotes = value;
	}
	public boolean getPatientConsentIsNotNull()
	{
		return this.patientconsent != null;
	}
	public ims.core.vo.lookups.YesNo getPatientConsent()
	{
		return this.patientconsent;
	}
	public void setPatientConsent(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.patientconsent = value;
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
		if(this.recordinginformation != null)
		{
			if(!this.recordinginformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.lastauthoringhcp != null)
		{
			if(!this.lastauthoringhcp.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.diagnosis != null)
		{
			if(!this.diagnosis.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.procedures != null)
		{
			if(!this.procedures.isValidated())
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
		if(this.catsreferral == null)
			listOfErrors.add("CatsReferral is mandatory");
		if(this.recordinginformation == null)
			listOfErrors.add("RecordingInformation is mandatory");
		if(this.recordinginformation != null)
		{
			String[] listOfOtherErrors = this.recordinginformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.lastauthoringhcp == null)
			listOfErrors.add("LastAuthoringHCP is mandatory");
		if(this.lastauthoringhcp != null)
		{
			String[] listOfOtherErrors = this.lastauthoringhcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.diagnosis != null)
		{
			String[] listOfOtherErrors = this.diagnosis.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.procedures != null)
		{
			String[] listOfOtherErrors = this.procedures.validate();
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
	
		DiagnosisManagementVo clone = new DiagnosisManagementVo(this.id, this.version);
		
		clone.catsreferral = this.catsreferral;
		if(this.recordinginformation == null)
			clone.recordinginformation = null;
		else
			clone.recordinginformation = (ims.core.vo.AuthoringInformationVo)this.recordinginformation.clone();
		if(this.lastauthoringhcp == null)
			clone.lastauthoringhcp = null;
		else
			clone.lastauthoringhcp = (ims.core.vo.AuthoringInformationVo)this.lastauthoringhcp.clone();
		if(this.diagnosis == null)
			clone.diagnosis = null;
		else
			clone.diagnosis = (ims.core.vo.PatientDiagnosisAtConsultationVoCollection)this.diagnosis.clone();
		if(this.procedures == null)
			clone.procedures = null;
		else
			clone.procedures = (ims.core.vo.PatientProcedureShortVoCollection)this.procedures.clone();
		if(this.firstdefinitivetreatmentdate == null)
			clone.firstdefinitivetreatmentdate = null;
		else
			clone.firstdefinitivetreatmentdate = (ims.framework.utils.Date)this.firstdefinitivetreatmentdate.clone();
		clone.investigationsandresults = this.investigationsandresults;
		clone.managementplan = this.managementplan;
		clone.adviceandinfogiven = this.adviceandinfogiven;
		if(this.actionrequiredbygp == null)
			clone.actionrequiredbygp = null;
		else
			clone.actionrequiredbygp = (ims.core.vo.lookups.YesNo)this.actionrequiredbygp.clone();
		clone.actionrequiredbygpnotes = this.actionrequiredbygpnotes;
		if(this.patientconsent == null)
			clone.patientconsent = null;
		else
			clone.patientconsent = (ims.core.vo.lookups.YesNo)this.patientconsent.clone();
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
		if (!(DiagnosisManagementVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DiagnosisManagementVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((DiagnosisManagementVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((DiagnosisManagementVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.diagnosis != null)
			count++;
		if(this.procedures != null)
			count++;
		if(this.firstdefinitivetreatmentdate != null)
			count++;
		if(this.investigationsandresults != null)
			count++;
		if(this.managementplan != null)
			count++;
		if(this.adviceandinfogiven != null)
			count++;
		if(this.actionrequiredbygp != null)
			count++;
		if(this.actionrequiredbygpnotes != null)
			count++;
		if(this.patientconsent != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 9;
	}
	protected ims.core.vo.PatientDiagnosisAtConsultationVoCollection diagnosis;
	protected ims.core.vo.PatientProcedureShortVoCollection procedures;
	protected ims.framework.utils.Date firstdefinitivetreatmentdate;
	protected String investigationsandresults;
	protected String managementplan;
	protected String adviceandinfogiven;
	protected ims.core.vo.lookups.YesNo actionrequiredbygp;
	protected String actionrequiredbygpnotes;
	protected ims.core.vo.lookups.YesNo patientconsent;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
