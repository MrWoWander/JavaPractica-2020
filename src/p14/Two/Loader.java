package p14.Two;

import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        Task task = new Task();
        new Thread(task).start();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter");
        scanner.nextLine();

        task.stop();
        System.out.println("Loader: " + task.getCounter());
    }
}
