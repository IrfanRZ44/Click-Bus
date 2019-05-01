package com.exomatik.clickbus.clickbus;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by IrfanRZ on 6/1/2018.
 */

public class SwipeAdapter extends PagerAdapter {
    private int[] image_resources = {R.drawable.s1,
            R.drawable.s2,
            R.drawable.s3};
    private String title[] = {"CARI BUS & PILIH KURSI",
            "PEMBAYARAN TRANSFER",
            "E-TIKET BUS DIKIRIM"};
    private String isi[] = {"Lakukan pencarian bus tujuan anda dan pilih kursi yang tersedia.",
            "Lakukan pembayaran tiket bus secara online tanpa harus ke loket.",
            "Cukup tunjukkan e-tiket bus anda. Tanpa perlu cetak tiket."};

    private Context ctx;
    private LayoutInflater layoutInflater;

    public SwipeAdapter(Context ctx){
        this.ctx=ctx;
    }


    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(RelativeLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout, container, false);

        android.widget.ImageView imageView = (ImageView) item_view.findViewById(R.id.image_view);
        TextView textTitle = (TextView) item_view.findViewById(R.id.text_title);
        TextView textIsis = (TextView) item_view.findViewById(R.id.text_isi);

        imageView.setImageResource(image_resources[position]);
        textTitle.setText(title[position]);
        textIsis.setText(isi[position]);
        container.addView(item_view);

        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }

}
