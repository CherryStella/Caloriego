package com.example.android.caloriego;

import android.content.Context;

/**
 * Created by Cherry on 4/16/18.
 */

public class DBSetupInsert {
    private final Context context;


    public DBSetupInsert(Context ctx) {
        this.context = ctx;
    }
    public void setupInsertToFood(String values) {
        DBAdapter db = new DBAdapter(context);
        db.open();
        db.insert("food", "food_id,food_name,food_manufactor_name, food_serving size, food_serving_measurement," +
                "food_serving_name_number,food_serving_name_word,food_energy,food_proteins,food_carbonhydrates,food_fat," +
                        "food_energy_calculated,food_proteins_calculated,food_carbonhydrates_calculated,food_fat_calculated," +
                "food_user_id,food_barcode,food_category_id,food_thumb,food_image_a,food_image_b,food_image_c,food_notes", values);

        db.close();
    }

    public void insertAllFood(){
        setupInsertToFood("Null, 'Nottemiks','First Price','600','gram','1','pakka','512','16.1','37.1','32.3','3072','97','223','194'," +
                "NULL,NULL,'42','first_price_noottemiks_thumb.jpg','first_price_noottemiks_a.jpg','first_price_noottemiks_b.jpg','first_price_noottemiks_c.jpg',NULL");
    }



}
