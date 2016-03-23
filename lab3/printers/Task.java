class Task implements Runnable {
    private final String msg;
    PrintMonitor monitor;

    public Task(String msg, PrintMonitor monitor) {
        this.msg = msg;
        this.monitor = monitor;
    }

    private void print(int printer_number) {
        System.out.println("Printer: " + printer_number);
        System.out.println(msg);
    }

    @Override
    public void run() {
        Integer printer = monitor.getPrinter(this);
        print(printer);
        monitor.freePrinter(printer);
    }
}