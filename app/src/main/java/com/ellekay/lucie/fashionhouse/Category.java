package com.ellekay.lucie.fashionhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.ArrayList;
import java.util.List;

public class Category extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private StaggeredGridLayoutManager glmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(this));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.home_recycler);
        recyclerView.setHasFixedSize(true);

        glmanager = new StaggeredGridLayoutManager(2, 1);
        recyclerView.setLayoutManager(glmanager);

        List<CategoryClass> gList = getDataItem();

        CategoryAdapter cAdapter = new CategoryAdapter(this,gList);
        recyclerView.setAdapter(cAdapter);

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
                Intent i3 = new Intent(Category.this, CatalogActivity.class);
                startActivity(i3);
            }
        });
        makeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(Category.this, MakeUp.class);
                startActivity(i4);
            }
        });

        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5 = new Intent(Category.this, Category.class);
                startActivity(i5);
            }
        });
        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6 = new Intent(Category.this, SignUp.class);
                startActivity(i6);
            }
        });
    }

    private List<CategoryClass> getDataItem(){
        List<CategoryClass> categoryItem = new ArrayList<CategoryClass>();
        categoryItem.add(new CategoryClass("Dresses", R.drawable.nguo));
        categoryItem.add(new CategoryClass("Make up", R.drawable.vipodozi));
        categoryItem.add(new CategoryClass("Jewellery", R.drawable.gold));
        categoryItem.add(new CategoryClass("Bags", R.drawable.bag));
        categoryItem.add(new CategoryClass("Shoes", R.drawable.viatu));
        categoryItem.add(new CategoryClass("Hair", R.drawable.afroheadband));
        return categoryItem;

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("msg", ""+position);

    }
}