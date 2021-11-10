package com.example.homebudgetmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int mYear, mMonth, mDay;
    TextView chooseDate;
    DatePickerDialog datePickerDialog;
    Calendar c;
    //  all edittext and button initialization
    EditText itemName,itemCost,itemDescription;
    Button addItems;
    Random random,random1;
    int [] vegetables={R.drawable.mixed,R.drawable.tomato_potato,
            R.drawable.potato,R.drawable.tamato,R.drawable.bottlegaurd,R.drawable.brinjal,R.drawable.ladyfingers,R.drawable.carrot,
            R.drawable.radish,R.drawable.cauliflower};

  private  String iName,iCost,iDescription,iDate;
//    RecyclerView
    RecyclerView recyclerView;
    ArrayList<P1recyclerClass> arrayList;
    P1RecyclerViewAdapter p1RecyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       itemName=findViewById(R.id.item_name);
       itemCost=findViewById(R.id.item_cost);
       itemDescription=findViewById(R.id.item_Description);

        chooseDate = findViewById(R.id.chooseDate);
        addItems=findViewById(R.id.add_item);

        recyclerView=findViewById(R.id.recyclerView);
        myRecyclerDetails();


    }
//    click listener on choose data text and setting the date on it
    public void setDate(View view) {

            // Get Current Date
            c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
            datePickerDialog = new DatePickerDialog(MainActivity.this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            chooseDate.setText(dayOfMonth + " / " + (monthOfYear + 1) + " /" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
// setting arraylist,adapter ,recyclerview and linearLayoutManager and then calling it ot main method i.o onCreate
        public  void myRecyclerDetails(){
            String nameList[]={"Sanjay","Anil","Rohan","Anup","Vikas","Rahul"};
            int storeLength=vegetables.length;
            random= new Random();
            int randomImage=random.nextInt(storeLength);
            arrayList= new ArrayList<>();
          for (int count=0;count<nameList.length;count++){
              arrayList.add(new P1recyclerClass(vegetables[randomImage],nameList[count],"5000","abc","2021/09/28"));
          }
           p1RecyclerViewAdapter= new P1RecyclerViewAdapter(this,arrayList);
          recyclerView.setAdapter(p1RecyclerViewAdapter);
            LinearLayoutManager linearLayoutManager= new
                    LinearLayoutManager(getApplicationContext(),
                    LinearLayoutManager.VERTICAL,true);
            recyclerView.setLayoutManager(linearLayoutManager);
        }

        //getting date from textView and editView
    public  void  getItemDetails(){
        iName=itemName.getText().toString().trim().toUpperCase();
        iCost=itemCost.getText().toString().trim().toUpperCase();
        iDescription=itemDescription.getText().toString().trim();
        iDate=chooseDate.getText().toString().trim().toUpperCase();

    }
    // click listener on add button
    public void addItems(View view) {
        getItemDetails();
        Toast.makeText(this, "Items added Successfully !", Toast.LENGTH_SHORT).show();
        random1= new Random();
        int images=random1.nextInt(vegetables.length);
        P1recyclerClass p1recyclerClass= new P1recyclerClass(vegetables[images],iName,"Rs " + iCost,iDescription,iDate);
        arrayList.add(p1recyclerClass);
        p1RecyclerViewAdapter.notifyDataSetChanged();

        // after adding the all details setting the text to its previous position
        itemName.setText("");
        itemCost.setText("");
        itemDescription.setText("");
        chooseDate.setText("Choose the Date");
    }


}