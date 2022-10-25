package com.example.fuel_management;

import org.json.JSONObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;

public class CustomerModel {

    private String BASE_URL = "";
    private RestTemplate restTemplate = new RestTemplate();

    public List<Customer> findAll(){
        try{
            return restTemplate.exchange(
                    BASE_URL + "findall", HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>(){}
            ).getBody();
        }
        catch (Exception e){
            return null;
        }
    }

    public Customer find(int id){
        try{
            return restTemplate.exchange(
                    BASE_URL + "find/" + id, HttpMethod.GET, null, new ParameterizedTypeReference<Customer>(){}
            ).getBody();
        }
        catch (Exception e){
            return null;
        }
    }

    public boolean create(Customer customer){
        try {
            Map<String, String> values = new HashMap<String, String>();
            values.put("name", customer.getName());
            values.put("litres", String.valueOf(customer.getLitres()));
            values.put("name", customer.getFuelType());
            JSONObject jsonObject = new JSONObject(values);
            HttpHeaders headers = new HttpHeaders();

        }
    }
}
