package dk.vip.client.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import dk.vip.client.domain.compute.command.IExecuteExpression;
import dk.vip.client.domain.compute.command.ProtocolHandler;
import dk.vip.client.domain.compute.command.executions.SetNetwork;
import dk.vip.client.domain.compute.command.executions.SetUser;
import dk.vip.client.domain.convert.IExpressionConverter;
import dk.vip.client.domain.translate.Expression;
import dk.vip.client.domain.translate.ITranslator;
import dk.vip.client.domain.transmit.HeadTransmissionHandler;
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
        // Translate expression
        Expression expression = translator.translate(query);
        logger.log(Level.INFO, "expression:\n" + expression.toString());
        // Verify expression

        String result = "";
        if (expression.getProtocol().equals("set")) {
            // Compute expression
            Map<String, IExecuteExpression> setCommands = new HashMap<>();
            setCommands.put("network", new SetNetwork());
            setCommands.put("user", new SetUser());
            ProtocolHandler setProtocolHandler = new ProtocolHandler("set", setCommands);
            result = setProtocolHandler.execute(expression);
        } else {
            // Package expression
            
            // Convert expression
            String exportJson = expressionConverter.convert(expression);
            logger.log(Level.INFO, "json export:\n" + exportJson);
            // Transmit expression
            String importJson = transmissionHandler.transmit(exportJson);
            logger.log(Level.INFO, "json import:\n" + importJson);
        }
        return result;
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
