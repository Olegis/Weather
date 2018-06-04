package com.olegis.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class TopActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        TextView citySelectionView = findViewById(R.id.city_selection_view);
        TextView forecast3View = findViewById(R.id.forecast3_view);
        TextView forecastWeekView = findViewById(R.id.forecast_week_view);

        citySelectionView.setOnClickListener(this);
        forecast3View.setOnClickListener(this);
        forecastWeekView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.city_selection_view || id == R.id.forecast3_view || id == R.id.forecast_week_view) {
            Intent intent = new Intent(this, CityCategoryActivity.class);
            startActivity(intent);
        }
    }
}
