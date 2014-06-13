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

package ims.emergency.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class AttendanceOutcome extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public AttendanceOutcome()
	{
		super();
	}
	public AttendanceOutcome(int id)
	{
		super(id, "", true);
	}
	public AttendanceOutcome(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public AttendanceOutcome(int id, String text, boolean active, AttendanceOutcome parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public AttendanceOutcome(int id, String text, boolean active, AttendanceOutcome parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public AttendanceOutcome(int id, String text, boolean active, AttendanceOutcome parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static AttendanceOutcome buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new AttendanceOutcome(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (AttendanceOutcome)super.getParentInstance();
	}
	public AttendanceOutcome getParent()
	{
		return (AttendanceOutcome)super.getParentInstance();
	}
	public void setParent(AttendanceOutcome parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		AttendanceOutcome[] typedChildren = new AttendanceOutcome[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (AttendanceOutcome)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof AttendanceOutcome)
		{
			super.addChild((AttendanceOutcome)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof AttendanceOutcome)
		{
			super.removeChild((AttendanceOutcome)child);
		}
		return super.getChildInstances().size();
	}
	public Image getExpandedImage()
	{
		return super.getImage();
	}
	public Image getCollapsedImage()
	{
		return super.getImage();
	}
	public static ims.framework.IItemCollection getNegativeInstancesAsIItemCollection()
	{
		AttendanceOutcomeCollection result = new AttendanceOutcomeCollection();
		result.add(DID_NOT_WAIT);
		result.add(MORTUARY);
		result.add(DID);
		result.add(DOA);
		result.add(BID);
		result.add(TRANSFERRED);
		result.add(OPD);
		result.add(ADMISSIONS);
		result.add(ED_CLINIC);
		return result;
	}
	public static AttendanceOutcome[] getNegativeInstances()
	{
		AttendanceOutcome[] instances = new AttendanceOutcome[9];
		instances[0] = DID_NOT_WAIT;
		instances[1] = MORTUARY;
		instances[2] = DID;
		instances[3] = DOA;
		instances[4] = BID;
		instances[5] = TRANSFERRED;
		instances[6] = OPD;
		instances[7] = ADMISSIONS;
		instances[8] = ED_CLINIC;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[9];
		negativeInstances[0] = "DID_NOT_WAIT";
		negativeInstances[1] = "MORTUARY";
		negativeInstances[2] = "DID";
		negativeInstances[3] = "DOA";
		negativeInstances[4] = "BID";
		negativeInstances[5] = "TRANSFERRED";
		negativeInstances[6] = "OPD";
		negativeInstances[7] = "ADMISSIONS";
		negativeInstances[8] = "ED_CLINIC";
		return negativeInstances;
	}
	public static AttendanceOutcome getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		String[] negativeInstances = getNegativeInstanceNames();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].equals(name))
				return getNegativeInstances()[i];
		}
		return null;
	}
	public static AttendanceOutcome getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		AttendanceOutcome[] negativeInstances = getNegativeInstances();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].getID() == id)
				return negativeInstances[i];
		}
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1291014;
	public static final AttendanceOutcome DID_NOT_WAIT = new AttendanceOutcome(-2346, "Did Not Wait", true, null, null, Color.Default);
	public static final AttendanceOutcome MORTUARY = new AttendanceOutcome(-2356, "Mortuary", true, null, null, Color.Default);
	public static final AttendanceOutcome DID = new AttendanceOutcome(-2357, "DID", true, null, null, Color.Default);
	public static final AttendanceOutcome DOA = new AttendanceOutcome(-2358, "DOA", true, null, null, Color.Default);
	public static final AttendanceOutcome BID = new AttendanceOutcome(-2359, "BID", true, null, null, Color.Default);
	public static final AttendanceOutcome TRANSFERRED = new AttendanceOutcome(-2360, "Transferred", true, null, null, Color.Default);
	public static final AttendanceOutcome OPD = new AttendanceOutcome(-2361, "OPD", true, null, null, Color.Default);
	public static final AttendanceOutcome ADMISSIONS = new AttendanceOutcome(-2362, "Admissions", true, null, null, Color.Default);
	public static final AttendanceOutcome ED_CLINIC = new AttendanceOutcome(-2363, "ED Clinic", true, null, null, Color.Default);
}