
package cellcivilization;

import java.util.ArrayList;


public class Operation {Thread t;
    Operation(ArrayList<Cell> civ,ArrayList<Item> it,CW world){
    t=new Thread(new Runnable(){
        public void run() {
            while(true){
try{Thread.sleep(world.timeup?1:1000);}catch(Exception e){}
            if(world.conti){world.timeup();
                for(int ce=0;ce<civ.size();ce++){boolean destroy=false;//int []f=Cell.findlife(ce, 0, civ, it, world);if(f.length>1){System.out.println(ce+":"+f.length);}
                    if(civ.get(ce).hard!=-1){
                    
                    
                for(int i=0;i<civ.size();i++){
                if(i!=ce){
            
            if(civ.get(i).x==civ.get(ce).x&&(civ.get(i).y==civ.get(ce).y+1||civ.get(i).y==civ.get(ce).y-1)||civ.get(i).y==civ.get(ce).y&&(civ.get(i).x==civ.get(ce).x+1||civ.get(i).x==civ.get(ce).x-1)){
                
                
                boolean ima=false,ife=false,ma=false,fe=false;int ipo=0,po=0;
            for(int j=0;j<civ.get(i).protein.size();j++){if(civ.get(i).protein.get(j).substring(0, 3).equals("MMM")){ima=true;ipo=j;}
            if(civ.get(i).protein.get(j).substring(0, 3).equals("FFF")){ife=true;ipo=j;}
            }
            for(int j=0;j<civ.get(ce).protein.size();j++){if(civ.get(ce).protein.get(j).substring(0, 3).equals("MMM")){ma=true;po=j;}
            if(civ.get(ce).protein.get(j).substring(0, 3).equals("FFF")){fe=true;po=j;}
            }
            if(ma&&ife){civ.get(ce).protein.remove(po);civ.get(i).protein.remove(ipo);
            civ.get(i).DNA+=civ.get(ce).DNA;
            for(int ee=0;ee<civ.get(ce).protein.size();ee++){civ.get(i).protein.add(civ.get(ce).protein.get(ee));}
            if(civ.get(i).sac+civ.get(ce).sac>9999){civ.get(i).sac=9999;}else{civ.get(i).sac+=civ.get(ce).sac;}
            if(civ.get(i).ATP+civ.get(ce).ATP>9999){civ.get(i).ATP=999;}else{civ.get(i).ATP+=civ.get(ce).ATP;}
            civ.get(i).protein.add("MRA2830312");civ.get(i).protein.add("MRA2830312");
            destroy=true;break;
            }
            if(fe&&ima){civ.get(ce).protein.remove(po);civ.get(i).protein.remove(ipo);
                civ.get(ce).DNA+=civ.get(i).DNA;
            for(int ee=0;ee<civ.get(i).protein.size();ee++){civ.get(ce).protein.add(civ.get(i).protein.get(ee));}
            if(civ.get(i).sac+civ.get(ce).sac>9999){civ.get(ce).sac=9999;}else{civ.get(ce).sac+=civ.get(i).sac;}
            if(civ.get(i).ATP+civ.get(ce).ATP>9999){civ.get(ce).ATP=999;}else{civ.get(ce).ATP+=civ.get(i).ATP;}
            civ.remove(i);
            if(ce>i){ce--;}
            civ.get(ce).protein.add("MRA2830312");civ.get(ce).protein.add("MRA2830312");
            break;
            
            
            }
            //have sex upon
            
            if(civ.get(i).hard==-1){
            for(int ee=0;ee<civ.get(i).protein.size();ee++){if(Math.random()>0.7){civ.get(ce).protein.add(civ.get(i).protein.get(ee));}}
            if(civ.get(i).sac+civ.get(ce).sac>9999){civ.get(ce).sac=9999;}else{civ.get(ce).sac+=civ.get(i).sac;}
            if(civ.get(i).ATP+civ.get(ce).ATP>9999){civ.get(ce).ATP=999;}else{civ.get(ce).ATP+=civ.get(i).ATP;}
            civ.remove(i);if(ce>i){ce--;}break;
            }
            //eat upon
            
            if(civ.get(i).hard<civ.get(ce).harm){
            
            for(int ee=0;ee<civ.get(i).protein.size();ee++){if(Math.random()>0.7){civ.get(ce).protein.add(civ.get(i).protein.get(ee));}}
            if(civ.get(i).sac+civ.get(ce).sac>9999){civ.get(ce).sac=9999;}else{civ.get(ce).sac+=civ.get(i).sac;}
            if(civ.get(i).ATP+civ.get(ce).ATP>9999){civ.get(ce).ATP=999;}else{civ.get(ce).ATP+=civ.get(i).ATP;}
            civ.remove(i);if(ce>i){ce--;}break;
            
            }
            if(civ.get(ce).hard<civ.get(i).harm){
            for(int ee=0;ee<civ.get(ce).protein.size();ee++){if(Math.random()>0.7){civ.get(i).protein.add(civ.get(ce).protein.get(ee));}}
            if(civ.get(i).sac+civ.get(ce).sac>9999){civ.get(i).sac=9999;}else{civ.get(i).sac+=civ.get(ce).sac;}
            if(civ.get(i).ATP+civ.get(ce).ATP>9999){civ.get(i).ATP=999;}else{civ.get(i).ATP+=civ.get(ce).ATP;}
            
            destroy=true;break;
            
            }
            //kill
            boolean iw=false,ia=false,is=false,id=false,w=false,a=false,s=false,d=false;
            for(int j=0;j<civ.get(i).protein.size();j++){if(civ.get(i).protein.get(j).substring(0, 3).equals("COW")){iw=true;}
            if(civ.get(i).protein.get(j).substring(0, 3).equals("COA")){ia=true;}
            if(civ.get(i).protein.get(j).substring(0, 3).equals("COS")){is=true;}
            if(civ.get(i).protein.get(j).substring(0, 3).equals("COD")){id=true;}
            }
            for(int j=0;j<civ.get(ce).protein.size();j++){if(civ.get(ce).protein.get(j).substring(0, 3).equals("COW")){w=true;}
            if(civ.get(ce).protein.get(j).substring(0, 3).equals("COA")){a=true;}
            if(civ.get(ce).protein.get(j).substring(0, 3).equals("COS")){s=true;}
            if(civ.get(ce).protein.get(j).substring(0, 3).equals("COD")){d=true;}
            }
            if(civ.get(i).x==civ.get(ce).x&&civ.get(i).y==civ.get(ce).y+1&&w&&is||civ.get(i).x==civ.get(ce).x&&civ.get(i).y==civ.get(ce).y-1&&s&&iw||
                    civ.get(i).y==civ.get(ce).y&&civ.get(i).x==civ.get(ce).x+1&&d&&ia||civ.get(i).y==civ.get(ce).y&&civ.get(i).x==civ.get(ce).x-1&&a&&id){
            civ.get(ce).ATP=(civ.get(ce).ATP+civ.get(i).ATP)/2;civ.get(i).ATP=civ.get(ce).ATP;civ.get(ce).temp=(civ.get(ce).temp+civ.get(i).temp)/2;civ.get(i).temp=civ.get(ce).temp;civ.get(ce).sac=(civ.get(ce).sac+civ.get(i).sac)/2;civ.get(i).sac=civ.get(ce).sac;
            
            
            }
            //help each other
            
            }
            
            
                }
            }
            
            if(civ.get(ce).hard!=-1&&!destroy){
            civ.get(ce).temp+=(world.gettemp(civ.get(ce).x, civ.get(ce).y)-civ.get(ce).temp)*0.1;
            if(civ.get(ce).temp>=1273){civ.get(ce).hard=-1;}
            if(!world.difficulty){if(civ.get(ce).ATP>=5){civ.get(ce).ATP-=5;}else{civ.get(ce).hard=-1;}}
            else{if(civ.get(ce).ATP>=15){civ.get(ce).ATP-=15;}else{civ.get(ce).hard=-1;}}
            }
            //burn
            
            //environment connection upon
                 
            
            if(civ.get(ce).hard!=-1&&!destroy){
            for(int pro=0;pro<civ.get(ce).protein.size();pro++){
            if(civ.get(ce).temp>CW.stoi(civ.get(ce).protein.get(pro).
                    substring(3,6))&&
                    civ.get(ce).temp<CW.stoi(civ.get(ce).protein.get(pro).substring(6,10)))
            {
            
                switch(civ.get(ce).protein.get(pro).substring(0,3)){//
                    case "GRE":if(civ.get(ce).ATP<=999&&(world.gethour(civ.get(ce).x)<18&&world.gethour(civ.get(ce).x)>=6||!world.difficulty)){civ.get(ce).ATP+=50;}if(civ.get(ce).ATP>500&&civ.get(ce).sac<9900){civ.get(ce).ATP-=100;civ.get(ce).sac+=100;}break;
                    case "MET":boolean water=false;
                        for(int i=0;i<it.size();i++){
            if(it.get(i).x==civ.get(ce).x&&it.get(i).y==civ.get(ce).y){water=true;}}
                        for(int p=0;p<civ.get(ce).protein.size();p++){
            if(civ.get(ce).protein.get(p).substring(0, 3).equals("HEO")){water=false;}}
                        if(civ.get(ce).ATP<500&&!water){if(civ.get(ce).sac>99){civ.get(ce).ATP+=100;civ.get(ce).sac-=100;}
                        else{civ.get(ce).ATP+=civ.get(ce).sac;civ.get(ce).sac=0;}}break;
                    case "HEA":if(civ.get(ce).temp<298&&civ.get(ce).ATP>39){civ.get(ce).temp+=10;civ.get(ce).ATP-=40;}break;
                     case "WSA":boolean hasw=false;int cel=-1;
                                for(int w=0;w<civ.get(ce).protein.size();w++){
            if(civ.get(ce).protein.get(w).substring(0,3).equals("COW")){hasw=true;}}
                                for(int c=0;c<civ.size();c++){
            if(civ.get(c).x==civ.get(ce).x&&civ.get(c).y==civ.get(ce).y+1){
                boolean re=false;
                for(int p=0;p<civ.get(c).protein.size();p++){
            if(civ.get(c).protein.get(p).substring(0,3).equals("REA")){re=true;}}
                
                
                if(re){cel=c;}else{break;}}}
                                if(civ.get(ce).ATP>29&&hasw&&cel!=-1&&civ.get(ce).sti){civ.get(ce).ATP-=30;
                                civ.get(ce).sti=false;civ.get(cel).sti=true;}break;
            
                case "ASA":boolean hasa=false;cel=-1;
                                for(int w=0;w<civ.get(ce).protein.size();w++){
            if(civ.get(ce).protein.get(w).substring(0,3).equals("COA")){hasa=true;}}
                                for(int c=0;c<civ.size();c++){
            if(civ.get(c).x==civ.get(ce).x-1&&civ.get(c).y==civ.get(ce).y){
                boolean re=false;
                for(int p=0;p<civ.get(c).protein.size();p++){
            if(civ.get(c).protein.get(p).substring(0,3).equals("REA")){re=true;}}
                
                
                if(re){cel=c;}else{break;}}}
                                if(civ.get(ce).ATP>29&&hasa&&cel!=-1&&civ.get(ce).sti){civ.get(ce).ATP-=30;
                                civ.get(ce).sti=false;civ.get(cel).sti=true;}break;
                
                
                case "SSA":boolean hass=false;cel=-1;
                                for(int w=0;w<civ.get(ce).protein.size();w++){
            if(civ.get(ce).protein.get(w).substring(0,3).equals("COS")){hass=true;}}
                                for(int c=0;c<civ.size();c++){
            if(civ.get(c).x==civ.get(ce).x&&civ.get(c).y==civ.get(ce).y-1){
                boolean re=false;
                for(int p=0;p<civ.get(c).protein.size();p++){
            if(civ.get(c).protein.get(p).substring(0,3).equals("REA")){re=true;}}
                
                
                if(re){cel=c;}else{break;}}}
                                if(civ.get(ce).ATP>29&&hass&&cel!=-1&&civ.get(ce).sti){civ.get(ce).ATP-=30;
                                civ.get(ce).sti=false;civ.get(cel).sti=true;}break;
                                
                                case "DSA":boolean hasd=false;cel=-1;
                                for(int w=0;w<civ.get(ce).protein.size();w++){
            if(civ.get(ce).protein.get(w).substring(0,3).equals("COD")){hasd=true;}}
                                for(int c=0;c<civ.size();c++){
            if(civ.get(c).x==civ.get(ce).x+1&&civ.get(c).y==civ.get(ce).y){
                boolean re=false;
                for(int p=0;p<civ.get(c).protein.size();p++){
            if(civ.get(c).protein.get(p).substring(0,3).equals("REA")){re=true;}}
                
                
                if(re){cel=c;}else{break;}}}
                                if(civ.get(ce).ATP>29&&hasd&&cel!=-1&&civ.get(ce).sti){civ.get(ce).ATP-=30;
                                civ.get(ce).sti=false;civ.get(cel).sti=true;}break;
                                
                                case "RGR":boolean re=false;
                for(int c=0;c<civ.size();c++){
            if(Math.pow(civ.get(c).x-civ.get(ce).x,2)+Math.pow(civ.get(c).y-civ.get(ce).y,2)<=16&&Math.pow(civ.get(c).x-civ.get(ce).x,2)+Math.pow(civ.get(c).y-civ.get(ce).y,2)>1&&civ.get(c).color==0){
                re=true;}}
                if(civ.get(ce).ATP>29&&!civ.get(ce).sti&&re){civ.get(ce).ATP-=30;
                                civ.get(ce).sti=true;}break;
                
                                case "RRE":re=false;
                for(int c=0;c<civ.size();c++){
            if(Math.pow(civ.get(c).x-civ.get(ce).x,2)+Math.pow(civ.get(c).y-civ.get(ce).y,2)<=16&&Math.pow(civ.get(c).x-civ.get(ce).x,2)+Math.pow(civ.get(c).y-civ.get(ce).y,2)>1&&civ.get(c).color==1){
                re=true;}}
                if(civ.get(ce).ATP>29&&!civ.get(ce).sti&&re){civ.get(ce).ATP-=30;
                                civ.get(ce).sti=true;}break;
                                
                                case "RBU":re=false;
                for(int c=0;c<civ.size();c++){
            if(Math.pow(civ.get(c).x-civ.get(ce).x,2)+Math.pow(civ.get(c).y-civ.get(ce).y,2)<=16&&Math.pow(civ.get(c).x-civ.get(ce).x,2)+Math.pow(civ.get(c).y-civ.get(ce).y,2)>1&&civ.get(c).color==2){
                re=true;}}
                
                for(int c=0;c<it.size();c++){
            if(Math.pow(it.get(c).x-civ.get(ce).x,2)+Math.pow(it.get(c).y-civ.get(ce).y,2)<=16){
                re=true;}}
                if(civ.get(ce).ATP>29&&!civ.get(ce).sti&&re){civ.get(ce).ATP-=30;
                                civ.get(ce).sti=true;}break;
                                 case "RYE":re=false;
                for(int c=0;c<civ.size();c++){
            if(Math.pow(civ.get(c).x-civ.get(ce).x,2)+Math.pow(civ.get(c).y-civ.get(ce).y,2)<=16&&Math.pow(civ.get(c).x-civ.get(ce).x,2)+Math.pow(civ.get(c).y-civ.get(ce).y,2)>1&&civ.get(c).color==3){
                re=true;}}
                if(civ.get(ce).ATP>29&&!civ.get(ce).sti&&re){civ.get(ce).ATP-=30;
                                civ.get(ce).sti=true;}break;
                                case "RBA":re=false;
                for(int c=0;c<civ.size();c++){
            if(Math.pow(civ.get(c).x-civ.get(ce).x,2)+Math.pow(civ.get(c).y-civ.get(ce).y,2)<=16&&Math.pow(civ.get(c).x-civ.get(ce).x,2)+Math.pow(civ.get(c).y-civ.get(ce).y,2)>1&&civ.get(c).color==4){
                re=true;}}
                
                if(civ.get(ce).ATP>29&&!civ.get(ce).sti&&re){civ.get(ce).ATP-=30;
                                civ.get(ce).sti=true;}break;
                                case "RDG":re=false;
                for(int c=0;c<civ.size();c++){
            if(Math.pow(civ.get(c).x-civ.get(ce).x,2)+Math.pow(civ.get(c).y-civ.get(ce).y,2)<=16&&Math.pow(civ.get(c).x-civ.get(ce).x,2)+Math.pow(civ.get(c).y-civ.get(ce).y,2)>1&&civ.get(c).color==5){
                re=true;}}
                
                
                if(civ.get(ce).ATP>29&&!civ.get(ce).sti&&re){civ.get(ce).ATP-=30;
                                civ.get(ce).sti=true;}break;
                                case "RGY":re=false;
                for(int c=0;c<civ.size();c++){
            if(Math.pow(civ.get(c).x-civ.get(ce).x,2)+Math.pow(civ.get(c).y-civ.get(ce).y,2)<=16&&Math.pow(civ.get(c).x-civ.get(ce).x,2)+Math.pow(civ.get(c).y-civ.get(ce).y,2)>1&&civ.get(c).color==6){
                re=true;}}
                
                if(civ.get(ce).ATP>29&&!civ.get(ce).sti&&re){civ.get(ce).ATP-=30;
                                civ.get(ce).sti=true;}break;
                                case "RIR":re=false;
                for(int c=0;c<civ.size();c++){
            if(Math.pow(civ.get(c).x-civ.get(ce).x,2)+Math.pow(civ.get(c).y-civ.get(ce).y,2)<=16&&Math.pow(civ.get(c).x-civ.get(ce).x,2)+Math.pow(civ.get(c).y-civ.get(ce).y,2)>1&&civ.get(c).color==7){
                re=true;}}
                
                
                if(civ.get(ce).ATP>29&&!civ.get(ce).sti&&re){civ.get(ce).ATP-=30;
                                civ.get(ce).sti=true;}break;
                                case "RWA":re=false;
                
                for(int c=0;c<it.size();c++){
            if(Math.pow(it.get(c).x-civ.get(ce).x,2)+Math.pow(it.get(c).y-civ.get(ce).y,2)<=2){
                re=true;}}
                if(civ.get(ce).ATP>29&&!civ.get(ce).sti&&re){civ.get(ce).ATP-=30;
                                civ.get(ce).sti=true;}break;
                                case "RCO":
                                if(civ.get(ce).ATP>29&&!civ.get(ce).sti&&civ.get(ce).temp<388){civ.get(ce).ATP-=30;
                                civ.get(ce).sti=true;}break;
                                case "RHO":
                                if(civ.get(ce).ATP>29&&!civ.get(ce).sti&&civ.get(ce).temp>413){civ.get(ce).ATP-=30;
                                civ.get(ce).sti=true;}break;
                                case "RVC":
                                if(civ.get(ce).ATP>29&&!civ.get(ce).sti&&civ.get(ce).temp<363){civ.get(ce).ATP-=30;
                                civ.get(ce).sti=true;}break;
                                case "RVH":
                                if(civ.get(ce).ATP>29&&!civ.get(ce).sti&&civ.get(ce).temp>428){civ.get(ce).ATP-=30;
                                civ.get(ce).sti=true;}break;
                                case "MRA":
                                if(Math.random()>0.5&&civ.get(ce).ATP>19){
                                    
                                switch((int)(Math.random()*4)){
                                    case 0:Cell.move(ce,1,civ,it,world);break;
                                case 1:Cell.move(ce,2,civ,it,world);break;
                                case 2:Cell.move(ce,3,civ,it,world);break;
                                case 3:Cell.move(ce,4,civ,it,world);break;
                                
                                }
                                }break;
                                case "SMW":if(civ.get(ce).sti&&civ.get(ce).ATP>19){Cell.move(ce,1,civ,it,world);civ.get(ce).sti=false;}break;
                                case "SMD":if(civ.get(ce).sti&&civ.get(ce).ATP>19){Cell.move(ce,2,civ,it,world);civ.get(ce).sti=false;}break;
                                case "SMS":if(civ.get(ce).sti&&civ.get(ce).ATP>19){Cell.move(ce,3,civ,it,world);civ.get(ce).sti=false;}break;
                                case "SMA":if(civ.get(ce).sti&&civ.get(ce).ATP>19){Cell.move(ce,4,civ,it,world);civ.get(ce).sti=false;}break;
                                case "RPO":boolean st=false;
                                    for(int p=0;p<civ.get(ce).protein.size();p++){
                                    if(civ.get(ce).protein.get(p).substring(0,3).equals("RSS")){st=true;}}
                                    if(Math.random()+(st?0.2:0)>0.9&&civ.get(ce).protein.size()<26){Cell.transcription(ce,civ,it);}break;
                                case "TAC":if(civ.get(ce).protein.size()<26&&Math.random()>0.8){Cell.stranscription(ce,0,civ,it);}break;
                                case "CAC":if(civ.get(ce).protein.size()<26&&Math.random()>0.8){Cell.stranscription(ce,1,civ,it);}break;
                
                
                
                
                
                
                
                
                
                }
                
                
                
            
            }
            
            }
            boolean DPO=false,DPS=false,DPW=false,DMS=false,DMW=false,DCM=false,DCF=false,DSS=false,CON=false;
            for(int p=0;p<civ.get(ce).protein.size();p++){
            switch(civ.get(ce).protein.get(p).substring(0,3)){
                case "DPO":DPO=true;break;
                case "DPS":DPS=true;break;
                case "DPW":DPW=true;break;
                case "DMS":DMS=true;break;
                case "DMW":DMW=true;break;
                case "DCM":DCM=true;break;
                case "DCF":DCF=true;break;
                case "DSS":DSS=true;break;
                case "CON":CON=true;break;
            }}
            double de=Math.random(),mut;boolean possible=false;int dir=0,px=0,py=0,sex;
            if((de>0.995||de>0.95&&!(DPW)||de>0.75&&DPO||de>0.5&&(DPS&&civ.get(ce).sti))&&civ.get(ce).ATP>=75){possible=true;}
            if(!possible&&DSS&&civ.get(ce).sti&&civ.get(ce).ATP>=75){civ.get(ce).sti=false;possible=true;}
            if(possible){
            for(int i=1;i<5;i++){
                switch(i){
                    case 1:px=civ.get(ce).x;py=civ.get(ce).y+1;break;
                    case 2:px=civ.get(ce).x+1;py=civ.get(ce).y;break;
                    case 3:px=civ.get(ce).x;py=civ.get(ce).y-1;break;
                    default:px=civ.get(ce).x-1;py=civ.get(ce).y;break;
                }
                boolean tryer=true;
            for(int c=0;c<civ.size();c++){
            if(civ.get(c).x==px&&civ.get(c).y==py){tryer=false;}
            }
            if(px>world.ex-1||py>world.ey-1||px<world.sx||py<world.sy){tryer=false;}
            if(tryer){dir=i;break;}
            }
            
            }
            
            
            
            if(dir!=0){civ.get(ce).ATP-=75;
            if(DMS&&DMW||!DMS&&!DMW){mut=0.01;}
            else{if(DMS){mut=0.1;}else{mut=0.001;}}
            if(DCF){sex=2;}else{if(DCM){sex=1;}else{sex=0;}}
            String DNA="";String []protein;
            if(CON&&!DCM&&!DCF){
            switch(dir){
                    case 1:civ.get(ce).protein.add("COW2830312");break;
                    case 2:civ.get(ce).protein.add("COD2830312");break;
                    case 3:civ.get(ce).protein.add("COS2830312");break;
                    default:civ.get(ce).protein.add("COA2830312");break;
                }
            }
            for(int d=0;d<civ.get(ce).DNA.length();d++){if(Math.random()<mut){
            double mu=Math.random();
            if(mu<0.55){
            int nuc=(int)(Math.random()*4)+1;
    switch(nuc){
        case 1:DNA+="A";
            break;
            case 2:DNA+="T";
            break;
            case 3:DNA+="C";
            break;
            case 4:DNA+="G";
            break;}}
            
            
            else{if(mu<0.6){int num=(int)(Math.random()*5)+1;
            for(int n=0;n<num;n++){
            int nuc=(int)(Math.random()*4)+1;
    switch(nuc){
        case 1:DNA+="A";
            break;
            case 2:DNA+="T";
            break;
            case 3:DNA+="C";
            break;
            case 4:DNA+="G";
            break;}}}}}else{
            
            DNA+=civ.get(ce).DNA.substring(d,d+1);}}
            if(sex==1){DNA=DNA.substring(0,(DNA.length()+1)/2);}
            if(sex==2){DNA=DNA.substring((DNA.length()+1)/2);}//meiosis
            
            
            if(sex==1){protein=new String[2];protein[0]="MRA2830312";protein[1]="MMM2830312";}
            else{if(sex==2){protein=new String[1];protein[0]="FFF2830312";}
            else{if(CON){protein=new String[3];protein[0]="RPO2830312";protein[1]="RPO2830312";
            switch(dir){
                    case 1:protein[2]="COS2830312";break;
                    case 2:protein[2]="COA2830312";break;
                    case 3:protein[2]="COW2830312";break;
                    default:protein[2]="COD2830312";break;
                }
            
            }else{protein=new String[2];protein[0]="RPO2830312";protein[1]="RPO2830312";
            
            }}}
            civ.add(new Cell(DNA,protein,civ.get(ce).temp,civ.get(ce).sac/2,civ.get(ce).ATP/2,0,0,px,py,false,0,civ,it,world));
            civ.get(ce).sac/=2;civ.get(ce).ATP/=2;
            //cell production
            }
            //all protein move except suicide
            boolean die=false,res=false;
            for(int pro=0;pro<civ.get(ce).protein.size();pro++){
            if(civ.get(ce).protein.get(pro).substring(0,3).equals("BRO")&&civ.get(ce).temp>CW.stoi(civ.get(ce).protein.get(pro).substring(3,6))&&civ.get(ce).temp<CW.stoi(civ.get(ce).protein.get(pro).substring(6,10)))
            {die=true;}}
            for(int pro=0;pro<civ.get(ce).protein.size();pro++){
            if(civ.get(ce).protein.get(pro).substring(0,3).equals("ABR")&&civ.get(ce).temp>CW.stoi(civ.get(ce).protein.get(pro).substring(3,6))&&civ.get(ce).temp<CW.stoi(civ.get(ce).protein.get(pro).substring(6,10)))
            {res=true;}}
            if(die&&!res){civ.get(ce).hard=-1;}
            }
            
            
            
            //if die then die
            if(destroy){civ.remove(ce);ce--;}
            
            
                }}}}
        }
    
    
    });
    
    
    
    }
    //opwater(boolean typeis){
    
    
    //}
    
}
