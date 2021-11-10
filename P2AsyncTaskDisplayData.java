package com.example.homebudgetmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class P2AsyncTaskDisplayData extends AppCompatActivity {
TextView title_name,category_name;
ImageView showImage;
Button displayData;
Random random;
    int[] vegetables = {R.drawable.mixed,
            R.drawable.potato, R.drawable.tamato, R.drawable.bottlegaurd};
    Bitmap bitmap = null;

    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2_async_task_display_data);
        title_name=findViewById(R.id.title);
        category_name=findViewById(R.id.category);
        displayData=findViewById(R.id.displayData);
        showImage=findViewById(R.id.showImage);
//  by default all view al invisible
        title_name.setVisibility(View.INVISIBLE);
        category_name.setVisibility(View.INVISIBLE);
        showImage.setVisibility(View.INVISIBLE);


        displayData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Handler().postDelayed(new Runnable() {


                    @Override
                    public void run() {
                        // This method will be executed once the timer is over

                        MyAsyncTask myAsyncTask= new MyAsyncTask();
                        myAsyncTask.execute();
                        title_name.setVisibility(View.VISIBLE);
                        category_name.setVisibility(View.VISIBLE);
                        showImage.setVisibility(View.VISIBLE);

                    }
                }, 3000);



            }
        });
    }
    public  class MyAsyncTask extends AsyncTask<String, String, Bitmap>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(P2AsyncTaskDisplayData.this);
//            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("Please wait... !");
            progressDialog.show();

        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            random = new Random();
            int images = random.nextInt(vegetables.length);
            // whenever you click the button it shows different images each times
            bitmap=BitmapFactory.decodeResource(getResources(),vegetables[images]);

            return bitmap;
        }
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (showImage != null) {
                progressDialog.hide();
                showImage.setImageBitmap(bitmap);

                // setting the title and category

                String title="Title : Navratri 2017 : 3 ways to wear purple on Navratri";
                String category="Category: Life & Style";
                title_name.setText(title);
                category_name.setText(category);
                Toast.makeText(P2AsyncTaskDisplayData.this, "Data Displayed  ", Toast.LENGTH_SHORT).show();
            } else {
                progressDialog.show();
            }
        }


    }
}