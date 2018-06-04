package com.olegis.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Olegis on 12.03.2018.
 */

public class CityCategoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_category_activity);
        RecyclerView citysCategoriesRecyclerView = findViewById(R.id.recycler_view); //Найдем наш RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); //Создадим LinearLayoutManager
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);//Обозначим ориентацию
        citysCategoriesRecyclerView.setLayoutManager(layoutManager);//Назначим нашему RecyclerView созданный ранее layoutManager
        citysCategoriesRecyclerView.setAdapter(new MyAdapter(City.cityes));//Назначим нашему RecyclerView адаптер
    }

    //Класс, который содержит в себе все элементы списка
    private class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView categoryNameTextView;
//        private TextView categoryDescriptionTextView;

        MyViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.category_list_item, parent, false));
            itemView.setOnClickListener(this);
            categoryNameTextView = itemView.findViewById(R.id.category_name_text_view);
//            categoryDescriptionTextView = itemView.findViewById(R.id.category_description_text_view);
        }

        void bind(String category) { //} String description) {
//            String category = city.getName();
            if (getLayoutPosition() != RecyclerView.NO_POSITION) {
                categoryNameTextView.setText(category);
//                categoryDescriptionTextView.setText(category);
            }
        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            showCityActivity(position == RecyclerView.NO_POSITION ? 0 : position);
        }
    }

    //Адаптер для RecyclerView
    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        private final City[] cities;

        MyAdapter(City[] cityes) {
            this.cities = cityes;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
            return new MyViewHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.bind(cities[position].getName()); //cities[position].getDescription());
        }

        @Override
        public int getItemCount() {
            return cities.length;
        }
    }

    //Запускаем активити для конкретного города
    private void showCityActivity(int categoryId) {
        Intent intent = new Intent(this, CityActivity.class);
        intent.putExtra(CityActivity.EXTRA_CITYNOM, categoryId);
        startActivity(intent);
    }
}
