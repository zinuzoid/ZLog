package com.zinuzoid.zlog.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zinuzoid.zlog.ZLog;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ZLog.setLogInterface(new ZLog.LogInterface() {
			@Override
			public void d(String tag, String message) {
				Log.d(tag, message);
			}
		});

		ZLog.d("Test");

		ZLog.d(new RuntimeException("panic!"));
	}
}
