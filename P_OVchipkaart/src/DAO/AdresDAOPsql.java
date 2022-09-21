package DAO;

import Domeinklasse.Adres;
import Domeinklasse.Reiziger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdresDAOPsql implements AdresDAO {
    private static Connection conn;


    public AdresDAOPsql(Connection conn) {
        this.conn = conn;


    }


    @Override
    public boolean save(Adres adres) {
        try {
            String sql = "INSERT INTO adres (adres_id,postcode,huisnummer,straat,woonplaats,reiziger_id) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, adres.getadresId());
            pst.setString(2, adres.getPostcode());
            pst.setString(3, adres.getHuisnummer());
            pst.setString(4, adres.getStraat());
            pst.setString(5, adres.getWoonplaats());
            pst.setInt(6, adres.getReizigerId());
            int row = pst.executeUpdate();


            if (row > 0 ) {
                System.out.println("(adres is toegevoegd)");
            }
            pst.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }

    @Override
    public boolean update(Adres adres) {
        try {
            String sql = "UPDATE adres SET postcode = ?, huisnummer = ?, straat = ?, woonplaats = ?, reiziger_id = ? WHERE adres_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, adres.getPostcode());
            pst.setString(2, adres.getHuisnummer());
            pst.setString(3, adres.getStraat());
            pst.setString(4, adres.getWoonplaats());
            pst.setInt(5, adres.getReizigerId());
            pst.setInt(6, adres.getadresId());
            int row = pst.executeUpdate();
            if (row > 0 ) {
                System.out.println(adres);
            }
            pst.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Adres adres) {
        try {
            String sql = "DELETE FROM adres WHERE adres_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, adres.getadresId());
            int row = pst.executeUpdate();
            if (row > 0 ) {
                System.out.println("(De reiziger is verwijdert)");

            }
            pst.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Adres findByReiziger(Reiziger reiziger) {
        try {
            String sql = "SELECT * FROM adres WHERE reiziger_id = ?";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, reiziger.getId());
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                int adrid = rs.getInt("adres_id");
                String postcd = rs.getString("postcode");
                String hsnummer = rs.getString("huisnummer");
                String strt = rs.getString("straat");
                String wnplaats = rs.getString("woonplaats");
                int reizid = rs.getInt("reiziger_id");

                System.out.println("Adres gegevens van reiziger met het volgend id: "+ reizid +  "\n"
                        + "Adresid:" + " " + adrid +  ",Postcode: "+ postcd +  ", Huisnummer:" + " " + hsnummer  + ", Straat:" + " " + strt
                        + ", Woonplaats:" + " " + wnplaats);

            }
            pst.close();


        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }
        return null;
    }

    @Override
    public List<Adres> findAll() {
        try {
            String sql = "SELECT * FROM adres";

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            List<Adres> adressen = new ArrayList<>();


            while (rs.next()) {
                int adrid = rs.getInt("adres_id");
                String postcd = rs.getString("postcode");
                String hsnummer = rs.getString("huisnummer");
                String strt = rs.getString("straat");
                String wnplaats = rs.getString("woonplaats");
                int reizid = rs.getInt("reiziger_id");
                Adres adres = new Adres(adrid, postcd, hsnummer, strt, wnplaats, reizid);
                adressen.add(adres);
            }
            pst.close();
            return adressen;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
