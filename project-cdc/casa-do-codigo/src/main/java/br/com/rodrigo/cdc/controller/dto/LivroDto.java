package br.com.rodrigo.cdc.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.rodrigo.cdc.modelo.Autor;
import br.com.rodrigo.cdc.modelo.Categoria;
import br.com.rodrigo.cdc.modelo.Livro;

public class LivroDto {

	private String titulo;
	private String sinopse;
	private String sumario;
	private BigDecimal preco;
	private Integer paginas;
	private String isbn;
	private LocalDate dataDePublicacao;
	private Categoria categoria;
	private Autor autor;

	public LivroDto(Livro livro) {
		super();
		this.titulo = livro.getTitulo();
		this.sinopse = livro.getSinopse();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.paginas = livro.getPaginas();
		this.isbn = livro.getIsbn();
		this.dataDePublicacao = livro.getDataDePublicacao();
		this.categoria = livro.getCategoria();
		this.autor = livro.getAutor();
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

	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getDataDePublicacao() {
		return dataDePublicacao;
	}

	public void setDataDePublicacao(LocalDate dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}
