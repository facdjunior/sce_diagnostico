package Modelo;

import java.io.Serializable;

/**
 *
 * @author Francisco Junior 29-07-2015
 */
public class Estado implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private int codigo;
    private String nome;
    private String sigla;
    private Integer codibge;

    public Estado() {
    }

    public Estado(int codigo, String nome, String sigla, Integer codibge) {
        this.codigo = codigo;
        this.nome = nome;
        this.sigla = sigla;
        this.codibge = codibge;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Integer getCodibge() {
        return codibge;
    }

    public void setCodibge(Integer codibge) {
        this.codibge = codibge;
    }
}
