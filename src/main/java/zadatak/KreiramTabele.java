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
                TableUtils.dropTable(db.getKonekcija(), Skola.class,true);
                TableUtils.dropTable(db.getKonekcija(), Razred.class,true);

                //Kreiram tabele
                TableUtils.createTable(db.getKonekcija(), Razred.class);
                TableUtils.createTable(db.getKonekcija(), Skola.class);




            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                db.zatvoriKonekciju();
            }


        }




}
