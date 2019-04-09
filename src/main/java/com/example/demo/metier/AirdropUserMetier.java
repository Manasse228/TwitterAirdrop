package com.example.demo.metier;

import org.springframework.data.repository.query.Param;

import com.example.demo.entity.AirdropUser;

public interface AirdropUserMetier {

	public AirdropUser getUserCollectByTwitter(String twitter);

	public AirdropUser getUserCollectByTelegram(String telegram);

	public AirdropUser getUserCollectByEtherAdresse(String etherAdresse);
	
	public void saveAirdropUser(AirdropUser airdropUser);
	
	public int updateAirdropUser(AirdropUser AirdropUser);

}
