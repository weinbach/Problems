package sedgewick.union_find;

import java.util.ArrayList;

public class SocialNetworkConnectivity {

    int[] id;
    int[] sizes;
    boolean allConnected;

    public SocialNetworkConnectivity(int membersAmount) {
        this.id = new int[membersAmount];
        this.sizes = new int[membersAmount];

        for(int i=0;i<membersAmount;i++){
            id[i] = i;
            sizes[i] = 1;
        }
    }

    public void union(int indexOne, int indexTwo){
        if(!allConnected){
            System.out.println("x " + indexOne + " " + indexTwo);
            int rootOne = getRoot(indexOne);
            int rootTwo = getRoot(indexTwo);

            if(rootOne == rootTwo)
                return;

            if(sizes[rootOne] > sizes[rootTwo]){
                id[rootTwo] = rootOne;
                sizes[rootOne] += sizes[indexTwo];
                allConnected = sizes[rootOne] == id.length;
            } else{
                id[rootOne] = rootTwo;
                sizes[rootTwo] += sizes[indexOne];
                allConnected = sizes[rootTwo] == id.length;
            }
        }
    }

    public int getRoot(int index){
        while(id[index]!=index){
            id[index] = id[id[index]];
            sizes[id[index]]-=sizes[index];
            sizes[id[id[index]]]+=sizes[index];
            index = id[index];
        }
        return index;
    }

    boolean isConnected(int indexOne, int indexTwo){
        return getRoot(indexOne) == getRoot(indexTwo);
    }

    public int[] getId() {
        return id;
    }

    public int[] getSizes() {
        return sizes;
    }

    public boolean isAllConnected() {
        return allConnected;
    }

    public static void main(String[] args) {
        SocialNetworkConnectivity pr = new SocialNetworkConnectivity(10);

        ArrayList<Friendship> friendships = new ArrayList<>();
        friendships.add(new Friendship(0, 5, 1));
        friendships.add(new Friendship(2, 4, 2));
        friendships.add(new Friendship(4, 6, 3));
        friendships.add(new Friendship(1, 3, 4));
        friendships.add(new Friendship(8, 5, 6));
        friendships.add(new Friendship(9, 0, 7));
        friendships.add(new Friendship(7, 3, 8));
        friendships.add(new Friendship(3, 4, 9));
        friendships.add(new Friendship(3, 5, 10));
        friendships.add(new Friendship(0, 4, 11));

        for (Friendship friendship : friendships) {
            pr.union(friendship.getFriendA(), friendship.getFriendB());
            if (pr.isAllConnected()) {
                System.out.print("All are connected at date: " + friendship.getDate());
                break;
            }
        }

    }

}
