package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private final int NAME_INDEX = 0;
    private final int VALUE_INDEX = 1;
    private final String ATTR_NAME = "name";
    private final String ATTR_VALUE = "value";

    private final String START_TAG_KEY = "Key";
    private final String START_TAG_SECTION = "Section";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", Thread.currentThread().getName());
        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest
                .Builder(SampleWorker.class,15, TimeUnit.MINUTES)
                .build();

        WorkManager workManager = WorkManager.getInstance(this);
        workManager.enqueue(periodicWorkRequest);

        /*try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            InputStream is = getApplicationContext().getAssets().open("v5OnboardOpIntel.xml");
            parser.setInput(is,null);
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT){
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        String attrValue = getAttributeValue(parser, "name");
                        String tagName = parser.getName();
                        switch (tagName){
                            case START_TAG_SECTION:

                        }

                        break;

                }
                eventType = parser.next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }*/

    }

    String getAttributeValue(final XmlPullParser parser, final String name) {
        String result;
        result = parser.getAttributeValue(null, name);
        return result;
    }

}