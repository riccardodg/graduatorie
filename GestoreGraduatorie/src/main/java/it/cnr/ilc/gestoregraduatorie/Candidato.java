/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.ilc.gestoregraduatorie;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author riccardodelgratta
 */
public class Candidato {

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
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    private String nomeCompleto;
    private String nome;
    private String cognome;
    private String chiave;
    private List<Graduatoria> graduatorie=new ArrayList<>();
    private String fileOrigine;

    public Candidato(String nome, List<Graduatoria> graduatorie) {
        this.nomeCompleto = nome;
        this.graduatorie = graduatorie;
    }

    public Candidato() {
    }

    
    /**
     * @return the nomeCompleto
     */
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    /**
     * @param nomeCompleto the nomeCompleto to set
     */
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
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

    /**
     * @return the chiave
     */
    public String getChiave() {
        return chiave;
    }

    /**
     * @param chiave the chiave to set
     */
    public void setChiave(String chiave) {
        this.chiave = chiave;
    }

    /**
     * @return the fileOrigine
     */
    public String getFileOrigine() {
        return fileOrigine;
    }

    /**
     * @param fileOrigine the fileOrigine to set
     */
    public void setFileOrigine(String fileOrigine) {
        this.fileOrigine = fileOrigine;
    }
    
    
    
}
