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
// This code was generated by Alexie Ursache using IMS Development Environment
// (version 1.18 build 40527.1730)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.ccosched.forms.resourceavailabilty;
import ims.core.vo.PatientShort;
import ims.core.vo.lookups.ChannelType;
import ims.dto.Result;
import ims.dto.client.Sd_sess_appts;
import ims.framework.controls.TreeNode;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.FrameworkInternalException;
import ims.framework.utils.Color;
import ims.framework.utils.Date;
import ims.framework.utils.DateFormat;
import ims.framework.utils.StringUtils;
import ims.framework.utils.Time;
import ims.framework.utils.TimeFormat;
import ims.framework.utils.TimeSpan;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;

public class Logic extends BaseLogicDTO {
	private final String NEW_LINE = System.getProperty("line.separator");
	
	protected void OnFormOpen()
	{
		form.SetDefaultGrid().setEnabled(true);
		form.SetDefaultGrid().setReadOnly(false);
		form.AvailabilityPattern().setEnabled(true);
		form.ShowAvailabilityGrid().setEnabled(true);
		form.ShowAvailabilityGrid().setReadOnly(true);

		form.getGlobalContext().CcoSched.Booking.setDefaultTime(new ArrayList());
		ShowControls(1);
		form.DateRange().clear();
		form.AvailabilityPattern().clear();

		// Patient
		PatientShort patient = form.getGlobalContext().Core.getPatientShort();

		form.PatientName().setValue(patient.getNameIsNotNull() ? patient.getName().getForename() + " " + patient.getName().getSurname() : "");			
		form.PatientDOB().setValue(patient.getDobIsNotNull() ? patient.getDob().toString() : "");

		form.PatientHospitalNumber().setValue(patient.getHospnum() != null ? patient.getHospnum().getValue() : "");
		//ICCO688
		form.PatientTelephone().setValue(patient.getCommunicationChannel(ChannelType.GEN_PHONE) !=null ? patient.getCommunicationChannel(ChannelType.GEN_PHONE).getCommValue() : "");

		if (patient.getAddressIsNotNull())
		{
			StringBuffer address = new StringBuffer(200);
			if(patient.getAddress().getLine1IsNotNull()) //WDEV-14468 
			{
				address.append(patient.getAddress().getLine1()); 
				address.append(NEW_LINE);
			}
			if(patient.getAddress().getLine2IsNotNull())
			{
				address.append(patient.getAddress().getLine2());
				address.append(NEW_LINE);
			}
			if(patient.getAddress().getLine3IsNotNull())
			{
				address.append(patient.getAddress().getLine3());
				address.append(NEW_LINE);
			}
			if(patient.getAddress().getLine4IsNotNull())
			{
				address.append(patient.getAddress().getLine4());
				address.append(NEW_LINE);
			}
			if(patient.getAddress().getLine5IsNotNull())
			{
				address.append(patient.getAddress().getLine5());
				address.append(NEW_LINE);
			}
			////WDEV-14468 GM
			if (patient.getAddress().getPostCodeIsNotNull())
			{
				address.append(patient.getAddress().getPostCode());
			}
			
			form.PatientAddress().setValue(address.toString());
		}

		form.PatientCategory().setValue(form.getGlobalContext().CcoSched.Booking.getCategory());

		// booking
		if(form.getGlobalContext().CcoSched.Booking.getStartDate() != null)
			form.BookingStartDate().setValue(form.getGlobalContext().CcoSched.Booking.getStartDate().toString(DateFormat.STANDARD));
		if(form.getGlobalContext().CcoSched.Booking.getEndDate() != null)
			form.BookingEndDate().setValue(form.getGlobalContext().CcoSched.Booking.getEndDate().toString(DateFormat.STANDARD));
		form.BookingAppointmentTime().setValue("");
		form.BookingTransport().setValue(form.getGlobalContext().CcoSched.Booking.getTransport());

		// availability
		Sd_sess_appts session = (Sd_sess_appts)domain.getDTOInstance(Sd_sess_appts.class);

		Date min = new Date(maxDate);
		Date max = new Date(minDate);

		Hashtable ht = form.getGlobalContext().CcoSched.Booking.getSelectedSessions();
		Hashtable tooltips = new Hashtable();
		Hashtable tooltips2 = new Hashtable();
		if(ht != null)
		{
			Enumeration sess = ht.elements();
			while(sess.hasMoreElements())
			{
				String str = (String)sess.nextElement();
				String[] sessions = StringUtils.splitString(str, ",");
				for(int j=0; j<sessions.length; j++)
				{
					String s2 = sessions[j];
					String[] tmp = StringUtils.splitString(s2, "+");
	
					session.Filter.clear();
					session.Filter.Prfile_sess_id = tmp[0];
					session.Filter.Prfiled_sess_id = tmp[1];
	
					Result result = session.get();
					if (result != null)
					{
						engine.showMessage(result.getMessage());
						return;
					}
					if (session.DataCollection.count() != 1)
					{
						engine.showMessage("Failed to get session (ID=" + tmp[0] + ")");
						return;
					}
					Sd_sess_appts.Sd_sess_apptsRecord s = session.DataCollection.get(0);
	
					
					Date date = null;
					if (s.Sess_dt != null && s.Sess_dt.equals("") == false)
						try{date = new Date(s.Sess_dt, DateFormat.ISO);}catch(ParseException e){e.printStackTrace();}
					if (date == null)
					{
						engine.showMessage("Failed to get session date (ID=" + tmp[0] + ")");
						return;
					}
	
					Time startTime = null;
					if (s.Stm != null && s.Stm.equals("") == false)
						try{ startTime = new Time(s.Stm, TimeFormat.FLAT6);}catch(RuntimeException e){e.printStackTrace();}
					if (startTime == null)
					{
						engine.showMessage("Internal error: Session start time not returned.");
						return;
					}
	
					Time endTime = null;
					if (s.Etm != null && s.Etm.equals("") == false)
						try{endTime = new Time(s.Etm, TimeFormat.FLAT6);}catch(RuntimeException e){e.printStackTrace();};
					if (endTime == null)
					{
						engine.showMessage("Internal error: Session end time not returned.");
						return;
					}
					//Used to be AddDate
					//Change Start Time  = Time(8,0) and  End Time = Time(19,59)
					try {
						if (checkTime(new Time(8,0), startTime.copy()))
							form.AvailabilityPattern().addUnavailableTime(new Date(date), new Time(8,0), new Time(8,01));
						else
							form.AvailabilityPattern().addUnavailableTime(new Date(date), new Time(8,0), startTime.copy());
						
						if (checkTime(endTime.copy(), new Time(19,59)))
							form.AvailabilityPattern().addUnavailableTime(new Date(date), new Time(19,58), new Time(19,59));
						else
							form.AvailabilityPattern().addUnavailableTime(new Date(date), endTime.copy(), new Time(19,59));
					} catch (FrameworkInternalException e1) 
					{
						engine.showMessage(e1.getMessage());
					}

					
					Integer di = GetInteger(s.Tno_appts);
					Integer di2 = GetInteger(s.Tno_fappts);
	
					int i1 = (di == null ? 0 : di.intValue());
					int i2 = (di2 == null ? 0 : di2.intValue());
	
					if (!tooltips.containsKey(date))
					{
						tooltips.put(date, new Integer(i1));
						tooltips2.put(date, new Integer(i2));
					}
					else
					{
						int i = ((Integer)tooltips.get(date)).intValue();
						i += i1;
						tooltips.put(date, new Integer(i));
	
						i = ((Integer)tooltips2.get(date)).intValue();
						i += i2;
						tooltips2.put(date, new Integer(i));
					}
	
					if (date.isLessThan(min)) min = new Date(date.getYear(), date.getMonth(), date.getDay());
					if (date.isGreaterThan(max)) max = new Date(date.getYear(), date.getMonth(), date.getDay());
	
					for(int k=0; k<s.Seqno2Collection.count(); k++)
					{
						Sd_sess_appts.Sd_sess_apptsSeqno2Record times = s.Seqno2Collection.get(k); 
						Time stTime = null;
						try{stTime = new Time(times.Stm2, TimeFormat.FLAT6);}catch(RuntimeException e){e.printStackTrace();}
						if (stTime == null)
						{
							engine.showMessage("Failed to get exluded start time (ID=" + tmp[0] + ")");
							return;
						}
	
						Time endTm = null;
						try{endTm = new Time(times.Etm2, TimeFormat.FLAT6);}catch(RuntimeException e){e.printStackTrace();} 
						if (endTm == null)
						{
							engine.showMessage("Failed to get exluded end time (ID=" + tmp[0] + ")");
							return;
						}
	
						//used to be AddPeriod
						try {
							form.AvailabilityPattern().addBookedTime(new Date(date), stTime.copy(), endTm.copy());
						} catch (FrameworkInternalException e) 
						{
							engine.showMessage(e.getMessage());
						}
					}
	
					for(int l = 0; l<s.Seqno3Collection.count(); l++)
					{
						Sd_sess_appts.Sd_sess_apptsSeqno3Record  times = s.Seqno3Collection.get(l);
						if (!times.Appt_stat.equals("-2190") && !times.Appt_stat.equals("-2193") && !times.Appt_stat.equals("-2197")) //Cancelled
						{
							Time stTime = null;
							try{stTime = new Time(times.Appt_stm, TimeFormat.FLAT6);}catch(RuntimeException e){e.printStackTrace();}
							if (startTime == null)
							{
								engine.showMessage("Failed to get appointment start time (ID=" + tmp[0] + ")");
								return;
							}
	
							Time endTm = null;
							try{endTm = new Time(times.Appt_etm, TimeFormat.FLAT6);}catch(RuntimeException e){e.printStackTrace();}
							if (endTm == null)
							{
								engine.showMessage("Failed to get appointment end time (ID=" + tmp[0] + ")");
								return;
							}
							//Used to be AddPeriod
							try {
								form.AvailabilityPattern().addBookedTime(new Date(date), stTime.copy(), endTm.copy());
							} catch (FrameworkInternalException e) 
							{
								engine.showMessage(e.getMessage());
							}
						}
					}
				}
			}
		}

		form.StartDate().setValue(min);
		form.EndDate().setValue(max);

		String htmlNewlLine = "<BR>";
		Enumeration dates = tooltips.keys();
		while(dates.hasMoreElements())
		{
			Date date = (Date)dates.nextElement();
			StringBuffer sb = new StringBuffer(100);
			sb.append(date.toString(DateFormat.STANDARD));
			sb.append(htmlNewlLine);
			sb.append("First appointments: ");
			sb.append(tooltips2.get(date).toString());
			sb.append(htmlNewlLine);
			sb.append("Total number of appointments: ");
			sb.append(tooltips.get(date).toString());
			form.AvailabilityPattern().addTooltip(date, sb.toString());
		}

		OnRefresh();

		if(ht != null)
		{
			TreeNode node = form.DateRange().getNodes().add(minDate, "Dates");

			ArrayList ar = new ArrayList();
			Enumeration enumColl = ht.keys();
			while(enumColl.hasMoreElements())
				ar.add(enumColl.nextElement());
			
			//equivalent of ar.Sort();
			Collections.sort(ar, new StringComparer());
		
			for(int i=0; i<ar.size(); i++)
			{
				Date americanDate = null;
				if (ar.get(i) != null && ar.get(i).equals("") == false)
					try{americanDate = new Date((String)ar.get(i),DateFormat.ISO);}catch(ParseException e){e.printStackTrace();}
				if(americanDate != null)
					node.getNodes().add(americanDate, americanDate.toString(DateFormat.MEDIUM));//("dd MMMM yyyy", new System.Globalization.CultureInfo("en-US")));
			}
	
			node.setExpanded(true);
		}
	}	
	
