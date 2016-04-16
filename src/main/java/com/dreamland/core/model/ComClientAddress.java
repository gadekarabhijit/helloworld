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
@Table(name = "COM_CLIENT_ADDDRESS")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ComClientAddress extends BaseModel implements java.io.Serializable
{
	private static final long serialVersionUID = -5905521962310018939L;

	@Id
	@Column(name = "CLIENT_ADDRESS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "CLIENT_ID", nullable = false)
	private ComClientName comClientName;

	@Column(name = "CITY")
	private String city;

	@Column(name = "ADDRESS1")
	private String address1;

	@Column(name = "ADDRESS2")
	private String address2;

	@Column(name = "ADDRESS3")
	private String address3;

	@Column(name = "STATE")
	private String state;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "POSTALCODE")
	private String postalCode;

	@Column(name = "IS_ACTIVE")
	private Integer isActive;

	@Column(name = "IS_PRIMARY", length = 4)
	private Integer isPrimary;

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
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public ComClientName getComClientName()
	{
		return comClientName;
	}

	public void setComClientName(ComClientName comClientName)
	{
		this.comClientName = comClientName;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getAddress1()
	{
		return address1;
	}

	public void setAddress1(String address1)
	{
		this.address1 = address1;
	}

	public String getAddress2()
	{
		return address2;
	}

	public void setAddress2(String address2)
	{
		this.address2 = address2;
	}

	public String getAddress3()
	{
		return address3;
	}

	public void setAddress3(String address3)
	{
		this.address3 = address3;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getPostalCode()
	{
		return postalCode;
	}

	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
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

	public void setIsActive(Integer isActive)
	{
		this.isActive = isActive;
	}

	public void setIsPrimary(Integer isPrimary)
	{
		this.isPrimary = isPrimary;
	}
}
