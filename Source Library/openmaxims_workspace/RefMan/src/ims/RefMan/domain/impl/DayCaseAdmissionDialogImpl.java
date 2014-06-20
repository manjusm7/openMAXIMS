// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.71 build 3618.29606)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.RefMan.domain.base.impl.BaseDayCaseAdmissionDialogImpl;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.domain.objects.PatientElectiveList;
import ims.RefMan.vo.PatientElectiveListBedAdmissionVo;
import ims.RefMan.vo.PatientElectiveListBedAdmissionVoCollection;
import ims.RefMan.vo.PatientElectiveListRefVo;
import ims.RefMan.vo.domain.CatsReferralWizardVoAssembler;
import ims.RefMan.vo.domain.PatientElectiveListBedAdmissionVoAssembler;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.domain.objects.CareContext;
import ims.core.clinical.domain.objects.Service;
import ims.core.clinical.vo.ServiceRefVo;
import ims.core.domain.ADT;
import ims.core.domain.impl.ADTImpl;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.domain.objects.MemberOfStaff;
import ims.core.vo.CareContextLiteVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.InpatientEpisodeVo;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.ServiceShortVo;
import ims.core.vo.domain.CareContextLiteVoAssembler;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.MemberOfStaffLiteVoAssembler;
import ims.core.vo.domain.PatientListVoAssembler;
import ims.core.vo.domain.ServiceShortVoAssembler;
import ims.core.vo.lookups.ReferralManagementContractType;
import ims.core.vo.lookups.Specialty;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.DateTime;
import ims.icp.vo.PatientICPFullVo;
import ims.icp.vo.domain.PatientICPFullVoAssembler;
import ims.icps.instantiation.domain.objects.PatientICP;
import ims.pathways.configuration.domain.objects.RTTStatusPoint;
import ims.pathways.domain.HL7PathwayIf;
import ims.pathways.domain.impl.HL7PathwayIfImpl;
import ims.pathways.domain.objects.PathwayRTTStatus;
import ims.pathways.domain.objects.RTTStatusEventMap;
import ims.pathways.vo.PatientEventVo;
import ims.pathways.vo.RTTStatusEventMapVo;
import ims.pathways.vo.domain.PatientJourneyVoAssembler;
import ims.pathways.vo.domain.RTTStatusEventMapVoAssembler;
import ims.pathways.vo.lookups.EventStatus;
import ims.scheduling.domain.objects.Booking_Appointment;
import ims.scheduling.vo.Appointment_StatusVo;
import ims.scheduling.vo.BookingAppointmentTheatreVo;
import ims.scheduling.vo.Booking_AppointmentRefVo;
import ims.scheduling.vo.domain.BookingAppointmentTheatreVoAssembler;
import ims.scheduling.vo.lookups.Status_Reason;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DayCaseAdmissionDialogImpl extends BaseDayCaseAdmissionDialogImpl
{

	private static final long serialVersionUID = 1L;
	private static final int START_OF_FIRST_DEFINITIVE_TREATMENT = 30;

	public ims.core.vo.LocShortMappingsVoCollection listActiveWardsForHospital(ims.core.resource.place.vo.LocationRefVo hospital)
	{
		OrganisationAndLocation implLoc = (OrganisationAndLocation)getDomainImpl(OrganisationAndLocationImpl.class);
		return implLoc.listActiveWardsForHospital(hospital);
	}

	public CareContextShortVo admitPatient(ims.core.vo.PatientShort patVo, ims.core.vo.InpatientEpisodeVo episVo, ims.scheduling.vo.Booking_AppointmentRefVo bookingApptVoRef, ims.RefMan.vo.CatsReferralWizardVo voCats, PatientElectiveListBedAdmissionVo patientElectiveList, PatientElectiveListBedAdmissionVoCollection differentPatientElectiveListForService) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException, ims.domain.exceptions.UniqueKeyViolationException
	{
		if (bookingApptVoRef == null || bookingApptVoRef.getID_Booking_Appointment() == null)
			throw new CodingRuntimeException("bookingApptVoRef is null or id not provide for method admitPatient");

		ADT implLoc = (ADT)getDomainImpl(ADTImpl.class);
		InpatientEpisodeVo voIP = implLoc.admitPatient(patVo, episVo, null);
		
		if ( !voIP.getAdmissionDateTime().equals(episVo.getAdmissionDateTime()))
		{
			throw new DomainInterfaceException("Patient is already an inpatient. Cannot Admit.");
		}

		DomainFactory factory = getDomainFactory();
		
		// Get PatientElectiveList domain object
		HashMap domMap = new HashMap();
		if (patientElectiveList != null)
		{
			PatientElectiveList domPatientElectiveList = PatientElectiveListBedAdmissionVoAssembler.extractPatientElectiveList(factory, patientElectiveList, domMap);
			factory.save(domPatientElectiveList);

			if (differentPatientElectiveListForService != null)
			{
				for (PatientElectiveListBedAdmissionVo patientElectiveListToCancel : differentPatientElectiveListForService)
				{
					PatientElectiveList domPatientElectiveListToCancel = PatientElectiveListBedAdmissionVoAssembler.extractPatientElectiveList(factory, patientElectiveListToCancel, domMap);
					factory.save(domPatientElectiveListToCancel);
				}
			}
		}

		//wdev-8305
		CatsReferral domCats = (CatsReferral) factory.getDomainObject(CatsReferral.class, voCats.getID_CatsReferral());
		domCats.setRequiresDischargeRep(null);
		domCats.setDischargeDate(null);//wdev-11889
		
		//WDEV-18316
		if (Boolean.TRUE.equals(ConfigFlag.DOM.RTT_STATUS_POINT_FUNCTIONALITY.getValue()) && Boolean.TRUE.equals(domCats.isRTTClockImpact()))
		{
			PathwayRTTStatus rttStatus = createPathwayRTTStatus(domCats);
			domCats.setCurrentRTTStatus(rttStatus);

			RTTStatusEventMapVo rttMap = getRTTStatusEventMap(rttStatus.getRTTStatus());

			if (rttMap != null && rttMap.getEvent() != null)
			{
				PatientEventVo patEvent = new PatientEventVo();
				patEvent.setPatient(PatientListVoAssembler.create(domCats.getPatient()));
				patEvent.setEvent(rttMap.getEvent());
				patEvent.setEventDateTime(new DateTime());
				patEvent.setEventStatus(EventStatus.ACTIVE);
				patEvent.setJourney(PatientJourneyVoAssembler.create(domCats.getJourney()));

				HL7PathwayIf impl = (HL7PathwayIf) getDomainImpl(HL7PathwayIfImpl.class);
				impl.instantiatePatientEvent(patEvent);
			}
		}
		
		factory.save(domCats);

		//Update the Status of the Appointment
		BookingAppointmentTheatreVo vo = BookingAppointmentTheatreVoAssembler.create((Booking_Appointment) getDomainFactory().getDomainObject(bookingApptVoRef));
		if (vo != null)
		{
			vo.getApptStatusHistory().add(vo.getCurrentStatusRecord());

			Appointment_StatusVo voApptStat = new Appointment_StatusVo();
			voApptStat.setStatus(Status_Reason.ADMITTED);
			//voApptStat.setStatusChangeDateTime(new DateTime());//WDEV-12760
			voApptStat.setStatusChangeDateTime(episVo.getAdmissionDateTime()); //wdev-12760
			vo.setCurrentStatusRecord(voApptStat);
			vo.setApptStatus(Status_Reason.ADMITTED);
			
			vo.setPASEvent(voIP.getPasEvent());//wdev-18155

			Booking_Appointment doAppt = BookingAppointmentTheatreVoAssembler.extractBooking_Appointment(factory, vo);
			factory.save(doAppt);
		}
		
		// Update the CareContext with PASEvent (WDEV-8364)
		CareContextLiteVo careContext = CareContextLiteVoAssembler.create((CareContext) getDomainFactory().getDomainObject(CareContext.class, voCats.getCareContext().getID_CareContext()));
		careContext.setPasEvent(voIP.getPasEvent());
		
		CareContext domCareContext = CareContextLiteVoAssembler.extractCareContext(factory, careContext);
		factory.save(domCareContext);
		
		//Update the ICP with PASEVent
		List picps = getDomainFactory().find("select picp from PatientICP picp left join picp.appointments as appts where appts.id = '" + bookingApptVoRef.getID_Booking_Appointment() + "' and picp.completedDateTime = null");
		if (picps != null && picps.size() == 1)
		{
			PatientICPFullVo voPatientICP = PatientICPFullVoAssembler.create((PatientICP) picps.get(0));
			if (voPatientICP != null)
			{
				voPatientICP.setPasEvent(voIP.getPasEvent());

				PatientICP doICP = PatientICPFullVoAssembler.extractPatientICP(factory, voPatientICP);

				factory.save(doICP);
			}
		}
		
		return CareContextShortVoAssembler.create(domCareContext);
	}

	private RTTStatusEventMapVo getRTTStatusEventMap(RTTStatusPoint rttStatusPoint)
	{
		if(rttStatusPoint == null)
			return null;
		
		String query = "select rttMap from RTTStatusEventMap as rttMap left join rttMap.currentRTTStatus as rtt where rtt.id = :RTTStatusPoint and rttMap.event is not null and rttMap.active = 1";
		List<?> listRTTMap = getDomainFactory().find(query, new String[] {"RTTStatusPoint"}, new Object[] {rttStatusPoint.getId()});
		
		if(listRTTMap != null && listRTTMap.size() > 0 && listRTTMap.get(0) instanceof RTTStatusEventMap)
		{
			return RTTStatusEventMapVoAssembler.create((RTTStatusEventMap) listRTTMap.get(0));
		}
		
		return null;
	}

	private PathwayRTTStatus createPathwayRTTStatus(CatsReferral domCats)
	{
		if(!ConfigFlag.DOM.RTT_STATUS_POINT_FUNCTIONALITY.getValue())
			return null;
		
		if(domCats == null)
			return null;
		
		RTTStatusPoint rttStatusPoint = getRTTStatusPoint(START_OF_FIRST_DEFINITIVE_TREATMENT);
		
		Object mos = getMosUser();
		MemberOfStaff doMos = null;
		
		if(mos instanceof MemberOfStaffLiteVo)
		{
			doMos = MemberOfStaffLiteVoAssembler.extractMemberOfStaff(getDomainFactory(), (MemberOfStaffLiteVo) mos);
		}
		
		PathwayRTTStatus pathwayRTTStatus = new PathwayRTTStatus();
		pathwayRTTStatus.setRTTStatus(rttStatusPoint);
		pathwayRTTStatus.setStatusBy(doMos);
		pathwayRTTStatus.setStatusDateTime(new java.util.Date());
		
		if(domCats.getJourney() != null && domCats.getJourney().getCurrentClock() != null)
    	{
			domCats.getJourney().getCurrentClock().setCurrentRTTStatus(pathwayRTTStatus);
    			
    		if(domCats.getJourney().getCurrentClock().getRTTStatusHistory() == null)
    			domCats.getJourney().getCurrentClock().setRTTStatusHistory(new java.util.ArrayList());
    			
    		domCats.getJourney().getCurrentClock().getRTTStatusHistory().add(pathwayRTTStatus);
    	}
		
		return pathwayRTTStatus;
	}

	private RTTStatusPoint getRTTStatusPoint(int nationalCode)
	{
		String query = "select rtt from RTTStatusPoint as rtt where rtt.nationalCode = :NationalCode";
		
		List<?> rttList = getDomainFactory().find(query, new String[] {"NationalCode"}, new Object[] {nationalCode});
		
		if(rttList != null && rttList.size() > 0 && rttList.get(0) instanceof RTTStatusPoint)
		{
			return (RTTStatusPoint) rttList.get(0);
		}
		
		return null;
	}

	/**
	* listActiveMedics
	*/
	public ims.core.vo.MedicLiteVoCollection listActiveMedics(String szName)
	{
		HcpAdmin implHCP = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return implHCP.listActiveMedics(szName);
	}

	public ims.RefMan.vo.CatsReferralWizardVo getCatsReferralWizardVoForCareContext(ims.core.admin.vo.CareContextRefVo voCarecontext)
	{
		if(voCarecontext == null || voCarecontext.getID_CareContext() == null)
			throw new CodingRuntimeException("CareContextRefVo is null or id not provide for CareContextRefVo");
		
		DomainFactory factory = getDomainFactory();
		List catsRef = factory.find("select catsRef from CatsReferral as catsRef where catsRef.careContext.id = '" + voCarecontext.getID_CareContext() + "')");
		if(catsRef != null && catsRef.size() > 0)
		{
			 CatsReferral val = (CatsReferral) catsRef.get(0);
			if(val != null)
			{
				return CatsReferralWizardVoAssembler.create(val);
			}
		}	
		return null;
	}

	/**
	* getCatsReferral
	*/
	public ims.RefMan.vo.CatsReferralWizardVo getCatsReferral(ims.scheduling.vo.Booking_AppointmentRefVo voBookingRefVo)
	{
		if(voBookingRefVo == null)
			throw new CodingRuntimeException("voBookingRefVo is null");
		
		DomainFactory factory = getDomainFactory();
		List lstCatsRef = factory.find("from CatsReferral catsRef where catsRef.appointments.id = '" + voBookingRefVo.getID_Booking_Appointment() + "'");
		if(lstCatsRef != null && lstCatsRef.size() == 1)
		{
			CatsReferral doCatsRef = (CatsReferral) lstCatsRef.get(0);
			return CatsReferralWizardVoAssembler.create(doCatsRef);
		}
		return null;
	}

	// WDEV-12293 
	public Specialty getReferralSpecialty(Booking_AppointmentRefVo bookingAppointment)
	{
		if (bookingAppointment == null || !bookingAppointment.getID_Booking_AppointmentIsNotNull())
			return null;
		
		String query = "select service from CatsReferral as referral left join referral.referralDetails as details left join details.service as service left join referral.appointments as appt where appt.id = :ID";
		
		ArrayList<String> paramNames = new ArrayList<String>(); paramNames.add("ID");
		ArrayList<Object> paramValues = new ArrayList<Object>(); paramValues.add(bookingAppointment.getID_Booking_Appointment());
		
		ServiceShortVo service = ServiceShortVoAssembler.create((Service) getDomainFactory().findFirst(query, paramNames, paramValues));
		
		return service.getSpecialty();
	}

	public PatientElectiveListBedAdmissionVo getPatientElectiveListForAppointment(Booking_AppointmentRefVo appointment)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean hasPatientElectiveListsToBeCancelled(PatientRefVo patient, PatientElectiveListRefVo patientElectiveList, ServiceRefVo service)
	{
		if (patient == null || patient.getID_Patient() == null)
			return Boolean.FALSE;
		
		if (service == null || service.getID_Service() == null)
			return Boolean.FALSE;
		
		StringBuilder query = new StringBuilder("SELECT COUNT(pel.id) FROM PatientElectiveList AS pel LEFT JOIN pel.electiveList AS el LEFT JOIN el.service AS serv LEFT JOIN pel.patient AS patient LEFT JOIN pel.tCIDetails AS tci");
		query.append(" WHERE pel.id <> :PEL_ID AND patient.id = :PAT_ID AND service.id = :SERVICE_ID AND tci.isActive = 0");
		
		ArrayList<String> paramNames = new ArrayList<String>();							ArrayList<Object> paramValues = new ArrayList<Object>();
		paramNames.add("PEL_ID");														paramValues.add(patientElectiveList.getID_PatientElectiveList());
		paramNames.add("PAT_ID");														paramValues.add(patient.getID_Patient());
		paramNames.add("SERVICE_ID");													paramValues.add(service.getID_Service());
		
		long count = getDomainFactory().countWithHQL(query.toString(), paramNames.toArray(new String[paramNames.size()]), paramValues.toArray(new Object[paramValues.size()]));
		
		if (count > 0)
			return Boolean.TRUE;
		
		return Boolean.FALSE;
	}

	public PatientElectiveListBedAdmissionVoCollection getDifferentPatientElectiveListForService(PatientRefVo patient, PatientElectiveListRefVo electiveList, ServiceRefVo service)
	{
		if (patient == null || patient.getID_Patient() == null)
			return null;
		
		if (service == null || service.getID_Service() == null)
			return null;
		
		StringBuilder query = new StringBuilder("SELECT pel FROM PatientElectiveList AS pel LEFT JOIN pel.electiveList AS el LEFT JOIN el.service AS service LEFT JOIN pel.patient AS patient LEFT JOIN pel.tCIDetails AS tci");
		query.append(" WHERE pel.id <> :PEL_ID AND patient.id = :PAT_ID AND service.id = :SERVICE_ID AND tci.isActive = 0");
		
		ArrayList<String> paramNames = new ArrayList<String>();							ArrayList<Object> paramValues = new ArrayList<Object>();
		paramNames.add("PEL_ID");														paramValues.add(electiveList.getID_PatientElectiveList());
		paramNames.add("PAT_ID");														paramValues.add(patient.getID_Patient());
		paramNames.add("SERVICE_ID");													paramValues.add(service.getID_Service());
		
		return PatientElectiveListBedAdmissionVoAssembler.createPatientElectiveListBedAdmissionVoCollectionFromPatientElectiveList(getDomainFactory().find(query.toString(), paramNames, paramValues));
	}
}
