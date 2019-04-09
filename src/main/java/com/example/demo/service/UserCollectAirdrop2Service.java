package com.example.demo.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserCollectAirdrop2;
import com.example.demo.metier.FollowerMetier;
import com.example.demo.metier.UserCollectAirdrop2Metier;
import com.example.demo.utils.Utility;
import com.opencsv.CSVReader;

@CrossOrigin(origins = "*")
@RestController

public class UserCollectAirdrop2Service {	
	
	@Autowired
	private UserCollectAirdrop2Metier userCollectMetier2;
	
	@Autowired
	private FollowerMetier followerMetier;
	

	@RequestMapping(value = "/extractTwoCSV/", method = RequestMethod.GET)
	public void extractTwoCSV() throws IOException {

		CSVReader reader;
		int i = 0, cpt = 0, cpt1 = 0;
		try {
			reader = new CSVReader(
					new FileReader(
							"C:\\Users\\Ameyibo\\eclipse-workspace\\TwitterAirdrop\\src\\main\\resources\\Airdrop2.csv"),
					',');

			List<String[]> myEntries = reader.readAll();
			ArrayList<UserCollectAirdrop2> userCollectList = new ArrayList<>();
			System.out.println(myEntries.size());

			for (String[] strings : myEntries) {

				String textLine = Arrays.toString(strings).replaceAll("\\[|\\]", "");

				String[] cols = textLine.split(",");

				String email = cols[1].trim();
				String telegram = cols[3].trim();
				String twitter = cols[9].trim();
				String referal = cols[12].trim();
				String etherAddress = cols[15].trim();
				String medium = cols[18].trim();
				
			
				if (telegram.length() > 0 && telegram.charAt(0) == '@' && twitter.length() > 0
						&& twitter.charAt(0) == '@' && etherAddress.length() > 0 && Utility.isValidAddress(etherAddress) && medium.length() > 0) {

					UserCollectAirdrop2 userCollect = new UserCollectAirdrop2();

					//System.out.println("twitter " + twitter);
					//System.out.println("email " + email);

					System.out.println("Email: "+email+" Telegram: " +telegram+ " Twitter: " + twitter + " Referal: " + referal+" EtherAddress: "+etherAddress+" Medium "+medium);
					
					if (email.length() > 0 && Utility.validateEmail(email)) {
						userCollect.setEmail(email);
					}
					userCollect.setTelegram(telegram.substring(1, telegram.length()));
					userCollect.setTwitter(twitter.substring(1, twitter.length()));
					userCollect.setReferalName(referal);
					userCollect.setEtherAdresse(etherAddress);
					userCollect.setMediumName(medium);
					
					cpt++;
					userCollectList.add(userCollect);

				}

				i++;

			}

			System.out.println("Taille finale " + i);
			System.out.println("Taille correcte " + cpt);

			reader.close();

			for (UserCollectAirdrop2 userCollect : userCollectList) {
				if (userCollectMetier2.getUserCollectByEtherAdresse(userCollect.getEtherAdresse()) == null
						&& userCollectMetier2.getUserCollectByTelegram(userCollect.getTelegram()) == null
						&& userCollectMetier2.getUserCollectByTwitter(userCollect.getTwitter()) == null
						&& followerMetier.getFollowerByName(userCollect.getTwitter()) != null) {
					cpt1++;
					userCollectMetier2.saveUserCollect(userCollect);
				}
			}
			
			System.out.println("Taille correcte 1 " + cpt1);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
