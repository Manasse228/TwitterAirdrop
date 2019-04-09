package com.example.demo.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserCollectRepository;
import com.example.demo.entity.UserCollect;
import com.example.demo.metier.UserCollectMetier;

@Service
public class UserCollectMetierImpl implements UserCollectMetier {

	@Autowired
	private UserCollectRepository userCollectRepository;

	@Override
	public void saveUserCollect(UserCollect userCollect) {
		userCollectRepository.save(userCollect);
	}

	@Override
	public UserCollect getUserCollectByTwitter(String twitter) {
		return userCollectRepository.getUserCollectByTwitter(twitter);
	}

	@Override
	public UserCollect getUserCollectByTelegram(String telegram) {
		return userCollectRepository.getUserCollectByTelegram(telegram);
	}

	@Override
	public UserCollect getUserCollectByEtherAdresse(String etherAdresse) {
		return userCollectRepository.getUserCollectByEtherAdresse(etherAdresse);
	}

	@Override
	public List<UserCollect> getAll() {
		return userCollectRepository.findAll();
	}

}
