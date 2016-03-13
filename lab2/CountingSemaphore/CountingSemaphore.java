class CountingSemaphore {

    PackedInteger packedInteger;

    public CountingSemaphore(PackedInteger packedInteger, int value) {
        this.packedInteger = new PackedInteger(value);
    }

    public synchronized void P(int n) {
        System.out.print("Client wants to take a basket there are now");
        packedInteger.printValue();
        while (packedInteger.value - n <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        packedInteger.decrease(n);
        System.out.print("Client took a basket there are now");
        packedInteger.printValue();
    }

    public synchronized void V(int n) {
        System.out.print("Client wants to return a basket there are now");
        packedInteger.printValue();
        packedInteger.increase(n);
        System.out.println("Client returned a basket there are now");
        packedInteger.printValue();
        notifyAll();
    }
}