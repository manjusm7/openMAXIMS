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
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5007.25751)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated: 16/04/2014, 12:34
 *
 */
package ims.core.configuration.domain.objects;

/**
 * 
 * @author Daniel Laffan
 * Generated.
 */


public class DrawingImage extends ims.domain.DomainObject implements ims.domain.SystemInformationRetainer, java.io.Serializable {
	public static final int CLASSID = 1021100008;
	private static final long serialVersionUID = 1021100008L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	/** Category */
	private ims.domain.lookups.LookupInstance category;
	/** Type */
	private ims.domain.lookups.LookupInstance type;
	/** Desription of Image Use */
	private String imagename;
	/** Actual Image to be Used */
	private ims.core.configuration.domain.objects.AppImage image;
	/** Root Image Configuration */
	private ims.core.configuration.domain.objects.DrawingGroup rootGroup;
	/** Version Number */
	private Integer versionNumber;
	/** ImageStatus */
	private ims.domain.lookups.LookupInstance imageStatus;
	/** Question to be recorded against the Graphic
	  * Collection of ims.assessment.configuration.domain.objects.ImageFindingQuestion.
	  */
	private java.util.Set questions;
	/** AssocFindings
	  * Collection of ims.assessment.configuration.domain.objects.ImageFinding.
	  */
	private java.util.Set assocFindings;
	/** SystemInformation */
	private ims.domain.SystemInformation systemInformation = new ims.domain.SystemInformation();
    public DrawingImage (Integer id, int ver)
    {
    	super(id, ver);
    }
    public DrawingImage ()
    {
    	super();
    }
    public DrawingImage (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.core.configuration.domain.objects.DrawingImage.class;
	}


	public ims.domain.lookups.LookupInstance getCategory() {
		return category;
	}
	public void setCategory(ims.domain.lookups.LookupInstance category) {
		this.category = category;
	}

