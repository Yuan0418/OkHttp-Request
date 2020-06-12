package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewResult;
    private Button getBtn;
    private static final String TAG = "MainActivity";
    private OkHttpClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult=(TextView) findViewById(R.id.text_view_result);
        getBtn=(Button)findViewById(R.id.btnAddEdit);
        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HttpRequest11 hq=new HttpRequest11();

/*
                //1. report disaster
                double longitude = -6.2546;
                double latitude = 53.3438;
                double radius = 1.3;
                String type = "flood";
                int lvl = 1;
                int people = 123;
                int startTime = 1581007055;
                int endTime = 0;

                String id=hq.reportDisaster(longitude,  latitude, radius, type, lvl, people, startTime, endTime);
                Log.v("report disaster:", id);


                //set assembly point
                String id2="1136AFC576003000";
                String assembly_lat = "53.3540786";
                String assembly_ln ="-6.259978";
                hq.set_assemblyPoint(id2,assembly_lat,assembly_ln);


                //2. get all disaster
                //Log.v("get_all_disasters:", all_dis);

                List<HttpRequest11.Disaster> list=hq.get_all_disasters();

                for(int i = 0; i < list.size(); i++){
                    //System.out.println(list.get(i));
                    Log.v("get_all_disasters"+i,list.get(i).id);
                    Log.v("get_all_disasters"+i,String.valueOf(list.get(i).assembly_lat));
                    Log.v("get_all_disasters"+i,String.valueOf(list.get(i).assembly_ln));
                    Log.v("get_all_disasters"+i,String.valueOf(list.get(i).lvl));
                    Log.v("get_all_disasters"+i,String.valueOf(list.get(i).endTime));
                    Log.v("get_all_disasters"+i,String.valueOf(list.get(i).latitude));
                    Log.v("get_all_disasters"+i,String.valueOf(list.get(i).longitude));
                    Log.v("get_all_disasters"+i,String.valueOf(list.get(i).people));
                    Log.v("get_all_disasters"+i,String.valueOf(list.get(i).radius));
                    Log.v("get_all_disasters"+i,String.valueOf(list.get(i).start_time));
                    Log.v("get_all_disasters"+i,String.valueOf(list.get(i).req_route));
                    Log.v("get_all_disasters"+i,String.valueOf(list.get(i).type));
                }

                //3. finish disaster 1136AFC576003000
                String id_finish="\"1136AFC576003000\"";
                hq.finsih_disaster(id_finish);

                //4. query disaster
                String disasterID="1164FD94C9001000";
                List<HttpRequest11.Vehicle> vehicleList=hq.query_disaster(disasterID);
                //Log.v("query_dis_vehicles:", query_dis);
                for(int i = 0; i < vehicleList.size(); i++) {

                    Log.v("query_dis_vehicles:" + i, vehicleList.get(i).id);
                    Log.v("query_dis_vehicles" + i, String.valueOf(vehicleList.get(i).des_lat));
                    Log.v("query_dis_vehicles" + i, String.valueOf(vehicleList.get(i).des_ln));
                    Log.v("query_dis_vehicles" + i, String.valueOf(vehicleList.get(i).latitude));
                    Log.v("query_dis_vehicles" + i, String.valueOf(vehicleList.get(i).longitude));
                    Log.v("query_dis_vehicles" + i, String.valueOf(vehicleList.get(i).type));
                    Log.v("query_dis_vehicles" + i, String.valueOf(vehicleList.get(i).disaster_id));
                }




                //5. query free vehicles
                HttpRequest11.FreeVehicle freeVehicle=hq.query_free_vehicles();
                Log.v("query_free_vehicles:", String.valueOf(freeVehicle.type0));
                Log.v("query_free_vehicles:", String.valueOf(freeVehicle.type1));
                Log.v("query_free_vehicles:", String.valueOf(freeVehicle.type2));
                Log.v("query_free_vehicles:", String.valueOf(freeVehicle.type3));
                //parseJSONWithJSONObject(query_freeVehicles);

                //6. dispatch_vehicles
                //&#x5fc5;&#x987b;&#x56db;&#x4e2a;vehicle&#x90fd;&#x6709;&#x6570;&#x636e;&#xff01;
                String id_dispatch="1164FD94C9001000";
                int vehicle0=1;//vehicle type
                int vehicle2=0;
                int vehicle3=0;
                int vehicle4=0;
                String dispatch_result=hq.dispatch_vehicles(id_dispatch,vehicle0,vehicle2,vehicle3,vehicle4);
                Log.v("dispatch_vehicles:", dispatch_result);//no return(return fine means ok)
 */
                //7. register
                String id="xiguo@tcd.ie";
                String pwd="123";
                String pwd1="1231";
                //hq.register(id, pwd);

                //8.log in
                if(hq.login(id,pwd)) Log.v("np:", id);
                else Log.v("no:", id);


            }
        });
    }
}
