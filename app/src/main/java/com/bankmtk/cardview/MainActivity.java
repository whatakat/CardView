package com.bankmtk.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        DataSourceBuilder builder = new DataSourceBuilder(getResources());
        final List<Soc> dataSource = builder.build();

        final SocnetAdapter adapter = new SocnetAdapter(dataSource);
        recyclerView.setAdapter(adapter);

        Button add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSource.add(0,new Soc("Yet one autumn",
                        R.drawable.nature7, true));
                adapter.notifyDataSetChanged();
            }
        });

        final Activity that = this;

        adapter.SetOnItemClickListener(new SocnetAdapter.OnItemClicklistener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(that, String.format("Position -%d", position),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
