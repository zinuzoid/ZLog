package com.zinuzoid.zlog;

import android.util.Log;

/**
 * ZLog
 * on 12/30/2015 AD
 *
 * @author Jetsada Machom <jim@imjim.im>
 */
public class ZLog {

	private static LogInterface mLogInterface;

	public static void setLogInterface(LogInterface logInterface) {
		mLogInterface = logInterface;
	}

	public static void d(String tag, String message) {
		if(mLogInterface != null) {
			Log.d(tag, message);
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
