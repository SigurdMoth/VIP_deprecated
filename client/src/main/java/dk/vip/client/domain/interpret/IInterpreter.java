package dk.vip.client.domain.interpret;

public interface IInterpreter {
    Expression interpret(String query);
}