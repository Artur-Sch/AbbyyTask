package com.sch.abbyytask;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Активити профиля котейки
 */

public class CatProfileActivity extends AppCompatActivity {

    public static String CAT_KEY = "CAT_KEY";

    private ImageView catPhoto;
    private TextView catName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cat_profile_activity);

        catName = findViewById(R.id.pr_text);
        catPhoto = findViewById(R.id.pr_img);

        Bundle bundle = getIntent().getExtras();


        Cat cat = (Cat)bundle.get(CAT_KEY); ;
        catName.setText(cat.getName());
                /**
         * Через клас DownloadImageTask загрузка идет оооочень долго
         */
        new DownloadImageTask(catPhoto).execute(cat.getImageURL());
        /**
         * Через  Picasso загрузка идет быстро и с кэшем. Но это стороняя библиотека
         */
//        Picasso.get().load(cat.getImageURL()).into(catPhoto);

        /**
        * если загрузка картинок из @drawable
        */
//        int imageResourceId = this.getApplicationContext().getResources().getIdentifier(cat.getImageURL(),"drawable", this.getApplicationContext().getPackageName());
//        catPhoto.setImageURL(imageResourceId);
    }


    // обработка нажатия клавиши назад
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out); // анимация перехода
        finish();
    }


}
