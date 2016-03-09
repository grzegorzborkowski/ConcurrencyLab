class Decrement implements Runnable {

    BinarySemaphre binarySemaphore;
    PackedInteger packedInteger;
    int range;

    public Decrement(BinarySemaphore binarySemaphore, PackedInteger packedInteger, int range) {
        this.binarySemaphre = binarySemaphore;
        this.packedInteger = packedInteger;
        this.range = range;
    }

    public void run() {
        for (int i = 0; i < range; i++) {
            binarySemaphore.p();
            packedInteger.decrease();
            binarySemaphore.v();
        }
        packedInteger.printValue();
    }
}