
package vy13;
public class Vy13 {


    public static void main(String[] args) {
  System.out.println("MAX HEAP");
         maxHeap maxHeap = new maxHeap(11);
         minHeap minHeap=new minHeap(15);
         Nokta n1=new Nokta(5,"torun-2");
         Nokta n2=new Nokta(3,"alt-torun-1");
         Nokta n3=new Nokta(37,"baba1");
         Nokta n4=new Nokta(10,"torun");
         Nokta n5=new Nokta(84,"dede");
         Nokta n6=new Nokta(39,"baba-2");
         Nokta n7=new Nokta(6,"torun-2");
         Nokta n8=new Nokta(22,"torun-1");
         Nokta n9=new Nokta(9,"alt-torun-1");
         
        maxHeap.ekleme(n1);
        System.out.println("eklendi");
        maxHeap.ekleme(n2);
        maxHeap.ekleme(n3);
        maxHeap.ekleme(n4);
        maxHeap.ekleme(n5);
       
         System.out.println("eklendi");
        maxHeap.ekleme(n6);
        maxHeap.ekleme(n7);
        maxHeap.ekleme(n8);
        maxHeap.ekleme(n9);
        System.out.println("MAX DEĞER " + maxHeap.maximum().no);
        // max değeri diziden çıkardığımızda denge bozulacağından tekrar ekleme yapıyoruz
         maxHeap.ekleme(n5);
    System.out.println("ARANAN DEĞER : "+maxHeap.arama(5));
    maxHeap.goster();
   /*
     minHeap.ekleme(maxHeap.maximum());
       minHeap.ekleme(maxHeap.maximum());
       minHeap.ekleme(maxHeap.maximum());
       minHeap.ekleme(maxHeap.maximum());
       minHeap.ekleme(maxHeap.maximum());
      minHeap.ekleme(maxHeap.maximum());
       minHeap.ekleme(maxHeap.maximum());
       minHeap.ekleme(maxHeap.maximum());
     minHeap.ekleme(maxHeap.maximum());
    minHeap.goster();
    System.out.println("Min DEĞER " + minHeap.maximum().no);
  */
  //  Dugum d=new Dugum(0,"aa");
   Agac a=new Agac();
    a.ekle(maxHeap.maximum());
    a.ekle(maxHeap.maximum());
    a.ekle(maxHeap.maximum());
    a.ekle(maxHeap.maximum());
    a.ekle(maxHeap.maximum());
    a.ekle(maxHeap.maximum());
    a.ekle(maxHeap.maximum());
     a.ekle(maxHeap.maximum());
      a.ekle(maxHeap.maximum());
      
     
      
       System.out.println("inorder : ");
    a.inorder(n8);
        System.out.println("postorder : ");
    a.postorder(n8);
        System.out.println("preorder : ");
    a.preorder(n8);
    
   
      
  
   
    }
    
}
class Nokta{
     int no;
    String isim;
     int sol;
     int sag;
   Nokta so;
   Nokta sa;
    public Nokta(int no,String isim){
        this.no=no;
        this.isim=isim;
        sol=-1;
        sag=-1;
        so=null;
        sa=null;
    }
    void yaz(){
        System.out.println("numro="+no+"-----"+"isim= "+isim+".."+sol+"...."+sag);
    }
    
}
class minHeap{
    Nokta [] dizi;
    int tane;
    int N;
   
    public minHeap(int N){
        dizi=new Nokta[N];
        tane=0;
    }
  
   
    boolean bosmu(){
        return tane==0;
                
    }
     public void goster() {
         int j=0;
        for (int i=0; i <tane ; i++) {
           if(dizi[i].no==dizi[j].no){
            System.out.print(" EBEVEYN : " + dizi[i].no +dizi[i].isim+dizi[i].sol+ dizi[i].sag+ " SOL ÇOCUK : "
                    + dizi[(2*i+1)].no + dizi[(2*i+1)].isim +dizi[2*i+1].sol+dizi[2*i+1].sag+" SAĞ ÇOCUK :" + dizi[((2*i)+2)].no+dizi[(2*i+2)].isim+dizi[i].sol+dizi[i].sag);
            System.out.println();
            j++;
        }
        }
    }
    void ekleme(Nokta yeni){
          System.out.println("sel");
          yeni.sol=yeni.sol*2+2;
        System.out.println("dd"+yeni.sol);
                System.out.println("ee"+yeni.sag);
        tane++;
        dizi[tane-1]=yeni;
        yukaricik(tane-1);
       yeni.sol=tane*2+1;
      yeni.sag=tane*2+1;
    }
     void yukaricik(int n){
        int ata=(n-1)/2;
   
 

        while(ata>=0 && dizi[ata].no>dizi[n].no){
            Nokta ara=dizi[ata];
            dizi[ata]=dizi[n];
            dizi[n]=ara;
            n=ata;
            ata=(n-1)/2;
          
       
         
        }
             }
      void asagin(int n){
          int sol=2*n+1;
         int sag=2*n+2;
         while((sol<tane && dizi[n].no<dizi[sol].no) ||(sag<tane&& dizi[n].no<dizi[sag].no)){
            if(sag>tane||dizi[sol].no>dizi[sag].no){
             Nokta ara=dizi[sol];
             dizi[sol]=dizi[n];
             dizi[n]=ara;
             n=sol;
            // dizi[sol].so=dizi[2*n+1];
            }
            else{
                Nokta ara=dizi[sag];
                dizi[sag]=dizi[n];
                dizi[n]=ara;
                n=sag;
                // dizi[sag].sa=dizi[2*n+2];
            }
          sol=2*n+1;
          sag=2*n+2;
         }
         
         
         
    }
      ////ardışık arama////
      int arama(int a){
          int i;
          for(i=0;i<tane/2;i++){
              if(dizi[i].no==a) return i;
          }
          return -1;
      }
      Nokta aramam(int a){
         for (int i = 0; i < tane; i++) {
			int sol = 2 * i + 1;
			int sag = 2*i + 2;
			dizi[i].so = sol >= tane ? null : dizi[sol];
			dizi[i].sa = sag >= tane ? null : dizi[sag];
		}
		return dizi[0];
      }
      ///nokta sil///
      Nokta maximum(){
          Nokta tmp=dizi[0];
          dizi[0]=dizi[tane-1];
          asagin(0);
         tane--;
          return tmp;
      }
}
class maxHeap{
    Nokta [] dizi;
    int tane;
    int N;
    public maxHeap(int N){
        dizi=new Nokta[N];
        tane=0;
  
        
    }
 
