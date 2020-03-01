package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv_timesTable;
    public void generateTimesTable(int timesTableNumber) {
        ArrayList<String> timesTableContent = new ArrayList<String>();
        for (int j = 1; j <= 100; j++){
            timesTableContent.add(Integer.toString(j * timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);

        lv_timesTable.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_timesTable = findViewById(R.id.lv_timesTable);
        final SeekBar sb_timesTable = findViewById(R.id.sb_times);

        int max = 20;
        int startingPosition = 10;

        sb_timesTable.setMax(max);
        sb_timesTable.setProgress(startingPosition);

        generateTimesTable(startingPosition);

        sb_timesTable.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;

                if (progress < min) {
                    timesTableNumber = min;
                    sb_timesTable.setProgress(min);
                } else {
                    timesTableNumber = progress;
                }
                Log.i("Seekbar Value", Integer.toString(timesTableNumber));

                generateTimesTable(timesTableNumber);

            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
