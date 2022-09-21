package DAO;

import Domeinklasse.OVchipkaart;
import Domeinklasse.Reiziger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OVchipkaartDAOPsql implements OVchipkaartDAO {
    private static Connection conn;


    public OVchipkaartDAOPsql(Connection conn) {
        this.conn = conn;


    }



    @Override
    public List<OVchipkaart> findByReiziger(Reiziger reiziger) {
        try {
            String sql = "SELECT * FROM ov_chipkaart WHERE reiziger_id = ?";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, reiziger.getId());
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                int kaartNummer = rs.getInt("kaart_nummer");
                Date geldigTot = rs.getDate("geldig_tot");
                int Klasse = rs.getInt("klasse");
                Double Saldo = rs.getDouble("saldo");
                int reizigerId = rs.getInt("reiziger_id");

                System.out.println("\n" + "OVChipkaart: " + "Kaartnummer:"+ kaartNummer + ", Geldig tot:" + " " + geldigTot + ", Klasse:" + " " + Klasse  + ", Saldo:" + " " + Saldo
                        + ", reiziger_id:" + " " + reizigerId);

            }
            pst.close();


        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }
        return null;
    }

    @Override
    public boolean save(OVchipkaart ovchipkaart) {
        try {
            String sql = "INSERT INTO ov_chipkaart (kaart_nummer,geldig_tot,klasse,saldo,reiziger_id) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, ovchipkaart.getKaartNummer());
            pst.setDate(2, ovchipkaart.getGeldigTot());
            pst.setInt(3, ovchipkaart.getKlasse());
            pst.setDouble(4, ovchipkaart.getSaldo());
            pst.setInt(5, ovchipkaart.getReizigerId());
            int row = pst.executeUpdate();

            if (row > 0 ) {
                System.out.println("(OV is toegevoegd)");
            }

            pst.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("(OV is al toegevoegd)");
            return false;

        }

    }

    @Override
    public boolean update(OVchipkaart ovchipkaart) {
        try {
            String sql = "UPDATE ov_chipkaart SET kaart_nummer = ?, geldig_tot = ?, klasse = ?, saldo = ? WHERE reiziger_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, ovchipkaart.getKaartNummer());
            pst.setDate(2, ovchipkaart.getGeldigTot());
            pst.setInt(3, ovchipkaart.getKlasse());
            pst.setDouble(4, ovchipkaart.getSaldo());
            pst.setInt(5, ovchipkaart.getReizigerId());
            int row = pst.executeUpdate();
            if (row > 0 ) {
                System.out.println(ovchipkaart);
                System.out.println("(reziger is geupdate)");
            }
            pst.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean delete(OVchipkaart ovchipkaart) {
        try {
            String sql = "DELETE FROM ov_chipkaart WHERE reiziger_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, ovchipkaart.getReizigerId());
            int row = pst.executeUpdate();
            if (row > 0 ) {
                System.out.println("(OV is verwijdert)");

            }
            pst.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<OVchipkaart> findAll() {
        try {
            String sql = "SELECT * FROM ov_chipkaart";

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            List<OVchipkaart> ovchipkaarten = new ArrayList<OVchipkaart>();


            while (rs.next()) {
                int kaartNummer = rs.getInt("kaart_nummer");
                Date geldigTot = rs.getDate("geldig_tot");
                int Klasse = rs.getInt("klasse");
                Double Saldo = rs.getDouble("saldo");
                int reizigerId = rs.getInt("reiziger_id");
                OVchipkaart ovchipkaart = new OVchipkaart(kaartNummer, geldigTot, Klasse, Saldo, reizigerId);
                ovchipkaarten.add(ovchipkaart);
            }
            pst.close();
            return ovchipkaarten;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
