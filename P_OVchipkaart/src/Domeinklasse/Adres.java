package Domeinklasse;

public class Adres {
    private int adresId;
    private String postcode;
    private String huisnummer;
    private String straat;
    private String woonplaats;
    private int reizigerId;




    public Adres (int adrid, String pstcd, String huisnr, String strt, String woonplts, int rzid){
        adresId = adrid;
        postcode = pstcd;
        huisnummer = huisnr;
        straat = strt;
        woonplaats = woonplts;
        reizigerId = rzid;

    }

    public int getadresId() {
        return adresId;
    }

    public void setadresId(int id) {
        this.adresId = adresId;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public int getReizigerId() {
        return reizigerId;
    }

    public void setReizigerId(int reizigerId) {
        this.reizigerId = reizigerId;
    }

    public String toString(){

        String s = "Adresid: " + adresId + ", Postcode: " + postcode + ", Huisnummer: " + huisnummer +
                ", Straat: " + straat + ", Woonplaats: " + woonplaats + ", ReizigerId: " + reizigerId;
        return s;
    }
}
