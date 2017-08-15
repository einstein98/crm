package com.heima.crm.domain;
// Generated 2017-8-10 19:52:50 by Hibernate Tools 3.2.2.GA

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name = "customers", catalog = "mybos")
@XmlRootElement
public class Customer implements java.io.Serializable {

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", telephone=" + telephone + ", address=" + address
				+ ", station=" + station + ", decidedzoneId=" + decidedzoneId + ", password=" + password + ", email="
				+ email + "]";
	}

	private Integer id;
	private String name;
	private String telephone;
	private String address;
	private String station;
	private String decidedzoneId;
	private String password;
	private String email;

	@Column(name = "PASSWORD", nullable = false)
	public String getPassword() {
		return password;
	}

	@Column(name = "EMAIL", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Customer() {
	}

	public Customer(String name, String telephone, String address) {
		this.name = name;
		this.telephone = telephone;
		this.address = address;
	}

	public Customer(String name, String telephone, String address, String station, String decidedzoneId) {
		this.name = name;
		this.telephone = telephone;
		this.address = address;
		this.station = station;
		this.decidedzoneId = decidedzoneId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "NAME", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "TELEPHONE", nullable = false, length = 20)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "STATION")
	public String getStation() {
		return this.station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	@Column(name = "DECIDEDZONE_ID", length = 32)
	public String getDecidedzoneId() {
		return this.decidedzoneId;
	}

	public void setDecidedzoneId(String decidedzoneId) {
		this.decidedzoneId = decidedzoneId;
	}

}
