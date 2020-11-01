package dk.vip.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dk.vip.client.presentation.IInputReader;

@SpringBootApplication
public class ClientApplication implements ApplicationRunner {

	@Autowired
	private IInputReader inputReader;

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		inputReader.start();
	}
}
