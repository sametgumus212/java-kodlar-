/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vys5;

/**
 *
 * @author chs
 */
public class Vys5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        cblist cb1 = new cblist();

        for (int i = 0; i <361; i += 30) {
            String isim = "d" + String.valueOf(i);
            //   System.out.println(isim);
            int acimiz = i;
            Dugum has;
            double degerimiz =i;
            has = new Dugum(acimiz, degerimiz);
           

            cb1.sonaekle(has);
            System.out.println(has.aci + "---" + has.deger);
            if (i > 29) {
                System.out.println(has.geri.aci);
            }

        }
        cb1.dugum_goster();
        cb1.yazdır(215);
        for (int i = 0; i < 360; i += 15) {
            String isim = "d" + String.valueOf(i);
            //   System.out.println(isim);
            int acimiz = i;
            Dugum has;
            double degerimiz = i;
            has = new Dugum(acimiz, degerimiz);
           

            cb1.acisalekle(has);
            System.out.println(has.aci + "---" + has.deger);
            if (i > 29) {
              //  System.out.println(has.geri.aci);
            }

        }
         cb1.dugum_goster();
        cb1.yazdır(315);
 
        //  cb1.yazdır(235);
        // TODO code application logic here
    }

}

class Dugum {

    int aci = 0;
    double deger;
    Dugum ileri;
    Dugum geri;

    public Dugum(int aci, double deger) {
        this.aci = aci ;
        this.deger = Math.sin(deger);
        ileri = null;
        geri = null;

    }

    void dugumgoster(Dugum tmp) {
        System.out.println("acı : " + tmp.aci + " acı değeri = " + tmp.deger);

    }

}

class cblist {

    Dugum bas;
    Dugum son;

    public cblist() {
        this.bas = null;
        this.son = null;
    }

    void basaekle(Dugum yeni) {
        if (bas == son) {
            bas = yeni;
            son = yeni;
        } else {
            yeni.ileri = bas;
            bas.geri = yeni;
            bas = yeni;
        }
    }

    void sonaekle1(Dugum yeni) {
        if (bas == null) {
            bas = yeni;
            son = yeni;
        } else {
            son.ileri = yeni;
            yeni.geri = son;
            son = yeni;
        }

    }

    void sonaekle(Dugum yeni) {
        if (bas == null) {
            bas = yeni;
            son = yeni;
        } else {
            son.ileri = yeni;
            yeni.geri = son;
            son = yeni;
        }
    }

    void acisalekle(Dugum yeni) {
        if(bas.aci==yeni.aci)System.out.println("mevcut");
        else if (bas == null) {
            bas = yeni;
            son = yeni;
        } else {
            Dugum tmp = bas;
            Dugum onceki = bas;

            if (yeni.aci < tmp.aci) {
                yeni.ileri = bas;
                bas.geri = yeni;
                bas = yeni;
            }
            if (yeni.aci > tmp.aci) {
                while (yeni.aci > tmp.aci) {
                   //System.out.println("kkk");
                    //System.out.println("aaa");
                    onceki = tmp;
                     tmp=tmp.ileri;
                    //System.out.println("bbb");
                    //System.out.println("tmp ileri="+tmp.aci);

                }
              //  System.out.println("ccc");
                yeni.geri = tmp.geri;
                yeni.ileri = tmp;
                onceki.ileri = yeni;
                tmp.geri = yeni;

            }

        }

    }

    void goster(cblist cb) {
        Dugum tmp = new Dugum(0, 0.0);
        tmp = cb.bas;
        while (tmp.ileri != null) {
            System.out.println("acı : " + tmp.aci + " acı değeri = " + tmp.deger);
            tmp = tmp.ileri;
        }
    }

    void dugum_goster() {
        System.out.println();

        Dugum temp = bas;
        while (temp != null) {
            System.out.println("isim= " + temp.aci + "......para miktarı= " + temp.deger);
            temp = temp.ileri;
        }

    }

    void yazdır(int basaci) {
        Dugum tmp = new Dugum(0, 0.0);
        tmp = bas;
        if (basaci <= 180) {
            while (tmp.aci < 180) {
                //System.out.println("aaaaaaaaaa");

                System.out.println("acı : " + tmp.aci + " acı değeri = " + tmp.deger);
                tmp = tmp.ileri;
            }

        } else {
            while (tmp != null) {
                if (tmp.aci <= 180) {

                    tmp = tmp.ileri;
                } else {
                    System.out.println("acı : " + tmp.aci + " acı değeri = " + tmp.deger);

                    tmp = tmp.ileri;
                    // bas=tmp;
                }
            }
        }
    }

}
