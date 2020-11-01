package dk.vip.client.presentation;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputScanner implements IInputReader {

    private HeadExpressionHandler expressionHandler;
    private boolean isRunning;
    private Scanner scanner = new Scanner(System.in);
    //private Logger logger = Logger.getLogger(InputScanner.class.getName());

    @Override
    public void start() {
        isRunning = true;
        readLoop();
    }

    @Override
    public void stop() {
        isRunning = false;
    }

    private void readLoop() {
       new Thread(() -> {
            while (isRunning) {
                readLine();
            }
            scanner.close();
       }).start();
    }

    private void readLine() {
        if (scanner.hasNextLine()) {
            String query = scanner.nextLine();
            if (query.equals("exit")) {
                isRunning = false;
            }
            String result = expressionHandler.handleExpression(query);
            System.out.println(result);
        }
    }

    @Autowired
    public void setStrategy(HeadExpressionHandler expressionHandler) {
        this.expressionHandler = expressionHandler;
    }
}
