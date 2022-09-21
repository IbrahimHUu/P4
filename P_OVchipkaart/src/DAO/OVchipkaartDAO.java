package DAO;

import Domeinklasse.OVchipkaart;
import Domeinklasse.Reiziger;

import java.sql.SQLException;
import java.util.List;

public interface OVchipkaartDAO {

    List<OVchipkaart> findByReiziger (Reiziger reiziger);
    boolean save(OVchipkaart ovchipkaart);
    boolean update (OVchipkaart ovchipkaart);
    boolean delete (OVchipkaart ovchipkaart);
    List<OVchipkaart> findAll();
}
