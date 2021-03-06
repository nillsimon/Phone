package com.example.yoga_tab;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TimerFragment extends Fragment {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int SECONDS_IN_HOUR = 3600;
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int DELAY = 1000;
    private static final String KEY_SECONDS = "seconds";
    private static final String KEY_RUNNING = "running";
    private static final String FORMAT = "%02d:%02d";
    private TextView timer_Asana, timer_Training;
    private int seconds = 0;
    private boolean running = true;
    int time2 = 10000;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_timer, container, false);
        return view;
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(KEY_SECONDS, seconds);
        outState.putBoolean(KEY_RUNNING, running);
        super.onSaveInstanceState(outState);
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
        }
    }
    private void initViews(View view) {
        timer_Training = view.findViewById(R.id.timerTraining);
        timer_Asana = view.findViewById(R.id.timerAsana);
    }
}

