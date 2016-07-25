package com.example.m.weather;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {



    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
           int idWidget = appWidgetId;
            Intent intent = new Intent(context,Wejscie.class);
            Log.d("Uwaga","OnUpdate");
            PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,0);
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.new_app_widget);
            remoteViews.setOnClickPendingIntent(R.id.imageView3,pendingIntent);
            appWidgetManager.updateAppWidget(idWidget,remoteViews);
        }
    }

    @Override
    public void onEnabled(Context context) {
        Log.d("Uwaga","OnEnabled");
        Toast.makeText(context,"Hello",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDisabled(Context context) {
        Log.d("Uwaga","OnDisabled");
        Toast.makeText(context,"ByeBye",Toast.LENGTH_SHORT).show();
    }
}

