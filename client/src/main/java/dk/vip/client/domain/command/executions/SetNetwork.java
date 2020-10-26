package dk.vip.client.domain.command.executions;

import dk.vip.client.domain.command.IExecution;
import dk.vip.client.domain.configuration.Configurator;
import dk.vip.client.domain.configuration.EnumConfig;
import dk.vip.client.domain.configuration.NetworkConfiguration;
import dk.vip.client.domain.translator.Expression;

public class SetNetwork implements IExecution {

    @Override
    public String execute(Expression expression){
        NetworkConfiguration configuration = (NetworkConfiguration)EnumConfig.NETWORK.get();
        configuration.setNetwork("1");
        configuration.setNode("3");
        Configurator.getInstance().saveConfig(EnumConfig.NETWORK);
        return "hello world";
    }
}
