package dk.vip.client.domain.command.executions;

import dk.vip.client.domain.command.IExecution;
import dk.vip.client.domain.configuration.Configurator;
import dk.vip.client.domain.configuration.NetworkConfiguration;
import dk.vip.client.domain.translator.Expression;

public class SetNetwork implements IExecution {

    @Override
    public String execute(Expression expression){
        NetworkConfiguration netConf = Configurator.getInstance().get(NetworkConfiguration.class);
        netConf.setNetwork("6");
        netConf.setNode("4");
        Configurator.getInstance().saveConfig(NetworkConfiguration.class);
        return "hello world";
    }
}
