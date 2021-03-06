//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.scheduling.forms.generatesessions;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.scheduling.domain.GenerateSessions.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.scheduling.domain.GenerateSessions domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected void clearScreen()
	{
		this.form.dteEffectiveFrom().setValue(null);
		this.form.dteEffectiveTo().setValue(null);
		this.form.dtelastGen().setValue(null);
		this.form.txtDescription().setValue("");
	}
	protected void populateScreenFromData(ims.scheduling.vo.ProfileShortVo value)
	{
		clearScreen();
		if(value == null)
			return;

		this.form.dteEffectiveFrom().setValue(value.getEffFrmIsNotNull() ? value.getEffFrm() : null);
		this.form.dteEffectiveTo().setValue(value.getEffToIsNotNull() ? value.getEffTo() : null);
		this.form.dtelastGen().setValue(value.getLastGenDateIsNotNull() ? value.getLastGenDate() : null);
		this.form.txtDescription().setValue(value.getDescriptionIsNotNull() ? value.getDescription(): null);
	}
	protected ims.scheduling.vo.ProfileShortVo populateDataFromScreen(ims.scheduling.vo.ProfileShortVo value)
	{
		if(value == null)
			value = new ims.scheduling.vo.ProfileShortVo();

		value.setEffFrm(this.form.dteEffectiveFrom().getValue());
		value.setEffTo(this.form.dteEffectiveTo().getValue());
		value.setLastGenDate(this.form.dtelastGen().getValue());
		value.setDescription(this.form.txtDescription().getValue());

		return value;
	}
	protected ims.scheduling.vo.ProfileShortVo populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.scheduling.vo.ProfileShortVo());
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.scheduling.domain.GenerateSessions domain;
}
