class PackedInteger {
    int value;

    PackedInteger(int value) {
        this.value = value;
    }

    public void increase(int n) {
        this.value = this.value + n;
    }

    public void decrease(int n) {
        this.value = this.value - n;
    }

    public void printValue() {
        System.out.println(this.value);
    }
}