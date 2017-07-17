/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.ilc.gestoregraduatorie;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author riccardodelgratta
 */
public class Client {

    /**
     * @return the mapFileGraduatoria
     */
    public Map<String, List<Graduatoria>> getMapFileGraduatoria() {
        return mapFileGraduatoria;
    }

    /**
     * @param mapFileGraduatoria the mapFileGraduatoria to set
     */
    public void setMapFileGraduatoria(Map<String, List<Graduatoria>> mapFileGraduatoria) {
        this.mapFileGraduatoria = mapFileGraduatoria;
    }

    public String CLASS_NAME = Client.class.getName();

    public static String path = "/Users/riccardodelgratta/Desktop/grad/";
    public static String IG = "IGRADO";
    public static String IIG = "IIGRADO";

    private String classiDiConcorso;
    private String nomeDaRicercare;
    private Map<String, List> mapClassiScuole = new HashMap();
    private Map<String, List<Graduatoria>> mapFileGraduatoria = new HashMap();
    private Candidato candidato;
    private List<Candidato> candidati;

    public static void main(String[] args) {
        Client c = new Client();
        c.checkArgs(args);
        c.leggiFileEriempiGraduatorie(path, IIG);
//        System.err.println("************* START *************");
//        for (Map.Entry entry : c.getMapFileGraduatoria().entrySet()) {
//            List<Graduatoria> g = (List) entry.getValue();
//            for (Graduatoria g : g) {
//                //System.out.println("File " + entry.getKey() + "\tGrad classeDacercare di conc -" + g.getCodClasseDiConcorso()+"-");
//                if (g.getCodClasseDiConcorso()!=null && g.getCodClasseDiConcorso().equals("A036")) {
//                    System.out.println("File " + entry.getKey() + "\tGrad classeDacercare di conc " + g.getCodClasseDiConcorso());
//                    System.out.println("Cognome -" + g.getCognome() + "-\tNome -" + g.getNome()+"-");
////                    
//                }
//            }
//        }
//        System.err.println("************* END *************");
        c.mapClassiScuole = c.getGraduatorieDaClassiDiConcorso(c.getMapFileGraduatoria(), c.getClassiDiConcorso());
        c.stampaMappaClassiScuole(c.mapClassiScuole);

    }

    public void stampaMappaClassiScuole(Map<String, List> map) {
        for (Map.Entry entry : map.entrySet()) {
            System.err.println("\nClasse " + entry.getKey() + " ha scuole:");
            List<String> l = (List) entry.getValue();
            for (String s : l) {
                System.out.println("\tScuola " + s);
            }

        }

    }

    /**
     * Crea una lista di scuole dove le classi di concorso sono attivate
     *
     * @param grads
     * @param classi
     */
    public Map<String, List> getGraduatorieDaClassiDiConcorso(Map<String, List<Graduatoria>> grads, String classi) {

        String message;

        String routine = "getGraduatorieDaClassiDiConcorso";

        Map<String, List> tempMapClassiScuole = new HashMap();

        List<String> files = new ArrayList<>();
        //System.err.println("************* START *************");
        for (String classeDacercare : classi.split(",")) {
            message = String.format("Cerco la classe -%s- in routine -%s-", classeDacercare, routine);
            Logger.getLogger(CLASS_NAME).log(Level.INFO, message);

            for (Map.Entry entry : grads.entrySet()) {
                List<Graduatoria> gs = (List) entry.getValue();
                for (Graduatoria g : gs) {
                    String classeDiConcorso = g.getCodClasseDiConcorso();
                    //if (listaDiClassi.contains(classeDiConcorso))
                    //System.out.println("File " + entry.getKey() + "\tGrad classeDacercare di conc -" + g.getCodClasseDiConcorso()+"-");
                    if (classeDiConcorso != null && classeDiConcorso.equals(classeDacercare)) {
//                        System.out.println("File " + entry.getKey() + "\tGrad classe di conc " + g.getCodClasseDiConcorso());
//                        System.out.println("Cognome -" + g.getCognome() + "-\tNome -" + g.getNome() + "-");
                        String mioFile = g.getFileOrigine().replaceAll(path, "")
                                .replaceAll(IIG, "")
                                .replaceAll(IG, "")
                                .replaceAll("/", "");
                        if (!files.contains(mioFile)) {
                            files.add(mioFile);
                            //System.out.println("TROVATO File " + g.getFileOrigine() + "\tGrad classe di conc " + classeDiConcorso + " " + files);
                        }
//                    
                    }
                }
            }
            tempMapClassiScuole.put(classeDacercare, files);

            files = new ArrayList<>();
        }
        //System.err.println("************* END *************");

        return tempMapClassiScuole;
    }

