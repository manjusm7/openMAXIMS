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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.55 build 2755.18939)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.ccosched.domain.impl;

import ims.ccosched.domain.ActivityView;
import ims.ccosched.domain.base.impl.BaseUnconfirmedAppointmentsImpl;
import ims.core.domain.PatientSearch;
import ims.core.domain.impl.PatientSearchImpl;
import ims.core.vo.Patient;
import ims.core.vo.PatientFilter;
import ims.core.vo.PatientId;
import ims.core.vo.PatientShort;
import ims.core.vo.PatientShortCollection;
import ims.core.vo.lookups.PatIdType;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.dto.Result;
import ims.dto.client.Go_ptplact;
import ims.dto.client.Go_ptreatpl;
import ims.dto.client.Lkup;
import ims.dto.client.Sd_activity;
import ims.dto.client.Sd_activity_grp;
import ims.dto.client.Sd_appt;
import ims.dto.client.Sd_appt_dts;
import ims.framework.exceptions.CodingRuntimeException;

public class UnconfirmedAppointmentsImpl extends BaseUnconfirmedAppointmentsImpl
{
	private static final long	serialVersionUID	= -6470083149870449673L;

	public Patient getPatient(PatientShort patient) throws DomainInterfaceException, StaleObjectException
	{
		ActivityView impl = (ActivityView)getDomainImpl(ActivityViewImpl.class);
		return impl.getPatient(patient);
	}

	public Sd_activity_grp listActivityGroups(String act_ind_grp) throws DomainInterfaceException
	{
		Sd_activity_grp activityGroups = (Sd_activity_grp)getDTOInstance(Sd_activity_grp.class);
		activityGroups.Filter.clear();
		activityGroups.Filter.Act_ind_grp = "Y";

		Result result = activityGroups.list();
		if (result != null)
			throw new DomainInterfaceException(result.getMessage());
		
		return activityGroups;
	}

	public Sd_activity listActivities(String act_ind, String grp_act_ind) throws DomainInterfaceException
	{
		Sd_activity activities = (Sd_activity)getDTOInstance(Sd_activity.class);
		activities.Filter.clear();
		activities.Filter.Act_ind = "Y";
		activities.Filter.Grp_act_ind = "Y";

		Result result = activities.list();
		if (result != null)
		{
			throw new DomainInterfaceException(result.getMessage());
		}
		
		return activities;
	}

	public Sd_appt getAndGetForUpdateAppointment(String appt_head_id) throws DomainInterfaceException
	{
		if(appt_head_id == null)
			throw new CodingRuntimeException("Cannot get appointment for null appt_head_id");
		
		Sd_appt apptDto = (Sd_appt)getDTOInstance(Sd_appt.class);
		apptDto.Filter.clear();
		apptDto.Filter.Appt_head_id = appt_head_id;
		
		Result result = apptDto.get();
		if (result != null)
			throw new DomainInterfaceException(result.getMessage());

		//Get for Update
		result = apptDto.getForUpdate();
		if (result != null)
			throw new DomainInterfaceException(result.getMessage());
		
		return apptDto;
	}

	public Sd_appt updateAppointment(Sd_appt sd_appt) throws DomainInterfaceException
	{
		if(sd_appt == null)
			throw new CodingRuntimeException("Cannot update null appointment");
		
		Result result = sd_appt.update();
		if (result != null)
			throw new DomainInterfaceException(result.getMessage());
		
		return sd_appt;
	}
	
	public Lkup getLookupInstance(String lkup_type) throws DomainInterfaceException
	{
		ActivityView impl = (ActivityView)getDomainImpl(ActivityViewImpl.class);
		return impl.getLookupInstance(lkup_type);
	}

	public Go_ptplact getAction(String pt_act_id) throws DomainInterfaceException
	{
		if (pt_act_id == null)
			throw new CodingRuntimeException("Cannot get Action for null id");

		Go_ptplact actions = (Go_ptplact) getDTOInstance(Go_ptplact.class);
		actions.Filter.clear();
		actions.Filter.Pt_act_id = pt_act_id;

		Result result = actions.get();
		if (result != null)
			throw new DomainInterfaceException(result.getMessage());

		return actions;
	}

	public Go_ptreatpl getTreatmentPlan(String unid) throws DomainInterfaceException
	{
		if (unid == null)
			throw new CodingRuntimeException("Cannot get Treatment Plan for null id");

		Go_ptreatpl tp = (Go_ptreatpl) getDTOInstance(Go_ptreatpl.class);
		tp.Filter.clear();
		tp.Filter.Unid = unid;
		Result result = tp.get();
		if (result != null)
			throw new DomainInterfaceException(result.getMessage());

		return tp;
	}

	public Sd_appt_dts listAppointments(String grp_id, String activ_id, String confirm_stat, String appt_stat) throws DomainInterfaceException
	{
		if(grp_id == null)
			throw new CodingRuntimeException("Cannot list appointments for null Grp_id");
		
		if(activ_id == null)
			throw new CodingRuntimeException("Cannot list appointments for null Activ_id");
		
		Sd_appt_dts appointments = (Sd_appt_dts)getDTOInstance(Sd_appt_dts.class);
		appointments.Filter.clear();
		appointments.Filter.Grp_id	= grp_id;
		appointments.Filter.Activ_id = activ_id;
		appointments.Filter.Confirm_stat = confirm_stat;
		appointments.Filter.Appt_stat    = appt_stat;

		Result result = appointments.list();
		if (result != null)
			throw new DomainInterfaceException(result.getMessage());
		
		return appointments;
	}
	
	public ims.dto.client.Patient getPatient(String pkey) throws DomainInterfaceException
	{
		ActivityView impl = (ActivityView)getDomainImpl(ActivityViewImpl.class);
		return impl.getPatient(pkey);
		
	}
	public PatientShort getPatientShort(String pkey) throws DomainInterfaceException
	{
		PatientFilter filter = new PatientFilter();
		PatientId patientId = new PatientId();
		patientId.setIdValue(pkey);
		patientId.setType(PatIdType.PKEY);
		filter.setPersId(patientId);
		PatientSearch PatientSearchImpl = (PatientSearch) getDomainImpl(PatientSearchImpl.class);
		PatientShortCollection coll = PatientSearchImpl.searchPatients(filter);
		
		if(coll!=null && coll.size()>0)
			return coll.get(0);
		else 
			return null;		
	}
}