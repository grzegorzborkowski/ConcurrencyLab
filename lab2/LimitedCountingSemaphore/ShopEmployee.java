import java.util.Random;

class ShopEmployee implements Runnable {

    Shop shop;

    public ShopEmployee(Shop shop) {
        this.shop = shop;
    }

    public void run() {
        Random random = new Random();
        int basketsNumber = random.nextInt(10);
        int seconds = random.nextInt(5000);
        try {
            Thread.sleep(seconds);
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Adding baskets to shop" + basketsNumber);
        shop.addBaskets(shop.getBasketNumber());
    }
}