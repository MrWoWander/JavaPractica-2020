package p14.Four;

public class Parking {

    private final int parkingSize = 500;
    private int carCount = 0;

    public synchronized void in() {
        if (carCount == parkingSize)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        carCount++;
        System.out.println("Автомобиль поставлен на парковку");
        System.out.println("Свободных мест: " + (parkingSize - carCount));
        notify();
    }

    public synchronized void out() {
        if (carCount == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        carCount--;
        System.out.println("Автомобиль убран с парковки");
        System.out.println("Свободных мест: " + (parkingSize - carCount));
        notify();
    }
}
