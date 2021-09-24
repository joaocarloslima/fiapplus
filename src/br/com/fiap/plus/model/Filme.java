package br.com.fiap.plus.model;

public class Filme {
	//POJO
	private Long id;
	private String titulo;
	private String sinopse;
	private int ano;
	private double nota;
	private boolean assistido;
	private String ondeAssistir;
	
	public Filme(String titulo, String sinopse, int ano, double nota, boolean assistido, String ondeAssistir) {
		super();
		this.titulo = titulo;
		this.sinopse = sinopse;
		this.ano = ano;
		this.nota = nota;
		this.assistido = assistido;
		this.ondeAssistir = ondeAssistir;
	}
	
	

	public Filme(Long id, String titulo, String sinopse, int ano, double nota, boolean assistido, String ondeAssistir) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.sinopse = sinopse;
		this.ano = ano;
		this.nota = nota;
		this.assistido = assistido;
		this.ondeAssistir = ondeAssistir;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public boolean isAssistido() {
		return assistido;
	}

	public void setAssistido(boolean assistido) {
		this.assistido = assistido;
	}

	public String getOndeAssistir() {
		return ondeAssistir;
	}

	public void setOndeAssistir(String ondeAssistir) {
		this.ondeAssistir = ondeAssistir;
	}

	public String[] toArray() {
		String[] filme = {
				String.valueOf(this.id), 
				this.titulo, 
				this.sinopse, 
				String.valueOf(this.ano), 
				String.valueOf(this.nota), 
				this.assistido?"SIM":"NÃO", 
				this.ondeAssistir
		}; 
		return filme;
	}

}
