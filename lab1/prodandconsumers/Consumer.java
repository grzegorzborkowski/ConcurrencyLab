public class Consumer implements Runnable {
    private ProConsBuffer buffer;
    private int stepsNumber;

    public Consumer(ProConsBuffer buffer, int stepsNumber) {
        this.buffer = buffer;
        this.stepsNumber = stepsNumber;
    }

    public void run() {
        for (int i = 0; i < stepsNumber; i++) {
            String message = buffer.take();
        }
    }
}