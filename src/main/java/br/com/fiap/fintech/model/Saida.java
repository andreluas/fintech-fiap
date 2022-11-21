package br.com.fiap.fintech.model;

import java.util.Objects;

public class Saida {

	private int id;
	private String nome;
	private Double valor;
	private Usuario usuario;

	public Saida() {
	}
	
	public Saida(String nome, Double valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}
	
	public Saida(String nome, Double valor, Usuario usuario) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.usuario = usuario;
	}
	
	public Saida(int id, String nome, Double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}

	public Saida(int id, String nome, Double valor, Usuario usuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, usuario, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Saida other = (Saida) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(usuario, other.usuario) && Objects.equals(valor, other.valor);
	}
}