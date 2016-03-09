class Decrement implements Runnable {

    PackedInteger packedInteger;
    int range;

    public Decrement(PackedInteger packedInteger, int range) {
        this.packedInteger = packedInteger;
        this.range = range;
    }

    public void run() {
        for (int i = 0; i < range; i++) {
            packedInteger.decrease();
        }
        packedInteger.printValue();
    }
}