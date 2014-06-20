// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class FollowupManagementType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public FollowupManagementType()
	{
		super();
	}
	public FollowupManagementType(int id)
	{
		super(id, "", true);
	}
	public FollowupManagementType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public FollowupManagementType(int id, String text, boolean active, FollowupManagementType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public FollowupManagementType(int id, String text, boolean active, FollowupManagementType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public FollowupManagementType(int id, String text, boolean active, FollowupManagementType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static FollowupManagementType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new FollowupManagementType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (FollowupManagementType)super.getParentInstance();
	}
	public FollowupManagementType getParent()
	{
		return (FollowupManagementType)super.getParentInstance();
	}
	public void setParent(FollowupManagementType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		FollowupManagementType[] typedChildren = new FollowupManagementType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (FollowupManagementType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof FollowupManagementType)
		{
			super.addChild((FollowupManagementType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof FollowupManagementType)
		{
			super.removeChild((FollowupManagementType)child);
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
		FollowupManagementTypeCollection result = new FollowupManagementTypeCollection();
		result.add(TLT);
		result.add(ANOTHER_APPOINTMENT);
		result.add(SPECIAL_INVESTIGATIONS);
		result.add(REFER_BACK_TO_CONSULTANT);
		return result;
	}
	public static FollowupManagementType[] getNegativeInstances()
	{
		FollowupManagementType[] instances = new FollowupManagementType[4];
		instances[0] = TLT;
		instances[1] = ANOTHER_APPOINTMENT;
		instances[2] = SPECIAL_INVESTIGATIONS;
		instances[3] = REFER_BACK_TO_CONSULTANT;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[4];
		negativeInstances[0] = "TLT";
		negativeInstances[1] = "ANOTHER_APPOINTMENT";
		negativeInstances[2] = "SPECIAL_INVESTIGATIONS";
		negativeInstances[3] = "REFER_BACK_TO_CONSULTANT";
		return negativeInstances;
	}
	public static FollowupManagementType getNegativeInstance(String name)
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
	public static FollowupManagementType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		FollowupManagementType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1341013;
	public static final FollowupManagementType TLT = new FollowupManagementType(-1567, "TLT", true, null, null, Color.Default);
	public static final FollowupManagementType ANOTHER_APPOINTMENT = new FollowupManagementType(-1568, "Another Appointment", true, null, null, Color.Default);
	public static final FollowupManagementType SPECIAL_INVESTIGATIONS = new FollowupManagementType(-1590, "Awaiting Results", true, null, null, Color.Default);
	public static final FollowupManagementType REFER_BACK_TO_CONSULTANT = new FollowupManagementType(-1873, "Refer Back to Consultant", true, null, null, Color.Default);
}
