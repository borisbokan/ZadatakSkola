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
        private int id;
        @DatabaseField(columnName = POLJE_OZNAKA)
        private String oznaka;
        @DatabaseField(columnName = POLJE_BROJ_UCENIKA)
        private int brojUcenika;

        @DatabaseField(foreign = true,foreignAutoRefresh = true,canBeNull = true)
        private Skola skola;


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

        public Skola getSkola() {
            return skola;
        }

        public void setSkola(Skola skola_fk) {
            this.skola = skola_fk;
        }
}
