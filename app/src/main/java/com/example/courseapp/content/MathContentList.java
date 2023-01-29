package com.example.courseapp.content;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.courseapp.R;
import com.example.courseapp.model.ContentData;

import java.util.ArrayList;
import java.util.List;

public class MathContentList extends AppCompatActivity {

    RecyclerView recyclerView;
    List<ContentData> dataList;
    ContentAdapter adapter;
    ContentData androidData;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathroom);

        recyclerView = findViewById(R.id.recycleView);
        searchView = findViewById(R.id.search);
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(MathContentList.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList = new ArrayList<>();

        androidData = new ContentData("Persamaan",R.string.persamaan,R.drawable.rec_card);
        dataList.add(androidData);

        androidData = new ContentData("aljabar",R.string.aljabar,R.drawable.rec_card);
        dataList.add(androidData);

        androidData = new ContentData("trigonometri",R.string.trigonometri,R.drawable.rec_card);
        dataList.add(androidData);

        androidData = new ContentData("fungsi",R.string.fungsi,R.drawable.rec_card);
        dataList.add(androidData);

        androidData = new ContentData("himpunan",R.string.himpunan,R.drawable.rec_card);
        dataList.add(androidData);

        adapter = new ContentAdapter(MathContentList.this,dataList);
        recyclerView.setAdapter(adapter);

    }

    private void searchList(String text){
        List<ContentData> dataSearchList = new ArrayList<>();
        for (ContentData data : dataList  ) {
            if (data.getDataTitle().toLowerCase().contains(text.toLowerCase())){
                dataSearchList.add(data);
            }
        }
        if (dataSearchList.isEmpty()){
            Toast.makeText(this,"Tidak ditemukan", Toast.LENGTH_SHORT).show();
        }else{
            adapter.setSearchList(dataSearchList);
        }

    }



}