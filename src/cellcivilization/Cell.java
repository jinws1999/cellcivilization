
package cellcivilization;
import java.util.*;
public class Cell {String DNA;ArrayList <String> protein;int temp, sac,ATP,hard,harm,x,y,color;boolean sti;Thread t;
    Cell(String nDNA,String[]nprotein,int ntemp,int nsac,int nATP,int nhard,int nharm,int nx,int ny,boolean nsti,int nco,ArrayList<Cell> civ,ArrayList<Item> it,CW world){
    DNA=nDNA;
    temp=ntemp;sac=nsac;ATP=nATP;hard=nhard;harm=nharm;x=nx;y=ny;sti=nsti;color=nco;
    protein=new ArrayList();
    for(int i=0;i<nprotein.length;i++){protein.add(nprotein[i]);}
    
    
    }
    
    static void move(int cel,int direction,ArrayList<Cell> civ,ArrayList<Item> it,CW world){
         int[]organ=findlife(cel,0,civ,it);
        if(civ.get(cel).ATP>=(organ.length>20?400:organ.length*20)){boolean ok=true;
        for(int c=0;c<civ.size();c++){boolean isother=true;
        for(int cc=0;cc<organ.length;cc++){if(organ[cc]==c){isother=false;}}
        if(isother){for(int cc=0;cc<organ.length;cc++){
        switch(direction){
            case 1:if(civ.get(c).x==civ.get(organ[cc]).x&&civ.get(c).y==civ.get(organ[cc]).y+1){ok=false;}break;
            case 2:if(civ.get(c).x==civ.get(organ[cc]).x+1&&civ.get(c).y==civ.get(organ[cc]).y){ok=false;}break;
            case 3:if(civ.get(c).x==civ.get(organ[cc]).x&&civ.get(c).y==civ.get(organ[cc]).y-1){ok=false;}break;
            case 4:if(civ.get(c).x==civ.get(organ[cc]).x-1&&civ.get(c).y==civ.get(organ[cc]).y){ok=false;}break;
        
        }}}}
        
        
        
        for(int cc=0;cc<organ.length;cc++){
        switch(direction){
            case 1:if(civ.get(organ[cc]).y+1>world.ey-1){ok=false;}break;
            case 2:if(civ.get(organ[cc]).x+1>world.ex-1){ok=false;}break;
            case 3:if(civ.get(organ[cc]).y-1<world.sy){ok=false;}break;
            case 4:if(civ.get(organ[cc]).x-1<world.sx){ok=false;}break;
        
        }}
        
        if(ok){civ.get(cel).ATP-=(organ.length>20?400:organ.length*20);
        for(int c=0;c<organ.length;c++){
            switch(direction){
            case 1:civ.get(organ[c]).y++;break;                       //move
            case 2:civ.get(organ[c]).x++;break;
            case 3:civ.get(organ[c]).y--;break;
            case 4:civ.get(organ[c]).x--;break;
        
        }
        
        
        
        }
        
        }
        
        }}
    
    static void transcription(int cel,ArrayList<Cell> civ,ArrayList<Item> it){
    int start=(int)(Math.random()*(civ.get(cel).DNA.length()-50));if(start>=0){
    for(int t=start;t<civ.get(cel).DNA.length()-10;t++){
    if(civ.get(cel).DNA.substring(t,t+7).equals("TATAAAA")||civ.get(cel).DNA.substring(t,t+7).equals("TATATAA")||
            civ.get(cel).DNA.substring(t,t+7).equals("TATAAAT")||civ.get(cel).DNA.substring(t,t+7).equals("TATATAT")){
    String mRNA="";
    for(int s=t+7;s<civ.get(cel).DNA.length();s++){
    switch(civ.get(cel).DNA.substring(s,s+1)){
        case "A":mRNA+="U";break;
        case "T":mRNA+="A";break;
        case "C":mRNA+="G";break;
        case "G":mRNA+="C";break;
    }
    if(mRNA.length()>7&&mRNA.substring(mRNA.length()-7).equals("GCGCGGC")){mRNA=mRNA.substring(0, mRNA.length()-7);break;}
    }
    translation(cel,mRNA,civ,it);
    break;
    }}}}
    
    
    static void stranscription(int cel,int typ,ArrayList<Cell> civ,ArrayList<Item> it){
    int start=(int)(Math.random()*(civ.get(cel).DNA.length()-50));
    for(int t=start;t<civ.get(cel).DNA.length()-10;t++){
    if(civ.get(cel).DNA.substring(t,t+3).equals("TAC")&&typ==0||civ.get(cel).DNA.substring(t,t+3).equals("CAC")&&typ==1){
    String mRNA="";
    for(int s=t;s<civ.get(cel).DNA.length();s++){
    switch(civ.get(cel).DNA.substring(s,s+1)){
        case "A":mRNA+="U";break;
        case "T":mRNA+="A";break;
        case "C":mRNA+="G";break;
        case "G":mRNA+="C";break;
    }
    if(mRNA.length()>7&&mRNA.substring(mRNA.length()-7).equals("GCGCGGC")){mRNA=mRNA.substring(0, mRNA.length()-7);break;}
    }//System.out.println(mRNA);
    translation(cel,mRNA,civ,it);
    break;
    }}}
    
    
    
