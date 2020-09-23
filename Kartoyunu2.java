/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kartoyunu2;

/**
 *
 * @author chs
 */
public class Kartoyunu2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ////herbir nokta bir kartı temsil etmekte buradaki nokta tanımlanırken k = kırmızı ,s =siyah renkli kartları temsil etmektedir
        ////ve buradaki amacımız kartların sıralama dizilimini bulmaktır.örneğin 15 kart için en baştan alta doğru kart sıralaması 1s,1k,2s,2k,3s,2k,1s,3k olmalıki bir alta birde yere atılınca...
        ///sonuc itibariyle yerde bulunan kartlar kırmızı ,siyah, kırmızı, siyah, kırmızı,.........siyah,kırmızı. şeklinde olabilsin.
        Nokta n1 = new Nokta(1, "k");
        Nokta n2 = new Nokta(2, "s");
        Nokta n3 = new Nokta(3, "k");
        Nokta n4 = new Nokta(4, "s");
        Nokta n5 = new Nokta(5, "k");
        Nokta n6 = new Nokta(6, "s");
        Nokta n7 = new Nokta(7, "k");
        Nokta n8 = new Nokta(8, "s");
        Nokta n9 = new Nokta(9, "k");
        Nokta n10 = new Nokta(10, "s");
        Nokta n11 = new Nokta(11, "k");
        Nokta n12 = new Nokta(12, "s");
        Nokta n13 = new Nokta(13, "k");
        Nokta n14 = new Nokta(14, "s");
        Nokta n15 = new Nokta(15, "k");///burdaki kart sayısı keyfi alınmıştır..bu sayı değiştikçe çıktıdaki dizilim şeklide değişecektir.
        
        Kuyruk k1 = new Kuyruk(32);
        Kuyruk k2 = new Kuyruk(32);
        maxHeap max = new maxHeap(16);

        k1.ekle(n1);
        k1.ekle(n2);
        k1.ekle(n3);
        k1.ekle(n4);
        k1.ekle(n5);
        k1.ekle(n6);
        k1.ekle(n7);
        k1.ekle(n8);
        k1.ekle(n9);
        k1.ekle(n10);
        k1.ekle(n11);
        k1.ekle(n12);
        k1.ekle(n13);
        k1.ekle(n14);
        k1.ekle(n15);

        int sayac = 0;
        while (!k1.bosmu()) {///k1 kuyruğu boşalana kadar yani elimde tuttuğum kartların hepsi yere atılana kadar.

            k1.ekle(k1.cikar());///kuyruğun başından alınan kartı kuyruğun sonuna ekleme işlemi.
            Nokta tmp = k1.cikar();
            if (sayac % 2 == 0) {//tanımlanan sayac mod 2 ye göre switch on .switch off işlemi görüyor .bu sayede 1 kırmızı 1 siyah olarak indisleme yapılır.
                tmp.isim = "K";
            } else {
                tmp.isim = "S";
            }

            k2.ekle(tmp);///k2 kuyruğu yere atılan kartları temsil ediyor.
            sayac++;
            max.ekleme(k2.cikar());//k2 kuyruğunun başından çıkan kartlar maxheap'e ekleniyor.
        }
 Nokta nn=new Nokta(0,"as"); /// boş bir kart tanımlanıyor yani renksiz(maxheapten çıkacak kartları göstermek için kullandım///
        while (!max.bosmu()) {///maxheap boşalana kadar siliniyor(yani tepeden eleman çıkarılıyor)

            nn = max.sil();
            nn.yaz(); ///maxhepten çıkan kartın renginin gösterimi
        }

    }

}
/// Eleman yapısı (her bir kartın tanımlanması) /////

class Nokta {

    int no;
    String isim;
    int sol;
    int sag;

    public Nokta(int no, String isim) {
        this.no = no;
        this.isim = isim;
        sol = -1;
        sag = -1;

    }

    void yaz() {
        System.out.println("numro=" + no + "-----" + "isim= " + isim);
    }

}

//// Kuyruk veri yapısının tanımlanması......////
class Kuyruk {

    int N;
    Nokta[] dizi;
    int bas;
    int son;

    public Kuyruk(int N) {
        this.N = N;
        dizi = new Nokta[N];
        bas = 0;
        son = 0;
    }

    boolean bosmu() {
        if (bas == son) {
            return true;
        } else {
            return false;
        }
    }

    boolean dolumu() {
        if (bas == (son + 1) % N) {
            return true;
        } else {
            return false;
        }
    }

    void ekle(Nokta yeni) {
        if (!dolumu()) {
            dizi[son] = yeni;
            son = (son + 1) % N;
        }
    }

    Nokta cikar() {
        Nokta sonuc;
        if (!bosmu()) {
            sonuc = dizi[bas];
            bas = (bas + 1) % N;
            return sonuc;
        } else {
            return null;
        }
    }
}

/// Heapsort veri yapısının tanımlanması///////
class maxHeap {

    Nokta[] dizi;
    int tane;
    int N;

    public maxHeap(int N) {
        dizi = new Nokta[N];
        tane = 0;

    }

    boolean bosmu() {
        return tane == 0;

    }

    public void goster() {
        int j = 0;
        for (int i = 0; i < tane / 2; i++) {
            if (dizi[i].no == dizi[j].no) {
                System.out.print(" EBEVEYN : " + dizi[i].no + dizi[i].isim + dizi[i].sol + dizi[i].sag + " SOL ÇOCUK : "
                        + dizi[(2 * i + 1)].no + dizi[(2 * i + 1)].isim + dizi[(2 * i + 1)].sol + dizi[(2 * i + 1)].sag + " SAĞ ÇOCUK :" + dizi[((2 * i) + 2)].no + dizi[((2 * i) + 2)].isim + dizi[((2 * i) + 2)].sol + dizi[((2 * i) + 2)].sag);
            }
            System.out.println();
            j++;
        }
    }

    void ekleme(Nokta yeni) {
        tane++;
        dizi[tane - 1] = yeni;
        yukaricik(tane - 1);

    }

    void yukaricik(int n) {
        int ata = (n - 1) / 2;
        while (ata >= 0 && dizi[ata].no < dizi[n].no) {
            Nokta ara = dizi[ata];
            dizi[ata] = dizi[n];
            dizi[n] = ara;
            n = ata;
            ata = (n - 1) / 2;

        }

    }

    void asagin(int n) {
        int sol = 2 * n + 1;
        int sag = 2 * n + 2;
        while ((sol < tane && dizi[n].no < dizi[sol].no) || (sag < tane && dizi[n].no < dizi[sag].no)) {
            if (sag > tane || dizi[sol].no > dizi[sag].no) {
                Nokta ara = dizi[sol];
                dizi[sol] = dizi[n];
                dizi[n] = ara;
                n = sol;
            } else {
                Nokta ara = dizi[sag];
                dizi[sag] = dizi[n];
                dizi[n] = ara;
                n = sag;
            }
            sol = 2 * n + 1;
            sag = 2 * n + 2;
        }

    }
    ////ardışık arama////

    int arama(int a) {
        int i;
        for (i = 1; i < tane; i++) {
            if (dizi[i].no == a) {
                return i;
            }
        }
        return -1;
    }
    ///Eleman silme ( bastaki en buyuk elemanın silimi)   ///

    Nokta sil() {
        Nokta tmp = dizi[0];
        dizi[0] = dizi[tane - 1];
        asagin(0);
        tane--;
        return tmp;
    }
}
