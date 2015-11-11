package com.ellekay.lucie.fashionhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class Checkout extends AppCompatActivity {
    //Declare frame imageViews


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //creating the circular button
        final com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton mymenu =
                new com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.Builder(this)
                        .build();

        SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(this);
        //Setting icons to the buttons
        ImageView rlIcon1 = new ImageView(this);
        ImageView rlIcon2 = new ImageView(this);
        ImageView rlIcon3 = new ImageView(this);
        ImageView rlIcon4 = new ImageView(this);
        //setting icons for the buttons
        rlIcon1.setImageDrawable(getResources().getDrawable(R.drawable.helpy));
        rlIcon2.setImageDrawable(getResources().getDrawable(R.drawable.business1));
        rlIcon3.setImageDrawable(getResources().getDrawable(R.drawable.cartfull));
        rlIcon4.setImageDrawable(getResources().getDrawable(R.drawable.car));

        //creating the floating action menu subButtos being created dynamically
        final FloatingActionMenu myFloatingMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(rLSubBuilder.setContentView(rlIcon1).build())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon2).build())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon3).build())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon4).build())
                .attachTo(mymenu)
                .build();

        rlIcon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Checkout.this, CatalogActivity.class);
                startActivity(i);
            }
        });
        rlIcon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(Checkout.this, ShoppingCartActivity.class);
                startActivity(i2);
            }
        });
        rlIcon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(Checkout.this, Checkout.class);
                startActivity(i3);
            }
        });
        rlIcon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(Checkout.this, Home.class);
                startActivity(i4);
            }
        });

    }


}
