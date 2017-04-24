package model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by borcha on 24.04.17..
 */
@DatabaseTable(tableName = "razred")
public class Skola {


    //public static final String POLJE_ID="id";
    public static final String POLJE_NAZIV="naziv";

    @DatabaseField(generatedId = true)
    int id;
    @DatabaseField(columnName = POLJE_NAZIV)
    String naziv;

    @ForeignCollectionField(foreignFieldName = "skola_fk")
    ForeignCollection<Skola> razredi;


    public Skola(){
        //Konstruktor koji je neophodan za ORM
    }

    public Skola(String _nazivSkole){
         this.naziv=_nazivSkole;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }


    public ForeignCollection<Skola> getRazredi() {
        return razredi;
    }

    public void setRazredi(ForeignCollection<Skola> razredi) {
        this.razredi = razredi;
    }
}
