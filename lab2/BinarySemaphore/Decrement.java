class Decrement implements Runnable {

    PackedInteger packedInteger;
    BinarySemaphore binarySemaphore;
    int range;

    public Decrement(BinarySemaphore binarySemaphore, PackedInteger packedInteger, int range) {
        this.binarySemaphore = binarySemaphore;
        this.packedInteger = packedInteger;
        this.range = range;
    }

    public void run() {
        for (int i = 0; i < range; i++) {
            binarySemaphore.P();
            packedInteger.decrease();
            binarySemaphore.V();
        }
        packedInteger.printValue();
    }
}