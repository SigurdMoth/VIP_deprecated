package dk.vip.client.domain.compute.command;

import dk.vip.client.domain.interpret.Expression;

public interface IExecuteExpression {
    String execute(Expression expression);
}
