package br.com.sistema.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;


/**
 *
 * @author Marcos
 */
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable{
    
    private static final Long SerialVersionUID = 1L;
    
    //------------------------//
    //Atributes
    //------------------------//
    @Id
    @GeneratedValue
    @Column(name = "IdPessoa", nullable = false)
    private Integer idPessoa;
    
    @Column(name = "Nome", nullable = false, length = 80)
    private String nome;
    @Column(name = "Email", nullable = false, length = 80)
    private String email;
    @Column(name = "Telefone", nullable = false, length = 20)
    private String telefone;
    @Column(name = "Cpf", nullable = false, length = 15)
    private String cpf;
    @Column(name = "DataDeNascimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeNascimento;
    @Column(name = "DataDeCadastro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeCadastro;
    
    //------------------------//
    //Mappings
    //------------------------//
    @OneToOne(mappedBy = "pessoa", fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoPessoa")
    private Endereco endereco;
    
    @ManyToOne (optional=false)
    @ForeignKey(name = "PessoaSexo")
    @JoinColumn(name = "IdSexo", referencedColumnName = "IdSexo")
    private Sexo sexo;
    //------------------------// 
    //Constructor
    //------------------------//
    public Pessoa() {
    }

    //------------------------//
    //Getter's and Setter's
    //------------------------//
    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    //------------------------//
    //Equals and Hash Codes
    //------------------------//
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this.idPessoa != null ? this.idPessoa.hashCode() : 0);
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
        final Pessoa other = (Pessoa) obj;
        if (this.idPessoa != other.idPessoa && (this.idPessoa == null || !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }
    
    
}
