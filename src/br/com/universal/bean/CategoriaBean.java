package br.com.universal.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.dao.DataIntegrityViolationException;

import br.com.universal.model.Categoria;
import br.com.universal.service.inter.ICategoriaService;

public class CategoriaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2089847905752291431L;
	
	private ICategoriaService categoriaService;
	
	private Categoria categoria;
	
	private List<Categoria> listaCategorias;
	
	private Integer id;
	
	public String preparaInserir() {
		categoria = new Categoria();
		listaCategorias = categoriaService.listarTodos();
		System.out.println(listaCategorias);
		
		return "formCategoria";
	}

	public String preparaAtualizar() {
		categoria = categoriaService.buscarPorId(id);
		return "formCategoria";
	}

	public String salvar() {
		if (categoria.getId() == null) {
			categoriaService.salvar(categoria);
		} else {
			categoriaService.atualizar(categoria);
		}
		return listar();
	}

	public String atualizar() {
		categoriaService.atualizar(categoria);
		return listar();
	}

	public String apagar() {
		try {
			categoriaService.apagar(categoria);
		} catch (DataIntegrityViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("Não foi possivel realizar a exclusao.");
			context.addMessage("formCategoria", message);
			return null;
		}
		return listar();
	}

	public String listar() {
		listaCategorias = categoriaService.listarTodos();
		System.out.println(listaCategorias);
		return "listCategoria";
	}


	public void buscarPorId() {
		categoria = categoriaService.buscarPorId(id);
	}

	public void setCategoriaService(ICategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	public ICategoriaService getCategoriaService() {
		return categoriaService;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setListaCategorias(List<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public List<Categoria> getListaCategorias() {
		return listaCategorias;
	}
	
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

}
