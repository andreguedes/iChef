package br.com.ichef;

import android.app.Activity;
import android.os.Bundle;

/**
 * Esta � a classe que exibe a tela inicial do sistema
 * 
 * @author Andr�
 *
 */
public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
	}
}
