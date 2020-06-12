package com.example.myapplication;
import android.os.StrictMode;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpRequest11 {
    private OkHttpClient client;
    public List<Disaster> get_all_disasters(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url("https://ase.zhaojiajin.club/disaster/getall")
                .method("GET", null)
                .build();
        Call call=client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //System.out.println(response.body().string());
            final String string = response.body().string();
            return parseJSONWithJSONObject2(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String reportDisaster(double longitude, double latitude,double radius,String type,int lvl,int people,int startTime,int endTime){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json,text/plain");
        RequestBody body = RequestBody.create(mediaType, "{\n    \"longitude\":" + longitude + ",\n    \"latitude\":" + latitude + ",\n    \"radius\":" + radius + ",\n    \"type\":\"" + type + "\",\n    \"lvl\":" + lvl + ",\n    \"people\": " + people + ",\n    \"startTime\":" + startTime + ",\n    \"endTime\":" + endTime + "\n }");

        final Request request = new Request.Builder()
                .url("https://ase.zhaojiajin.club/disaster/report")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Call call=client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //System.out.println(response.body().string());
            final String string = response.body().string();
            return string;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean set_assemblyPoint(String id,String aaa, String  bbb){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json,application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n    \"id\":\""+id+ "\",\n    \"assembly_lat\":\""+aaa+  "\",\n    \"assembly_ln\":\""+bbb+"\"\n}");
        final Request request = new Request.Builder()
                .url("https://ase.zhaojiajin.club/disaster/setassemblypoint")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Type", "application/json")
                .build();
        Call call=client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
            if(response.code()==200) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean finsih_disaster(String id){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"id\":\""+id+"\"}");
        final Request request = new Request.Builder()
                .url("https://ase.zhaojiajin.club/disaster/finish")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Call call=client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
            if(response.code()==200) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean register(String id, String pw){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json,application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n    \"email\":\""+id+ "\",\n    \"pwd\":\""+pw+"\"\n}");
        final Request request = new Request.Builder()
                .url("https://ase.zhaojiajin.club/user/register")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Type", "application/json")
                .build();
        Call call=client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
            if(response.code()==200) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean login(String id, String pw){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json,application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n    \"email\": \""+id+ "\",\n    \"pwd\": \""+pw+"\"\n}");
        final Request request = new Request.Builder()
                .url("https://ase.zhaojiajin.club/user/login")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Type", "application/json")
                .build();;
        Call call=client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
            if(response.code()==200) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Vehicle> query_disaster(String disasterID){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"id\":\""+disasterID+"\"}");
        final Request request = new Request.Builder()
                .url("https://ase.zhaojiajin.club/disaster/query")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Call call=client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //System.out.println(response.body().string());
            final String string = response.body().string();
            return parseJSONWithJSONObject1(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public FreeVehicle query_free_vehicles(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url("https://ase.zhaojiajin.club/vehicle/query")
                .method("GET", null)
                .build();
        Call call=client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //System.out.println(response.body().string());
            final String string = response.body().string();

            return parseJSONWithJSONObject3(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String dispatch_vehicles(String id_dispatch,int vehicle0,int vehicle1,int vehicle2,int vehicle3){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json,application/json");
        RequestBody body = RequestBody.create(mediaType, "{ \"0\": "+vehicle0+",  \"1\":"+vehicle1+",  \"2\":"+vehicle2+",  \"3\": "+vehicle3+ "}");
        final Request request = new Request.Builder()
                .url("https://ase.zhaojiajin.club/vehicle/dispatch?disaster_id="+id_dispatch)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Content-Type", "application/json")
                .build();
        Call call=client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //System.out.println(response.body().string());
            final String string = response.body().string();
            return string;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void parseJSONWithJSONObject(String JsonData) {
        try {
            JSONObject obj = new JSONObject(JsonData);
            Iterator<String> male_Iterator = obj.keys();
            while(male_Iterator.hasNext()){
                // 获得key
                String key = male_Iterator.next();
                //根据key获得value, value也可以是JSONObject,JSONArray,使用对应的参数接收即可
                String value = obj.getString(key);
                Log.v("00000:", key+" "+value);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //2 layers json
    public List<Disaster> parseJSONWithJSONObject2(String JsonData) {
        try {
            JSONObject reader = new JSONObject(JsonData);
            Iterator<String> keys1 = reader.keys();

            List list=new ArrayList();

            while(keys1.hasNext()){
                String key = keys1.next();  //
                Disaster disaster=new Disaster();
                //根据key获得value, value也可以是JSONObject,JSONArray,使用对应的参数接收即可
                //Log.v("obj:",key);

                disaster.id=key;

                String value = reader.getString(key);
                JSONObject reader2 = new JSONObject(value);
                Iterator<String> keys2 = reader2.keys();
                int k=0;
                while(keys2.hasNext()){
                    String keyy = keys2.next();
                    String value2 = reader2.getString(keyy);
                   // Log.v("member:",keyy+" "+value2);
                    k=k+1;
                    if(k==1)  disaster.assembly_lat=Double.valueOf(value2.toString());
                    if(k==2)  disaster.assembly_ln=Double.valueOf(value2.toString());
                    if(k==3)  disaster.endTime=Integer.valueOf(value2.toString());
                    if(k==4)  disaster.latitude=Double.valueOf(value2.toString());
                    if(k==5)  disaster.longitude=Double.valueOf(value2.toString());
                    if(k==6)  disaster.lvl=Integer.valueOf(value2.toString());
                    if(k==7)  disaster.people=Integer.valueOf(value2.toString());
                    if(k==8)  disaster.radius=Double.valueOf(value2.toString());
                    if(k==9)  disaster.req_route=parseJSONWithJSONObject4(value2);
                    if(k==10) disaster.start_time=Integer.valueOf(value2.toString());
                    if(k==11) disaster.type=value2;
                }
                list.add(disaster);
               // Log.v("obj",disaster[j]);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Vehicle> parseJSONWithJSONObject1(String JsonData) {
        try {
            JSONObject reader = new JSONObject(JsonData);
            Iterator<String> keys1 = reader.keys();

            List list=new ArrayList();

            while(keys1.hasNext()){
                String key = keys1.next();
                Vehicle vehicle=new Vehicle();
                Log.v("obj:",key);

                vehicle.id=key;
                String value = reader.getString(key);
                JSONObject reader2 = new JSONObject(value);
                Iterator<String> keys2 = reader2.keys();
                int k=0;
                while(keys2.hasNext()){
                    String keyy = keys2.next();
                    String value2 = reader2.getString(keyy);
                    Log.v("member:",keyy+" "+value2);
                    k=k+1;
                    if(k==1)  vehicle.des_lat=Double.valueOf(value2.toString());
                    if(k==2)  vehicle.des_ln=Double.valueOf(value2.toString());
                    if(k==3)  vehicle.disaster_id=value2;
                    if(k==4)  vehicle.latitude=Double.valueOf(value2.toString());
                    if(k==5)  vehicle.longitude=Double.valueOf(value2.toString());
                    if(k==6)  vehicle.type=Integer.valueOf(value2.toString());
                }
                list.add(vehicle);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public FreeVehicle parseJSONWithJSONObject3(String JsonData) {
        try {
            JSONObject reader = new JSONObject(JsonData);
            Iterator<String> keys1 = reader.keys();

            int k=0;
            FreeVehicle freevehicle=new FreeVehicle();
            while(keys1.hasNext()){
                String key = keys1.next();
                String value2 = reader.getString(key);
              //  Log.v("member:",keyy+" "+value2);
                if(k==0)  freevehicle.type0=Integer.valueOf(value2.toString());
                if(k==1)  freevehicle.type1=Integer.valueOf(value2.toString());
                if(k==2)  freevehicle.type2=Integer.valueOf(value2.toString());
                if(k==3)  freevehicle.type3=Integer.valueOf(value2.toString());
                k=k+1;
                }
            return freevehicle;
        } catch (JSONException e) {
            e.printStackTrace();
        }
            return null;
    }

    public List<Location1> parseJSONWithJSONObject4(String JsonData) {

        JSONArray array = new JSONArray();
        try {
            List list=new ArrayList();
            array = new JSONArray(JsonData);
            for(int i=0; i<array.length(); i++) {
                JSONObject jsonObj = array.getJSONObject(i);
                String location=jsonObj.toString();
           //     Log.v("obj",location);

                Location1 location1=new Location1();
                location1=parseJSONWithJSONObject5(location);
              //  Log.v("obj1",String.valueOf(location1.longitude)+" "+String.valueOf(location1.latitude));
                list.add(location1);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Location1 parseJSONWithJSONObject5(String JsonData) {

        try {
            JSONObject reader = new JSONObject(JsonData);
            Iterator<String> keys1 = reader.keys();

            int k=0;
            Location1 location1= new Location1();
            while(keys1.hasNext()){
                String key = keys1.next();
                String value2 = reader.getString(key);
               // Log.v("member:",key+" "+value2);
                if(k==0)  location1.longitude=Double.valueOf(value2.toString());
                if(k==1)  location1.latitude=Double.valueOf(value2.toString());
                k=k+1;
            }
            return location1;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static class Disaster{
        String id="110";
        double assembly_lat=0;
        double assembly_ln= 0;
        int endTime = 0;
        double latitude = 0;
        double longitude = 0;
        int lvl = 1;
        int people = 123;
        double radius = 1.3;
        List req_route=new ArrayList();
        int start_time= 1587660819;
        String type = "\"flood\"";
    }

    public static class Vehicle{
        String id="110";
        double des_lat=0;
        double des_ln=0;
        String disaster_id="120";
        double latitude= 0;
        double longitude= 0;
        int type= 2;
    }

    public static class FreeVehicle{
        int type0=0;
        int type1=0;
        int type2=0;
        int type3=0;
    }

    public static class Location1{
        double longitude=0;
        double latitude=0;
    }
}

//\"assembly_lat\":" + assembly_lat + ",\n    \"assembly_ln\":" + assembly_ln + "\n