package akasaka.chloe.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import akasaka.chloe.MainActivity;
import akasaka.chloe.Notifications.ReminderBroadcast;
import akasaka.chloe.R;

public class TheDyingMessageActivity extends AppCompatActivity {
    // Declaring buttons from activity
    private Button the_dying_messageButton;
    private Button eButton;
    private Button coldButton;
    private Button the_adults_toyButton;
    private Button welcome_to_the_love_hospitalButton;
    private Button shironoirButton;

    private String title = "Hey";
    private String text = "how are you";

    private long timeAtButtonClick;

    private Random random = new Random();

    private Handler handler = new Handler();
    private int notificationCount = 0;
    private String localText;
    private void showNotificationSequence() {
        // Reset the notification count
        notificationCount = 1;

        // Start the sequence with a delay of 2 seconds
        handler.postDelayed(notificationRunnable, 2000);
    }

    private Runnable notificationRunnable = new Runnable() {
        @Override
        public void run() {
            if (notificationCount < 12) {
                // Show the notification
                showNotification();

                // Increment the notification count
                notificationCount++;

                // Schedule the next notification after a delay of 2 seconds
                handler.postDelayed(notificationRunnable, 2000);
            }
        }
    };

    private void showNotification() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        System.out.println("yey");

        if (notificationCount * 50 == 550){
            localText = text.substring(notificationCount * 50, notificationCount * 50 + 19);
            the_dying_messageButton.setEnabled(true);
        } else {
            if (notificationCount > 1) {
                localText = text.substring(notificationCount * 50, (notificationCount + 1) * 50);
            } else {
                localText = text.substring(0, notificationCount * 30);
            }
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "notifications")
                .setSmallIcon(R.mipmap.silly_doggy_standing_on_4_cans) //#todo find something better, something more fitting
                .setContentTitle(title)
                .setContentText(localText)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setStyle(new NotificationCompat.BigTextStyle());

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);

        // idfc
        // nobody can reject when I ask, so it's not a problem
        notificationManagerCompat.notify(random.nextInt(), builder.build());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_dying_message);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Finding them by id
        the_dying_messageButton = findViewById(R.id.The_Dying_Message);
        eButton = findViewById(R.id.E);
        coldButton = findViewById(R.id.Cold);
        the_adults_toyButton = findViewById(R.id.The_Adults_Toy);
        welcome_to_the_love_hospitalButton = findViewById(R.id.Welcome_to_The_Love_Hospital);
        shironoirButton = findViewById(R.id.Shironoir);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this, ReminderBroadcast.class);

        // Setting up onClock listeners
        the_dying_messageButton.setOnClickListener(view -> {

            the_dying_messageButton.setEnabled(false);

            Toast.makeText(this, "The_Dying_Message listener was called", Toast.LENGTH_SHORT).show();
            timeAtButtonClick = System.currentTimeMillis();

            title = "Nee Anaata?";
            text = "散漫で不安定なこの世界\n" +
                    "革命を起こしてよ\n" +
                    "\n" +
                    "愛」が正解になれ\n" +
                    "\n" +
                    "不安なんて簡単に消えちゃって\n" +
                    "薄明の陽照らす、その向こうへ\n" +
                    "\n" +
                    "記録も　記憶も　無い人　埋葬\n" +
                    "希望も　未来も　無い国　外傷\n" +
                    "\n" +
                    "長い夜を終え　朝焼けを見た\n" +
                    "赤く染まる背中と\n" +
                    "\n" +
                    "ねえ　貴方はいつか　居なくなりますか\n" +
                    "終わりかけのこの世界で\n" +
                    "夜明け前の憂い　耐え難い孤独\n" +
                    "淡い想いと寂寞を　抱いた\n" +
                    "\n" +
                    "鮮明な弾丸の記憶に\n" +
                    "誰もがひよっては\n" +
                    "\n" +
                    "第一歩が出ない\n" +
                    "\n" +
                    "安全は簡単に消えちゃって\n" +
                    "悪影響及ぼした、僕の心へ\n" +
                    "長い雨が止み　暑い陽射しが\n" +
                    "照らす大きな背中を\n" +
                    "\n" +
                    "ねえ　貴方はいつも　夢を見てますか\n" +
                    "終わりかけのこの世界で\n" +
                    "塞がれた道を　拓く者になる\n" +
                    "「メッセージ」を抱いていた　つらいよ\n" +
                    "\n" +
                    "無情にも時が来て　彼方へ旅立った\n" +
                    "果敢な感情構え　砕け散る為に\n" +
                    "勇敢な貴方は　空を切り裂いた\n" +
                    "精悍な表情構え　風になった\n" +
                    "\n" +
                    "慟哭　隠して\n" +
                    "\n" +
                    "寂寞　隠して\n" +
                    "\n" +
                    "生きる事さえ　望めないなら\n" +
                    "ただ世界を感じて　息を吐く\n" +
                    "\n" +
                    "長い夜を終え　背中など無い\n" +
                    "そこにあるのはただ　広いブルー\n" +
                    "\n" +
                    "ねえ　貴方はいつも　元気をくれますか\n" +
                    "終わりかけのこの世界で\n" +
                    "暗がりで交わした　小さな約束が\n" +
                    "私の生きる糧さ\n" +
                    "ねえ　私は二度と　暗い顔しないよ\n" +
                    "遮る影も見えぬから\n" +
                    "明るい陽射しを　存分に浴びながら\n" +
                    "「6日」の朝を迎えた";

            showNotificationSequence();

            System.out.println("The_Dying_Message listener was called");
        });

        eButton.setOnClickListener(view -> {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

            System.out.println(prefs.getAll());
            Toast.makeText(this, "The_Dying_Message listener was called: ", Toast.LENGTH_SHORT).show();

            System.out.println("eButton listener was called");
        });

        coldButton.setOnClickListener(view -> {
            System.out.println("coldButton listener was called");
        });

        the_adults_toyButton.setOnClickListener(view -> {
            System.out.println("the_adults_toyButton listener was called");
        });

        welcome_to_the_love_hospitalButton.setOnClickListener(view -> {
            System.out.println("welcome_to_the_love_hospitalButton listener was called");
        });

        shironoirButton.setOnClickListener(view -> {
            System.out.println("shironoirButton listener was called");
        });
    }

    public String getTitleFromTheDyingMessage() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}