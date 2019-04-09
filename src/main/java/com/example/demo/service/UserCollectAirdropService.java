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

import com.example.demo.entity.UserCollect;
import com.example.demo.metier.FollowerMetier;
import com.example.demo.metier.UserCollectMetier;
import com.example.demo.utils.Utility;
import com.opencsv.CSVReader;

@CrossOrigin(origins = "*")
@RestController
public class UserCollectAirdropService {

	@Autowired
	private FollowerMetier followerMetier;

	@Autowired
	private UserCollectMetier userCollectMetier;

	@RequestMapping(value = "/extractCSV/", method = RequestMethod.GET)
	public void extractCSV() throws IOException {

		CSVReader reader;
		int i = 0, cpt = 0;
		try {
			reader = new CSVReader(
					new FileReader(
							"C:\\Users\\Ameyibo\\eclipse-workspace\\TwitterAirdrop\\src\\main\\resources\\Airdrop.csv"),
					',');

			List<String[]> myEntries = reader.readAll();
			ArrayList<UserCollect> userCollectList = new ArrayList<>();
			System.out.println(myEntries.size());

			for (String[] strings : myEntries) {

				String textLine = Arrays.toString(strings).replaceAll("\\[|\\]", "");

				String[] cols = textLine.split(",");

				String email = cols[2].trim();
				String telegram = cols[3].trim();
				String twitter = cols[4].trim();
				String etherAddress = cols[7].trim();

				if (telegram.length() > 0 && telegram.charAt(0) == '@' && twitter.length() > 0
						&& twitter.charAt(0) == '@' && etherAddress.length() > 0
						&& Utility.isValidAddress(etherAddress)) {

					UserCollect userCollect = new UserCollect();

					System.out.println("twitter " + twitter);
					System.out.println("email " + email);

					System.out.println("Twitter " + twitter + " Twitter sub " + twitter.substring(1, twitter.length()));

					userCollect.setEtherAdresse(etherAddress);
					userCollect.setTelegram(telegram.substring(1, telegram.length()));
					userCollect.setTwitter(twitter.substring(1, twitter.length()));
					if (email.length() > 0 && Utility.validateEmail(email)) {
						userCollect.setEmail(email);
					}
					cpt++;
					userCollectList.add(userCollect);

				}

				i++;

			}

			System.out.println("Taille finale " + i);
			System.out.println("Taille correcte " + cpt);

			reader.close();

			for (UserCollect userCollect : userCollectList) {
				if (userCollectMetier.getUserCollectByEtherAdresse(userCollect.getEtherAdresse()) == null
						&& userCollectMetier.getUserCollectByTelegram(userCollect.getTelegram()) == null
						&& userCollectMetier.getUserCollectByTwitter(userCollect.getTwitter()) == null
						&& followerMetier.getFollowerByName(userCollect.getTwitter()) != null) {
					// userCollectMetier.saveUserCollect(userCollect);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
