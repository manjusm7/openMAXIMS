//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.therapies.forms.homevisitaccess;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.therapies.domain.HomeVisitAccess.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.therapies.domain.HomeVisitAccess domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbAccomodationypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbAccomodationype().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.AccommodationType existingInstance = (ims.spinalinjuries.vo.lookups.AccommodationType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbAccomodationypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.AccommodationType)
		{
			ims.spinalinjuries.vo.lookups.AccommodationType instance = (ims.spinalinjuries.vo.lookups.AccommodationType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbAccomodationypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.AccommodationType existingInstance = (ims.spinalinjuries.vo.lookups.AccommodationType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbAccomodationype().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbAccomodationypeLookup()
	{
		this.form.cmbAccomodationype().clear();
		ims.spinalinjuries.vo.lookups.AccommodationTypeCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getAccommodationType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbAccomodationype().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbAccomodationypeLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.AccommodationType instance = ims.spinalinjuries.vo.lookups.LookupHelper.getAccommodationTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbAccomodationype().setValue(instance);
	}
	protected final void defaultcmbAccomodationypeLookupValue()
	{
		this.form.cmbAccomodationype().setValue((ims.spinalinjuries.vo.lookups.AccommodationType)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.AccommodationType.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.AccommodationType.TYPE_ID));
	}
	protected final void oncmbOwnershipStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbOwnershipStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.OwnershipStatus existingInstance = (ims.spinalinjuries.vo.lookups.OwnershipStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbOwnershipStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.spinalinjuries.vo.lookups.OwnershipStatus)
		{
			ims.spinalinjuries.vo.lookups.OwnershipStatus instance = (ims.spinalinjuries.vo.lookups.OwnershipStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbOwnershipStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.spinalinjuries.vo.lookups.OwnershipStatus existingInstance = (ims.spinalinjuries.vo.lookups.OwnershipStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbOwnershipStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbOwnershipStatusLookup()
	{
		this.form.cmbOwnershipStatus().clear();
		ims.spinalinjuries.vo.lookups.OwnershipStatusCollection lookupCollection = ims.spinalinjuries.vo.lookups.LookupHelper.getOwnershipStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbOwnershipStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbOwnershipStatusLookupValue(int id)
	{
		ims.spinalinjuries.vo.lookups.OwnershipStatus instance = ims.spinalinjuries.vo.lookups.LookupHelper.getOwnershipStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbOwnershipStatus().setValue(instance);
	}
	protected final void defaultcmbOwnershipStatusLookupValue()
	{
		this.form.cmbOwnershipStatus().setValue((ims.spinalinjuries.vo.lookups.OwnershipStatus)domain.getLookupService().getDefaultInstance(ims.spinalinjuries.vo.lookups.OwnershipStatus.class, engine.getFormName().getID(), ims.spinalinjuries.vo.lookups.OwnershipStatus.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.therapies.domain.HomeVisitAccess domain;
}
