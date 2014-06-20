// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.beans;

public class ReferralDischargeVoBean extends ims.vo.ValueObjectBean
{
	public ReferralDischargeVoBean()
	{
	}
	public ReferralDischargeVoBean(ims.RefMan.vo.ReferralDischargeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dischargetype = vo.getDischargeType() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeType().getBean();
		this.furthermanagement = vo.getFurtherManagement();
		this.dischargeothertype = vo.getDischargeOtherType() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeOtherType().getBean();
		this.otherdetails = vo.getOtherDetails();
		this.currentonwardreferral = vo.getCurrentOnwardReferral() == null ? null : (ims.RefMan.vo.beans.OnwardReferralVoBean)vo.getCurrentOnwardReferral().getBean();
		this.onwardreferrals = vo.getOnwardReferrals() == null ? null : vo.getOnwardReferrals().getBeanCollection();
		this.dischargedate = vo.getDischargeDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDischargeDate().getBean();
		this.recordinginformation = vo.getRecordingInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getRecordingInformation().getBean();
		this.discharginghcp = vo.getDischargingHCP() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getDischargingHCP().getBean();
		if(vo.getResultsForReport() != null)
		{
			this.resultsforreport = new ims.vo.RefVoBean[vo.getResultsForReport().size()];
			for(int resultsforreport_i = 0; resultsforreport_i < vo.getResultsForReport().size(); resultsforreport_i++)
			{
				this.resultsforreport[resultsforreport_i] = new ims.vo.RefVoBean(vo.getResultsForReport().get(resultsforreport_i).getBoId(),vo.getResultsForReport().get(resultsforreport_i).getBoVersion());
			}
		}
		if(vo.getDiagnosisForReport() != null)
		{
			this.diagnosisforreport = new ims.vo.RefVoBean[vo.getDiagnosisForReport().size()];
			for(int diagnosisforreport_i = 0; diagnosisforreport_i < vo.getDiagnosisForReport().size(); diagnosisforreport_i++)
			{
				this.diagnosisforreport[diagnosisforreport_i] = new ims.vo.RefVoBean(vo.getDiagnosisForReport().get(diagnosisforreport_i).getBoId(),vo.getDiagnosisForReport().get(diagnosisforreport_i).getBoVersion());
			}
		}
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.ReferralDischargeVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dischargetype = vo.getDischargeType() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeType().getBean();
		this.furthermanagement = vo.getFurtherManagement();
		this.dischargeothertype = vo.getDischargeOtherType() == null ? null : (ims.vo.LookupInstanceBean)vo.getDischargeOtherType().getBean();
		this.otherdetails = vo.getOtherDetails();
		this.currentonwardreferral = vo.getCurrentOnwardReferral() == null ? null : (ims.RefMan.vo.beans.OnwardReferralVoBean)vo.getCurrentOnwardReferral().getBean(map);
		this.onwardreferrals = vo.getOnwardReferrals() == null ? null : vo.getOnwardReferrals().getBeanCollection();
		this.dischargedate = vo.getDischargeDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDischargeDate().getBean();
		this.recordinginformation = vo.getRecordingInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getRecordingInformation().getBean(map);
		this.discharginghcp = vo.getDischargingHCP() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getDischargingHCP().getBean(map);
		if(vo.getResultsForReport() != null)
		{
			this.resultsforreport = new ims.vo.RefVoBean[vo.getResultsForReport().size()];
			for(int resultsforreport_i = 0; resultsforreport_i < vo.getResultsForReport().size(); resultsforreport_i++)
			{
				this.resultsforreport[resultsforreport_i] = new ims.vo.RefVoBean(vo.getResultsForReport().get(resultsforreport_i).getBoId(),vo.getResultsForReport().get(resultsforreport_i).getBoVersion());
			}
		}
		if(vo.getDiagnosisForReport() != null)
		{
			this.diagnosisforreport = new ims.vo.RefVoBean[vo.getDiagnosisForReport().size()];
			for(int diagnosisforreport_i = 0; diagnosisforreport_i < vo.getDiagnosisForReport().size(); diagnosisforreport_i++)
			{
				this.diagnosisforreport[diagnosisforreport_i] = new ims.vo.RefVoBean(vo.getDiagnosisForReport().get(diagnosisforreport_i).getBoId(),vo.getDiagnosisForReport().get(diagnosisforreport_i).getBoVersion());
			}
		}
	}

	public ims.RefMan.vo.ReferralDischargeVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.ReferralDischargeVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.ReferralDischargeVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.ReferralDischargeVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.ReferralDischargeVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.vo.LookupInstanceBean getDischargeType()
	{
		return this.dischargetype;
	}
	public void setDischargeType(ims.vo.LookupInstanceBean value)
	{
		this.dischargetype = value;
	}
	public String getFurtherManagement()
	{
		return this.furthermanagement;
	}
	public void setFurtherManagement(String value)
	{
		this.furthermanagement = value;
	}
	public ims.vo.LookupInstanceBean getDischargeOtherType()
	{
		return this.dischargeothertype;
	}
	public void setDischargeOtherType(ims.vo.LookupInstanceBean value)
	{
		this.dischargeothertype = value;
	}
	public String getOtherDetails()
	{
		return this.otherdetails;
	}
	public void setOtherDetails(String value)
	{
		this.otherdetails = value;
	}
	public ims.RefMan.vo.beans.OnwardReferralVoBean getCurrentOnwardReferral()
	{
		return this.currentonwardreferral;
	}
	public void setCurrentOnwardReferral(ims.RefMan.vo.beans.OnwardReferralVoBean value)
	{
		this.currentonwardreferral = value;
	}
	public ims.RefMan.vo.beans.OnwardReferralVoBean[] getOnwardReferrals()
	{
		return this.onwardreferrals;
	}
	public void setOnwardReferrals(ims.RefMan.vo.beans.OnwardReferralVoBean[] value)
	{
		this.onwardreferrals = value;
	}
	public ims.framework.utils.beans.DateBean getDischargeDate()
	{
		return this.dischargedate;
	}
	public void setDischargeDate(ims.framework.utils.beans.DateBean value)
	{
		this.dischargedate = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getRecordingInformation()
	{
		return this.recordinginformation;
	}
	public void setRecordingInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.recordinginformation = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getDischargingHCP()
	{
		return this.discharginghcp;
	}
	public void setDischargingHCP(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.discharginghcp = value;
	}
	public ims.vo.RefVoBean[] getResultsForReport()
	{
		return this.resultsforreport;
	}
	public void setResultsForReport(ims.vo.RefVoBean[] value)
	{
		this.resultsforreport = value;
	}
	public ims.vo.RefVoBean[] getDiagnosisForReport()
	{
		return this.diagnosisforreport;
	}
	public void setDiagnosisForReport(ims.vo.RefVoBean[] value)
	{
		this.diagnosisforreport = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean dischargetype;
	private String furthermanagement;
	private ims.vo.LookupInstanceBean dischargeothertype;
	private String otherdetails;
	private ims.RefMan.vo.beans.OnwardReferralVoBean currentonwardreferral;
	private ims.RefMan.vo.beans.OnwardReferralVoBean[] onwardreferrals;
	private ims.framework.utils.beans.DateBean dischargedate;
	private ims.core.vo.beans.AuthoringInformationVoBean recordinginformation;
	private ims.core.vo.beans.AuthoringInformationVoBean discharginghcp;
	private ims.vo.RefVoBean[] resultsforreport;
	private ims.vo.RefVoBean[] diagnosisforreport;
}