    static void translation(int cel,String mRNA,ArrayList<Cell> civ,ArrayList<Item> it){
    int num=mRNA.length()/3;String poly="";
    for(int n=0;n<num;n++){
    switch(mRNA.substring(n*3,n*3+3)){//BCJP(X) LX Z
        case "UUU":poly+="A";break;
        case "UUC":poly+="A";break;
        case "UUA":poly+="B";break;
        case "UUG":poly+="B";break;
        case "UCU":poly+="C";break;
        case "UCC":poly+="C";break;
        case "UCA":poly+="C";break;
        case "UCG":poly+="C";break;
        case "UAU":poly+="D";break;
        case "UAC":poly+="D";break;
        case "UAA":poly+="Z";break;
        case "UAG":poly+="Z";break;
        case "UGU":poly+="E";break;
        case "UGC":poly+="E";break;
        case "UGA":poly+="Z";break;
        case "UGG":poly+="F";break;
        
        case "CUU":poly+="B";break;
        case "CUC":poly+="B";break;
        case "CUA":poly+="B";break;
        case "CUG":poly+="B";break;
        case "CCU":poly+="G";break;
        case "CCC":poly+="G";break;
        case "CCA":poly+="G";break;
        case "CCG":poly+="G";break;
        case "CAU":poly+="H";break;
        case "CAC":poly+="H";break;
        case "CAA":poly+="I";break;
        case "CAG":poly+="I";break;
        case "CGU":poly+="J";break;
        case "CGC":poly+="J";break;
        case "CGA":poly+="J";break;
        case "CGG":poly+="J";break;
        
        case "AUU":poly+="K";break;
        case "AUC":poly+="K";break;
        case "AUA":poly+="K";break;
        case "AUG":poly+="L";break;
        case "ACU":poly+="M";break;
        case "ACC":poly+="M";break;
        case "ACA":poly+="M";break;
        case "ACG":poly+="M";break;
        case "AAU":poly+="N";break;
        case "AAC":poly+="N";break;
        case "AAA":poly+="O";break;
        case "AAG":poly+="O";break;
        case "AGU":poly+="C";break;
        case "AGC":poly+="C";break;
        case "AGA":poly+="J";break;
        case "AGG":poly+="J";break;
        
        case "GUU":poly+="P";break;
        case "GUC":poly+="P";break;
        case "GUA":poly+="P";break;
        case "GUG":poly+="X";break;
        case "GCU":poly+="Q";break;
        case "GCC":poly+="Q";break;
        case "GCA":poly+="Q";break;
        case "GCG":poly+="Q";break;
        case "GAU":poly+="R";break;
        case "GAC":poly+="R";break;
        case "GAA":poly+="S";break;
        case "GAG":poly+="S";break;
        case "GGU":poly+="T";break;
        case "GGC":poly+="T";break;
        case "GGA":poly+="T";break;
        case "GGG":poly+="T";break;
        
    
    
    }}
    int start=-1;
    for(int f=0;f<poly.length();f++){
        if((poly.substring(f,f+1).equals("L")||poly.substring(f,f+1).equals("X"))&&start==-1){start=f;}
        if(poly.substring(f,f+1).equals("X")){String np=poly.substring(0,f)+"P"+(f+1!=poly.length()?poly.substring(f+1):"");
        poly=np;}
        if(start!=-1&&poly.substring(f,f+1).equals("Z")){formprotein(cel,poly.substring(start+1,f),civ,it);start=-1;}
    
    }
    if(start!=-1&&start+1!=poly.length()){formprotein(cel,poly.substring(start+1),civ,it);}
    }
    
