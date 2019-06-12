package com.sch.abbyytask;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Адаптер для отображения
 */

public class CustomAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<Cat> listCat;
    private TextView textInListView;
    private ImageView imageInListView;


    public CustomAdapter(MainActivity mainActivity, List<Cat> catListst) {
        this.listCat = catListst;
        layoutInflater = (LayoutInflater) mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return listCat.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = layoutInflater.inflate(R.layout.list_view_layout, null);
        textInListView = rowView.findViewById(R.id.text);
        textInListView.setText(listCat.get(position).getName());
        imageInListView = rowView.findViewById(R.id.img);

        /**
         * Через клас DownloadImageTask загрузка идет оооочень долго
         */
        new DownloadImageTask(imageInListView).execute(listCat.get(position).getImageURL());
        /**
         * Через клас Picasso загрузка идет гораздо быстрее
         */
        // Picasso.get().load(listCat.get(position).getImageURL()).into(listViewHolder.imageInListView);

        return rowView;
    }
}
