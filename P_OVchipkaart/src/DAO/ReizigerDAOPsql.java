package DAO;

import Domeinklasse.Reiziger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ReizigerDAOPsql implements ReizigerDAO {
    private static Connection conn;


    public ReizigerDAOPsql(Connection conn) {
        this.conn = conn;


    }

    @Override
    public boolean save(Reiziger reiziger) {
        try {
            String sql = "INSERT INTO reiziger (reiziger_id,voorletters,tussenvoegsel,achternaam, geboortedatum) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, reiziger.getId());
            pst.setString(2, reiziger.getVoorletters());
            pst.setString(3, reiziger.getTussenvoegsel());
            pst.setString(4, reiziger.getAchternaam());
            pst.setDate(5, reiziger.getGeboortedatum());
            int row = pst.executeUpdate();


            if (row > 0 ) {
                System.out.println("(reziger is toegevoegd)");
            }
            pst.close();
            return true;

        } catch (SQLException e) {
            System.out.println("(Reiziger is al toegevoegd)");
            return false;

        }

    }


    @Override
    public boolean update(Reiziger reiziger) {
        try {
            String sql = "UPDATE reiziger SET reiziger_id = ?, tussenvoegsel = ?, achternaam = ?, geboortedatum = ? WHERE voorletters = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, reiziger.getId());
            pst.setString(2, reiziger.getTussenvoegsel());
            pst.setString(3, reiziger.getAchternaam());
            pst.setDate(4, reiziger.getGeboortedatum());
            pst.setString(5, reiziger.getVoorletters());
            int row = pst.executeUpdate();
            if (row > 0 ) {
                System.out.println(reiziger + " (reziger is geupdate)");
            }
            pst.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Reiziger reiziger) {
        try {
            String sql = "DELETE FROM reiziger WHERE voorletters = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, reiziger.getVoorletters());
            int row = pst.executeUpdate();
            if (row > 0 ) {
                System.out.println("(De reiziger is verwijdert)");

            }
            pst.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Deze reiziger is al verwijdert");
            return false;
        }

    }



    @Override
    public Reiziger findById(int id) {
        try {
            String sql = "SELECT * FROM reiziger WHERE reiziger_id = ?";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                int identiteit = rs.getInt("reiziger_id");
                String voorlttrs= rs.getString("voorletters");
                String tussenvgsl = rs.getString("tussenvoegsel");
                String achternm = rs.getString("achternaam");
                Date gbdatum = rs.getDate("geboortedatum");

                System.out.println("Gegevens van reziger met ID: " + id + "\n" + "Voorletters:" + " " + voorlttrs + ", Tussenvoegsels:" + " " + tussenvgsl  + ", Achternaam:" + " " + achternm
                        + ", Geboortedatum:" + " " + gbdatum);

            }
            pst.close();


        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }
        return null;
    }

    @Override
    public List<Reiziger> findByGbdatum(String datum) {
        try {
            String sql = "SELECT * FROM reiziger WHERE geboortedatum = ?";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setDate(1, Date.valueOf(datum));
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                int identiteit = rs.getInt("reiziger_id");
                String voorlttrs= rs.getString("voorletters");
                String tussenvgsl = rs.getString("tussenvoegsel");
                String achternm = rs.getString("achternaam");
                Date gbdatum = rs.getDate("geboortedatum");

                System.out.println("\n" + "Gegevens van reiziger met het volgende geboortedatum: " + gbdatum + "\n" + "Voorletters:" + " " + voorlttrs + ", Tussenvoegsels:" + " " + tussenvgsl  + ", Achternaam:" + " " + achternm
                        + ", Geboortedatum:" + " " + gbdatum );
            }
        pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Reiziger> findAll(){

        try {
            String sql = "SELECT * FROM reiziger";

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            List<Reiziger> reizigers = new ArrayList<Reiziger>();


            while (rs.next()) {
                int identiteit = rs.getInt("reiziger_id");
                String voorlttrs = rs.getString("voorletters");
                String tussenvgsl = rs.getString("tussenvoegsel");
                String achternm = rs.getString("achternaam");
                Date gbdatum = rs.getDate("geboortedatum");
                Reiziger reiziger = new Reiziger(identiteit, voorlttrs, tussenvgsl, achternm, gbdatum);
                reizigers.add(reiziger);
            }
            pst.close();
            return reizigers;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
