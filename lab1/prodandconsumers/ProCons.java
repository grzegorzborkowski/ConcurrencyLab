public class ProCons {
    public static void main(String[] args) {
        int stepsnumber = 10;
        ProConsBuffer proConsBuffer = new ProConsBuffer();

        Consumer consumer1 = new Consumer(proConsBuffer, stepsnumber);
        Producer producent1 = new Producer(proConsBuffer, stepsnumber);

        Thread producentThread = new Thread(producent1);
        Thread consumerThread = new Thread(consumer1);
        consumerThread.start();
        producentThread.start();
    }
}