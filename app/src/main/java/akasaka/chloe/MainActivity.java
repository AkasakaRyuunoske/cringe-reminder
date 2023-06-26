package akasaka.chloe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import akasaka.chloe.Activities.OptionsActivity;
import akasaka.chloe.Activities.TheDyingMessageActivity;
import akasaka.chloe.Notifications.NotificationChanelManager;
import akasaka.chloe.Notifications.ReminderBroadcast;

public class MainActivity extends AppCompatActivity {
    private Button cringeMeInXSeconds;
    private Button optionsButton;

    private Button theDyingMessageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationChanelManager notificationChanelManager = new NotificationChanelManager(this);
        notificationChanelManager.createNotificationChannel();

        theDyingMessageButton = findViewById(R.id.thedyingmessage);
        theDyingMessageButton.setOnClickListener(v -> {

            System.out.println("Yey activity changed!");

            Intent myIntent = new Intent(MainActivity.this, TheDyingMessageActivity.class);
//        myIntent.putExtra("key", value); //Optional parameters
            MainActivity.this.startActivity(myIntent);
        });

        optionsButton = findViewById(R.id.options);
        optionsButton.setOnClickListener(v -> {

            System.out.println("Yey activity changed!");

            Intent myIntent = new Intent(MainActivity.this, OptionsActivity.class);
//        myIntent.putExtra("key", value); //Optional parameters
            MainActivity.this.startActivity(myIntent);
        });

        cringeMeInXSeconds = findViewById(R.id.testCringe);
        cringeMeInXSeconds.setOnClickListener(v -> {
            Toast.makeText(this, "Setting reminder...", Toast.LENGTH_SHORT).show();

//            String periodEditTextValue = periodEditText.getText().toString();

//            Log.v("EditText", periodEditTextValue);

            Intent intent = new Intent(MainActivity.this, ReminderBroadcast.class);
            PendingIntent pendingIntent = null;

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
            }

            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            long timeAtButtonClick = System.currentTimeMillis();
            long userPeriod;

            try {
//                userPeriod = Integer.parseInt(periodEditTextValue) * 1000L;
                alarmManager.set(AlarmManager.RTC_WAKEUP, timeAtButtonClick + 1000L, pendingIntent);
                Toast.makeText(this, "Reminder Set!", Toast.LENGTH_LONG).show();

//                cringeMeInXSeconds.setText("Cringe me in next " + periodEditTextValue + " seconds");

            } catch (NumberFormatException numberFormatException) {
                cringeMeInXSeconds.setText("Can't cringe ya if you don't use integers");
                Toast.makeText(this, "Provide an integer value u silly thing", Toast.LENGTH_LONG).show();
            }
        });
    }
}