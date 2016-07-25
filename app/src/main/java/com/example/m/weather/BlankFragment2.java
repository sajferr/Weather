package com.example.m.weather;


import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {
    ImageView imageView1;
    TextView tekst7;
    View view;
    TextView tekst8;
    TextView tekst9;
    TextView tekst10;
    TextView tekst11;
    String lolz;
   static  String coPowiedzial;


    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



         view = inflater.inflate(R.layout.fragment_blank_fragment2,container,false);
        imageView1 = (ImageView)view.findViewById(R.id.imageViewSpeech);
        ImageView imageView2=(ImageView)view.findViewById(R.id.imageViewMicro);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Uwaga","Onclick");
                Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "pl");
                i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Tell me");
                startActivityForResult(i, 100);

            }
        });
        tekst7 = (TextView)view.findViewById(R.id.textView7);
        tekst8=(TextView)view.findViewById(R.id.textView8);
        tekst9=(TextView)view.findViewById(R.id.textView9);
        tekst10=(TextView)view.findViewById(R.id.textView10);
        tekst11=(TextView)view.findViewById(R.id.textView11);





        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100&&resultCode==-1){
            ArrayList<String> arrayList = new ArrayList<>(data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS));
            AsyncujeSpeech asyncuje = new AsyncujeSpeech(arrayList.get(0),view);


        }



    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Uwaga","onDestroy");
    }
}
