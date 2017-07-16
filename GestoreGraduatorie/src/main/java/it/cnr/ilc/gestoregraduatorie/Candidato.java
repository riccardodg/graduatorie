/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.ilc.gestoregraduatorie;

import java.util.List;

/**
 *
 * @author riccardodelgratta
 */
public class Candidato {
    
    private String nome;
    private List<Graduatoria> graduatorie;

    public Candidato(String nome, List<Graduatoria> graduatorie) {
        this.nome = nome;
        this.graduatorie = graduatorie;
    }

    public Candidato() {
    }

    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the graduatorie
     */
    public List<Graduatoria> getGraduatorie() {
        return graduatorie;
    }

    /**
     * @param graduatorie the graduatorie to set
     */
    public void setGraduatorie(List<Graduatoria> graduatorie) {
        this.graduatorie = graduatorie;
    }
    
    
    
}
