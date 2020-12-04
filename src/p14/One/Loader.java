package p14.One;

public class Loader {
    public static void main(String[] args) {
        for(int i = 0; i < 4; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    ValueStorage.incrementValue();
                }
                System.out.println(ValueStorage.getValue());
            }).start();
        }
    }
}
