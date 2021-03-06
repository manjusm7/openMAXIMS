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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.vo.enums;

public final class RiskAssessmentType extends ims.framework.utils.Enum
{
	public final static RiskAssessmentType VTE = new RiskAssessmentType(0, "VTE", null, ims.framework.utils.Color.Default);
	public final static RiskAssessmentType WATERLOW = new RiskAssessmentType(1, "Waterlow", null, ims.framework.utils.Color.Default);
	public final static RiskAssessmentType REPOSSTITIONING = new RiskAssessmentType(2, "Re-postitioning", null, ims.framework.utils.Color.Default);
	public final static RiskAssessmentType FALLS = new RiskAssessmentType(3, "Falls", null, ims.framework.utils.Color.Default);
	public final static RiskAssessmentType VIP = new RiskAssessmentType(4, "VIP", null, ims.framework.utils.Color.Default);
	public final static RiskAssessmentType NV = new RiskAssessmentType(5, "NV", null, ims.framework.utils.Color.Default);
	public final static RiskAssessmentType MOVINGHANDLING = new RiskAssessmentType(6, "Moving & handling", null, ims.framework.utils.Color.Default);
	public final static RiskAssessmentType BEDRAILS = new RiskAssessmentType(7, "Bed Rails", null, ims.framework.utils.Color.Default);
	public final static RiskAssessmentType DELIRIUM = new RiskAssessmentType(8, "Delirium", null, ims.framework.utils.Color.Default);
	public final static RiskAssessmentType MUST = new RiskAssessmentType(9, "MUST", null, ims.framework.utils.Color.Default);

	private RiskAssessmentType(int id, String text, ims.framework.utils.Image image, ims.framework.utils.Color textColor)
	{
		super(id, text, image, textColor);
	}
}
