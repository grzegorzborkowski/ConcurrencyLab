class Shop {

    LimitedCountingSemaphore limitedCountingSemaphore;
    private int basketNumber;

    public Shop (int basketLimit) {
        this.basketNumber = 0;
        LimitedCountingSemaphore limitedCountingSemaphore = new LimitedCountingSemaphore(basketLimit);
        this.limitedCountingSemaphore = limitedCountingSemaphore;

    }

    public void takeBasket() {
        limitedCountingSemaphore.P(1);
    }

    public void addBaskets(int n) {
        limitedCountingSemaphore.V(n);
    }

    public void returnBasket() {
        limitedCountingSemaphore.V(1);
    }

    public int getBasketNumber() {
        return basketNumber;
    }

    public static void main(String[] args) {
        int basketNumber = 10;
        int basketLimit = 20;
        Shop shop = new Shop(basketLimit);
        Client[] clients = new Client[20];
        ShopEmployee shopEmployee = new ShopEmployee(shop);
        for(int i=0; i<clients.length; i++) {
            clients[i] = new Client(shop);
        }

        Thread[] clientThreads = new Thread[20];
        Thread shopEmployeeThread = new Thread(shopEmployee);
        for(int i=0; i<clientThreads.length; i++) {
            clientThreads[i] = new Thread(clients[i]);
            clientThreads[i].start();
        }
        shopEmployeeThread.start();
    }
}