    static void formprotein(int cel,String poly,ArrayList<Cell> civ,ArrayList<Item> it){
    int a=0,g=0,b=0,h=0,low=283,high=312;
    for(int ca=0;ca<poly.length();ca++){if(poly.substring(ca).equals("A")){a++;}}
    for(int ca=0;ca<poly.length();ca++){if(poly.substring(ca).equals("G")){g++;}}
    for(int ca=0;ca<poly.length();ca++){if(poly.substring(ca).equals("B")){b++;}}
    for(int ca=0;ca<poly.length();ca++){if(poly.substring(ca).equals("H")){h++;}}
    if(a>=1){high+=5;}if(a>=4){high+=20;}
    if(g>=1){high+=5;}if(g>=4){high+=20;}
    if(b>=1){low-=5;}if(b>=4){low-=20;}
    if(h>=1){low-=5;}if(h>=4){low-=20;}
    String back=""+low+"0"+high;
    if(poly.length()>=10){
    switch(poly.substring(0,2)){
        
        case "AA":civ.get(cel).protein.add("BRO"+back);
break;
case "AB":civ.get(cel).protein.add("ABR"+back);
break;
case "AC":civ.get(cel).protein.add("GRE"+back);
break;
case "AD":civ.get(cel).protein.add("MET"+back);
break;
case "AE":civ.get(cel).protein.add("HEA"+back);
break;
case "AF":civ.get(cel).protein.add("HEO"+back);
break;
case "AG":if(civ.get(cel).hard<50){civ.get(cel).hard++;}//hard
break;
case "AH":if(civ.get(cel).harm<50){civ.get(cel).harm++;}//harmful
break;
case "AI":civ.get(cel).protein.add("WSA"+back);
break;
case "AJ":civ.get(cel).protein.add("ASA"+back);
break;
case "AK":civ.get(cel).protein.add("SSA"+back);
break;
case "AL":civ.get(cel).protein.add("DSA"+back);
break;
case "AM":civ.get(cel).protein.add("REA"+back);
break;
case "AN":civ.get(cel).protein.add("RGR"+back);
break;
case "AO":civ.get(cel).protein.add("RRE"+back);
break;
case "AP":civ.get(cel).protein.add("RBU"+back);
break;
case "AQ":civ.get(cel).protein.add("RYE"+back);
break;
case "AR":civ.get(cel).protein.add("RBA"+back);
break;
case "AS":civ.get(cel).protein.add("RDG"+back);
break;
case "AT":civ.get(cel).protein.add("RGY"+back);
break;
case "AU":civ.get(cel).protein.add("RIR"+back);
break;
case "AV":civ.get(cel).protein.add("RPO"+back);
break;
case "AW":civ.get(cel).protein.add("RSS"+back);
break;
case "AX":civ.get(cel).color=1;//red
break;
case "AY":civ.get(cel).color=2;//blue
break;
case "AZ":civ.get(cel).color=3;//yellow
break;
case "BA":civ.get(cel).color=4;//black
break;
case "BB":civ.get(cel).color=5;//darkgrey
break;
case "BC":civ.get(cel).color=6;//grey
break;
case "BD":civ.get(cel).color=7;//iron
break;
case "BE":civ.get(cel).protein.add("RWA"+back);
break;
case "BF":civ.get(cel).protein.add("RCO"+back);
break;
case "BG":civ.get(cel).protein.add("RHO"+back);
break;
case "BH":civ.get(cel).protein.add("RVH"+back);
break;
case "BI":civ.get(cel).protein.add("RVC"+back);
break;
case "BJ":civ.get(cel).protein.add("DPO"+back);
break;
case "BK":civ.get(cel).protein.add("DPS"+back);
break;
case "BL":civ.get(cel).protein.add("DPW"+back);
break;
case "BM":civ.get(cel).protein.add("DMS"+back);
break;
case "BN":civ.get(cel).protein.add("DMW"+back);
break;
case "BO":civ.get(cel).protein.add("DCM"+back);
break;
case "BP":civ.get(cel).protein.add("DCF"+back);
break;
case "BQ":civ.get(cel).protein.add("DSS"+back);
break;
case "BR":civ.get(cel).protein.add("CON"+back);
break;
case "BS":civ.get(cel).protein.add("CAC"+back);
break;
case "BT":civ.get(cel).protein.add("TAC"+back);
break;
case "BU":civ.get(cel).protein.add("MRA"+back);
break;
case "BV":civ.get(cel).protein.add("SMW"+back);
break;
case "BW":civ.get(cel).protein.add("SMS"+back);
break;
case "BX":civ.get(cel).protein.add("SMA"+back);
break;
case "BY":civ.get(cel).protein.add("SMD"+back);
break;
    
    
    }
    }}
    
