/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Marcos
 */
@Entity
@Table(name = "estado")
public class Estado implements Serializable{
    private static final Long SerialVersionUID = 1L;
    
    //------------------------//
    //Atributes
    //------------------------//
    @Id
    @GeneratedValue
    @Column(name = "IdEstado", nullable = false)
    private Integer idEstado;
    @Column(name = "Nome", nullable = false, length = 80, unique = true)
    private String nome;
    
    //------------------------//
    //Mappings
    //------------------------//
    @OneToMany(mappedBy = "estado", fetch = FetchType.LAZY)
    @ForeignKey(name = "Endereco_Estado")
    private List<Endereco> enderecos;
    
    //------------------------//
    //Constructor
    //------------------------//
    public Estado() {
    }

    //------------------------//
    //Getter's and Setter's
    //------------------------//
    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    //------------------------//
    //Equals and Hash Codes
    //------------------------//
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (this.idEstado != null ? this.idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estado other = (Estado) obj;
        if (this.idEstado != other.idEstado && (this.idEstado == null || !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }
    
}
