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

package ims.core.domain;

// Generated from form domain impl
public interface AllergenReactions extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* list Allergen Type Reactions
	*/
	public ims.core.vo.AllergenTypeReactionsCollection listAllergenTypeReactions(ims.core.vo.lookups.AllergenType allergenType);

	// Generated from form domain interface definition
	/**
	* save Allergen Type Reaction
	*/
	public ims.core.vo.AllergenTypeReactionsCollection saveAllergenTypeReaction(ims.core.vo.lookups.AllergenType allergenType, ims.core.vo.AllergenTypeReactionsCollection allergenTypeReactions) throws ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.ForeignKeyViolationException;
}