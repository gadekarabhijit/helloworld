package com.dreamland.core.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BaseModel
{
	@Column(name = "CREATED_DT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "UPDATED_DT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "RECORD_STATUS")
	private String recordStatus;

	@Column(name = "INSTITUTE_ID")
	private Long instituteId;

	public Date getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	public String getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate()
	{
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate)
	{
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy()
	{
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy)
	{
		this.updatedBy = updatedBy;
	}

	public String getRecordStatus()
	{
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus)
	{
		this.recordStatus = recordStatus;
	}

	public Long getInstituteId()
	{
		return instituteId;
	}

	public void setInstituteId(Long instituteId)
	{
		this.instituteId = instituteId;
	}

}

