package dk.vip.client.domain;

import dk.vip.client.domain.translator.Expression;
import dk.vip.client.domain.translator.ITranslator;
import dk.vip.client.presentation.HeadExpressionHandler;

public class TailExpressionHandler implements HeadExpressionHandler {

    private ITranslator translator;

    public TailExpressionHandler(ITranslator translator) {
        this.translator = translator;
    }

    @Override
    public String handleExpression(String query) {
        // Interpret expression
        Expression expression = translator.translate(query);
        // Verify expression

        // Convert expression
        return "";
    }
}
