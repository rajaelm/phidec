package com.example.phidecapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;


import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.ViewHolder> {
    private List<Car> list_car;
    LinearLayout hiddenView;
    CardView cardView;
    ImageButton arrow;

    public CarsAdapter(List<Car> list_car) {
        this.list_car = list_car;
    }

    @Override
    public CarsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_car,parent,false);

        return new CarsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarsAdapter.ViewHolder holder, int position) {
        Car listCar=list_car.get(position);
        holder.txtname.setText(listCar.getNom());
        holder.txtmatricule.setText(listCar.getMatricule());
        holder.txtconducteur.setText(listCar.getConducteur());
    }

    @Override
    public int getItemCount() {
        return list_car.size();
    }
    public void filterList(ArrayList<Car> filteredList) {
        list_car = filteredList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtname,txtmatricule,txtconducteur;
        private Button buttonA;
        public ViewHolder(View itemView) {
            super(itemView);
            txtname=(TextView)itemView.findViewById(R.id.txt_name);
            txtmatricule=(TextView)itemView.findViewById(R.id.txt_matricule);
            txtconducteur=(TextView)itemView.findViewById(R.id.txt_conducteur);
            buttonA= (Button) itemView.findViewById(R.id.activeButton);
        }
    }
}
