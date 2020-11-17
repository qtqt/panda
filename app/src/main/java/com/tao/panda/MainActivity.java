package com.tao.panda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_tip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TipDialog tipDialog = new TipDialog(MainActivity.this);
                tipDialog.show();
            }
        });
    }
}
