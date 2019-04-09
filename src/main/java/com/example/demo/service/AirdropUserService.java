package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AirdropUser;
import com.example.demo.entity.UserCollect;
import com.example.demo.entity.UserCollectAirdrop2;
import com.example.demo.entity.UserCollectSuite;
import com.example.demo.metier.AirdropUserMetier;
import com.example.demo.metier.UserCollectAirdrop2Metier;
import com.example.demo.metier.UserCollectMetier;
import com.example.demo.metier.UserCollectSuiteMetier;

@CrossOrigin(origins = "*")
@RestController
public class AirdropUserService {

	@Autowired
	private UserCollectMetier userCollectMetier;

	@Autowired
	private UserCollectAirdrop2Metier userCollectMetier2;

	@Autowired
	private UserCollectSuiteMetier userCollectSuiteMetier;

	@Autowired
	private AirdropUserMetier airdropUserMetier;

	ArrayList<UserCollect> userCollectList = new ArrayList<>();

	ArrayList<UserCollectAirdrop2> userCollec2tList = new ArrayList<>();

	ArrayList<UserCollectSuite> userCollectSuiteList = new ArrayList<>();

	ArrayList<AirdropUser> airdropUserList = new ArrayList<>();

	@RequestMapping(value = "/getAll/", method = RequestMethod.GET)
	public void getAll() {

		userCollectList = (ArrayList<UserCollect>) userCollectMetier.getAll();

		userCollec2tList = (ArrayList<UserCollectAirdrop2>) userCollectMetier2.getAll();

		userCollectSuiteList = (ArrayList<UserCollectSuite>) userCollectSuiteMetier.getAll();

		for (UserCollect userCollect : userCollectList) {
			AirdropUser airdropUser = new AirdropUser();

			airdropUser.setBalance(userCollect.getBalance());
			airdropUser.setEmail(userCollect.getEmail());
			airdropUser.setEtherAdresse(userCollect.getEtherAdresse());
			airdropUser.setTelegram(userCollect.getTelegram());
			airdropUser.setTwitter(userCollect.getTwitter());

			airdropUserList.add(airdropUser);
		}
		
		for (UserCollectAirdrop2 userCollectAirdrop2 : userCollec2tList) {
			
			AirdropUser airdropUser = new AirdropUser();
			int i = 0;
			
			airdropUser.setBalance(userCollectAirdrop2.getBalance());
			airdropUser.setEmail(userCollectAirdrop2.getEmail());
			airdropUser.setEtherAdresse(userCollectAirdrop2.getEtherAdresse());
			airdropUser.setTelegram(userCollectAirdrop2.getTelegram());
			airdropUser.setTwitter(userCollectAirdrop2.getTwitter());
			
			for (AirdropUser aUser : airdropUserList) {
				if(aUser.getEtherAdresse().equals(airdropUser.getEtherAdresse())){
					aUser.setBalance(aUser.getBalance() + airdropUser.getBalance());
					i++;
					break;
				}
			}
			
			if(i == 0) {
				airdropUserList.add(airdropUser);
			}
			i=0;
		}
		
		for (UserCollectSuite userCollectSuite : userCollectSuiteList) {
			
			AirdropUser airdropUser = new AirdropUser();
			int i = 0;
			
			airdropUser.setBalance(userCollectSuite.getBalance());
			airdropUser.setEmail(userCollectSuite.getEmail());
			airdropUser.setEtherAdresse(userCollectSuite.getEtherAdresse());
			airdropUser.setTelegram(userCollectSuite.getTelegram());
			airdropUser.setTwitter(userCollectSuite.getTwitter());
			
			for (AirdropUser aUser : airdropUserList) {
				if(aUser.getEtherAdresse().equals(airdropUser.getEtherAdresse())){
					aUser.setBalance(aUser.getBalance() + airdropUser.getBalance());
					i++;
					break;
				}
			}
			
			if(i == 0) {
				airdropUserList.add(airdropUser);
			}
			i=0;
		}
		
		for (AirdropUser airdropUser : airdropUserList) {
			if(airdropUserMetier.getUserCollectByEtherAdresse(airdropUser.getEtherAdresse()) != null) {
				AirdropUser responseUser = airdropUserMetier.getUserCollectByEtherAdresse(airdropUser.getEtherAdresse());
				airdropUserMetier.updateAirdropUser(responseUser);
			} else {
				airdropUserMetier.saveAirdropUser(airdropUser);
			}
			
			
		}
		
		System.out.println("Taille finale "+airdropUserList.size());

	}

}
