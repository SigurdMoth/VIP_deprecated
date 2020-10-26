package dk.vip.client.presentation;

public interface HeadExpressionHandler {

    /**
     * Verify expression, JSONify
     * 
     * @return
     */
    String handleExpression(String query);

    //public void setStrategy(ITranslator translator);

    //public void setStrategy(IExpressionConverter expressionConverter);

    //public void setStrategy(HeadTransmissionHandler transmissionHandler);

}
