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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.20 build 40907.1415)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;

import ims.admin.domain.base.impl.BaseDrawingConfigImpl;
import ims.core.configuration.domain.objects.DrawingGraphicImage;
import ims.core.configuration.vo.DrawingGraphicImageRefVo;
import ims.core.vo.DrawingGraphicImageVo;
import ims.core.vo.DrawingGraphicImageVoCollection;
import ims.core.vo.domain.DrawingGraphicImageVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.List;


public class DrawingConfigImpl extends BaseDrawingConfigImpl
{
	public DrawingGraphicImageVo saveGraphicImage(DrawingGraphicImageVo voGraphicImage) throws StaleObjectException
	{
		if(voGraphicImage == null)
			throw new RuntimeException("Cannot save null value for DrawingGraphicImageVo");
		if(!voGraphicImage.isValidated())
			throw new CodingRuntimeException("DrawingGraphicImageVo has not been validated");
		
		DomainFactory factory = getDomainFactory();
		DrawingGraphicImage doGraphicImage = DrawingGraphicImageVoAssembler.extractDrawingGraphicImage(factory, voGraphicImage);
		factory.save(doGraphicImage);
		
		return DrawingGraphicImageVoAssembler.create(doGraphicImage);
	}

	public DrawingGraphicImageVoCollection listGraphicImages(String name, ims.core.vo.lookups.PreActiveActiveInactiveStatus status)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("from DrawingGraphicImage dgi");
		java.util.ArrayList markers = new java.util.ArrayList();		
		java.util.ArrayList values  = new java.util.ArrayList();
		String clause = " where ";
		
		if(name != null && !name.equals(""))
		{
			hql.append(clause);
			hql.append("upper(dgi.imageName) like :imgName");
			markers.add("imgName");
			values.add(name.toUpperCase());
			clause = " and "; 
		}
		
		if(status != null)
		{
			hql.append(clause);
			hql.append("dgi.imageStatus = :imgStat");
			markers.add("imgStat");
			values.add(getDomLookup(status));
			clause = " and ";
		}

		List graphicImagesList = factory.find(hql.toString(), markers, values);
		return DrawingGraphicImageVoAssembler.createDrawingGraphicImageVoCollectionFromDrawingGraphicImage(graphicImagesList);
	}

	public DrawingGraphicImageVo getDrawingGraphicImage(DrawingGraphicImageRefVo drawingGraphicImageRefVo)
	{
		if(drawingGraphicImageRefVo == null)
			throw new CodingRuntimeException("Cannot get DrawingGraphicImageVo for null DrawingGraphicImageRefVo");
		
		DomainFactory factory = getDomainFactory();
		DrawingGraphicImage doDrawingGraphicImage = (DrawingGraphicImage) factory.getDomainObject(DrawingGraphicImage.class, drawingGraphicImageRefVo.getID_DrawingGraphicImage());
		return DrawingGraphicImageVoAssembler.create(doDrawingGraphicImage);
	}
}
