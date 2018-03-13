package uk.co.cruentus.gregatron1
/**Created by Greg Hurlock on 06/03/2018.*/

import android.widget.RemoteViews
import android.app.PendingIntent
import android.content.Intent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context

class AppWidgetProviderOne : AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        val N = appWidgetIds.size

        // Perform this loop procedure for each App Widget that belongs to this provider
        for (i in 0 until N) {
            val appWidgetId = appWidgetIds[i]

            // Get the layout for the App Widget and attach an on-click listener
            // to the button
            val views = RemoteViews(context.getPackageName(), R.layout.appwidget_one)

            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}

class WidgetActivity{


}