package com.example.fuel_management;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ListView listViewCustomer;
    private EditText txtDescription;
    private ImageView viewPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);
            List<Customer> customers = new HttpRequestCustomerList().execute().get();
            listViewCustomer = (ListView) findViewById(R.id.listViewCustomer);
            listViewCustomer.setAdapter(new CustomerListAdapter(getApplicationContext(), customers));

        }catch (Exception e){
            AlertDialog.Builder builder =  new AlertDialog.Builder(getApplicationContext());
            builder.setMessage(e.getMessage());
            builder.create().show();
        }

    }

    private class HttpRequestCustomerList extends AsyncTask<Void, Void, List<Customer>> {

        @Override
        protected List<Customer> doInBackground(Void... voids) {
            CustomerModel customerModel = new CustomerModel();
            return customerModel.findAll();
        }

        @Override
        protected void onPostExecute(List<Customer> customers) {
            super.onPostExecute(customers);
        }
    }

}