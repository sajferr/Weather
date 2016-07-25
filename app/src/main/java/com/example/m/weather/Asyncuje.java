package com.example.m.weather;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by m on 2016-07-20.
 */
public class Asyncuje  {
    String city;
    View inflater1;
    String inini3434343;
    Context context;
    WeatherCollected collected = new WeatherCollected();
    Asyncuje(Context context, String city, View inflater1)
    {
        this.city=city;
        this.inflater1=inflater1;
        this.context=context;
        new AsyncujeJuz().execute();



    }



    public class AsyncujeJuz extends AsyncTask<Void, Void, String> {
        private static final String pierwszaWersjaLinku="http://api.openweathermap.org/data/2.5/weather?q=";
        private static final String drugaWersjaLinku="&mode=xml&appid=ff2485070e13592527b9e2ee86779d74";
        String url = pierwszaWersjaLinku+city+drugaWersjaLinku;
        EditText editText;
        TextView tekst1,tekst2,tekst3,tekst4,tekst5;
        String lol2z;
        Wyjatek wyjatek;
        ImageView imageView;

        @Override
        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);
            if(wyjatek.coJest!=null){
                Toast.makeText(context,"Nie ma takiego miasta",Toast.LENGTH_LONG).show();

            }


            else {

                editText = (EditText) inflater1.findViewById(R.id.editText);
                tekst1 = (TextView) inflater1.findViewById(R.id.textView2);
                tekst2 = (TextView) inflater1.findViewById(R.id.textView3);
                tekst3 = (TextView) inflater1.findViewById(R.id.textView4);
                tekst4 = (TextView) inflater1.findViewById(R.id.textView5);
                tekst5 = (TextView) inflater1.findViewById(R.id.textView6);
                imageView = (ImageView) inflater1.findViewById(R.id.imageView);
                tekst1.setText(collected.getCityName());
                tekst2.setText(collected.getCountry());
                tekst3.setText(String.valueOf(collected.getTempCelcj()) + " °C");
                tekst4.setText(collected.getWind() + " km/h");
                tekst5.setText(collected.getPressure() + " hPa");
                String obrazek = collected.getWeather();
                if (obrazek.equals("03d")) {
                    imageView.setImageResource(R.drawable.dzientrzeci);
                } else if (obrazek.equals("01d")) {
                    imageView.setImageResource(R.drawable.dzienpierwszy);
                } else if (obrazek.equals("02d")) {
                    imageView.setImageResource(R.drawable.dziendrugi);
                } else if (obrazek.equals("04d")) {
                    imageView.setImageResource(R.drawable.dzienczwarty);
                } else if (obrazek.equals("09d")) {
                    imageView.setImageResource(R.drawable.dziendziewiaty);
                } else if (obrazek.equals("10d")) {
                    imageView.setImageResource(R.drawable.dziendziesiaty);
                } else if (obrazek.equals("11d")) {
                    imageView.setImageResource(R.drawable.dzienjedenasty);
                } else if (obrazek.equals("13d")) {
                    imageView.setImageResource(R.drawable.dzientrzynasty);
                } else if (obrazek.equals("50d")) {
                    imageView.setImageResource(R.drawable.dzienpiecdziesiaty);
                } else if (obrazek.equals("50n")) {
                    imageView.setImageResource(R.drawable.nocpiecdziesiata);
                } else if (obrazek.equals("01n")) {
                    imageView.setImageResource(R.drawable.nocpierwsza);
                } else if (obrazek.equals("02n")) {
                    imageView.setImageResource(R.drawable.nocdruga);
                } else if (obrazek.equals("03n")) {
                    imageView.setImageResource(R.drawable.noctrzeci);
                } else if (obrazek.equals("04n")) {
                    imageView.setImageResource(R.drawable.nocczwarta);
                } else if (obrazek.equals("09n")) {
                    imageView.setImageResource(R.drawable.nocdziewiata);
                } else if (obrazek.equals("10n")) {
                    imageView.setImageResource(R.drawable.nocdziesiata);
                } else if (obrazek.equals("11n")) {
                    imageView.setImageResource(R.drawable.nocjedenasty);
                } else if (obrazek.equals("13n")) {
                    imageView.setImageResource(R.drawable.noctrzynasty);
                }
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
                Log.d("Uwaga","malformed");
                e.printStackTrace();

            }  catch (XmlPullParserException e) {
                Log.d("Uwaga","printstacktrac4343e");
              //  Toast.makeText(context,"Nie ma takiego miasta",Toast.LENGTH_LONG).show();

            }
            catch (Exception e) {
                Log.d("Uwaga","printstacktrace");


            }
            finally {
                wyjatek=new Wyjatek("Jest");
                return  "siema";
            }

        }
    }

    private void parsing(XmlPullParser parser) throws XmlPullParserException, IOException {
        String tekst = null;
        int event =0;
        event = parser.getEventType();
        if(event==XmlPullParser.START_DOCUMENT) {

            while (event != XmlPullParser.END_DOCUMENT) {
                String coName = parser.getName();
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
                event = parser.next();

            }
        }




    }

}
