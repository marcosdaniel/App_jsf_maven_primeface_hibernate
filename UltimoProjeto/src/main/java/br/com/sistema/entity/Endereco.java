package br.com.sistema.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

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
    //Mappings
    //------------------------//
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoPessoa")
    @JoinColumn(name = "IdPessoa", referencedColumnName = "IdPessoa")
    private Pessoa pessoa;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoTipoLogradouro")
    @JoinColumn(name = "IdTipoLogradouro", referencedColumnName = "IdTipoLogradouro")
    private TipoLogradouro tipoLogradouro;
    //------------------------//
    //Construct
    //------------------------//
    public Endereco() {
    }
    
    //------------------------//
    //Getter's and Setter's
    //------------------------//
    
}
