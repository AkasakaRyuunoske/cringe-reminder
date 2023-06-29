package akasaka.chloe.Notifications;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.preference.PreferenceManager;

import java.util.Map;

import akasaka.chloe.Activities.TheDyingMessageActivity;
import akasaka.chloe.R;

public class ReminderBroadcast extends BroadcastReceiver {
    NotificationCompat.Builder builder;
    @Override
    public void onReceive(Context context, Intent intent) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        Map<String, ?> preferences = sharedPreferences.getAll();

        System.out.println("Prefs inside reminder: " + sharedPreferences.getAll());

        TheDyingMessageActivity theDyingMessageActivity = new TheDyingMessageActivity();

        System.out.println(theDyingMessageActivity.getTitleFromTheDyingMessage());
        System.out.println(theDyingMessageActivity.getText());

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "notifications")
                .setSmallIcon(R.mipmap.silly_doggy_standing_on_4_cans) //#todo find something better, something more fitting
                .setContentTitle(preferences.get("header_content").toString())
                .setContentText(preferences.get("message_content").toString())
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);

        // idfc
        // nobody can reject when I ask, so it's not a problem
        notificationManagerCompat.notify(200, builder.build());
    }
}
