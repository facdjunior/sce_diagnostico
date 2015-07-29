/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CidadeDAO;
import Modelo.Cidade;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
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
public class CidadeBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Cidade cidadeB;
    private DataModel listaCidade;

    public CidadeBean() {
    cidadeB = new Cidade();
    }

    public Cidade getCidadeB() {
        return cidadeB;
    }

    public void setCidadeB(Cidade cidadeB) {
        this.cidadeB = cidadeB;
    }

    public DataModel getListaCidade() {
        CidadeDAO cd = new CidadeDAO();
        listaCidade = new ListDataModel(cd.listarCidade());
        return listaCidade;
    }

    public void setListaCidade(DataModel listaCidade) {
        this.listaCidade = listaCidade;
    }
 
    public void novoCidade(){
        cidadeB = new Cidade();
        
    }
    
    public void selecionarCidade(){
        cidadeB = (Cidade) listaCidade.getRowData();
    }
    
    public String salvaCidade(){
        CidadeDAO est = new CidadeDAO();
        if(est.salvarCidade(cidadeB)){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com Sucesso",""));
            return "/listas/listacidade.jsf";
        }
        return "erro";
    }
    
    public String editarCidade(){
        CidadeDAO cd = new CidadeDAO();
        if(cd.editarCidade(cidadeB)){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado alterado com Sucesso",""));
            return "/listas/listacidade.jsf";
        }
        return "erro";
    }
    
    public String excluirCidade(){
        CidadeDAO cd = new CidadeDAO();
        if(cd.excluirCidade(cidadeB)){ 
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado excluído com Sucesso",""));
            return "/listas/listacidade.jsf";
        } 
        return "erro";
    }
    
}
