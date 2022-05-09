package com.example.recyclerviewseminar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class CustomRecyclerView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        generateCards();
    }

    private void generateCards() {
        DataInitializer dataInit = DataInitializer.getSingletonInitializer();
        ArrayList<MasterData> list = dataInit.getData();

        if (list != null && !list.isEmpty()) {
            RecyclerView recyclerView;
            CustomDataAdaptor adaptor;

            recyclerView = findViewById(R.id.my_recycler_view);
            adaptor = new CustomDataAdaptor(this, list);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recyclerView.setAdapter(adaptor);
        }

    }
}