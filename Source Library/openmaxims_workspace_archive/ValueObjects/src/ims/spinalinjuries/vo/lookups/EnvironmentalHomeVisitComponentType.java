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

package ims.spinalinjuries.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class EnvironmentalHomeVisitComponentType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public EnvironmentalHomeVisitComponentType()
	{
		super();
	}
	public EnvironmentalHomeVisitComponentType(int id)
	{
		super(id, "", true);
	}
	public EnvironmentalHomeVisitComponentType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public EnvironmentalHomeVisitComponentType(int id, String text, boolean active, EnvironmentalHomeVisitComponentType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public EnvironmentalHomeVisitComponentType(int id, String text, boolean active, EnvironmentalHomeVisitComponentType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public EnvironmentalHomeVisitComponentType(int id, String text, boolean active, EnvironmentalHomeVisitComponentType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static EnvironmentalHomeVisitComponentType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new EnvironmentalHomeVisitComponentType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (EnvironmentalHomeVisitComponentType)super.getParentInstance();
	}
	public EnvironmentalHomeVisitComponentType getParent()
	{
		return (EnvironmentalHomeVisitComponentType)super.getParentInstance();
	}
	public void setParent(EnvironmentalHomeVisitComponentType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		EnvironmentalHomeVisitComponentType[] typedChildren = new EnvironmentalHomeVisitComponentType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (EnvironmentalHomeVisitComponentType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof EnvironmentalHomeVisitComponentType)
		{
			super.addChild((EnvironmentalHomeVisitComponentType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof EnvironmentalHomeVisitComponentType)
		{
			super.removeChild((EnvironmentalHomeVisitComponentType)child);
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
		EnvironmentalHomeVisitComponentTypeCollection result = new EnvironmentalHomeVisitComponentTypeCollection();
		result.add(ENVIRONMENTAL);
		result.add(ENVIRONMENTALEXTERNALACCESSANDPARKING);
		result.add(INTERNALACCESS);
		result.add(TOILETINGANDCHANGINGFACILITIES);
		result.add(FOODANDDRINKINGFACILITIES);
		result.add(HOMEVISIT);
		result.add(HOMEVISITEXTERNALACCESSANDPARKING);
		result.add(ACCESSFRONT);
		result.add(ACCESSBACK);
		result.add(BATHINGANDTOILETFACILITIES);
		result.add(HEATING);
		result.add(STAIRCASE);
		return result;
	}
	public static EnvironmentalHomeVisitComponentType[] getNegativeInstances()
	{
		EnvironmentalHomeVisitComponentType[] instances = new EnvironmentalHomeVisitComponentType[12];
		instances[0] = ENVIRONMENTAL;
		instances[1] = ENVIRONMENTALEXTERNALACCESSANDPARKING;
		instances[2] = INTERNALACCESS;
		instances[3] = TOILETINGANDCHANGINGFACILITIES;
		instances[4] = FOODANDDRINKINGFACILITIES;
		instances[5] = HOMEVISIT;
		instances[6] = HOMEVISITEXTERNALACCESSANDPARKING;
		instances[7] = ACCESSFRONT;
		instances[8] = ACCESSBACK;
		instances[9] = BATHINGANDTOILETFACILITIES;
		instances[10] = HEATING;
		instances[11] = STAIRCASE;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[12];
		negativeInstances[0] = "ENVIRONMENTAL";
		negativeInstances[1] = "ENVIRONMENTALEXTERNALACCESSANDPARKING";
		negativeInstances[2] = "INTERNALACCESS";
		negativeInstances[3] = "TOILETINGANDCHANGINGFACILITIES";
		negativeInstances[4] = "FOODANDDRINKINGFACILITIES";
		negativeInstances[5] = "HOMEVISIT";
		negativeInstances[6] = "HOMEVISITEXTERNALACCESSANDPARKING";
		negativeInstances[7] = "ACCESSFRONT";
		negativeInstances[8] = "ACCESSBACK";
		negativeInstances[9] = "BATHINGANDTOILETFACILITIES";
		negativeInstances[10] = "HEATING";
		negativeInstances[11] = "STAIRCASE";
		return negativeInstances;
	}
	public static EnvironmentalHomeVisitComponentType getNegativeInstance(String name)
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
	public static EnvironmentalHomeVisitComponentType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		EnvironmentalHomeVisitComponentType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1051147;
	public static final EnvironmentalHomeVisitComponentType ENVIRONMENTAL = new EnvironmentalHomeVisitComponentType(-233, "Environmental", true, null, null, Color.Default);
	public static final EnvironmentalHomeVisitComponentType ENVIRONMENTALEXTERNALACCESSANDPARKING = new EnvironmentalHomeVisitComponentType(-235, "External Access and Parking", true, EnvironmentalHomeVisitComponentType.ENVIRONMENTAL, null, Color.Default);
	public static final EnvironmentalHomeVisitComponentType INTERNALACCESS = new EnvironmentalHomeVisitComponentType(-236, "Internal Access", true, EnvironmentalHomeVisitComponentType.ENVIRONMENTAL, null, Color.Default);
	public static final EnvironmentalHomeVisitComponentType TOILETINGANDCHANGINGFACILITIES = new EnvironmentalHomeVisitComponentType(-237, "Toileting and Changing Facilities", true, EnvironmentalHomeVisitComponentType.ENVIRONMENTAL, null, Color.Default);
	public static final EnvironmentalHomeVisitComponentType FOODANDDRINKINGFACILITIES = new EnvironmentalHomeVisitComponentType(-238, "Food and Drinking Facilities", true, EnvironmentalHomeVisitComponentType.ENVIRONMENTAL, null, Color.Default);
	public static final EnvironmentalHomeVisitComponentType HOMEVISIT = new EnvironmentalHomeVisitComponentType(-234, "Home Visit", true, null, null, Color.Default);
	public static final EnvironmentalHomeVisitComponentType HOMEVISITEXTERNALACCESSANDPARKING = new EnvironmentalHomeVisitComponentType(-239, "External Access and Parking", true, EnvironmentalHomeVisitComponentType.HOMEVISIT, null, Color.Default);
	public static final EnvironmentalHomeVisitComponentType ACCESSFRONT = new EnvironmentalHomeVisitComponentType(-240, "Access Front", true, EnvironmentalHomeVisitComponentType.HOMEVISIT, null, Color.Default);
	public static final EnvironmentalHomeVisitComponentType ACCESSBACK = new EnvironmentalHomeVisitComponentType(-241, "Access Back", true, EnvironmentalHomeVisitComponentType.HOMEVISIT, null, Color.Default);
	public static final EnvironmentalHomeVisitComponentType BATHINGANDTOILETFACILITIES = new EnvironmentalHomeVisitComponentType(-242, "Bathing and Toilet Facilities", true, EnvironmentalHomeVisitComponentType.HOMEVISIT, null, Color.Default);
	public static final EnvironmentalHomeVisitComponentType HEATING = new EnvironmentalHomeVisitComponentType(-243, "Heating", true, EnvironmentalHomeVisitComponentType.HOMEVISIT, null, Color.Default);
	public static final EnvironmentalHomeVisitComponentType STAIRCASE = new EnvironmentalHomeVisitComponentType(-244, "Staircase", true, EnvironmentalHomeVisitComponentType.HOMEVISIT, null, Color.Default);
}