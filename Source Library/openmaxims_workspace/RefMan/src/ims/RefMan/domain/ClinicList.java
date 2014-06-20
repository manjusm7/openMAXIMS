// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.domain;

// Generated from form domain impl
public interface ClinicList extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.scheduling.vo.SessionShortVoCollection listSession(ims.core.vo.ServiceShortVo service, ims.core.vo.ServiceFunctionVoCollection functionColl, ims.scheduling.vo.ProfileShortVo profile, ims.framework.utils.Date sessionDate);

	// Generated from form domain interface definition
	public ims.core.vo.ServiceShortVoCollection listService(ims.core.vo.ServiceShortVo serviceShort);

	// Generated from form domain interface definition
	public ims.core.vo.ServiceFunctionVoCollection listServiceFunctions(ims.core.vo.ServiceShortVo serviceShort);

	// Generated from form domain interface definition
	/**
	* one of the parameters can only be used at any time
	*/
	public ims.scheduling.vo.SessionSlotVoCollection listSessionSlots(ims.scheduling.vo.SessionShortVo session, Integer[] sessionIds);

	// Generated from form domain interface definition
	/**
	* retrieve the patient for this appt through the parent Sch_Booking
	*/
	public ims.core.vo.PatientShort getBookingPatient(ims.scheduling.vo.Booking_AppointmentVo appointment);

	// Generated from form domain interface definition
	/**
	* Lists all profiles
	*/
	public ims.scheduling.vo.ProfileShortVoCollection listProfiles(ims.framework.interfaces.ILocation location, ims.framework.utils.Date date);

	// Generated from form domain interface definition
	public void dnaAppt(ims.scheduling.vo.Booking_AppointmentVo appt, ims.chooseandbook.vo.lookups.ActionRequestType requestType) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void cancelSlot(ims.scheduling.vo.SessionSlotVo sessionSlot, ims.chooseandbook.vo.lookups.ActionRequestType requestType, String requestSource) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.scheduling.vo.Booking_AppointmentVo cancelAppt(ims.scheduling.vo.Booking_AppointmentVo appt, ims.chooseandbook.vo.lookups.ActionRequestType requestType, String requestSource) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void reOpenSlot(ims.scheduling.vo.SessionSlotVo sessionSlot) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* listFlexibleBookings
	*/
	public ims.scheduling.vo.Sch_BookingVoCollection listFlexibleBookings(ims.scheduling.vo.Sch_SessionRefVo session);

	// Generated from form domain interface definition
	/**
	* listAppointments
	*/
	public ims.scheduling.vo.SessionSlotVoCollection listAppointments(ims.scheduling.vo.Sch_SessionRefVo session, Integer[] sessionIds, ims.scheduling.vo.lookups.Status_Reason apptType);

	// Generated from form domain interface definition
	/**
	* saveAppointment
	*/
	public void saveAppointment(ims.scheduling.vo.Booking_AppointmentVo appt) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.CareSpellVo saveCareSpell(ims.core.vo.CareSpellVo voCareSpell) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* getPASCode
	*/
	public ims.core.vo.lookups.ContextType getPASCode(ims.core.vo.ActivityVo activity);

	// Generated from form domain interface definition
	/**
	* Communicates with CabGW interface
	*/
	public ims.scheduling.domain.objects.Booking_Appointment sendRequestandUpdateReferences(ims.domain.DomainFactory factory, ims.chooseandbook.vo.lookups.ActionRequestType requestType, ims.domain.DomainObject domObject, String requestSource) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* getCatsReferralForAppointment
	*/
	public ims.RefMan.vo.CatsReferralRefVo getCatsReferralForAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt);

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralWizardVo getCatsReferralWizardForAppointment(ims.scheduling.vo.Booking_AppointmentRefVo appt);

	// Generated from form domain interface definition
	public ims.RefMan.vo.ConsultationDetailsVo getConsultationDetailsForCatsReferral(ims.RefMan.vo.CatsReferralRefVo catsReferral);

	// Generated from form domain interface definition
	public void saveConsultationDetails(ims.RefMan.vo.ConsultationDetailsVo consultation) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* updateCatsReferralAdditionalInvStatus
	*/
	public void updateCatsReferralAdditionalInvStatus(ims.RefMan.vo.CatsReferralRefVo catsReferral) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* save consultation
	*/
	public ims.RefMan.vo.ConsultationDetailsVo saveConsultationAndReferralAndAppt(ims.RefMan.vo.ConsultationDetailsVo voConsultation, ims.RefMan.vo.CatsReferralListVo voReferral, ims.scheduling.vo.Booking_AppointmentVo voAppt) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	/**
	* Get Referral
	*/
	public ims.RefMan.vo.CatsReferralListVo getCatsReferral(ims.RefMan.vo.CatsReferralRefVo voReferralRef);

	// Generated from form domain interface definition
	/**
	* Get Care Context Short
	*/
	public ims.core.vo.CareContextShortVo getCareContextShort(ims.core.admin.vo.CareContextRefVo voCareContextRef);

	// Generated from form domain interface definition
	public ims.core.vo.PatientShort getPatient(ims.core.patient.vo.PatientRefVo patient);

	// Generated from form domain interface definition
	/**
	* listLocationLite
	*/
	public ims.core.vo.LocationLiteVoCollection listLocationLite();

	// Generated from form domain interface definition
	/**
	* updateCatsReferralCancelStatus
	*/
	public void updateCatsReferralCancelStatus(ims.RefMan.vo.CatsReferralRefVo catsReferral) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public ims.core.vo.OrganisationLiteVoCollection listOrganisation();

	// Generated from form domain interface definition
	public ims.core.vo.LocationLiteVoCollection listLocationByOrganisation(ims.core.resource.place.vo.OrganisationRefVo orgId);

	// Generated from form domain interface definition
	public ims.core.vo.OrganisationLiteVo getOrganisationByLocation(Integer locationId);

	// Generated from form domain interface definition
	public ims.RefMan.vo.SessionSlotCatsReferralClinicListWrapperVoCollection listAppointments(ims.scheduling.vo.Sch_SessionRefVoCollection sessions, ims.scheduling.vo.lookups.Status_Reason apptType);

	// Generated from form domain interface definition
	public ims.scheduling.vo.SessionSlotVo getSessionSlot(ims.scheduling.vo.Session_SlotRefVo slotRef);

	// Generated from form domain interface definition
	public ims.scheduling.vo.Booking_AppointmentVo getAppointment(ims.scheduling.vo.Session_SlotRefVo session);

	// Generated from form domain interface definition
	public ims.RefMan.vo.CatsReferralForClinicListVo getCatsReferral(ims.scheduling.vo.Booking_AppointmentRefVo appt);

	// Generated from form domain interface definition
	public void saveAppointmentForDNA(ims.scheduling.vo.Booking_AppointmentVo appt, ims.RefMan.vo.CatsReferralForClinicListVo catsReferral, ims.scheduling.vo.SessionSlotClinicListListVo sessionSlot, ims.RefMan.vo.PatientElectiveListForDNAAppointmentsVo electiveList, Boolean isFirstApptActivityforDNA) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public Boolean isThereAnyDiagnosticContractsForThisSite(ims.core.resource.place.vo.OrganisationRefVo voOrg);

	// Generated from form domain interface definition
	public ims.scheduling.vo.Booking_AppointmentVo getArrivedBookingAppt(ims.RefMan.vo.CatsReferralListVo catsReferralRefVo);

	// Generated from form domain interface definition
	public Boolean hasLocationDiagnosticContract(ims.core.resource.place.vo.LocationRefVo location);

	// Generated from form domain interface definition
	public Boolean hasTCI(ims.scheduling.vo.Booking_AppointmentRefVo appointment);

	// Generated from form domain interface definition
	public ims.RefMan.vo.PatientElectiveListForDNAAppointmentsVo getPatientElectiveList(ims.scheduling.vo.Booking_AppointmentRefVo appointment);
}
