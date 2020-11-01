package dk.vip.client.domain.interpret;

import dk.vip.expression.Expression;

public interface IInterpreter {
    Expression interpret(String query);
}