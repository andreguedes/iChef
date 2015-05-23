package br.com.ichef;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.app.Application;

/**
 * Esta classe é inicializada assim que o app abre e nela estamos inicializando
 * o ActiveAndroid e finalizando assim que o app fecha
 * 
 * @author André
 *
 */
public class Ichef extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		ActiveAndroid.initialize(this);
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
		ActiveAndroid.dispose();
	}
}
