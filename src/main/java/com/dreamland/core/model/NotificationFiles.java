package com.dreamland.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "COM_NOTIFICATION_FILES")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "fileId")
public class NotificationFiles extends BaseModel implements java.io.Serializable
{
	private static final long serialVersionUID = -6300657122287161773L;

	@Id
	@Column(name = "FILE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fileId;

	@Column(name = "DATA_FILE")
	private byte[] file;

	@Column(name = "DATA_FILE_TYPE", length = 1)
	private Integer datafileType;

	@Column(name = "DOCUMENT1", unique = false, length = 100000)
	private byte[] document1;

	@Column(name = "DOCUMENT1_TYPE", length = 1)
	private Integer document1Type;

	@Column(name = "DOCUMENT2", unique = false, length = 100000)
	private byte[] document2;

	@Column(name = "DOCUMENT2_TYPE", length = 1)
	private Integer document2Type;

	@ManyToOne
	@JoinColumn(name = "NOTIFICATION_ID", nullable = false)
	Notification notification;

	@Column(name = "STRING1", length = 5000)
	private String string1;

	@Column(name = "STRING2", length = 5000)
	private String string2;

	/*
	 * @Column(name = "CREATED_DT")
	 *
	 * @Temporal(TemporalType.TIMESTAMP) private Date createdDate = new Date();
	 *
	 * @Column(name = "CREATED_BY") private String createdBy;
	 *
	 * /*@Column(name = "UPDATED_DT")
	 *
	 * @Temporal(TemporalType.TIMESTAMP) private Date updatedDate;
	 *
	 * @Column(name = "UPDATED_BY") private String updatedBy;
	 *
	 * @Column(name = "RECORD_STATUS") private String recordStatus = "A";
	 */

	public Integer getFileId()
	{
		return fileId;
	}

	public void setFileId(Integer fileId)
	{
		this.fileId = fileId;
	}

	public byte[] getFile()
	{
		return file;
	}

	public void setFile(byte[] file)
	{
		this.file = file;
	}

	public Notification getNotification()
	{
		return notification;
	}

	public void setNotification(Notification notification)
	{
		this.notification = notification;
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

	public byte[] getDocument1()
	{
		return document1;
	}

	public void setDocument1(byte[] document1)
	{
		this.document1 = document1;
	}

	public Integer getDocument1Type()
	{
		return document1Type;
	}

	public void setDocument1Type(Integer document1Type)
	{
		this.document1Type = document1Type;
	}

	public byte[] getDocument2()
	{
		return document2;
	}

	public void setDocument2(byte[] document2)
	{
		this.document2 = document2;
	}

	public Integer getDocument2Type()
	{
		return document2Type;
	}

	public void setDocument2Type(Integer document2Type)
	{
		this.document2Type = document2Type;
	}

	public Integer getDatafileType()
	{
		return datafileType;
	}

	public void setDatafileType(Integer datafileType)
	{
		this.datafileType = datafileType;
	}

}
