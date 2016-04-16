package com.dreamland.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "COM_DEVICE_DETAILS")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "deviceDetailId")
public class DeviceDetails extends BaseModel implements java.io.Serializable
{
	private static final long serialVersionUID = 3576776261941465947L;

	@Id
	@Column(name = "DEVICE_DTL_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deviceDetailId;

	@ManyToOne(optional = true)
	@JoinColumn(name = "COM_USER_ID", nullable = false)
	@JsonProperty("comUserDetails") // used to map parent element
	@JsonBackReference
	private ComUserDetails comUserDetails;

	@Column(name = "DEVICE_ID", nullable = false)
	private String deviceId;

	@Column(name = "DEVICE_MODEL")
	private String deviceModel;

	@Column(name = "DEVICE_TYPE")
	private Integer deviceType;

	/*
	 * @Column(name = "CREATED_DT")
	 *
	 * @Temporal(TemporalType.TIMESTAMP) private Date createdDate = new Date();
	 *
	 * @Column(name = "CREATED_BY") private String createdBy;
	 *
	 * @Column(name = "UPDATED_DT")
	 *
	 * @Temporal(TemporalType.TIMESTAMP) private Date updatedDate;
	 *
	 * @Column(name = "UPDATED_BY") private String updatedBy;
	 *
	 * @Column(name = "RECORD_STATUS") private String recordStatus = "A";
	 */

	public ComUserDetails getComUserDetails()
	{
		return comUserDetails;
	}

	public void setComUserDetails(ComUserDetails comUserDetails)
	{
		this.comUserDetails = comUserDetails;
	}

	public Integer getDeviceDetailId()
	{
		return deviceDetailId;
	}

	public void setDeviceDetailId(Integer deviceDetailId)
	{
		this.deviceDetailId = deviceDetailId;
	}

	public String getDeviceId()
	{
		return deviceId;
	}

	public void setDeviceId(String deviceId)
	{
		this.deviceId = deviceId;
	}

	public String getDeviceModel()
	{
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel)
	{
		this.deviceModel = deviceModel;
	}

	/*
	 * @Override public Date getCreatedDate() { return createdDate; }
	 *
	 * @Override public void setCreatedDate(Date createdDate) { this.createdDate
	 * = createdDate; }
	 *
	 * @Override public String getCreatedBy() { return createdBy; }
	 *
	 * @Override public void setCreatedBy(String createdBy) { this.createdBy =
	 * createdBy; }
	 *
	 * @Override public Date getUpdatedDate() { return updatedDate; }
	 *
	 * @Override public void setUpdatedDate(Date updatedDate) { this.updatedDate
	 * = updatedDate; }
	 *
	 * @Override public String getUpdatedBy() { return updatedBy; }
	 *
	 * @Override public void setUpdatedBy(String updatedBy) { this.updatedBy =
	 * updatedBy; }
	 *
	 * @Override public String getRecordStatus() { return recordStatus; }
	 *
	 * @Override public void setRecordStatus(String recordStatus) {
	 * this.recordStatus = recordStatus; }
	 */

	public Integer getDeviceType()
	{
		return deviceType;
	}

	public void setDeviceType(Integer deviceType)
	{
		this.deviceType = deviceType;
	}

	@Override
	public String toString()
	{
		return "DeviceDetails [deviceDetailId=" + deviceDetailId + ", comUserDetails=" + comUserDetails + ", deviceId="
				+ deviceId + ", deviceModel=" + deviceModel + ", deviceType=" + deviceType + "]";
	}

}
