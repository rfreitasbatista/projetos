package br.com.rodrigo.cdc.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String sinopse;
	private String sumario;
	private BigDecimal preco;
	private Integer paginas;
	private String isbn;
	private LocalDate dataDePublicacao;
	@OneToOne
	private Categoria categoria;
	@OneToOne
	private Autor autor;

	
	@Deprecated
	public Livro() {
		// TODO Auto-generated constructor stub
	}
	
	public Livro(String titulo, String sinopse, String sumario, BigDecimal preco, Integer paginas, String isbn,
			 LocalDate dataDePublicacao, Categoria categoria, Autor autor) {
		super();
		this.titulo = titulo;
		this.sinopse = sinopse;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataDePublicacao = dataDePublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

	public Integer getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getSinopse() {
		return sinopse;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataDePublicacao() {
		return dataDePublicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}

}
