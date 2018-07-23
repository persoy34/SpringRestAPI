package com.perihan.spring.rest.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="User")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "User")
public class User implements Serializable{
	
	private static final long serialVersionUID = -1232395859408322338L;

	
	@ManyToMany(cascade = CascadeType.ALL)
	   @JoinTable(name = "User_Country", 
	         joinColumns = { @JoinColumn(name = "USER_ID") }, 
	         inverseJoinColumns = { @JoinColumn(name = "COUNTRY_ID") })
	private Set<Country>  country= new HashSet<>();
	
	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name = "USER_ID")
	   private long id;

	@Column(name="userName")
	private String userName;
	
	@Column(name="userSurname")
	private String userSurname;
	
	@Column(name="userMiddleName")
	private String userMiddlename;
	
	@Column(name="userAddress")
	private String userAddress;
	
	@Column(name="userPhone")
	private String userPhone;
	
	public User() {
		
	}
	
	public User(Long id,String userName, String userSurname, String userMiddlename, String userAddress, String userPhone ) {
		this.id = id;
		this.userName = userName;
		this.userSurname = userSurname;
		this.userMiddlename = userMiddlename;
		this.userAddress = userAddress;
		this.userPhone = userPhone;
	}
	@ManyToOne(cascade=CascadeType.ALL, 
			fetch = FetchType.LAZY)
	public Set<Country> getCountry() {
		return country;
	}

	public void setCountry(Set<Country> country) {
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}

	public String getUserMiddlename() {
		return userMiddlename;
	}

	public void setUserMiddleName(String userMiddlename) {
		this.userMiddlename = userMiddlename;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

}
