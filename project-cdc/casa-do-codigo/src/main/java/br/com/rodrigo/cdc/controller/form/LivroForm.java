package br.com.rodrigo.cdc.controller.form;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.rodrigo.cdc.annotations.Exists;
import br.com.rodrigo.cdc.annotations.FutureDate;
import br.com.rodrigo.cdc.annotations.UniqueValue;
import br.com.rodrigo.cdc.modelo.Autor;
import br.com.rodrigo.cdc.modelo.Categoria;
import br.com.rodrigo.cdc.modelo.Livro;
import br.com.rodrigo.cdc.repository.AutorRepository;
import br.com.rodrigo.cdc.repository.CategoriaRepository;

public class LivroForm {

	@NotNull
	@NotEmpty
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "Este título já está cadastrado")
	private String titulo;
	@NotNull
	@NotEmpty
	@NotBlank
	@Size(max = 500)
	private String sinopse;
	@NotNull
	@NotBlank
	private String sumario;
	@NotNull
	@DecimalMin(value = "20.0", inclusive = true)
	private BigDecimal preco;
	@NotNull
	@Min(value = 100)
	private Integer paginas;
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn", message = "Este ISBN já está cadastrado")
	private String isbn;
	@NotNull
	@NotEmpty
	@NotBlank
	@FutureDate(domainClass = Livro.class, fieldName = "dataDePublicacao", message = "A data cadastrada deve ser no futuro")
	private String dataDePublicacao;
	@NotNull
	@Exists(domainClass = Categoria.class, fieldName = "nome", message = "Esta categoria não está cadastrada")
	private String categoria;
	@NotNull
	@Exists(domainClass = Autor.class, fieldName = "nome", message = "Esta pessoa autora não está cadastrado")
	private String autor;
	

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

	public String getDataDePublicacao() {
		return dataDePublicacao;
	}

	public void setDataDePublicacao(String dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Livro converter(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
		Optional<Autor> autorObj = autorRepository.findByNome(autor);
		Optional<Categoria> categoriaObj = categoriaRepository.findByNome(categoria);
		LocalDate formattedDate = dateConverter(dataDePublicacao);

		if (autorObj.isEmpty() || categoriaObj.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		
		return new Livro(titulo, sinopse, sumario, preco, paginas, isbn, formattedDate, categoriaObj.get(), autorObj.get());
	}

	private LocalDate dateConverter(String dateString) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate futureDate = LocalDate.parse(dateString, dateFormat);

		return futureDate;
	}
}
