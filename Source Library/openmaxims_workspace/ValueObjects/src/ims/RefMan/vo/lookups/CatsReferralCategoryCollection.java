// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.lookups;

import ims.framework.cn.data.TreeModel;
import ims.framework.cn.data.TreeNode;
import ims.vo.LookupInstanceCollection;
import ims.vo.LookupInstVo;

public class CatsReferralCategoryCollection extends LookupInstanceCollection implements ims.vo.ImsCloneable, TreeModel
{
	private static final long serialVersionUID = 1L;
	public void add(CatsReferralCategory value)
	{
		super.add(value);
	}
	public int indexOf(CatsReferralCategory instance)
	{
		return super.indexOf(instance);
	}
	public boolean contains(CatsReferralCategory instance)
	{
		return indexOf(instance) >= 0;
	}
	public CatsReferralCategory get(int index)
	{
		return (CatsReferralCategory)super.getIndex(index);
	}
	public void remove(CatsReferralCategory instance)
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
		CatsReferralCategoryCollection newCol = new CatsReferralCategoryCollection();
		CatsReferralCategory item;
		for (int i = 0; i < super.size(); i++)
		{
			item = this.get(i);
			newCol.add(new CatsReferralCategory(item.getID(), item.getText(), item.isActive(), item.getParent(), item.getImage(), item.getColor(), item.getOrder()));
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
					item.setParent((CatsReferralCategory)item.getParent().clone());
			}
		}
		return newCol;
	}
	public CatsReferralCategory getInstance(int instanceId)
	{
		return (CatsReferralCategory)super.getInstanceById(instanceId);
	}
	public TreeNode[] getRootNodes()
	{
		LookupInstVo[] roots = super.getRoots();
		TreeNode[] nodes = new TreeNode[roots.length];
		System.arraycopy(roots, 0, nodes, 0, roots.length);
		return nodes;
	}
	public CatsReferralCategory[] toArray()
	{
		CatsReferralCategory[] arr = new CatsReferralCategory[this.size()];
		super.toArray(arr);
		return arr;
	}
	public static CatsReferralCategoryCollection buildFromBeanCollection(java.util.Collection beans)
	{
		CatsReferralCategoryCollection coll = new CatsReferralCategoryCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while(iter.hasNext())
		{
			coll.add(CatsReferralCategory.buildLookup((ims.vo.LookupInstanceBean)iter.next()));
		}
		return coll;
	}
	public static CatsReferralCategoryCollection buildFromBeanCollection(ims.vo.LookupInstanceBean[] beans)
	{
		CatsReferralCategoryCollection coll = new CatsReferralCategoryCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(CatsReferralCategory.buildLookup(beans[x]));
		}
		return coll;
	}
}
