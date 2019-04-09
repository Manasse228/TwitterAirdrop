package com.example.demo.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserCollectAirdrop2Repository;
import com.example.demo.entity.UserCollectAirdrop2;
import com.example.demo.metier.UserCollectAirdrop2Metier;

@Service
public class UserCollectAirdrop2Impl implements UserCollectAirdrop2Metier {

	@Autowired
	private UserCollectAirdrop2Repository userCollectAirdrop2Repository;

	@Override
	public void saveUserCollect(UserCollectAirdrop2 userCollect) {
		userCollectAirdrop2Repository.save(userCollect);
	}

	@Override
	public UserCollectAirdrop2 getUserCollectByTwitter(String twitter) {
		return userCollectAirdrop2Repository.getUserCollectByTwitter(twitter);
	}

	@Override
	public UserCollectAirdrop2 getUserCollectByTelegram(String telegram) {
		return userCollectAirdrop2Repository.getUserCollectByTelegram(telegram);
	}

	@Override
	public UserCollectAirdrop2 getUserCollectByEtherAdresse(String etherAdresse) {
		return userCollectAirdrop2Repository.getUserCollectByEtherAdresse(etherAdresse);
	}

	@Override
	public List<UserCollectAirdrop2> getAll() {
		return userCollectAirdrop2Repository.findAll();
	}

}
