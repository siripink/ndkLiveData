package com.me.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

import androidx.lifecycle.ViewModelProviders;
import com.me.myapplication.models.CountNumberViewModel;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }

    private CountNumberViewModel model;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        model = ViewModelProviders.of(this).get(CountNumberViewModel.class);
        model.getCount().observe(this, count -> {
            textView.setText(""+ count);
        });
    }

    public void increaseCount(View view) {
        int intCount = model.getCount().getValue();
        model.update(stringFromJNI(intCount));
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI(int count);
}
