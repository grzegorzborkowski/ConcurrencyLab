class LimitedCountingSemaphore {

    CountingSemaphore firstSemaphore;
    CountingSemaphore secondSemaphore;

    int limit;
    public LimitedCountingSemaphore(int limit) {
        this.limit = limit;
        this.firstSemaphore = new CountingSemaphore(0);
        this.secondSemaphore = new CountingSemaphore(limit);
    }

    public synchronized void P(int n) {
        firstSemaphore.P(n);
        secondSemaphore.V(n);
    }

    public synchronized void V(int n) {
        secondSemaphore.P(n);
        firstSemaphore.V(n);
    }
}