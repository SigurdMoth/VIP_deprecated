package dk.vip.client.domain;

import dk.vip.client.domain.translator.Expression;

public interface IExpressionConverter {
    String convert(Expression expression);
}
