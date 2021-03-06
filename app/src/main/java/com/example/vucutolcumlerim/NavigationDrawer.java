package com.example.vucutolcumlerim;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class NavigationDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        BottomNavigationView bnv= (BottomNavigationView)findViewById( R.id.btnnavigationMenu );
        bnv.setOnNavigationItemSelectedListener( mOnNavigationItemListener );




    }
       private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemListener
        = new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item){

               Fragment selectedFragment = null;

               switch (item.getItemId()) {
                   case R.id.bottonNavAnasayfa:
                       selectedFragment = new AnasayfaFragment();
                       break;
                   case R.id.bottonNavOneriler :
                       selectedFragment= new OnerilerFragment();
                       break;
                   case R.id.bottonNavHesabim:
                       selectedFragment = new HesabimFragment();
                       break;
               }
               FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
               transaction.replace( R.id.frame_layaout, selectedFragment );
               transaction.commit();
               return true;
           }

       };

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment selectedFragment = null;


        if (id == R.id.nav_KiloOranlari) {
            selectedFragment =new KiloOranlariFragment();
        } else if (id == R.id.nav_YagOranlari) {

            selectedFragment =new YagOranlariFragment();

        } else if (id == R.id.nav_KasOranlari) {
            selectedFragment =new KasOranlariFragment();

        } else if (id == R.id.nav_SuOranlari) {
            selectedFragment =new SuOranlariFragment();

        } else if (id == R.id.nav_FacebooktaPaylas) {
            selectedFragment =new FacebooktaPaylasFragment();

        } else if (id == R.id.nav_Twiter) {
            selectedFragment =new TwiterFragment();

        }else if (id == R.id.nav_lnkdn) {
            selectedFragment =new LinkedinFragment();

        }else if (id == R.id.nav_mail) {
            selectedFragment =new MailFragment();

        }else if (id == R.id.nav_tlfn) {
            selectedFragment =new TelefonFragment();
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace( R.id.frame_layaout, selectedFragment );
        transaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