	public ims.domain.lookups.LookupInstance getType() {
		return type;
	}
	public void setType(ims.domain.lookups.LookupInstance type) {
		this.type = type;
	}

	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		if ( null != imagename && imagename.length() > 255 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for imagename. Tried to set value: "+
				imagename);
		}
		this.imagename = imagename;
	}

	public ims.core.configuration.domain.objects.AppImage getImage() {
		return image;
	}
	public void setImage(ims.core.configuration.domain.objects.AppImage image) {
		this.image = image;
	}

	public ims.core.configuration.domain.objects.DrawingGroup getRootGroup() {
		return rootGroup;
	}
	public void setRootGroup(ims.core.configuration.domain.objects.DrawingGroup rootGroup) {
		this.rootGroup = rootGroup;
	}

	public Integer getVersionNumber() {
		return versionNumber;
	}
	public void setVersionNumber(Integer versionNumber) {
		this.versionNumber = versionNumber;
	}

	public ims.domain.lookups.LookupInstance getImageStatus() {
		return imageStatus;
	}
	public void setImageStatus(ims.domain.lookups.LookupInstance imageStatus) {
		this.imageStatus = imageStatus;
	}

	public java.util.Set getQuestions() {
		if ( null == questions ) {
			questions = new java.util.HashSet();
		}
		return questions;
	}
	public void setQuestions(java.util.Set paramValue) {
		this.questions = paramValue;
	}

	public java.util.Set getAssocFindings() {
		if ( null == assocFindings ) {
			assocFindings = new java.util.HashSet();
		}
		return assocFindings;
	}
	public void setAssocFindings(java.util.Set paramValue) {
		this.assocFindings = paramValue;
	}

	public ims.domain.SystemInformation getSystemInformation() {
		if (systemInformation == null) systemInformation = new ims.domain.SystemInformation();
		return systemInformation;
	}


	/**
	 * isConfigurationObject
	 * Taken from the Usage property of the business object, this method will return
	 * a boolean indicating whether this is a configuration object or not
	 * Configuration = true, Instantiation = false
	 */
	public static boolean isConfigurationObject()
	{
		if ( "Configuration".equals("Configuration") )
			return true;
		else
			return false;
	}





	public int getClassId() {
		return CLASSID;
	}

	public String getClassVersion()
	{
		return CLASSVERSION;
	}

	public String toAuditString()
	{
		StringBuffer auditStr = new StringBuffer();
		
		auditStr.append("\r\n*category* :");
		if (category != null)
			auditStr.append(category.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*type* :");
		if (type != null)
			auditStr.append(type.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*imagename* :");
		auditStr.append(imagename);
	    auditStr.append("; ");
		auditStr.append("\r\n*image* :");
		if (image != null)
		{
			auditStr.append(toShortClassName(image));
				
		    auditStr.append(image.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*rootGroup* :");
		if (rootGroup != null)
		{
			auditStr.append(toShortClassName(rootGroup));
				
		    auditStr.append(rootGroup.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*versionNumber* :");
		auditStr.append(versionNumber);
	    auditStr.append("; ");
		auditStr.append("\r\n*imageStatus* :");
		if (imageStatus != null)
			auditStr.append(imageStatus.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*questions* :");
		if (questions != null)
		{
			java.util.Iterator it8 = questions.iterator();
			int i8=0;
			while (it8.hasNext())
			{
				if (i8 > 0)
					auditStr.append(",");
				ims.assessment.configuration.domain.objects.ImageFindingQuestion obj = (ims.assessment.configuration.domain.objects.ImageFindingQuestion)it8.next();
		if (obj != null)
		{
		   if (i8 == 0)
		   {
			auditStr.append(toShortClassName(obj));
			auditStr.append("[");
		   }
		
		   auditStr.append(obj.getId());
		}
			i8++;
		}
		if (i8 > 0)
			auditStr.append("] " + i8);
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*assocFindings* :");
		if (assocFindings != null)
		{
			java.util.Iterator it9 = assocFindings.iterator();
			int i9=0;
			while (it9.hasNext())
			{
				if (i9 > 0)
					auditStr.append(",");
				ims.assessment.configuration.domain.objects.ImageFinding obj = (ims.assessment.configuration.domain.objects.ImageFinding)it9.next();
		if (obj != null)
		{
		   if (i9 == 0)
		   {
			auditStr.append(toShortClassName(obj));
			auditStr.append("[");
		   }
		
		   auditStr.append(obj.getId());
		}
			i9++;
		}
		if (i9 > 0)
			auditStr.append("] " + i9);
		}
	    auditStr.append("; ");
		return auditStr.toString();
	}
	
	public String toXMLString()
	{
		return toXMLString(new java.util.HashMap());
	}
	
	public String toXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<class type=\"" + this.getClass().getName() + "\" ");		
		sb.append(" id=\"" + this.getId() + "\""); 
		sb.append(" source=\"" + ims.configuration.EnvironmentConfig.getImportExportSourceName() + "\" ");
		sb.append(" classVersion=\"" + this.getClassVersion() + "\" ");
		sb.append(" component=\"" + this.getIsComponentClass() + "\" >");
		
		if (domMap.get(this) == null)
		{
			domMap.put(this, this);
			sb.append(this.fieldsToXMLString(domMap));
		}
		sb.append("</class>");
		
		String keyClassName = "DrawingImage";
		String externalSource = ims.configuration.EnvironmentConfig.getImportExportSourceName();
		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + this.getId());
		if (impObj == null)
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(this.getId());
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(this);
			impObj.setLocalId(this.getId()); 
    		impObj.setClassName(keyClassName); 
			domMap.put(keyClassName + "_" + externalSource + "_" + this.getId(), impObj);
		}
		
		return sb.toString();
	}

	public String fieldsToXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		if (this.getCategory() != null)
		{
			sb.append("<category>");
			sb.append(this.getCategory().toXMLString()); 
			sb.append("</category>");		
		}
		if (this.getType() != null)
		{
			sb.append("<type>");
			sb.append(this.getType().toXMLString()); 
			sb.append("</type>");		
		}
		if (this.getImagename() != null)
		{
			sb.append("<imagename>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getImagename().toString()));
			sb.append("</imagename>");		
		}
		if (this.getImage() != null)
		{
			sb.append("<image>");
			sb.append(this.getImage().toXMLString(domMap)); 	
			sb.append("</image>");		
		}
		if (this.getRootGroup() != null)
		{
			sb.append("<rootGroup>");
			sb.append(this.getRootGroup().toXMLString(domMap)); 	
			sb.append("</rootGroup>");		
		}
		if (this.getVersionNumber() != null)
		{
			sb.append("<versionNumber>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getVersionNumber().toString()));
			sb.append("</versionNumber>");		
		}
		if (this.getImageStatus() != null)
		{
			sb.append("<imageStatus>");
			sb.append(this.getImageStatus().toXMLString()); 
			sb.append("</imageStatus>");		
		}
		if (this.getQuestions() != null)
		{
			if (this.getQuestions().size() > 0 )
			{
			sb.append("<questions>");
			sb.append(ims.domain.DomainObject.toXMLString(this.getQuestions(), domMap));
			sb.append("</questions>");		
			}
		}
		if (this.getAssocFindings() != null)
		{
			if (this.getAssocFindings().size() > 0 )
			{
			sb.append("<assocFindings>");
			sb.append(ims.domain.DomainObject.toXMLString(this.getAssocFindings(), domMap));
			sb.append("</assocFindings>");		
			}
		}
		return sb.toString();
	}
		
	public static java.util.List fromListXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.List list, java.util.HashMap domMap) throws Exception
	{
		if (list == null)
		 list = new java.util.ArrayList();
		fillListFromXMLString(list, el, factory, domMap);
		return list;
	}
	
	public static java.util.Set fromSetXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.Set set, java.util.HashMap domMap) throws Exception
	{
		if (set == null)
			 set = new java.util.HashSet();
		fillSetFromXMLString(set, el, factory, domMap);
		return set;
	}
	
	private static void fillSetFromXMLString(java.util.Set set, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			DrawingImage domainObject = getDrawingImagefromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!set.contains(domainObject)) 
				set.add(domainObject);
			newSet.add(domainObject);			
		}
		
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = set.iterator();
		//Find out which objects need to be removed
		while (iter.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet.contains(o))
			{
				removedSet.add(o);
			}
		}
		iter = removedSet.iterator();
		//Remove the unwanted objects
		while (iter.hasNext())
		{
			set.remove(iter.next());
		}		
	}
	
	private static void fillListFromXMLString(java.util.List list, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			DrawingImage domainObject = getDrawingImagefromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}

			int domIdx = list.indexOf(domainObject);
			if (domIdx == -1)
			{
				list.add(i, domainObject);
			}
			else if (i != domIdx && i < list.size())
			{
				Object tmp = list.get(i);
				list.set(i, list.get(domIdx));
				list.set(domIdx, tmp);
			}
		}		
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=list.size();
		while (i1 > size)
		{
			list.remove(i1-1);
			i1=list.size();
		}
	}
		
	public static DrawingImage getDrawingImagefromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getDrawingImagefromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static DrawingImage getDrawingImagefromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!DrawingImage.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!DrawingImage.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the DrawingImage class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (DrawingImage)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(DrawingImage.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		DrawingImage ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (DrawingImage)factory.getImportedDomainObject(DrawingImage.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new DrawingImage();
		}
		String keyClassName = "DrawingImage";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (DrawingImage)impObj.getDomainObject();
		}
		else
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(extId);
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(ret);
			domMap.put(keyClassName + "_" + externalSource + "_" + extId, impObj);
		}
		fillFieldsfromXML(el, factory, ret, domMap);
		return ret;
	}

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, DrawingImage obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("category");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setCategory(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("type");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setType(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("imagename");
		if(fldEl != null)
		{	
    		obj.setImagename(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("image");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setImage(ims.core.configuration.domain.objects.AppImage.getAppImagefromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("rootGroup");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setRootGroup(ims.core.configuration.domain.objects.DrawingGroup.getDrawingGroupfromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("versionNumber");
		if(fldEl != null)
		{	
    		obj.setVersionNumber(new Integer(fldEl.getTextTrim()));	
		}
		fldEl = el.element("imageStatus");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setImageStatus(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("questions");
		if(fldEl != null)
		{
			fldEl = fldEl.element("set");	
			obj.setQuestions(ims.assessment.configuration.domain.objects.ImageFindingQuestion.fromSetXMLString(fldEl, factory, obj.getQuestions(), domMap));
		}
		fldEl = el.element("assocFindings");
		if(fldEl != null)
		{
			fldEl = fldEl.element("set");	
			obj.setAssocFindings(ims.assessment.configuration.domain.objects.ImageFinding.fromSetXMLString(fldEl, factory, obj.getAssocFindings(), domMap));
		}
	}

	public static String[] getCollectionFields()
	{
		return new String[]{
		 "questions"
		, "assocFindings"
		};
	}


	public static class FieldNames	
	{
	public static final String ID = "id";
		public static final String Category = "category";
		public static final String Type = "type";
		public static final String Imagename = "imagename";
		public static final String Image = "image";
		public static final String RootGroup = "rootGroup";
		public static final String VersionNumber = "versionNumber";
		public static final String ImageStatus = "imageStatus";
		public static final String Questions = "questions";
		public static final String AssocFindings = "assocFindings";
	}
}

