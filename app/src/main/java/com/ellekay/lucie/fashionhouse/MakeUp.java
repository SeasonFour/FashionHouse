package com.ellekay.lucie.fashionhouse;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;


public class MakeUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_make_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Eye"));
        tabLayout.addTab(tabLayout.newTab().setText("Facial"));
        tabLayout.addTab(tabLayout.newTab().setText("Nails"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        //creating the circular button
        final com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton mymenu =
                new com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.Builder(this)
                        .build();

        SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(this);
        //Setting icons to the buttons
        ImageView helpIcon = new ImageView(this);
        ImageView checkoutIcon = new ImageView(this);
        ImageView makeUp = new ImageView(this);
        ImageView homeIcon = new ImageView(this);
        ImageView profileIcon = new ImageView(this);

        //setting icons for the buttons
        checkoutIcon.setImageDrawable(getResources().getDrawable(R.drawable.cartfull));
        makeUp.setImageDrawable(getResources().getDrawable(R.drawable.makeupy));
        homeIcon.setImageDrawable(getResources().getDrawable(R.drawable.home));
        profileIcon.setImageDrawable(getResources().getDrawable(R.drawable.profile));


        //creating the floating action menu subButtos being created dynamically
        final FloatingActionMenu myFloatingMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(rLSubBuilder.setContentView(profileIcon).build())
                .addSubActionView(rLSubBuilder.setContentView(checkoutIcon).build())
                .addSubActionView(rLSubBuilder.setContentView(makeUp).build())
                .addSubActionView(rLSubBuilder.setContentView(homeIcon).build())


                .attachTo(mymenu)
                .build();


        //Should be linked to the catalogue class
        checkoutIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(MakeUp.this, CatalogActivity.class);
                startActivity(i3);
            }
        });
        makeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(MakeUp.this, MakeUp.class);
                startActivity(i4);
            }
        });

        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5 = new Intent(MakeUp.this, Category.class);
                startActivity(i5);
            }
        });
        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6 = new Intent(MakeUp.this, SignUp.class);
                startActivity(i6);
            }
        });

    }


    }
