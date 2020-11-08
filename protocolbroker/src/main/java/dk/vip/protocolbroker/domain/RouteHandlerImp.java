package dk.vip.protocolbroker.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import dk.vip.expression.Expression;
import dk.vip.protocolbroker.presentation.IRouteHandler;
import dk.vip.wrap.Wrap;

public class RouteHandlerImp implements IRouteHandler {

    Logger logger = Logger.getLogger(RouteHandlerImp.class.getName());

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
        if (protocolMap.containsKey(protocol)){
            protocolServicePath = protocolMap.get(protocol);
        } // Else inform service is down

        return null;
    }

    @Override
    public String updateProtocolMap(String request) {
        // TODO Auto-generated method stub
        return null;
    }
}
