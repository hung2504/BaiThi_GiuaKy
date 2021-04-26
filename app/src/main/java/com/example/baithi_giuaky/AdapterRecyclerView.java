package com.example.baithi_giuaky;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.CoffeeViewHolder> {
    private ArrayList<Coffee> listCoffee;
    private onClickListener mListener;

    public interface onClickListener{
        void onItemClick(int position);
    }
    public void setOnClick(onClickListener listener){
        this.mListener = listener;
    }

    public AdapterRecyclerView(ArrayList<Coffee> listCoffee) {
        this.listCoffee = listCoffee;
    }

    @NonNull
    @Override
    public CoffeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        CoffeeViewHolder cvh = new CoffeeViewHolder(v,mListener);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeViewHolder holder, int position) {

        Coffee coffee = listCoffee.get(position);

        holder.imageView.setBackgroundResource(coffee.getImagesCoffee());
        holder.tvName.setText(coffee.getNameCoffee());
        holder.tvPrice.setText(coffee.getPriceCoffee()+"$");
    }

    @Override
    public int getItemCount() {
        return listCoffee.size();
    }

    public class CoffeeViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView tvName;
        private TextView tvPrice;

        public CoffeeViewHolder(@NonNull View itemView,onClickListener listener) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imagesA);
            tvName = itemView.findViewById(R.id.tvNameA);
            tvPrice = itemView.findViewById(R.id.tvPriceA);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
