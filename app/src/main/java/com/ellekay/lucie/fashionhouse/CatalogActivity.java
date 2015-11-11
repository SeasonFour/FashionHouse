package com.ellekay.lucie.fashionhouse;

/**
 * Created by maureen on 11/9/15.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class CatalogActivity extends Activity {

    private List<Product> mProductList;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        // Obtain a reference to the product catalog
        mProductList = ShoppingCartHelper.getCatalog(getResources());

        // Create the list
        ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
        listViewCatalog.setAdapter(new ProductAdapter(mProductList, getLayoutInflater(), false));

        // onclick item view description of the list item
        listViewCatalog.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent productDetailsIntent = new Intent(getBaseContext(),Productdetails.class);
                productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX, position);
                startActivity(productDetailsIntent);
            }
        });
        //On click view shopping cart button takes you to shopping cart activity

        Button viewShoppingCart = (Button) findViewById(R.id.ButtonViewCart);
        viewShoppingCart.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent viewShoppingCartIntent = new Intent(getBaseContext(), ShoppingCartActivity.class);
                startActivity(viewShoppingCartIntent);
            }
        });

    }
}