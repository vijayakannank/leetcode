package common;

import java.util.*;

public class Friend {
    private String name;
    private List<Friend> friendList = new ArrayList<>();
    public static HashSet<String> set = new HashSet<String>();
    public String getName() {
        return name;
    }
    public void setName(String name) {
    }
    public List<Friend> getFriendList() {
        return friendList;
    }
    public void setFriendList(List<Friend> friendList) {
        this.friendList = friendList;
    }
    Friend(String name){
        this.name = name;
    }
    public void addToList(Friend f) {
        this.friendList.add(f);
    }
    public void addFriend(Friend f) {
        addToList(f);
        f.addToList(this);
    }
    public boolean isFriendOf(Friend f) {

        buildFriendsMap(this);
        set.add(f.name);
        if(set.contains(f.getName()))
            return true;
        return false;
    }

    void buildFriendsMap(Friend f){
        for(Friend friend: f.friendList){
            if(this.set.add(friend.name)) {
                buildFriendsMap(friend);
            }
        }
    }

    public static void main(String[] args) {
        Friend f1 = new Friend("a");
        Friend f2 = new Friend("b");
        Friend f3 = new Friend("c");
        Friend f4 = new Friend("d");
        Friend f5 = new Friend("e");
        f1.addFriend(f2);

        f3.addFriend(f4);
        f4.addFriend(f5);
        //
        System.out.println(f3.isFriendOf(f4));
    }
}

