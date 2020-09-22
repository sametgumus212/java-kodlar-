/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vyroudrobin;

public class Vyroudrobin {

    public static void main(String[] args) {
        kuyruk k = new kuyruk(3, 10);
        k.ekle(12);
        k.goster();
        k.ekle(5);
        k.goster();
        k.ekle(18);
        k.goster();
        for (int i = 0; i < 6; i++) {
              System.out.println(" Adım "+(i+1));
            
            k.goster();
            k.cikar();
          
        }
    }
}

class kuyruk {

    int dizi[];
    int bas;
    int son;
    int quant;

    public kuyruk(int c, int quant) {
        this.quant = quant;
        dizi = new int[c];
        bas = 0;
        son = 0;
    }

    void ekle(int e) {
        if (dizi[son] == 0) {
            dizi[son] = e;
            dizi[bas] = e;
        } else {
            son = son + 1;
        }
        //  dizi[son]=dizi[son+1];
        dizi[son] = e;

    }

    void cikar() {
        if (dizi.length < 1) {
            System.out.println("boş");
            return;
        }

        if (dizi[bas] <= quant) {
            // 
            int ydizi[] = new int[dizi.length - 1];
            for (int i = 0; i < dizi.length - 1; i++) {
                ydizi[i] = dizi[i + 1];

            }
            dizi = new int[ydizi.length];
            for (int i = 0; i < dizi.length; i++) {
                dizi[i] = ydizi[i];

            }
        } else {
            int tmp;
            tmp = dizi[0] - quant;
            for (int i = 0; i < dizi.length - 1; i++) {

                dizi[i] = dizi[i + 1];

            }
            dizi[dizi.length - 1] = tmp;
        }
    }

    void goster() {
        for (int i = 0; i < dizi.length; i++) {
            System.out.println(dizi[i]);
        }
    }
}
