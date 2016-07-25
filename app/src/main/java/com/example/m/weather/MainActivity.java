package com.example.m.weather;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.speech.RecognizerIntent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    NavigationView navigationView ;
    BlankFragment2 blankFragment2;
    BlankFragment3 blankFragment3;
    Fragment fragment;
    BlankFragment4 blankFragment4;
    FragmentTransaction transaction;
    String lolz313131
            ;
    String krr;
    String tas;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView = (NavigationView)findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
        BlankFragment blankFragment = new BlankFragment();
        FragmentManager manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.frame,blankFragment);
        transaction.commit();

    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.item1:
                //speech
                BlankFragment2 blankFragment2 =new BlankFragment2();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,blankFragment2).commit();


//                Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
//                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
//                i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Tell me");
//                startActivityForResult(i, 100);
                break;
            case R.id.item2:
                //help
                blankFragment3 = new BlankFragment3();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,blankFragment3).commit();

                break;
            case R.id.item3:
                //about create

                blankFragment4 = new BlankFragment4();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,blankFragment4).commit();
                break;

            case R.id.item4:
                //exot
                finish();
                finish();

                    break;
            case R.id.item10:
                BlankFragment blankFragment = new BlankFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,blankFragment).commit();
                break;

            case R.id.openwea:
                Uri uri = Uri.parse("http://openweathermap.org/");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);


        }






        return false;
    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode==100&&resultCode==RESULT_OK){
//            ArrayList<String> arrayList = new ArrayList<>(data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS));
//
//
//
//
//
//        }

    }

