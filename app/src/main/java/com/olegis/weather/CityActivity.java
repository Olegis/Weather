package com.olegis.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Olegis on 12.03.2018.
 */

public class CityActivity extends AppCompatActivity {
    public static final String EXTRA_CITYNOM = "cityNom";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        // Получить вид погоды города
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int cityNom = bundle.getInt(EXTRA_CITYNOM);
            City city = City.cityes[cityNom];
            Log.d("CityActivity", "cityNom " + cityNom);
            Log.d("CityActivity", "city " + city.getName());
            Log.d("CityActivity", "cityNom " + city.getDescription());
//            Log.d("CityActivity", "cityNom " + city.getImageResourceId());
            // Заполнить ихображение погоды города
//            ImageView photo = (ImageView) findViewById(R.id.photo);
//            photo.setImageResource(city.getImageResourceId());
//            photo.setContentDescription(city.getName());

            // Заполнение наименования города
            TextView name = findViewById(R.id.name);
            name.setText(city.getName());

            // Заполнение описания погоды города
            TextView description = findViewById(R.id.description);
            description.setText(city.getDescription());
        }
    }
}
