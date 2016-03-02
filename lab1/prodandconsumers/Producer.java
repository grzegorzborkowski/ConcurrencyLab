public class Producer implements Runnable {
    private ProConsBuffer buffer;
    private int stepsNumber;

    public Producer(ProConsBuffer buffer, int stepsNumber) {
        this.buffer = buffer;
        this.stepsNumber = stepsNumber;
    }

    public void run() {
        for (int i = 0; i < stepsNumber; i++) {
            buffer.put("message " + i);
        }
    }
}