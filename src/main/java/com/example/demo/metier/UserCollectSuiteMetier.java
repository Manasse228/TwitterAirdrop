package com.example.demo.metier;


import java.util.List;

import com.example.demo.entity.UserCollectSuite;

public interface UserCollectSuiteMetier {
	
	public void saveUserCollect(UserCollectSuite userCollect);

	public UserCollectSuite getUserCollectByTwitter(String twitter);

	public UserCollectSuite getUserCollectByTelegram(String telegram);

	public UserCollectSuite getUserCollectByEtherAdresse(String etherAdresse);
	
	public List<UserCollectSuite> getAll();

}
