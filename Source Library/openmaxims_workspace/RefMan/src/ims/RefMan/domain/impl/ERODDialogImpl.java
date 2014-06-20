// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4910.25978)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import ims.RefMan.domain.base.impl.BaseERODDialogImpl;
import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.domain.objects.PatientElectiveList;
import ims.RefMan.domain.objects.ReferralEROD;
import ims.RefMan.vo.CatsReferralERODVo;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.ReferralERODRefVo;
import ims.RefMan.vo.ReferralERODVo;
import ims.RefMan.vo.domain.CatsReferralERODVoAssembler;
import ims.RefMan.vo.domain.ReferralERODVoAssembler;
import ims.RefMan.vo.lookups.ERODType;
import ims.domain.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;
import ims.pathways.domain.objects.PauseDetails;

import java.util.List;

public class ERODDialogImpl extends BaseERODDialogImpl
{
	private static final long serialVersionUID = 1L;

	public CatsReferralERODVo getCatsReferral(CatsReferralRefVo catsReferral)
	{
		if(catsReferral == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		CatsReferral doCatsErod = (CatsReferral) factory.getDomainObject(CatsReferral.class, catsReferral.getID_CatsReferral());
		
		return CatsReferralERODVoAssembler.create(doCatsErod);
	}

	public CatsReferralERODVo saveEROD(ERODType erodType, CatsReferralERODVo catsReferralErod, ReferralERODVo referralEROD) throws ims.domain.exceptions.StaleObjectException
	{
		if(catsReferralErod == null)
			throw new CodingRuntimeException("Cannot save a null CatsReferralERODVo.");
		
		if(!catsReferralErod.isValidated())
			throw new CodingRuntimeException("CatsReferralERODVo is not validated.");
		
		if(referralEROD == null)
			throw new CodingRuntimeException("Cannot save a null ReferralERODVo.");
		
		DomainFactory factory = getDomainFactory();
		CatsReferral doCatsReferralErod = null;
		
		if(ERODType.ELECTIVE.equals(erodType))
		{
			ReferralEROD doReferralErod = ReferralERODVoAssembler.extractReferralEROD(factory, referralEROD);
			factory.save(doReferralErod);
			
			if(referralEROD.getID_ReferralEROD() == null)
			{
				doCatsReferralErod = CatsReferralERODVoAssembler.extractCatsReferral(factory, catsReferralErod);
			
				if(doCatsReferralErod.getElectiveEROD() == null)
					doCatsReferralErod.setElectiveEROD(new java.util.ArrayList());
			
				doCatsReferralErod.getElectiveEROD().add(doReferralErod);
				
				if(catsReferralErod.getJourney() != null && catsReferralErod.getJourney().getCurrentClock() != null)
				{
					PauseDetails doPauseDetails = new PauseDetails();
					doPauseDetails.setPauseStart(doReferralErod.getERODDate1());
					doPauseDetails.setActive(true);
					
					doCatsReferralErod.getJourney().getCurrentClock().setCurrentPause(doPauseDetails);
					
					if(catsReferralErod.getJourney().getCurrentClock().getPauseDetails() == null)
						doCatsReferralErod.getJourney().getCurrentClock().setPauseDetails(new java.util.ArrayList());
					
					doCatsReferralErod.getJourney().getCurrentClock().getPauseDetails().add(doPauseDetails);
				}
			
				factory.save(doCatsReferralErod);
			}
			
			if(catsReferralErod.getJourney() != null && catsReferralErod.getJourney().getCurrentClock() != null)
			{
				String patientElectiveListQuery = "select electiveList from PatientElectiveList as electiveList left join electiveList.referral as cats left join electiveList.pathwayClock as pc where cats.id = :CatsId and pc.id = :PathwayClock";
				List<?> electiveList = factory.find(patientElectiveListQuery, new String[] {"CatsId", "PathwayClock"}, new Object[] {catsReferralErod.getID_CatsReferral(), catsReferralErod.getJourney().getCurrentClock().getID_PathwayClock()});
				
				if(electiveList != null && electiveList.size() > 0 && electiveList.get(0) instanceof PatientElectiveList)
				{
					PatientElectiveList doPatientElectiveList = (PatientElectiveList) electiveList.get(0);
					doPatientElectiveList.setEROD(doReferralErod);
					
					factory.save(doPatientElectiveList);
				}
			}
		}
		else if(ERODType.OUTPATIENT.equals(erodType))
		{
			doCatsReferralErod = CatsReferralERODVoAssembler.extractCatsReferral(factory, catsReferralErod);
			factory.save(doCatsReferralErod);
		}
		
		return CatsReferralERODVoAssembler.create(doCatsReferralErod);
	}

	public ReferralERODVo getEROD(ReferralERODRefVo erod)
	{
		if(erod == null)
			return null;
		
		DomainFactory factory = getDomainFactory();
		ReferralEROD doErod = (ReferralEROD) factory.getDomainObject(ReferralEROD.class, erod.getID_ReferralEROD());
		
		return ReferralERODVoAssembler.create(doErod);
	}

	public Boolean isStale(ReferralERODRefVo referralERODRef)
	{
		if(referralERODRef == null)
			return false;
		
		DomainFactory factory = getDomainFactory();
		
		List<?> refErods = factory.find("select re.id from ReferralEROD as re where re.id = :ReferralERODId and re.version > :ReferralERODVersion", new String[] {"ReferralERODId", "ReferralERODVersion"}, new Object[] {referralERODRef.getID_ReferralEROD(), referralERODRef.getVersion_ReferralEROD()});
		
		if(refErods != null && refErods.size() > 0)
			return true;
		
		return false;
	}
}
