/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.ilc.gestoregraduatorie;

/**
 *
 * @author riccardodelgratta
 */
public class Graduatoria {

    private String CodClasseDiConcorso; //0
    private String DescrClasseDiConcorso; //1
    private String TipoPosto; //2
    private String CodTipoPosto; //3
    private String InclRis; //4
    private int Posto; //5
    private String Cognome; //6
    private String Nome; //7
    private String DataNascita; //8
    private String ProvNascita; //9
    private double Punteggio; //10
    private String Prefer1; //11
    private String Prefer2; //12
    private String Prefer3; //13
    private String Prefer4; //14
    private String AnnoIns; //15
    private String GradPreferAnnoPrec; //16
    private String CodTitoloSpec1; //17
    private String ConsegTitoloSpec1; //18
    private String CodTitoloSpec2; //19
    private String ConsegTitoloSpec2; //20
    private String CodTitoloSpec3; //21
    private String ConsegTitoloSpec3; //22
    private String CodTitoloSpec4; //23
    private String ConsegTitoloSpec4; //24
    private int NumFigli; //25
    private String ServSenzaDemerito; //26
    private String ScuolaAcquisDomanda; //27
    private String CodiceFiscale; //28
    private String ComNascita; //29
    private String Sesso; //30
    private String CodComune; //31
    private String ComResidenza; //32
    private String CAP; //33
    private String Via; //34
    private String Tel; //35
    private String Cell; //36
    private String ProvPresentDomanda; //37
    private int PostoProvinciale; //38
    private String FasciaGradProv; //39
    private String ModalitaAccesso; //40
    private String IndirizzoEMail; //41
    private String Supplenza10gg; //42
    private String TipologiaGraduatoria; //43
    
    private String fileOrigine;

    /**
     * @return the CodClasseDiConcorso
     */
    public String getCodClasseDiConcorso() {
        return CodClasseDiConcorso;
    }

    /**
     * @param CodClasseDiConcorso the CodClasseDiConcorso to set
     */
    public void setCodClasseDiConcorso(String CodClasseDiConcorso) {
        this.CodClasseDiConcorso = CodClasseDiConcorso;
    }

    /**
     * @return the DescrClasseDiConcorso
     */
    public String getDescrClasseDiConcorso() {
        return DescrClasseDiConcorso;
    }

    /**
     * @param DescrClasseDiConcorso the DescrClasseDiConcorso to set
     */
    public void setDescrClasseDiConcorso(String DescrClasseDiConcorso) {
        this.DescrClasseDiConcorso = DescrClasseDiConcorso;
    }

    /**
     * @return the TipoPosto
     */
    public String getTipoPosto() {
        return TipoPosto;
    }

    /**
     * @param TipoPosto the TipoPosto to set
     */
    public void setTipoPosto(String TipoPosto) {
        this.TipoPosto = TipoPosto;
    }

    /**
     * @return the CodTipoPosto
     */
    public String getCodTipoPosto() {
        return CodTipoPosto;
    }

    /**
     * @param CodTipoPosto the CodTipoPosto to set
     */
    public void setCodTipoPosto(String CodTipoPosto) {
        this.CodTipoPosto = CodTipoPosto;
    }

    /**
     * @return the InclRis
     */
    public String getInclRis() {
        return InclRis;
    }

    /**
     * @param InclRis the InclRis to set
     */
    public void setInclRis(String InclRis) {
        this.InclRis = InclRis;
    }

    /**
     * @return the Posto
     */
    public int getPosto() {
        return Posto;
    }

    /**
     * @param Posto the Posto to set
     */
    public void setPosto(int Posto) {
        this.Posto = Posto;
    }

    /**
     * @return the Cognome
     */
    public String getCognome() {
        return Cognome;
    }

    /**
     * @param Cognome the Cognome to set
     */
    public void setCognome(String Cognome) {
        this.Cognome = Cognome;
    }

    /**
     * @return the Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * @return the DataNascita
     */
    public String getDataNascita() {
        return DataNascita;
    }

    /**
     * @param DataNascita the DataNascita to set
     */
    public void setDataNascita(String DataNascita) {
        this.DataNascita = DataNascita;
    }

    /**
     * @return the ProvNascita
     */
    public String getProvNascita() {
        return ProvNascita;
    }

    /**
     * @param ProvNascita the ProvNascita to set
     */
    public void setProvNascita(String ProvNascita) {
        this.ProvNascita = ProvNascita;
    }

    /**
     * @return the Punteggio
     */
    public double getPunteggio() {
        return Punteggio;
    }

    /**
     * @param Punteggio the Punteggio to set
     */
    public void setPunteggio(double Punteggio) {
        this.Punteggio = Punteggio;
    }

    /**
     * @return the Prefer1
     */
    public String getPrefer1() {
        return Prefer1;
    }

    /**
     * @param Prefer1 the Prefer1 to set
     */
    public void setPrefer1(String Prefer1) {
        this.Prefer1 = Prefer1;
    }

    /**
     * @return the Prefer2
     */
    public String getPrefer2() {
        return Prefer2;
    }

