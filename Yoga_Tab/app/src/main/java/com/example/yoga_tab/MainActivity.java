package com.example.yoga_tab;

import android.content.res.Configuration;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int SECONDS_IN_HOUR = 3600;
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int DELAY = 1000;
    private int seconds = 0;
    TextView mTextField;
    TextView timer_Training, timer_Assana;

    public int time2 = 15000;
    FrameLayout container;
    private boolean running = true;
    private String myString = "Hello";
    boolean isStarted = false;
    boolean isCanseled = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, AsanaFragment.newInstance())
                    .commitNow();
        }
        initViews();
        initListFragment();
        showAsFragmentAtStart();
    }

    public void initViews() {
        container = findViewById(R.id.fragmentContainer);



    }

    private void showAsFragmentAtStart() {
        if (container.getTag().equals("tablet_display")) {
            initDetailFragment(0);

        }
    }

    void initDetailFragment(int position) {
        AsanaFragment detailFragment = new AsanaFragment();
        detailFragment.setWorkout(position);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, detailFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    void initListFragment() {
        if (container.getTag().equals("usual_display")) {
            ListFragment listFragment = new ListFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainer, listFragment);
            transaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
        } else {

        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.time_30:
                time2 = 30000;
                return true;
            case R.id.time_45:
                time2 = 45000;
                return true;
            case R.id.time_90:
                time2 = 90000;
                return true;
            case R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void onClickStart(View v) {

        megaTimer();
        startTimer();
        reverseTimer();
        timer_Assana = findViewById(R.id.timerAsana);
        timer_Training = findViewById(R.id.timerTraining);

    }
    CountDownTimer cTimer = null;
    void startTimer() {
        cTimer = new CountDownTimer(time2, 1000) {
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
            }
        };
        cTimer.start();
    }
    public void reverseTimer() {
        new CountDownTimer(time2, 1000) {
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                timer_Assana.setText("" + String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));
            }
            public void onFinish() {
                cTimer.cancel();
                timer_Assana.setText("Out");
            }
        }.start();
    }
    private void megaTimer() {
        if(isStarted == false){
            final Handler handler = new Handler();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    int hours = seconds / SECONDS_IN_HOUR;
                    int minutes = (seconds % SECONDS_IN_HOUR) / SECONDS_IN_MINUTE;
                    int secs = seconds % 60;
                    String time = String.format(Locale.US, "%d:%02d:%02d", hours, minutes, secs);
                    timer_Training.setText(time);
                    if(running) {
                        seconds++;
                        isStarted = true;
                    }
                    handler.postDelayed(this, DELAY);
                }
            });
        }}
}
