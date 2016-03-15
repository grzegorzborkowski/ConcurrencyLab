import java.util.Random;

class Client implements Runnable {

    Shop shop;

    public Client(Shop shop) {
        this.shop = shop;
    }

    public void run() {
        Random random = new Random();
        shop.takeBasket();
        int seconds = random.nextInt(5000);
        try {
            Thread.sleep(seconds);
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        shop.returnBasket();
    }
}