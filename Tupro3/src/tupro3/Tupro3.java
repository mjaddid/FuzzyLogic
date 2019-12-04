package tupro3;

import java.io.*;


/**
 *
 * @author Mujaddid
 */
public class Tupro3 {
    static String id[]=new String [101]; //var id influencer
    static String folowerCount[]=new String [101]; //var folower
    static String eR[]=new String [101]; // var enggangement rate
    static double FSangatSedikit = 0,FSedikit = 0,FSedang = 0,FBanyak = 0,FSangatBanyak = 0; //anggota folowercount
    static double EKecil = 0,ESedang = 0,ETinggi = 0; //anggota enggangement rate
    static double nano=0,micro=0,medium=0; //hasil akhir
    static double hasil=0; // hasil Y*
    static double Hasil[]=new double[100]; // array data hasil Y*
    static double Top[]=new double[20]; // 20 influencer terbaik

    static void bacaData() // membaca data dari file influencer.csv
    {
        int i=0;
        BufferedReader br;
        String line;
        try {
            br=new BufferedReader(new FileReader(".\\src\\tupro3\\influencers.csv")); //direktori file influencer.csv
            while((line=br.readLine())!=null){
                
                String[] data=line.split(",");
                id[i]=data[0];
                folowerCount[i]=data[1];
                eR[i]=data[2];
                i++;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    static void cekFolowers(int folowers) // cek folower
    {
        FSangatSedikit=0;
        FSedikit=0;
        FSedang = 0;
        FBanyak= 0;
        FSangatBanyak = 0;
        double hasil=0;
        if (folowers<=5000)
        {
            FSangatSedikit=1; 
        }
        else if ((folowers>5000)&&(folowers<15000))
        {
            hasil=15000-folowers;
            FSangatSedikit=hasil/10000;
            hasil=folowers-5000;
            FSedikit=hasil/10000;
        }
        else if ((folowers>15000)&&(folowers<25000))
        {
            FSedikit=1;
        }
        else if ((folowers>25000)&&(folowers<35000))
        {
            hasil=35000-folowers;
            FSedikit=hasil/10000;
            hasil=folowers-25000;
            FSedang=hasil/10000;
        }
        else if ((folowers>35000)&&(folowers<45000))
        {
            FSedang=1;
        }  
        else if ((folowers>45000)&&(folowers<55000))
        {
            hasil=55000-folowers;
            FSedang=hasil/10000;
            hasil=folowers-45000;
            FBanyak=hasil/10000;
        }
        else if ((folowers>55000)&&(folowers<65000))
        {
            FBanyak=1;
        }
        else if ((folowers>65000)&&(folowers<75000))
        {
            hasil=75000-folowers;
            FBanyak=hasil/10000;
            hasil=folowers-65000;
            FSangatBanyak=hasil/10000;
        }
        else if (folowers>=75000)
        {
            FSangatBanyak=1;
        }
    }
    
    static void cekER(double ER) //cek Er
    {
        EKecil= 0;
        ESedang = 0;
        ETinggi = 0;
        if (ER<=2)
        {
            EKecil=1; 
        }
        else if ((ER>2)&&(ER<3))
        {
            EKecil=(3-ER)/1;
            ESedang=(ER-2)/1;
        }
        else if ((ER>3)&&(ER<4))
        {
            ESedang=1;
        }
        else if ((ER>4)&&(ER<5))
        {
            ESedang=(5-ER)/1;
            ETinggi=(ER-4)/1;
        }
        else if (ER>=5)
        {
            ETinggi=1;
        }
    }
    
    static void inferensi(int folowers,double ER) //inferensi
    {
        double n1=0,n2=0,n3=0,n4=0,n5=0,n6=0,n7=0,n8=0; //var nano
        double mc1=0,mc2=0,mc3 = 0; // var micro
        double md1=0,md2=0,md3=0,md4=0; //var medium
        nano=0;
        micro=0;
        medium=0;
        
        cekFolowers(folowers);
        cekER(ER);
        if ((FSangatSedikit!=0)&&(EKecil!=0))
            n1=Math.min(FSangatSedikit, EKecil);
        if ((FSangatSedikit!=0)&&(ESedang!=0))
            n2=Math.min(FSangatSedikit, ESedang);
        if ((FSangatSedikit!=0)&&(ETinggi!=0))
            n3=Math.min(FSangatSedikit, ETinggi);
        if ((FSedikit!=0)&&(EKecil!=0))
            n4=Math.min(FSedikit, EKecil);
        if ((FSedikit!=0)&&(ESedang!=0))
            n5=Math.min(FSedikit, ESedang);
        if ((FSedikit!=0)&&(ETinggi!=0))
            mc1=Math.min(FSedikit, ETinggi);
        if ((FSedang!=0)&&(EKecil!=0))
            n6=Math.min(FSedang, EKecil);
        if ((FSedang!=0)&&(ESedang!=0))
            mc2=Math.min(FSedang, ESedang);
        if ((FSedang!=0)&&(ETinggi!=0))
            md1=Math.min(FSedang, ETinggi);
        if ((FBanyak!=0)&&(EKecil!=0))
            n7=Math.min(FBanyak, EKecil);
        if ((FBanyak!=0)&&(ESedang!=0))
            mc3=Math.min(FBanyak, ESedang);
        if ((FBanyak!=0)&&(ETinggi!=0))
            md2=Math.min(FBanyak, ETinggi);
        if ((FSangatBanyak!=0)&&(EKecil!=0))
            n8=Math.min(FSangatBanyak, EKecil);
        if ((FSangatBanyak!=0)&&(ESedang!=0))
            md3=Math.min(FSangatBanyak, ESedang);
        if ((FSangatBanyak!=0)&&(ETinggi!=0))
            md4=Math.min(FSangatBanyak, ETinggi);
        
        double tmp=0;
        tmp=Math.max(n1, n2);
        tmp=Math.max(tmp, n3);
        tmp=Math.max(tmp, n4);
        tmp=Math.max(tmp, n5);
        tmp=Math.max(tmp, n6);
        tmp=Math.max(tmp, n7);
        tmp=Math.max(tmp, n8);
        nano=tmp;
        
        tmp=Math.max(mc1, mc2);
        tmp=Math.max(tmp, mc3);
        micro=tmp;
        
        tmp=Math.max(md1, md2);
        tmp=Math.max(tmp, md3);
        tmp=Math.max(tmp, md4);
        medium=tmp;
    }
    
    static void defuzzification()
    {
        hasil=0;
        if ((nano!=0)&&(micro!=0))
            hasil= (((nano*30)+(micro*60))/(nano+micro));
        else if ((nano!=0)&&(medium!=0))
            hasil= (((nano*30)+(medium*90))/(nano+medium));
        else if ((micro!=0)&&(medium!=0))
            hasil= (((micro*60)+(medium*90))/(micro+medium));
        else if ((nano!=0)&&((micro==0)||(medium==0)))
            hasil= ((nano*30)/nano);
        else if ((micro!=0)&&((nano==0)||(medium==0)))
            hasil= ((micro*60)/micro);
        else if ((medium!=0)&&((nano==0)||(micro==0)))
            hasil= ((medium*90)/medium);
    }
    
    public static void main(String[] args)
    {
        int i=0;
        bacaData();
        for(i = 1; i < 101; i++ )
        {
            inferensi(Integer.parseInt(folowerCount[i]),Double.parseDouble(eR[i]));
            defuzzification();
            Hasil[i-1]=hasil;
        }
        int x=0;
        int tmp=0;
        double max=0,tmp1=0;
        while (x<20)
        {
            max=Hasil[0];
            for(i = 0; i < 100; i++ )
            {
                tmp1=Hasil[i];
                if(tmp1>max)
                {
                    max=Hasil[i];
                    tmp=i;
                }
            }
            Top[x]=tmp+1;
            Hasil[tmp]=0;
            x++;
            System.out.println("Data ke-"+(tmp+1)+" ="+max);
        }
        i=0;
        try {
            BufferedWriter writer =new BufferedWriter(new FileWriter(".\\src\\tupro3\\choosen.csv")); //direktori penympanan file hasil
            while(i<=19)
            {
                String temp=String.valueOf(Top[i]);
                writer.write(temp+"\n");
                i++;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
