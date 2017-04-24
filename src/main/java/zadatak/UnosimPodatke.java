package zadatak;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import jdk.nashorn.internal.runtime.ListAdapter;
import model.Razred;
import model.Skola;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by borcha on 24.04.17..
 */
public class UnosimPodatke {


    private static Dao<Skola,Integer> DAOSkola=null;
    private static Dao<Razred,Integer> DAORazred=null;
     private static myDB db = null;
     
    public static void main(String[] args){

        try {

            db=new myDB();
            DAOSkola= DaoManager.createDao(db.getKonekcija(),Skola.class);
            DAORazred=DaoManager.createDao(db.getKonekcija(),Razred.class);


            Poruka.text("Unosim skole");
            Poruka.linija40();
            Skola skola1=new Skola("Os Djura Jaksic");
            DAOSkola.create(skola1);

            Skola skola2=new Skola("OS Dositej Obradovic");
            DAOSkola.create(skola2);
            Poruka.text("Skole unesene...");
            Poruka.nrlinr();


            //Prikaz unesenih skola
            Poruka.linija40();
            Poruka.text("Skole unesene");
           
            Poruka.linija40();
            Poruka.nrlinr();

            List<Skola> skole=DAOSkola.queryForAll();
            Poruka.text("Spisak svih skola nakon unosa");

            for (Skola sk : skole ) {
                Poruka.text(sk.toString());
            }



            Poruka.noviRed();
            Poruka.text("Unos razreda...");
            Poruka.linija40();
            //Unos odeljenja tj Razreda
            Razred ra51=new Razred("5-1",21);
            ra51.setSkola(skola1);
            DAORazred.create(ra51);

            Razred ra52=new Razred("5-2",26);
            ra52.setSkola(skola1);
            DAORazred.create(ra52);

            Razred ra61=new Razred("6-1",17);
            ra61.setSkola(skola1);
            DAORazred.create(ra61);


            Razred ra62=new Razred("6-2",24);
            ra62.setSkola(skola1);
            DAORazred.create(ra62);

            Razred ra5A=new Razred("5-A",23);
            ra5A.setSkola(skola2);
            DAORazred.create(ra5A);

            Razred ra7c=new Razred("7-C",19);
            ra7c.setSkola(skola2);
            DAORazred.create(ra7c);

            Poruka.nrlinr();


            List<Razred> razerdi=DAORazred.queryForAll();
            Poruka.linija40();
            Poruka.text("Prikaz unesenih odeljenja");
            Poruka.linija40();
            for (Razred ra : razerdi ) {
                         Poruka.text(ra.toString());
            }
            Poruka.nrlinr();





        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
