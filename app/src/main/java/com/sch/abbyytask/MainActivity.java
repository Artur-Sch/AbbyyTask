package com.sch.abbyytask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    public static List<Cat> catsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catsList = getAllCats(); // создали котеек

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(new CustomAdapter(this, catsList));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Cat cat = catsList.get(position);

                Intent intent = new Intent(MainActivity.this , CatProfileActivity.class);
                intent.putExtra(CatProfileActivity.CAT_KEY, cat);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // анимация перехода
                finish();
            }
        });
    }

    /*
    Добвляем котеек
     */
    private List<Cat> getAllCats(){
        List<Cat> items = new ArrayList<>();
        items.add(new Cat("Барсик", "http://pngimg.com/uploads/cat/cat_PNG50546.png"));
        items.add(new Cat("Кэсис", "http://pngimg.com/uploads/cat/cat_PNG50537.png"));
        items.add(new Cat("Ферруцио", "http://pngimg.com/uploads/cat/cat_PNG50525.png"));
        items.add(new Cat("Клементе", "http://pngimg.com/uploads/cat/cat_PNG50511.png"));
        items.add(new Cat("Грампи", "http://pngimg.com/uploads/cat/cat_PNG50498.png"));
        items.add(new Cat("Юппи", "http://pngimg.com/uploads/cat/cat_PNG50480.png"));
        items.add(new Cat("Шелли", "http://pngimg.com/uploads/cat/cat_PNG50433.png"));
        items.add(new Cat("Кактус", "http://pngimg.com/uploads/cat/cat_PNG50425.png"));
        items.add(new Cat("Леопардо", "http://pngimg.com/uploads/cat/cat_PNG120.png"));
        items.add(new Cat("Жуля", "http://pngimg.com/uploads/cat/cat_PNG104.png"));

//        items.add(new Cat("Барсик", "cat_1"));
//        items.add(new Cat("Кэсис", "cat_2"));
//        items.add(new Cat("Ферруцио", "cat_3"));
//        items.add(new Cat("Клементе", "cat_4"));
//        items.add(new Cat("Грампи", "cat_5"));
//        items.add(new Cat("Юппи", "cat_6"));
//        items.add(new Cat("Шелли", "cat_7"));
//        items.add(new Cat("Кактус", "cat_8"));
//        items.add(new Cat("Леопардо", "cat_9"));
//        items.add(new Cat("Жуля", "cat_10"));
        return items;
    }

}
