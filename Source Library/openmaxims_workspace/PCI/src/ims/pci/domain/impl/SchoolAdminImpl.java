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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.71 build 3594.20535)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.pci.domain.impl;

import ims.admin.helper.Keywords;
import ims.core.resource.place.domain.objects.School;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.domain.SchoolShortVoAssembler;
import ims.core.vo.domain.SchoolVoAssembler;
import ims.core.vo.lookups.LocationType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.pci.domain.base.impl.BaseSchoolAdminImpl;

import java.util.ArrayList;

public class SchoolAdminImpl extends BaseSchoolAdminImpl
{

	private static final long serialVersionUID = 1L;

	public ims.core.vo.SchoolShortVoCollection list(String school, ims.core.vo.LocationLiteVo sector)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		String query = "from School s ";
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		
		if(school != null)
		{
			if(markers.size() > 0)
				hql.append(" and ");
			
			hql.append("s.upperCaseName like :schoolName");
			markers.add("schoolName");
			values.add("%" + school.toUpperCase() + "%");
		}
		
		if(sector != null && sector.getID_LocationIsNotNull())
		{
			if(markers.size() > 0)
				hql.append(" and ");
			
			hql.append("s.sector.id = :sector");
			markers.add("sector");
			values.add(sector.getID_Location());
		}
		
		if (markers.size() > 0)
			query += " where ";
		query += hql.toString();

		return SchoolShortVoAssembler.createSchoolShortVoCollectionFromSchool(factory.find(query, markers, values));
	}

	public ims.core.vo.SchoolVo get(ims.core.resource.place.vo.SchoolRefVo schoolRef)
	{
		if(schoolRef == null || schoolRef.getID_School() == null)
			throw new DomainRuntimeException("School not provided for get call. ");
		
		DomainFactory factory = getDomainFactory();
		
		School doSchool = (School) factory.getDomainObject(School.class, schoolRef.getID_School());
		
		return SchoolVoAssembler.create(doSchool);
	}

	public ims.core.vo.SchoolVo save(ims.core.vo.SchoolVo school) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException
	{
		if(school == null)
			throw new DomainRuntimeException("Cannot save null SchoolVo.");
		
		if(!school.isValidated())
			throw new DomainRuntimeException("SchoolVo not validated.");
		
		DomainFactory factory = getDomainFactory();
		School doSchool = SchoolVoAssembler.extractSchool(factory, school);
		try
		{
		factory.save(doSchool);
		}
		catch (UnqViolationUncheckedException uvue) 
		{
			String dupMessage = Keywords.checkDuplicateTaxonomy(factory, doSchool, "externalMappings",school.getExternalMappings(), "getSchoolName");
			if(dupMessage != null)
				throw new UniqueKeyViolationException(dupMessage);
			
			//else is name duplication
			throw new UniqueKeyViolationException("A record called \"" + school.getSchoolName() + "\" already exists. Duplicates not allowed.", uvue);		
		
		}
		
		return SchoolVoAssembler.create(doSchool);
	}

	/**
	 * WDEV-12668 - Updated function: added parameter to control whether inactive records should be listed
	 */
	public LocationLiteVoCollection listSectors(String text, Boolean listInactive) 
	{
		if(text == null || (text != null && text.trim().length() == 0))
			throw new DomainRuntimeException("String for search is null.");
		
		String sectorLite = text != null ? text.toUpperCase() + "%" : "%%";
		
		StringBuffer hql = new StringBuffer();
		hql.append(" from Location loc");
		hql.append(" where loc.upperName like :secName and loc.type.id = :typeValue");
		
		// WDEV-12668 - Update query to list only active records
		if (!listInactive)
			hql.append(" and loc.isActive = 1");
		
		return LocationLiteVoAssembler.createLocationLiteVoCollectionFromLocation(getDomainFactory().find(hql.toString(), new String []{"secName", "typeValue"}, new Object []{sectorLite, LocationType.SECTOR.getID()}));
	}
}