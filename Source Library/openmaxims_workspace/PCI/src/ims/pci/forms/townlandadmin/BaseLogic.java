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

package ims.pci.forms.townlandadmin;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.pci.domain.TownlandAdmin.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.pci.domain.TownlandAdmin domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void clearContextInformation()
	{
		engine.clearPatientContextInformation();
	}
	protected final void oncmbCountyValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctnTownland().cmbCounty().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ntpf.vo.lookups.County existingInstance = (ims.ntpf.vo.lookups.County)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbCountyLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ntpf.vo.lookups.County)
		{
			ims.ntpf.vo.lookups.County instance = (ims.ntpf.vo.lookups.County)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbCountyLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ntpf.vo.lookups.County existingInstance = (ims.ntpf.vo.lookups.County)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctnTownland().cmbCounty().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbCountyLookup()
	{
		this.form.ctnTownland().cmbCounty().clear();
		ims.ntpf.vo.lookups.CountyCollection lookupCollection = ims.ntpf.vo.lookups.LookupHelper.getCounty(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctnTownland().cmbCounty().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbCountyLookupValue(int id)
	{
		ims.ntpf.vo.lookups.County instance = ims.ntpf.vo.lookups.LookupHelper.getCountyInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctnTownland().cmbCounty().setValue(instance);
	}
	protected final void defaultcmbCountyLookupValue()
	{
		this.form.ctnTownland().cmbCounty().setValue((ims.ntpf.vo.lookups.County)domain.getLookupService().getDefaultInstance(ims.ntpf.vo.lookups.County.class, engine.getFormName().getID(), ims.ntpf.vo.lookups.County.TYPE_ID));
	}
	protected final void oncmbCountySearchValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbCountySearch().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ntpf.vo.lookups.County existingInstance = (ims.ntpf.vo.lookups.County)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbCountySearchLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.ntpf.vo.lookups.County)
		{
			ims.ntpf.vo.lookups.County instance = (ims.ntpf.vo.lookups.County)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbCountySearchLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.ntpf.vo.lookups.County existingInstance = (ims.ntpf.vo.lookups.County)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbCountySearch().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbCountySearchLookup()
	{
		this.form.cmbCountySearch().clear();
		ims.ntpf.vo.lookups.CountyCollection lookupCollection = ims.ntpf.vo.lookups.LookupHelper.getCounty(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbCountySearch().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbCountySearchLookupValue(int id)
	{
		ims.ntpf.vo.lookups.County instance = ims.ntpf.vo.lookups.LookupHelper.getCountyInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbCountySearch().setValue(instance);
	}
	protected final void defaultcmbCountySearchLookupValue()
	{
		this.form.cmbCountySearch().setValue((ims.ntpf.vo.lookups.County)domain.getLookupService().getDefaultInstance(ims.ntpf.vo.lookups.County.class, engine.getFormName().getID(), ims.ntpf.vo.lookups.County.TYPE_ID));
	}
	protected void clearScreen()
	{
		this.form.ctnTownland().chkActive().setValue(false);
		this.form.ctnTownland().cmbCounty().setValue(null);
		this.form.ctnTownland().txtTownland().setValue("");
	}
	protected void populateScreenFromData(ims.core.vo.TownlandVo value)
	{
		clearScreen();
		if(value == null)
			return;

		if(value.getIsActiveIsNotNull())
			this.form.ctnTownland().chkActive().setValue(value.getIsActive().booleanValue());
		this.form.ctnTownland().cmbCounty().setValue(value.getCountyIsNotNull() ? value.getCounty() : null);
		this.form.ctnTownland().txtTownland().setValue(value.getNameIsNotNull() ? value.getName(): null);
	}
	protected ims.core.vo.TownlandVo populateDataFromScreen(ims.core.vo.TownlandVo value)
	{
		if(value == null)
			value = new ims.core.vo.TownlandVo();

		value.setIsActive(new Boolean(this.form.ctnTownland().chkActive().getValue()));
		value.setCounty(this.form.ctnTownland().cmbCounty().getValue());
		value.setName(this.form.ctnTownland().txtTownland().getValue());

		return value;
	}
	protected ims.core.vo.TownlandVo populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.core.vo.TownlandVo());
	}
	public void initialize() throws ims.framework.exceptions.FormOpenException
	{
	}
	public boolean allowNew()
	{
		return form.getMode() == ims.framework.enumerations.FormMode.VIEW && !form.isReadOnly();
	}
	public boolean allowUpdate()
	{
		return form.getMode() == ims.framework.enumerations.FormMode.VIEW && !form.isReadOnly();
	}
	public String[] validateUIRules()
	{
		return null;
	}
	public void clear()
	{
	}
	public void search()
	{
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.pci.domain.TownlandAdmin domain;
}