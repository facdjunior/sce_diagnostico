
package Modelo;

/**
 *
 * @author Francisco Junior
 */
public class Cidade {
    private int codigo;
    private String nome;
    private Integer uf_codigo;
    private Integer codibge;

    public Cidade() {
    }

    public Cidade(int codigo, String nome, Integer uf_codigo, Integer codibge) {
        this.codigo = codigo;
        this.nome = nome;
        this.uf_codigo = uf_codigo;
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

    public Integer getUf_codigo() {
        return uf_codigo;
    }

    public void setUf_codigo(Integer uf_codigo) {
        this.uf_codigo = uf_codigo;
    }

    public Integer getCodibge() {
        return codibge;
    }

    public void setCodibge(Integer codibge) {
        this.codibge = codibge;
    }
    
    
} 
