// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.62 build 3121.18691)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.RefMan.forms.referralwizard;

import java.io.Serializable;

public final class AccessLogic extends BaseAccessLogic implements Serializable
{
	private static final long serialVersionUID = 1L;

	public boolean isAccessible()
	{
		if(!super.isAccessible())
			return false;

		// TODO: Add your conditions here.
		return true;
	}
	public boolean isReadOnly()
	{
		if(super.isReadOnly())
			return true;

		// TODO: Add your conditions here.
		return false;
	}
}
