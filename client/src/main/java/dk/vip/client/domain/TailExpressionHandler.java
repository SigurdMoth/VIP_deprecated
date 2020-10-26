package dk.vip.client.domain;

import java.util.logging.Level;
import java.util.logging.Logger;

import dk.vip.client.domain.translator.Expression;
import dk.vip.client.domain.translator.ITranslator;
import dk.vip.client.presentation.HeadExpressionHandler;

public class TailExpressionHandler implements HeadExpressionHandler {

    private ITranslator translator;
    private IExpressionConverter expressionConverter;
    private Logger logger = Logger.getLogger(TailExpressionHandler.class.getName());

    public TailExpressionHandler(ITranslator translator, IExpressionConverter expressionConverter) {
        this.translator = translator;
        this.expressionConverter = expressionConverter;
    }

    @Override
    public String handleExpression(String query) {
        // Interpret expression
        Expression expression = translator.translate(query);
        logger.log(Level.INFO, "expression:\n" + expression.toString());
        // Verify expression

        // Convert expression
        String json = expressionConverter.convert(expression);
        logger.log(Level.INFO, "json:\n" + json);
        return "";
    }
}
