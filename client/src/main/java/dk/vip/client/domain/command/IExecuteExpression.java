package dk.vip.client.domain.command;

import dk.vip.client.domain.translator.Expression;

public interface IExecuteExpression {
    String execute(Expression expression);
}
