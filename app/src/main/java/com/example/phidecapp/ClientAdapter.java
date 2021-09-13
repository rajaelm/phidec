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

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ViewHolder> {
    private List<Client>list_client;
    LinearLayout hiddenView;
    CardView cardView;
    ImageButton arrow;

    public ClientAdapter(List<Client> list_client) {

        this.list_client = list_client;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_client,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClientAdapter.ViewHolder holder, int position) {
        Client listClient=list_client.get(position);
        holder.txtname.setText(listClient.getNom_client());
        holder.txtemail.setText(listClient.getEmail());
        holder.txtrs.setText(listClient.getRs());
    }

    @Override
    public int getItemCount() {
        return list_client.size();
    }
    public void filterList(ArrayList<Client> filteredList) {
        list_client = filteredList;
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
