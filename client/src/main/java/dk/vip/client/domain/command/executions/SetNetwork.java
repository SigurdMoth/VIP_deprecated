package dk.vip.client.domain.command.executions;

import dk.vip.client.domain.command.IExecuteExpression;
import dk.vip.client.domain.configuration.Configurator;
import dk.vip.client.domain.configuration.models.NetworkConfiguration;
import dk.vip.client.domain.translator.Expression;
import dk.vip.client.domain.translator.Parameter;

public class SetNetwork implements IExecuteExpression {

    // set network -v 6 -n 4
    @Override
    public String execute(Expression expression){
        NetworkConfiguration netConf = Configurator.getInstance().get(NetworkConfiguration.class);

        StringBuilder sb = new StringBuilder("NetworkConfiguration: ");


        Parameter parameter = expression.getParameterByIdentifier("v");
        if (parameter != null){
            netConf.setNetwork(parameter.getValue());
            sb.append("\n \t+ added parameter " + parameter.getIdentifier() + " of value:" + parameter.getValue());
        }
        
        parameter = expression.getParameterByIdentifier("n");
        if (parameter != null){
            netConf.setNode(parameter.getValue());
            sb.append("\n \t+ added parameter " + parameter.getIdentifier() + " of value:" + parameter.getValue());
        }

        Configurator.getInstance().saveConfig(NetworkConfiguration.class);
        return sb.toString();
    }
}