    public void init() {

    }

    public void leggiFileEriempiGraduatorie(String path, String cartella) {
        //Get file from resources folder
        String message;

        String routine = "leggiFileEriempiGraduatorie";

        File folder = new File(path + cartella);
        String nomeFile;

        Map<String, List<Graduatoria>> tempMap = new HashMap<>();

        File[] listOfFiles = folder.listFiles();
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                nomeFile = listOfFile.getName();
                message = String.format("Leggo file -%s- in routine -%s-", nomeFile, routine);
                Logger.getLogger(CLASS_NAME).log(Level.INFO, message);
                try {
                    tempMap = riempiGraduatoriaDaFile(path + cartella + "/" + nomeFile);

                } catch (Exception e) {
                    message = String.format("Errore nel leggere -%s- in routine -%s-. Messaggio -%s-", nomeFile, routine, e.getMessage());
                    Logger.getLogger(CLASS_NAME).log(Level.SEVERE, message);

                }
            }
            getMapFileGraduatoria().putAll(tempMap);

        }
    }

    private Map<String, List<Graduatoria>> riempiGraduatoriaDaFile(String file) throws IOException {

        InputStream ExcelFileToRead = new FileInputStream(file);
        HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row;
        HSSFCell cell;

        List<String> classi = new ArrayList<>();
        List<String> ret = new ArrayList<>();
        List<Graduatoria> tempGradList = new ArrayList<>();
        Graduatoria grad;
        Map<String, List<Graduatoria>> tempMapFileGraduatoria = new HashMap();

        /* mappatura campi graduatoria numero di cella
         */
        String CodClasseDiConcorso; //0
        String DescrClasseDiConcorso; //1
        String TipoPosto; //2
        String CodTipoPosto; //3
        String InclRis; //4
        int Posto; //5
        String Cognome; //6
        String Nome; //7
        String DataNascita; //8
        String ProvNascita; //9
        double Punteggio; //10
        String Prefer1; //11
        String Prefer2; //12
        String Prefer3; //13
        String Prefer4; //14
        String AnnoIns; //15
        String GradPreferAnnoPrec; //16
        String CodTitoloSpec1; //17
        String ConsegTitoloSpec1; //18
        String CodTitoloSpec2; //19
        String ConsegTitoloSpec2; //20
        String CodTitoloSpec3; //21
        String ConsegTitoloSpec3; //22
        String CodTitoloSpec4; //23
        String ConsegTitoloSpec4; //24
        int NumFigli; //25
        String ServSenzaDemerito; //26
        String ScuolaAcquisDomanda; //27
        String CodiceFiscale; //28
        String ComNascita; //29
        String Sesso; //30
        String CodComune; //31
        String ComResidenza; //32
        String CAP; //33
        String Via; //34
        String Tel; //35
        String Cell; //36
        String ProvPresentDomanda; //37
        int PostoProvinciale; //38
        String FasciaGradProv; //39
        String ModalitaAccesso; //40
        String IndirizzoEMail; //41
        String Supplenza10gg; //42
        String TipologiaGraduatoria; //43

        Iterator rows = sheet.rowIterator();
        int r = 0, c = 0;
        while (rows.hasNext()) {
            row = (HSSFRow) rows.next();
            c = 0;
            grad = new Graduatoria();
            for (Iterator cells = row.cellIterator(); cells.hasNext();) {
                cell = (HSSFCell) cells.next();
                if (r > 1) {

                    grad.setFileOrigine(file);
//                    String valueStr;
//                    int valueInt;
//                    double valueDbl;
                    if (c == 0) { //CodClasseDiConcorso
                        CodClasseDiConcorso = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " classeDacercare "+ CodClasseDiConcorso);
                        grad.setCodClasseDiConcorso(CodClasseDiConcorso);
                    }

                    if (c == 1) { //DescrClasseDiConcorso
                        DescrClasseDiConcorso = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " classeDacercare "+ DescrClasseDiConcorso);
                        grad.setDescrClasseDiConcorso(DescrClasseDiConcorso);
                    }
//                    
                    if (c == 2) { //TipoPosto
                        TipoPosto = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " classeDacercare "+ TipoPosto);
                        grad.setTipoPosto(TipoPosto);
                    }

                    if (c == 3) { //CodTipoPosto
                        CodTipoPosto = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " classeDacercare "+ CodTipoPosto);
                        grad.setCodTipoPosto(CodTipoPosto);
                    }
