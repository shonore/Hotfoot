package net.androidbootcamp.hotfoot;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Timer;
import java.util.TimerTask;


public class Splash extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                //when the timer is done switch to next activity
                startActivity(new Intent(Splash.this, MainActivity.class));

            }
        };
        Timer opening = new Timer();
        opening.schedule(task,3000); //set timer for 5 seconds
    }



}
