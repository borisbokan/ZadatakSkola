package zadatak;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import model.Razred;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

/*
   * Zadatak: Nakon malog odmora koji traje 1.5 sekunde. Kabinet iz Biologije uvek  slobodan za jedan razred.  Svaki od razreda ulazi u kabinet i ima po jedan cas u istom . Svaki od razreda ima po jedan cas u istom kabinetu. Za vreme nastave u Biologiji ostali imaju pauzu ili su na drugoj nastavi u drugim kabinetima. Cas traje po 4.5 sekundi.
   * */
public class UcionicaNit extends Thread {


        private static Boolean kabinetSlobodan=true;
        private Razred razred;

        UcionicaNit(Razred _razred){
            this.razred=_razred;

        }


        private void  maliOdmor(){

            try {
                Poruka.naslov("Pocetak malog odmora>>>");
                sleep(1500);
                Poruka.text("Kraj malog odmora");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Ulazak u ucionicu i pocetak casa
        private void ulazPocetakCasa(){

              do{
                  synchronized (kabinetSlobodan){
                     Poruka.naslov("U kabinetu razred " + this.razred.getOznaka());
                     kabinetSlobodan=false;

                  }

                  try {
                      synchronized (kabinetSlobodan) {
                          Poruka.naslov("Cas je u toku...Tisinaaa....");
                      }


                      sleep(4500);
                      
                      synchronized (kabinetSlobodan) {
                          Poruka.naslov("Cas je zavrsen.");
                      }
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }


                  synchronized (kabinetSlobodan){
                       this.kabinetSlobodan=true;
                       Poruka.naslov("Kabinet je slobodan!");
                  }


              }while (!kabinetSlobodan);


        }
    

         @Override
        public void run(){

            maliOdmor();
            ulazPocetakCasa();
            maliOdmor();


        }




        //******************************************Testiranje********************************
        public static void main(String[] args){


            try {
                
                myDB db=new myDB();
                Dao<Razred,Integer> DAOrazredi = DaoManager.createDao(db.getKonekcija(),Razred.class);


                List<Razred> razredi= DAOrazredi.queryForAll();
                UcionicaNit cas;
                Poruka.naslov("Lista razreda (broj razreda: " + razredi.size()+ ")");
                for (Razred ra : razredi ) {
                   cas=new UcionicaNit(ra);
                   cas.start();
                   
                    try {
                        cas.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Poruka.linija40();


            } catch (SQLException e) {
                e.printStackTrace();
            }


            Poruka.naslov("*************KRAJ SVIH CASOVA****************");

        }




}
