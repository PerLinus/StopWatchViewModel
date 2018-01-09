package com.nilsson83gmail.linus.stopwatchviewmodel;

import android.arch.lifecycle.ViewModel;

/**
 * Created by Linus on 2018-01-08.
 */

public class StopWatchViewModel extends ViewModel{

    private int time;
    private boolean running;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
