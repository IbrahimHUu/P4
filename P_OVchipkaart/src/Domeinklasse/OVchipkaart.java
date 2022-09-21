package Domeinklasse;

import java.sql.Date;

public class OVchipkaart {

    private int kaartNummer;
    private Date geldigTot;
    private int klasse;
    private double saldo;
    private int reizigerId;

    private Reiziger studentenreiziger;

    public OVchipkaart(int krtnr, Date geltot, int ks, Double sd, int ri) {
        kaartNummer = krtnr;
        geldigTot = geltot;
        klasse = ks;
        saldo = sd;
        reizigerId = ri;


    }

    public int getKaartNummer() {
        return kaartNummer;
    }

    public void setKaartNummer(int kaartNummer) {
        this.kaartNummer = kaartNummer;
    }

    public java.sql.Date getGeldigTot() {
        return (java.sql.Date) geldigTot;
    }

    public void setGeldigTot(Date geldigTot) {
        this.geldigTot = geldigTot;
    }

    public int getKlasse() {
        return klasse;
    }

    public void setKlasse(int klasse) {
        this.klasse = klasse;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getReizigerId() {
        return reizigerId;
    }

    public void setReizigerId(int reizigerId) {
        this.reizigerId = reizigerId;
    }

    public Reiziger getStudentenreiziger() {
        return studentenreiziger;
    }

    public void setStudentenreiziger(Reiziger studentenreiziger) {
        this.studentenreiziger = studentenreiziger;
    }

    public String toString(){
        String s =  "Kaartnummer:"+ kaartNummer + ", Geldig tot:" + " " + geldigTot + ", Klasse:" + " " + klasse  + ", Saldo:" + " " + saldo
                + ", reiziger_id:" + " " + reizigerId;
        if(studentenreiziger == null){
            s = s + " De reiziger is onbekend";
        }
        else {
            s = s + " Rekeninghouder " + studentenreiziger;
        }

        return s;
    }

}