    /**
     * @param Prefer2 the Prefer2 to set
     */
    public void setPrefer2(String Prefer2) {
        this.Prefer2 = Prefer2;
    }

    /**
     * @return the Prefer3
     */
    public String getPrefer3() {
        return Prefer3;
    }

    /**
     * @param Prefer3 the Prefer3 to set
     */
    public void setPrefer3(String Prefer3) {
        this.Prefer3 = Prefer3;
    }

    /**
     * @return the Prefer4
     */
    public String getPrefer4() {
        return Prefer4;
    }

    /**
     * @param Prefer4 the Prefer4 to set
     */
    public void setPrefer4(String Prefer4) {
        this.Prefer4 = Prefer4;
    }

    /**
     * @return the AnnoIns
     */
    public String getAnnoIns() {
        return AnnoIns;
    }

    /**
     * @param AnnoIns the AnnoIns to set
     */
    public void setAnnoIns(String AnnoIns) {
        this.AnnoIns = AnnoIns;
    }

    /**
     * @return the GradPreferAnnoPrec
     */
    public String getGradPreferAnnoPrec() {
        return GradPreferAnnoPrec;
    }

    /**
     * @param GradPreferAnnoPrec the GradPreferAnnoPrec to set
     */
    public void setGradPreferAnnoPrec(String GradPreferAnnoPrec) {
        this.GradPreferAnnoPrec = GradPreferAnnoPrec;
    }

    /**
     * @return the CodTitoloSpec1
     */
    public String getCodTitoloSpec1() {
        return CodTitoloSpec1;
    }

    /**
     * @param CodTitoloSpec1 the CodTitoloSpec1 to set
     */
    public void setCodTitoloSpec1(String CodTitoloSpec1) {
        this.CodTitoloSpec1 = CodTitoloSpec1;
    }

    /**
     * @return the ConsegTitoloSpec1
     */
    public String getConsegTitoloSpec1() {
        return ConsegTitoloSpec1;
    }

    /**
     * @param ConsegTitoloSpec1 the ConsegTitoloSpec1 to set
     */
    public void setConsegTitoloSpec1(String ConsegTitoloSpec1) {
        this.ConsegTitoloSpec1 = ConsegTitoloSpec1;
    }

    /**
     * @return the CodTitoloSpec2
     */
    public String getCodTitoloSpec2() {
        return CodTitoloSpec2;
    }

    /**
     * @param CodTitoloSpec2 the CodTitoloSpec2 to set
     */
    public void setCodTitoloSpec2(String CodTitoloSpec2) {
        this.CodTitoloSpec2 = CodTitoloSpec2;
    }

    /**
     * @return the ConsegTitoloSpec2
     */
    public String getConsegTitoloSpec2() {
        return ConsegTitoloSpec2;
    }

    /**
     * @param ConsegTitoloSpec2 the ConsegTitoloSpec2 to set
     */
    public void setConsegTitoloSpec2(String ConsegTitoloSpec2) {
        this.ConsegTitoloSpec2 = ConsegTitoloSpec2;
    }

    /**
     * @return the CodTitoloSpec3
     */
    public String getCodTitoloSpec3() {
        return CodTitoloSpec3;
    }

    /**
     * @param CodTitoloSpec3 the CodTitoloSpec3 to set
     */
    public void setCodTitoloSpec3(String CodTitoloSpec3) {
        this.CodTitoloSpec3 = CodTitoloSpec3;
    }

    /**
     * @return the ConsegTitoloSpec3
     */
    public String getConsegTitoloSpec3() {
        return ConsegTitoloSpec3;
    }

    /**
     * @param ConsegTitoloSpec3 the ConsegTitoloSpec3 to set
     */
    public void setConsegTitoloSpec3(String ConsegTitoloSpec3) {
        this.ConsegTitoloSpec3 = ConsegTitoloSpec3;
    }

    /**
     * @return the CodTitoloSpec4
     */
    public String getCodTitoloSpec4() {
        return CodTitoloSpec4;
    }

    /**
     * @param CodTitoloSpec4 the CodTitoloSpec4 to set
     */
    public void setCodTitoloSpec4(String CodTitoloSpec4) {
        this.CodTitoloSpec4 = CodTitoloSpec4;
    }

    /**
     * @return the ConsegTitoloSpec4
     */
    public String getConsegTitoloSpec4() {
        return ConsegTitoloSpec4;
    }

    /**
     * @param ConsegTitoloSpec4 the ConsegTitoloSpec4 to set
     */
    public void setConsegTitoloSpec4(String ConsegTitoloSpec4) {
        this.ConsegTitoloSpec4 = ConsegTitoloSpec4;
    }

    /**
     * @return the NumFigli
     */
    public int getNumFigli() {
        return NumFigli;
    }

    /**
     * @param NumFigli the NumFigli to set
     */
    public void setNumFigli(int NumFigli) {
        this.NumFigli = NumFigli;
    }

    /**
     * @return the ServSenzaDemerito
     */
    public String getServSenzaDemerito() {
        return ServSenzaDemerito;
    }

    /**
     * @param ServSenzaDemerito the ServSenzaDemerito to set
     */
    public void setServSenzaDemerito(String ServSenzaDemerito) {
        this.ServSenzaDemerito = ServSenzaDemerito;
    }

