package com.dreamland.core.model;

import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "COM_CLIENT_NAME")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ComClientName extends BaseModel implements java.io.Serializable
{
	private static final long serialVersionUID = 128582936512040142L;

	@Id
	@Column(name = "CLIENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comClientName", cascade = CascadeType.ALL)
	private Set<ComClientAddress> comClientAddresses = new HashSet<ComClientAddress>();

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "comClientName", cascade = CascadeType.ALL)
	private ComUserDetails comUserDetails;

	/*
	 * @OneToOne(fetch = FetchType.LAZY, mappedBy = "comClientName", cascade =
	 * CascadeType.PERSIST) private Student student;
	 */

	@Column(name = "SALUTATION")
	private Integer salutation;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "REMARK_ID")
	private String remark;

	@Column(name = "WEIGHT_UNIT")
	private Integer weightUnit;

	@Column(name = "WEIGHT", precision = 3, scale = 2)
	private Double weight;

	@Column(name = "HEIGHT_UNIT")
	private Integer heightUnit;

	@Column(name = "HEIGHT", precision = 3, scale = 2)
	private Double height;

	@Column(name = "IDENTIFICATION_MARK")
	private String identificationMark;

	@Column(name = "AGE", length = 3)
	private Integer age;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_OF_BIRTH")
	private Date dateOfBirth;

	@Column(name = "GENDER", length = 5)
	private Integer gender;

	@Column(name = "CONTACT_NOS", length = 100)
	private String contactNos;

	@Column(name = "IS_HANDICAPED", length = 3)
	private Integer isHandicaped;

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

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Set<ComClientAddress> getComClientAddresses()
	{
		return comClientAddresses;
	}

	public void setComClientAddresses(Set<ComClientAddress> comClientAddresses)
	{
		this.comClientAddresses = comClientAddresses;
	}

	public ComUserDetails getComUserDetails()
	{
		return comUserDetails;
	}

	public void setComUserDetails(ComUserDetails comUserDetails)
	{
		this.comUserDetails = comUserDetails;
		this.comUserDetails.setComClientName(this);
	}

	public Integer getSalutation()
	{
		return salutation;
	}

	/*
	 * public Student getStudent() { return student; }
	 *
	 * public void setStudent(Student student) { this.student = student; }
	 */

	public void setSalutation(Integer salutation)
	{
		this.salutation = salutation;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getMiddleName()
	{
		return middleName;
	}

	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}

	public String getEmailId()
	{
		return emailId;
	}

	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public Integer getWeightUnit()
	{
		return weightUnit;
	}

	public void setWeightUnit(Integer weightUnit)
	{
		this.weightUnit = weightUnit;
	}

	public Double getWeight()
	{
		return weight;
	}

	public void setWeight(Double weight)
	{
		this.weight = weight;
	}

	public Integer getHeightUnit()
	{
		return heightUnit;
	}

	public void setHeightUnit(Integer heightUnit)
	{
		this.heightUnit = heightUnit;
	}

	public Double getHeight()
	{
		return height;
	}

	public void setHeight(Double height)
	{
		this.height = height;
	}

	public String getIdentificationMark()
	{
		return identificationMark;
	}

	public void setIdentificationMark(String identificationMark)
	{
		this.identificationMark = identificationMark;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	public Date getDateOfBirth()
	{
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getGender()
	{
		return gender;
	}

	public void setGender(Integer gender)
	{
		this.gender = gender;
	}

	public String getContactNos()
	{
		return contactNos;
	}

	public void setContactNos(String contactNos)
	{
		this.contactNos = contactNos;
	}

	public Integer getIsHandicaped()
	{
		return isHandicaped;
	}

	public void setIsHandicaped(Integer isHandicaped)
	{
		this.isHandicaped = isHandicaped;
	}

	@Override
	public String toString()
	{
		return "ComClientName [id=" + id + ", comClientAddresses=" + comClientAddresses + ", comUserDetails="
				+ comUserDetails + ", salutation=" + salutation + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", middleName=" + middleName + ", emailId=" + emailId + ", remark=" + remark + ", weightUnit="
				+ weightUnit + ", weight=" + weight + ", heightUnit=" + heightUnit + ", height=" + height
				+ ", identificationMark=" + identificationMark + ", age=" + age + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", contactNos=" + contactNos + ", isHandicaped=" + isHandicaped + "]";
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
	 *
	 * @Override public void setRecordStatus(String recordStatus) {
	 * this.recordStatus = recordStatus; }
	 */

}
