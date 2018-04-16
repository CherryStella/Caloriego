package com.example.android.caloriego;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stetho.initializeWithDefaults(this);

        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();


        DBAdapter db = new DBAdapter(this);
        db.open();

        int numberRows = db.count("food");

        if(numberRows < 1){
            db.insert("food",
                    "food_id,food_name,food_manufactor_name,food_serving_size,food_serving_measurement,food_energy_calculated",
                    "Null,'Egg,whole,cooked,hard-boiled','Stella','136.0','g','211'");
            db.insert("food","food_id,food_name,food_manufactor_name,food_serving_size,food_serving_measurement,food_energy_calculated",
                    "Null,'Steak,hard-boiled','Stella','136.0','g','232'");
        }

        DBSetupInsert setupInsert = new DBSetupInsert(this);
        setupInsert.insertAllFood();



        db.close();

        Toast.makeText(this,"Database works, food created!",Toast.LENGTH_SHORT).show();
    }
}
