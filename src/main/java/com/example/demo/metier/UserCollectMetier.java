package com.example.demo.metier;

import java.util.List;

import com.example.demo.entity.UserCollect;

public interface UserCollectMetier {

	public void saveUserCollect(UserCollect userCollect);

	public UserCollect getUserCollectByTwitter(String twitter);

	public UserCollect getUserCollectByTelegram(String telegram);

	public UserCollect getUserCollectByEtherAdresse(String etherAdresse);
	
	public List<UserCollect> getAll();

}
