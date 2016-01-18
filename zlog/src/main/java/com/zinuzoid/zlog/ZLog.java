package com.zinuzoid.zlog;

import android.util.Log;

/**
 * @author Jetsada Machom <jim@imjim.im>
 */
public class ZLog {

	private static LogInterface mLogInterface;

	public static void setLogInterface(LogInterface logInterface) {
		mLogInterface = logInterface;
	}

	public static void d(String tag, String message) {
		if(mLogInterface != null) {
			mLogInterface.d(tag, message);
		} else {
			Log.d("ZLog", "LogInterface isn't initialize!");
		}
	}

	public static void d(String message) {
		d("ZLog", message);
	}

	public static void d(Object obj, String message) {
		d(obj.getClass().getSimpleName(), message);
	}

	public interface LogInterface {

		void d(String tag, String message);

	}

}
