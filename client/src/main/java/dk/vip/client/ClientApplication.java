package dk.vip.client;

import dk.vip.client.domain.TailExpressionHandler;
import dk.vip.client.domain.compute.configuration.Configurator;
import dk.vip.client.domain.convert.ClientWrapConverterJSON;
import dk.vip.client.domain.convert.IClientWrapConverter;
import dk.vip.client.domain.interpret.IInterpreter;
import dk.vip.client.domain.interpret.SimpleInterpreter;
import dk.vip.client.domain.transmit.HeadTransmissionHandler;
import dk.vip.client.persistence.TailConfigurationFileHandler;
import dk.vip.client.persistence.TailTransmissionHandler;
import dk.vip.client.presentation.HeadExpressionHandler;
import dk.vip.client.presentation.IInputReader;
import dk.vip.client.presentation.InputScanner;

public class ClientApplication {

	public static void main(String[] args) {
		IInterpreter interpreter = new SimpleInterpreter();
		IClientWrapConverter clientWrapConverter = new ClientWrapConverterJSON();
		HeadTransmissionHandler transmissionHandler = new TailTransmissionHandler();
		Configurator.getInstance().setStrategy(new TailConfigurationFileHandler());
		Configurator.getInstance().init();
		HeadExpressionHandler expressionHandler = new TailExpressionHandler(interpreter, clientWrapConverter,
				transmissionHandler);

		IInputReader inputReader = new InputScanner(expressionHandler);
		inputReader.start();
	}
}