//                    
                    if (c == 4) { //InclRis
                        InclRis = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " classeDacercare "+ InclRis);
                        grad.setInclRis(InclRis);
                    }

                    if (c == 5) { //Post -> INT
                        String temp = cell.getStringCellValue().trim();
                        if (temp.isEmpty()) {
                            Posto = 0;
                        } else {
                            Posto = Integer.parseInt(temp);
                        }

                        //System.err.println("FILE " + file+ " Posto "+ Posto);
                        grad.setPosto(Posto);
                    }

                    if (c == 6) { //Cognome
                        Cognome = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " classeDacercare "+ Cognome);
                        grad.setCognome(Cognome);
                    }
//                    
                    if (c == 7) { //Nome
                        Nome = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " classeDacercare "+ Nome);
                        grad.setNome(Nome);
                    }
//                    
                    if (c == 8) { //DataNascita
                        DataNascita = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " DataNascita "+ DataNascita);
                        grad.setDataNascita(DataNascita);
                    }

                    if (c == 9) { //ProvNascita
                        ProvNascita = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " ProvNascita "+ ProvNascita);
                        grad.setProvNascita(ProvNascita);
                    }
//                    
                    if (c == 10) { //Punteggio -> DOUBLE
                        String temp = cell.getStringCellValue().trim();
                        if (temp.isEmpty()) {
                            Punteggio = 0.0;
                        } else {
                            temp = temp.replace(",", ".");
                            Punteggio = Double.parseDouble(temp);
                        }

                        //System.err.println("FILE " + file+ " Punteggio "+ Punteggio);
                        grad.setPunteggio(Punteggio);
                    }
                    if (c == 11) { //Prefer1
                        Prefer1 = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " Prefer1 "+ Prefer1);
                        grad.setPrefer1(Prefer1);
                    }
//                    
                    if (c == 12) { //Prefer2
                        Prefer2 = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " Prefer2 "+ Prefer2);
                        grad.setPrefer2(Prefer2);
                    }
//                    
                    if (c == 13) { //Prefer3
                        Prefer3 = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " Prefer3 "+ Prefer3);
                        grad.setPrefer3(Prefer3);
                    }
//                    
                    if (c == 14) { //Prefer4
                        Prefer4 = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " Prefer4 "+ Prefer4);
                        grad.setPrefer4(Prefer4);
                    }
//                    
                    if (c == 15) { //AnnoIns
                        AnnoIns = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " AnnoIns "+ AnnoIns);
                        grad.setAnnoIns(AnnoIns);
                    }
//                    
                    if (c == 16) { //GradPreferAnnoPrec
                        GradPreferAnnoPrec = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " GradPreferAnnoPrec "+ GradPreferAnnoPrec);
                        grad.setGradPreferAnnoPrec(GradPreferAnnoPrec);
                    }
//                    
                    if (c == 17) { //CodTitoloSpec1
                        CodTitoloSpec1 = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " CodTitoloSpec1 "+ CodTitoloSpec1);
                        grad.setCodTitoloSpec1(CodTitoloSpec1);
                    }
