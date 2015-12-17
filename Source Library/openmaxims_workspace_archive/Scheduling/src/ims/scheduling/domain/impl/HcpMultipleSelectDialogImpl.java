//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 5196.25869)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.scheduling.domain.impl;

import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.scheduling.domain.base.impl.BaseHcpMultipleSelectDialogImpl;

import java.util.ArrayList;

public class HcpMultipleSelectDialogImpl extends BaseHcpMultipleSelectDialogImpl
{

	private static final long serialVersionUID = 1L;
	//WDEV-19368 
	public HcpLiteVoCollection listHCPs(String name,String selectedHcpIds)
	{
		if (name == null || (name != null && name.length() == 0))
			throw new DomainRuntimeException("Can not search on null name.");

		DomainFactory factory = getDomainFactory();

		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();

		String hql = "select h from Hcp h ";

		hql += "where h.isActive = :isActive and (h.mos.name.upperSurname like :hcpSname or h.mos.name.upperForename like :hcpFname)";
		
		if (selectedHcpIds != null && selectedHcpIds.trim().length() > 0)
		{
			hql +=" and h.mos.id not in (" + selectedHcpIds +")";
		}
				
		markers.add("isActive");
		values.add(Boolean.TRUE);
		markers.add("hcpSname");
		values.add(name.toUpperCase() + "%");
		markers.add("hcpFname");
		values.add(name.toUpperCase() + "%");

		hql += " order by h.mos.name.upperSurname,h.mos.name.upperForename";

		return HcpLiteVoAssembler.createHcpLiteVoCollectionFromHcp(factory.find(hql, markers, values));
	}
}