class Race {
    public static void main(String[] args) {
        PackedInteger packedInteger = new PackedInteger(0);
        int range = 10000000;
        Increment increment = new Increment(packedInteger, range);
        Thread incrementThread = new Thread(increment);

        Decrement decrement = new Decrement(packedInteger, range);
        Thread decrementThread = new Thread(decrement);

        incrementThread.start();
        decrementThread.start();
    }
}