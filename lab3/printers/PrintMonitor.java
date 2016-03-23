import java.util.HashSet;
import java.util.Set;

class PrintMonitor {

    private final Lock lock = new ReentrantLock();
    private final Condition waiting_for_printer = lock.newCondition();
    private final Set<Integer> printers = new HashSet<Integer>();
    Integer availablePrinter;

    public PrintMonitor(int numberOfPrinters) {
        for (int i = 0; i < numberOfPrinters; i++) {
            printers.add(i);
        }
    }

    public Integer getPrinter(Task task) {
        lock.lock();
        try {
            while (printers.isEmpty()) {
                waiting_for_printer.await();
            }
            availablePrinter = printers.iterator().next();
            printers.remove(availablePrinter);
        } finally {
            lock.unlock();
            return availablePrinter;
        }
    }

    public void freePrinter(Integer printer) {
        lock.lock();
        printers.add(printer);
        waiting_for_printer.signal();
        lock.unlock();
    }
}