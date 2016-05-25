package com.zinuzoid.zlog;

import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;

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
		StackTraceResult stackTraceResult = getCallerClassMethod();

		d(stackTraceResult.className + "|" + stackTraceResult.methodName, message);
	}

	/**
	 * Log with auto discovery class type and method name as TAG
	 * This method might bring up the performance penalty. Suppose to be use as ad-hoc debug only.
	 *
	 * @param e exception
	 */
	public static void d(Exception e) {
		if(!ENABLE) {
			return;
		}
		StackTraceResult stackTraceResult = getCallerClassMethod();

		d(stackTraceResult.className + "|" + stackTraceResult.methodName, getExceptionStackTrace(e));
	}

	/**
	 * Log with auto discovery class type and method name as TAG
	 * This method might bring up the performance penalty. Suppose to be use as ad-hoc debug only.
	 */
	public static void d() {
		d("••••••••••••••••••••••••••••••••");
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
		d(getSimpleClassName(obj.getClass().getName()), message);
	}

	public static void dumpStack() {
		if(!ENABLE) {
			return;
		}
		Thread.dumpStack();
	}

	private static StackTraceResult getCallerClassMethod() {
		StackTraceResult stackTraceResult = new StackTraceResult();
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		StackTraceElement ste = stackTrace[4];
		stackTraceResult.methodName = ste.getMethodName();
		stackTraceResult.className = getSimpleClassName(ste.getClassName());
		return stackTraceResult;
	}

	private static String getExceptionStackTrace(Exception e) {
		StringWriter writer = new StringWriter();
		e.printStackTrace(new PrintWriter(writer));
		return writer.toString();
	}

	private static String getSimpleClassName(String className) {
		int dot = className.lastIndexOf('.');
		if(dot != -1) {
			return className.substring(dot + 1);
		}
		return className;
	}

	private static class StackTraceResult {
		public String methodName;
		public String className;
	}

	public interface LogInterface {

		void d(String tag, String message);

	}

}
