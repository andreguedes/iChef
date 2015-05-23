package br.com.ichef;

import android.app.Activity;
import android.os.Bundle;

/**
 * Esta é a classe que exibe a tela inicial do sistema
 * 
 * @author André
 *
 */
public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
	}
}
