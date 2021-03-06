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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.dtomove.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class SchedulingCategory extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public SchedulingCategory()
	{
		super();
	}
	public SchedulingCategory(int id)
	{
		super(id, "", true);
	}
	public SchedulingCategory(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public SchedulingCategory(int id, String text, boolean active, SchedulingCategory parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public SchedulingCategory(int id, String text, boolean active, SchedulingCategory parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public SchedulingCategory(int id, String text, boolean active, SchedulingCategory parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static SchedulingCategory buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new SchedulingCategory(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (SchedulingCategory)super.getParentInstance();
	}
	public SchedulingCategory getParent()
	{
		return (SchedulingCategory)super.getParentInstance();
	}
	public void setParent(SchedulingCategory parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		SchedulingCategory[] typedChildren = new SchedulingCategory[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (SchedulingCategory)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof SchedulingCategory)
		{
			super.addChild((SchedulingCategory)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof SchedulingCategory)
		{
			super.removeChild((SchedulingCategory)child);
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
		SchedulingCategoryCollection result = new SchedulingCategoryCollection();
		result.add(SINGLE_LIST);
		result.add(MULTIPLE_LIST);
		return result;
	}
	public static SchedulingCategory[] getNegativeInstances()
	{
		SchedulingCategory[] instances = new SchedulingCategory[2];
		instances[0] = SINGLE_LIST;
		instances[1] = MULTIPLE_LIST;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[2];
		negativeInstances[0] = "SINGLE_LIST";
		negativeInstances[1] = "MULTIPLE_LIST";
		return negativeInstances;
	}
	public static SchedulingCategory getNegativeInstance(String name)
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
	public static SchedulingCategory getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		SchedulingCategory[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 3432;
	public static final SchedulingCategory SINGLE_LIST = new SchedulingCategory(-1878, "Single List", true, null, null, Color.Default);
	public static final SchedulingCategory MULTIPLE_LIST = new SchedulingCategory(-1879, "Multiple List", true, null, null, Color.Default);
}
