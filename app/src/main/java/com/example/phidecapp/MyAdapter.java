package com.example.phidecapp;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<List_data>list_data;

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

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtname,txtemail,txtrs;
        public ViewHolder(View itemView) {
            super(itemView);
            txtname=(TextView)itemView.findViewById(R.id.txt_name);
            txtemail=(TextView)itemView.findViewById(R.id.txt_email);
            txtrs=(TextView)itemView.findViewById(R.id.txt_rs);
        }
    }
}
