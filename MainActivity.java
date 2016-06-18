package net.androidbootcamp.hotfoot;

import android.content.Context;
import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set the date
        long date = System.currentTimeMillis();
        SimpleDateFormat currentDate = new SimpleDateFormat("MM/dd/yyyy");
        String dateString = currentDate.format(date);
        TextView dateDisplay = (TextView)findViewById(R.id.txtDate);
        dateDisplay.setText(dateString);
        Button start = (Button)findViewById(R.id.btnStart);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Introduction.class));
            }
        });
    }

}
