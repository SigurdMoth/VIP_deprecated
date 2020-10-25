package dk.vip.client.presentation;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputScanner implements InputReader {

    private Logger logger = Logger.getLogger(InputScanner.class.getName());
    private boolean isRunning;
    private Scanner scanner = new Scanner(System.in);

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
            String inputLine = scanner.nextLine();
            if (inputLine.equals("exit")) {
                isRunning = false;
            }
            logger.log(Level.INFO, "Testing read msg:" + inputLine);
        }
    }

}
