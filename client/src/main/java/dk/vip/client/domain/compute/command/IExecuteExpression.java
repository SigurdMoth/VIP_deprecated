package dk.vip.client.domain.compute.command;

import dk.vip.client.domain.translate.Expression;

public interface IExecuteExpression {
    String execute(Expression expression);
}
