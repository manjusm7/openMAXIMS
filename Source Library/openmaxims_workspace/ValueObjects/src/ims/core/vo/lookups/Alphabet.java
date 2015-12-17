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

package ims.core.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class Alphabet extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public Alphabet()
	{
		super();
	}
	public Alphabet(int id)
	{
		super(id, "", true);
	}
	public Alphabet(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public Alphabet(int id, String text, boolean active, Alphabet parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public Alphabet(int id, String text, boolean active, Alphabet parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public Alphabet(int id, String text, boolean active, Alphabet parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static Alphabet buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new Alphabet(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (Alphabet)super.getParentInstance();
	}
	public Alphabet getParent()
	{
		return (Alphabet)super.getParentInstance();
	}
	public void setParent(Alphabet parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		Alphabet[] typedChildren = new Alphabet[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (Alphabet)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof Alphabet)
		{
			super.addChild((Alphabet)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof Alphabet)
		{
			super.removeChild((Alphabet)child);
		}
		return super.getChildInstances().size();
	}
	public Image getExpandedImage()
	{
		return super.getImage();
	}
	public Image getCollapsedImage()
	{
		return super.getImage();
	}
	public static ims.framework.IItemCollection getNegativeInstancesAsIItemCollection()
	{
		AlphabetCollection result = new AlphabetCollection();
		result.add(A);
		result.add(B);
		result.add(C);
		result.add(D);
		result.add(E);
		result.add(F);
		result.add(G);
		result.add(H);
		result.add(I);
		result.add(J);
		result.add(K);
		result.add(L);
		result.add(M);
		result.add(N);
		result.add(O);
		result.add(P);
		result.add(Q);
		result.add(R);
		result.add(S);
		result.add(T);
		result.add(U);
		result.add(V);
		result.add(W);
		result.add(X);
		result.add(Y);
		result.add(Z);
		return result;
	}
	public static Alphabet[] getNegativeInstances()
	{
		Alphabet[] instances = new Alphabet[26];
		instances[0] = A;
		instances[1] = B;
		instances[2] = C;
		instances[3] = D;
		instances[4] = E;
		instances[5] = F;
		instances[6] = G;
		instances[7] = H;
		instances[8] = I;
		instances[9] = J;
		instances[10] = K;
		instances[11] = L;
		instances[12] = M;
		instances[13] = N;
		instances[14] = O;
		instances[15] = P;
		instances[16] = Q;
		instances[17] = R;
		instances[18] = S;
		instances[19] = T;
		instances[20] = U;
		instances[21] = V;
		instances[22] = W;
		instances[23] = X;
		instances[24] = Y;
		instances[25] = Z;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[26];
		negativeInstances[0] = "A";
		negativeInstances[1] = "B";
		negativeInstances[2] = "C";
		negativeInstances[3] = "D";
		negativeInstances[4] = "E";
		negativeInstances[5] = "F";
		negativeInstances[6] = "G";
		negativeInstances[7] = "H";
		negativeInstances[8] = "I";
		negativeInstances[9] = "J";
		negativeInstances[10] = "K";
		negativeInstances[11] = "L";
		negativeInstances[12] = "M";
		negativeInstances[13] = "N";
		negativeInstances[14] = "O";
		negativeInstances[15] = "P";
		negativeInstances[16] = "Q";
		negativeInstances[17] = "R";
		negativeInstances[18] = "S";
		negativeInstances[19] = "T";
		negativeInstances[20] = "U";
		negativeInstances[21] = "V";
		negativeInstances[22] = "W";
		negativeInstances[23] = "X";
		negativeInstances[24] = "Y";
		negativeInstances[25] = "Z";
		return negativeInstances;
	}
	public static Alphabet getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		String[] negativeInstances = getNegativeInstanceNames();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].equals(name))
				return getNegativeInstances()[i];
		}
		return null;
	}
	public static Alphabet getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		Alphabet[] negativeInstances = getNegativeInstances();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].getID() == id)
				return negativeInstances[i];
		}
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1021236;
	public static final Alphabet A = new Alphabet(-1639, "A", true, null, null, Color.Default);
	public static final Alphabet B = new Alphabet(-1640, "B", true, null, null, Color.Default);
	public static final Alphabet C = new Alphabet(-1641, "C", true, null, null, Color.Default);
	public static final Alphabet D = new Alphabet(-1642, "D", true, null, null, Color.Default);
	public static final Alphabet E = new Alphabet(-1643, "E", true, null, null, Color.Default);
	public static final Alphabet F = new Alphabet(-1644, "F", true, null, null, Color.Default);
	public static final Alphabet G = new Alphabet(-1645, "G", true, null, null, Color.Default);
	public static final Alphabet H = new Alphabet(-1646, "H", true, null, null, Color.Default);
	public static final Alphabet I = new Alphabet(-1647, "I", true, null, null, Color.Default);
	public static final Alphabet J = new Alphabet(-1648, "J", true, null, null, Color.Default);
	public static final Alphabet K = new Alphabet(-1649, "K", true, null, null, Color.Default);
	public static final Alphabet L = new Alphabet(-1650, "L", true, null, null, Color.Default);
	public static final Alphabet M = new Alphabet(-1651, "M", true, null, null, Color.Default);
	public static final Alphabet N = new Alphabet(-1652, "N", true, null, null, Color.Default);
	public static final Alphabet O = new Alphabet(-1653, "O", true, null, null, Color.Default);
	public static final Alphabet P = new Alphabet(-1654, "P", true, null, null, Color.Default);
	public static final Alphabet Q = new Alphabet(-1655, "Q", true, null, null, Color.Default);
	public static final Alphabet R = new Alphabet(-1656, "R", true, null, null, Color.Default);
	public static final Alphabet S = new Alphabet(-1657, "S", true, null, null, Color.Default);
	public static final Alphabet T = new Alphabet(-1658, "T", true, null, null, Color.Default);
	public static final Alphabet U = new Alphabet(-1659, "U", true, null, null, Color.Default);
	public static final Alphabet V = new Alphabet(-1660, "V", true, null, null, Color.Default);
	public static final Alphabet W = new Alphabet(-1661, "W", true, null, null, Color.Default);
	public static final Alphabet X = new Alphabet(-1662, "X", true, null, null, Color.Default);
	public static final Alphabet Y = new Alphabet(-1663, "Y", true, null, null, Color.Default);
	public static final Alphabet Z = new Alphabet(-1664, "Z", true, null, null, Color.Default);
}