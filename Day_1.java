package net.androidbootcamp.hotfoot;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;


public class Day_1 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_1);
        long date = System.currentTimeMillis();
        SimpleDateFormat currentDate = new SimpleDateFormat("MM/dd/yyyy");
        String dateString = currentDate.format(date);
        TextView dateDisplay = (TextView)findViewById(R.id.day1Date);
        dateDisplay.setText(dateString);
        Button btnDay1 = (Button)findViewById(R.id.btnDay1);
        btnDay1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Day_1.this, Day_2.class));

        }
    });


    }
}