    boolean bosmu(){
        return tane==0;
                
    }
     public void goster() {
         int j=0;
        for (int i=0; i <tane /2; i++) {
           if(dizi[i].no==dizi[j].no)
            System.out.print(" EBEVEYN : " + dizi[i].no +dizi[i].isim+ dizi[i].sol+ dizi[i].sag+ " SOL ÇOCUK : "
                    + dizi[(2*i+1)].no + dizi[(2*i+1)].isim + dizi[(2*i+1)].sol + dizi[(2*i+1)].sag+" SAĞ ÇOCUK :" + dizi[((2*i)+2)].no+dizi[((2*i)+2)].isim+ dizi[((2*i)+2)].sol+ dizi[((2*i)+2)].sag);
            System.out.println();
            j++;
        }
    }
    void ekleme(Nokta yeni){
        tane++;
        dizi[tane-1]=yeni;
        yukaricik(tane-1);
       
    }
     void yukaricik(int n){
        int ata=(n-1)/2;
        while(ata>=0 && dizi[ata].no<dizi[n].no){
            Nokta ara=dizi[ata];
            dizi[ata]=dizi[n];
            dizi[n]=ara;
            n=ata;
            ata=(n-1)/2;
                    
        }
       
     }
      void asagin(int n){
          int sol=2*n+1;
         int sag=2*n+2;
         while((sol<tane && dizi[n].no<dizi[sol].no) ||(sag<tane&& dizi[n].no<dizi[sag].no)){
            if(sag>tane||dizi[sol].no>dizi[sag].no){
             Nokta ara=dizi[sol];
             dizi[sol]=dizi[n];
             dizi[n]=ara;
             n=sol;
            }
            else{
                Nokta ara=dizi[sag];
                dizi[sag]=dizi[n];
                dizi[n]=ara;
                n=sag;
            }
          sol=2*n+1;
       sag=2*n+2;
         }
         
         
         
    }
      ////ardışık arama////
      int arama(int a){
          int i;
          for(i=0;i<tane;i++){
              if(dizi[i].no==a) return i;
          }
          return -1;
      }
      ///nokta sil///
      Nokta maximum(){
          Nokta tmp=dizi[0];
         dizi[0]=dizi[tane-1];
          asagin(0);
        tane--;
          return tmp;
      }
}
class Dugum{
    int no;
    String isim;
    Dugum sol;
    Dugum sag;
    public Dugum(int no,String isim){
        this.no=no;
        this.isim=isim;
        sol=null;
        sag=null;
    }
    void yazim(){
        System.out.println("numara= "+no+ "isim= "+isim);
    }
}
class Agac{
    Nokta kok;
    public Agac(){
       kok=null;
    }
    boolean bosmu(){
        if(kok==null)return true;
        else return false;
    }
    void ekle(Nokta yeni){
        Nokta y=null;
        Nokta x=kok;
        while(x!=null){
            y=x;
            if(yeni.no<x.no)
                x=x.so;
            else x=x.sa;
        }
        if(y==null)
            kok=yeni;
        else{
            if(yeni.no<y.no){
                y.so=yeni;
            }else y.sa=yeni;
        }
    }
    void inorder(Nokta tmp){
        if(tmp==null)return ;
        
        inorder(tmp.so);
      
        tmp.yaz();
        inorder(tmp.sa);
        
    }
     void preorder(Nokta tamp){
       if(tamp==null) System.exit(0);
       tamp.yaz();
       preorder(tamp.so);
       preorder(tamp.sa);
   }
   void postorder(Nokta tamp){
       if(tamp==null)return;
       postorder(tamp.so);
       postorder(tamp.sa);
       tamp.yaz();
   }
   
}