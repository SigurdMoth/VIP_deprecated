package dk.vip.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dk.vip.client.presentation.InputReader;
import dk.vip.client.presentation.InputScanner;

@SpringBootApplication
public class ClientApplication {
	private static Logger logger = Logger.getLogger(ClientApplication.class.getName());

	public static void main(String[] args) {
		// SpringApplication.run(ClientApplication.class, args);
		InputReader reader = new InputScanner();
		reader.start();
		logger.log(Level.INFO, "Thread excecuted.");
	}
}
