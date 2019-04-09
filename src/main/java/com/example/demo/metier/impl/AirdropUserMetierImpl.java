package com.example.demo.metier.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AirdropUserRepository;
import com.example.demo.entity.AirdropUser;
import com.example.demo.metier.AirdropUserMetier;

@Service
public class AirdropUserMetierImpl implements AirdropUserMetier {

	@Autowired
	private AirdropUserRepository airdropUserImpl;

	@Override
	public AirdropUser getUserCollectByTwitter(String twitter) {
		return airdropUserImpl.getUserCollectByTwitter(twitter);
	}

	@Override
	public AirdropUser getUserCollectByTelegram(String telegram) {
		return airdropUserImpl.getUserCollectByTelegram(telegram);
	}

	@Override
	public AirdropUser getUserCollectByEtherAdresse(String etherAdresse) {
		return airdropUserImpl.getUserCollectByEtherAdresse(etherAdresse);
	}

	@Override
	public void saveAirdropUser(AirdropUser airdropUser) {
		airdropUserImpl.save(airdropUser);
	}

	@Override
	public int updateAirdropUser(AirdropUser AirdropUser) {
		return airdropUserImpl.updateAirdropUser(AirdropUser);
	}

}
