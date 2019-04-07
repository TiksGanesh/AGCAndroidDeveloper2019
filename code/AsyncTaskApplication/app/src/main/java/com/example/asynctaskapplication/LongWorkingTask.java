package com.example.asynctaskapplication;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Class
 * Description
 */
public class LongWorkingTask extends AsyncTask<String,Void,Integer> {

    private final static  String LOG_TAG = LongWorkingTask.class.getSimpleName();

    private Integer counter = 0;

    private OnCountListener listener;

    public LongWorkingTask() {
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.e(LOG_TAG, "onPreExecute");
    }

    @Override
    protected Integer doInBackground(String... strings) {

        Log.e(LOG_TAG, "doInBackground");
        String input = strings[0];
        Log.e(LOG_TAG, input);

        try {
            for (int i = 0; i <= 10 ; i++){
                Thread.sleep(3000);
                counter += i;
            }

            return counter;
        }catch (InterruptedException ex){
            Log.e(LOG_TAG, " Exception thrown");
            return counter;
        }
    }


    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        Log.e(LOG_TAG, "onPostExecute");
        Log.e(LOG_TAG, "Result: "+ String.valueOf(integer));

        if (null != listener){
            listener.onFinalCount(integer);
        }

    }

    public void setListener(OnCountListener listener) {
        this.listener = listener;
    }
}
