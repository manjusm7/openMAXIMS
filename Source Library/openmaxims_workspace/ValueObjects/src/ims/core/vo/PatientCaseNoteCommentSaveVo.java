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
 * Linked to core.clinical.PatientCaseNoteComment business object (ID: 1003100133).
 */
public class PatientCaseNoteCommentSaveVo extends ims.core.clinical.vo.PatientCaseNoteCommentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientCaseNoteCommentSaveVo()
	{
	}
	public PatientCaseNoteCommentSaveVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientCaseNoteCommentSaveVo(ims.core.vo.beans.PatientCaseNoteCommentSaveVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.casenote = bean.getCaseNote() == null ? null : new ims.core.clinical.vo.PatientCaseNoteRefVo(new Integer(bean.getCaseNote().getId()), bean.getCaseNote().getVersion());
		this.authoredby = bean.getAuthoredBy() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getAuthoredBy().getId()), bean.getAuthoredBy().getVersion());
		this.authoreddate = bean.getAuthoredDate() == null ? null : bean.getAuthoredDate().buildDateTime();
		this.comment = bean.getComment();
		this.casenotefolderlocation = bean.getCaseNoteFolderLocation() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getCaseNoteFolderLocation().getId()), bean.getCaseNoteFolderLocation().getVersion());
		this.notetype = bean.getNoteType() == null ? null : ims.core.vo.lookups.CaseNoteCommentType.buildLookup(bean.getNoteType());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientCaseNoteCommentSaveVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.casenote = bean.getCaseNote() == null ? null : new ims.core.clinical.vo.PatientCaseNoteRefVo(new Integer(bean.getCaseNote().getId()), bean.getCaseNote().getVersion());
		this.authoredby = bean.getAuthoredBy() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getAuthoredBy().getId()), bean.getAuthoredBy().getVersion());
		this.authoreddate = bean.getAuthoredDate() == null ? null : bean.getAuthoredDate().buildDateTime();
		this.comment = bean.getComment();
		this.casenotefolderlocation = bean.getCaseNoteFolderLocation() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getCaseNoteFolderLocation().getId()), bean.getCaseNoteFolderLocation().getVersion());
		this.notetype = bean.getNoteType() == null ? null : ims.core.vo.lookups.CaseNoteCommentType.buildLookup(bean.getNoteType());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientCaseNoteCommentSaveVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientCaseNoteCommentSaveVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientCaseNoteCommentSaveVoBean();
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
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("CASENOTE"))
			return getCaseNote();
		if(fieldName.equals("AUTHOREDBY"))
			return getAuthoredBy();
		if(fieldName.equals("AUTHOREDDATE"))
			return getAuthoredDate();
		if(fieldName.equals("COMMENT"))
			return getComment();
		if(fieldName.equals("CASENOTEFOLDERLOCATION"))
			return getCaseNoteFolderLocation();
		if(fieldName.equals("NOTETYPE"))
			return getNoteType();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getCaseNoteIsNotNull()
	{
		return this.casenote != null;
	}
	public ims.core.clinical.vo.PatientCaseNoteRefVo getCaseNote()
	{
		return this.casenote;
	}
	public void setCaseNote(ims.core.clinical.vo.PatientCaseNoteRefVo value)
	{
		this.isValidated = false;
		this.casenote = value;
	}
	public boolean getAuthoredByIsNotNull()
	{
		return this.authoredby != null;
	}
	public ims.core.resource.people.vo.MemberOfStaffRefVo getAuthoredBy()
	{
		return this.authoredby;
	}
	public void setAuthoredBy(ims.core.resource.people.vo.MemberOfStaffRefVo value)
	{
		this.isValidated = false;
		this.authoredby = value;
	}
	public boolean getAuthoredDateIsNotNull()
	{
		return this.authoreddate != null;
	}
	public ims.framework.utils.DateTime getAuthoredDate()
	{
		return this.authoreddate;
	}
	public void setAuthoredDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.authoreddate = value;
	}
	public boolean getCommentIsNotNull()
	{
		return this.comment != null;
	}
	public String getComment()
	{
		return this.comment;
	}
	public static int getCommentMaxLength()
	{
		return 2500;
	}
	public void setComment(String value)
	{
		this.isValidated = false;
		this.comment = value;
	}
	public boolean getCaseNoteFolderLocationIsNotNull()
	{
		return this.casenotefolderlocation != null;
	}
	public ims.core.resource.place.vo.LocationRefVo getCaseNoteFolderLocation()
	{
		return this.casenotefolderlocation;
	}
	public void setCaseNoteFolderLocation(ims.core.resource.place.vo.LocationRefVo value)
	{
		this.isValidated = false;
		this.casenotefolderlocation = value;
	}
	public boolean getNoteTypeIsNotNull()
	{
		return this.notetype != null;
	}
	public ims.core.vo.lookups.CaseNoteCommentType getNoteType()
	{
		return this.notetype;
	}
	public void setNoteType(ims.core.vo.lookups.CaseNoteCommentType value)
	{
		this.isValidated = false;
		this.notetype = value;
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.casenote == null)
			listOfErrors.add("CaseNote is mandatory");
		if(this.authoredby == null)
			listOfErrors.add("AuthoredBy is mandatory");
		if(this.authoreddate == null)
			listOfErrors.add("AuthoredDate is mandatory");
		if(this.comment == null || this.comment.length() == 0)
			listOfErrors.add("Comment is mandatory");
		else if(this.comment.length() > 2500)
			listOfErrors.add("The length of the field [comment] in the value object [ims.core.vo.PatientCaseNoteCommentSaveVo] is too big. It should be less or equal to 2500");
		if(this.casenotefolderlocation == null)
			listOfErrors.add("Case Note Folder Location is mandatory");
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
	
		PatientCaseNoteCommentSaveVo clone = new PatientCaseNoteCommentSaveVo(this.id, this.version);
		
		clone.patient = this.patient;
		clone.casenote = this.casenote;
		clone.authoredby = this.authoredby;
		if(this.authoreddate == null)
			clone.authoreddate = null;
		else
			clone.authoreddate = (ims.framework.utils.DateTime)this.authoreddate.clone();
		clone.comment = this.comment;
		clone.casenotefolderlocation = this.casenotefolderlocation;
		if(this.notetype == null)
			clone.notetype = null;
		else
			clone.notetype = (ims.core.vo.lookups.CaseNoteCommentType)this.notetype.clone();
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
		if (!(PatientCaseNoteCommentSaveVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientCaseNoteCommentSaveVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientCaseNoteCommentSaveVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientCaseNoteCommentSaveVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patient != null)
			count++;
		if(this.casenote != null)
			count++;
		if(this.authoredby != null)
			count++;
		if(this.authoreddate != null)
			count++;
		if(this.comment != null)
			count++;
		if(this.casenotefolderlocation != null)
			count++;
		if(this.notetype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.clinical.vo.PatientCaseNoteRefVo casenote;
	protected ims.core.resource.people.vo.MemberOfStaffRefVo authoredby;
	protected ims.framework.utils.DateTime authoreddate;
	protected String comment;
	protected ims.core.resource.place.vo.LocationRefVo casenotefolderlocation;
	protected ims.core.vo.lookups.CaseNoteCommentType notetype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}