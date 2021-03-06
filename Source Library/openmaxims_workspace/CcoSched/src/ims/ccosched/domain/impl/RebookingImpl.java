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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.ccosched.domain.impl;

import java.util.ArrayList;
import java.util.List;


import ims.ccosched.domain.Rebooking;
import ims.ccosched.vo.PatTreatmentPlanLiteVo;
import ims.ccosched.vo.domain.PatTreatmentPlanLiteVoAssembler;
import ims.domain.DomainFactory;
import ims.dto.DTODomainImplementation;

public class RebookingImpl extends DTODomainImplementation implements Rebooking
{

	private static final long serialVersionUID = 1L;

	public PatTreatmentPlanLiteVo getTreatmentPlan(Integer actionIdFromDTO) 
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("select ptp from PatTreatmentPlan as ptp left join ptp.actions as acts where "); 
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
		hql.append(" acts.id = :aptId");
		markers.add("aptId");
		values.add(actionIdFromDTO);

		hql.append(" and ptp.isRIE is null");

		List listPTP = factory.find(hql.toString(), markers,values);
		if (listPTP != null && listPTP.size() > 0) 
			return PatTreatmentPlanLiteVoAssembler.create((ims.oncology.domain.objects.PatTreatmentPlan)listPTP.get(0));
		else
			return null;
	}
}
