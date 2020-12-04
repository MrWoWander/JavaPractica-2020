package p14.Five;

public class Friend implements Comparable<Friend>{
    private final String name;

    Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void ballTo(Friend catcher) {
        System.out.println(this.name + ": кинул мяч " + catcher.getName());
        synchronized (compareTo(catcher) > 0 ? catcher : this) {
            catcher.ballTo(this);
        }
    }

    @Override
    public int compareTo(Friend o) {
        return this.getName().compareTo(o.getName());
    }
}
