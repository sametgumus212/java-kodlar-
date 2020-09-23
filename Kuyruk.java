/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuyruk;

/**
 *
 * @author chs
 */
public class Kuyruk {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}

class kuyruk{
   int arka ,on, size;
   int kapasite;
   int dizi[];
   public kuyruk(int kapasite){
       this.kapasite=kapasite;
      on=this.size=0;
      arka=kapasite-1;
      dizi=new int[this.kapasite];
   }
   boolean dolumu(kuyruk kyr){
       if(kyr.size==kyr.kapasite){
           System.out.println("kapasite dolu ");
           
       }
       return (kyr.size==kyr.kapasite);
   }
   boolean bosmu(kuyruk kyr){
       return (kyr.size==0);
   }
   void ekle(int yeni){
       if(bosmu(this)){
           this.arka=(this.arka+1)%this.kapasite;
           this.dizi[this.arka]=yeni;
           this.size=this.size+1;
           System.out.println(" kuyruğa yeni eleman eklendi ");
           }
   }
 
   
}
