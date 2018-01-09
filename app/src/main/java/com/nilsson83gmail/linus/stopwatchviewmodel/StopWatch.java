package com.nilsson83gmail.linus.stopwatchviewmodel;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class StopWatch extends AppCompatActivity {

    StopWatchViewModel viewModel;
    private int seconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        viewModel = ViewModelProviders.of(this).get(StopWatchViewModel.class);

        runTimer();
    }

    public void onClickStart(View view) {
        viewModel.setRunning(true);
    }

    public void onClickStop(View view) {
        viewModel.setRunning(false);
    }

    public void onClickReset(View view) {
        viewModel.setRunning(false);
        seconds = 0;
    }

    private void runTimer() {
        seconds = viewModel.getTime();
        final TextView timeView = (TextView)findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds /3600;
                int minutes = (seconds %3600)/60;
                int secs = seconds %60;
                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if(viewModel.isRunning()) {
                    seconds++;
                }
                viewModel.setTime(seconds);
                handler.postDelayed(this, 1000);
            }

        });
    }
}
