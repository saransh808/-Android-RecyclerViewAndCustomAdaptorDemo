package com.example.recyclerviewseminar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomDataAdaptor extends RecyclerView.Adapter<CustomDataAdaptor.CustomDataViewHolder> {

    private Context context;
    private ArrayList<MasterData> dataList;
//    private SelectListener listener;

    public CustomDataAdaptor(Context context, ArrayList<MasterData> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public CustomDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomDataViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_for_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomDataViewHolder holder, int position) {
        String name = dataList.get(position).getName();
        holder.data_card_name.setText(name);
        holder.data_card_age.setText(dataList.get(position).getAge().toString());
        if(dataList.get(position).getImgUrl()!=null && !dataList.get(position).getImgUrl().isEmpty()){
//            Picasso.get().load(dataList.get(position).getImgUrl()).into(holder.data_card_img);
            CustomImageHandler handler = new CustomImageHandler(dataList.get(position).getImgUrl(), holder.data_card_img);
            handler.execute();
        }


        holder.data_card_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context.getApplicationContext(), "Clicked for "+name, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class CustomDataViewHolder extends RecyclerView.ViewHolder{
        TextView data_card_name;
        TextView data_card_age;
        ImageView data_card_img;
        CardView data_card_main;

        public CustomDataViewHolder(@NonNull View itemView) {
            super(itemView);
            data_card_name = itemView.findViewById(R.id.data_card_name);
            data_card_age = itemView.findViewById(R.id.data_card_age);
            data_card_img = itemView.findViewById(R.id.data_card_img);
            data_card_main = itemView.findViewById(R.id.data_card_main);
        }
    }
}
