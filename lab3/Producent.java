public class Producent implements Runnable {
    private BoundedBuffer boundedBuffer;
    private int stepsNumber;

    public Producent(BoundedBuffer boundedBuffer, int stepsNumber) {
        this.boundedBuffer = boundedBuffer;
        this.stepsNumber = stepsNumber;
    }

    public void run() {
        for (int i = 0; i < stepsNumber; i++) {
            try {
                System.out.print("Trying to consume a string");
                Object x = boundedBuffer.take();
            } catch (InterruptedException e) {
            }
     //       System.out.print("Consumed ", + x);
        }

    }
}