package dk.vip.client.domain.translator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleTranslator implements ITranslator {
    private Logger logger = Logger.getLogger(SimpleTranslator.class.getName());

    @Override
    public Expression translate(String query) {
        List<Parameter> parameters = new ArrayList<>();

        String[] splitQuery = query.split(" ");
        String[] splitParameter = query.split(" -");
        // should be a thrown error that can be handled.
        for (int i = 1; i < splitParameter.length; i++) {
            String identifier = splitParameter[i].substring(0, 1);
            String value = splitParameter[i].substring(2);
            if (!splitParameter[i].substring(1, 2).equals(" ")) {
                logger.log(Level.WARNING, "A parameter was excluded because of a syntax error");
                continue; // skip add.
            }
            parameters.add(new Parameter(identifier, value));
        }

        // protocol, command, <List>parameters
        return new Expression(splitQuery[0], splitQuery[1], parameters);
    }
}
