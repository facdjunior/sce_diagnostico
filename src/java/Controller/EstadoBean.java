package Controller;

import DAO.EstadoDAO;
import Modelo.Estado;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Francisco Junior
 */
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Estado estadoB;
    private DataModel listaEstado;

    public EstadoBean() {
    estadoB = new Estado();
    }

    public Estado getEstadoB() {
        return estadoB;
    }

    public void setEstadoB(Estado estadoB) {
        this.estadoB = estadoB;
    }

    public DataModel getListaEstado() {
        EstadoDAO cd = new EstadoDAO();
        listaEstado = new ListDataModel(cd.listarEstado());
        return listaEstado;
    }

    public void setListaEstado(DataModel listaEstado) {
        this.listaEstado = listaEstado;
    }
    
    public void novoContato(){
        estadoB = new Estado();
        
    }
    
    public void selecionarContato(){
        estadoB = (Estado) listaEstado.getRowData();
    }
    
    public String salvaEstado(){
        EstadoDAO est = new EstadoDAO();
        if(est.salvarContato(estadoB)){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com Sucesso",""));
            return "/listas/listaEstados.jsf";
        }
        return "erro";
    }
    
    public String editarEstado(){
        EstadoDAO cd = new EstadoDAO();
        if(cd.editarEstado(estadoB)){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado alterado com Sucesso",""));
            return "/listas/listaEstados.jsf";
        }
        return "erro";
    }
    
    public String excluirEstado(){
        EstadoDAO cd = new EstadoDAO();
        if(cd.excluirEstado(estadoB)){ 
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado excluído com Sucesso",""));
            return "/listas/listaEstados.jsf";
        } 
        return "erro";
    }
    
}
