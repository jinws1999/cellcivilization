
package cellcivilization;//for(int i=0;i<sss.getText().length();i++){if(sss.getText().substring(i,i+1).equals("\n")){}else{System.out.print(sss.getText().substring(i,i+1));}}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class Cellcivilization {

    public static void main(String[] args) {
        JFrame launch=new JFrame("Cell Civilization Launcher");
        JFrame launchnew=new JFrame("新的世界");
        JFrame launchold=new JFrame("读取");
        JFrame set=new JFrame("高级设置");
        JFrame en=new JFrame("Cell Civilization");
        launch.setBounds(300,200, 600, 450);
        launchnew.setBounds(300,200, 600, 450);
        launchold.setBounds(300,200, 600, 450);
        set.setBounds(300, 0, 600, 700);
        en.setBounds(0,0, 1450, 800);
        launch.setVisible(true);
        launch.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        launchnew.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        launchold.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        set.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        en.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container launchcon=launch.getContentPane();
        Container launchnewcon=launchnew.getContentPane();
        Container launcholdcon=launchold.getContentPane();
        Container setcon=set.getContentPane();
        Container c=en.getContentPane();c.setLayout(null);
        Toolkit tk=Toolkit.getDefaultToolkit();
        Image lbg=tk.getImage("launchbg.jpg");
        launchcon.setLayout(null);
        launchnewcon.setLayout(null);
        launcholdcon.setLayout(null);
        setcon.setLayout(null);
        
        
        class Drawbg extends JPanel{
        public void paint(Graphics g){
        super.paint(g);
        g.drawImage(lbg, 0,0,600,200, this);
        }
        }
        
        
        
        
        
        Drawbg drawbg=new Drawbg();Drawbg drawbgn=new Drawbg();Drawbg drawbgo=new Drawbg();
        launchcon.add(drawbg);launchnewcon.add(drawbgn);launcholdcon.add(drawbgo);
        drawbg.setBounds(0,0,600,200);drawbgn.setBounds(0,0,600,200);drawbgo.setBounds(0,0,600,200);
        JButton createnew=new JButton("新的世界");
        JButton useold=new JButton("读取");
        JButton setsth=new JButton("高级设置");
        JButton backn=new JButton("返回");
        JButton backo=new JButton("返回");
        JButton backs=new JButton("返回");
        JButton entern=new JButton("进入世界");
        JButton entero=new JButton("进入世界");
        JLabel nametn=new JLabel("请输入世界的名称");
        JLabel fnum=new JLabel("请输入初始细胞数量预期（上限10000，默认1000）");
        JButton nameto=new JButton("选择世界");
        JTextField namen=new JTextField();
        JTextField num=new JTextField();
        JTextField nameo=new JTextField();
        JLabel sin1=new JLabel("依次输入生成细胞范围的左下顶点横纵坐标、右上顶点横纵坐标");
        JLabel sin2=new JLabel("是否设立结界（禁止细胞超出范围外）");
        JLabel sin4=new JLabel("请输入基因，或random");
        JLabel sin5=new JLabel("请输入初始蛋白质");
        JLabel sin6=new JLabel("温度");
        JLabel sin7=new JLabel("糖");
        JLabel sin8=new JLabel("ATP");
        JLabel sin9=new JLabel("坚韧度");
        JLabel sin10=new JLabel("坚锐度");
        JLabel sin11=new JLabel("pond");
        JTextField sb1=new JTextField();
        JTextField sb2=new JTextField();
        JTextField sb3=new JTextField();
        JTextField sb4=new JTextField();
        JTextField spro=new JTextField();
        JTextField stemp=new JTextField();
        JTextField ssac=new JTextField();
        JTextField sATP=new JTextField();
        JTextField sying=new JTextField();
        JTextField srui=new JTextField();
        JTextArea sgene=new JTextArea();
        JRadioButton sbc=new JRadioButton();
        JRadioButton po=new JRadioButton();po.setSelected(true);
        set.add(sin1);set.add(sin2);set.add(sin4);set.add(sin5);set.add(sin6);
        set.add(sin7);set.add(sin8);set.add(sin9);set.add(sin10);set.add(sin11);set.add(sb1);
        set.add(sb2);set.add(sb3);set.add(sb4);set.add(spro);set.add(stemp);
        set.add(ssac);set.add(sATP);set.add(sying);set.add(srui);set.add(sgene);set.add(sbc);set.add(po);
        launchcon.add(createnew);
        launchcon.add(useold);
        launchnewcon.add(nametn);
        launchnewcon.add(fnum);
        launcholdcon.add(nameto);
        launchnewcon.add(namen);
        launchnewcon.add(num);
        launcholdcon.add(nameo);
        launchnewcon.add(backn);
        launchnewcon.add(entern);
        launcholdcon.add(backo);
        launcholdcon.add(entero);
        launchnewcon.add(setsth);
        set.add(backs);
        createnew.setBounds(100, 275, 100, 50); //sss.setBounds(200, 275, 100, 200);
        useold.setBounds(400, 275, 100, 50);
        nametn.setBounds(60, 275, 200, 50);
        fnum.setBounds(60, 335, 350, 50);
        nameto.setBounds(100, 275, 160, 50);
        namen.setBounds(260, 275, 160, 50);
        num.setBounds(380, 335, 160, 50);
        nameo.setBounds(260, 275, 160, 50);
        entern.setBounds(430, 275, 160, 50);
        entero.setBounds(430, 275, 160, 50);
        backn.setBounds(180,220,160,50);
        backo.setBounds(180,220,160,50);
        setsth.setBounds(360,220,160,50);
        backs.setBounds(180,5,160,35);
        sin1.setBounds(50,50,500,35);
        sin2.setBounds(100,140,350,35);
        sin4.setBounds(50,230,150,35);
        sin5.setBounds(50,520,150,35);  
        sin6.setBounds(50,565,50,35);        
        sin7.setBounds(150,565,50,35);        
        sin8.setBounds(250,565,50,35);        
        sin9.setBounds(350,565,50,35);        
        sin10.setBounds(450,565,50,35);
        sin11.setBounds(100,610,80,35);        
        sb1.setBounds(100,95,80,35);
        sb2 .setBounds(200,95,80,35);       
        sb3 .setBounds(300,95,80,35);       
        sb4.setBounds(400,95,80,35);              
        sgene.setBounds(220,230,350,280);
        spro.setBounds(220,520,350,35);        
        stemp.setBounds(100,565,50,35);        
        ssac.setBounds(200,565,50,35);
        sATP.setBounds(300,565,50,35); 
        sying.setBounds(400,565,50,35);       
        srui.setBounds(500,565,50,35);        
        sbc.setBounds(470,140,50,35);
        po.setBounds(200,610,30,35);
        sb1.setText("-700");
        sb2.setText("-400");       
        sb3.setText("700");       
        sb4.setText("400");            
        sgene.setText("random");
        spro.setText("RPO2830312RPO2830312");        
        stemp.setText("303");        
        ssac.setText("0");
        sying.setText("0"); 
        sATP.setText("500");       
        srui.setText("0");        
        num.setText("1000"); 

        ArrayList<Cell> civ=new ArrayList();
        ArrayList<Item> it=new ArrayList();
        CW world=new CW(en,c,civ,it);
        Operation op=new Operation(civ,it,world);

        
        class Draw extends JPanel {
    
    
    public void paint(Graphics g){
    super.paint(g);Color iron=new Color(160,160,160);
    Graphics2D g2=(Graphics2D)g;
    
    if(world.showbasinfo){
        Font f=new Font("宋体",1,15);g2.setFont(f);
        g2.drawString("0   ("+CW.itos(world.gethour(0),2)+":"+CW.itos(world.minute,2)+")", 660, 12);
    g2.drawString("300   ("+CW.itos(world.gethour(300),2)+":"+CW.itos(world.minute,2)+")", 960, 12);
    g2.drawString("600   ("+CW.itos(world.gethour(600),2)+":"+CW.itos(world.minute,2)+")", 1260, 12);
    g2.drawString("-300   ("+CW.itos(world.gethour(-300),2)+":"+CW.itos(world.minute,2)+")", 360, 12);
    g2.drawString("-600   ("+CW.itos(world.gethour(-600),2)+":"+CW.itos(world.minute,2)+")", 60, 12);
    g2.drawString("x (time)", 660, 35);
    g2.drawString("0", 1250, 375);
    g2.drawString("("+(41-Math.abs(0-132+44*Math.abs(world.month-7))/8)+" C˚)", 1230, 400);
    g2.drawString("200", 1250, 175);
    g2.drawString("("+(41-Math.abs(200-132+44*Math.abs(world.month-7))/8)+" C˚)", 1230, 200);
    g2.drawString("-200", 1250, 575);
    g2.drawString("("+(41-Math.abs(-200-132+44*Math.abs(world.month-7))/8)+" C˚)", 1230, 600);
    g2.drawString("y", 1100, 375);
    g2.drawString("(average temperature)", 1050, 400);
    
    
    }
    for(int c=0;c<it.size();c++){
   g2.setColor(Color.blue);
    g2.fill(new Rectangle2D.Double(700+it.get(c).x,400-it.get(c).y,2,2));
    }
    for(int c=0;c<civ.size();c++){
    switch(civ.get(c).color){
        case 0:g2.setColor(Color.green);break;
        case 1:g2.setColor(Color.red);break;
        case 2:g2.setColor(Color.blue);break;
        case 3:g2.setColor(Color.yellow);break;
        case 4:g2.setColor(Color.black);break;
        case 5:g2.setColor(Color.DARK_GRAY);break;
        case 6:g2.setColor(Color.GRAY);break;
        case 7:g2.setColor(iron);break;
    }
    g2.fill(new Rectangle2D.Double(700+civ.get(c).x,400-civ.get(c).y,2,2));
    }
    
    }

}
Draw draw=new Draw();
        c.add(draw);draw.setBounds(0,40,1400,800);
        Thread t=new Thread(new Runnable(){
            public void run() {
               while(true){try{Thread.sleep(50);}catch(Exception e){}
               draw.repaint();
               }
            }
        });t.start();
        
        
        
        
        createnew.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) { 
                
                launchnew.setVisible(true);launch.setVisible(false);
                
            }
        
        });
        
        useold.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                launchold.setVisible(true);launch.setVisible(false);
                
            }
        
        });
        
        setsth.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                set.setVisible(true);launchnew.setVisible(false);
                
            }
        
        });
        
        backn.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                 launch.setVisible(true);launchnew.setVisible(false);
               
            }
        
        });
        
        backo.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                launch.setVisible(true);launchold.setVisible(false);
                
            }
        
        });
        
         backs.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                 launchnew.setVisible(true);set.setVisible(false);
               
            }
        
        });
        
        nameto.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooseworld=new JFileChooser();
                chooseworld.showOpenDialog(chooseworld);
                nameo.setText(chooseworld.getSelectedFile().getAbsolutePath());
            }
        
        });
        
        entern.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                world.file=new File(namen.getText()+".txt");
                try{world.file.createNewFile();
                }catch(IOException e2){}
                launchnew.setVisible(false);
                int sx=CW.checknum(sb1.getText(),-700,699,-700,699,-700);
                int sy=CW.checknum(sb2.getText(),-400,399,-400,399,-400);
                int ex=CW.checknum(sb3.getText(),sx+1,700,sx+1,700,700);
                int ey=CW.checknum(sb4.getText(),sy+1,400,sy+1,400,400);
                if(sbc.isSelected()){world.sx=sx;world.sy=sy;world.ex=ex;world.ey=ey;}
                double possibility=(double)(CW.checknum(num.getText(),0,((ex-sx)*(ey-sy)>10000?10000:(ex-sx)*(ey-sy)),0,((ex-sx)*(ey-sy)>10000?10000:(ex-sx)*(ey-sy)),0))/(double)((ex-sx)*(ey-sy));
                for(int i=sx;i<ex;i++){
                   
                for(int j=sy;j<ey;j++){
                if(Math.random()<possibility){
                    
                    String[]protein=new String[(int)(spro.getText().length()/10)];
                    for(int k=0;k<(int)(spro.getText().length()/10);k++){protein[k]=spro.getText().substring(k*10,k*10+10);}
                    //={"RPO2830312","RPO2830312"};"DPW2000400","MRA2000400","MRA2000400","MRA2000400","MRA2000400","GRE2000400"
                    civ.add(new Cell(CW.checkgene(sgene.getText()),protein,CW.checknum(stemp.getText(), 0, 9999, 0, 9999, 303),
                            CW.checknum(ssac.getText(), 0, 9999, 0, 9999, 0),CW.checknum(sATP.getText(), 0, 999, 0, 999, 0),
                            CW.checknum(sying.getText(), 0, 50, 0, 50, 0),CW.checknum(srui.getText(), 0, 50, 0, 50, 0),i,j,false,0,civ,it,world));
                }}}
                //it.add(new Item((int)(i,j,civ,it));
                if(po.isSelected()){for(int i=-400;i<-150;i++){for(int j=50;j<250;j++){it.add(new Item(i,j,civ,it));}}
                int ws=-400,we=-150,wh=249;
                do{int nws=ws+(int)(Math.random()*(we-ws)/16);int nwe=we-(int)(Math.random()*(we-ws)/16);wh++;
                ws=nws;we=nwe;
                for(int i=ws;i<we;i++){it.add(new Item(i,wh,civ,it));}
                
                }while(we-ws>50&&wh!=399);
                
                ws=-400;we=-150;wh=50;
                do{int nws=ws+(int)(Math.random()*(we-ws)/16);int nwe=we-(int)(Math.random()*(we-ws)/16);wh--;
                ws=nws;we=nwe;
                for(int i=ws;i<we;i++){it.add(new Item(i,wh,civ,it));}
                
                }while(we-ws>50&&wh!=-400);
                
                ws=50;we=250;wh=-400;
                do{int nws=ws+(int)(Math.random()*(we-ws)/16);int nwe=we-(int)(Math.random()*(we-ws)/16);wh--;
                ws=nws;we=nwe;
                for(int i=ws;i<we;i++){it.add(new Item(wh,i,civ,it));}
                
                }while(we-ws>50&&wh!=-700);
                
                ws=50;we=250;wh=-151;
                do{int nws=ws+(int)(Math.random()*(we-ws)/16);int nwe=we-(int)(Math.random()*(we-ws)/16);wh++;
                ws=nws;we=nwe;
                for(int i=ws;i<we;i++){it.add(new Item(wh,i,civ,it));}
                
                }while(we-ws>50&&wh!=699);}
                
                /*start by(wh,we)
                for(int j=we;j>we-200;j--){int length=(int)(Math.random()*40)+80+we-j;
                for(int i=wh;i<wh+length;i++){it.add(new Item(i,j,civ,it));}
                wh+=length/80;
                }*/
                
                
                world.t.start();op.t.start();
                CW.save(world.file, world.year,world.month,world.day, world.hour, world.minute, civ, it);
                 //      250
                //-400     -150
                    // 50
                
                /*for(int j=0;j<civ.size();j++){
                for(int i=0;i<994;i++){if(civ.get(j).DNA.substring(i, i+7).equals("TATAAAA")||civ.get(j).DNA.substring(i, i+7).equals("TATATAA")||
                        civ.get(j).DNA.substring(i, i+7).equals("TATAAAT")||civ.get(j).DNA.substring(i, i+7).equals("TATATAT")){i+=6;System.out.println(j);}}}
                
                */
                
               en.setVisible(true);
            }
        
        });
        
        entero.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                world.file=new File(nameo.getText());
                launchold.setVisible(false);
                CW.load(world,civ,it);
                world.t.start();
                op.t.start();
                
                en.setVisible(true);
            }
        
        });
        
        
        
    }
    
}