//                    
                    if (c == 18) { //ConsegTitoloSpec1
                        ConsegTitoloSpec1 = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " ConsegTitoloSpec1 "+ ConsegTitoloSpec1);
                        grad.setConsegTitoloSpec1(ConsegTitoloSpec1);
                    }
//                    
                    if (c == 19) { //CodTitoloSpec2
                        CodTitoloSpec2 = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " CodTitoloSpec2 "+ CodTitoloSpec2);
                        grad.setCodTitoloSpec2(CodTitoloSpec2);
                    }

                    if (c == 20) { //ConsegTitoloSpec2
                        ConsegTitoloSpec2 = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " ConsegTitoloSpec2 "+ ConsegTitoloSpec2);
                        grad.setConsegTitoloSpec2(ConsegTitoloSpec2);
                    }
//                    
                    if (c == 21) { //CodTitoloSpec3
                        CodTitoloSpec3 = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " CodTitoloSpec3 "+ CodTitoloSpec3);
                        grad.setCodTitoloSpec3(CodTitoloSpec3);
                    }

                    if (c == 22) { //ConsegTitoloSpec3
                        ConsegTitoloSpec3 = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " ConsegTitoloSpec3 "+ ConsegTitoloSpec3);
                        grad.setConsegTitoloSpec3(ConsegTitoloSpec3);
                    }
//                    
                    if (c == 23) { //CodTitoloSpec4
                        CodTitoloSpec4 = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " CodTitoloSpec4 "+ CodTitoloSpec4);
                        grad.setCodTitoloSpec4(CodTitoloSpec4);
                    }
