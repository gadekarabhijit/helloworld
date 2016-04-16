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
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Abhijit
 * @Created Date : Oct 28, 2015
 */
@Entity
@Table(name = "COM_USER_ROLE")
public class UserRole extends BaseModel
{
	@Id
	@Column(name = "ROLE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(optional = true)
	@JoinColumn(name = "COM_USER_ID", nullable = false)
	@JsonProperty("comUserDetails") // used to map parent element
	@JsonBackReference
	private ComUserDetails comUserDetails;

	@Column(name = "ROLE_NAME")
	private String roleName;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public ComUserDetails getComUserDetails()
	{
		return comUserDetails;
	}

	public void setComUserDetails(ComUserDetails comUserDetails)
	{
		this.comUserDetails = comUserDetails;
	}

	public String getRoleName()
	{
		return roleName;
	}

	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}
}
