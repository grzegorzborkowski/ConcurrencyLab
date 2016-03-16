public class Consumer implements Runnable {
    private BoundedBuffer boundedBuffer;
    private int stepsNumber;

    public Consumer(BoundedBuffer boundedBuffer, int stepsNumber) {
        this.boundedBuffer = boundedBuffer;
        this.stepsNumber = stepsNumber;
    }

    public void run() {
        for (int i = 0; i < stepsNumber; i++) {
            String text = new String("ABC");
            try {
                System.out.println("Trying to put string" + text);
                boundedBuffer.put(text);
            } catch (InterruptedException e) {
            }
            System.out.println("Put successful");
        }
    }
}