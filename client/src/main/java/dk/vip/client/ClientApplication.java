package dk.vip.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dk.vip.client.domain.ExpressionConverterJSON;
import dk.vip.client.domain.IExpressionConverter;
import dk.vip.client.domain.TailExpressionHandler;
import dk.vip.client.domain.translator.ITranslator;
import dk.vip.client.domain.translator.SimpleTranslator;
import dk.vip.client.presentation.HeadExpressionHandler;
import dk.vip.client.presentation.IPromptReader;
import dk.vip.client.presentation.PromptScanner;

@SpringBootApplication
public class ClientApplication {
	private static Logger logger = Logger.getLogger(ClientApplication.class.getName());

	public static void main(String[] args) {
		// SpringApplication.run(ClientApplication.class, args);
		ITranslator translator = new SimpleTranslator();
		IExpressionConverter expressionConverter = new ExpressionConverterJSON();
		HeadExpressionHandler expressionhandler = new TailExpressionHandler(translator, expressionConverter);
		IPromptReader reader = new PromptScanner(expressionhandler);
		reader.start();
	}
}
