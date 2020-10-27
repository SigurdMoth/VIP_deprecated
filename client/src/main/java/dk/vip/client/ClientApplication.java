package dk.vip.client;

import dk.vip.client.domain.TailExpressionHandler;
import dk.vip.client.domain.compute.configuration.Configurator;
import dk.vip.client.domain.convert.ExpressionConverterJSON;
import dk.vip.client.domain.convert.IExpressionConverter;
import dk.vip.client.domain.translate.ITranslator;
import dk.vip.client.domain.translate.SimpleTranslator;
import dk.vip.client.domain.transmit.HeadTransmissionHandler;
import dk.vip.client.persistence.TailConfigurationFileHandler;
import dk.vip.client.persistence.TailTransmissionHandler;
import dk.vip.client.presentation.HeadExpressionHandler;
import dk.vip.client.presentation.IPromptReader;
import dk.vip.client.presentation.PromptScanner;

public class ClientApplication {

	public static void main(String[] args) {
		ITranslator translator = new SimpleTranslator();
		IExpressionConverter expressionConverter = new ExpressionConverterJSON();
		HeadTransmissionHandler transmissionHandler = new TailTransmissionHandler();
		Configurator.getInstance().setStrategy(new TailConfigurationFileHandler());
		Configurator.getInstance().init();
		HeadExpressionHandler expressionHandler = new TailExpressionHandler(translator, expressionConverter,
				transmissionHandler);

		IPromptReader reader = new PromptScanner(expressionHandler);
		reader.start();
	}
}
