package com.example.homebudgetmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class P1RecyclerViewNewActivity extends AppCompatActivity {
ImageView imageView;
TextView nameTxt,costTxt,descText,dateText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p1_recycler_view_new);

        imageView=findViewById(R.id.imageId);
        nameTxt=findViewById(R.id.itemName);
        costTxt=findViewById(R.id.costName);
        descText=findViewById(R.id.descName);
        dateText=findViewById(R.id.dateName);

        imageView.setImageResource(getIntent().getIntExtra("image_name",0));
        nameTxt.setText(getIntent().getStringExtra("item_name"));
        costTxt.setText(getIntent().getStringExtra("item_cost"));
        descText.setText(getIntent().getStringExtra("item_desc"));
        dateText.setText(getIntent().getStringExtra("choose_date"));

    }
}