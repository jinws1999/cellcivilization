
package cellcivilization;

import static com.sun.jmx.mbeanserver.DefaultMXBeanMappingFactory.propertyName;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class CW {File file;Thread t;int year,month,day,hour,minute,order;int sleep,x,y;double times;Boolean showbasinfo,conti,timeup,difficulty=false;int sx=-700,sy=-400,ex=700,ey=400;
   
    CW(JFrame en,Container c,ArrayList<Cell>civ,ArrayList<Item>it){year=0;month=1;day=1;hour=6;minute=0;sleep=10;times=1;showbasinfo=false;conti=true;timeup=false;
    CW world=this;t=new Thread(new Runnable() {

        public void run() {
            Toolkit tk=Toolkit.getDefaultToolkit();
        Image oper=tk.getImage("oper.jpg");Image brief=tk.getImage("brief.jpg");Image info=tk.getImage("info.jpg");
        String sopein="一、基本原理\n    初始设置后，系统根据初始的要求产生一定量的细胞（细胞数过大会导致系统运行速度变慢），这些细胞具有自己的DNA、初\n始蛋白质（默认状态是两个RNA聚合酶），及其他属性。开始运作后，细胞自己本身会根据自己的蛋白质、ATP等属性以及环境来"
                + "\n活动，会产生mRNA、新的蛋白质、有丝分裂、减数分裂等，细胞如果因为自己的死亡程序、饥饿、被攻击等原因破裂，则属性\nhard调整为-1，其他细胞接近它便可吃掉它。整个世界的大小，长为1400单位，宽为800单位，可以通过设置环境控制中的结界"
                + "\n来限制细胞的运作范围，结界设置的四个参数分别为左下角的横纵坐标、右上角的横纵坐标。世界的横纵坐标模拟地球的经纬度，\n根据日期与时间决定每个位置的温度。使用者可以通过功能界面查询关于这个世界的各种信息，并对其进行调整。"
                + "\n二、资料查询\n    细胞序号可以辨认细胞，但由于其会因细胞的消失而变化，为了防止程序出错，强烈建议在暂停状态下进行查询与操作。\n    多细胞生物查询可以显示所有的多细胞生物所含的细胞序号、以及其数量。\n"
                + "    蛋白质在此项目中的格式为三个大写字母加上七个数字（三个字母表示蛋白质种类，前三个数字和后四个数字分别表示蛋白质\n保持其活性的开尔文单位温度上下限制），在资料查询中按照要求只需写三位表示蛋白质的字母，可以搜索所有含有一种或多种蛋\n"
                + "白质的细胞序号。\n    按照例如（0，2，5，8，）这样的格式来输入细胞编号，从而查询其具体信息。\n三、指令操作\n   输入细胞序号以及指令，可以行使各种功能。\n" +
"   指令大全：\n" +
"   1、/timeup （用于切换时间流逝速度至快速，只有在细胞很少时有实际效果）\n" +
"   2、/timedown （用于切换时间流逝速度至慢速）\n" +
"   3、/0 此为关于细胞操作的所有指令的开头二位，表示除了“对于这些细胞”外，其他所有细胞都被选中。\n" +
"   4、/1 此为关于细胞操作的所有指令的开头二位，表示“对于这些细胞”栏的细胞都被选中。\n" +
"   5、/temperature/数字（0-9999）\n" +
"   6、/ATP/数字（0~999）\n" +
"   7、/sac/数字（0~9999）\n" +
"   8、/stimulate/数字（0/1，0为复极状态，1为产生动作电位状态）\n" +
"   9、/DNA/核苷酸序列（例：ATTCG）\n" +
"   10、/hard/数字（-1~50，-1为破损）\n" +
"   11、/harm/数字（0~50）\n" +
"   12、/color/数字（0~7,分别位绿、红、蓝、黄、黑、深灰、灰、银）\n" +
"   13、/protein/clear（清除蛋白质）\n" +
"   14、/protein/add/蛋白质（增加蛋白质，如:/protein/add/BRO2830312ABR2830312）\n" +
"   5~14条为关于细胞的操作指令的第三位到最后\n四、基因编辑\n" +
"   在上方框内可以输入random或者一段核苷酸序列，按下添加后，下方框内出现三行处理好的信息，可以一次重复添加多个，并可以改动下方框内的其他数据，注意按要求修改，不要随意换行，否则会出错。\n" +
"   第三行信息内容：温度（前四位）+糖（四位）+ATP（三位）+硬度（两位）+尖锐度（两位）+温度（前四位）+温度（前四位）+X坐标（第一个正负号开始）+Y坐标（第二个正负号开始）+产生动作电位与否（第三个正负号）+颜色序号（第三个正负号后）";
        String sproin="本项目对一些蛋白质功能的表示方法\n" +
"一、标准\n" +
"BRO:损毁自身细胞\n" +
"ABR:防止损毁自身细胞\n" +
"GRE:叶绿素\n" +
"MET:线粒体\n" +
"HEA:转化ATP为热量\n" +
"HEO:可在水中呼吸\n" +
"WSA:受刺激后向上释放化学信号\n" +
"ASA:受刺激后向左释放化学信号\n" +
"SSA:受刺激后向下释放化学信号\n" +
"DSA:受刺激后向右释放化学信号\n" +
"REA:可接收化学信号并产生动作电位\n" +
"RGR:可感受周围绿色并产生动作电位\n" +
"RRE:可感受周围红色并产生动作电位\n" +
"RBU:可感受周围蓝色并产生动作电位\n" +
"RYE:可感受周围黄色并产生动作电位\n" +
"RBA:可感受周围黑色并产生动作电位\n" +
"RDG:可感受周围深灰色并产生动作电位\n" +
"RGY:可感受周围灰色并产生动作电位\n" +
"RIR:可感受周围银色并产生动作电位\n" +
"RPO:RNA聚合酶，用于转录\n" +
"RSS:提升转录活性\n" +
"RWA:可感受周围水并产生动作电位\n" +
"RCO:可感受周围低温并产生动作电位\n" +
"RHO:可感受周围高温并产生动作电位\n" +
"RVH:可感受周围超高温并产生动作电位\n" +
"RVC:可感受周围超低温并产生动作电位\n" +
"DPO:提升细胞分裂活性\n" +
"DPS:若有动作电位，提升细胞分裂活性\n" +
"DPW:降低细胞分裂活性\n" +
"DMS:提升基因突变率\n" +
"DMW:减弱基因突变率\n" +
"DCM:减数分裂产生精子\n" +
"DCF:减数分裂产生卵子\n" +
"DSS:消耗动作电位，提升细胞分裂活性\n" +
"CON:在有丝分裂时与新细胞产生连接\n" +
"CAC:识别特殊点CAC进行转录\n" +
"TAC:识别特殊点TAC进行转录\n" +
"MRA:随机移动\n" +
"SMW:向上移动\n" +
"SMS:向下移动\n" +
"SMA:向左移动\n" +
"SMD:向右移动\n" +
"二、不直接通过转录得到，由上述某些蛋白质构造\n" +
"COW:向上连接\n" +
"COA:向左连接\n" +
"COS:向下连接\n" +
"COD:向右连接\n" +
"MMM:标制其为精子，与卵子结合后标志消失\n" +
"FFF:标制其为卵子，与精子结合后标志消失\n" +
"三、转录后直接改变颜色或强度，转录后蛋白质数据不保留\n" +
"BRE:转红色\n" +
"BBU:转蓝色\n" +
"BYE:转黄色\n" +
"BBA:转黑色\n" +
"BDG:转深灰色\n" +
"BGY:转灰色\n" +
"BIR:转银色\n" +
"HAR:提升细胞坚固度\n" +
"STR:提升细胞尖锐度";
        
        
        
        
        
        
        
        
        
        
        
        
        
             JButton use=new JButton("功能");
             c.add(use);
             use.setBounds(1350,10,80,30);
             JFrame usage=new JFrame("功能栏");
             JFrame helping=new JFrame("说明");
             usage.setBounds(300,200,700,500);helping.setBounds(400,250,600,500);
             Container helpcon=helping.getContentPane();
             JDialog savesuc=new JDialog(usage,"");
             savesuc.setBounds(300,300,300,200);
             savesuc.getContentPane().add(new JLabel("保存成功"));
             JTabbedPane jt=new JTabbedPane();usage.add(jt);
             JTabbedPane jth=new JTabbedPane();helpcon.add(jth);
             use.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e) {
                     usage.setVisible(true);
                 }
             });
             
             
             class Draw extends JPanel{int choice;
                 public void paint(Graphics g){Font large=new Font("timesnewRoman",1,20);Font mid=new Font("timesnewRoman",1,16);Font small=new Font("timesnewRoman",0,12);
                    super.paint(g);
                    Graphics2D g2=(Graphics2D)g;
                    switch(choice){
                        case 0:g2.drawImage(brief,0,0,600,200,this);
                        g2.setFont(large);
                        g2.drawString("项目名称： CellCivilization  Version 1.0",50, 220);
                        g2.drawString("作者：  金玮晟",50, 250);
                        g2.drawString("项目简介",50, 280);
                        g2.setFont(mid);
                        g2.drawString("本项目致力于构建一个环境，设置一些基本原理，模拟生物的生命",100, 310);
                        g2.drawString("过程、进化过程，使用者可以通过本项目来观察、控制虚拟的细胞与环境，",50, 330);
                        g2.drawString("从而零距离体验进化论的具体表现，使其对更多的人来说，不再只是逻辑",50, 350);
                        g2.drawString("上的理论。",50, 370);break;
                        case 1:g2.drawImage(oper,0,0,600,200,this);
                        break;
                        case 2:g2.drawImage(info,0,0,600,200,this);break;
                    }
                    
                    }
             }
             Draw basicin=new Draw();Draw opein=new Draw();Draw proin=new Draw();basicin.choice=0;opein.choice=1;proin.choice=2;
             opein.setLayout(null);proin.setLayout(null);
             JPanel basicp=new JPanel();JPanel soup=new JPanel();JPanel chp=new JPanel();JPanel editp=new JPanel();
             JButton saveb=new JButton("保存");
             JButton help=new JButton("说明");
             JButton pause=new JButton("暂停");
             JButton showbas=new JButton("在世界中显示地理、时间信息");
             JButton poly=new JButton("多细胞生物查询");
             JButton pro=new JButton("查询");
             JButton inf=new JButton("搜索所选编号细胞信息");
             JButton clear=new JButton("清空");
             JButton addwater=new JButton("添加水");JButton removewater=new JButton("去除水");
             JButton newbound=new JButton("重置结界");JButton removebound=new JButton("去除结界");
             JButton ope=new JButton("操作");
             JButton add=new JButton("添加");
             JButton ok=new JButton("上传细胞");
             JLabel opel1=new JLabel("对于这些细胞（例：0,1,）");
             JLabel opel2=new JLabel("指令");
             JLabel findpro=new JLabel("寻找含有以下全部蛋白质的细胞(例:GRE,BRO,)");
             JTextArea se=new JTextArea(20,20);
             JTextArea pre=new JTextArea(20,20);pre.setText("random");
             JTextArea wait=new JTextArea(20,20);
             JTextArea inform=new JTextArea(20,20);
             JTextArea proinform=new JTextArea(20,20);
             JTextField prof=new JTextField();
             JTextField inff=new JTextField();
             JTextField w1=new JTextField();
             JTextField w2=new JTextField();
             JTextField w3=new JTextField();
             JTextField w4=new JTextField();
             JTextField b1=new JTextField();
             JTextField b2=new JTextField();
             JTextField b3=new JTextField();
             JTextField b4=new JTextField();
             b1.setText(""+sx);b2.setText(""+sy);b3.setText(""+ex);b4.setText(""+ey);
             JTextField ce=new JTextField();
             JTextField code=new JTextField();
             JScrollPane sej=new JScrollPane(se);
             JScrollPane prej=new JScrollPane(pre);
             JScrollPane waitj=new JScrollPane(wait);
             JScrollPane informj=new JScrollPane(inform);inform.setEditable(false);inform.setText(sopein);
             JScrollPane proinformj=new JScrollPane(proinform);proinform.setEditable(false);proinform.setText(sproin);
             int sur=0;
             for(int cel=0;cel<civ.size();cel++){if(civ.get(cel).hard!=-1){sur++;}}
             
             JLabel showinfo=new JLabel("    0年1月1日    6：00     总共细胞数量： "+civ.size()+"   未破损细胞数量： "+sur);
             basicp.setLayout(null);soup.setLayout(null);chp.setLayout(null);editp.setLayout(null);
             basicp.add(saveb);basicp.add(showbas);basicp.add(showinfo);basicp.add(pause);basicp.add(help);
             
             soup.add(poly);soup.add(pro);soup.add(inf);soup.add(clear);soup.add(findpro);soup.add(prof);soup.add(inff);soup.add(sej);
             
             chp.add(w1);chp.add(w2);chp.add(w3);chp.add(w4);chp.add(b1);chp.add(b2);chp.add(b3);chp.add(b4);
             chp.add(ce);chp.add(code);chp.add(opel1);chp.add(opel2);chp.add(ope);chp.add(addwater);chp.add(removewater);
             chp.add(newbound);chp.add(removebound);
             
             editp.add(prej);editp.add(waitj);editp.add(add);editp.add(ok);
             
             opein.add(informj);proin.add(proinformj);
             
             saveb.setBounds(550,25,80,35);help.setBounds(130,25,80,35);
             showbas.setBounds(300,25,230,35);showinfo.setBounds(50,180,500,50);pause.setBounds(30,25,80,35);
             sej.setBounds(50,145,400,250);poly.setBounds(200,5,200,30);pro.setBounds(360,40,80,30);inf.setBounds(420,110,180,30);
             clear.setBounds(460,200,80,30);findpro.setBounds(50,40,300,30);prof.setBounds(50,75,500,30);inff.setBounds(50,110,350,30);
             
             w1.setBounds(50,5,60,30);w2.setBounds(120,5,60,30);w3.setBounds(190,5,60,30);w4.setBounds(260,5,60,30);
             b1.setBounds(50,40,60,30);b2.setBounds(120,40,60,30);b3.setBounds(190,40,60,30);b4.setBounds(260,40,60,30);
             addwater.setBounds(330,5,100,30);removewater.setBounds(440,5,100,30);
             newbound.setBounds(330,40,100,30);removebound.setBounds(440,40,100,30);
             opel1.setBounds(25,80,200,30);opel2.setBounds(25,120,150,30);ce.setBounds(230,80,350,30);code.setBounds(230,120,350,30);ope.setBounds(590,100,50,30);
             
             prej.setBounds(30,30,400,150);waitj.setBounds(30,200,400,220);add.setBounds(470,50,100,50);ok.setBounds(470,250,100,50);
             
             informj.setBounds(0,200,570,230);proinformj.setBounds(0,200,570,230);
             
             jt.addTab("基本信息",basicp);jt.addTab("资料查询",soup);jt.addTab("环境操控",chp);jt.addTab("基因编辑",editp);
             jth.addTab("关于项目",basicin);jth.addTab("操作说明",opein);jth.addTab("蛋白质信息",proin);
             
             
             
             
             saveb.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                CW.save(file, year,month,day, hour, minute, civ, it);
                savesuc.setVisible(true);
            }
        
        });
           
             help.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                helping.setVisible(true);
            }
        
        });
             
             showbas.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                if(showbasinfo){showbasinfo=false;}else{showbasinfo=true;}
            }
        
        });
             
             pause.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                if(conti){conti=false;pause.setText("继续");}else{conti=true;pause.setText("暂停");}
            }
        
        });
             
             poly.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                ArrayList <Integer>all=new ArrayList();int creature=0;
                for(int ce=0;ce<civ.size();ce++){boolean needapply=true;
                     for(int c=0;c<all.size();c++){if(all.get(c)==ce){needapply=false;}}
                     if(needapply){int[]find=Cell.findlife(ce,0, civ, it);
                           if(find.length!=1){creature++;
                           for(int cc=0;cc<find.length;cc++){se.append(find[cc]+",");all.add(find[cc]);}
                           se.append("\n");
                           }
                     
                     }
                
                }
                se.append("共发现"+creature+"个多细胞生物（共含"+all.size()+"个细胞）。"+"\n");
            }
        
        });
             
             pro.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {//meixiewan
                String ser="",need=prof.getText();ArrayList <Integer>all=new ArrayList();boolean firsthasdone=false;
                for(int s=0;s<need.length();s++){
                     
                     if(need.substring(s,s+1).equals(",")){
                         if(firsthasdone){
                         for(int c=0;c<all.size();c++){boolean is=false;
                             for(int p=0;p<civ.get(all.get(c)).protein.size();p++){
                          if(civ.get(all.get(c)).protein.get(p).substring(0,3).equals(ser)){is=true;}
                          }if(!is){all.remove(c);c--;}
                             
                         }}
                         else{
                          for(int ce=0;ce<civ.size();ce++){boolean is=false;
                          
                          
                          for(int p=0;p<civ.get(ce).protein.size();p++){
                          if(civ.get(ce).protein.get(p).substring(0,3).equals(ser)){is=true;}
                          }if(is){all.add(ce);}
                          
                          }firsthasdone=true;
                     }
                     ser="";}
                     else{ser+=need.substring(s,s+1);}
                }
                for(int c=0;c<all.size();c++){if(c%20==0&&c!=0){se.append("\n");}se.append(all.get(c)+",");}se.append("\n");
            }
        
        });
             
             inf.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                String ser="",need=inff.getText();
                for(int s=0;s<need.length();s++){
                     if(need.substring(s,s+1).equals("0")||need.substring(s,s+1).equals("1")||need.substring(s,s+1).equals("2")||need.substring(s,s+1).equals("3")||
                             need.substring(s,s+1).equals("4")||need.substring(s,s+1).equals("5")||need.substring(s,s+1).equals("6")||need.substring(s,s+1).equals("7")||
                             need.substring(s,s+1).equals("8")||need.substring(s,s+1).equals("9")){ser+=need.substring(s,s+1);}
                     if(need.substring(s,s+1).equals(",")){int search=stoi(ser);
                     if(search>=0&&search<civ.size()){se.append("order : "+search+"\n"+"DNA : "+civ.get(search).DNA+"\nprotein : ");
                          for(int p=0;p<civ.get(search).protein.size();p++){se.append(civ.get(search).protein.get(p));}
                          se.append("\n"+"temperature : "+civ.get(search).temp+"  sac : "+civ.get(search).sac+"  ATP : "
                                  +civ.get(search).ATP+"  hard : "+civ.get(search).hard+"  harm : "+civ.get(search).harm+"  color : "
                                  +civ.get(search).color+"  X : "+civ.get(search).x+"  Y : "+civ.get(search).y+"  Stimulate : "+civ.get(search).sti+"\n");
                     
                     }
                     
                     ser="";
                     }
                
                }
            }
        
        });
             
             clear.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                
                se.setText("");
            }
        
        });
             
             addwater.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                int wsx=checknum(w1.getText(),-700,699,-700,699,12500);int wsy=checknum(w2.getText(),-400,399,-400,399,12500);
                int wex=checknum(w3.getText(),wsx+1,700,wsx+1,700,12500);int wey=checknum(w4.getText(),wsy+1,400,wsy+1,400,12500);
                if(wsx!=12500&&wsy!=12500&&wex!=12500&&wey!=12500){
                for(int i=wsx;i<wex;i++){
                     for(int j=wsy;j<wey;j++){boolean alreadyhas=false;
                           for(int w=0;w<it.size();w++){
                           if(it.get(w).x==i&&it.get(w).y==j){alreadyhas=true;}}
                           if(!alreadyhas){it.add(new Item(i,j,civ,it));}
                     }
                
                }
                
                
                }
            }
        
        });
             removewater.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                int wsx=checknum(w1.getText(),-700,699,-700,699,12500);int wsy=checknum(w2.getText(),-400,399,-400,399,12500);
                int wex=checknum(w3.getText(),wsx+1,700,wsx+1,700,12500);int wey=checknum(w4.getText(),wsy+1,400,wsy+1,400,12500);
                if(wsx!=12500&&wsy!=12500&&wex!=12500&&wey!=12500){
                for(int i=wsx;i<wex;i++){
                     for(int j=wsy;j<wey;j++){
                           for(int w=0;w<it.size();w++){
                           if(it.get(w).x==i&&it.get(w).y==j){it.remove(w);break;}}
                     }
                
                }
                
                
                }else{w1.setText("");w2.setText("");w3.setText("");w4.setText("");}
            }
        
        });
             newbound.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                int bsx=checknum(b1.getText(),-700,699,-700,699,12500);int bsy=checknum(b2.getText(),-400,399,-400,399,12500);
                int bex=checknum(b3.getText(),bsx+1,700,bsx+1,700,12500);int bey=checknum(b4.getText(),bsy+1,400,bsy+1,400,12500);
                if(bsx!=12500&&bsy!=12500&&bex!=12500&&bey!=12500){
                sx=bsx;sy=bsy;ex=bex;ey=bey;b1.setText(""+sx);b2.setText(""+sy);b3.setText(""+ex);b4.setText(""+ey);
                }else{b1.setText(""+sx);b2.setText(""+sy);b3.setText(""+ex);b4.setText(""+ey);}
            }
        
        });
             removebound.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                sx=-700;sy=-400;ex=700;ey=400;b1.setText(""+sx);b2.setText(""+sy);b3.setText(""+ex);b4.setText(""+ey);
            }
        
        });
             ope.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                String ser="",need=ce.getText(),cod=code.getText();ArrayList <Integer>pre=new ArrayList();ArrayList <Integer>useit=new ArrayList();
                for(int s=0;s<need.length();s++){
                     if(need.substring(s,s+1).equals("0")||need.substring(s,s+1).equals("1")||need.substring(s,s+1).equals("2")||need.substring(s,s+1).equals("3")||
                             need.substring(s,s+1).equals("4")||need.substring(s,s+1).equals("5")||need.substring(s,s+1).equals("6")||need.substring(s,s+1).equals("7")||
                             need.substring(s,s+1).equals("8")||need.substring(s,s+1).equals("9")){ser+=need.substring(s,s+1);}
                     if(need.substring(s,s+1).equals(",")){int search=stoi(ser);boolean doit=true;if(search>=0&&search<civ.size()){
                         for(int c:pre){if(c==search){doit=false;}}
                         if(doit){pre.add(search);}}ser="";}
                
                }
                if(cod.length()>3&&cod.substring(0,3).equals("/0/")){for(int ce=0;ce<civ.size();ce++){boolean other=true;
                for(int c:pre){if(c==ce){other=false;}}if(other){useit.add(ce);}
                }}
                
                if(cod.length()>3&&cod.substring(0,3).equals("/1/")){
                while(pre.size()>0){int posi=-1,num=-1;for(int c=0;c<pre.size();c++){if(pre.get(c)<num||num==-1){num=pre.get(c);posi=c;}}
                useit.add(num);pre.remove(posi);}}
                
                if(cod.length()>=9&&cod.substring(3,9).equals("remove")){
                for(int r=useit.size()-1;r>=0;r--){civ.remove(useit.get(r).intValue());}}
                if(cod.length()>=16&&cod.substring(3,15).equals("temperature/")){int temp=checknum(cod.substring(15),0,9999,0,9999,-1);
                if(temp!=-1){for(int r=useit.size()-1;r>=0;r--){civ.get(useit.get(r)).temp=temp;}}
                }
                if(cod.length()>=8&&cod.substring(3,7).equals("sac/")){int sac=checknum(cod.substring(7),0,9999,0,9999,-1);
                if(sac!=-1){for(int r=useit.size()-1;r>=0;r--){civ.get(useit.get(r)).sac=sac;}}
                }
                if(cod.length()>=8&&cod.substring(3,7).equals("ATP/")){int ATP=checknum(cod.substring(7),0,999,0,999,-1);
                if(ATP!=-1){for(int r=useit.size()-1;r>=0;r--){civ.get(useit.get(r)).ATP=ATP;}}
                }
                if(cod.length()>=9&&cod.substring(3,8).equals("hard/")){int hard=(cod.substring(8).equals("-1")?-1:checknum(cod.substring(8),0,50,0,50,-1));
                for(int r=useit.size()-1;r>=0;r--){civ.get(useit.get(r)).hard=hard;
                }}
                if(cod.length()>=9&&cod.substring(3,8).equals("harm/")){int harm=checknum(cod.substring(8),0,50,0,50,-1);
                if(harm!=-1){for(int r=useit.size()-1;r>=0;r--){civ.get(useit.get(r)).harm=harm;}}
                }
                if(cod.length()>=10&&cod.substring(3,9).equals("color/")){int color=checknum(cod.substring(9),0,7,0,7,-1);
                if(color!=-1){for(int r=useit.size()-1;r>=0;r--){civ.get(useit.get(r)).color=color;}}
                }
                if(cod.length()>=14&&cod.substring(3,13).equals("stimulate/")){int sti=checknum(cod.substring(13),0,1,0,1,-1);
                if(sti!=-1){for(int r=useit.size()-1;r>=0;r--){civ.get(useit.get(r)).sti=(sti==1);}}
                }
                if(cod.length()>=8&&cod.substring(3,7).equals("DNA/")){String DNA=checkgene(cod.substring(7));
                for(int r=useit.size()-1;r>=0;r--){civ.get(useit.get(r)).DNA=DNA;}
                }
                if(cod.length()>=16&&cod.substring(3,16).equals("protein/clear")){
                for(int r=useit.size()-1;r>=0;r--){while(civ.get(useit.get(r)).protein.size()!=0){civ.get(useit.get(r)).protein.remove(0);}}
                }
                if(cod.length()>=16&&cod.substring(3,15).equals("protein/add/")){String proall=cod.substring(15);int pron=(int)(proall.length()/10);
                String[]pro=new String[pron];for(int i=0;i<pron;i++){pro[i]=proall.substring(10*i,10*i+10);}
                for(int r=useit.size()-1;r>=0;r--){for(int p=0;p<pron;p++){civ.get(useit.get(r)).protein.add(pro[p]);}}
                }
                
                if(cod.length()>=7&&cod.substring(0,7).equals("/timeup")){timeup=true;}
                if(cod.length()>=9&&cod.substring(0,9).equals("/timedown")){timeup=false;}
                if(cod.length()>=7&&cod.substring(0,12).equals("/difficultyon")){difficulty=true;}
                if(cod.length()>=7&&cod.substring(0,13).equals("/difficultyoff")){difficulty=false;}
                //for(int c:useit){se.append(c+",");}
            }
        
        });
             add.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                
                String DNA=checkgene(pre.getText());if(!wait.getText().equals("")){wait.append("\n");}
                wait.append(DNA+"\nRPO2830312RPO2830312\n030300005000000+0+0-0");
            }
        
        });
             ok.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {wait.append("\n"+"#");
                int order=0;String all=wait.getText(),line="",DNA="";String[]protein;int temp,sac,ATP,hard,harm,color;boolean sti;
                while(!all.substring(order,order+1).equals("#")&&!all.substring(order,order+2).equals("\n#")){line="";
                while(!all.substring(order,order+1).equals("\n")){line+=all.substring(order,order+1);order++;}order++;
                DNA=line;line="";
                while(!all.substring(order,order+1).equals("\n")){line+=all.substring(order,order+1);order++;}order++;
                protein=new String[line.length()/10];
                for(int i=0;i<line.length()/10;i++){
    protein[i]=line.substring(i*10, i*10+10);
    }line="";
                while(!all.substring(order,order+1).equals("\n")){line+=all.substring(order,order+1);order++;}order++;
                temp=stoi(line.substring(0, 4));sac=stoi(line.substring(4, 8));ATP=stoi(line.substring(8, 11));hard=checknum(line.substring(11, 13),-1,50,-1,50,0);harm=stoi(line.substring(13,15));
    int sign=0,sign2=0;
    for(int j=16;;j++){if(line.substring(j, j+1).equals("+")||line.substring(j, j+1).equals("-")){sign=j;break;}}
    x=line.substring(15, 16).equals("+")?stoi(line.substring(16, sign)):-stoi(line.substring(16, sign));
    for(int j=sign+1;;j++){if(line.substring(j, j+1).equals("+")||line.substring(j, j+1).equals("-")){sign2=j;break;}}
    y=line.substring(sign, sign+1).equals("+")?stoi(line.substring(sign+1, sign2)):-stoi(line.substring(sign+1, sign2));
    sti=line.substring(sign2, sign2+1).equals("+");
       color=stoi(line.substring(sign2+1));boolean xyok=true;
       do{xyok=true;
               for(int ce=0;ce<civ.size();ce++){if(civ.get(ce).x==x&&civ.get(ce).y==y){xyok=false;}}
               if(!xyok){x=sx+(int)(Math.random()*(ex-sx));y=sy+(int)(Math.random()*(ey-sy));}
               
       }while(!xyok);
       
    civ.add(new Cell(DNA,protein,temp,sac,ATP,hard,harm,x,y,sti,color,civ,it,world));         
            }
                
    
    
    
    
    
            }
        
        });
             
             
             
             while(true){
             try{Thread.sleep(50);}catch(Exception e){}
             synchronized(""){if(conti){
             
             sur=0;
             for(int cel=0;cel<civ.size();cel++){if(civ.size()>cel&&civ.get(cel).hard!=-1){sur++;}}//civ.get(cel).ATP=500;
             showinfo.setText("  中心位置时间："+year+"年"+month+"月"+day+"日    "+hour+":"+itos(minute,2)+"     总细胞数量: "+civ.size()+"   未破损细胞数量： "+sur);
             
             }}
             }
             
        }
    });
        
        
        
    }
    public static void save(File file,int y,int m,int d,int h,int mi,ArrayList<Cell> civ,ArrayList<Item> it){
    try{
        FileWriter fw=new FileWriter(file);
    BufferedWriter bw=new BufferedWriter(fw);
    for(int i=0;i<civ.size();i++){
    
    bw.write(civ.get(i).DNA);
    bw.newLine();
    for(int j=0;j<civ.get(i).protein.size();j++){
    bw.write(civ.get(i).protein.get(j));
    }
    bw.newLine();
    bw.write(itos(civ.get(i).temp,4)+itos(civ.get(i).sac,4)+itos(civ.get(i).ATP,3)+(civ.get(i).hard!=-1?itos(civ.get(i).hard,2):"-1")+itos(civ.get(i).harm,2)
    +(civ.get(i).x>=0?"+":"-")+Math.abs(civ.get(i).x)+(civ.get(i).y>=0?"+":"-")+Math.abs(civ.get(i).y)+(civ.get(i).sti?"+":"-")+civ.get(i).color);
    bw.newLine();
    
    
    }
    bw.write("#");bw.newLine();
    for(int j=0;j<it.size();j++){
    bw.write(""+(it.get(j).x>=0?"+":"-")+Math.abs(it.get(j).x)+(it.get(j).y>=0?"+":"-")+Math.abs(it.get(j).y));
    bw.newLine();
    }
    bw.write("#");bw.newLine();
    bw.write(""+y);bw.newLine();
    bw.write(""+m);bw.newLine();
    bw.write(""+d);bw.newLine();
    bw.write(""+h);bw.newLine();
    bw.write(""+mi);
    
    bw.close();
    fw.close();
    
    }catch(Exception e){}
    }
    public static void load(CW world,ArrayList<Cell> civ,ArrayList<Item> it){
    try{String s,DNA;String[]protein;int temp,sac,ATP,hard,harm,x,y,color,type;Boolean sti;
        FileReader fr=new FileReader(world.file);
    BufferedReader br=new BufferedReader(fr);
    while(true){s=br.readLine();
    if(s.equals("#")){break;}
    else{DNA=s;s=br.readLine();
    protein=new String[s.length()/10];
    for(int i=0;i<s.length()/10;i++){
    protein[i]=s.substring(i*10, i*10+10);
    }
    s=br.readLine();
    temp=stoi(s.substring(0, 4));sac=stoi(s.substring(4, 8));ATP=stoi(s.substring(8, 11));hard=checknum(s.substring(11, 13),-1,50,-1,50,0);harm=stoi(s.substring(13,15));
    int sign=0,sign2=0;
    for(int j=16;;j++){if(s.substring(j, j+1).equals("+")||s.substring(j, j+1).equals("-")){sign=j;break;}}
    x=s.substring(15, 16).equals("+")?stoi(s.substring(16, sign)):-stoi(s.substring(16, sign));
    for(int j=sign+1;;j++){if(s.substring(j, j+1).equals("+")||s.substring(j, j+1).equals("-")){sign2=j;break;}}
    y=s.substring(sign, sign+1).equals("+")?stoi(s.substring(sign+1, sign2)):-stoi(s.substring(sign+1, sign2));
    sti=s.substring(sign2, sign2+1).equals("+");
    color=stoi(s.substring(sign2+1));
    civ.add(new Cell(DNA,protein,temp,sac,ATP,hard,harm,x,y,sti,color,civ,it,world));
    }
    }
    
    
    while(true){s=br.readLine();
    if(s.equals("#")){break;}
    else{
        int sign=0;
    for(int j=1;;j++){if(s.substring(j, j+1).equals("+")||s.substring(j, j+1).equals("-")){sign=j;break;}}
    x=s.substring(0, 1).equals("+")?stoi(s.substring(1, sign)):-stoi(s.substring(1, sign));
    y=s.substring(sign,sign+1).equals("+")?stoi(s.substring(sign+1)):-stoi(s.substring(sign+1));
        it.add(new Item(x,y,civ,it));
    }
    }
    
    s=br.readLine();world.year=stoi(s);
    s=br.readLine();world.month=stoi(s);
    s=br.readLine();world.day=stoi(s);
    s=br.readLine();world.hour=stoi(s);
    s=br.readLine();world.minute=stoi(s);
    br.close();
    fr.close();
    
    }catch(Exception e){}
    
    }
     public static String checkgene(String in){if(in.length()==6&&in.equals("random")){return Cell.rancreate();}
     String g="";
     for(int i=0;i<in.length();i++){if(in.substring(i,i+1).equals("A")||in.substring(i,i+1).equals("T")||in.substring(i,i+1).equals("C")||in.substring(i,i+1).equals("G")){g+=in.substring(i,i+1);}}
     return g;
     }
     
    
    public static int checknum(String in,int min,int max,int resmall,int rebig,int renull){boolean posi=true;String num="";int number;
    for(int i=0;i<in.length();i++){if(in.substring(i,i+1).equals("0")||in.substring(i,i+1).equals("1")||in.substring(i,i+1).equals("2")||
            in.substring(i,i+1).equals("3")||in.substring(i,i+1).equals("4")||in.substring(i,i+1).equals("5")||in.substring(i,i+1).equals("6")||
            in.substring(i,i+1).equals("7")||in.substring(i,i+1).equals("8")||in.substring(i,i+1).equals("9")||in.substring(i,i+1).equals("-")&&i==0){
        if(in.substring(i,i+1).equals("-")){posi=false;}else{num+=in.substring(i,i+1);}}else{break;}}
    if(num.equals("")){return renull;}
    number=stoi(num);if(!posi){number=-number;}
    if(number>max){return rebig;}
    if(number<min){return resmall;}
    return number;
    }
    
    public static String itos(int n,int num){int numr;String s="";
    for(int i=1;;i++){if(n<Math.pow(10, i)){numr=i;break;}}
    for(int j=0;j<num-numr;j++){s+=0;}
    s+=n;
    return s;
    }
    
    public static int stoi(String s){int n=0;
    for(int i=0;i<s.length();i++){
    switch(s.substring(s.length()-i-1,s.length()-i)){
        case "0":
            break;
        case "1":n+=1*Math.pow(10, i);
            break;
        case "2":n+=2*Math.pow(10, i);
            break;
        case "3":n+=3*Math.pow(10, i);
            break;
        case "4":n+=4*Math.pow(10, i);
            break;
        case "5":n+=5*Math.pow(10, i);
            break;
        case "6":n+=6*Math.pow(10, i);
            break;
        case "7":n+=7*Math.pow(10, i);
            break;
        case "8":n+=8*Math.pow(10, i);
            break;
        case "9":n+=9*Math.pow(10, i);
            break;
        
    }
    
    }
    return n;
    }
    
    public int gettemp(int xx,int yy){
       return 273+41-Math.abs(yy-132+44*Math.abs(month-7))/8-Math.abs(gethour(xx)-12);
    }
    public int gethour(int xx){
       if(hour+12*xx/700<0){return hour+12*xx/700+24;}
       if(hour+12*xx/700>24){return hour+12*xx/700-24;}
        return hour+12*xx/700;
    
    }
    void timeup(){
    if(minute!=30){minute+=30;}
             else{minute=0;
             if(hour!=23){hour++;}
             else{
             hour=0;
             if(day==31||day==30&&(month==4||month==6||month==9||month==11)||day==29&&month==2||day==28&&month==2&&year%4!=0){day=1;
             if(month==12){year++;month=1;}else{month++;}
             }else{day++;}
             }
             }
    
    
    }

    
}
/*
JButton speedl=new JButton("低速");
             JButton speedm=new JButton("中速");
             JButton speedh=new JButton("高速");
JLabel speed=new JLabel("当前世界运行速度：100分钟／秒（中速）");

basicp.add(speedl);basicp.add(speedm);basicp.add(speedh);basicp.add(speed);speedl.setBounds(360,100,80,50);speedm.setBounds(450,100,80,50);speedh.setBounds(540,100,80,50);speed.setBounds(50,100,300,50);
speedl.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                sleep=100;
                speed.setText("当前世界运行速度：10分钟／秒（低速）");
            }
        
        });
             
             speedm.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                sleep=10;
                speed.setText("当前世界运行速度：100分钟／秒（中速）");
            }
        
        });
             
             speedh.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                sleep=1;
                speed.setText("当前世界运行速度：1000分钟／秒（高速）");
            }
        
        });
*/