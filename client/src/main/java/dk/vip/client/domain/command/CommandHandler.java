package dk.vip.client.domain.command;

import java.util.Map;

import dk.vip.client.domain.translator.Expression;

public class CommandHandler {

    private final String protocol;
    private final Map<String, IExecution> commands;

    public CommandHandler(String protocol, Map<String, IExecution> commands) {
        this.protocol = protocol;
        this.commands = commands;
    }

    public String execute(String command, Expression expression) {
        return commands.get(command).execute(expression);
    }

    public String getProtocol() {
        return protocol;
    }
    public Map<String, IExecution> getCommands(){
        return commands;
    }

}
