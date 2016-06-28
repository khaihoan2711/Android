package com.google.firebase.codelab.friendlychat.mvvm;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

import android.app.Application;

/**
 * Created by henrytao on 6/19/16.
 */
public class App extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    if (!FirebaseApp.getApps(this).isEmpty()) {
      FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
  }
}
