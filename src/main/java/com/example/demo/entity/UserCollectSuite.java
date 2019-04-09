package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userCollectSuite")
public class UserCollectSuite { // WTXHubbotAirdrop1Suite.xlsx

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(length = 225, name = "twitter", nullable = true, unique = false)
	private String twitter;

	@Column(length = 225, name = "telegram", nullable = true, unique = false)
	private String telegram;

	@Column(length = 225, name = "etherAdresse", nullable = true, unique = false)
	private String etherAdresse;

	@Column(length = 225, name = "email", nullable = true, unique = false)
	private String email;

	@Column(name = "balance", nullable = true)
	private int balance;

	public UserCollectSuite() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getTelegram() {
		return telegram;
	}

	public void setTelegram(String telegram) {
		this.telegram = telegram;
	}

	public String getEtherAdresse() {
		return etherAdresse;
	}

	public void setEtherAdresse(String etherAdresse) {
		this.etherAdresse = etherAdresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "UserCollectSuite [id=" + id + ", twitter=" + twitter + ", telegram=" + telegram + ", etherAdresse="
				+ etherAdresse + ", email=" + email + ", balance=" + balance + "]";
	}

}
