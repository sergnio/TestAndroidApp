package com.example.testapp;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class OPExampleAppWidgetProvider extends AppWidgetProvider {

    // File to update widget
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            // Responsible for diplaying layouts in another process
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.op_widget);
            // intent to start when we click the button
            // This will open the activity
            views.setOnClickPendingIntent(R.id.example_widget_button, pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetId, views);

        }
    }
}
