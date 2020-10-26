package dk.vip.client;

import dk.vip.client.domain.ExpressionConverterJSON;
import dk.vip.client.domain.HeadTransmissionHandler;
import dk.vip.client.domain.IExpressionConverter;
import dk.vip.client.domain.TailExpressionHandler;
import dk.vip.client.domain.translator.ITranslator;
import dk.vip.client.domain.translator.SimpleTranslator;
import dk.vip.client.persistence.TailTransmissionHandler;
import dk.vip.client.presentation.HeadExpressionHandler;
import dk.vip.client.presentation.IPromptReader;
import dk.vip.client.presentation.PromptScanner;

public class ClientApplication {

	public static void main(String[] args) {
		ITranslator translator = new SimpleTranslator();
		IExpressionConverter expressionConverter = new ExpressionConverterJSON();
		HeadTransmissionHandler transmissionHandler = new TailTransmissionHandler();
		HeadExpressionHandler expressionhandler = new TailExpressionHandler(translator, expressionConverter,
				transmissionHandler);

		IPromptReader reader = new PromptScanner(expressionhandler);
		reader.start();
	}
}
