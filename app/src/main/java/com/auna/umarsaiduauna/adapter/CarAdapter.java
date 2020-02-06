package com.auna.umarsaiduauna.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.auna.umarsaiduauna.R;
import com.auna.umarsaiduauna.model.Cars;

import java.util.List;
import java.util.Objects;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

     List<Cars> carsList;
    List<String> getCountriesn;
     Context mContext;
    public CarAdapter(Context context,List<Cars> carsList){
        this.mContext = context;
        this.carsList = carsList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(mContext).inflate(R.layout.items_cars_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.gender.setText(carsList.get(position).getGender());
        holder.years.setText(carsList.get(position).getStartYear()+" - "+ carsList.get(position).getEndYear());
        //holder.countries.setText( carsList.get(position).getCountries());

    }


    @Override
    public int getItemCount() {
        return carsList == null ? 0 : carsList.size();
    }

    public class ViewHolder extends BaseViewHolder{
        TextView years, gender, countries, colors;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            years = itemView.findViewById(R.id.years);
            gender = itemView.findViewById(R.id.gender);
            countries = itemView.findViewById(R.id.countries);
            colors = itemView.findViewById(R.id.colors);
        }

    }

}
