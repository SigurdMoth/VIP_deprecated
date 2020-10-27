package dk.vip.client;

import dk.vip.client.domain.ExpressionConverterJSON;
import dk.vip.client.domain.HeadTransmissionHandler;
import dk.vip.client.domain.IExpressionConverter;
import dk.vip.client.domain.TailExpressionHandler;
import dk.vip.client.domain.configuration.Configurator;
import dk.vip.client.domain.translator.ITranslator;
import dk.vip.client.domain.translator.SimpleTranslator;
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

		//HeadExpressionHandler expressionHandler = new TailExpressionHandler();
		// expressionHandler.setStrategy(transmissionHandler);
		// expressionHandler.setStrategy(expressionConverter);
		// expressionHandler.setStrategy(translator);
		HeadExpressionHandler expressionHandler = new TailExpressionHandler(translator, expressionConverter,
				transmissionHandler);

		IPromptReader reader = new PromptScanner(expressionHandler);
		reader.start();
	}
}
