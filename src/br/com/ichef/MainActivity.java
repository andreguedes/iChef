package br.com.ichef;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import br.com.ichef.model.Usuario;

/**
 * Esta � a classe respons�vel por exibir a tela de login, ela implementa
 * interfaces para anima��o e cliques
 * 
 * @author Andr�
 *
 */
public class MainActivity extends Activity implements AnimationListener,
		OnClickListener {

	Button btnLogin, btnCadastro;
	EditText edtEmail, edtSenha;
	ImageView imgLogo;

	Animation animLogo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Declara��o de um tipo de anima��o
		animLogo = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.zoom_in);
		animLogo.setAnimationListener(this);

		edtEmail = (EditText) findViewById(R.id.edtEmail);
		edtSenha = (EditText) findViewById(R.id.edtSenha);

		btnLogin = (Button) findViewById(R.id.btnLogin);
		btnCadastro = (Button) findViewById(R.id.btnCadastro);

		// Os bot�es declarados precisam implementar a interface OnClickListener
		// para serem ouvidos pelo onClick()
		btnLogin.setOnClickListener(this);
		btnCadastro.setOnClickListener(this);

		imgLogo = (ImageView) findViewById(R.id.imgLogo);
		// Aqui a imagem ganha o poder de anima��o
		imgLogo.startAnimation(animLogo);
	}

	/**
	 * O m�todo onClick recebe uma view por parametro, ou seja, algum componente
	 * que foi declarado como clic�vel. Este, verifica qual componente foi
	 * selecionado na tela e executa uma instru��es relacionada ao mesmo
	 */
	@Override
	public void onClick(View v) {
		String email = edtEmail.getText().toString();
		String senha = edtSenha.getText().toString();

		switch (v.getId()) {
		case R.id.btnLogin:

			if (email.equals(""))
				edtEmail.setError(getString(R.string.preencha));
			else if (senha.equals(""))
				edtSenha.setError(getString(R.string.preencha));
			else {
				if (Usuario.getUsuario(email, senha)) {

					// Esta instru��o abre a tela de Menu, lembrando que a mesma
					// deve
					// estar declarada no AndroidManifest.xml
					Intent intent = new Intent(this, MenuActivity.class);
					startActivity(intent);

					// A Activity deve ser finalizada, pois o login foi
					// realizado corretamente
					finish();

				} else {
					Toast.makeText(this,
							getResources().getString(R.string.nao_cadastro),
							Toast.LENGTH_LONG).show();
				}
			}
			break;
		case R.id.btnCadastro:

			// Esta instru��o abre uma nova tela, lembrando que a mesma deve
			// estar declarada no AndroidManifest.xml
			Intent intent = new Intent(this, CadastroActivity.class);
			startActivity(intent);

			break;

		default:
			break;
		}
	}

	@Override
	public void onAnimationEnd(Animation animation) {

	}

	@Override
	public void onAnimationRepeat(Animation animation) {

	}

	@Override
	public void onAnimationStart(Animation animation) {

	}

}
