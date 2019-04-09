package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userCollectAirdrop2")
public class UserCollectAirdrop2 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(length = 225, name = "email", nullable = true, unique = false)
	private String email;

	@Column(length = 225, name = "telegram", nullable = true, unique = false)
	private String telegram;

	@Column(length = 225, name = "twitter", nullable = true, unique = false)
	private String twitter;

	@Column(length = 225, name = "referalName", nullable = true, unique = false)
	private String referalName;

	@Column(length = 225, name = "etherAdresse", nullable = true, unique = false)
	private String etherAdresse;

	@Column(length = 225, name = "mediumName", nullable = true, unique = false)
	private String mediumName;

	@Column(name = "balance", nullable = true)
	private int balance;

	public UserCollectAirdrop2() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelegram() {
		return telegram;
	}

	public void setTelegram(String telegram) {
		this.telegram = telegram;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getReferalName() {
		return referalName;
	}

	public void setReferalName(String referalName) {
		this.referalName = referalName;
	}

	public String getEtherAdresse() {
		return etherAdresse;
	}

	public void setEtherAdresse(String etherAdresse) {
		this.etherAdresse = etherAdresse;
	}

	public String getMediumName() {
		return mediumName;
	}

	public void setMediumName(String mediumName) {
		this.mediumName = mediumName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "UserCollectAirdrop2 [id=" + id + ", email=" + email + ", telegram=" + telegram + ", twitter=" + twitter
				+ ", referalName=" + referalName + ", etherAdresse=" + etherAdresse + ", mediumName=" + mediumName
				+ ", balance=" + balance + "]";
	}

}
