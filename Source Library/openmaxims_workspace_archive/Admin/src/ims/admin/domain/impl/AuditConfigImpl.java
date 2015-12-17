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
// This code was generated by John MacEnri using IMS Development Environment (version 1.53 build 2566.31117)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;

import java.util.List;

import ims.admin.domain.base.impl.BaseAuditConfigImpl;
import ims.admin.vo.AuditedClassVo;
import ims.configuration.ClassConfig;
import ims.configuration.Configuration;
import ims.configuration.NonAuditObject;
import ims.domain.DomainFactory;
import ims.domain.SessionData;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.framework.SessionConstants;

public class AuditConfigImpl extends BaseAuditConfigImpl
{

	private static final long serialVersionUID = 1L;

	public void saveAuditConfig(ims.admin.vo.AuditedClassVoCollection nonAuditedClasses) throws ims.domain.exceptions.StaleObjectException
	{
		DomainFactory factory = this.getDomainFactory();
		String hql = "from NonAuditObject where boClassName = ";
		SessionData sessData = (SessionData)factory.getDomainSession().getAttribute(SessionConstants.SESSION_DATA);
		Configuration cfg = sessData.configurationModule.get();
		ClassConfig classCfg = cfg.getClassConfig();
		
		for (int i = 0; i < nonAuditedClasses.size(); i++)
		{
			AuditedClassVo vo = nonAuditedClasses.get(i);
			try
			{
				factory.delete(hql + "'" + vo.getClassName() + "'");
			}
			catch (ForeignKeyViolationException e)
			{
				throw new DomainRuntimeException(e);
			}
			classCfg.makeObjectAudited(vo.getClassName());
			if (!vo.getIsAudited().booleanValue())
			{
				NonAuditObject domNonAud = new NonAuditObject();
				domNonAud.setBoClassName(vo.getClassName());
				factory.save(domNonAud);
				classCfg.makeObjectNonAudited(vo.getClassName());				
			}
		}				
	}

	private Configuration getConfiguration()
	{
		SessionData sessData = (SessionData)this.getDomainFactory().getDomainSession().getAttribute(SessionConstants.SESSION_DATA);
		Configuration cfg = sessData.configurationModule.get();
		return cfg;
	}

	public void activateAuditConfig()
	{		
		DomainFactory factory = getDomainFactory();		
		List nonAuditBos = factory.find("select na.boClassName from NonAuditObject na");
		ClassConfig cc = getConfiguration().getClassConfig();
		cc.loadNonAuditBos(nonAuditBos);		
	}
}