package com.example.midterm2;

import static android.content.ContentValues.TAG;

import android.util.Log;

public class Counter implements Runnable{

    String TAG = MainActivity.class.getSimpleName();
    boolean loop = true;
    int count;

    public Counter(int input) {
        this.count = input;
    }
    @Override
    public void run() {
        loop = true;
        while(loop) {
            try{
                Thread.sleep(1000);
                count++;
                Log.i(TAG, "Thread ID" + Thread.currentThread().getId() + " counter is: " + count);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stop(){
        loop = false;
    }

}
