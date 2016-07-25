package com.example.m.weather;


import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncujeSpeech  {
    String city;
    View inflater1;
    WeatherCollected collected = new WeatherCollected();
    AsyncujeSpeech(String city, View inflater1)
    {
        this.city=city;
        this.inflater1=inflater1;
        new AsyncujeJuz2().execute();



    }



    public class AsyncujeJuz2 extends AsyncTask<Void, Void, String> {
        private static final String pierwszaWersjaLinku="http://api.openweathermap.org/data/2.5/weather?q=";
        private static final String drugaWersjaLinku="&mode=xml&appid=ff2485070e13592527b9e2ee86779d74";
        String url = pierwszaWersjaLinku+city+drugaWersjaLinku;
        EditText editText;
        TextView tekst7,tekst8,tekst9,tekst10,tekst11;
        String lol2z;
        ImageView imageViewSpeech;

        @Override
        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);
            tekst7  =(TextView)inflater1.findViewById(R.id.textView7);
            tekst8  =(TextView)inflater1.findViewById(R.id.textView8);
            tekst9  =(TextView)inflater1.findViewById(R.id.textView9);
            tekst10  =(TextView)inflater1.findViewById(R.id.textView10);
            tekst11  =(TextView)inflater1.findViewById(R.id.textView11);
            imageViewSpeech=(ImageView)inflater1.findViewById(R.id.imageViewSpeech);
            tekst7.setText(collected.getCityName());
            tekst8.setText(collected.getCountry());
            tekst9.setText(String.valueOf(collected.getTempCelcj())+" °C");
            tekst10.setText(collected.getWind()+" km/h");
            tekst11.setText(collected.getPressure()+" hPa");
            String obrazek = collected.getWeather();
            if(obrazek.equals("03d")){
                imageViewSpeech.setImageResource(R.drawable.dzientrzeci);
            }
            else if(obrazek.equals("01d")){
                imageViewSpeech.setImageResource(R.drawable.dzienpierwszy);
            }
            else if(obrazek.equals("02d")){
                imageViewSpeech.setImageResource(R.drawable.dziendrugi);
            }
            else if(obrazek.equals("04d")){
                imageViewSpeech.setImageResource(R.drawable.dzienczwarty);
            }
            else if(obrazek.equals("09d")){
                imageViewSpeech.setImageResource(R.drawable.dziendziewiaty);
            }
            else if(obrazek.equals("10d")){
                imageViewSpeech.setImageResource(R.drawable.dziendziesiaty);
            }
            else if(obrazek.equals("11d")){
                imageViewSpeech.setImageResource(R.drawable.dzienjedenasty);
            }
            else if(obrazek.equals("13d")){
                imageViewSpeech.setImageResource(R.drawable.dzientrzynasty);
            }
            else if(obrazek.equals("50d")){
                imageViewSpeech.setImageResource(R.drawable.dzienpiecdziesiaty);
            }
            else if(obrazek.equals("50n")){
                imageViewSpeech.setImageResource(R.drawable.nocpiecdziesiata);
            }
            else if(obrazek.equals("01n")){
                imageViewSpeech.setImageResource(R.drawable.nocpierwsza);
            }
            else if(obrazek.equals("02n")){
                imageViewSpeech.setImageResource(R.drawable.nocdruga);
            }
            else if(obrazek.equals("03n")){
                imageViewSpeech.setImageResource(R.drawable.noctrzeci);
            }
            else if(obrazek.equals("04n")){
                imageViewSpeech.setImageResource(R.drawable.nocczwarta);
            }
            else if(obrazek.equals("09n")){
                imageViewSpeech.setImageResource(R.drawable.nocdziewiata);
            }
            else if(obrazek.equals("10n")){
                imageViewSpeech.setImageResource(R.drawable.nocdziesiata);
            }
            else if(obrazek.equals("11n")){
                imageViewSpeech.setImageResource(R.drawable.nocjedenasty);
            }
            else if(obrazek.equals("13n")){
                imageViewSpeech.setImageResource(R.drawable.noctrzynasty);
            }




        }







        @Override
        protected String doInBackground(Void... params) {


            try {
                URL urlGlowny = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) urlGlowny.openConnection();
                connection.setDoInput(true);
                connection.connect();
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                XmlPullParser parser = factory.newPullParser();
                parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,true);
                parser.setInput(connection.getInputStream(),null);
                parsing(parser);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
            return  "siema";
        }
    }

    private void parsing(XmlPullParser parser) throws XmlPullParserException, IOException {
        String tekst = null;
        int event =0;
        event = parser.getEventType();
        while (event!=XmlPullParser.END_DOCUMENT){
            String coName= parser.getName();
            switch (event) {
                case XmlPullParser.START_TAG:
                    if (coName.equals("city")) {
                        collected.setCityName(parser.getAttributeValue(null, "name"));
                    } else if (coName.equals("temperature")) {
                        collected.setTemperature(parser.getAttributeValue(null, "value"));
                    } else if (coName.equals("speed")) {
                        collected.setWind(parser.getAttributeValue(null, "value"));
                    } else if (coName.equals("pressure")) {
                        collected.setPressure(parser.getAttributeValue(null, "value"));
                    } else if (coName.equals("weather")) {
                        collected.setWeather(parser.getAttributeValue(null, "icon"));

                    }
                    break;
                case XmlPullParser.TEXT:
                    tekst = parser.getText();
                    break;

                case XmlPullParser.END_TAG:
                    if (coName.equals("country")) {
                        collected.setCountry(tekst);

                    }
                    break;


            }
            event=parser.next();

        }




    }

}
