package dk.vip.client.domain.convert;

import com.google.gson.Gson;

import dk.vip.client.domain.translate.Expression;

public class ExpressionConverterJSON implements IExpressionConverter {

    @Override
    public String convert(Expression expression) {
        Gson gson = new Gson();
        return gson.toJson(expression);
    }
}
