package net.androidbootcamp.hotfoot;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class Day_2 extends AppCompatActivity
{
    Uri imageUri;
    Uri[] images = new Uri[100];
    ArrayList<Uri> uploadedImages = new ArrayList<Uri>();
    int index = 0;
    Button upload;
    ImageView imageView;
    private static final int PICK_IMAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_2);

        final GridView gridView = (GridView) findViewById(R.id.day2GridView);
        final ImageAdapter adapter = new ImageAdapter(this);
        gridView.setAdapter(adapter);
        adapter.setImageList(uploadedImages);
        upload = (Button)findViewById(R.id.btnUpload);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open the phone's gallery
                OpenGallery();
                adapter.updateImageList(uploadedImages);
            }
        });
    }
    //a method for accessing the phone's internal media
    public void OpenGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            //add the image to the adapter to be added to the list
            uploadedImages.add(index,imageUri);
        }
    }

    //The adapter for the GridView
   public class ImageAdapter extends BaseAdapter
    {
        private Context context;
        ArrayList<Uri> imagelist = new ArrayList<Uri>();
        public ImageAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return index;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            imageView = new ImageView(context);
            imageView.setImageURI(uploadedImages.get(position));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new GridView.LayoutParams(330, 300));
            return imageView;
        }
        public void setImageList(ArrayList<Uri> imagelist)
        {
            this.imagelist = imagelist;
        }
        public void updateImageList(ArrayList<Uri> newImagelist)
        {
            if(this.imagelist != null)
            {
                imagelist.addAll(newImagelist);
            }

            notifyDataSetChanged();
        }


    }


    }


