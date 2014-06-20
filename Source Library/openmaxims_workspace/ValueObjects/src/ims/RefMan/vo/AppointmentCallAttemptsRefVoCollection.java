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
 * Linked to RefMan.AppointmentCallAttempts business object (ID: 1096100010).
 */
public class AppointmentCallAttemptsRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<AppointmentCallAttemptsRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<AppointmentCallAttemptsRefVo> col = new ArrayList<AppointmentCallAttemptsRefVo>();
	public final String getBoClassName()
	{
		return "ims.RefMan.domain.objects.AppointmentCallAttempts";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(AppointmentCallAttemptsRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, AppointmentCallAttemptsRefVo value)
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
	public int indexOf(AppointmentCallAttemptsRefVo instance)
	{
		return col.indexOf(instance);
	}
	public AppointmentCallAttemptsRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, AppointmentCallAttemptsRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(AppointmentCallAttemptsRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(AppointmentCallAttemptsRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		AppointmentCallAttemptsRefVoCollection clone = new AppointmentCallAttemptsRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((AppointmentCallAttemptsRefVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		return clone;
	}
	public boolean isValidated()
	{
		return true;
	}
	public String[] validate()
	{
		return null;
	}
	public AppointmentCallAttemptsRefVo[] toArray()
	{
		AppointmentCallAttemptsRefVo[] arr = new AppointmentCallAttemptsRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public AppointmentCallAttemptsRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public AppointmentCallAttemptsRefVoCollection sort(SortOrder order)
	{
		return sort(new AppointmentCallAttemptsRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public AppointmentCallAttemptsRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<AppointmentCallAttemptsRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class AppointmentCallAttemptsRefVoComparator implements Comparator
	{
		private int direction = 1;
		public AppointmentCallAttemptsRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public AppointmentCallAttemptsRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			AppointmentCallAttemptsRefVo voObj1 = (AppointmentCallAttemptsRefVo)obj1;
			AppointmentCallAttemptsRefVo voObj2 = (AppointmentCallAttemptsRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
