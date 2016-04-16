package com.dreamland.core.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "COM_LIST_DETAILS")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "listDtlId")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties(
{ "hibernateLazyInitializer", "handler" })
public class ComListDetails extends BaseModel implements java.io.Serializable
{
	private static final long serialVersionUID = 767478073758506591L;

	@Id
	@Column(name = "LIST_DTL_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer listDtlId;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "LIST_ID", nullable = false)
	// @JsonManagedReference
	// @Fetch(FetchMode.JOIN)
	private ComListMaster comListMaster;

	@Column(name = "LIST_DTL_VALUE")
	private String value;

	@Column(name = "LIST_DTL_DESC", length = 5000)
	private String description;

	@Column(name = "STRING1", length = 5000)
	private String string1;

	@Column(name = "STRING2", length = 5000)
	private String string2;

	@Column(name = "STRING3", length = 5000)
	private String string3;

	@Column(name = "SEQUENCE_NO")
	private Integer sequenceNo;

	@Column(name = "NUMBER1")
	private Double number1;

	@Column(name = "NUMBER2")
	private Double number2;

	@Column(name = "NUMBER3")
	private Double number3;

	@Column(name = "DOCUMENT", unique = false, length = 100000)
	private byte[] document;

	@Column(name = "DOCUMENT_TYPE", length = 1)
	private Integer documentType;

	@Column(name = "DOCUMENT1", unique = false, length = 100000)
	private byte[] document1;

	@Column(name = "DOCUMENT1_TYPE", length = 1)
	private Integer document1Type;

	@Column(name = "DOCUMENT2", unique = false, length = 100000)
	private byte[] document2;

	@Column(name = "DOCUMENT2_TYPE", length = 1)
	private Integer document2Type;

	public Integer getListDtlId()
	{
		return listDtlId;
	}

	public void setListDtlId(Integer listDtlId)
	{
		this.listDtlId = listDtlId;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public ComListMaster getInstituteInfotMaster()
	{
		return comListMaster;
	}

	public void setInstituteInfotMaster(ComListMaster comListMaster)
	{
		this.comListMaster = comListMaster;
	}

	public String getString1()
	{
		return string1;
	}

	public void setString1(String string1)
	{
		this.string1 = string1;
	}

	public String getString2()
	{
		return string2;
	}

	public void setString2(String string2)
	{
		this.string2 = string2;
	}

	public String getString3()
	{
		return string3;
	}

	public void setString3(String string3)
	{
		this.string3 = string3;
	}

	public Integer getSequenceNo()
	{
		return sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo)
	{
		this.sequenceNo = sequenceNo;
	}

	public Double getNumber1()
	{
		return number1;
	}

	public void setNumber1(Double number1)
	{
		this.number1 = number1;
	}

	public Double getNumber2()
	{
		return number2;
	}

	public void setNumber2(Double number2)
	{
		this.number2 = number2;
	}

	public Double getNumber3()
	{
		return number3;
	}

	public void setNumber3(Double number3)
	{
		this.number3 = number3;
	}

	public byte[] getDocument()
	{
		return document;
	}

	public void setDocument(byte[] document)
	{
		this.document = document;
	}

	public Integer getDocumentType()
	{
		return documentType;
	}

	public void setDocumentType(Integer documentType)
	{
		this.documentType = documentType;
	}

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

	@Override
	public String toString()
	{
		return "ComListDetails [listDtlId=" + listDtlId + ", comListMaster=" + "" + ", value=" + value
				+ ", description=" + description + ", string1=" + string1 + ", string2=" + string2 + ", string3="
				+ string3 + ", sequenceNo=" + sequenceNo + ", number1=" + number1 + ", number2=" + number2
				+ ", number3=" + number3 + ", documentType=" + documentType + ", document1Type=" + document1Type
				+ ", document2Type=" + document2Type + ", createdDate=" + "" + ", createdBy=" + "" + ", updatedDate="
				+ "" + ", updatedBy=" + "" + ", recordStatus=" + "" + "]";
	}

}
