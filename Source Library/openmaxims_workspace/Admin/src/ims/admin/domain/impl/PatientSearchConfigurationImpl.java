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
// This code was generated by Silviu Checherita using IMS Development Environment (version 1.80 build 5427.27524)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.admin.domain.impl;

import ims.admin.domain.base.impl.BasePatientSearchConfigurationImpl;
import ims.admin.vo.AppUserShortVo;
import ims.admin.vo.AppUserShortVoCollection;
import ims.admin.vo.domain.AppUserShortVoAssembler;
import ims.admin.vo.domain.PDSConfigurationVoAssembler;
import ims.core.admin.domain.objects.PDSConfiguration;
import ims.core.configuration.domain.objects.AppUser;
import ims.core.configuration.vo.AppUserRefVo;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class PatientSearchConfigurationImpl extends BasePatientSearchConfigurationImpl
{

	private static final long serialVersionUID = 1L;

	public ims.admin.vo.PDSConfigurationVo getPatientSearchConfig()
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		hql.append("FROM PDSConfiguration");
		List<?> list = factory.find(hql.toString());
		
		if (list != null && list.size() > 0)
			return PDSConfigurationVoAssembler.create((PDSConfiguration) (list).get(0));
		
		return null;
	}

	public ims.admin.vo.PDSConfigurationVo savePatientSearchConfig(ims.admin.vo.PDSConfigurationVo value) throws ims.domain.exceptions.StaleObjectException
	{
		if (value == null )
			throw new CodingRuntimeException("Cannot save null PDSConfigurationVo.");

		if (!value.isValidated())
				throw new DomainRuntimeException("PDSConfigurationVo Not Validated.");
		
		DomainFactory factory = getDomainFactory();
		
		PDSConfiguration domPDSConfiguration = PDSConfigurationVoAssembler.extractPDSConfiguration(factory, value);
		factory.save(domPDSConfiguration);
		
		return PDSConfigurationVoAssembler.create(domPDSConfiguration);
	}

	@Override
	public AppUserShortVoCollection listUsers(AppUserShortVo filter) 
	{
		DomainFactory factory = getDomainFactory();
		String andStr = " ";
		StringBuffer clause = new StringBuffer();
		
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();

		String hql = "  from AppUser u ";
		
		if (filter.getUsername() != null && filter.getUsername().length() > 0)
		{
				hql = " from AppUser u ";
				clause.append(" upper(u.username) like :username");
				names.add("username");
				values.add("%" + filter.getUsername().trim().toUpperCase() + "%");
				andStr = " and ";
		}		
			clause.append(andStr + " u.isActive = :isActive" );
			names.add("isActive");
			values.add(Boolean.TRUE);		
			andStr = " and ";
				
		clause.append(andStr).append(" u.username != 'xxxxx'");
		andStr=" and ";

		if (andStr.equals(" and "))
		{
			hql += " where ";
		}
		hql += clause.toString();
		AppUserShortVoCollection ret = new AppUserShortVoCollection();
		List<?> list = factory.find(hql, names, values);
		
		for (int i = 0; i < list.size(); i++)
		{
			AppUser domUser = (AppUser) list.get(i);
			AppUserShortVo voUser = AppUserShortVoAssembler.create(domUser);
			if (domUser.getMos() != null && domUser.getMos().getName() != null)
				voUser.setUserRealName(domUser.getMos().getName().toString());
			ret.add(voUser);	
		}
		return ret.sort();
	}

	@Override
	public AppUserShortVo getApptUserShort(AppUserRefVo userId) 
	{
		if (userId != null)
		{	
		 AppUser user = (AppUser) getDomainFactory().getDomainObject(AppUser.class,userId.getID_AppUser());
			return AppUserShortVoAssembler.create(user);
		}
		return null;
	}
}
