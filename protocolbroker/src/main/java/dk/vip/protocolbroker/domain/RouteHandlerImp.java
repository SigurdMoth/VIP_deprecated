package dk.vip.protocolbroker.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.springframework.beans.factory.annotation.Autowired;

import dk.vip.expression.Expression;
import dk.vip.protocolbroker.presentation.IRouteHandler;
import dk.vip.wrap.Wrap;

public class RouteHandlerImp implements IRouteHandler {

    Logger logger = Logger.getLogger(RouteHandlerImp.class.getName());
    @Autowired
    ITransmissionHandler transmissionHandler;

    Map<String, String> protocolMap = new HashMap<>();

    @Override
    public String handleRoute(String requestBody) {
        // Unwrap wrap to expression
        Gson gson = new Gson();
        Wrap sessionWrap = null;
        try {
            sessionWrap = gson.fromJson(requestBody, Wrap.class);
        } catch (JsonSyntaxException e) {
            logger.log(Level.WARNING, "Failed to unwrap Json wrapper", e);
        }
        Expression expression = sessionWrap.getExpression();
        // Extract protocol from expression
        String protocol = expression.getProtocol();
        // Forward to correct protocol application
        String protocolServicePath = "NotSet";
        if (protocolMap.containsKey(protocol)) {
            protocolServicePath = protocolMap.get(protocol);
            return transmissionHandler.handleTransmission(sessionWrap, protocolServicePath);
        } else {// Else inform service is down
            logger.log(Level.WARNING, "Protocolservice: " + protocol
                    + " not found, either it is down, or the service reference is wrong.");
        }
        return protocolServicePath; // returns string NotSet
    }

    @Override
    public String publishProtocol(String request) {
        // Convert request

        // add key:value to map (name:path)
        return null;
    }
}
