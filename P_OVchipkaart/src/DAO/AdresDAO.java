package DAO;

import Domeinklasse.Adres;
import Domeinklasse.Reiziger;

import java.util.List;

public interface AdresDAO {
    boolean save (Adres adres);
    boolean update (Adres adres);
    boolean delete (Adres adres);
    Adres findByReiziger (Reiziger reiziger);
    List<Adres> findAll ();


}
