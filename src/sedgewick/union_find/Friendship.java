package sedgewick.union_find;

public class Friendship {

    int friendA;
    int friendB;
    int date;

    public Friendship(int friendA, int friendB, int date) {
        this.friendA = friendA;
        this.friendB = friendB;
        this.date = date;
    }

    public int getFriendA() {
        return friendA;
    }

    public int getFriendB() {
        return friendB;
    }

    public int getDate() {
        return date;
    }
}
