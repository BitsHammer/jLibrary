package com.bitshammer.livro;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bitshammer.autor.Autor;
import com.bitshammer.editora.Editora;

/**
 * 
 * Classe que representa um livro
 * @author Bruno
 */
/**
 * @author leticia.costa
 *
 */
@Entity
public class Livro {
	
	/**
	 * Id
	 */
	@Id
	@Column(name="livro_id")
	@GeneratedValue
	private Integer id;
	
	/**
	 * Título
	 */
	@Column(nullable=false, length=200)
	private String titulo;

	/**
	 * Número de páginas
	 */
	@Column(nullable=false)
	private Integer numeroPaginas;

	/**
	 * Editora do livro
	 */
	@ManyToOne
	@JoinColumn(name="editora_id", referencedColumnName="editora_id")
	private Editora editora;

	/**
	 * Lista de autores
	 */
	@ManyToMany
	@JoinTable(
	      name="autor_livro",
	      joinColumns={@JoinColumn(name="livro_id", referencedColumnName="livro_id")},
	      inverseJoinColumns={@JoinColumn(name="autor_id", referencedColumnName="autor_id")})
	private List<Autor> autores;
	
	/**
	 * ISBN
	 */
	@Column(nullable=false, length=10)
	private Long isbn;
	
	/**
	 * Data da publicação
	 */
	@Temporal(TemporalType.DATE)
	private Date dataPublicacao;
	
	/**
	 * Preço de venda
	 */
	@Column(nullable=false)
	private Double precoVenda = 0d;
	
	/**
	 * Resumo do livro
	 */
	@Column(nullable=false)
	private String resumo;
	
	/**
	 * Formato do livro
	 */
	@Enumerated(EnumType.ORDINAL)
	private FormatoLivro formato;
	
	
	/**
	 * Preço de custo
	 */
	@Column(nullable=false)
	private Double precoCusto = 0d;
	
	/**
	 * Quantidade em estoque
	 */
	@Column(nullable=false)
	private Integer quantidadeEstoque;
	
	/**
	 * Indice
	 */
	@Column(nullable=false)
	private String indice;
	
	/**
	 * Categorias
	 */
    @ElementCollection(targetClass=Categoria.class)
    @Enumerated(EnumType.ORDINAL)
    @CollectionTable(name="categoria_livro")
    @Column(name="categoria")
	private List<Categoria> categorias;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the numeroPaginas
	 */
	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	/**
	 * @param numeroPaginas the numeroPaginas to set
	 */
	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	/**
	 * @return the editora
	 */
	public Editora getEditora() {
		if (editora == null){
			editora = new Editora();
		}
		return editora;
	}

	/**
	 * @param editora the editora to set
	 */
	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	/**
	 * @return the autores
	 */
	public List<Autor> getAutores() {
 		return autores;
	}

	/**
	 * @param autores the autores to set
	 */
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	/**
	 * @return the isbn
	 */
	public Long getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the dataPublicacao
	 */
	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	/**
	 * @param dataPublicacao the dataPublicacao to set
	 */
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	/**
	 * @return the precoVenda
	 */
	public Double getPrecoVenda() {
		return precoVenda;
	}

	/**
	 * @param precoVenda the precoVenda to set
	 */
	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	/**
	 * @return the resumo
	 */
	public String getResumo() {
		return resumo;
	}

	/**
	 * @param resumo the resumo to set
	 */
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	/**
	 * @return the formato
	 */
	public FormatoLivro getFormato() {
		return formato;
	}

	/**
	 * @param formato the formato to set
	 */
	public void setFormato(FormatoLivro formato) {
		this.formato = formato;
	}

	/**
	 * @return the precoCusto
	 */
	public Double getPrecoCusto() {
		return precoCusto;
	}

	/**
	 * @param precoCusto the precoCusto to set
	 */
	public void setPrecoCusto(Double precoCusto) {
		this.precoCusto = precoCusto;
	}

	/**
	 * @return the quantidadeEstoque
	 */
	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	/**
	 * @param quantidadeEstoque the quantidadeEstoque to set
	 */
	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	
	/**
	 * Calcula a margem de lucro
	 * @return
	 */
	public Double calcularMargemLucro(){
		return precoVenda - precoCusto;
	}

	/**
	 * @return the indice
	 */
	public String getIndice() {
		return indice;
	}

	/**
	 * @param indice the indice to set
	 */
	public void setIndice(String indice) {
		this.indice = indice;
	}

	/**
	 * @return the categorias
	 */
	public List<Categoria> getCategorias() {
		return categorias;
	}

	/**
	 * @param categorias the categorias to set
	 */
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		return id.equals(((Livro)obj).getId());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Livro [getId()=");
		builder.append(getId());
		builder.append(", getTitulo()=");
		builder.append(getTitulo());
		builder.append(", getNumeroPaginas()=");
		builder.append(getNumeroPaginas());
		builder.append(", getEditora()=");
		builder.append(getEditora());
		builder.append(", getAutores()=");
		builder.append(getAutores());
		builder.append(", getIsbn()=");
		builder.append(getIsbn());
		builder.append(", getDataPublicacao()=");
		builder.append(getDataPublicacao());
		builder.append(", getPrecoVenda()=");
		builder.append(getPrecoVenda());
		builder.append(", getResumo()=");
		builder.append(getResumo());
		builder.append(", getFormato()=");
		builder.append(getFormato());
		builder.append(", getPrecoCusto()=");
		builder.append(getPrecoCusto());
		builder.append(", getQuantidadeEstoque()=");
		builder.append(getQuantidadeEstoque());
		builder.append(", calcularMargemLucro()=");
		builder.append(calcularMargemLucro());
		builder.append(", getIndice()=");
		builder.append(getIndice());
		builder.append(", getCategorias()=");
		builder.append(getCategorias());
		builder.append("]");
		return builder.toString();
	}
	
	
}
