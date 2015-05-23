package br.com.ichef.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

/**
 * Esta é a classe modelo para criação da tabela Usuario
 * 
 * @author André
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
	 * Construtor sobrecarregado com informações do novo usuário
	 * 
	 * @param nome
	 *            Nome do novo usuário
	 * @param email
	 *            E-mail do novo usuário
	 * @param senha
	 *            Senha do novo usuário
	 */
	public Usuario(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	/**
	 * Este método retorna um booleano informando a existência de um usuário
	 * para realização do login no app
	 * 
	 * @param email
	 *            E-mail do usuário
	 * @param senha
	 *            Senha do usuário
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