package net.androidbootcamp.hotfoot;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;

/**
 * Created by Stephanie on 6/13/16.
 */
public class InformationFooter extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.footer);
        Button next1 = (Button)findViewById(R.id.btnInfo);
        next1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(InformationFooter.this, Day_1.class));
            }
        });

    }
}
