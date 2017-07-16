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

    public String CLASS_NAME = Client.class.getName();

    public static String path = "/Users/riccardodelgratta/Desktop/grad/";
    public static String IG = "IGRADO";
    public static String IIG = "IIGRADO";

    private String classiDiConcorso;
    private String nomeDaRicercare;
    private Map<String, List> mapClassiScuole = new HashMap();
    private Candidato candidato;
    private List<Candidato> candidati;

    public static void main(String[] args) {
        Client c = new Client();
        c.leggiEriempiGraduatorie(path, IG);
    }

    public void init() {

    }

    private void leggiEriempiGraduatorie(String path, String cartella) {
        //Get file from resources folder

        File folder = new File(path + cartella);
        String nomeFile;
        String message;
        System.err.println(path + cartella);
        String routine = "leggiEriempiGraduatorie";
        File[] listOfFiles = folder.listFiles();
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                nomeFile = listOfFile.getName();
                message = String.format("Leggo file -%s- in routinen -%s-", nomeFile, routine);
                Logger.getLogger(CLASS_NAME).log(Level.INFO, message);
                try {
                    riempiGraduatoriaDaFile(path + cartella + "/" + nomeFile); //is = readXLSFile(path + cartella + "/" + listOfFiles[i].getName(), classe);
                    //                    if (is) {
                    //                        ret.add(cartella + "/" + listOfFiles[i].getName());
                    //                    }

                } catch (Exception e) {
                    System.err.println("ERROR in File " + nomeFile + " messaggio " + e.getMessage());
                }
            }
        }
    }

    public void riempiGraduatoriaDaFile(String file) throws IOException {
        InputStream ExcelFileToRead = new FileInputStream(file);
        HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);

        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row;
        HSSFCell cell;
        List<String> classi = new ArrayList<>();
        List<String> ret = new ArrayList<>();

        Iterator rows = sheet.rowIterator();
        int r = 0, c = 0;
        while (rows.hasNext()) {
            row = (HSSFRow) rows.next();
            c = 0;
            
            for (Iterator cells = row.cellIterator(); cells.hasNext();) {
                cell = (HSSFCell) cells.next();
                if (r > 1) {
                    
                    String value = cell.getStringCellValue();
                }
                c++;
            }
            r++;

        }
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