    static int []findlife(int cel,int nodir,ArrayList<Cell> civ,ArrayList<Item> it){boolean w=false,a=false,s=false,d=false;
    int[] ww=null,aa=null,ss=null,dd=null;
    for(int p=0;p<civ.get(cel).protein.size();p++){
    if(civ.get(cel).protein.get(p).substring(0,3).equals("COW")){w=true;}
    if(civ.get(cel).protein.get(p).substring(0,3).equals("COA")){a=true;}
    if(civ.get(cel).protein.get(p).substring(0,3).equals("COS")){s=true;}
    if(civ.get(cel).protein.get(p).substring(0,3).equals("COD")){d=true;}
    }
    for(int c=0;c<civ.size();c++){
    if(w&&nodir!=1&&civ.get(c).x==civ.get(cel).x&&civ.get(c).y==civ.get(cel).y+1){
        for(int p=0;p<civ.get(c).protein.size();p++){
    if(civ.get(c).protein.get(p).substring(0,3).equals("COS")){
    ww=findlife(c,3,civ,it);break;
    }
        }}
    if(d&&nodir!=2&&civ.get(c).x==civ.get(cel).x+1&&civ.get(c).y==civ.get(cel).y){
        for(int p=0;p<civ.get(c).protein.size();p++){
    if(civ.get(c).protein.get(p).substring(0,3).equals("COA")){
    dd=findlife(c,4,civ,it);break;
    }
        }}
    if(s&&nodir!=3&&civ.get(c).x==civ.get(cel).x&&civ.get(c).y==civ.get(cel).y-1){
        for(int p=0;p<civ.get(c).protein.size();p++){
    if(civ.get(c).protein.get(p).substring(0,3).equals("COW")){
    ss=findlife(c,1,civ,it);break;
    }
        }}
    if(a&&nodir!=4&&civ.get(c).x==civ.get(cel).x-1&&civ.get(c).y==civ.get(cel).y){
        for(int p=0;p<civ.get(c).protein.size();p++){
    if(civ.get(c).protein.get(p).substring(0,3).equals("COD")){
    aa=findlife(c,2,civ,it);break;
    }
        }}
    }
    if(ww==null){ww=new int[0];}
    if(ss==null){ss=new int[0];}
    if(aa==null){aa=new int[0];}
    if(dd==null){dd=new int[0];}
    int[] find=new int[ww.length+ss.length+aa.length+dd.length+1];
    find[0]=cel;
    for(int www=0;www<ww.length;www++){find[www+1]=ww[www];}
    for(int aaa=0;aaa<aa.length;aaa++){find[aaa+1+ww.length]=aa[aaa];}
    for(int sss=0;sss<ss.length;sss++){find[sss+1+ww.length+aa.length]=ss[sss];}
    for(int ddd=0;ddd<dd.length;ddd++){find[ddd+1+ww.length+aa.length+ss.length]=dd[ddd];}
    return find;
    }
    
    static String rancreate(){int nuc=0;String DNA="";
    for(int i=0;i<2000;i++){nuc=(int)(Math.random()*4)+1;
    switch(nuc){
        case 1:DNA+="A";
            break;
            case 2:DNA+="T";
            break;
            case 3:DNA+="C";
            break;
            case 4:DNA+="G";
            break;
    
    }}
    
    return DNA;
    
    }
    
    
    
}
/*
5 4
12 3 1
7 3
10 2 2
7 2 1
10 2
*/





/*
suit temperature:283--0312
k1BRO:ABBBHHJF,broke down cell
k0ABR:BBCGJJKL,not broke
k1GRE:GSSLKMN,produce ATP
k1MET:JKKABBI,turn saccharite into ATP
k1HEA:EFEFGDD,turn ATP to temperature
k0HEO:sai breath
k2HAR:HARDHHH,let cell harder
k2STR:FIBBAA,let cell harmful

k1WSA:
k1ASA:
k1SSA:
k1DSA:
k0REA:
k1RGR:
k1RRE:
k1RBU:
k1RYE:
k1RBA:
k1RDG:
k1RGY:
k1RIR:

k1RPO:RNA polymerase (easy)
k0RSS

k2BRE:
k2BBU:
k2BYE:
k2BBA:
k2BDG:
k2BGY:
k2BIR:
k1RWA:
k1RCO
k1RHO
k1RVH:
k1RVC:

1DPO:DNA polymerase (easy)
0DPS:
0DPW:
0DMS:
0DMW:
0DCM:
0DCF:
3MMM:
3FFF:
0DSS:stimulate copy

0CON:
3COW
3COA
3COS
3COD

delete 0STK:
delete 0SSW:
delete 0SSS:

k1TAC:RNA polymerase
k1CAC:RNA polymerase

k1MRA
k1SMW
k1SMS
k1SMA
k1SMD

*/