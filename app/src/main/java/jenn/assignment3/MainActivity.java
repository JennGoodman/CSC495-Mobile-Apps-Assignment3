package jenn.assignment3;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    int tryCount = 0;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

    public void onClickSubmit (View v) {
        EditText user = (EditText) findViewById(R.id.textUsername);
        EditText pass = (EditText) findViewById(R.id.textPassword);
        String valid = "Invalid Username/Password (" + ++tryCount + ")Tries";

        if (user.getText().toString().equals(pass.getText().toString())) {
            valid = "Valid Username/Password";
            tryCount = 0;
        }

        NotificationCompat.Builder myNotify = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_stat_a3)
                .setContentTitle("Assignment 3")
                .setContentText(valid);

        NotificationManager notifyMan = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);

        notifyMan.notify(5777, myNotify.build());
    }
}
