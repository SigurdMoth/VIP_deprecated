package dk.vip.client.domain;

import dk.vip.client.domain.translator.Expression;
import com.google.gson.Gson;

public class ExpressionConverterJSON implements IExpressionConverter {

    @Override
    public String convert(Expression expression) {
        Gson gson = new Gson();
        return gson.toJson(expression);
    }
}
