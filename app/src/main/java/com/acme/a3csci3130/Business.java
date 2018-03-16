package com.acme.a3csci3130;

/**
 * Created by brandonhussey on 2018-03-15.
 */

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Business implements Serializable {

    public String busId;
    public String name;
    public String number;
    public String province;
    public String address;
    public String primary;


    public Business() {}

    public Business(String busId, String name, String number, String province, String address, String primary){
        this.busId = busId;
        this.name = name;
        this.number = number;
        this.province = province;
        this.address = address;
        this.primary = primary;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("Business ID", busId);
        result.put("Name", name);
        result.put("Number", number);
        result.put("Province", province);
        result.put("Address", address);
        result.put("Primary", primary);

        return result;
    }
}