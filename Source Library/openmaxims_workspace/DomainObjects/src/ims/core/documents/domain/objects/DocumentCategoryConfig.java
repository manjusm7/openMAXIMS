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
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5589.25814)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated: 12/10/2015, 13:28
 *
 */
package ims.core.documents.domain.objects;

/**
 * 
 * @author Neil McAnaspie
 * Generated.
 */


public class DocumentCategoryConfig extends ims.domain.DomainObject implements ims.domain.SystemInformationRetainer, java.io.Serializable {
	public static final int CLASSID = 1068100004;
	private static final long serialVersionUID = 1068100004L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	/** Template */
	private ims.core.admin.domain.objects.TemplateBo template;
	/** Document Category */
	private ims.domain.lookups.LookupInstance category;
	/** Specialty
	  * Collection of ims.domain.lookups.LookupInstance.
	  */
	private java.util.List specialty;
	/** SystemInformation */
	private ims.domain.SystemInformation systemInformation = new ims.domain.SystemInformation();
    public DocumentCategoryConfig (Integer id, int ver)
    {
    	super(id, ver);
    }
    public DocumentCategoryConfig ()
    {
    	super();
    }
    public DocumentCategoryConfig (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.core.documents.domain.objects.DocumentCategoryConfig.class;
	}


	public ims.core.admin.domain.objects.TemplateBo getTemplate() {
		return template;
	}
	public void setTemplate(ims.core.admin.domain.objects.TemplateBo template) {
		this.template = template;
	}

	public ims.domain.lookups.LookupInstance getCategory() {
		return category;
	}
	public void setCategory(ims.domain.lookups.LookupInstance category) {
		this.category = category;
	}

	public java.util.List getSpecialty() {
		if ( null == specialty ) {
			specialty = new java.util.ArrayList();
		}
		return specialty;
	}
	public void setSpecialty(java.util.List paramValue) {
		this.specialty = paramValue;
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
		if ( "Instantiation".equals("Configuration") )
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
		
		auditStr.append("\r\n*template* :");
		if (template != null)
		{
			auditStr.append(toShortClassName(template));
				
		    auditStr.append(template.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*category* :");
		if (category != null)
			auditStr.append(category.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*specialty* :");
		if (specialty != null)
		{
			java.util.Iterator it3 = specialty.iterator();
			int i3=0;
			while (it3.hasNext())
			{
				if (i3 > 0)
					auditStr.append(",");
				ims.domain.lookups.LookupInstance obj = (ims.domain.lookups.LookupInstance)it3.next();
			auditStr.append(obj.getText());
			i3++;
		}
		if (i3 > 0)
			auditStr.append("] " + i3);
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
		
		String keyClassName = "DocumentCategoryConfig";
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
		if (this.getTemplate() != null)
		{
			sb.append("<template>");
			sb.append(this.getTemplate().toXMLString(domMap)); 	
			sb.append("</template>");		
		}
		if (this.getCategory() != null)
		{
			sb.append("<category>");
			sb.append(this.getCategory().toXMLString()); 
			sb.append("</category>");		
		}
		if (this.getSpecialty() != null)
		{
			if (this.getSpecialty().size() > 0 )
			{
			sb.append("<specialty>");
			sb.append(ims.domain.lookups.LookupInstance.toXMLString(this.getSpecialty())); 
			sb.append("</specialty>");		
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
			DocumentCategoryConfig domainObject = getDocumentCategoryConfigfromXML(itemEl, factory, domMap);

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
			DocumentCategoryConfig domainObject = getDocumentCategoryConfigfromXML(itemEl, factory, domMap);

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
		
	public static DocumentCategoryConfig getDocumentCategoryConfigfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getDocumentCategoryConfigfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static DocumentCategoryConfig getDocumentCategoryConfigfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!DocumentCategoryConfig.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!DocumentCategoryConfig.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the DocumentCategoryConfig class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (DocumentCategoryConfig)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(DocumentCategoryConfig.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		DocumentCategoryConfig ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (DocumentCategoryConfig)factory.getImportedDomainObject(DocumentCategoryConfig.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new DocumentCategoryConfig();
		}
		String keyClassName = "DocumentCategoryConfig";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (DocumentCategoryConfig)impObj.getDomainObject();
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

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, DocumentCategoryConfig obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("template");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setTemplate(ims.core.admin.domain.objects.TemplateBo.getTemplateBofromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("category");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setCategory(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("specialty");
		if(fldEl != null)
		{
			fldEl = fldEl.element("list");	
			obj.setSpecialty(ims.domain.lookups.LookupInstance.fromListXMLString(fldEl, factory, obj.getSpecialty())); 
		}
	}

	public static String[] getCollectionFields()
	{
		return new String[]{
		 "specialty"
		};
	}


	public static class FieldNames	
	{
	public static final String ID = "id";
		public static final String Template = "template";
		public static final String Category = "category";
		public static final String Specialty = "specialty";
	}
}

