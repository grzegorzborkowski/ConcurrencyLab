class BinarySemaphore {
    Boolean value;

    public BinarySemaphore() {
        value = true;
    }

    public synchronized void P() {
        while (value == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        value = false;
    }

    public synchronized void V() {
        if ( value == true ) {
            System.out.println("You can't apply V method on an already lifted Semaphore");
        }
        value = true;
        notifyAll();
    }
}