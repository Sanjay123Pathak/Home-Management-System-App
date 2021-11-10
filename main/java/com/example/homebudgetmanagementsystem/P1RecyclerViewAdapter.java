package com.example.homebudgetmanagementsystem;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class P1RecyclerViewAdapter extends RecyclerView.Adapter<P1RecyclerViewAdapter.P1ViewHolder> {
    Context context;
    ArrayList<P1recyclerClass> arrayList;
    CardView cardView;

    public P1RecyclerViewAdapter(Context context, ArrayList<P1recyclerClass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public P1ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.p1_recycler_items_list, parent,
                false);
        return new P1ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull P1ViewHolder holder, int position) {
                    P1recyclerClass p1recyclerClass=arrayList.get(position);
                    holder.image.setImageResource(p1recyclerClass.getImage());
                    holder.nameTxt.setText(p1recyclerClass.getName());
                    holder.item_cost.setText(p1recyclerClass.itemCost);
                    holder.descriptionText.setText(p1recyclerClass.getDescription());
                    holder.dateText.setText(p1recyclerClass.getDateText());


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToNextActivity=new Intent(context,P1RecyclerViewNewActivity.class);
                goToNextActivity.putExtra("image_name",p1recyclerClass.getImage());
                goToNextActivity.putExtra("item_name",p1recyclerClass.getName());
                goToNextActivity.putExtra("item_cost",p1recyclerClass.getItemCost());
                goToNextActivity.putExtra("item_desc",p1recyclerClass.getDescription());
                goToNextActivity.putExtra("choose_date",p1recyclerClass.getDateText());
                goToNextActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(goToNextActivity);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class P1ViewHolder extends RecyclerView.ViewHolder {
        ImageView image,delete_image;
        TextView nameTxt, descriptionText,item_cost,dateText;
        public P1ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            delete_image=itemView.findViewById(R.id.deleteImage);
            delete_image.setVisibility(View.INVISIBLE);
//            for all text name .date,cost,amd description textview
            nameTxt = itemView.findViewById(R.id.name_text);
            item_cost=itemView.findViewById(R.id.cost_text);
            dateText = itemView.findViewById(R.id.date_text);
            descriptionText = itemView.findViewById(R.id.description_text);
//         for card view

            cardView=itemView.findViewById(R.id.cardView);

// click listener on card_view
            cardView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    delete_image.setVisibility(View.VISIBLE);
                    delete_image.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            deleteView(getAdapterPosition());
                            delete_image.setVisibility(View.INVISIBLE);
                        }
                    });

                    return true;
                }
            });


        }
//        this is for deleting the cardView i.e row deleting
        public  void deleteView(int position){
            Toast.makeText(context, "Item deleted successfully !", Toast.LENGTH_SHORT).show();
            arrayList.remove(position);
            notifyDataSetChanged();
        }
    }
}
