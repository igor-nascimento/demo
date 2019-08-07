package com.example.demo.vo;

import java.util.Date;

public class Projeto {
	
	private Long id;
	
	private String nome;
	
	
	private Empresa empresa;
	
	private boolean status;

	private Date data_ativacao;
	
	private Date data_desativacao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getData_ativacao() {
		return data_ativacao;
	}

	public void setData_ativacao(Date data_ativacao) {
		this.data_ativacao = data_ativacao;
	}

	public Date getData_desativacao() {
		return data_desativacao;
	}

	public void setData_desativacao(Date data_desativacao) {
		this.data_desativacao = data_desativacao;
	}

	public Projeto() {
		empresa = new Empresa();
	}
	
}
