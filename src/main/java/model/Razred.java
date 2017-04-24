package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by borcha on 24.04.17..
 */
@DatabaseTable(tableName = "razred")
public class Razred {

        public static  final String POLJE_ID="id";
        public static final String POLJE_OZNAKA="oznaka";
        public static final String POLJE_BROJ_UCENIKA="broj_ucenika";

        @DatabaseField(generatedId = true)
        int id;
        @DatabaseField(columnName = POLJE_OZNAKA)
        String oznaka;
        @DatabaseField(columnName = POLJE_BROJ_UCENIKA)
        int brojUcenika;

        @DatabaseField(foreign = true,foreignAutoRefresh = true,canBeNull = false)
        Skola skola_fk;


        public Razred(){
            //Prazan za potrebe ORM-a
        }


        public Razred(String _oznakaRazreda,int _brojUcenika){
                this.oznaka=_oznakaRazreda;
                this.brojUcenika=_brojUcenika;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOznaka() {
            return oznaka;
        }

        public void setOznaka(String oznaka) {
            this.oznaka = oznaka;
        }

        public int getBrojUcenika() {
            return brojUcenika;
        }

        public void setBrojUcenika(int brojUcenika) {
            this.brojUcenika = brojUcenika;
        }

        public Skola getSkola_fk() {
            return skola_fk;
        }

        public void setSkola_fk(Skola skola_fk) {
            this.skola_fk = skola_fk;
        }
}
