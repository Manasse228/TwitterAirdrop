package com.example.demo.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserCollectSuiteRepository;
import com.example.demo.entity.UserCollectSuite;
import com.example.demo.metier.UserCollectSuiteMetier;

@Service
public class UserCollectSuiteImpl implements UserCollectSuiteMetier {

	@Autowired
	private UserCollectSuiteRepository collectSuiteRepository;

	@Override
	public void saveUserCollect(UserCollectSuite userCollect) {
		collectSuiteRepository.save(userCollect);
	}

	@Override
	public UserCollectSuite getUserCollectByTwitter(String twitter) {
		return collectSuiteRepository.getUserCollectByTwitter(twitter);
	}

	@Override
	public UserCollectSuite getUserCollectByTelegram(String telegram) {
		return collectSuiteRepository.getUserCollectByTelegram(telegram);
	}

	@Override
	public UserCollectSuite getUserCollectByEtherAdresse(String etherAdresse) {
		return collectSuiteRepository.getUserCollectByEtherAdresse(etherAdresse);
	}

	@Override
	public List<UserCollectSuite> getAll() {
		return collectSuiteRepository.findAll();
	}

}
