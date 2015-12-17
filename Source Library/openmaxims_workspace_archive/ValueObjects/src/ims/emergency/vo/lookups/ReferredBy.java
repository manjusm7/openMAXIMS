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

public class ReferredBy extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ReferredBy()
	{
		super();
	}
	public ReferredBy(int id)
	{
		super(id, "", true);
	}
	public ReferredBy(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ReferredBy(int id, String text, boolean active, ReferredBy parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ReferredBy(int id, String text, boolean active, ReferredBy parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ReferredBy(int id, String text, boolean active, ReferredBy parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ReferredBy buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ReferredBy(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ReferredBy)super.getParentInstance();
	}
	public ReferredBy getParent()
	{
		return (ReferredBy)super.getParentInstance();
	}
	public void setParent(ReferredBy parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ReferredBy[] typedChildren = new ReferredBy[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ReferredBy)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ReferredBy)
		{
			super.addChild((ReferredBy)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ReferredBy)
		{
			super.removeChild((ReferredBy)child);
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
		ReferredByCollection result = new ReferredByCollection();
		result.add(GP);
		result.add(OTHER);
		return result;
	}
	public static ReferredBy[] getNegativeInstances()
	{
		ReferredBy[] instances = new ReferredBy[2];
		instances[0] = GP;
		instances[1] = OTHER;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "GP";
		negativeInstances[1] = "OTHER";
		return negativeInstances;
	}
	public static ReferredBy getNegativeInstance(String name)
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
	public static ReferredBy getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ReferredBy[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1291000;
	public static final ReferredBy GP = new ReferredBy(-1194, "GP", true, null, null, Color.Default);
	public static final ReferredBy OTHER = new ReferredBy(-2445, "Other", true, null, null, Color.Default);
}