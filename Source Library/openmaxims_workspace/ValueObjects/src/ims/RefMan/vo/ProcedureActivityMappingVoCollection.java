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
 * Linked to RefMan.ProcedureActivityMapping business object (ID: 1096100026).
 */
public class ProcedureActivityMappingVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<ProcedureActivityMappingVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<ProcedureActivityMappingVo> col = new ArrayList<ProcedureActivityMappingVo>();
	public String getBoClassName()
	{
		return "ims.RefMan.domain.objects.ProcedureActivityMapping";
	}
	public boolean add(ProcedureActivityMappingVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, ProcedureActivityMappingVo value)
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
	public int indexOf(ProcedureActivityMappingVo instance)
	{
		return col.indexOf(instance);
	}
	public ProcedureActivityMappingVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, ProcedureActivityMappingVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(ProcedureActivityMappingVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(ProcedureActivityMappingVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		ProcedureActivityMappingVoCollection clone = new ProcedureActivityMappingVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((ProcedureActivityMappingVo)this.col.get(x).clone());
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
	public ProcedureActivityMappingVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public ProcedureActivityMappingVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public ProcedureActivityMappingVoCollection sort(SortOrder order)
	{
		return sort(new ProcedureActivityMappingVoComparator(order));
	}
	public ProcedureActivityMappingVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new ProcedureActivityMappingVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public ProcedureActivityMappingVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.RefMan.vo.ProcedureActivityMappingRefVoCollection toRefVoCollection()
	{
		ims.RefMan.vo.ProcedureActivityMappingRefVoCollection result = new ims.RefMan.vo.ProcedureActivityMappingRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public ProcedureActivityMappingVo[] toArray()
	{
		ProcedureActivityMappingVo[] arr = new ProcedureActivityMappingVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<ProcedureActivityMappingVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class ProcedureActivityMappingVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public ProcedureActivityMappingVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public ProcedureActivityMappingVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public ProcedureActivityMappingVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			ProcedureActivityMappingVo voObj1 = (ProcedureActivityMappingVo)obj1;
			ProcedureActivityMappingVo voObj2 = (ProcedureActivityMappingVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.RefMan.vo.beans.ProcedureActivityMappingVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.RefMan.vo.beans.ProcedureActivityMappingVoBean[] getBeanCollectionArray()
	{
		ims.RefMan.vo.beans.ProcedureActivityMappingVoBean[] result = new ims.RefMan.vo.beans.ProcedureActivityMappingVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			ProcedureActivityMappingVo vo = ((ProcedureActivityMappingVo)col.get(i));
			result[i] = (ims.RefMan.vo.beans.ProcedureActivityMappingVoBean)vo.getBean();
		}
		return result;
	}
	public static ProcedureActivityMappingVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		ProcedureActivityMappingVoCollection coll = new ProcedureActivityMappingVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.RefMan.vo.beans.ProcedureActivityMappingVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static ProcedureActivityMappingVoCollection buildFromBeanCollection(ims.RefMan.vo.beans.ProcedureActivityMappingVoBean[] beans)
	{
		ProcedureActivityMappingVoCollection coll = new ProcedureActivityMappingVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
