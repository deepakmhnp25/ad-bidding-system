package com.kobler.bidder;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

/**
 * Main class for the ad bidding system application
 *
 * @author Deepak Mohan
 * @version 1.0
 * @since 11-09-2022
 */
@SpringBootApplication
public class BidderApplication {

	private static Logger logger = LoggerFactory.getLogger(BidderApplication.class);

	/**
	 * main method to start the application
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		// Loading the serviceAccountKey for firestore db
		ClassPathResource classPathResource = new ClassPathResource("serviceAccountKey.json");
		InputStream inputStream = classPathResource.getInputStream();
		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(inputStream))
				.build();
		FirebaseApp.initializeApp(options);
		logger.info("Connection to firestore db successful");

		// Application initialization
		SpringApplication.run(BidderApplication.class, args);
		logger.info("Application start up successful");
	}

}
