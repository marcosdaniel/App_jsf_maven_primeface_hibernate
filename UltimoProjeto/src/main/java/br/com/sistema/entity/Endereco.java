package br.com.sistema.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Marcos
 */
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable{
    private static final Long SerialVersionUID = 1L;
    
    //------------------------//
    //Atributes
    //------------------------//
    @Id
    @GeneratedValue
    @Column(name = "IdEndereco", nullable = false)
    private Integer idEndereco;
    
    @Column(name = "Bairro", length = 80,  nullable = false)
    private String bairro;
    @Column(name = "NomeLogradouro", length = 160,  nullable = false)
    private String nomeLogradouro;
    @Column(name = "CEP", length = 9,  nullable = false)
    private String cep;
    @Column(name = "Numero", nullable = false)
    private Integer numero;
    @Column(name = "Complemento")
    private Integer complemento;
    
    //------------------------//
    //Construct
    //------------------------//
    public Endereco() {
    }
    
}
