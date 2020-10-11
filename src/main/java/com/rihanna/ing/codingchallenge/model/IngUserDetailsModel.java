package com.rihanna.ing.codingchallenge.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User_table")
public class IngUserDetailsModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	private String username;
	private String password;
	
	private boolean enabled;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private TitleEnum title;
	private String firstN;
	private String lastName;
	private GenderEnum gender;
	
	@ManyToOne
	private AddressModel address;

	
	public TitleEnum getTitle() {
		return title;
	}
	public void setTitle(TitleEnum title) {
		this.title = title;
	}
	public String getFirstN() {
		return firstN;
	}
	public void setFirstN(String firstN) {
		this.firstN = firstN;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public GenderEnum getGender() {
		return gender;
	}
	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}
	public AddressModel getAddress() {
		return address;
	}
	public void setAddress(AddressModel address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}

}
