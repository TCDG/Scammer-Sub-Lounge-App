package com.scammersublounge.sslapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.scammersublounge.sslapp.utils.NavigationHandler;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    private AccountHeader mNavDrawerHeader = null;
    private Drawer mNavDrawer = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Handle Toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(mToolbar);

        // Create the account header
        buildNavHeader(false, savedInstanceState);

        // Create the nav drawer
        buildNavDrawer(savedInstanceState);
    }

    private void buildNavHeader(boolean compact, Bundle savedInstanceState) {
        mNavDrawerHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.nav_header_background)
                .withCompactStyle(compact)
                .withSavedInstance(savedInstanceState)
                .build();
    }

    private void buildNavDrawer(Bundle savedInstanceState) {
        mNavDrawer = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(mNavDrawerHeader)
                .withToolbar(mToolbar)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Home").withIdentifier(NavigationHandler.idHome),
                        new PrimaryDrawerItem().withName("About").withIdentifier(NavigationHandler.idAbout)
                )
                .addStickyDrawerItems(
                        new SecondaryDrawerItem().withName("Settings").withIcon(GoogleMaterial.Icon.gmd_settings).withIdentifier(NavigationHandler.idSettings)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        NavigationHandler.handleClick(MainActivity.this, drawerItem);
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .build();
    }
}
