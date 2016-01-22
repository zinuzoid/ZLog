package com.zinuzoid.zlog;

import android.util.Log;

/**
 * @author Jetsada Machom <jim@imjim.im>
 */
public class ZLog {

	private static LogInterface LOG_INTERFACE;
	private static boolean ENABLE = true;

	public static void setLogInterface(LogInterface logInterface) {
		LOG_INTERFACE = logInterface;
	}

	public static void setEnable(boolean enable) {
		ENABLE = enable;
	}

	public static void d(String tag, String message) {
		if(!ENABLE) {
			return;
		}
		if(LOG_INTERFACE != null) {
			LOG_INTERFACE.d(tag, message);
		} else {
			Log.d("ZLog", "LogInterface isn't initialize!");
		}
	}

	/**
	 * Log with auto discovery class type and method name as TAG
	 * This method might bring up the performance penalty. Suppose to be use as ad-hoc debug only.
	 *
	 * @param message message
	 */
	public static void d(String message) {
		if(!ENABLE) {
			return;
		}

		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		StackTraceElement ste = stackTrace[2];
		String methodName = ste.getMethodName();
		String className = ste.getClassName();
		int dot = className.lastIndexOf('.');
		if(dot != -1) {
			className = className.substring(dot + 1);
		}

		d(className + "|" + methodName, message);
	}

	/**
	 * Log with auto discovery object's class type as TAG
	 *
	 * @param obj     object
	 * @param message message
	 */
	public static void d(Object obj, String message) {
		if(!ENABLE) {
			return;
		}
		d(obj.getClass().getSimpleName(), message);
	}

	public interface LogInterface {

		void d(String tag, String message);

	}

}