	private boolean checkTime(Time startTime, Time endTime)
	{
		int diff = TimeSpan.getTimeSpan(endTime, startTime).getMinutes();
		return(diff <= 0);
	}
	
	protected void OnDefaultTime(int column, GenForm.SetDefaultGridRow row,	boolean isChecked) 
	{
		ArrayList ar = form.getGlobalContext().CcoSched.Booking.getDefaultTime();
		if (!isChecked)
			ar.remove(row.getSlots());
		else
		{
			if (ar.size() == 0)
				ar.add(row.getSlots());
			else
			{
				boolean error = false;
				for (int i = 0; i < ar.size(); ++i)
				{
					String [] time = StringUtils.splitString((String)ar.get(i), ":");
					Time t = null;
					try{t = new Time(time[0] + time[1] + "00", TimeFormat.FLAT6);}catch(RuntimeException e){e.printStackTrace();}
					if (t == null)
					{
						InternalError("Wrong time format");
						return;
					}

					String[] time1 = StringUtils.splitString(row.getSlots(), ":");
					Time t1 = null;
					try{ t1 = new Time(time1[0] + time1[1] + "00", TimeFormat.FLAT6);}catch(RuntimeException e){e.printStackTrace();}
					if (t1 == null)
					{
						InternalError("Wrong time format");
						return;
					}
					
					if (!((CompareTimes(t, t1) > 0 && SubstractTimes(t, t1).getHour() >= form.getGlobalContext().CcoSched.Booking.getIntervalRequired().intValue()) || (CompareTimes(t, t1) < 0  && SubstractTimes(t1, t).getHour() >= form.getGlobalContext().CcoSched.Booking.getIntervalRequired().intValue())))
					{
						row.setDefault(false);
						engine.showMessage("The interval required must be " + form.getGlobalContext().CcoSched.Booking.getIntervalRequired().toString() + " hour(s).");
						error = true;
						break;
					}
				}
				if (!error)
					ar.add(row.getSlots());
			}
		}
		//ar.Sort();
		Collections.sort(ar, new StringComparer());

		StringBuffer times = new StringBuffer(40);
		for(int i=0; i<ar.size(); i++)
		{
			times.append(ar.get(i));
			times.append(", ");
		}
		if (ar.size() > 0)
			times.delete(times.length()- 2, times.length());

		form.BookingAppointmentTime().setValue(times.toString());
	}
	protected void OnCancel() 
	{
		if(form.getGlobalContext().CcoSched.Booking.getDefaultTime() != null)
		{
			ArrayList ar = form.getGlobalContext().CcoSched.Booking.getDefaultTime();
			ar.clear();
			form.getGlobalContext().CcoSched.Booking.setDefaultTime(ar);
		}
		engine.close(DialogResult.OK);
	}
	protected void OnRefresh() 
	{
		if(form.StartDate().getValue() != null && form.EndDate().getValue() != null && form.StartDate().getValue().isGreaterThan(form.EndDate().getValue()))
		{
			engine.showMessage("Start Date cannot be set after End Date.");
			return;
		}
		
		form.AvailabilityPattern().setStartDate(form.StartDate().getValue().copy());
		form.AvailabilityPattern().setEndDate(form.EndDate().getValue().copy());
	}
	protected void OnOk() 
	{
		ArrayList ar = new ArrayList();
		for (int i = 0; i < form.SetDefaultGrid().getRows().size(); ++i)
			if (form.SetDefaultGrid().getRows().get(i).getDefault())
				ar.add(form.SetDefaultGrid().getRows().get(i).getSlots());
		form.getGlobalContext().CcoSched.Booking.setDefaultTime(ar);
		engine.close(DialogResult.OK);
	}
	protected void OnPattern() 
	{
		ShowControls(1);
	}
	protected void OnAvailabilityPatternClick(ims.framework.utils.Time value) 
	{
		if (form.getGlobalContext().CcoSched.Booking.getDefaultTime() != null)
			form.getGlobalContext().CcoSched.Booking.getDefaultTime().clear();
		form.BookingAppointmentTime().setValue("");
		if (value.getHour() != 8 || value.getMinute() != 0)
			value.addMinutes(-30);

		Time border = null;
		try{ border = new Time(value.getHour(), value.getMinute());}catch(RuntimeException e){e.printStackTrace();}//Utility.GetDTOTimeFromString(string.Format("{0:D2}{1:D2}{2:D2}",  0));
		if (border == null)
		{
			InternalError("Wrong time format");
			return;
		}
		ShowControls(0);
		form.SetDefaultGrid().getRows().clear();

		String key = form.StartDate().getValue().toString(DateFormat.ISO);
		String s2 = (String)form.getGlobalContext().CcoSched.Booking.getSelectedSessions().get(key);
		if(s2 == null || s2.length() == 0)
			return;
		//Replace s2.plit(new char[]{',','+'});
		String[] str = StringUtils.splitString(s2.replace(',', '+'),"+");

		Sd_sess_appts sessionAppointments = (Sd_sess_appts)domain.getDTOInstance(Sd_sess_appts.class);
		sessionAppointments.Filter.clear();
		sessionAppointments.Filter.Prfile_sess_id = str[0];
		sessionAppointments.Filter.Prfiled_sess_id = str[1];
		sessionAppointments.Filter.Userrights = form.getGlobalContext().CcoSched.getLoggedInUserId();
		Result result = sessionAppointments.get();
		if (result != null)
		{
			engine.showMessage(result.getMessage());
			return;
		}
		if (sessionAppointments.DataCollection.count() == 0)
		{
			engine.showMessage("Internal error: No data return for session.");
			return;
		}
		Sd_sess_appts.Sd_sess_apptsRecord sessionAppointment = sessionAppointments.DataCollection.get(0);

		Time startTime = null;
		try{startTime = new Time(sessionAppointment.Stm, TimeFormat.FLAT6);}catch(RuntimeException e){e.printStackTrace();}
		if (startTime == null)
		{
			engine.showMessage("Internal error: Session start time not returned.");
			return;
		}

		Time endTime = null;//dt = Utility.GetDTOTimeFromString(sessionAppointment.attEtm);
		try{ endTime = new Time(sessionAppointment.Etm, TimeFormat.FLAT6);}catch(RuntimeException e){e.printStackTrace();} 
		if (endTime == null)
		{
			engine.showMessage("Internal error: Session end time not returned.");
			return;
		}

//		#region 1. find booked periods
		ArrayList bookedPeriods = new ArrayList();
		for(int i=0; i<sessionAppointment.Seqno3Collection.count(); i++)
		{
			Sd_sess_appts.Sd_sess_apptsSeqno3Record r = sessionAppointment.Seqno3Collection.get(i);
			if (!r.Appt_stat.equals("-2190") && !r.Appt_stat.equals("-2193") && !r.Appt_stat.equals("-2197")) //Cancelled
			{
				Time startTimeBooked = GetTimeFromString(r.Appt_stm);
				if (startTimeBooked == null)
				{
					InternalError("Appointment start time not returned.");
					return;
				}

				Time endTimeBooked = GetTimeFromString(r.Appt_etm);
				if (endTimeBooked == null)
				{
					InternalError("Appointment end time not returned.");
					return;
				}

				boolean self = r.Pkey.equals(form.getGlobalContext().Core.getPatientShort().getPkey().getValue());
				ArrayList intersectedPeriods = new ArrayList();
				for(int j=0; j<bookedPeriods.size(); j++)
				{
					Object[] period = (Object[]) bookedPeriods.get(j);
					if (CompareTimes(startTimeBooked, (Time)period[1]) < 0 && CompareTimes(endTimeBooked, (Time)period[0]) > 0)
						intersectedPeriods.add(period);
				}

				Time min = startTimeBooked;
				Time max = endTimeBooked;
				for(int j=0; j<intersectedPeriods.size(); j++)
				{
					Object[] period = (Object[])intersectedPeriods.get(j);
					if (CompareTimes((Time)period[0], min) < 0)
						min = (Time)period[0];
					if (CompareTimes((Time)period[1], max) > 0) 
						max = (Time)period[1];
				}
				int k = 1;
				for(int j=0; j<intersectedPeriods.size(); j++)
				{
					Object[] o = (Object[]) intersectedPeriods.get(j);
					k += ((Integer)o[2]).intValue();
					self |= ((Boolean)o[3]).booleanValue();
					bookedPeriods.remove(o);
				}

				bookedPeriods.add(new Object[]{min, max, new Integer(k), new Boolean(self)});
			}
		}
//		#endregion

//		#region 2. find exluded periods
		ArrayList excludedPeriods = new ArrayList();
		for(int i=0; i<sessionAppointment.Seqno2Collection.count(); i++)
		{
			Sd_sess_appts.Sd_sess_apptsSeqno2Record r = sessionAppointment.Seqno2Collection.get(i);
			Time startTimeExclusion = GetTimeFromString(r.Stm2);
			if (startTimeExclusion == null)
			{
				InternalError("failed to get exclusion time record.");
				return;
			}

			Time endTimeExclusion = GetTimeFromString(r.Etm2);
			if (endTimeExclusion == null)
			{
				InternalError("failed to get exclusion time record.");
				return;
			}

			ArrayList intersectedPeriods = new ArrayList();
			for(int j=0; j<excludedPeriods.size(); j++)
			{
				Time[] period = (Time[])excludedPeriods.get(j);
				if (CompareTimes(startTimeExclusion, period[1]) <= 0  && CompareTimes(endTimeExclusion, period[0]) >= 0)
					intersectedPeriods.add(period);
			}

			Time min = startTimeExclusion;
			Time max = endTimeExclusion;
			
			for(int j=0; j<intersectedPeriods.size(); j++)
			{
				Time[] period = (Time[])intersectedPeriods.get(j);
				if (CompareTimes(period[0], min) < 0)
					min = period[0];
				if (CompareTimes(period[1], max) > 0)
					max = period[1];
			}
			for(int j=0; j<intersectedPeriods.size(); j++)
			{
				Object o = (Object)intersectedPeriods.get(j);
				excludedPeriods.remove(o);
			}

			excludedPeriods.add(new Time[]{min, max});
		}
//		#endregion
//
//		#region 3. find purely exluded periods
		ArrayList tmpArr = new ArrayList();
		for(int i=0; i<bookedPeriods.size(); i++)
		{
			Object[] bookedPeriod  = (Object[])bookedPeriods.get(i);
			Time s = (Time)bookedPeriod[0];
			Time e = (Time)bookedPeriod[1];

			tmpArr.clear();
			for(int j=0; j<excludedPeriods.size(); j++)
				tmpArr.add(excludedPeriods.get(j));
			excludedPeriods.clear();
			for(int j=0; j<tmpArr.size(); j++)
			{
				Time[] excludedPeriod = (Time[])tmpArr.get(j);
				if (CompareTimes(s, excludedPeriod[1]) > 0 || CompareTimes(e, excludedPeriod[0]) < 0)
					excludedPeriods.add(excludedPeriod);
				else if (CompareTimes(s, excludedPeriod[0]) >= 0 && CompareTimes(s, excludedPeriod[1]) <= 0 && CompareTimes(e, excludedPeriod[1]) > 0)
					excludedPeriods.add(new Time[]{excludedPeriod[1], e});
				else if (CompareTimes(s, excludedPeriod[0]) < 0 && CompareTimes(e, excludedPeriod[0]) >= 0 && CompareTimes(e, excludedPeriod[1]) <= 0)
					excludedPeriods.add(new Time[]{s, excludedPeriod[0]});
				else if (CompareTimes(s, excludedPeriod[0]) > 0 && CompareTimes(s, excludedPeriod[1]) < 0 && CompareTimes(e, excludedPeriod[0]) > 0 && CompareTimes(e, excludedPeriod[1]) < 0)
				{
					excludedPeriods.add(new Time[]{excludedPeriod[0], s});
					excludedPeriods.add(new Time[]{e, excludedPeriod[1]});
				}
			}
		}
//		#endregion
//
//		#region 4. find HCP period
		Time startTimeListOwner = null;
		Time endTimeListOwner = null;
		if (form.getGlobalContext().CcoSched.Booking.getListOwner() != null)
		{
			for(int i=0; i<sessionAppointment.LoseqnoCollection.count(); i++)
			{
				Sd_sess_appts.Sd_sess_apptsLoseqnoRecord listOwner = sessionAppointment.LoseqnoCollection.get(i);
				if (listOwner.Loseqno.equals(form.getGlobalContext().CcoSched.Booking.getListOwner().Staff_no))
				{
					startTimeListOwner = GetTimeFromString(listOwner.Stm1);
					if (startTimeListOwner == null)
					{
						InternalError("start time for list owner is not supplied.");
						return;
					}
					
					endTimeListOwner = GetTimeFromString(listOwner.Etm1);
					if (endTimeListOwner == null)
					{
						InternalError("end time for list owner is not supplied.");
						return;
					}
					break;
				}
			}
			if (startTimeListOwner == null)
			{
				InternalError("list owner is not found.");
				return;
			}
		}
//		#endregion
//
//		#region 5. create slots
		boolean flag = true;
		
		if (sessionAppointment.Userrights.equals("-100"))
			flag = false;
		else if (form.getGlobalContext().CcoSched.Booking.getListOwner() != null && sessionAppointment.Userrights.equals("-101"))
			for(int i=0; i<sessionAppointment.LoseqnoCollection.count(); i++)
			{
				Sd_sess_appts.Sd_sess_apptsLoseqnoRecord listOwner = sessionAppointment.LoseqnoCollection.get(i);
				if (listOwner.Loseqno.equals(form.getGlobalContext().CcoSched.Booking.getListOwner().Staff_no))
				{
					Integer si = null;
					try{si = new Integer(listOwner.Loremnoapp);}catch(NumberFormatException e){e.printStackTrace();};
					if (si != null && si.intValue() == 0)
						flag = false;
					break;
				}
			}
		if (flag)
		{
			int timeRequired = form.getGlobalContext().CcoSched.Booking.getTimeRequired().intValue();
			Time slotStartTime = startTime;
			while (true)
			{
				Time slotEndTime = new Time(slotStartTime.getHour(), slotStartTime.getMinute());
				slotEndTime.addMinutes(timeRequired);
				if (slotEndTime.isGreaterThan(endTime))
					break;

				flag = false;
				if (sessionAppointment.Userrights.equals("-102"))
					flag = true;
				else
				{
					if (form.getGlobalContext().CcoSched.Booking.getListOwner() == null)
						flag = true;
					else
					{
						if (startTimeListOwner.isLessOrEqualThan(slotStartTime) && slotStartTime.isLessThan(endTimeListOwner))
							flag = true;
						else
							slotStartTime = slotEndTime;
					}
				}


				if (flag)
				{
					GenForm.SetDefaultGridRow row = null;
					if (slotStartTime.isGreaterThan(border))
					{
						row = form.SetDefaultGrid().getRows().newRow();
						row.setSlots(slotStartTime.toString(TimeFormat.DEFAULT));// ("HH:mm");
						if (startTimeListOwner != null)
						{
							if (startTimeListOwner.isLessOrEqualThan(slotStartTime) && slotStartTime.isLessThan(endTimeListOwner))
								row.setBackColor(Color.LightYellow);
						}
					}					

					flag = true;
					for(int j=0; j<bookedPeriods.size(); j++)
					{	
						Object[] bookedPeriod = (Object[]) bookedPeriods.get(j);
						if (slotStartTime.isLessThan((Time)bookedPeriod[1]) && slotEndTime.isGreaterThan((Time)bookedPeriod[0]))
						{
							if (row != null)
							{
								row.setStatus("Booked (" + bookedPeriod[2].toString() + ")");
								row.setBackColor((((Boolean)bookedPeriod[3]).booleanValue() ? Color.PaletTurquoise : Color.White));
							}
							slotStartTime = new Time(((Time)bookedPeriod[1]).getHour(), ((Time)bookedPeriod[1]).getMinute());
							flag = false;
							break;
						}
					}
					if (flag)
					{
						for(int k=0; k<excludedPeriods.size(); k++)
						{	
							Time[] excludedPeriod = (Time[])excludedPeriods.get(k);
							if (slotStartTime.isLessThan(excludedPeriod[1]) && slotEndTime.isGreaterThan(excludedPeriod[0]))
							{
								if (row != null)
								{
									row.setStatus("Excluded");
									row.setBackColor(Color.LightGray);
								}
								slotStartTime = new Time(((Time)excludedPeriod[1]).getHour(), ((Time)excludedPeriod[1]).getMinute());
								flag = false;
								break;
							}
						}
						if (flag)
						{
							if (row != null)
								row.setStatus("Available");
							slotStartTime = new Time(slotEndTime.getHour(), slotEndTime.getMinute());
						}
					}
				}
			}
		}
//		#endregion
	}
	protected void OnDateSelected(ims.framework.controls.TreeNode node)
	{
		Date date = (Date)node.getValue();
		if (date.equals(minDate))
			ShowControls(1);
		else
		{
			ShowControls(2);
			form.ShowAvailabilityGrid().getRows().clear();
			String ss = (String)form.getGlobalContext().CcoSched.Booking.getSelectedSessions().get(date.toString(DateFormat.ISO));
			String[] str = StringUtils.splitString(ss.replace(',','+'), "+");

			Sd_sess_appts sessionAppointments = (Sd_sess_appts)domain.getDTOInstance(Sd_sess_appts.class);
			sessionAppointments.Filter.clear();
			sessionAppointments.Filter.Prfile_sess_id = str[0];
			sessionAppointments.Filter.Prfiled_sess_id = str[1];
			try
			{
				sessionAppointments.Filter.Userrights = form.getGlobalContext().CcoSched.getLoggedInUserId();
			}
			catch(NumberFormatException e)
			{
				engine.showMessage(e.getMessage());
			}
			Result result = sessionAppointments.get();
			if (result != null)
			{
				engine.showMessage(result.getMessage());
				return;
			}
			if (sessionAppointments.DataCollection.count() == 0)
			{
				InternalError("No data return for session.");
				return;
			}
			Sd_sess_appts.Sd_sess_apptsRecord sessionAppointment = sessionAppointments.DataCollection.get(0);

			Time startTime = GetTimeFromString(sessionAppointment.Stm);
			if (startTime == null)
			{
				InternalError("Session start time not returned.");
				return;
			}

			Time endTime = GetTimeFromString(sessionAppointment.Etm);
			if (endTime == null)
			{
				InternalError("Session end time not returned.");
				return;
			}

//			#region 1. find booked periods
			ArrayList bookedPeriods = new ArrayList();
			for(int k=0; k<sessionAppointment.Seqno3Collection.count(); k++)
			{
				Sd_sess_appts.Sd_sess_apptsSeqno3Record r = sessionAppointment.Seqno3Collection.get(k);
				if (!r.Appt_stat.equals("-2190") && !r.Appt_stat.equals("-2193") && !r.Appt_stat.equals("-2197")) //Cancelled
				{
					Time startTimeBooked = GetTimeFromString(r.Appt_stm);
					if (startTimeBooked == null)
					{
						InternalError("Appointment start time not returned.");
						return;
					}

					Time endTimeBooked = GetTimeFromString(r.Appt_etm);
					if (endTimeBooked == null)
					{
						InternalError("Appointment end time not returned.");
						return;
					}

					boolean self = r.Pkey.equals(form.getGlobalContext().Core.getPatientShort().getPkey().getValue());
					ArrayList intersectedPeriods = new ArrayList();
					for(int j=0; j<bookedPeriods.size(); j++)
					{
						Object[] period = (Object[])bookedPeriods.get(j);
						if (startTimeBooked.isLessThan((Time)period[1]) && endTimeBooked.isGreaterThan((Time)period[0]))
							intersectedPeriods.add(period);
					}

					Time min = new Time(startTimeBooked.getHour(), startTimeBooked.getMinute());
					Time max = new Time(endTimeBooked.getHour(), endTimeBooked.getMinute());
					for(int j=0; j<intersectedPeriods.size();j++)
					{
						Object[] period = (Object[])intersectedPeriods.get(j);
						if (((Time)period[0]).isLessThan(min))
							min = new Time(((Time)period[0]).getHour(),((Time)period[0]).getMinute());
						if (((Time)period[1]).isGreaterThan(max))
							max = new Time(((Time)period[1]).getHour(), ((Time)period[1]).getMinute());
					}
					int i = 1;
					for(int j=0; j<intersectedPeriods.size(); j++)
					{
						Object[] o = (Object[])intersectedPeriods.get(j);
						i += ((Integer)o[2]).intValue();
						self |= ((Boolean)o[3]).booleanValue();
						bookedPeriods.remove(o);
					}

					bookedPeriods.add(new Object[]{min, max, new Integer(i), new Boolean(self)});
				}
			}
//			#endregion

//			#region 2. find exluded periods
			ArrayList excludedPeriods = new ArrayList();
			
			for(int i=0; i<sessionAppointment.Seqno2Collection.count(); i++)
			{
				Sd_sess_appts.Sd_sess_apptsSeqno2Record r = sessionAppointment.Seqno2Collection.get(i);
				
				Time startTimeExclusion = GetTimeFromString(r.Stm2);
				if (startTimeExclusion == null)
				{
					InternalError("failed to get exclusion time record.");
					return;
				}

				Time endTimeExclusion = GetTimeFromString(r.Etm2);
				if (endTimeExclusion == null)
				{
					InternalError("failed to get exclusion time record.");
					return;
				}

				ArrayList intersectedPeriods = new ArrayList();
				for(int j=0; j<excludedPeriods.size(); j++)
				{
					Time[] period  = (Time[])excludedPeriods.get(j);
					if (startTimeExclusion.isLessOrEqualThan(period[1]) && endTimeExclusion.isGreaterOrEqualThan(period[0]))
						intersectedPeriods.add(period);
				}

				Time min = new Time(startTimeExclusion.getHour(), startTimeExclusion.getMinute());
				Time max = new Time(endTimeExclusion.getHour(), endTimeExclusion.getMinute());
				for(int j=0; j<intersectedPeriods.size(); j++)
				{
					Time[] period  = (Time[])intersectedPeriods.get(j);
					if (period[0].isLessThan(min))
						min = new Time(period[0].getHour(), period[0].getMinute());
					if (period[1].isGreaterThan(max))
						max = new Time(period[1].getHour(), period[1].getMinute());
				}
				for(int j=0; j<intersectedPeriods.size(); j++)
					excludedPeriods.remove(intersectedPeriods.get(j));

				excludedPeriods.add(new Time[]{min, max});
			}
//			#endregion
//
//			#region 3. find purely exluded periods
			ArrayList tmpArr = new ArrayList();
			for(int i=0; i<bookedPeriods.size(); i++)
			{
				Object[] bookedPeriod = (Object[])bookedPeriods.get(i);
				Time s = new Time(((Time)bookedPeriod[0]).getHour(), ((Time)bookedPeriod[0]).getMinute());
				Time e = new Time(((Time)bookedPeriod[1]).getHour(), ((Time)bookedPeriod[1]).getMinute());

				tmpArr.clear();
				for(int j=0; j<excludedPeriods.size(); j++)
					tmpArr.add(excludedPeriods.get(j));
				excludedPeriods.clear();
				for(int j=0; j<tmpArr.size(); j++)
				{
					Time[] excludedPeriod = (Time[])tmpArr.get(j);
					if (s.isGreaterThan(excludedPeriod[1]) || e.isLessThan(excludedPeriod[0]))
						excludedPeriods.add(excludedPeriod);
					else if (s.isGreaterOrEqualThan(excludedPeriod[0]) && s.isLessOrEqualThan(excludedPeriod[1]) && e.isGreaterThan(excludedPeriod[1]))
						excludedPeriods.add(new Time[]{excludedPeriod[1], e});
					else if (s.isLessThan(excludedPeriod[0]) && e.isGreaterOrEqualThan(excludedPeriod[0]) && e.isLessOrEqualThan(excludedPeriod[1]))
						excludedPeriods.add(new Time[]{s, excludedPeriod[0]});
					else if (s.isGreaterThan(excludedPeriod[0]) && s.isLessThan(excludedPeriod[1]) && e.isGreaterThan(excludedPeriod[0]) && e.isLessThan(excludedPeriod[1]))
					{
						excludedPeriods.add(new Time[]{excludedPeriod[0], s});
						excludedPeriods.add(new Time[]{e, excludedPeriod[1]});
					}
				}
			}
//			#endregion

//			#region 4. find HCP period
			Time startTimeListOwner = null;
			Time endTimeListOwner = null;
			
			if (form.getGlobalContext().CcoSched.Booking.getListOwner() != null)
			{
				for(int i=0; i<sessionAppointment.LoseqnoCollection.count(); i++)
				{
					Sd_sess_appts.Sd_sess_apptsLoseqnoRecord listOwner = sessionAppointment.LoseqnoCollection.get(i);
					if (listOwner.Loseqno.equals(form.getGlobalContext().CcoSched.Booking.getListOwner().Staff_no))
					{
						startTimeListOwner = GetTimeFromString(listOwner.Stm1);
						if (startTimeListOwner == null)
						{
							InternalError("start time for list owner is not supplied.");
							return;
						}

						endTimeListOwner = GetTimeFromString(listOwner.Etm1);
						if (endTimeListOwner == null)
						{
							InternalError("end time for list owner is not supplied.");
							return;
						}
						break;
					}
				}
				if (startTimeListOwner == null)
				{
					InternalError("list owner is not found.");
					return;
				}
			}
//			#endregion
//
//			#region 5. create slots
			boolean flag = true;
		
			if (sessionAppointment.Userrights.equals("-100"))
				flag = false;
			else if (form.getGlobalContext().CcoSched.Booking.getListOwner() != null && sessionAppointment.Userrights.equals("-101"))
				for(int j=0; j<sessionAppointment.LoseqnoCollection.count(); j++)
				{
					Sd_sess_appts.Sd_sess_apptsLoseqnoRecord listOwner = sessionAppointment.LoseqnoCollection.get(j);
					if (listOwner.Loseqno.equals(form.getGlobalContext().CcoSched.Booking.getListOwner().Staff_no))
					{
						Integer si = GetInteger(listOwner.Loremnoapp);
						if (si != null  && si.intValue() == 0)
							flag = false;
						break;
					}
				}
			if (flag)
			{
				int timeRequired = form.getGlobalContext().CcoSched.Booking.getTimeRequired().intValue();
				Time slotStartTime = new Time(startTime.getHour(), startTime.getMinute());
				while (true)
				{
					Time slotEndTime = new Time(slotStartTime.getHour(), slotStartTime.getMinute());
					slotEndTime.addMinutes(timeRequired);
					if (slotEndTime.isGreaterThan(endTime))
						break;

					flag = false;
					if (sessionAppointment.Userrights.equals("-102"))
						flag = true;
					else
					{
						if (form.getGlobalContext().CcoSched.Booking.getListOwner() == null)
							flag = true;
						else
						{
							if (startTimeListOwner.isLessOrEqualThan(slotStartTime) && slotStartTime.isLessThan(endTimeListOwner))
								flag = true;
							else
								slotStartTime = new Time(slotEndTime.getHour(), slotEndTime.getMinute());
						}
					}


					if (flag)
					{
						GenForm.ShowAvailabilityGridRow row = form.ShowAvailabilityGrid().getRows().newRow();
						row.setSlots(slotStartTime.toString(TimeFormat.DEFAULT));
						if (startTimeListOwner != null)
						{
							if (startTimeListOwner.isLessOrEqualThan(slotStartTime) && slotStartTime.isLessThan(endTimeListOwner))
								row.setBackColor(Color.LightYellow);
						}

						flag = true;
						for(int j=0; j<bookedPeriods.size(); j++)
						{
							Object[] bookedPeriod = (Object[])bookedPeriods.get(j);
							if (slotStartTime.isLessThan((Time)bookedPeriod[1]) && slotEndTime.isGreaterThan((Time)bookedPeriod[0]))
							{
								row.setStatus("Booked (" + bookedPeriod[2].toString() + ")");
								row.setBackColor((((Boolean)bookedPeriod[3]).booleanValue() ? Color.PaletTurquoise: Color.White));
								slotStartTime = new Time(((Time)bookedPeriod[1]).getHour(), ((Time)bookedPeriod[1]).getMinute());
								flag = false;
								break;
							}
						}
						if (flag)
						{
						
							for(int j=0; j<excludedPeriods.size(); j++)
							{
								Time[] excludedPeriod = (Time[])excludedPeriods.get(j);
								if (slotStartTime.isLessThan(excludedPeriod[1]) && slotEndTime.isGreaterThan(excludedPeriod[0]))
								{
									row.setStatus("Excluded");
									row.setBackColor(Color.LightGray);
									slotStartTime = new Time(excludedPeriod[1].getHour(),excludedPeriod[1].getMinute());
									flag = false;
									break;
								}
							}
							if (flag)
							{
								row.setStatus("Available");
								slotStartTime = new Time(slotEndTime.getHour(), slotEndTime.getMinute());
							}
						}
					}
				}
			}
		}
	}

