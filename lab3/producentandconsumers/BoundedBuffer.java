import java.util.concurrent.locks.*;


class BoundedBuffer {
    final Lock lock = new ReentrantLock();
    final Condition notFull  = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length)
                notFull.await();
            items[putptr] = x;
            if (++putptr == items.length) putptr = 0;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await();
            Object x = items[takeptr];
            if (++takeptr == items.length) takeptr = 0;
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        int stepsNumber = 10;
        int consumerLength = 5;
        int producentLength = 5;
        BoundedBuffer boundedBuffer = new BoundedBuffer();

        Consumer[] consumer = new Consumer[consumerLength];
        Producent[] producent = new Producent[producentLength];

        Thread[] consumerThreads = new Thread[consumerLength];
        Thread[] producentThreads = new Thread[producentLength];

        for(int i=0; i<consumerLength; i++) {
            consumer[i] = new Consumer(boundedBuffer, stepsNumber);
            consumerThreads[i] = new Thread(consumer[i]);
            consumerThreads[i].start();
        }

        for(int i=0; i<producentLength; i++) {
            producent[i] = new Producent(boundedBuffer, stepsNumber);
            producentThreads[i] = new Thread(producent[i]);
            producentThreads[i].start();
        }
    }
}