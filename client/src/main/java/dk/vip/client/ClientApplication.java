package dk.vip.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dk.vip.client.presentation.IPromptReader;
import dk.vip.client.presentation.PromptScanner;

@SpringBootApplication
public class ClientApplication {
	private static Logger logger = Logger.getLogger(ClientApplication.class.getName());

	public static void main(String[] args) {
		// SpringApplication.run(ClientApplication.class, args);
		IPromptReader reader = new PromptScanner();
		reader.start();
		logger.log(Level.INFO, "Thread excecuted.");
	}
}
