package dk.vip.client.domain.compute.command.executions;

import dk.vip.client.domain.compute.command.IExecuteExpression;
import dk.vip.client.domain.compute.configuration.Configurator;
import dk.vip.client.domain.compute.configuration.models.UserConfiguration;
import dk.vip.client.domain.interpret.Expression;
import dk.vip.client.domain.interpret.Parameter;

public class SetUser implements IExecuteExpression {

    @Override
    public String execute(Expression expression) {
        UserConfiguration userConf = Configurator.getInstance().get(UserConfiguration.class);

        StringBuilder sb = new StringBuilder("UserConfiguration: ");
        
        Parameter parameter = expression.getParameterByIdentifier("n");
        if (parameter != null){
            userConf.setName(parameter.getValue());
            sb.append("\n \t+ added parameter " + parameter.getIdentifier() + " of value:" + parameter.getValue());
        }

        Configurator.getInstance().saveConfig(UserConfiguration.class);
        return sb.toString();
    }

}