//                    
                    if (c == 24) { //ConsegTitoloSpec2
                        ConsegTitoloSpec4 = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " ConsegTitoloSpec4 "+ ConsegTitoloSpec4);
                        grad.setConsegTitoloSpec4(ConsegTitoloSpec4);
                    }
                    if (c == 25) { //NumFigli -> INT
                        String temp = cell.getStringCellValue().trim();
                        if (temp.isEmpty()) {
                            NumFigli = 0;
                        } else {
                            NumFigli = Integer.parseInt(temp);
                        }
                        //System.err.println("FILE " + file+ " NumFigli "+ NumFigli);
                        grad.setNumFigli(NumFigli);
                    }
                    if (c == 26) { //ServSenzaDemerito
                        ServSenzaDemerito = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " ServSenzaDemerito "+ ServSenzaDemerito);
                        grad.setServSenzaDemerito(ServSenzaDemerito);
                    }
                    if (c == 27) { //ScuolaAcquisDomanda
                        ScuolaAcquisDomanda = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " ScuolaAcquisDomanda "+ ScuolaAcquisDomanda);
                        grad.setScuolaAcquisDomanda(ScuolaAcquisDomanda);
                    }

                    if (c == 28) { //CodiceFiscale
                        CodiceFiscale = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " CodiceFiscale "+ CodiceFiscale);
                        grad.setCodiceFiscale(CodiceFiscale);
                    }

                    if (c == 29) { //ComNascita
                        ComNascita = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " classeDacercare "+ Nome);
                        grad.setComNascita(ComNascita);
                    }

                    if (c == 30) { //Sesso
                        Sesso = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " Sesso "+ Sesso);
                        grad.setSesso(Sesso);
                    }

                    if (c == 31) { //CodComune
                        CodComune = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " CodComune "+ CodComune);
                        grad.setCodComune(CodComune);
                    }

                    if (c == 32) { //ComResidenza
                        ComResidenza = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " ComResidenza "+ ComResidenza);
                        grad.setComResidenza(ComResidenza);
                    }
                    if (c == 33) { //CAP
                        CAP = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " CAP "+ CAP);
                        grad.setCAP(CAP);
                    }
                    if (c == 34) { //Via
                        Via = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " Via "+ Via);
                        grad.setVia(Via);
                    }
                    if (c == 35) { //Tel
                        Tel = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " Tel "+ Tel);
                        grad.setTel(Tel);
                    }
                    if (c == 36) { //Cell
                        Cell = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " Cell "+ Cell);
                        grad.setCell(Cell);
                    }
                    if (c == 37) { //ProvPresentDomanda
                        ProvPresentDomanda = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " ProvPresentDomanda "+ ProvPresentDomanda);
                        grad.setProvPresentDomanda(ProvPresentDomanda);
                    }
                    if (c == 38) { //NumFigli -> INT
                        String temp = cell.getStringCellValue().trim();
                        if (temp.isEmpty()) {
                            PostoProvinciale = 0;
                        } else {
                            PostoProvinciale = Integer.parseInt(temp);
                        }
                        //System.err.println("FILE " + file+ " PostoProvinciale "+ PostoProvinciale);
                        grad.setPostoProvinciale(PostoProvinciale);
                    }
                    if (c == 39) { //FasciaGradProv
                        FasciaGradProv = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " FasciaGradProv "+ FasciaGradProv);
                        grad.setFasciaGradProv(FasciaGradProv);
                    }
                    if (c == 40) { //ModalitaAccesso
                        ModalitaAccesso = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " ModalitaAccesso "+ ModalitaAccesso);
                        grad.setModalitaAccesso(ModalitaAccesso);
                    }
                    if (c == 41) { //IndirizzoEMail
                        IndirizzoEMail = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " IndirizzoEMail "+ IndirizzoEMail);
                        grad.setIndirizzoEMail(IndirizzoEMail);
                    }
                    if (c == 42) { //Supplenza10gg
                        Supplenza10gg = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " Supplenza10gg "+ Supplenza10gg);
                        grad.setSupplenza10gg(Supplenza10gg);
                    }
                    if (c == 43) { //TipologiaGraduatoria
                        TipologiaGraduatoria = cell.getStringCellValue().trim();
                        //System.err.println("FILE " + file+ " TipologiaGraduatoria "+ TipologiaGraduatoria);
                        grad.setTipologiaGraduatoria(TipologiaGraduatoria);
                    }

                }
                c++;
            }
            tempGradList.add(grad);
            r++;

        }
        tempMapFileGraduatoria.put(file, tempGradList);
        return tempMapFileGraduatoria;
    }

    private void checkArgs(String[] args) {
        int i = 0;
        for (String arg : args) {
            switch (arg) {
                case "-c":
                    setClassiDiConcorso(args[i + 1]);
                    break;
                case "-n":
                    setNomeDaRicercare(args[i + 1]);
                    break;
            }
            i++;
        }
    }

    /**
     * @return the classiDiConcorso
     */
    public String getClassiDiConcorso() {
        return classiDiConcorso;
    }

    /**
     * @param classiDiConcorso the classiDiConcorso to set
     */
    public void setClassiDiConcorso(String classiDiConcorso) {
        this.classiDiConcorso = classiDiConcorso;
    }

    /**
     * @return the mapClassiScuole
     */
    public Map<String, List> getMapClassiScuole() {
        return mapClassiScuole;
    }

    /**
     * @param mapClassiScuole the mapClassiScuole to set
     */
    public void setMapClassiScuole(Map<String, List> mapClassiScuole) {
        this.mapClassiScuole = mapClassiScuole;
    }

    /**
     * @return the candidato
     */
    public Candidato getCandidato() {
        return candidato;
    }

    /**
     * @param candidato the candidato to set
     */
    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    /**
     * @return the candidati
     */
    public List<Candidato> getCandidati() {
        return candidati;
    }

    /**
     * @param candidati the candidati to set
     */
    public void setCandidati(List<Candidato> candidati) {
        this.candidati = candidati;
    }

    /**
     * @return the nomeDaRicercare
     */
    public String getNomeDaRicercare() {
        return nomeDaRicercare;
    }

    /**
     * @param nomeDaRicercare the nomeDaRicercare to set
     */
    public void setNomeDaRicercare(String nomeDaRicercare) {
        this.nomeDaRicercare = nomeDaRicercare;
    }
}
