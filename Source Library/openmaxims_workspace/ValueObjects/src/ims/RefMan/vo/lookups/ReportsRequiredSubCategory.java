// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class ReportsRequiredSubCategory extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ReportsRequiredSubCategory()
	{
		super();
	}
	public ReportsRequiredSubCategory(int id)
	{
		super(id, "", true);
	}
	public ReportsRequiredSubCategory(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ReportsRequiredSubCategory(int id, String text, boolean active, ReportsRequiredSubCategory parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ReportsRequiredSubCategory(int id, String text, boolean active, ReportsRequiredSubCategory parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ReportsRequiredSubCategory(int id, String text, boolean active, ReportsRequiredSubCategory parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ReportsRequiredSubCategory buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ReportsRequiredSubCategory(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ReportsRequiredSubCategory)super.getParentInstance();
	}
	public ReportsRequiredSubCategory getParent()
	{
		return (ReportsRequiredSubCategory)super.getParentInstance();
	}
	public void setParent(ReportsRequiredSubCategory parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ReportsRequiredSubCategory[] typedChildren = new ReportsRequiredSubCategory[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ReportsRequiredSubCategory)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ReportsRequiredSubCategory)
		{
			super.addChild((ReportsRequiredSubCategory)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ReportsRequiredSubCategory)
		{
			super.removeChild((ReportsRequiredSubCategory)child);
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
		ReportsRequiredSubCategoryCollection result = new ReportsRequiredSubCategoryCollection();
		result.add(CATS_REPORT_REQUIRED);
		result.add(FOLLOW_UP_NOTES_REP_REQUIRED);
		result.add(SUPPLEMENTARY_NOTES_REPORT_REQUIRED);
		result.add(SECONDARY_CARE_REPORT);
		return result;
	}
	public static ReportsRequiredSubCategory[] getNegativeInstances()
	{
		ReportsRequiredSubCategory[] instances = new ReportsRequiredSubCategory[4];
		instances[0] = CATS_REPORT_REQUIRED;
		instances[1] = FOLLOW_UP_NOTES_REP_REQUIRED;
		instances[2] = SUPPLEMENTARY_NOTES_REPORT_REQUIRED;
		instances[3] = SECONDARY_CARE_REPORT;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[4];
		negativeInstances[0] = "CATS_REPORT_REQUIRED";
		negativeInstances[1] = "FOLLOW_UP_NOTES_REP_REQUIRED";
		negativeInstances[2] = "SUPPLEMENTARY_NOTES_REPORT_REQUIRED";
		negativeInstances[3] = "SECONDARY_CARE_REPORT";
		return negativeInstances;
	}
	public static ReportsRequiredSubCategory getNegativeInstance(String name)
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
	public static ReportsRequiredSubCategory getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		ReportsRequiredSubCategory[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1341021;
	public static final ReportsRequiredSubCategory CATS_REPORT_REQUIRED = new ReportsRequiredSubCategory(-1843, "CATS Report required ", true, null, null, Color.Default);
	public static final ReportsRequiredSubCategory FOLLOW_UP_NOTES_REP_REQUIRED = new ReportsRequiredSubCategory(-1844, "Follow-up Notes Rep required", true, null, null, Color.Default);
	public static final ReportsRequiredSubCategory SUPPLEMENTARY_NOTES_REPORT_REQUIRED = new ReportsRequiredSubCategory(-1845, "Supplementary Notes report required", true, null, null, Color.Default);
	public static final ReportsRequiredSubCategory SECONDARY_CARE_REPORT = new ReportsRequiredSubCategory(-1846, "Secondary Care report", true, null, null, Color.Default);
}
