package zadatak;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import model.Razred;
import model.Skola;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by borcha on 24.04.17..
 */
public class PrikaziPodataka {



    private static myDB db = null;
    private static Dao<Skola,Integer> DAOSkola=null;
    private static Dao<Razred,Integer> DAORazred=null;

    public static void main(String[] args){

         db=new myDB();
        try {
            DAORazred= DaoManager.createDao(db.getKonekcija(),Razred.class);




            List<Razred> razredi=DAORazred.queryForAll();

            for (Razred ra : razredi ) {
                Poruka.text(ra.toString() + " == > " + ra.getSkola().toString());
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }





    }
}
