package p14.Three;

import java.util.ArrayList;

public class Loader {
    private static ArrayList<Double> numbers = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(Loader::addedNumbers));
        }

        threads.forEach(Thread::start);
    }

    public static void addedNumbers(){
        for (int i = 0; i < 1000000; i++)
        {
            double result = Math.random() / Math.random();
            synchronized (Loader.class) {
                numbers.add(result);
            }
        }
        System.out.println(numbers.size());
        numbers.clear();
    }
}