    /**
     * @return the ScuolaAcquisDomanda
     */
    public String getScuolaAcquisDomanda() {
        return ScuolaAcquisDomanda;
    }

    /**
     * @param ScuolaAcquisDomanda the ScuolaAcquisDomanda to set
     */
    public void setScuolaAcquisDomanda(String ScuolaAcquisDomanda) {
        this.ScuolaAcquisDomanda = ScuolaAcquisDomanda;
    }

    /**
     * @return the CodiceFiscale
     */
    public String getCodiceFiscale() {
        return CodiceFiscale;
    }

    /**
     * @param CodiceFiscale the CodiceFiscale to set
     */
    public void setCodiceFiscale(String CodiceFiscale) {
        this.CodiceFiscale = CodiceFiscale;
    }

    /**
     * @return the ComNascita
     */
    public String getComNascita() {
        return ComNascita;
    }

    /**
     * @param ComNascita the ComNascita to set
     */
    public void setComNascita(String ComNascita) {
        this.ComNascita = ComNascita;
    }

    /**
     * @return the Sesso
     */
    public String getSesso() {
        return Sesso;
    }

    /**
     * @param Sesso the Sesso to set
     */
    public void setSesso(String Sesso) {
        this.Sesso = Sesso;
    }

    /**
     * @return the CodComune
     */
    public String getCodComune() {
        return CodComune;
    }

    /**
     * @param CodComune the CodComune to set
     */
    public void setCodComune(String CodComune) {
        this.CodComune = CodComune;
    }

    /**
     * @return the ComResidenza
     */
    public String getComResidenza() {
        return ComResidenza;
    }

    /**
     * @param ComResidenza the ComResidenza to set
     */
    public void setComResidenza(String ComResidenza) {
        this.ComResidenza = ComResidenza;
    }

    /**
     * @return the CAP
     */
    public String getCAP() {
        return CAP;
    }

    /**
     * @param CAP the CAP to set
     */
    public void setCAP(String CAP) {
        this.CAP = CAP;
    }

    /**
     * @return the Via
     */
    public String getVia() {
        return Via;
    }

    /**
     * @param Via the Via to set
     */
    public void setVia(String Via) {
        this.Via = Via;
    }

    /**
     * @return the Tel
     */
    public String getTel() {
        return Tel;
    }

    /**
     * @param Tel the Tel to set
     */
    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    /**
     * @return the Cell
     */
    public String getCell() {
        return Cell;
    }

    /**
     * @param Cell the Cell to set
     */
    public void setCell(String Cell) {
        this.Cell = Cell;
    }

    /**
     * @return the ProvPresentDomanda
     */
    public String getProvPresentDomanda() {
        return ProvPresentDomanda;
    }

    /**
     * @param ProvPresentDomanda the ProvPresentDomanda to set
     */
    public void setProvPresentDomanda(String ProvPresentDomanda) {
        this.ProvPresentDomanda = ProvPresentDomanda;
    }

    /**
     * @return the PostoProvinciale
     */
    public int getPostoProvinciale() {
        return PostoProvinciale;
    }

    /**
     * @param PostoProvinciale the PostoProvinciale to set
     */
    public void setPostoProvinciale(int PostoProvinciale) {
        this.PostoProvinciale = PostoProvinciale;
    }

    /**
     * @return the FasciaGradProv
     */
    public String getFasciaGradProv() {
        return FasciaGradProv;
    }

    /**
     * @param FasciaGradProv the FasciaGradProv to set
     */
    public void setFasciaGradProv(String FasciaGradProv) {
        this.FasciaGradProv = FasciaGradProv;
    }

    /**
     * @return the ModalitaAccesso
     */
    public String getModalitaAccesso() {
        return ModalitaAccesso;
    }

    /**
     * @param ModalitaAccesso the ModalitaAccesso to set
     */
    public void setModalitaAccesso(String ModalitaAccesso) {
        this.ModalitaAccesso = ModalitaAccesso;
    }

    /**
     * @return the IndirizzoEMail
     */
    public String getIndirizzoEMail() {
        return IndirizzoEMail;
    }

    /**
     * @param IndirizzoEMail the IndirizzoEMail to set
     */
    public void setIndirizzoEMail(String IndirizzoEMail) {
        this.IndirizzoEMail = IndirizzoEMail;
    }

    /**
     * @return the Supplenza10gg
     */
    public String getSupplenza10gg() {
        return Supplenza10gg;
    }

    /**
     * @param Supplenza10gg the Supplenza10gg to set
     */
    public void setSupplenza10gg(String Supplenza10gg) {
        this.Supplenza10gg = Supplenza10gg;
    }

    /**
     * @return the TipologiaGraduatoria
     */
    public String getTipologiaGraduatoria() {
        return TipologiaGraduatoria;
    }

    /**
     * @param TipologiaGraduatoria the TipologiaGraduatoria to set
     */
    public void setTipologiaGraduatoria(String TipologiaGraduatoria) {
        this.TipologiaGraduatoria = TipologiaGraduatoria;
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
