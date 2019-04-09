package com.example.demo.metier;


import java.util.List;

import com.example.demo.entity.UserCollectAirdrop2;


public interface UserCollectAirdrop2Metier {
	
	public void saveUserCollect(UserCollectAirdrop2 userCollect);

	public UserCollectAirdrop2 getUserCollectByTwitter(String twitter);

	public UserCollectAirdrop2 getUserCollectByTelegram(String telegram);

	public UserCollectAirdrop2 getUserCollectByEtherAdresse(String etherAdresse);
	
	public List<UserCollectAirdrop2> getAll();

}
