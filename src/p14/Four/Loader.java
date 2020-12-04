package p14.Four;

public class Loader {
    public static void main(String[] args) {
        Parking parking = new Parking();

        Thread task1 = new Thread(new Producer(parking));
        Thread task2 = new Thread(new Consumer(parking));

        task1.start();
        task2.start();
    }
}
