// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.lookups;

import ims.framework.cn.data.TreeModel;
import ims.framework.cn.data.TreeNode;
import ims.vo.LookupInstanceCollection;
import ims.vo.LookupInstVo;

public class ReportsRequiredSubCategoryCollection extends LookupInstanceCollection implements ims.vo.ImsCloneable, TreeModel
{
	private static final long serialVersionUID = 1L;
	public void add(ReportsRequiredSubCategory value)
	{
		super.add(value);
	}
	public int indexOf(ReportsRequiredSubCategory instance)
	{
		return super.indexOf(instance);
	}
	public boolean contains(ReportsRequiredSubCategory instance)
	{
		return indexOf(instance) >= 0;
	}
	public ReportsRequiredSubCategory get(int index)
	{
		return (ReportsRequiredSubCategory)super.getIndex(index);
	}
	public void remove(ReportsRequiredSubCategory instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public Object clone()
	{
		ReportsRequiredSubCategoryCollection newCol = new ReportsRequiredSubCategoryCollection();
		ReportsRequiredSubCategory item;
		for (int i = 0; i < super.size(); i++)
		{
			item = this.get(i);
			newCol.add(new ReportsRequiredSubCategory(item.getID(), item.getText(), item.isActive(), item.getParent(), item.getImage(), item.getColor(), item.getOrder()));
		}
		for (int i = 0; i < newCol.size(); i++)
		{
			item = newCol.get(i);
			if (item.getParent() != null)
			{
				int parentIndex = this.indexOf(item.getParent());
				if(parentIndex >= 0)
					item.setParent(newCol.get(parentIndex));
				else
					item.setParent((ReportsRequiredSubCategory)item.getParent().clone());
			}
		}
		return newCol;
	}
	public ReportsRequiredSubCategory getInstance(int instanceId)
	{
		return (ReportsRequiredSubCategory)super.getInstanceById(instanceId);
	}
	public TreeNode[] getRootNodes()
	{
		LookupInstVo[] roots = super.getRoots();
		TreeNode[] nodes = new TreeNode[roots.length];
		System.arraycopy(roots, 0, nodes, 0, roots.length);
		return nodes;
	}
	public ReportsRequiredSubCategory[] toArray()
	{
		ReportsRequiredSubCategory[] arr = new ReportsRequiredSubCategory[this.size()];
		super.toArray(arr);
		return arr;
	}
	public static ReportsRequiredSubCategoryCollection buildFromBeanCollection(java.util.Collection beans)
	{
		ReportsRequiredSubCategoryCollection coll = new ReportsRequiredSubCategoryCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while(iter.hasNext())
		{
			coll.add(ReportsRequiredSubCategory.buildLookup((ims.vo.LookupInstanceBean)iter.next()));
		}
		return coll;
	}
	public static ReportsRequiredSubCategoryCollection buildFromBeanCollection(ims.vo.LookupInstanceBean[] beans)
	{
		ReportsRequiredSubCategoryCollection coll = new ReportsRequiredSubCategoryCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(ReportsRequiredSubCategory.buildLookup(beans[x]));
		}
		return coll;
	}
}
