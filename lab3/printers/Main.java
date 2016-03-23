import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int numberOfPrinters = 5;
        int numberOfTask = 10;
        PrintMonitor printerMonitor = new PrintMonitor(numberOfPrinters);
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < numberOfTask; i++) {
            threadList.add(new Thread(new Task("Task number " + String.valueOf(i), printerMonitor)));
        }
        for (Thread thread : threadList) {
            thread.start();
        }
    }
}