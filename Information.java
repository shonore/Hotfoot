package net.androidbootcamp.hotfoot;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class Information extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] teamTitles = {"Decider", "Facilitator", "Customer Service Expert", "Financial Expert",
                "Marketing Expert", "Technical Expert", "Design Expert"};
        View headerView = getLayoutInflater().inflate(R.layout.header, null);
        View footerView = getLayoutInflater().inflate(R.layout.footer, null);
        TextView titleView = (TextView) headerView.findViewById(R.id.txtTeamTitle);
        TextView sprintDescrip = (TextView) headerView.findViewById(R.id.txtTeamDescription);
        ImageView graphic = (ImageView) findViewById(R.id.imgGraphic);
        getListView().addHeaderView(headerView);
        getListView().addFooterView(footerView, null, true);
        Button next1 = (Button) footerView.findViewById(R.id.btnInfo);
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_information, R.id.teamList, teamTitles));
        next1.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event)
            {
                int action = event.getAction();
                switch(action){
                    case MotionEvent.ACTION_DOWN:
                        startActivity(new Intent(Information.this,Day_1.class));
                        break;
                }
                return true;
            }
        });
    }
    //method for when user clicks list item
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        TextView Description = (TextView)findViewById(R.id.txtDescription);

        switch(position)
        {
            case 1:
                Description.setText(R.string.txtDeciderDescription);
                break;
            case 2:
                Description.setText("Meow");
                break;
            case 3:
                Description.setText("Woof");
                break;
            case 4:
                Description.setText("Moo");
                break;
            case 5:
                Description.setText("Baaa");
                break;
            case 6:
                Description.setText("Grrr");
                break;
            case 7:
                Description.setText("Peep");
                break;
        }
    }

}
