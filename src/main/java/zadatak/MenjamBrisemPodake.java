package zadatak;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import model.Razred;
import model.Skola;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by borcha on 24.04.17..
 */
public class MenjamBrisemPodake {


        private static myDB db = null;

        private static Dao<Razred,Integer> DAORazred=null;
        private static Dao<Skola,Integer> DAOSkola=null;

        public static void main(String[] args){
                     db=new myDB();
            try {
                DAORazred= DaoManager.createDao(db.getKonekcija(),Razred.class);
                DAOSkola= DaoManager.createDao(db.getKonekcija(),Skola.class);

                //Izlistati sve razrede OS Djura  Jaksic


                QueryBuilder<Razred,Integer> upitRazred=DAORazred.queryBuilder();
                QueryBuilder<Skola,Integer> upitSkola=DAOSkola.queryBuilder();
                upitSkola.where().eq(Skola.POLJE_NAZIV,"Os Djura Jaksic");

                upitRazred.leftJoin(upitSkola);

                List<Razred> skoleOSDJJA = upitRazred.query();

                for (Razred ra : skoleOSDJJA) {
                         Poruka.text(ra.toString() + " " + ra.getSkola().toString());
                }


                //Menjam sve skole OS Djura Jaksic u OS Svetozar Markovic
                Poruka.noviRed();
                Poruka.text("Menjam nazive skola u OS Svetozar Markovic");

                Where<Skola, Integer> zamena=DAOSkola.queryBuilder().where().eq(Skola.POLJE_NAZIV,"OS Svetozar Markovic");
                
                Skola skola=zamena.queryForFirst();
                skola.setNaziv("OS Svetozar Markovic");
                DAOSkola.update(skola);
                
                List<Razred> skoleZamena = upitRazred.query();



                for (Razred ra : skoleZamena) {
                    Poruka.text(ra.toString() + " " + ra.getSkola().toString());
                }
                Poruka.linija40();
                Poruka.nrlinr();


                List<Razred> skoleNakonIzmene = DAORazred.queryForAll();
                Poruka.text("Nakon izmene skole");
                Poruka.linija40();
                for (Razred ra : skoleNakonIzmene) {
                    Poruka.text(ra.toString() + " " + ra.getSkola().toString());
                }


                //Brisem razred gde ima 17 ucenika
                QueryBuilder<Razred,Integer> upit=DAORazred.queryBuilder();
                Where where=upit.where().eq(Razred.POLJE_BROJ_UCENIKA,17);
                Razred razred=(Razred)where.queryForFirst();
                DAORazred.delete(razred);


                //Prika nakon izmena
                List<Razred> nakonBrisRaz = DAORazred.queryForAll();
                Poruka.text("Nakon brisanja razreda sa 17 ucenika");
                Poruka.linija40();
                for (Razred ra : nakonBrisRaz) {
                    Poruka.text(ra.toString() + " " + ra.getSkola().toString());
                }
                Poruka.nrlinr();


            } catch (SQLException e) {
                e.printStackTrace();
            }


        }


}
