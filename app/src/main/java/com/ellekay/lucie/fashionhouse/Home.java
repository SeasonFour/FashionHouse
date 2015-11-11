package com.ellekay.lucie.fashionhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.etsy.android.grid.StaggeredGridView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.ArrayList;


public class Home extends AppCompatActivity implements AbsListView.OnScrollListener, AbsListView.OnItemClickListener {

    private static final String TAG = "STAGGERED GRID";
    public static final String SAVED_DATA_KEY = "SAVED_DATA_KEY";

    private StaggeredGridView myGridView;
    private boolean mHasRequestedMore;
    private HomeAdapter homeAdapter;

    private ArrayList<String> myData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(this));


        setTitle("Fashion House b-Home");
        myGridView = (StaggeredGridView) findViewById(R.id.grid_view);
        homeAdapter = new HomeAdapter(this, android.R.layout.simple_list_item_1, generateData());

        if (savedInstanceState != null){
            myData = savedInstanceState.getStringArrayList(SAVED_DATA_KEY);
        }

        if (myData == null){
            myData = generateData();
        }

        for (String data : myData){
            homeAdapter.add(data);
        }

        myGridView.setAdapter(homeAdapter);
        myGridView.setOnScrollListener(this);
        myGridView.setOnItemClickListener(this);


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
                .addSubActionView(rLSubBuilder.setContentView(checkoutIcon).build())
                .addSubActionView(rLSubBuilder.setContentView(makeUp).build())
                .addSubActionView(rLSubBuilder.setContentView(homeIcon).build())
                .addSubActionView(rLSubBuilder.setContentView(profileIcon).build())

                .attachTo(mymenu)
                .build();

        //Should be linked to the catalogue class
        checkoutIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(Home.this, ShoppingCartActivity.class);
                startActivity(i3);
            }
        });
        makeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(Home.this, MakeUp.class);
                startActivity(i4);
            }
        });

        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5 = new Intent(Home.this, Category.class);
                startActivity(i5);
            }
        });
        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6 = new Intent(Home.this, SignUp.class);
                startActivity(i6);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(SAVED_DATA_KEY, myData);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Item clicked: " +position, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onScrollStateChanged(final AbsListView view, final int scrollState) {
        Log.d(TAG, "onscrollstatechanged" + scrollState);

    }


    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        Log.d(TAG, "onScrollFirstItem:" +firstVisibleItem + "visibleCount:" +visibleItemCount + "totalcount:" +totalItemCount);
        if (mHasRequestedMore){
            int lastInSreen = firstVisibleItem + visibleItemCount;
            if (lastInSreen >= totalItemCount){
                Log.d(TAG, "onscroll last in screeen -so load more");
                mHasRequestedMore = true;
                onLoadMore();

            }
        }
    }

    private void onLoadMore(){
        final ArrayList<String> sampleData = generateData();
        for (String data : sampleData){
            homeAdapter.add(data);
        }
        myData.addAll(sampleData);
        homeAdapter.notifyDataSetChanged();
        mHasRequestedMore = false;
    }

    private ArrayList<String> generateData(){
        ArrayList<String> listData = new ArrayList<String>();
        listData.add("http://gloimg.sammydress.com/S/2015/201509/source-img/1442525830059-P-3136085.jpeg");//dress
        listData.add("http://www.wholesale7.net/images/201204/goods_img/28941_P_1335321411963.jpg"); //shoes
        listData.add("https://s-media-cache-ak0.pinimg.com/736x/5e/19/1c/5e191cdc55ed358a4c8b44f862efcc68.jpg"); //bag
        listData.add("http://s7ondemand4.scene7.com/is/image/Signet/9649018?$detail745$"); //jewellery
        listData.add("http://www.womentip.com/wp-content/uploads/2014/12/Makeup-Kits.jpeg");//makeupy
        listData.add("http://d236bkdxj385sg.cloudfront.net/wp-content/uploads/2011/03/afroheadband.jpg");//hair
        Log.d(TAG,"SIZE"+listData.size());
        return listData;
    }

}
