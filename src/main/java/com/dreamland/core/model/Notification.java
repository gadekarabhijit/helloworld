package com.dreamland.core.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.dreamland.utility.JsonDateDeserializer;
import com.dreamland.utility.JsonDateSerializer;

@Entity
@Table(name = "COM_NOTIFICATIONS")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "notificationId")
public class Notification extends BaseModel implements java.io.Serializable
{
	private static final long serialVersionUID = 1085165961751982130L;

	@Id
	@Column(name = "NOTIFICATION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer notificationId;

	@Column(name = "NOTIFICATION_HEADLINE")
	private String notificatiosHeadline;

	@Column(name = "NOTIFICATION_DETAILS")
	private String notificationDetails;

	@Column(name = "STATUS_VID")
	private Integer notificatioStatus;

	@Column(name = "NOTIFICATION_TYPE_VID")
	private Integer notificationType;

	public String getGroups()
	{
		return groups;
	}

	public void setGroups(String groups)
	{
		this.groups = groups;
	}

	@Column(name = "GROUPS")
	private String groups;

	@Column(name = "NOTIFICATION_FROM_DT")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using = JsonDateSerializer.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date notificationFromDate = new Date();

	@Column(name = "NOTIFICATION_TO_DT")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using = JsonDateSerializer.class)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date notificationToDate;

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "notification")
	private Set<NotificationFiles> notificationFiles = new HashSet<NotificationFiles>();

	public Integer getNotificationId()
	{
		return notificationId;
	}

	public void setNotificationId(Integer notificationId)
	{
		this.notificationId = notificationId;
	}

	public String getNotificatiosHeadline()
	{
		return notificatiosHeadline;
	}

	public void setNotificatiosHeadline(String notificatiosHeadline)
	{
		this.notificatiosHeadline = notificatiosHeadline;
	}

	public String getNotificatiosDetails()
	{
		return notificationDetails;
	}

	public void setNotificatiosDetails(String notificatiosDetails)
	{
		this.notificationDetails = notificatiosDetails;
	}

	public Integer getNotificatioStatus()
	{
		return notificatioStatus;
	}

	public void setNotificatioStatus(Integer notificatioStatus)
	{
		this.notificatioStatus = notificatioStatus;
	}

	public Date getNotificationFromDate()
	{
		return notificationFromDate;
	}

	public void setNotificationFromDate(Date notificationFromDate)
	{
		this.notificationFromDate = notificationFromDate;
	}

	public Date getNotificationToDate()
	{
		return notificationToDate;
	}

	public void setNotificationToDate(Date notificationToDate)
	{
		this.notificationToDate = notificationToDate;
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

	public Set<NotificationFiles> getNotificationFiles()
	{
		return notificationFiles;
	}

	public void setNotificationFiles(Set<NotificationFiles> notificationFiles)
	{
		this.notificationFiles = notificationFiles;
	}

	@Override
	public String toString()
	{
		return "Notification [notificationId=" + notificationId + ", notificatiosHeadline=" + notificatiosHeadline
				+ ", notificationDetails=" + notificationDetails + ", notificatioStatus=" + notificatioStatus
				+ ", notificationType=" + notificationType + ", groups=" + groups + ", notificationFromDate="
				+ notificationFromDate + ", notificationToDate=" + notificationToDate + ", notificationFiles="
				+ notificationFiles + "]";
	}

	public Integer getNotificationType()
	{
		return notificationType;
	}

	public void setNotificationType(Integer notificationType)
	{
		this.notificationType = notificationType;
	}

	public String getNotificationDetails()
	{
		return notificationDetails;
	}
}
