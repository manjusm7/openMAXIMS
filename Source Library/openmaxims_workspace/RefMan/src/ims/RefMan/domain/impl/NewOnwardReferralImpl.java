// This code was generated by Cristian Belciug using IMS Development Environment (version 1.65 build 3225.30788)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.RefMan.domain.impl;

import java.util.ArrayList;
import java.util.List;

import ims.RefMan.domain.ReferralOutcomeComponent;
import ims.RefMan.domain.base.impl.BaseNewOnwardReferralImpl;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.vo.CatsReferralListVo;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.ReferralOutcomeVo;
import ims.RefMan.vo.domain.CatsReferralListVoAssembler;
import ims.core.vo.OrgLiteVoCollection;
import ims.core.vo.domain.OrgLiteVoAssembler;
import ims.core.vo.lookups.OrganisationType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;

public class NewOnwardReferralImpl extends BaseNewOnwardReferralImpl
{
	private static final long serialVersionUID = 1L;

	public OrgLiteVoCollection listAllSuppliers() 
	{
		DomainFactory factory = getDomainFactory();

		String hql = " from Organisation org ";
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";

		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();

		condStr.append(andStr + " org.type.id = " + OrganisationType.SUPPLIER.getID());
		andStr = " and ";

		condStr.append(andStr + "org.isActive = :isActive");
		markers.add("isActive");
		values.add(Boolean.TRUE);	

		hql += " where ";
		hql += condStr.toString();

		List locations = factory.find(hql, markers, values, 1000);

		return OrgLiteVoAssembler.createOrgLiteVoCollectionFromOrganisation(locations).sort();
	}

	public CatsReferralListVo getCatsReferral(CatsReferralRefVo catsReferralRef) 
	{
		if(catsReferralRef == null || (catsReferralRef != null && !catsReferralRef.getID_CatsReferralIsNotNull()))
			throw new CodingRuntimeException("Cannot get CatsReferral on null CatsReferralRef.");
		
		return CatsReferralListVoAssembler.create((CatsReferral)getDomainFactory().getDomainObject(CatsReferral.class, catsReferralRef.getID_CatsReferral()));
	}

	public CatsReferralListVo saveCatsReferral(CatsReferralListVo catsReferral) throws StaleObjectException 
	{
		if(catsReferral == null)
			throw new DomainRuntimeException("Invalid referral wizard to save");
		if(!catsReferral.isValidated())
			throw new DomainRuntimeException("Record not validated before save");
		
		DomainFactory factory = getDomainFactory();
		CatsReferral domainObject = CatsReferralListVoAssembler.extractCatsReferral(factory, catsReferral);		
		factory.save(domainObject);
		return CatsReferralListVoAssembler.create(domainObject);
	}

	public ReferralOutcomeVo getReferralOutcome(CatsReferralRefVo catsReferralRef)
	{
		ReferralOutcomeComponent impl = (ReferralOutcomeComponent) getDomainImpl(ReferralOutcomeComponentImpl.class);
		
		return impl.getReferralOutcome(catsReferralRef);
	}

	public ReferralOutcomeVo saveReferralOutcome(ReferralOutcomeVo consultation) throws StaleObjectException 
	{
		ReferralOutcomeComponent impl = (ReferralOutcomeComponent) getDomainImpl(ReferralOutcomeComponentImpl.class);
		
		return impl.saveReferralOutcome(consultation);
	}
}
