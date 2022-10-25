package com.example.fuel_management;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ViewAnimator;

import static android.R.attr.resource;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class CustomerListAdapter extends ArrayAdapter<Customer> {

    private List<Customer> customers;
    private Context context;

    public CustomerListAdapter(Context context, List<Customer> customers ) {
        super(context, R.layout.customer_layout, customers);
        this.customers = customers;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View conveterView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.customer_layout, parent, false);
        Customer customer = this.customers.get(position);
        TextView textViewName = (TextView) view.findViewById(R.id.txtViewName);
        textViewName.setText(customer.getName());
        TextView textViewLitres = (TextView) view.findViewById(R.id.txtViewLitres);
        textViewLitres.setText(String.valueOf(customer.getLitres()));
        return view;
    }
}
