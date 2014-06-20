// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to RefMan.ReferralService business object (ID: 1096100011).
 */
public class ReferralServiceVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<ReferralServiceVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<ReferralServiceVo> col = new ArrayList<ReferralServiceVo>();
	public String getBoClassName()
	{
		return "ims.RefMan.domain.objects.ReferralService";
	}
	public boolean add(ReferralServiceVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, ReferralServiceVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			this.col.add(index, value);
			return true;
		}
		return false;
	}
	public void clear()
	{
		this.col.clear();
	}
	public void remove(int index)
	{
		this.col.remove(index);
	}
	public int size()
	{
		return this.col.size();
	}
	public int indexOf(ReferralServiceVo instance)
	{
		return col.indexOf(instance);
	}
	public ReferralServiceVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, ReferralServiceVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(ReferralServiceVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(ReferralServiceVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		ReferralServiceVoCollection clone = new ReferralServiceVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((ReferralServiceVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		
		return clone;
	}
	public boolean isValidated()
	{
		for(int x = 0; x < col.size(); x++)
			if(!this.col.get(x).isValidated())
				return false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(col.size() == 0)
			return null;
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		for(int x = 0; x < col.size(); x++)
		{
			String[] listOfOtherErrors = this.col.get(x).validate();
			if(listOfOtherErrors != null)
			{
				for(int y = 0; y < listOfOtherErrors.length; y++)
				{
					listOfErrors.add(listOfOtherErrors[y]);
				}
			}
		}
		
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
			return null;
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		return result;
	}
	public ReferralServiceVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public ReferralServiceVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public ReferralServiceVoCollection sort(SortOrder order)
	{
		return sort(new ReferralServiceVoComparator(order));
	}
	public ReferralServiceVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new ReferralServiceVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public ReferralServiceVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.RefMan.vo.ReferralServiceRefVoCollection toRefVoCollection()
	{
		ims.RefMan.vo.ReferralServiceRefVoCollection result = new ims.RefMan.vo.ReferralServiceRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public ReferralServiceVo[] toArray()
	{
		ReferralServiceVo[] arr = new ReferralServiceVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<ReferralServiceVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class ReferralServiceVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public ReferralServiceVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public ReferralServiceVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public ReferralServiceVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			ReferralServiceVo voObj1 = (ReferralServiceVo)obj1;
			ReferralServiceVo voObj2 = (ReferralServiceVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.RefMan.vo.beans.ReferralServiceVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.RefMan.vo.beans.ReferralServiceVoBean[] getBeanCollectionArray()
	{
		ims.RefMan.vo.beans.ReferralServiceVoBean[] result = new ims.RefMan.vo.beans.ReferralServiceVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			ReferralServiceVo vo = ((ReferralServiceVo)col.get(i));
			result[i] = (ims.RefMan.vo.beans.ReferralServiceVoBean)vo.getBean();
		}
		return result;
	}
	public static ReferralServiceVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		ReferralServiceVoCollection coll = new ReferralServiceVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.RefMan.vo.beans.ReferralServiceVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static ReferralServiceVoCollection buildFromBeanCollection(ims.RefMan.vo.beans.ReferralServiceVoBean[] beans)
	{
		ReferralServiceVoCollection coll = new ReferralServiceVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
