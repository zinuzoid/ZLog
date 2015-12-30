package com.zinuzoid.zlog.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zinuzoid.zlog.ZLog;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ZLog.d("Test");
	}
}
