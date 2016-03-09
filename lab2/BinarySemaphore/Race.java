class Race {
    public static void main(String[] args) {
        BinarySemaphore binarySemaphore = new BinarySemaphore();
        PackedInteger packedInteger = new PackedInteger(0);
        int range = 100000;
        Increment increment = new Increment(binarySemaphore, packedInteger, range);
        Decrement decrement = new Decrement(binarySemaphore, packedInteger, range);

        Thread incrementThread = new Thread(increment);
        Thread decrementThread = new Thread(decrement);

        incrementThread.start();
        decrementThread.start();
    }
}