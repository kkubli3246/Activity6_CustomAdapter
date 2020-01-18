package com.example.customlistadapter;

import android.app.Application;

public class MyApplication extends Application {
    private myFriends myFriends = new myFriends();

    public com.example.customlistadapter.myFriends getMyFriends() {
        return myFriends;
    }

    public void setMyFriends(com.example.customlistadapter.myFriends myFriends) {
        this.myFriends = myFriends;
    }
}
