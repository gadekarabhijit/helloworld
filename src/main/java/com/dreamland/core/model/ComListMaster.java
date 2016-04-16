package com.dreamland.core.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.security.crypto.codec.Base64;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "COM_LIST_MST")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "listId")
@JsonIgnoreProperties(
{ "hibernateLazyInitializer", "handler" })

public class ComListMaster extends BaseModel implements java.io.Serializable
{
	private static final long serialVersionUID = 1117935444961302329L;

	@Id
	@Column(name = "LIST_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer listId;

	@Column(name = "LIST_DESC")
	private String description;

	@Column(name = "LIST_VALUE")
	private String value;

	@Column(name = "URL")
	private String url;

	@Column(name = "LOGO", unique = false, length = 100000)
	private byte[] logo;

	// @JsonProperty("comListDetails")
	// @JsonBackReference
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	// @JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instituteInfotMaster", cascade = CascadeType.ALL)
	private Set<ComListDetails> comListDetails = new HashSet<ComListDetails>();

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

	public Integer getListId()
	{
		return listId;
	}

	public void setListId(Integer listId)
	{
		this.listId = listId;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	/*
	 * public Date getCreatedDate() { return createdDate; }
	 *
	 * public void setCreatedDate(Date createdDate) { this.createdDate =
	 * createdDate; }
	 *
	 * public String getCreatedBy() { return createdBy; }
	 *
	 * public void setCreatedBy(String createdBy) { this.createdBy = createdBy;
	 * }
	 *
	 * public Date getUpdatedDate() { return updatedDate; }
	 *
	 * public void setUpdatedDate() { this.updatedDate = new Date(); }
	 *
	 * public String getUpdatedBy() { return updatedBy; }
	 *
	 * public void setUpdatedBy(String updatedBy) { this.updatedBy = updatedBy;
	 * }
	 *
	 * public String getRecordStatus() { return recordStatus; }
	 *
	 * public void setActiveRecordStatus() { this.recordStatus = "A"; }
	 *
	 * public void deleteRecord() { this.recordStatus = "D"; }/
	 */

	public Set<ComListDetails> getInstituteInfoDetails()
	{
		return comListDetails;
	}

	public void setInstituteInfoDetails(Set<ComListDetails> comListDetails)
	{
		for (ComListDetails ins : comListDetails)
		{
			ins.setInstituteInfotMaster(this);
		}
		this.comListDetails = comListDetails;
	}

	public byte[] getLogo()
	{
		return logo;
	}

	public void setLogo(byte[] logo)
	{
		this.logo = logo;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	@Override
	public String toString()
	{
		return "ComListMatster [listId=" + listId + ", description=" + description + ", value=" + value + ", url="
				+ url + ", comListDetails=" + comListDetails + ", createdDate=" + "" + ", createdBy=" + ""
				+ ", updatedDate=" + "" + ", updatedBy=" + "" + ", recordStatus=" + "" + "]";
	}

	public String getByteArrayString()
	{
		if (this.logo != null)
		{
			return new String(Base64.encode(this.logo));
		} else
		{
			return "";
		}
	}

}
