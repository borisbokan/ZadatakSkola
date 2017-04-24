package zadatak;

import com.j256.ormlite.table.TableUtils;
import model.Razred;
import model.Skola;

import java.sql.SQLException;

/**
 * Created by borcha on 24.04.17..
 */
public class KreiramTabele {


       private static myDB db=null;


        public static void main(String[] args){
            KreiramTabele();
        }


        public static void KreiramTabele(){
            db = new myDB();

            try {

                //Brisem tabele
                Poruka.linija40();
                Poruka.text("Brisem sve tabele");

                TableUtils.dropTable(db.getKonekcija(), Skola.class,true);
                TableUtils.dropTable(db.getKonekcija(), Razred.class,true);
                Poruka.linija40();
                Poruka.noviRed();

                //Kreiram tabele
                Poruka.linija40();
                Poruka.text("Kreiram tabele");

                TableUtils.createTable(db.getKonekcija(), Razred.class);
                TableUtils.createTable(db.getKonekcija(), Skola.class);
                Poruka.linija40();
                Poruka.noviRed();



            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                db.zatvoriKonekciju();
            }


        }




}
