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
 * Linked to core.configuration.ElectiveListConfiguration business object (ID: 1028100072).
 */
public class ElectiveListConfigurationLiteVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<ElectiveListConfigurationLiteVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<ElectiveListConfigurationLiteVo> col = new ArrayList<ElectiveListConfigurationLiteVo>();
	public String getBoClassName()
	{
		return "ims.core.configuration.domain.objects.ElectiveListConfiguration";
	}
	public boolean add(ElectiveListConfigurationLiteVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, ElectiveListConfigurationLiteVo value)
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
	public int indexOf(ElectiveListConfigurationLiteVo instance)
	{
		return col.indexOf(instance);
	}
	public ElectiveListConfigurationLiteVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, ElectiveListConfigurationLiteVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(ElectiveListConfigurationLiteVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(ElectiveListConfigurationLiteVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		ElectiveListConfigurationLiteVoCollection clone = new ElectiveListConfigurationLiteVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((ElectiveListConfigurationLiteVo)this.col.get(x).clone());
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
	public ElectiveListConfigurationLiteVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public ElectiveListConfigurationLiteVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public ElectiveListConfigurationLiteVoCollection sort(SortOrder order)
	{
		return sort(new ElectiveListConfigurationLiteVoComparator(order));
	}
	public ElectiveListConfigurationLiteVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new ElectiveListConfigurationLiteVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public ElectiveListConfigurationLiteVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.configuration.vo.ElectiveListConfigurationRefVoCollection toRefVoCollection()
	{
		ims.core.configuration.vo.ElectiveListConfigurationRefVoCollection result = new ims.core.configuration.vo.ElectiveListConfigurationRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public ElectiveListConfigurationLiteVo[] toArray()
	{
		ElectiveListConfigurationLiteVo[] arr = new ElectiveListConfigurationLiteVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<ElectiveListConfigurationLiteVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class ElectiveListConfigurationLiteVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public ElectiveListConfigurationLiteVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public ElectiveListConfigurationLiteVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public ElectiveListConfigurationLiteVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			ElectiveListConfigurationLiteVo voObj1 = (ElectiveListConfigurationLiteVo)obj1;
			ElectiveListConfigurationLiteVo voObj2 = (ElectiveListConfigurationLiteVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.RefMan.vo.beans.ElectiveListConfigurationLiteVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.RefMan.vo.beans.ElectiveListConfigurationLiteVoBean[] getBeanCollectionArray()
	{
		ims.RefMan.vo.beans.ElectiveListConfigurationLiteVoBean[] result = new ims.RefMan.vo.beans.ElectiveListConfigurationLiteVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			ElectiveListConfigurationLiteVo vo = ((ElectiveListConfigurationLiteVo)col.get(i));
			result[i] = (ims.RefMan.vo.beans.ElectiveListConfigurationLiteVoBean)vo.getBean();
		}
		return result;
	}
	public static ElectiveListConfigurationLiteVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		ElectiveListConfigurationLiteVoCollection coll = new ElectiveListConfigurationLiteVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.RefMan.vo.beans.ElectiveListConfigurationLiteVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static ElectiveListConfigurationLiteVoCollection buildFromBeanCollection(ims.RefMan.vo.beans.ElectiveListConfigurationLiteVoBean[] beans)
	{
		ElectiveListConfigurationLiteVoCollection coll = new ElectiveListConfigurationLiteVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
