package com.example.customlistadapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class myFriends {
    List<Person> myFriendsList;

    public myFriends(List<Person> myFriends) {
        this.myFriendsList = myFriends;
    }

    public  myFriends(){
        String[] startingList = {"Ash", "Bob", "Cathy"};
        Random r = new Random();
        this.myFriendsList = new ArrayList<Person>();
        for (int i = 0; i < startingList.length; i++){
            Person p = new Person(startingList[i], r.nextInt(50), r.nextInt(10));
            this.myFriendsList.add(p);
        }
    }



    public List<Person> getMyFriends() {
        return myFriendsList;
    }

    public void setMyFriends(List<Person> myFriends) {
        this.myFriendsList = myFriends;
    }
}
