// This code was generated by Daniel Laffan using IMS Development Environment (version 1.80 build 4198.17562)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import ims.admin.domain.OrganisationAndLocation;
import ims.admin.domain.impl.OrganisationAndLocationImpl;
import ims.admin.vo.ElectiveListConfigurationVoCollection;
import ims.admin.vo.domain.ElectiveListConfigurationVoAssembler;
import ims.RefMan.domain.BookTheatre;
import ims.RefMan.domain.base.impl.BaseBookTheatreSlotDetailDialogImpl;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.domain.objects.PatientElectiveList;
import ims.RefMan.domain.objects.ReferralEROD;
import ims.RefMan.vo.CatsReferralForNewElectivListEntryVo;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.PatientElectiveListVo;
import ims.RefMan.vo.PatientElectiveListVoCollection;
import ims.RefMan.vo.ReferralERODForBookTheatreVo;
import ims.RefMan.vo.ReferralERODVo;
import ims.RefMan.vo.domain.CatsReferralForNewElectivListEntryVoAssembler;
import ims.RefMan.vo.domain.PatientElectiveListVoAssembler;
import ims.RefMan.vo.domain.ReferralERODForBookTheatreVoAssembler;
import ims.RefMan.vo.domain.ReferralERODVoAssembler;
import ims.RefMan.vo.lookups.ERODStatus;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.clinical.domain.objects.Service;
import ims.core.clinical.vo.ProcedureRefVo;
import ims.core.clinical.vo.ServiceRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.place.domain.objects.Location;
import ims.core.resource.people.domain.objects.Hcp;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpMinVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.HcpMinVoAssembler;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.lookups.ServiceCategory;
import ims.core.vo.lookups.WaitingListStatus;
import ims.core.vo.lookups.YesNo;
import ims.domain.DomainFactory;
import ims.domain.DomainObject;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.vo.lookups.ElectiveListReason;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.interfaces.ILocation;
import ims.icp.vo.PatientICPFullVo;
import ims.pathways.domain.objects.PathwayClock;
import ims.pathways.domain.objects.PauseDetails;
import ims.scheduling.domain.SessionAdmin;
import ims.scheduling.domain.impl.SessionAdminImpl;
import ims.scheduling.domain.objects.Booking_Appointment;
import ims.scheduling.domain.objects.Sch_Booking;
import ims.scheduling.domain.objects.Sch_Session;
import ims.scheduling.domain.objects.Sch_Session_Appointment_Order;
import ims.scheduling.domain.objects.SessionParentChildSlot;
import ims.scheduling.domain.objects.SessionSlotStatus;
import ims.scheduling.domain.objects.SessionTheatreProceduresRemanining;
import ims.scheduling.domain.objects.TheatreProcedure;
import ims.scheduling.vo.BookingAppointmentTheatreVo;
import ims.scheduling.vo.Booking_AppointmentRefVo;
import ims.scheduling.vo.Sch_BookingTheatreVo;
import ims.scheduling.vo.SessionParentChildSlotRefVo;
import ims.scheduling.vo.SessionParentChildSlotRefVoCollection;
import ims.scheduling.vo.SessionParentChildSlotVo;
import ims.scheduling.vo.domain.BookingAppointmentTheatreVoAssembler;
import ims.scheduling.vo.domain.Sch_BookingTheatreVoAssembler;
import ims.scheduling.vo.domain.SessionParentChildSlotVoAssembler;
import ims.scheduling.vo.lookups.Status_Reason;
import ims.scheduling.vo.lookups.TheatreType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class BookTheatreSlotDetailDialogImpl extends BaseBookTheatreSlotDetailDialogImpl
{

	private static final long	serialVersionUID	= 1L;

	/**
	 * saveBooking needs to handle child slots for theatre booking handles also
	 * the status points for the appointment and history
	 */
	public Sch_BookingTheatreVo saveTheatreBooking(Sch_BookingTheatreVo voBooking, CatsReferralRefVo catsRef, SessionParentChildSlotRefVoCollection voCollChildSlots, SessionParentChildSlotVo voSessParentChildSlot, TheatreType theatreType, ReferralERODForBookTheatreVo referralEROD, PatientElectiveListVo patientElectiveListToSave) throws DomainInterfaceException, StaleObjectException //WDEV-18084
	{
		if (voBooking == null)
			throw new CodingRuntimeException("voBooking is null in method saveBooking");

		DomainFactory factory = getDomainFactory();
		
		//get old slot if we are rebooking so we can release it and its children
		SessionParentChildSlot doOldSlot = null;
		if(voBooking.getAppointmentsIsNotNull() && voBooking.getAppointments().size() == 1)
		{
			if(voBooking.getAppointments().get(0).getID_Booking_AppointmentIsNotNull())
			{
				Booking_Appointment doAppt = (Booking_Appointment) factory.getDomainObject(voBooking.getAppointments().get(0));
				if(doAppt.getParentChildSlot() != null)
				{
					doOldSlot = doAppt.getParentChildSlot();
				}
			}
		}
		
		HashMap objMap = new HashMap();
		Sch_Booking doBooking = Sch_BookingTheatreVoAssembler.extractSch_Booking(factory, voBooking, objMap);

		// If CatsReferral record is in scope IE. Appointment booked through UI
		// associate the created appointments with the catsReferral record and
		// patient from cats referral with booking
		CatsReferral doCatsReferral = null;
		if (catsRef != null && catsRef.getID_CatsReferralIsNotNull())
		{
			doCatsReferral = (CatsReferral) factory.getDomainObject(catsRef);
			doBooking.setPatient(doCatsReferral.getPatient());
		}

		// If this is a new patient (from gateway) we will need to save the
		// patient first
		if (doBooking.getPatient().getId() == null)
		{
			factory.save(doBooking.getPatient());
		}

		// WDEV-5727 - consultation appt
		Booking_Appointment doConsultationAppt = null;
		if (doCatsReferral != null)
			doConsultationAppt = doCatsReferral.getConsultationAppt();

		int procedureMinsUsed = 0;
		Sch_Session doTheatreSession = null;
		if (doBooking.getAppointments() != null)
		{
			Iterator it = doBooking.getAppointments().iterator();
			Booking_Appointment doEarliestAppt = null;
			while (it.hasNext())
			{
				Booking_Appointment doBookAppt = (Booking_Appointment) it.next();
				
				doBookAppt.setRequiresRebook(false); //WDEV-12918

				if (doTheatreSession == null)
					doTheatreSession = doBookAppt.getSession();

				// WDEV-11964
				getDomainFactory().refresh(doTheatreSession);

				// Set patient at this level if not already set
				if (doBookAppt.getPatient() == null)
					doBookAppt.setPatient(doBooking.getPatient());

				if (doEarliestAppt != null && doEarliestAppt.getAppointmentDate().before(doBookAppt.getAppointmentDate()))
					doEarliestAppt = doBookAppt;

				if (doEarliestAppt == null)
					doEarliestAppt = doBookAppt;

				// WDEV-5727 - consultation appt
				if (doConsultationAppt == null)
				{
					if (doBookAppt.getSession().getService() != null)
					{
						if (doBookAppt.getSession().getService().getServiceCategory().equals(getDomLookup(ServiceCategory.CLINICAL)))
							doConsultationAppt = doBookAppt;
					}
				}

				// WDEV-5984
				if (doCatsReferral != null)
				{
					if (doCatsReferral.getReferralDetails() != null && doCatsReferral.getReferralDetails().getTransportRequired() != null && doCatsReferral.getReferralDetails().getTransportRequired().equals(getDomLookup(YesNo.YES)))
					{
						if (doBookAppt.getId() == null) // for every new appt
						{
							doBookAppt.setIsTransportRequired(true);
						}
					}
				}

				// go through the sessions configured TheatreProcedures and if
				// they have a limit - subtract 1 from the
				// NumberOfProceduresLeft
				// also subtract duration of procedure from Remaining Mins
				if (doBookAppt.getTheatreBooking() != null)
				{
					if (doCatsReferral != null && doCatsReferral.getCareContext() != null)
					{
						CareContextRefVo voCCRef = new CareContextRefVo(doCatsReferral.getCareContext().getId(), doCatsReferral.getCareContext().getVersion());
						//WDEV-12918
						BookTheatre impl = (BookTheatre) getDomainImpl(BookTheatreImpl.class);
						doBookAppt.getTheatreBooking().setSuitableForSurgeryProcedure(impl.getLastSuitableForSurgeryAssessmentProcedureTextByCareContext(voCCRef));
					}

					if (doBookAppt.getTheatreBooking().getProcedure() != null)
					{
						if (doBookAppt.getSession().getTheatreProceduresRemaining() != null && doBookAppt.getSession().getTheatreProceduresRemaining().getProcedureDetails() != null)
						{
							Iterator it1 = doBookAppt.getSession().getTheatreProceduresRemaining().getProcedureDetails().iterator();
							while (it1.hasNext())
							{
								TheatreProcedure doTheatreProc = (TheatreProcedure) it1.next();
								if (doTheatreProc.getProcedure() != null)
								{
									if (doTheatreProc.getProcedure().getId().equals(doBookAppt.getTheatreBooking().getProcedure().getId()) && (doTheatreProc.isIsLimited() != null && doTheatreProc.isIsLimited())) // WDEV-11777
										if (doTheatreProc.getNumberOfProceduresLeft() != null && !doTheatreProc.getNumberOfProceduresLeft().equals(new Integer(0)))
											doTheatreProc.setNumberOfProceduresLeft(new Integer(doTheatreProc.getNumberOfProceduresLeft().intValue() - 1));
								}
							}
						}

						if (doBookAppt.getCustomProcedureDuration() != null)
							procedureMinsUsed += doBookAppt.getCustomProcedureDuration();
						else if (doBookAppt.getTheatreBooking().getProcedure().getDurationInMins() != null)
							procedureMinsUsed += doBookAppt.getTheatreBooking().getProcedure().getDurationInMins().intValue();
					}
				}
			}

			if (procedureMinsUsed > 0 && doTheatreSession != null && doTheatreSession.getTheatreProceduresRemaining() != null && doTheatreSession.getTheatreProceduresRemaining().getRemainingTimeInMins() != null && !doTheatreSession.getTheatreProceduresRemaining().getRemainingTimeInMins().equals(new Integer(0)))
				doTheatreSession.getTheatreProceduresRemaining().setRemainingTimeInMins(new Integer(doTheatreSession.getTheatreProceduresRemaining().getRemainingTimeInMins().intValue() - procedureMinsUsed));

			doBooking.setFirstAppointment(doEarliestAppt);

			// if the first appointment is no longer associated with this
			// booking ie. was cancelled
			if (!doBooking.getAppointments().contains(doEarliestAppt))
			{
				doBooking.setFirstAppointment(null);
			}
		}
		
		// WDEV-13551
		// Refresh all slots except the ones required for rebooking (the parent slot and those calculated
		Iterator parentSlotIterator = doBooking.getFirstAppointment().getSession().getParentChildSlots().iterator();
		
		while (parentSlotIterator.hasNext())
		{
			SessionParentChildSlot parentSlot = (SessionParentChildSlot) parentSlotIterator.next();
			
			if (parentSlot.getId().equals(voSessParentChildSlot.getID_SessionParentChildSlot()))
				continue;
			
			if (foundInSlots(parentSlot.getId(), voCollChildSlots))
				continue;
			
			factory.refresh(parentSlot);
		}
		
		try
		{
			factory.save(doBooking);
		}
		catch (StaleObjectException ex)
		{
			// WDEV-11964
			if (ex != null && ex.getStaleObject() instanceof SessionTheatreProceduresRemanining)
			{
				// attempt to do the booking again in this scenario
				SessionTheatreProceduresRemanining doSessTheatreProcRem = (SessionTheatreProceduresRemanining) ex.getStaleObject();
				factory.refresh(doSessTheatreProcRem);

				// check if persisted slot is still available
				SessionParentChildSlot doSlot = (SessionParentChildSlot) factory.getDomainObject(voSessParentChildSlot);
				if (doSlot.getAppointment() == null)
					doSessTheatreProcRem.setRemainingTimeInMins(new Integer(doTheatreSession.getTheatreProceduresRemaining().getRemainingTimeInMins().intValue() - procedureMinsUsed));
				else
					throw new StaleObjectException(doSessTheatreProcRem);
				
				factory.save(doBooking);
			}
		}
		
		ReferralEROD doReferralEROD = null;
		if (doCatsReferral != null)
		{
			doCatsReferral.getAppointments().addAll(doBooking.getAppointments());
			// WDEV-5727 - consultation appt
			doCatsReferral.setConsultationAppt(doConsultationAppt);
			// WDEV-5727 - has appointments
			doCatsReferral.setHasAppointments(true);

			doCatsReferral.setHasTheatreAppt(true);// wdev-7607
			if(theatreType != null && theatreType.equals(TheatreType.OP_CASE))   	//wdev-13765
				doCatsReferral.setHasOPProcAwaitingAppt(Boolean.FALSE);				//wdev-13765
			
			PathwayClock currentClock = null;
			if(referralEROD != null)
			{
				if(doCatsReferral.getJourney() != null && doCatsReferral.getJourney().getCurrentClock() != null)
				{
					currentClock = doCatsReferral.getJourney().getCurrentClock();
					
					factory.refresh(currentClock);
					
					PauseDetails doPauseDetails = new PauseDetails();
					doPauseDetails.setPauseStart(referralEROD.getERODDate1() != null ? referralEROD.getERODDate1().getDate() : null);
					doPauseDetails.setActive(true);
						
					currentClock.setCurrentPause(doPauseDetails);
					
					if(currentClock.getPauseDetails() == null)
						currentClock.setPauseDetails(new java.util.ArrayList());
					
					currentClock.getPauseDetails().add(doPauseDetails);
				}
				
				doReferralEROD = createdReferralEROD(factory, doCatsReferral.getElectiveEROD(), currentClock, referralEROD, objMap);
				
				if(doCatsReferral.getElectiveEROD() == null)
						doCatsReferral.setElectiveEROD(new java.util.ArrayList());
				
				doCatsReferral.getElectiveEROD().add(doReferralEROD);
			}
			
			if(patientElectiveListToSave != null && patientElectiveListToSave.getTCIDetails() != null && patientElectiveListToSave.getTCIDetails().getTCIDate() != null)
			{
				if(doCatsReferral.getJourney() != null && doCatsReferral.getJourney().getCurrentClock() != null && doCatsReferral.getJourney().getCurrentClock().getCurrentPause() != null)
				{
					PauseDetails currentPause = doCatsReferral.getJourney().getCurrentClock().getCurrentPause();
					
					if(doCatsReferral.getJourney().getCurrentClock().getPauseDetails() != null)
					{
						for(int i=0; i<doCatsReferral.getJourney().getCurrentClock().getPauseDetails().size(); i++)
						{
							PauseDetails pause = (PauseDetails) doCatsReferral.getJourney().getCurrentClock().getPauseDetails().get(i);
							if(currentPause.equals(pause) && Boolean.TRUE.equals(pause.isActive()))
							{
								doCatsReferral.getJourney().getCurrentClock().getPauseDetails().remove(i);
								break;
							}
						}
					}
					
					currentPause.setPauseStop(patientElectiveListToSave.getTCIDetails().getTCIDate().getDate());
					
					if(doCatsReferral.getJourney().getCurrentClock().getPauseDetails() == null)
						doCatsReferral.getJourney().getCurrentClock().setPauseDetails(new java.util.ArrayList());
					
					doCatsReferral.getJourney().getCurrentClock().getPauseDetails().add(currentPause);	
				}
			}
			
			factory.save(doCatsReferral);
			
			/*if(currentClock != null)
			{
				String patientElectiveListQuery = "select electiveList from PatientElectiveList as electiveList left join electiveList.referral as cats left join electiveList.pathwayClock as pc where cats.id = :CatsId and pc.id = :PathwayClock";
				List<?> electiveList = factory.find(patientElectiveListQuery, new String[] {"CatsId", "PathwayClock"}, new Object[] {catsRef.getID_CatsReferral(), currentClock.getId()});
				
				if(electiveList != null && electiveList.size() > 0 && electiveList.get(0) instanceof PatientElectiveList)
				{
					PatientElectiveList doPatientElectiveList = (PatientElectiveList) electiveList.get(0);
					doPatientElectiveList.setEROD(doReferralEROD);
					
					factory.save(doPatientElectiveList);
				}
			}*/
			// WDEV-12157
			// Update the CatsReferral status (hasCancelled appointments field)
			SessionAdmin impl = (SessionAdmin) getDomainImpl(SessionAdminImpl.class);
			impl.updateCatsReferralAdditionalInvStatus(catsRef);

			BookTheatre implBT = (BookTheatre) getDomainImpl(BookTheatreImpl.class);
			implBT.updateActiveMonitoring(catsRef);
		}

		// WDEV-7528 - maintain SessionAppointmentOrder
		if (doTheatreSession != null)
		{
			Sch_Session_Appointment_Order doSessApptOrder = Sch_Session_Appointment_Order.getSch_Session_Appointment_OrderFromSession(factory, doTheatreSession.getId());
			if (doSessApptOrder == null)
			{
				doSessApptOrder = new Sch_Session_Appointment_Order();
				doSessApptOrder.setSession(doTheatreSession);
			}

			Iterator it1 = doBooking.getAppointments().iterator();
			while (it1.hasNext())
			{
				Booking_Appointment doAppt = (Booking_Appointment) it1.next();

				// WDEV-8271
				BookTheatre impl = (BookTheatre) getDomainImpl(BookTheatreImpl.class);
				impl.removeApptFromExistingSessionApptOrder(doAppt);

				if (!impl.alreadyExists(doSessApptOrder, doAppt))
					doSessApptOrder.getAppointments().add(doAppt);
			}

			factory.save(doSessApptOrder);
		}

		// WDEV-11777 - update the SessionTheatreSlot record
		if (voSessParentChildSlot != null)
		{
			SessionParentChildSlot doSessParentChildSlot = SessionParentChildSlotVoAssembler.extractSessionParentChildSlot(factory, voSessParentChildSlot);

			// get the one(first) appointment from the collection
			if (doBooking.getAppointments() != null)
			{
				Iterator it = doBooking.getAppointments().iterator();
				Booking_Appointment doBookedAppt = (Booking_Appointment) it.next();
				bookAppointmentIntoParentChildSlot(doBookedAppt, doSessParentChildSlot);
			}

			factory.save(doSessParentChildSlot);

			// WDEV-12918 - find and update the child slots with their (new
			// parent) also set them to booked
			if (voCollChildSlots != null)
			{
				for (SessionParentChildSlotRefVo voSlot : voCollChildSlots)
				{
					SessionParentChildSlot doSlot = (SessionParentChildSlot) factory.getDomainObject(voSlot);
					doSlot.setParentSlot(doSessParentChildSlot);
					doSlot.setStatus(getDomLookup(Status_Reason.BOOKED));
					factory.save(doSlot);
				}
			}
		}
		
		//WDEV-12918 rebooking theatre fixed slots
		if(doOldSlot != null)
		{
			doOldSlot.setAppointment(null);
			doOldSlot.setStatus(getDomLookup(Status_Reason.SLOTOPENED));
			
			if(doOldSlot.getSession() != null)
			{
				if(doOldSlot.getSession().getParentChildSlots() != null)
				{
					Iterator it = doOldSlot.getSession().getParentChildSlots().iterator();
					while(it.hasNext())
					{
						//release child slots
						SessionParentChildSlot doSlot = (SessionParentChildSlot) it.next();
						if(doSlot.getParentSlot() != null && doSlot.getParentSlot().equals(doOldSlot))
						{
							doSlot.setParentSlot(null);
							doSlot.setStatus(getDomLookup(Status_Reason.SLOTOPENED));
						}
					}
				}
			}
			
			SessionSlotStatus doStat = new SessionSlotStatus();
			doStat.setDateTime(new java.util.Date());
			doStat.setStatus(doOldSlot.getStatus());
			doStat.setStatusReason(doOldSlot.getStatusReason());
			doOldSlot.getStatusReasonHistory().add(doStat);
			
			factory.save(doOldSlot);
			factory.save(doOldSlot.getSession());
		}
		
		//WDEV-18084
		if (patientElectiveListToSave!=null)
		{
			PatientElectiveList domPatElectiveList = PatientElectiveListVoAssembler.extractPatientElectiveList(factory, patientElectiveListToSave,objMap) ;
			domPatElectiveList.setEROD(doReferralEROD);
			factory.save(domPatElectiveList);
		}
		return Sch_BookingTheatreVoAssembler.create(doBooking);
	}

	private ReferralEROD createdReferralEROD(DomainFactory factory, List theatreEROD, PathwayClock pathwayClock, ReferralERODForBookTheatreVo referralEROD, HashMap objMap)
	{
		if(referralEROD == null)
			return null;
		
		int sequence = 0;
		
		if(theatreEROD != null)
		{
			for(int i=0; i<theatreEROD.size(); i++)
			{
				if(theatreEROD.get(i) instanceof ReferralEROD)
				{
					ReferralEROD savedErod = (ReferralEROD) theatreEROD.get(i);
					
					if(savedErod.getSequence() != null && sequence < savedErod.getSequence())
						sequence = savedErod.getSequence();
				}
			}
		}
		
		sequence++;
		
		ReferralEROD doErod = ReferralERODForBookTheatreVoAssembler.extractReferralEROD(factory, referralEROD, objMap);
		doErod.setSequence(sequence);
		doErod.setPathWayClock(pathwayClock);
		
		return doErod;
	}

	/**
	 * WDEV-13551
	 * Function used to determine if the slot with the ID is found in the provided Slot collection
	 */
	private boolean foundInSlots(Integer slotID, SessionParentChildSlotRefVoCollection slotCollection)
	{
		if (slotCollection == null || slotCollection.size() == 0)
			return false;
		
		if (slotID == null)
			return false;
		
		for (SessionParentChildSlotRefVo slot : slotCollection)
		{
			if (slotID.equals(slot.getID_SessionParentChildSlot()))
				return true;
		}
		
		return false;
	}

	/**
	 * @param doAppt
	 * @param doSessionTheatreSlot
	 */
	private SessionParentChildSlot bookAppointmentIntoParentChildSlot(Booking_Appointment doAppt, SessionParentChildSlot doSessParentChildSlot)
	{
		if (doSessParentChildSlot == null)
			throw new CodingRuntimeException("doSessParentChildSlot is null in method bookAppointmentIntoParentChildSlot");
		if (doAppt == null)
			throw new CodingRuntimeException("doAppt is null in method bookAppointmentIntoParentChildSlot");

		doSessParentChildSlot.setAppointment(doAppt);

		doSessParentChildSlot.setStatus(getDomLookup(Status_Reason.BOOKED));
		doSessParentChildSlot.setStatusReason(getDomLookup(Status_Reason.BOOKED));

		SessionSlotStatus doStat = new SessionSlotStatus();
		doStat.setDateTime(new java.util.Date());
		doStat.setStatus(doSessParentChildSlot.getStatus());
		doStat.setStatusReason(doSessParentChildSlot.getStatusReason());
		doSessParentChildSlot.getStatusReasonHistory().add(doStat);

		return doSessParentChildSlot;
	}

	public BookingAppointmentTheatreVo getBookingTheatreAppointment(Booking_AppointmentRefVo appt)
	{
		if (appt == null || appt.getID_Booking_Appointment() == null)
			throw new CodingRuntimeException("appt is null or id not provided in method getBookingTheatreAppointment");
		
		return BookingAppointmentTheatreVoAssembler.create((Booking_Appointment) getDomainFactory().getDomainObject(appt));
	}

	public PatientICPFullVo getPatientICP(CareContextRefVo careContext)
	{
		BookTheatre impl = (BookTheatre) getDomainImpl(BookTheatreImpl.class);
		return impl.getPatientICP(careContext);
	}

	public PatientICPFullVo savePatientICP(PatientICPFullVo icp) throws DomainInterfaceException, StaleObjectException
	{
		BookTheatre impl = (BookTheatre) getDomainImpl(BookTheatreImpl.class);
		return impl.savePatientICP(icp);
	}

	public Boolean hasTheatreEROD(CatsReferralRefVo catsReferral)
	{
		if(catsReferral == null || catsReferral.getID_CatsReferral() == null)
			return false;
		
		DomainFactory factory = getDomainFactory();
		Object[] count = factory.find("select count(theaErod.id) from CatsReferral as cats left join cats.electiveEROD as theaErod where cats.id = :CatsReferralId and theaErod.isActive = 1 and (theaErod.isRIE is null or theaErod.isRIE = 0)", new String[] {"CatsReferralId"}, new Object[] {catsReferral.getID_CatsReferral()}).toArray();
			
		if(count != null && count.length > 0)
			return ((Long) count[0]).intValue() > 0;
		
		return false;
	}

	public ReferralERODVo getReferralERODByAppointment(Booking_AppointmentRefVo apptRef)
	{
		if(apptRef == null || apptRef.getID_Booking_Appointment() == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		String query = "select erod from ReferralEROD as erod left join erod.appointment as appt left join erod.erodStatus as eStatus where appt.id = :BookAppointment and (eStatus is null or eStatus.id <> :ErodStatus)";
		List<?> list = factory.find(query, new String[] {"BookAppointment", "ErodStatus"}, new Object[] {apptRef.getID_Booking_Appointment(), ERODStatus.CANCELLED.getID()});
		
		if(list != null && list.size() > 0 && list.get(0) != null)
		{
			return ReferralERODVoAssembler.create((ReferralEROD) list.get(0));
		}
		
		return null;
	}

	//WDEV-18084
	public CatsReferralForNewElectivListEntryVo getCatsReferral(CatsReferralRefVo catsReferralRef)
	{
		if (catsReferralRef == null || catsReferralRef.getID_CatsReferral()==null)
		{
			throw new CodingRuntimeException("Cannot get CatsReferralForNewElectivListEntryVo for null ID");
		}
		
		DomainFactory factory = getDomainFactory();
		CatsReferral domCatsRef=(CatsReferral) factory.getDomainObject(CatsReferral.class, catsReferralRef.getID_CatsReferral());
		
		return CatsReferralForNewElectivListEntryVoAssembler.create(domCatsRef);
	}

	public LocationLiteVoCollection listWardsForCurrentLocation(ILocation location)
	{
		if(location == null)
			return null;

		OrganisationAndLocation implLoc = (OrganisationAndLocation)getDomainImpl(OrganisationAndLocationImpl.class);
		LocationRefVo voRef = new LocationRefVo();
		voRef.setID_Location(location.getID());

		return implLoc.listActiveWardsForHospitalLite(voRef).sort();

	}

	public HcpMinVo getHCPMin(HcpRefVo hcpRef)
	{
		if (hcpRef == null || hcpRef.getID_Hcp()==null)
		{
			throw new CodingRuntimeException("Cannot get HCPMin for null ID");
		}
		
		DomainFactory factory = getDomainFactory();
		Hcp domHCP=(Hcp) factory.getDomainObject(Hcp.class, hcpRef.getID_Hcp());
		
		return HcpMinVoAssembler.create(domHCP);
	}

	public HcpLiteVo getHCPLiteVo(HcpRefVo hcpRef)
	{
		if (hcpRef == null || hcpRef.getID_Hcp()==null)
		{
			throw new CodingRuntimeException("Cannot get HCPMin for null ID");
		}
		
		DomainFactory factory = getDomainFactory();
		Hcp domHCP=(Hcp) factory.getDomainObject(Hcp.class, hcpRef.getID_Hcp());
		
		return HcpLiteVoAssembler.create(domHCP);
	}

	public PatientElectiveListVoCollection getPatientElectiveList(PatientRefVo patientRef, CatsReferralRefVo catsRef, ServiceRefVo serviceRef, ProcedureRefVo procedureRef, String listIdHcp, CatsReferralForNewElectivListEntryVo catsReferralWithPathwayClock, Boolean nonDiagnosticELE) //WDEV-18396
	{
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		StringBuffer hqlConditions = new StringBuffer();
		String andStr = " and ";

		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("select pEL from PatientElectiveList as pEL left join pEL.primaryProcedure as primProc left join pEL.electiveList as eL left join eL.service as service left join eL.hCPs as listOwners left join pEL.electiveListStatus as pELStatus left join pELStatus.electiveListStatus as status left join pEL.pathwayClock as pathClock  ");
		
		if (patientRef!=null)
		{
			hqlConditions.append(andStr);
			hqlConditions.append(" pEL.patient.id = :PatID ");
			markers.add("PatID");
			values.add(patientRef.getID_Patient());
			andStr = " and ";
		}
		
		if (catsRef!=null)
		{
			hqlConditions.append(andStr);
			hqlConditions.append(" pEL.referral.id = :CatsID ");
			markers.add("CatsID");
			values.add(catsRef.getID_CatsReferral());
			andStr = " and ";		
		}
		
		if (serviceRef!=null)
		{
			hqlConditions.append(andStr);
			hqlConditions.append(" service.id=:Service ");
			markers.add("Service");
			values.add(serviceRef.getID_Service());
			andStr = " and ";
		}
		
		if (procedureRef!=null)
		{
			hqlConditions.append(andStr);
			hqlConditions.append(" primProc.id=:Procedure ");
			markers.add("Procedure");
			values.add(procedureRef.getID_Procedure());
			andStr = " and ";
		}
		
		if (listIdHcp!=null && listIdHcp.length()>0)
		{	
			hqlConditions.append(andStr);
			hqlConditions.append(" ( listOwners.hCP.id in "+ listIdHcp +" ) ");
			andStr = " and ";
		}
		
		if (nonDiagnosticELE)
		{
			hqlConditions.append(andStr);
			hqlConditions.append(" pEL.electiveListReason.id not in ("+ ElectiveListReason.DIAGNOSTIC.getID() +" ) ");
			andStr = " and ";
		}
		
		if (catsReferralWithPathwayClock != null && catsReferralWithPathwayClock.getJourney() != null && catsReferralWithPathwayClock.getJourney().getCurrentClock() != null)
		{
			hqlConditions.append(andStr);
			hqlConditions.append(" pathClock.id = :Clock ");
			markers.add("Clock");
			values.add(catsReferralWithPathwayClock.getJourney().getCurrentClock().getID_PathwayClock());
			andStr = " and ";
		}
		
		hqlConditions.insert(0, " where ( status.id not in (" + WaitingListStatus.REMOVED.getID() + ")");
		hqlConditions.append(" ) ");

		List <?> list = factory.find(hql.toString() + hqlConditions.toString(),markers,values);
	
		if ((list == null || list.size() == 0) && catsReferralWithPathwayClock != null && catsReferralWithPathwayClock.getJourney() != null && catsReferralWithPathwayClock.getJourney().getCurrentClock() != null)
		{
			//If none found, perform the extended search to see if a patientElectiveList exists for the current clock for a service that uses the same specialty as this service's specialty.
			String query = "select pEL from PatientElectiveList as pEL left join pEL.pathwayClock as pathClock left join pEL.electiveListStatus as pELStatus left join pELStatus.electiveListStatus as status where pathClock.id = :Clock and status.id not in (" + WaitingListStatus.REMOVED.getID() + ")";
			
			List<?> extendedList = factory.find(query, new String[] {"Clock"}, new Object[] {catsReferralWithPathwayClock.getJourney().getCurrentClock().getID_PathwayClock()});
			
			if(extendedList == null || extendedList.size() == 0 || extendedList.get(0) == null)
				return null;
			
			PatientElectiveListVoCollection coll = new PatientElectiveListVoCollection();
			if(extendedList.get(0) instanceof PatientElectiveList)
			{
				PatientElectiveList electiveList = (PatientElectiveList) extendedList.get(0);
				PatientElectiveListVo electiveListVo = PatientElectiveListVoAssembler.create(electiveList);
				
				electiveListVo.setCanBeUsed(false);
				
				if(electiveList.getElectiveList() != null && electiveList.getElectiveList().getService() != null && serviceRef != null)
				{
					if(electiveList.getElectiveList().getService().getId().equals(serviceRef.getID_Service()))
					{
						electiveListVo.setCanBeUsed(true);
					}
					else if(electiveList.getElectiveList().getService().getSpecialty() != null)
					{
						Service service = (Service) factory.getDomainObject(Service.class, serviceRef.getID_Service());
						
						if(service != null && service.getSpecialty() != null && electiveList.getElectiveList().getService().getSpecialty().getId() == service.getSpecialty().getId())
						{
							electiveListVo.setCanBeUsed(true);
						}
					}
				}
				
				coll.add(electiveListVo);
				
				return coll;
			}
		}
		
		return PatientElectiveListVoAssembler.createPatientElectiveListVoCollectionFromPatientElectiveList(list);
	}

	//WDEV-18396
	public PatientElectiveListVo getPatientElectiveListsOnFormOpen(CatsReferralRefVo catsRef, ServiceRefVo serviceRef, String listIdHcp, Boolean nonDiagnosticELE, CatsReferralForNewElectivListEntryVo catsReferralWithPathwayClock)
	{
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		StringBuffer hqlConditions = new StringBuffer();
		String andStr = " and ";

		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("select pEL from PatientElectiveList as pEL left join pEL.electiveList as eL left join eL.service as service left join eL.hCPs as listOwners left join pEL.electiveListStatus as pELStatus left join pELStatus.electiveListStatus as status left join pEL.pathwayClock as pathClock ");
		
		if (catsRef!=null)
		{
			hqlConditions.append(andStr);
			hqlConditions.append(" pEL.referral.id = :CatsID ");
			markers.add("CatsID");
			values.add(catsRef.getID_CatsReferral());
			andStr = " and ";		
		}
		
		if (serviceRef!=null)
		{
			hqlConditions.append(andStr);
			hqlConditions.append(" service.id=:Service ");
			markers.add("Service");
			values.add(serviceRef.getID_Service());
			andStr = " and ";
		}
		
		if (listIdHcp!=null && listIdHcp.length()>0)
		{	
			hqlConditions.append(andStr);
			hqlConditions.append(" ( listOwners.hCP.id in "+ listIdHcp +" ) ");
			andStr = " and ";
		}
		
		if (nonDiagnosticELE)
		{
			hqlConditions.append(andStr);
			hqlConditions.append(" pEL.electiveListReason.id not in ("+ ElectiveListReason.DIAGNOSTIC.getID() +" ) ");
			andStr = " and ";
		}
		
		if (catsReferralWithPathwayClock != null && catsReferralWithPathwayClock.getJourney() != null && catsReferralWithPathwayClock.getJourney().getCurrentClock() != null)
		{
			hqlConditions.append(andStr);
			hqlConditions.append(" pathClock.id = :Clock ");
			markers.add("Clock");
			values.add(catsReferralWithPathwayClock.getJourney().getCurrentClock().getID_PathwayClock());
			andStr = " and ";
		}
		
		hqlConditions.insert(0, " where ( status.id not in (" + WaitingListStatus.REMOVED.getID() + ")");
		hqlConditions.append(" ) ");

		List <?> list = factory.find(hql.toString() + hqlConditions.toString(),markers,values);
		if (list == null || list.size() == 0)
			return null;
		return PatientElectiveListVoAssembler.create((PatientElectiveList) (list.get(0)));
	}

	//WDEV-18396
	public ElectiveListConfigurationVoCollection getElectiveListConfigurationOnFormOpen(ServiceRefVo serviceRef, LocationRefVo locationRef, String listIdHcp)
	{
		DomainFactory factory = getDomainFactory();

		StringBuffer hqlConditions = new StringBuffer();
		
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		String andStr = "";
		
		StringBuffer hql = new StringBuffer("select eLC from ElectiveListConfiguration as eLC left join eLC.hCPs as hcps left join hcps.hCP as hcp  left join eLC.listLocations as locations left join locations.listLocation as location ");
		
		if (serviceRef!=null) 
		{
			hqlConditions.append(andStr);
			hqlConditions.append(" eLC.service.id=:Service");
			markers.add("Service");
			values.add(serviceRef.getID_Service());
			andStr = " and ";
		}

		if (locationRef!=null)
		{
			hqlConditions.append(andStr);
			hqlConditions.append("( location.id=:LocID or locations is null )");
			markers.add("LocID");
			values.add(locationRef.getID_Location());
			andStr = " and ";
		}
		
		if (listIdHcp!=null && listIdHcp.length()>0)
		{	
			hqlConditions.append(andStr);
			hqlConditions.append("  hcp.id in "+ listIdHcp +" and hcps.defaultForHCP=1");
			andStr = " and ";
		}
		
		
		if (hqlConditions.length() > 0)
		{
			hqlConditions.insert(0, " where (");
			hqlConditions.append(" ) ");
		}
		
		List<?> list = factory.find(hql.toString() + hqlConditions.toString() + " order by UPPER(eLC.waitingListName) asc ",markers, values);

		
		return ElectiveListConfigurationVoAssembler.createElectiveListConfigurationVoCollectionFromElectiveListConfiguration(list);
	}

	//WDEV-18656
	public LocationLiteVo getParentHospitalLocation(LocationLiteVo wardLoc)
	{
		if (wardLoc == null)
			return null;
		
		Location doWard = (Location) getDomainFactory().getDomainObject(Location.class, wardLoc.getID_Location());
		
		return LocationLiteVoAssembler.create(doWard.getParentLocation());
				
	}

}
