/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chs
 */
public class TS extends Thread {
    int sayac=0;
    public void run(){
        System.out.println("süre tutulmaya başlandı hasanım");
         long bas=System.currentTimeMillis();
       while(sayac < 60000){
             System.out.println("ad");
           
           try {
               Thread.sleep(10000);
           } catch (InterruptedException ex) {
               Logger.getLogger(TS.class.getName()).log(Level.SEVERE, null, ex);
           }
       System.out.println("soyad");  
           try {
               Thread.sleep(5000);
           } catch (InterruptedException ex) {
               Logger.getLogger(TS.class.getName()).log(Level.SEVERE, null, ex);
           }
       sayac+=15000;
       if (sayac==60000)break;
        }
        long son=System.currentTimeMillis();
       long sure =son-bas;
        System.out.println("Toplam geçen sure :" +sure/1000 + "sn");
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       TS t=new TS();
      
       t.start();
      
        }
      
        // TODO code application logic here
    }
    

class Runner extends Thread {

    @Override
    public void run() {
        // Thread çalıştığında yapılması istenen işlemler buraya yazılır
    }

}
class Runner2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
           System.out.println("Soyad");
        }
    }

}