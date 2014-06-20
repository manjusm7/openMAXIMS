// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class KPIExceededReason extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public KPIExceededReason()
	{
		super();
	}
	public KPIExceededReason(int id)
	{
		super(id, "", true);
	}
	public KPIExceededReason(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public KPIExceededReason(int id, String text, boolean active, KPIExceededReason parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public KPIExceededReason(int id, String text, boolean active, KPIExceededReason parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public KPIExceededReason(int id, String text, boolean active, KPIExceededReason parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static KPIExceededReason buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new KPIExceededReason(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (KPIExceededReason)super.getParentInstance();
	}
	public KPIExceededReason getParent()
	{
		return (KPIExceededReason)super.getParentInstance();
	}
	public void setParent(KPIExceededReason parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		KPIExceededReason[] typedChildren = new KPIExceededReason[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (KPIExceededReason)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof KPIExceededReason)
		{
			super.addChild((KPIExceededReason)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof KPIExceededReason)
		{
			super.removeChild((KPIExceededReason)child);
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
		KPIExceededReasonCollection result = new KPIExceededReasonCollection();
		return result;
	}
	public static KPIExceededReason[] getNegativeInstances()
	{
		return new KPIExceededReason[] {};
	}
	public static String[] getNegativeInstanceNames()
	{
		return new String[] {};
	}
	public static KPIExceededReason getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		// No negative instances found
		return null;
	}
	public static KPIExceededReason getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		// No negative instances found
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1341047;
}
