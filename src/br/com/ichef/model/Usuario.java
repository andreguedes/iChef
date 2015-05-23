package br.com.ichef.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

/**
 * Esta � a classe modelo para cria��o da tabela Usuario
 * 
 * @author Andr�
 *
 */
@Table(name = "Usuario")
public class Usuario extends Model {

	@Column(name = "Nome")
	public String nome;

	@Column(name = "Email")
	public String email;

	@Column(name = "Senha")
	public String senha;

	public Usuario() {
		super();
	}

	/**
	 * Construtor sobrecarregado com informa��es do novo usu�rio
	 * 
	 * @param nome
	 *            Nome do novo usu�rio
	 * @param email
	 *            E-mail do novo usu�rio
	 * @param senha
	 *            Senha do novo usu�rio
	 */
	public Usuario(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	/**
	 * Este m�todo retorna um booleano informando a exist�ncia de um usu�rio
	 * para realiza��o do login no app
	 * 
	 * @param email
	 *            E-mail do usu�rio
	 * @param senha
	 *            Senha do usu�rio
	 * @return boolean
	 */
	public static boolean getUsuario(String email, String senha) {
		Usuario u = new Select().from(Usuario.class).where("Email = ?", email)
				.executeSingle();
		if (u == null)
			return false;
		return u.senha.equals(senha);
	}

}