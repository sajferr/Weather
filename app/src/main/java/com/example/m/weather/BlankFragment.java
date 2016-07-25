package com.example.m.weather;


import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
        EditText editText;
        TextView tekst1;
        TextView tekst2;
        TextView tekst3;
        TextView tekst4;
        TextView tekst5;
    String siema;
    Button button;
    String coWpisane;
    ImageView imageView;


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View inflater1 = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_blank,container,false);
                editText=(EditText) inflater1.findViewById(R.id.editText);
                tekst1  =(TextView)inflater1.findViewById(R.id.textView2);
                tekst2  =(TextView)inflater1.findViewById(R.id.textView3);
                tekst3  =(TextView)inflater1.findViewById(R.id.textView4);
                tekst4  =(TextView)inflater1.findViewById(R.id.textView5);
                tekst5  =(TextView)inflater1.findViewById(R.id.textView6);
                imageView=(ImageView)inflater1.findViewById(R.id.imageView);
                button = (Button)inflater1.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coWpisane = editText.getText().toString();
                if(coWpisane!=null){
                    Asyncuje asyncuje = new Asyncuje(getActivity(),coWpisane,inflater1);

                }


            }
        });





        return inflater1;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Uwaga","onDestroy");
    }
}
