class PackedInteger {
    int value;

    PackedInteger(int value) {
        this.value = value;
    }

    public synchronized void increase() {
        this.value = this.value + 1;
    }

    public synchronized void decrease() {
        this.value = this.value - 1;
    }

    public void printValue() {
        System.out.println(this.value);
    }
}