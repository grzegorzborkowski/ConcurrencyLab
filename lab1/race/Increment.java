class Increment implements Runnable {

    PackedInteger packedInteger;
    int range;

    public Increment(PackedInteger packedInteger, int range) {
        this.packedInteger = packedInteger;
        this.range = range;
    }

    public void run() {
        for (int i = 0; i < range; i++) {
            packedInteger.increase();
        }
        packedInteger.printValue();
    }
}