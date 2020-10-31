package dk.vip.session.domain.wrap.interpret;

public interface IInterpreter {
    Expression interpret(String query);
}