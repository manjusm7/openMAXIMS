// This code was generated by Daniel Laffan using IMS Development Environment (version 1.70 build 3401.14277)
// Copyright (C) 1995-2009 IMS MAXIMS plc. All rights reserved.

package ims.RefMan.forms.theatrelist;

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
