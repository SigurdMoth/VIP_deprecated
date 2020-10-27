package dk.vip.client.domain.command;

import java.util.Map;

import dk.vip.client.domain.translator.Expression;

public class ProtocolHandler {

    private final String protocol;
    private final Map<String, IExecution> commands;

    public ProtocolHandler(String protocol, Map<String, IExecution> commands) {
        this.protocol = protocol;
        this.commands = commands;
    }

    public String execute(Expression expression) {
        if (expression.getProtocol().equals(protocol)) {
            return commands.get(expression.getCommand()).execute(expression);
        }
        return "incorrect protocolhandler (ProtocolHandler.java)";
    }

    public String getProtocol() {
        return protocol;
    }

    public Map<String, IExecution> getCommands() {
        return commands;
    }

}
