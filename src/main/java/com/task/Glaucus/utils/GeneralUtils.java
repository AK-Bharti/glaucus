package com.task.Glaucus.utils;
import java.util.function.Consumer;

public interface GeneralUtils {
	
	public static final Consumer<Runnable> runOnSeperateThread = runnableThing -> {
		Thread thread = new Thread(runnableThing);
	    thread.start();
	};
	
}