	private void ShowControls(int state) {
		form.SetDefaultGrid().setVisible(state == 0);
		form.Pattern().setVisible(state == 0 || state == 2);
		form.Ok().setVisible(state == 0 || state == 2);
		//			Form.Cancel.Visible = state == 0;

		form.AvailabilityPattern().setVisible(state == 1);
		form.Refresh().setVisible(state == 1);

		form.ShowAvailabilityGrid().setVisible(state == 2);
	}
	
	private Integer GetInteger(String val)
	{
		Integer newVal = null;
		try{newVal = Integer.valueOf(val);}
		catch(NumberFormatException e)
		{e.printStackTrace();}

		return newVal;	
	}
	
	public class StringComparer implements Comparator
	{
		public int compare(Object x, Object y) 
		{
			return ((String)x).compareTo((String)y);
		}
	}
	
	public void InternalError(String message)
	{
		engine.showMessage("Internal error: " + message);
	}
	
	private int CompareTimes(Time t1, Time t2)
	{	
		int nSeconds1 = t1.getHour()*60 + t1.getMinute();
		int nSeconds2 = t2.getHour()*60 + t2.getMinute();
		if(nSeconds1 > nSeconds2)
			return 1;
		else if (nSeconds1 < nSeconds2)
			return -1;
		
		return 0;
	}
	
	private Time SubstractTimes(Time t1, Time t2)
	{
		int nMinutes1 = t1.getHour()*60 + t1.getMinute();
		int nMinutes2 = t2.getHour()*60 + t2.getMinute();
		int nMinutes  = nMinutes1-nMinutes2;
		if(nMinutes> 0)
		{
			return new Time(nMinutes%60, nMinutes-(nMinutes%60)*60);
		}
		
		return new Time(0,0);
	}
	
	private Time GetTimeFromString(String sTime)
	{
		Time time = null;
		try{time = new Time(sTime, TimeFormat.FLAT6);}catch(RuntimeException e){e.printStackTrace();}
		return time;
	}

	private Date minDate = new Date(1, 1, 1);//January 1, 0001
	private Date maxDate = new Date(9999, 12, 31);//31 December 9999
}