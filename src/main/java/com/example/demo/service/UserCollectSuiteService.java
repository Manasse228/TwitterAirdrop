package com.example.demo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserCollectAirdrop2;
import com.example.demo.entity.UserCollectSuite;
import com.example.demo.metier.FollowerMetier;
import com.example.demo.metier.UserCollectMetier;
import com.example.demo.metier.UserCollectSuiteMetier;
import com.example.demo.utils.Utility;
import com.opencsv.CSVReader;

@CrossOrigin(origins = "*")
@RestController
public class UserCollectSuiteService {

	@Autowired
	private FollowerMetier followerMetier;

	@Autowired
	private UserCollectSuiteMetier userCollectSuiteMetier;

	@RequestMapping(value = "/extractSuiteCSV/", method = RequestMethod.GET)
	public void extractSuiteCSV() throws IOException {

		String csvFile = "C:\\Users\\Ameyibo\\Downloads\\convertcsv.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
		int i = 0, j = 0, cpt1 = 0;
		ArrayList<UserCollectSuite> userCollectList = new ArrayList<>();
		ArrayList<String> erroString = new ArrayList<>();

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				i++;

				// use comma as separator
				String[] info = line.split(cvsSplitBy);

				System.out.println(line);
				if (info.length >11 && info[11].length() <= 4) {

					String telegram = info[4].trim();
					String etherAddress = info[7].trim();
					String email = info[8].trim();
					String twitter = info[9].trim();
					System.out.println("Show me " + info[11] + " telegram " + telegram);
					int balance = Integer.parseInt(info[11].trim());

					if (telegram.length() > 0  && twitter.length() > 0 && etherAddress.length() > 0 && Utility.isValidAddress(etherAddress)) {
						j++;

						UserCollectSuite userCollect = new UserCollectSuite();

						if (email.length() > 0 && Utility.validateEmail(email)) {
							userCollect.setEmail(email);
						}
						userCollect.setTelegram(telegram.substring(1, telegram.length()));
						userCollect.setTwitter(twitter.substring(1, twitter.length()));
						userCollect.setEtherAdresse(etherAddress);
						userCollect.setBalance(balance);
						userCollectList.add(userCollect);
					}

				} else {
					erroString.add(line);
				}

			}

			System.out.println(" Taille totale " + i);
			System.out.println(" Taille retenue " + j);

			for (UserCollectSuite userCollect : userCollectList) {
				if (userCollectSuiteMetier.getUserCollectByEtherAdresse(userCollect.getEtherAdresse()) == null
						&& userCollectSuiteMetier.getUserCollectByTelegram(userCollect.getTelegram()) == null
						&& userCollectSuiteMetier.getUserCollectByTwitter(userCollect.getTwitter()) == null
						&& followerMetier.getFollowerByName(userCollect.getTwitter()) != null) {
					cpt1++;
					userCollectSuiteMetier.saveUserCollect(userCollect);
				}
			}
			
			System.out.println("Taille correcte  " + cpt1); 
			System.out.println("erroString  " + erroString.size()); 

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		/*
		 * CSVReader reader; int i = 0, cpt = 0, cpt1 = 0; try { reader = new CSVReader(
		 * new FileReader(
		 * "C:\\Users\\Ameyibo\\eclipse-workspace\\TwitterAirdrop\\src\\main\\resources\\WTXHubbotAirdrop1suite2.csv"
		 * ), ',');
		 * 
		 * List<String[]> myEntries = reader.readAll(); ArrayList<UserCollectSuite>
		 * userCollectList = new ArrayList<>(); System.out.println(myEntries.size());
		 * 
		 * 
		 * 
		 * for (String[] strings : myEntries) {
		 * 
		 * System.out.println("strings humm "+strings.toString());
		 * 
		 * String textLine = Arrays.toString(strings).replaceAll("\\[|\\]", "");
		 * 
		 * String[] cols = textLine.split(",");
		 * 
		 * String email = cols[1].trim(); String telegram = cols[3].trim(); String
		 * twitter = cols[9].trim(); String referal = cols[12].trim(); String
		 * etherAddress = cols[15].trim(); String medium = cols[18].trim();
		 * 
		 * 
		 * if (telegram.length() > 0 && telegram.charAt(0) == '@' && twitter.length() >
		 * 0 && twitter.charAt(0) == '@' && etherAddress.length() > 0 &&
		 * Utility.isValidAddress(etherAddress) && medium.length() > 0) {
		 * 
		 * UserCollectSuite userCollect = new UserCollectSuite();
		 * 
		 * //System.out.println("twitter " + twitter); //System.out.println("email " +
		 * email);
		 * 
		 * System.out.println("Email: "+email+" Telegram: " +telegram+ " Twitter: " +
		 * twitter + " Referal: " +
		 * referal+" EtherAddress: "+etherAddress+" Medium "+medium);
		 * 
		 * if (email.length() > 0 && Utility.validateEmail(email)) {
		 * userCollect.setEmail(email); } userCollect.setTelegram(telegram.substring(1,
		 * telegram.length())); userCollect.setTwitter(twitter.substring(1,
		 * twitter.length())); userCollect.setEtherAdresse(etherAddress);
		 * userCollect.setBalance(0);
		 * 
		 * cpt++; //userCollectList.add(userCollect);
		 * 
		 * }
		 * 
		 * i++;
		 * 
		 * }
		 * 
		 * System.out.println("Taille finale " + i);
		 * System.out.println("Taille correcte " + cpt);
		 * 
		 * reader.close();
		 * 
		 * for (UserCollectSuite userCollect : userCollectList) { if
		 * (userCollectSuiteMetier.getUserCollectByEtherAdresse(userCollect.
		 * getEtherAdresse()) == null &&
		 * userCollectSuiteMetier.getUserCollectByTelegram(userCollect.getTelegram()) ==
		 * null &&
		 * userCollectSuiteMetier.getUserCollectByTwitter(userCollect.getTwitter()) ==
		 * null && followerMetier.getFollowerByName(userCollect.getTwitter()) != null) {
		 * cpt1++; //userCollectSuiteMetier.saveUserCollect(userCollect); } }
		 * 
		 * System.out.println("Taille correcte 1 " + cpt1);
		 * 
		 * } catch (FileNotFoundException e) { e.printStackTrace(); }
		 */

	}

}
