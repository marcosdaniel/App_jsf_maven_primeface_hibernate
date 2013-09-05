/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.entity;

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
@Table(name = "tipoendereco")
public class TipoEndereco {
    
    private static final Long SerialVersionUID = 1L;
    
    //------------------------//
    //Atributes
    //------------------------//
    @Id
    @GeneratedValue
    @Column(name = "IdTipoEndereco", nullable = false)
    private Integer idTipoEndereco;
    @Column(name = "DescricaoTipoEndereco", nullable = false, length = 35)
    private String descricaoTipoEndereco;

    //------------------------//
    //Mappings
    //------------------------//
    @OneToMany(mappedBy = "tipoendereco", fetch = FetchType.LAZY)
    @ForeignKey(name = "Endereco_TipoEndereco")
    private List<Endereco> enderecos;
    
    //------------------------//
    //Constructor
    //------------------------//
    public TipoEndereco() {
    }
    
    //------------------------//
    //Getter's and Setter's
    //------------------------//
    public Integer getIdTipoEndereco() {
        return idTipoEndereco;
    }

    public void setIdTipoEndereco(Integer idTipoEndereco) {
        this.idTipoEndereco = idTipoEndereco;
    }

    public String getDescricaoTipoEndereco() {
        return descricaoTipoEndereco;
    }

    public void setDescricaoTipoEndereco(String descricaoTipoEndereco) {
        this.descricaoTipoEndereco = descricaoTipoEndereco;
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
        int hash = 3;
        hash = 47 * hash + (this.idTipoEndereco != null ? this.idTipoEndereco.hashCode() : 0);
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
        final TipoEndereco other = (TipoEndereco) obj;
        if (this.idTipoEndereco != other.idTipoEndereco && (this.idTipoEndereco == null || !this.idTipoEndereco.equals(other.idTipoEndereco))) {
            return false;
        }
        return true;
    }
    
}
