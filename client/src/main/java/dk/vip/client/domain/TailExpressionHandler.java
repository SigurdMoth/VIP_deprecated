package dk.vip.client.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dk.vip.client.domain.compute.command.IExecuteExpression;
import dk.vip.client.domain.compute.command.ProtocolHandler;
import dk.vip.client.domain.compute.command.executions.SetNetwork;
import dk.vip.client.domain.compute.configuration.Configurator;
import dk.vip.client.domain.compute.configuration.models.NetworkConfiguration;
import dk.vip.client.domain.compute.configuration.models.UserConfiguration;
import dk.vip.client.domain.convert.IClientWrapConverter;
import dk.vip.client.domain.interpret.IInterpreter;
import dk.vip.client.domain.transmit.HeadTransmissionHandler;
import dk.vip.client.domain.wrap.ClientWrap;
import dk.vip.client.domain.wrap.MetaCollection;
import dk.vip.client.presentation.HeadExpressionHandler;
import dk.vip.expression.Expression;

@Component
public class TailExpressionHandler implements HeadExpressionHandler {

    @Autowired
    private IInterpreter interpreter;
    @Autowired
    private IClientWrapConverter clientWrapConverter;
    @Autowired
    private HeadTransmissionHandler transmissionHandler;
    @Autowired
    private Configurator configurator;
    
    @Autowired
    private SetNetwork setNetwork;
    @Autowired
    private SetNetwork setUser;

    private Logger logger = Logger.getLogger(TailExpressionHandler.class.getName());

    @Override
    public String handleExpression(String query) {
        // Translate expression
        Expression expression = interpreter.interpret(query);
        logger.log(Level.INFO, "expression:\n" + expression.toString());
        // Verify expression

        String result = "";
        if (expression.getProtocol().equals("set")) {
            // Compute expression
            Map<String, IExecuteExpression> setCommands = new HashMap<>();
            setCommands.put("network", setNetwork);
            setCommands.put("user", setUser);
            ProtocolHandler setProtocolHandler = new ProtocolHandler("set", setCommands);
            result = setProtocolHandler.execute(expression);
        } else {
            // Wrap expression
            MetaCollection metaCollection = new MetaCollection();
            metaCollection.add(configurator.get(NetworkConfiguration.class).bundle());
            metaCollection.add(configurator.get(UserConfiguration.class).bundle());
            ClientWrap clientWrap = new ClientWrap(expression, metaCollection);
            // Convert expression
            String exportJson = clientWrapConverter.convert(clientWrap);
            logger.log(Level.INFO, "json export:\n" + exportJson);
            // Transmit expression
            String importJson = transmissionHandler.transmit(exportJson);
            logger.log(Level.INFO, "json import:\n" + importJson);
        }
        return result;
    }
}
