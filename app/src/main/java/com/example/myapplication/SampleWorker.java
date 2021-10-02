package com.example.myapplication;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class SampleWorker extends Worker {

    public SampleWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.d("Worker main", Thread.currentThread().getName());
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                Log.d("Result1 "+Thread.currentThread().getName(),"result is " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 5; i < 10; i++) {
            try {
                Thread.sleep(1000);
                Log.d("Result2 "+Thread.currentThread().getName(),"result is " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return Result.success();
    }
}
