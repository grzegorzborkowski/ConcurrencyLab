class Shop {

    PackedInteger packedInteger;
    CountingSemaphore countingSemaphore;

    public Shop(int basketNumber) {
        CountingSemaphore countingSemaphore = new CountingSemaphore(packedInteger, basketNumber);
        this.packedInteger = countingSemaphore.packedInteger;
        this.countingSemaphore = countingSemaphore;
    }

    public void takeBasket() {
        countingSemaphore.P(1);
    }

    public void returnBasket() {
        countingSemaphore.V(1);
    }

    public static void main(String[] args) {
        Shop shop = new Shop(10);
        Client[] clients = new Client[20];
        for(int i=0; i<clients.length; i++) {
            clients[i] = new Client(shop);
        }

        Thread[] clientThreads = new Thread[20];
        for(int i=0; i<clientThreads.length; i++) {
            clientThreads[i] = new Thread(clients[i]);
            clientThreads[i].start();
        }
    }
}