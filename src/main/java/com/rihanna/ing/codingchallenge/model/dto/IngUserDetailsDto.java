package com.rihanna.ing.codingchallenge.model.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rihanna.ing.codingchallenge.model.AddressModel;
import com.rihanna.ing.codingchallenge.model.GenderEnum;
import com.rihanna.ing.codingchallenge.model.IngUserDetailsModel;
import com.rihanna.ing.codingchallenge.model.TitleEnum;

public class IngUserDetailsDto implements UserDetails {

//	@JsonIgnore
	private long userId;
	private String username;
	
	@JsonIgnore
	private String password;

	@JsonIgnore
	private List<GrantedAuthority> authorities;

	@JsonIgnore
	private boolean enabled;

	@JsonIgnore
	private boolean accountNonExpired;

	@JsonIgnore
	private boolean accountNonLocked;

	@JsonIgnore
	private boolean credentialsNonExpired;
	private TitleEnum title;
	private String firstN;
	private String lastName;
	private GenderEnum gender;
	private AddressModel address;
	private String role;
	
	public IngUserDetailsDto() {}
	
	public IngUserDetailsDto(IngUserDetailsModel iuld) {
		this.userId = iuld.getUserId();
		this.accountNonExpired = iuld.isAccountNonExpired();
		this.accountNonLocked = iuld.isAccountNonLocked();
		this.credentialsNonExpired = iuld.isCredentialsNonExpired();
		this.enabled = iuld.isEnabled();
		this.username = iuld.getUsername();
		this.address = iuld.getAddress();
		this.gender = iuld.getGender();
		this.lastName = iuld.getLastName();
		this.firstN = iuld.getFirstN();
		this.title = iuld.getTitle();
		this.password = iuld.getPassword();
		this.role = iuld.getRole();
		this.authorities = getAuthorities();
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

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
	@Override
	public List<GrantedAuthority> getAuthorities() {
		if (this.role != null) {
			List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
	        list.add(new SimpleGrantedAuthority(role));
	        return list;
		}
		else
			return Collections.EMPTY_LIST;
		
	}
	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
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
}
