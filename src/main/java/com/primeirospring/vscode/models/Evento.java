package com.primeirospring.vscode.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Evento
 * 
 */

@Entity
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;


    private String nome;
    private String local;
    private String data;
    private String horario;

    @OneToMany
    private List<Convidado> convidados;

    public String getNome() {
        return nome;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(final long codigo) {
        this.codigo = codigo;
    }

    public void setNome(final String nome) {
       this.nome = nome;
   }

   public String getLocal() {
       return local;
   }

   public void setLocal(final String local) {
       this.local = local;
   }

   public String getData() {
       return data;
   }

   public void setData(final String data) {
       this.data = data;
   }

   public String getHorario() {
       return horario;
   }

   public void setHorario(final String horario) {
       this.horario = horario;
   }

}