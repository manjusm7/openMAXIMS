// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;


public class IFCATSExternalEventVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<IFCATSExternalEventVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<IFCATSExternalEventVo> col = new ArrayList<IFCATSExternalEventVo>();
	public String getBoClassName()
	{
		return null;
	}
	public boolean add(IFCATSExternalEventVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, IFCATSExternalEventVo value)
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
	public int indexOf(IFCATSExternalEventVo instance)
	{
		return col.indexOf(instance);
	}
	public IFCATSExternalEventVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, IFCATSExternalEventVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(IFCATSExternalEventVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(IFCATSExternalEventVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		IFCATSExternalEventVoCollection clone = new IFCATSExternalEventVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((IFCATSExternalEventVo)this.col.get(x).clone());
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
	public IFCATSExternalEventVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public IFCATSExternalEventVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public IFCATSExternalEventVoCollection sort(SortOrder order)
	{
		return sort(new IFCATSExternalEventVoComparator(order));
	}
	public IFCATSExternalEventVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new IFCATSExternalEventVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public IFCATSExternalEventVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public IFCATSExternalEventVo[] toArray()
	{
		IFCATSExternalEventVo[] arr = new IFCATSExternalEventVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<IFCATSExternalEventVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class IFCATSExternalEventVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public IFCATSExternalEventVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public IFCATSExternalEventVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public IFCATSExternalEventVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			IFCATSExternalEventVo voObj1 = (IFCATSExternalEventVo)obj1;
			IFCATSExternalEventVo voObj2 = (IFCATSExternalEventVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.RefMan.vo.beans.IFCATSExternalEventVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.RefMan.vo.beans.IFCATSExternalEventVoBean[] getBeanCollectionArray()
	{
		ims.RefMan.vo.beans.IFCATSExternalEventVoBean[] result = new ims.RefMan.vo.beans.IFCATSExternalEventVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			IFCATSExternalEventVo vo = ((IFCATSExternalEventVo)col.get(i));
			result[i] = (ims.RefMan.vo.beans.IFCATSExternalEventVoBean)vo.getBean();
		}
		return result;
	}
	public static IFCATSExternalEventVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		IFCATSExternalEventVoCollection coll = new IFCATSExternalEventVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.RefMan.vo.beans.IFCATSExternalEventVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static IFCATSExternalEventVoCollection buildFromBeanCollection(ims.RefMan.vo.beans.IFCATSExternalEventVoBean[] beans)
	{
		IFCATSExternalEventVoCollection coll = new IFCATSExternalEventVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
