class CountingSemaphore {

    PackedInteger packedInteger;

    public CountingSemaphore(int value) {
        this.packedInteger = new PackedInteger(value);
    }

    public synchronized void P(int n) {
        while (packedInteger.value - n <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        packedInteger.decrease(n);
    }

    public synchronized void V(int n) {
        packedInteger.increase(n);
        notifyAll();
    }
}