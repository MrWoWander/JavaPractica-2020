package p14.Five;

public class Loader {
    public static void main(String[] args) {
        Friend sasha = new Friend("Саша");
        Friend masha = new Friend("Маша");

        new Thread(() -> sasha.ballTo(masha)).start();
        new Thread(() -> masha.ballTo(sasha)).start();
    }
}
