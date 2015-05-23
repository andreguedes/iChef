package br.com.ichef;

import br.com.ichef.model.Usuario;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Activity para cadastro de novos usuarios do app iChef
 * 
 * @author André
 *
 */
public class CadastroActivity extends Activity implements OnClickListener {

	Button btnCadastrar;
	EditText edtEmailCadastro, edtSenhaCadastro, edtNomeCadastro;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastro);

		edtEmailCadastro = (EditText) findViewById(R.id.edtEmailCadastro);
		edtSenhaCadastro = (EditText) findViewById(R.id.edtSenhaCadastro);
		edtNomeCadastro = (EditText) findViewById(R.id.edtNomeCadastro);

		btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
		btnCadastrar.setOnClickListener(this);
	}

	/**
	 * Este método contém a validação de campos vazios, e insere novos usuarios
	 * conforme as informações resgatadas da view
	 */
	@Override
	public void onClick(View v) {
		String email = edtEmailCadastro.getText().toString();
		String senha = edtSenhaCadastro.getText().toString();
		String nome = edtNomeCadastro.getText().toString();

		switch (v.getId()) {
		case R.id.btnCadastrar:
			if (nome.equals(""))
				edtNomeCadastro.setError(getString(R.string.preencha));
			else if (email.equals(""))
				edtEmailCadastro.setError(getString(R.string.preencha));
			else if (senha.equals(""))
				edtSenhaCadastro.setError(getString(R.string.preencha));
			else {
				Usuario usuario = new Usuario(nome, email, senha);
				usuario.save();

				Toast.makeText(
						this,
						getResources().getString(R.string.usuario_cadastrado)
								+ " " + nome, Toast.LENGTH_SHORT).show();
				finish();
			}
			break;

		default:
			break;
		}
	}
}
