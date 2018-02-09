package com.example.student.l2018020901;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import java.util.Date;

/**
 * Created by Student on 2018/2/9.
 */

public class MyWidgetProvider extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                R.layout.mywidget);
        Date date=new Date();
        remoteViews.setTextViewText(R.id.textView2,date.toString());
        Intent it= new Intent(context,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,
                it,0);
        remoteViews.setOnClickPendingIntent(R.id.button,pendingIntent);
        ComponentName thisWidget = new ComponentName(context,MyWidgetProvider.class);
        // 取得 Widgets 管理器
        AppWidgetManager manager = AppWidgetManager.getInstance(context);
        // 透過管理器來對指定的Widgets 實例進行單項更新
        manager.updateAppWidget(thisWidget,remoteViews);
    }
}
