package P1;

import java.sql.*;

public class MainP1 {

    //    Opdracht P1
    public static void main (String [] args){

        String url = "jdbc:postgresql://localhost/ovchip?user=postgres&password=Ibrahim123";

        try {
            Connection conn = DriverManager.getConnection(url);

            Statement st = conn.createStatement();
            String query = "SELECT * FROM reiziger";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                int id = rs.getInt("reiziger_id");
                String voorlttrs= rs.getString("voorletters");
                String tussenvgsl = rs.getString("tussenvoegsel");
                String achternm = rs.getString("achternaam");
                String gbdatum = rs.getString("geboortedatum");

                System.out.println("Id:" + " " + id + " " + "Voorletters:" + " " + voorlttrs + " " + "Tussenvoegsels:" + " " + tussenvgsl + " " + "Achternaam:" + " " + achternm +
                      " " + "Geboortedatum:" + " " + gbdatum );

            }
           conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}


