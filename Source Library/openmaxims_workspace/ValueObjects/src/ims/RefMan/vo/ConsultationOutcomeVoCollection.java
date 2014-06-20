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
 * Linked to RefMan.ConsultationOutcome business object (ID: 1096100028).
 */
public class ConsultationOutcomeVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<ConsultationOutcomeVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<ConsultationOutcomeVo> col = new ArrayList<ConsultationOutcomeVo>();
	public String getBoClassName()
	{
		return "ims.RefMan.domain.objects.ConsultationOutcome";
	}
	public boolean add(ConsultationOutcomeVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, ConsultationOutcomeVo value)
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
	public int indexOf(ConsultationOutcomeVo instance)
	{
		return col.indexOf(instance);
	}
	public ConsultationOutcomeVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, ConsultationOutcomeVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(ConsultationOutcomeVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(ConsultationOutcomeVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		ConsultationOutcomeVoCollection clone = new ConsultationOutcomeVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((ConsultationOutcomeVo)this.col.get(x).clone());
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
	public ConsultationOutcomeVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public ConsultationOutcomeVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public ConsultationOutcomeVoCollection sort(SortOrder order)
	{
		return sort(new ConsultationOutcomeVoComparator(order));
	}
	public ConsultationOutcomeVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new ConsultationOutcomeVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public ConsultationOutcomeVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.RefMan.vo.ConsultationOutcomeRefVoCollection toRefVoCollection()
	{
		ims.RefMan.vo.ConsultationOutcomeRefVoCollection result = new ims.RefMan.vo.ConsultationOutcomeRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public ConsultationOutcomeVo[] toArray()
	{
		ConsultationOutcomeVo[] arr = new ConsultationOutcomeVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<ConsultationOutcomeVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class ConsultationOutcomeVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public ConsultationOutcomeVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public ConsultationOutcomeVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public ConsultationOutcomeVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			ConsultationOutcomeVo voObj1 = (ConsultationOutcomeVo)obj1;
			ConsultationOutcomeVo voObj2 = (ConsultationOutcomeVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.RefMan.vo.beans.ConsultationOutcomeVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.RefMan.vo.beans.ConsultationOutcomeVoBean[] getBeanCollectionArray()
	{
		ims.RefMan.vo.beans.ConsultationOutcomeVoBean[] result = new ims.RefMan.vo.beans.ConsultationOutcomeVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			ConsultationOutcomeVo vo = ((ConsultationOutcomeVo)col.get(i));
			result[i] = (ims.RefMan.vo.beans.ConsultationOutcomeVoBean)vo.getBean();
		}
		return result;
	}
	public static ConsultationOutcomeVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		ConsultationOutcomeVoCollection coll = new ConsultationOutcomeVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.RefMan.vo.beans.ConsultationOutcomeVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static ConsultationOutcomeVoCollection buildFromBeanCollection(ims.RefMan.vo.beans.ConsultationOutcomeVoBean[] beans)
	{
		ConsultationOutcomeVoCollection coll = new ConsultationOutcomeVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
