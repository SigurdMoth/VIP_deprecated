package dk.vip.client.domain.translator;

import java.util.List;

public class Expression {
    private String protocol, command;
    private List<Parameter> parameters;

    public Expression(String protocol, String command, List<Parameter> parameters) {
        this.protocol = protocol;
        this.command = command;
        this.parameters = parameters;
    }

    class Parameter {
        String parameter, value;
        boolean hasValue;

        public Parameter(String parameter) {
            this.parameter = parameter;
        }

        public Parameter(String parameter, String value) {
            this.parameter = parameter;
            this.value = value;
            hasValue = true;
        }
    }
}
