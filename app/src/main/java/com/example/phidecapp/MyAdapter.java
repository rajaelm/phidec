package com.example.phidecapp;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<List_data>list_data;
    LinearLayout hiddenView;
    CardView cardView;
    ImageButton arrow;

    public MyAdapter(List<List_data> list_data) {
        this.list_data = list_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        List_data listData=list_data.get(position);
        holder.txtname.setText(listData.getNom());
        holder.txtemail.setText(listData.getEmail());
        holder.txtrs.setText(listData.getRs());
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }
    public void filterList(ArrayList<List_data> filteredList) {
        list_data = filteredList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtname,txtemail,txtrs;
        private Button buttonA;
        public ViewHolder(View itemView) {
            super(itemView);
            txtname=(TextView)itemView.findViewById(R.id.txt_name);
            txtemail=(TextView)itemView.findViewById(R.id.txt_email);
            txtrs=(TextView)itemView.findViewById(R.id.txt_rs);
            buttonA= (Button) itemView.findViewById(R.id.activeButton);
        }
    }
}
