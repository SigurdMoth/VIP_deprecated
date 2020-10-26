package dk.vip.client.domain;

import java.util.logging.Level;
import java.util.logging.Logger;

import dk.vip.client.domain.translator.Expression;
import dk.vip.client.domain.translator.ITranslator;
import dk.vip.client.presentation.HeadExpressionHandler;

public class TailExpressionHandler implements HeadExpressionHandler {

    private ITranslator translator;
    private IExpressionConverter expressionConverter;
    private HeadTransmissionHandler transmissionHandler;
    private Logger logger = Logger.getLogger(TailExpressionHandler.class.getName());

    public TailExpressionHandler(ITranslator translator, IExpressionConverter expressionConverter,
            HeadTransmissionHandler transmissionHandler) {
        this.translator = translator;
        this.expressionConverter = expressionConverter;
        this.transmissionHandler = transmissionHandler;
    }

    @Override
    public String handleExpression(String query) {
        // Interpret expression
        Expression expression = translator.translate(query);
        logger.log(Level.INFO, "expression:\n" + expression.toString());
        // Verify expression

        // Convert expression
        String exportJson = expressionConverter.convert(expression);
        logger.log(Level.INFO, "json export:\n" + exportJson);
        // Transmit expression
        String importJson = transmissionHandler.transmit(exportJson);
        logger.log(Level.INFO, "json import:\n" + importJson);
        return "";
    }

    public void setStrategy(ITranslator translator) {
        this.translator = translator;
    }

    public void setStrategy(IExpressionConverter expressionConverter) {
        this.expressionConverter = expressionConverter;
    }

    public void setStrategy(HeadTransmissionHandler transmissionHandler) {
        this.transmissionHandler = transmissionHandler;
    }
}
