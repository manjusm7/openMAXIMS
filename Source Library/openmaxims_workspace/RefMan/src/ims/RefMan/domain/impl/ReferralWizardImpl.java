// This code was generated by Marius Mihalec using IMS Development Environment (version 1.65 build 3160.29066)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.RefMan.domain.impl;

import ims.admin.domain.MosAdmin;
import ims.admin.domain.Service;
import ims.admin.domain.impl.MosAdminImpl;
import ims.admin.domain.impl.ServiceImpl;
import ims.RefMan.domain.BookAppointment;
import ims.RefMan.domain.SecondOpinionDialog;
import ims.RefMan.domain.base.impl.BaseReferralWizardImpl;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.domain.objects.OrderInvAppt;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.CatsReferralWizardVo;
import ims.RefMan.vo.domain.CatsReferralWizardVoAssembler;
import ims.RefMan.vo.lookups.ReferralUrgency;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.domain.objects.CareContext;
import ims.core.admin.domain.objects.Referral;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.admin.vo.ReferralRefVo;
import ims.core.domain.CareSpellDialog;
import ims.core.domain.impl.CareSpellDialogImpl;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.domain.objects.MemberOfStaff;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.CareSpellVo;
import ims.core.vo.GpShortVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.MemberOfStaffVo;
import ims.core.vo.Patient;
import ims.core.vo.ServiceVo;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.GpShortVoAssembler;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.MemberOfStaffLiteVoAssembler;
import ims.core.vo.domain.PatientAssembler;
import ims.core.vo.lookups.PollStatus;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.core.vo.lookups.ReferralType;
import ims.core.vo.lookups.SourceOfReferral;
import ims.core.vo.lookups.Specialty;
import ims.core.vo.lookups.TaxonomyType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.lookups.LookupInstance;
import ims.framework.enumerations.SystemLogLevel;
import ims.framework.enumerations.SystemLogType;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.DateTime;
import ims.ocrr.orderingresults.domain.objects.OcsOrderSession;
import ims.ocrr.orderingresults.domain.objects.OrderInvestigation;
import ims.ocrr.orderingresults.vo.OrderInvestigationRefVo;
import ims.pathways.configuration.domain.objects.RTTStatusPoint;
import ims.pathways.configuration.vo.TargetRefVo;
import ims.pathways.domain.HL7PathwayIf;
import ims.pathways.domain.impl.HL7PathwayIfImpl;
import ims.pathways.domain.objects.PathwayRTTStatus;
import ims.pathways.domain.objects.PatientPathwayJourney;
import ims.pathways.domain.objects.RTTStatusEventMap;
import ims.pathways.vo.PathwayClockVo;
import ims.pathways.vo.PathwayClockVoCollection;
import ims.pathways.vo.PatientEventVo;
import ims.pathways.vo.PatientJourneyVo;
import ims.pathways.vo.RTTStatusEventMapVo;
import ims.pathways.vo.domain.PatientJourneyVoAssembler;
import ims.pathways.vo.domain.RTTStatusEventMapVoAssembler;
import ims.pathways.vo.lookups.EventStatus;
import ims.pathways.vo.lookups.PatientTargetStatus;
import ims.scheduling.domain.OCSExternalEvents;
import ims.scheduling.domain.impl.OCSExternalEventsImpl;
import ims.scheduling.domain.objects.Booking_Appointment;
import ims.scheduling.vo.Booking_AppointmentRefVo;
import ims.scheduling.vo.lookups.Status_Reason;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ReferralWizardImpl extends BaseReferralWizardImpl implements SecondOpinionDialog
{
	private static final long serialVersionUID = 1L;
	
	private static final int GP_SOURCE_OF_REFERRAL_NAT_CODE = 10;
	private static final int OTHER_SOURCE_OF_REFERRAL_NAT_CODE = 12;

	public Patient getPatient(PatientRefVo patient) throws DomainInterfaceException 
	{
		if(patient == null || patient.getID_Patient() == null)
			throw new DomainRuntimeException("Invalid patient");
				
		return PatientAssembler.create((ims.core.patient.domain.objects.Patient)getDomainFactory().getDomainObject(patient));
	}

	public CatsReferralWizardVo getCatsReferral(CatsReferralRefVo voCatsRef) 
	{
		return CatsReferralWizardVoAssembler.create((CatsReferral)getDomainFactory().getDomainObject(CatsReferral.class, voCatsRef.getID_CatsReferral()));
	}

	public CatsReferralWizardVo saveCatsReferral(CatsReferralWizardVo record) throws DomainInterfaceException, StaleObjectException 
	{
		if(record == null)
			throw new DomainRuntimeException("Invalid referral wizard to save");
		if(!record.isValidated())
			throw new DomainRuntimeException("Record not validated before save");
		
		boolean isNewCatsReferral = record.getID_CatsReferral() == null;
		DomainFactory factory = getDomainFactory();
		
		//wdev-18432
		//12. On saving the Referral, If PathwayID is entered in the Referral Transfer Object, this will be saved as the PathwayID in the CatsReferral as well as the ExtClockId in the 
		//PathwayClock. If this is not entered, the PathwayId will be the CatsReferralId formatted prepended with ORG Code. The field size is 20 characters and will be formatted with 3 
		//characters containing the organisation code followed by 0 padded CatsReferral Id. 
		//e.g. OrganisationCode = MK1, CatsReferral.id = 3421 - PathwayID = MK100000000000003421 

		CatsReferral domainObject = null;

		if (record.getPathwayID() == null )
		{
			if (record.getID_CatsReferral() == null)//wdev-18550
			{
				domainObject = CatsReferralWizardVoAssembler.extractCatsReferral(factory, record);
				record = CatsReferralWizardVoAssembler.create(domainObject);
			}

			String orgCode = "";
			String szZeros = "";

			if (record.getReferralDetails() != null
				&& record.getReferralDetails().getReferrerType() != null)
			{
				if(record.getReferralDetails().getReferrerType().equals(SourceOfReferral.TRANSFER))
					orgCode = record.getReferralTransfer().getOTherOrganisationCode();
				else
					orgCode = record.getReferralDetails().getPCT();
			}
			
			if (orgCode.length() == 3)
				szZeros = "00000000000000000";
			else if (orgCode.length() == 4)
				szZeros = "0000000000000000";
			else if (orgCode.length() == 5)
				szZeros = "000000000000000";

			DecimalFormat myFormatter = new DecimalFormat(orgCode + szZeros);
			record.setPathwayID(myFormatter.format(record.getID_CatsReferral()));
		}

		// Save PatientJourney for this referral
		PatientPathwayJourney journey = createJourney(factory,record);
		
		domainObject = CatsReferralWizardVoAssembler.extractCatsReferral(factory, record);
		
		domainObject.setJourney(journey);
		
		PathwayRTTStatus rttStatus = null;
		if(ConfigFlag.DOM.RTT_STATUS_POINT_FUNCTIONALITY.getValue() && isNewCatsReferral && Boolean.TRUE.equals(record.getRTTClockImpact()))
		{
			rttStatus = createPathwayRTTStatus(domainObject);
			domainObject.setCurrentRTTStatus(rttStatus);
		}
		
		factory.save(domainObject);
		
		if(ConfigFlag.DOM.RTT_STATUS_POINT_FUNCTIONALITY.getValue() && rttStatus != null && isNewCatsReferral && Boolean.TRUE.equals(record.getRTTClockImpact()))
		{
			RTTStatusEventMapVo rttMap = getRTTStatusEventMap(rttStatus.getRTTStatus());
			
			if(rttMap != null && rttMap.getEvent() != null)
			{
				PatientEventVo patEvent = new PatientEventVo();
				patEvent.setPatient(record.getPatient());
				patEvent.setEvent(rttMap.getEvent());
				patEvent.setEventDateTime(new DateTime());
				patEvent.setEventStatus(EventStatus.ACTIVE);
				patEvent.setJourney(PatientJourneyVoAssembler.create(domainObject.getJourney()));
				
				HL7PathwayIf impl = (HL7PathwayIf) getDomainImpl(HL7PathwayIfImpl.class);
				impl.instantiatePatientEvent(patEvent);
			}
		}
				
		return CatsReferralWizardVoAssembler.create(domainObject);
	}

	private PathwayRTTStatus createPathwayRTTStatus(CatsReferral record)
	{
		if(!ConfigFlag.DOM.RTT_STATUS_POINT_FUNCTIONALITY.getValue())
			return null;
		
		if(record == null)
			return null;
		
		int nationalCode = OTHER_SOURCE_OF_REFERRAL_NAT_CODE;
		
		if(record.getReferralDetails() != null && record.getReferralDetails().getReferrerType() != null && SourceOfReferral.GP.getID() == record.getReferralDetails().getReferrerType().getId())
		{
			nationalCode = GP_SOURCE_OF_REFERRAL_NAT_CODE;
		}
		
		RTTStatusPoint rttStatusPoint = getRTTStatusPoint(nationalCode);
		Object mos = getMosUser();
		MemberOfStaff doMos = null;
		
		if(mos instanceof MemberOfStaffLiteVo)
		{
			doMos = MemberOfStaffLiteVoAssembler.extractMemberOfStaff(getDomainFactory(), (MemberOfStaffLiteVo) mos);
		}
		
		PathwayRTTStatus pathwayRTTStatus = new PathwayRTTStatus();
		pathwayRTTStatus.setRTTStatus(rttStatusPoint);
		pathwayRTTStatus.setStatusBy(doMos);
		pathwayRTTStatus.setStatusDateTime(new Date());
		
		if(record.getJourney() != null && record.getJourney().getCurrentClock() != null)
    	{
			record.getJourney().getCurrentClock().setCurrentRTTStatus(pathwayRTTStatus);
    			
    		if(record.getJourney().getCurrentClock().getRTTStatusHistory() == null)
    			record.getJourney().getCurrentClock().setRTTStatusHistory(new java.util.ArrayList());
    			
    		record.getJourney().getCurrentClock().getRTTStatusHistory().add(pathwayRTTStatus);
    	}
		
		return pathwayRTTStatus;
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

	// WDEV-17927 
	private PatientPathwayJourney createJourney(DomainFactory factory, CatsReferralWizardVo referral) 
	{
		// Only create the patient journey if the flag specified to do this.
		// WDEV-18483 - the patient journey gets created regardless of Elective List flag value
		//if (!ConfigFlag.GEN.USE_ELECTIVE_LIST_FUNCTIONALITY.getValue())
		//	return null;
		
		// If a patientjourney already exists for the referral, then don't create a new one
		if (referral != null && referral.getID_CatsReferralIsNotNull())
		{
			CatsReferral domReferral = (CatsReferral) factory.getDomainObject(CatsReferral.class, referral.getID_CatsReferral());
			if (domReferral != null && domReferral.getJourney() != null)
				return domReferral.getJourney();
		}
		
		PatientJourneyVo journey = new PatientJourneyVo();
				
		
		HL7PathwayIf impl = (HL7PathwayIf) getDomainImpl(HL7PathwayIfImpl.class);
		try 
		{
			// Create the holding referral first
			Referral domReferral = new Referral();
			domReferral.setAuthoringDateTime(new java.util.Date());			
			//WDEV-18395
			if (referral.getPathwayID()!=null && !referral.getPathwayID().equals(""))
				domReferral.setClockId(referral.getPathwayID());
			else
				domReferral.setClockId("MAXIMS_1");
			domReferral.setReferralType(factory.getLookupInstance(ReferralType.INTERNAL.getId()));
			domReferral.setExtReferralKey("IMS_" + new java.util.Date().getTime());
			domReferral.setPatient((ims.core.patient.domain.objects.Patient) factory.getDomainObject(ims.core.patient.domain.objects.Patient.class, referral.getPatient().getID_Patient()));
			
			// New Patient - need to save it
			if (referral.getPatientIsNotNull() && !referral.getPatient().getID_PatientIsNotNull())
			{
				ims.core.patient.domain.objects.Patient domPatient = PatientAssembler.extractPatient(factory, referral.getPatient());
				factory.save(domPatient);
				domReferral.setPatient(domPatient);
				Patient voPatient = PatientAssembler.create(domPatient);
				journey.setPatient(voPatient);
			}
			else
			{
				domReferral.setPatient(PatientAssembler.extractPatient(factory, referral.getPatient()));
				journey.setPatient(referral.getPatient());

			}
			factory.save(domReferral);
						
			journey.setReferral(new ReferralRefVo(domReferral.getId(), domReferral.getVersion()));
			
			if (referral.getReferralDetailsIsNotNull())
			{
				journey.setStartDate(referral.getReferralDetails().getDateOfReferral());
			}
			journey.setExtReferralKey(domReferral.getExtReferralKey());
			journey.setTargetEndDate(referral.getReferralDetails().getEnd18WW());
						
			if(Boolean.TRUE.equals(referral.getRTTClockImpact()))
			{
    			PathwayClockVo clock = new PathwayClockVo();
    			clock.setExtClockId(domReferral.getClockId());
    			clock.setExtClockName("MaximsClock_1");
    			clock.setStartDate(journey.getStartDate());
    			journey.setCurrentClock(clock);
    			if (!journey.getClockHistoryIsNotNull())
    				journey.setClockHistory(new PathwayClockVoCollection());
    			journey.getClockHistory().add(clock);
			}
			
			// Services specialty - if not set then use Emergency
			if (referral.getReferralDetailsIsNotNull() && referral.getReferralDetails().getServiceIsNotNull() && referral.getReferralDetails().getService().getSpecialtyIsNotNull())
				journey = impl.createPatientJourney(journey, null, referral.getReferralDetails().getService().getSpecialty(), null,null);			
			else	
				journey = impl.createPatientJourney(journey, null, Specialty.EMERGENCY, null,null);
			
			return PatientJourneyVoAssembler.extractPatientPathwayJourney(factory, journey);
		} 
		catch (DomainInterfaceException e) 
		{
			super.createSystemLogEntry(SystemLogType.APPLICATION, SystemLogLevel.ERROR, "Domain Interface Exception occurred creating patient journey - " + e.getMessage());
			return null;
		} 
		catch (StaleObjectException e) 
		{
			super.createSystemLogEntry(SystemLogType.APPLICATION, SystemLogLevel.ERROR, "Stale Object Exception occurred creating patient journey - " + e.getMessage());
			return null;
		}
		
		
		
	}

	public HcpLiteVo getHcpLiteById(HcpRefVo refId)
	{
		if(refId == null)
			throw new CodingRuntimeException("null refId passed to getHcpById() !");

		DomainFactory factory = getDomainFactory();
		
		ims.core.resource.people.domain.objects.Hcp boHcp = (ims.core.resource.people.domain.objects.Hcp)factory.getDomainObject(ims.core.resource.people.domain.objects.Hcp.class, refId.getID_Hcp());
		
		return HcpLiteVoAssembler.create(boHcp);
	}

	public CatsReferralWizardVo saveCareSpellAndReferralDetails(CatsReferralWizardVo referVo, CareSpellVo voCareSpell, Boolean bDiagnosticReferral) throws StaleObjectException, DomainInterfaceException
	{
		CareSpellDialog careSpell = (CareSpellDialog) getDomainImpl(CareSpellDialogImpl.class);
		CareSpellVo doCareSpell = careSpell.saveCareSpell(voCareSpell);		
	
		if (doCareSpell != null
			&& doCareSpell.getEpisodesIsNotNull()
			&& doCareSpell.getEpisodes().size() > 0
			&& doCareSpell.getEpisodes().get(0).getCareContextsIsNotNull()
			&& doCareSpell.getEpisodes().get(0).getCareContexts().size() > 0)
		{
			referVo.setCareContext(doCareSpell.getEpisodes().get(0).getCareContexts().get(0));
			
			//WDEV-18194
			if (referVo.getReferralDetails() != null && referVo.getReferralDetails().getTransportRequirements() != null)
			{
				referVo.getReferralDetails().getTransportRequirements().setCareContext(doCareSpell.getEpisodes().get(0).getCareContexts().get(0));
			}
			
			referVo = saveReferraDetails(referVo, bDiagnosticReferral);
		}
		else
			referVo = null;
				
		
		return referVo;
	}	
	
	/**
	 * WDEV-18452, WDEV-18548
	 * We have created the patient journey, we now need to check the urgency of the referral
	 * if it is Two Week Wait or Consultant Upgrade, we want to instantiate the event that will
	 * bring the 62 day target into scope
	 * @param referral
	 * @param prevReferralUrgency 
	 * @param journey
	 * @param hl7Impl 
	 * @throws StaleObjectException 
	 * @throws DomainInterfaceException 
	 */
	public void check62dayTarget(CatsReferralWizardVo referral, ReferralUrgency prevReferralUrgency) throws DomainInterfaceException, StaleObjectException 
	{
		// Only create the patient journey if the flag specified to do this.
		if (!ConfigFlag.GEN.USE_ELECTIVE_LIST_FUNCTIONALITY.getValue())
			return;
	
		DomainFactory factory = getDomainFactory();
						
		if (referral != null && (referral.getUrgency() == null || (referral.getUrgencyIsNotNull() 
				&& !referral.getUrgency().equals(ReferralUrgency.CONSULTANT_UPGRADE)
				&& !referral.getUrgency().equals(ReferralUrgency.TWO_WEEK_WAIT))))
		{
			// We may be looking at a downgrade, so if previous is one of these we also want to check below
			if (prevReferralUrgency != null 
					&& prevReferralUrgency.getId() != ReferralUrgency.CONSULTANT_UPGRADE.getId()
					&& prevReferralUrgency.getId() != ReferralUrgency.TWO_WEEK_WAIT.getId())
			return;
			
			if (prevReferralUrgency == null || referral.getUrgency() ==  null)
				return;
		}
		
		// Only perform the following checks if the urgency value has changed
		if (prevReferralUrgency != null && prevReferralUrgency.getId() == referral.getUrgency().getId())
			return;
			
			
		// Get the Patient Journey from referral
		CatsReferral domReferral = (CatsReferral) factory.getDomainObject(CatsReferral.class, referral.getID_CatsReferral());
		
		HL7PathwayIf hl7Impl = (HL7PathwayIf) getDomainImpl(HL7PathwayIfImpl.class);
			
		PatientEventVo patientEvent = new PatientEventVo();
		patientEvent.setEventDateTime(new DateTime());
		
		if (referral != null && referral.getUrgencyIsNotNull() && referral.getUrgency().equals(ReferralUrgency.CONSULTANT_UPGRADE))
		{
			// Find the event that needs to be instantiated - PAS mapping of type CONS is required for Consultant Upgrade
			try 
			{
				ims.pathways.vo.EventVo pthwEvent = hl7Impl.getEventByTaxonomyMap(TaxonomyType.PAS, "CONS");
				if (pthwEvent == null)
					return;
				patientEvent.setEvent(pthwEvent);
				patientEvent.setEventDateTime(new DateTime(referral.getConsUpgradeDate()));
			}
			catch (DomainInterfaceException e) 
			{
				super.createSystemLogEntry(SystemLogType.APPLICATION, SystemLogLevel.WARNING, "Event was not found for Consultant Upgrade - Pas mapping = CONS");
				return;
			}
		}
		else if (referral != null && referral.getUrgencyIsNotNull() && referral.getUrgency().equals(ReferralUrgency.TWO_WEEK_WAIT))
		{
			// Find the event that needs to be instantiated - PAS mapping of type TWO is required for Two Week Wait
			try 
			{
				// If there is already an active PatientEvent for Consultant Upgrade type and 62 day target is in scope, we do not want to instantiate this one
				TargetRefVo target = hl7Impl.getTargetByTaxonomyMap(TaxonomyType.PAS, "62D");
				
				StringBuffer hql = new StringBuffer(" select pev from PatientEvent pev join pev.event ev join ev.taxonomyMaps tx ");
				
				if (target != null)
				{
					hql.append(" join pev.patientTarget pjt ");
				}
				
				hql.append(" where pev.journey = :journey and pev.eventStatus.id = :status " +
								" and ev.status.id = :evstatus and tx.taxonomyName = :taxType and tx.taxonomyCode = :taxCode");
				ArrayList<String> labels = new ArrayList<String>();
				ArrayList<Object> values = new ArrayList<Object>();
				labels.add("journey");
				labels.add("status");
				labels.add("evstatus");
				labels.add("taxType");
				labels.add("taxCode");
				values.add(domReferral.getJourney());
				values.add(EventStatus.ACTIVE.getId());
				values.add(PreActiveActiveInactiveStatus.ACTIVE.getId());
				values.add(getDomLookup(TaxonomyType.PAS));
				values.add("CONS");
				
				if (target != null)
				{
					hql.append(" and pjt.pathwayTarget.target.id = :target and pjt.currentStatus.status.id = :inscope ");
					labels.add("target");
					labels.add("inscope");
					values.add(target.getID_Target());
					values.add(PatientTargetStatus.INSCOPE.getId());
				}
				
				List lst = factory.find(hql.toString(), labels, values);
				if (lst != null && lst.size() > 1)
				{
					super.createSystemLogEntry(SystemLogType.APPLICATION, SystemLogLevel.WARNING, "TwoWeekWait will not be instantiated as PatientEvent already found for Consultant Upgrade");
					return;
				}
				
				ims.pathways.vo.EventVo pthwEvent = hl7Impl.getEventByTaxonomyMap(TaxonomyType.PAS, "TWO");
				if (pthwEvent == null)
				{
					super.createSystemLogEntry(SystemLogType.APPLICATION, SystemLogLevel.WARNING, "Event was not found for Two Week Wait - Pas mapping = TWO");
					return;
				}
				patientEvent.setEvent(pthwEvent);
				patientEvent.setEventDateTime(new DateTime(referral.getReferralDetails().getDateReferralReceived()));
				
			}
			catch (DomainInterfaceException e) 
			{
				super.createSystemLogEntry(SystemLogType.APPLICATION, SystemLogLevel.WARNING, "Event was not found for Two Week Wait - Pas mapping = TWO " + e.getMessage());
				return;
			}
		}
		else if (referral != null && referral.getUrgencyIsNotNull())
		{
			// Downgrade - Check the Event that needs to be instantiated - PAS mapping of type DGD required
			try 
			{
				ims.pathways.vo.EventVo pthwEvent = hl7Impl.getEventByTaxonomyMap(TaxonomyType.PAS, "DGD");
				if (pthwEvent == null)
				{
					super.createSystemLogEntry(SystemLogType.APPLICATION, SystemLogLevel.WARNING, "Event was not found for Downgrade from TwoWeekWait or Consultant Upgrade - Pas mapping = DGD");
					return;
				}
				patientEvent.setEvent(pthwEvent);
			}
			catch (DomainInterfaceException e) 
			{
				super.createSystemLogEntry(SystemLogType.APPLICATION, SystemLogLevel.WARNING, "Event was not found for Downgrade from TwoWeekWait or Consultant Upgrade - Pas mapping = DGD " + e.getMessage());
				return;
			}
		}
		
		patientEvent.setJourney(PatientJourneyVoAssembler.create(domReferral.getJourney()));
		patientEvent.setPatient(referral.getPatient());
		patientEvent.setEventStatus(EventStatus.ACTIVE);

		hl7Impl.instantiatePatientEvent(patientEvent);
	
	}

	
	public CatsReferralWizardVo saveReferraDetails(CatsReferralWizardVo referVo, Boolean bDiagnosticReferral) throws StaleObjectException, DomainInterfaceException
	{
		boolean isNewCatsReferral = referVo.getID_CatsReferral() == null;
		DomainFactory factory = getDomainFactory();

		// WDEV-18452 - before save of the catsReferral, I need to hold onto the original Urgency value
		LookupInstance prevReferralUrgency=null;
		if (!isNewCatsReferral)
		{
			CatsReferral domCatsRef = (CatsReferral)factory.getDomainObject(CatsReferral.class, referVo.getID_CatsReferral());
			prevReferralUrgency = domCatsRef.getUrgency();
		}

		
		// Save PatientJourney for this referral
		PatientPathwayJourney journey = createJourney(factory,referVo);
		
		CatsReferral doCatsReferral = CatsReferralWizardVoAssembler.extractCatsReferral(factory, referVo);
		
		doCatsReferral.setJourney(journey);
		
		//WDEV-7471
		boolean isCreateOrder = doCatsReferral.getId() == null;
		
		
		PathwayRTTStatus rttStatus = null;
		if(ConfigFlag.DOM.RTT_STATUS_POINT_FUNCTIONALITY.getValue() && isNewCatsReferral && Boolean.TRUE.equals(referVo.getRTTClockImpact()))
		{
			rttStatus = createPathwayRTTStatus(doCatsReferral);
			doCatsReferral.setCurrentRTTStatus(rttStatus);
		}
		
		factory.save(doCatsReferral);
		
		if(ConfigFlag.DOM.RTT_STATUS_POINT_FUNCTIONALITY.getValue() && rttStatus != null && isNewCatsReferral && Boolean.TRUE.equals(referVo.getRTTClockImpact()))
		{
			RTTStatusEventMapVo rttMap = getRTTStatusEventMap(rttStatus.getRTTStatus());
			
			if(rttMap != null && rttMap.getEvent() != null)
			{
				PatientEventVo patEvent = new PatientEventVo();
				patEvent.setPatient(referVo.getPatient());
				patEvent.setEvent(rttMap.getEvent());
				patEvent.setEventDateTime(new DateTime());
				patEvent.setEventStatus(EventStatus.ACTIVE);
				patEvent.setJourney(PatientJourneyVoAssembler.create(doCatsReferral.getJourney()));
				
				HL7PathwayIf impl = (HL7PathwayIf) getDomainImpl(HL7PathwayIfImpl.class);
				impl.instantiatePatientEvent(patEvent);
			}
		}
		
		//WDEV-7471
		if(bDiagnosticReferral)
			pukkaJMessaging(doCatsReferral, isCreateOrder);
		
		// WDEV-18548
		try 
		{
			ReferralUrgency prevUrgency=null;
			if (prevReferralUrgency != null)
				prevUrgency = new ReferralUrgency(prevReferralUrgency.getId());
			
			// If this is an insert the vo won't have the id
			if (!referVo.getID_CatsReferralIsNotNull())
				referVo.setID_CatsReferral(doCatsReferral.getId());
			check62dayTarget(referVo, prevUrgency);
		}
		catch (DomainInterfaceException e) 
		{
			e.printStackTrace();  // This is already system logged
		}
		
		
		return CatsReferralWizardVoAssembler.create(doCatsReferral);
	}

	//WDEV-7441 - 1.
	public void pukkaJMessaging(CatsReferral doCatsReferral, Boolean isCreateOrder) throws StaleObjectException
	{
		DomainFactory factory = getDomainFactory();
		if(isCreateOrder)			
		{
			BookAppointment impl = (BookAppointment) getDomainImpl(BookAppointmentImpl.class);
			Object[] orderInvAndOrder = impl.createOrder(doCatsReferral, null);
			if(orderInvAndOrder != null)
			{
				OcsOrderSession doOcsOrder = (OcsOrderSession) orderInvAndOrder[1];
				OrderInvestigation doOrderInv = (OrderInvestigation) orderInvAndOrder[0];
				Booking_Appointment doBookedAppt = getBookedAppointment(doCatsReferral);
				if(doBookedAppt != null)
				{
					OrderInvAppt ordInvAppt = new OrderInvAppt();
					ordInvAppt.setOrderInvestigation(doOrderInv);
					ordInvAppt.setAppointment(doBookedAppt);
					ordInvAppt.getOrderInvestigation().setAppointmentDate(doBookedAppt.getAppointmentDate());
					ordInvAppt.setStatus(getDomLookup(PollStatus.CANCELNOTPROCESSED));
					doCatsReferral.getOrderInvAppts().add(ordInvAppt);
				}				
				doCatsReferral.getInvestigationOrders().add(doOcsOrder);
				doCatsReferral.setHasInvestigations(true);
				factory.save(doCatsReferral);
				
				//send message to PukkaJ
				if(doBookedAppt != null)
				{
					OCSExternalEvents implE = (OCSExternalEvents) getDomainImpl(OCSExternalEventsImpl.class);
					implE.generateNewOrderEvent(new Booking_AppointmentRefVo(doBookedAppt.getId(), doBookedAppt.getVersion()) , new OrderInvestigationRefVo(doOrderInv.getId(), doOrderInv.getVersion()));
				}
			}
		}
		else
		{
			//check if bookedAppt exists
			Booking_Appointment doBookedAppt = getBookedAppointment(doCatsReferral);
			//if there is no investigations for referral
			if(doCatsReferral.getInvestigationOrders().size() == 0)
			{
				BookAppointment impl = (BookAppointment) getDomainImpl(BookAppointmentImpl.class);
				//create one investigation
				Object[] orderInvAndOrder = impl.createOrder(doCatsReferral, null);
				OrderInvestigation doOrderInv = (OrderInvestigation) orderInvAndOrder[0];
				OcsOrderSession doOcsOrder = (OcsOrderSession) orderInvAndOrder[1];
				
				if(doBookedAppt != null)
				{
					OrderInvAppt ordInvAppt = new OrderInvAppt();
					ordInvAppt.setOrderInvestigation(doOrderInv);
					ordInvAppt.setAppointment(doBookedAppt);
					ordInvAppt.getOrderInvestigation().setAppointmentDate(doBookedAppt.getAppointmentDate());
					ordInvAppt.setStatus(getDomLookup(PollStatus.CANCELNOTPROCESSED));
					doCatsReferral.getOrderInvAppts().add(ordInvAppt);
				}
				doCatsReferral.getInvestigationOrders().add(doOcsOrder);
				doCatsReferral.setHasInvestigations(true);
				getDomainFactory().save(doCatsReferral);
				
				//send message to PukkaJ
				if(doBookedAppt != null)
				{
					OCSExternalEvents implE = (OCSExternalEvents) getDomainImpl(OCSExternalEventsImpl.class);
					implE.generateOrderUpdateEvent(new Booking_AppointmentRefVo(doBookedAppt.getId(), doBookedAppt.getVersion()) , new OrderInvestigationRefVo(doOrderInv.getId(), doOrderInv.getVersion()));
				}
				
			}
			//if we reach here there is an investigation and an appointment but they were never linked because maybe the sdslookup failed
			//ie. the webservice method in BookAppointment - processAppointmentForPukkaJ was never called - this code is specific to C&B appointments and a manual(maxims) order
			else if(doCatsReferral.getOrderInvAppts().size() == 0 && doBookedAppt != null && doBookedAppt.isIsCABBooking() != null && doBookedAppt.isIsCABBooking())
			{
				OrderInvestigation doOrderInv = null;
				if(doCatsReferral.getInvestigationOrders().size() > 0)
				{
					Iterator itO = doCatsReferral.getInvestigationOrders().iterator();
					if(itO.hasNext())
					{
						OcsOrderSession doOcsOrder = (OcsOrderSession) itO.next();
						Iterator itI = doOcsOrder.getInvestigations().iterator();
						if(itI.hasNext())
							doOrderInv  = (OrderInvestigation) itI.next();
					}
						
				}
					
				OrderInvAppt ordInvAppt = new OrderInvAppt();
				ordInvAppt.setOrderInvestigation(doOrderInv);
				ordInvAppt.setAppointment(doBookedAppt);
				ordInvAppt.getOrderInvestigation().setAppointmentDate(doBookedAppt.getAppointmentDate());
				ordInvAppt.setStatus(getDomLookup(PollStatus.CANCELNOTPROCESSED));
				doCatsReferral.getOrderInvAppts().add(ordInvAppt);
				
				getDomainFactory().save(doCatsReferral);
				
				//send message to PukkaJ
				OCSExternalEvents implE = (OCSExternalEvents) getDomainImpl(OCSExternalEventsImpl.class);
				implE.generateOrderUpdateEvent(new Booking_AppointmentRefVo(doBookedAppt.getId(), doBookedAppt.getVersion()) , new OrderInvestigationRefVo(doOrderInv.getId(), doOrderInv.getVersion()));
			}					
		}
	}

	private Booking_Appointment getBookedAppointment(CatsReferral doCatsReferral)
	{
		Booking_Appointment doBookedAppt = null;
		if(doCatsReferral.getAppointments().size() > 0)
		{
			Iterator it = doCatsReferral.getAppointments().iterator();
			while(it.hasNext())
			{
				Booking_Appointment doAppt = (Booking_Appointment) it.next();
				if(doAppt.getApptStatus() != null && doAppt.getApptStatus().equals( getDomLookup(Status_Reason.BOOKED)))
				{
					doBookedAppt = doAppt;
					break;	
				}
						
			}
		}
		return doBookedAppt;
	}

	public ServiceVo getServiceById(ServiceVo voService) 
	{
		Service impl = (Service) getDomainImpl(ServiceImpl.class);
		return impl.getServiceById(voService);
	}

	public GpShortVo getPatientsGp(Integer idPatient)
	{
//		DomainFactory factory = getDomainFactory();
		ims.core.patient.domain.objects.Patient pat=null;
//		IMSCriteria imsc=new IMSCriteria(Patient.class,factory);
//		imsc.equal("this.id", idPatient);
//		List patients=imsc.find();
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer(" from Patient where "); 
		String andStr = " ";
	
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Serializable> values = new ArrayList<Serializable>();
	
		hql.append(andStr + "id = :patient");
			markers.add("patient");
		values.add(idPatient);
			

		List patients = factory.find(hql.toString(), markers,values);
		if (patients!=null && patients.size()>0)
		{
			pat=(ims.core.patient.domain.objects.Patient) patients.get(0);
			if (pat.getGp()!=null)
				return GpShortVoAssembler.create(pat.getGp());
			else
				return null;
		}
		return null;
	}


	public MemberOfStaffVo getMemberOfStaff(MemberOfStaffShortVo mos) 
	{
		MosAdmin impl = (MosAdmin) getDomainImpl(MosAdminImpl.class);
		return impl.getMemberOfStaff(mos);
	}

	//WDEV-14160
	public CareContextShortVo getCareContext(CareContextRefVo careContextRef) 
	{
		if(careContextRef == null || !careContextRef.getID_CareContextIsNotNull())
			throw new CodingRuntimeException("Cannot get CareContextShortVo on null CareContext Id.");
		
		return CareContextShortVoAssembler.create((CareContext) getDomainFactory().getDomainObject(CareContext.class, careContextRef.getID_CareContext()));
	}
}
