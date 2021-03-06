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

package ims.clinical.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class ReferralDiscipline extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ReferralDiscipline()
	{
		super();
	}
	public ReferralDiscipline(int id)
	{
		super(id, "", true);
	}
	public ReferralDiscipline(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ReferralDiscipline(int id, String text, boolean active, ReferralDiscipline parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ReferralDiscipline(int id, String text, boolean active, ReferralDiscipline parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ReferralDiscipline(int id, String text, boolean active, ReferralDiscipline parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ReferralDiscipline buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ReferralDiscipline(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ReferralDiscipline)super.getParentInstance();
	}
	public ReferralDiscipline getParent()
	{
		return (ReferralDiscipline)super.getParentInstance();
	}
	public void setParent(ReferralDiscipline parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ReferralDiscipline[] typedChildren = new ReferralDiscipline[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ReferralDiscipline)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ReferralDiscipline)
		{
			super.addChild((ReferralDiscipline)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ReferralDiscipline)
		{
			super.removeChild((ReferralDiscipline)child);
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
		ReferralDisciplineCollection result = new ReferralDisciplineCollection();
		result.add(PHYSIO);
		result.add(CANCER);
		return result;
	}
	public static ReferralDiscipline[] getNegativeInstances()
	{
		ReferralDiscipline[] instances = new ReferralDiscipline[2];
		instances[0] = PHYSIO;
		instances[1] = CANCER;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "PHYSIO";
		negativeInstances[1] = "CANCER";
		return negativeInstances;
	}
	public static ReferralDiscipline getNegativeInstance(String name)
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
	public static ReferralDiscipline getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ReferralDiscipline[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1231064;
	public static final ReferralDiscipline PHYSIO = new ReferralDiscipline(-1402, "Physiotherapy", true, null, null, Color.Default);
	public static final ReferralDiscipline CANCER = new ReferralDiscipline(-1403, "Cancer", true, null, null, Color.Default);
}
