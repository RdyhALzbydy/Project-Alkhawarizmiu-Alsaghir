
package projectadvancedprogramming;

import javax.swing.*; //Import the all classes in package swing
import java.awt.*; //Import the all classes in package awt
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UI2_Register {
    
    int x = 50; //The x-coordinate of the shapes
    int y = 100; //The y-coordinate of the shapes
    
    JTextField tname;
    JTextField tage;
    JTextField tnumber;
    JTextField tp;
    JButton B1 ;
    
        //----------------------------------------------------------------------------
    
    private void createAccountFileIfNotExist(){ // دالة إنشاء ملف إذ لم يكن موجود مسبقا
        try {
        File myObj = new File("accounts.txt"); // إنشاء ملف لحفظ بيانات الأطفال
        if (myObj.createNewFile()) {
           System.out.println("File created: " + myObj.getName()); // ينشئ الملف ويعطيني اسمه
         } else {
           System.out.println("File already exists."); // الملف موجود 
         }
       } catch (IOException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
       }
    }
    
    
    
  //  -----------------------------------------------------------------------
    //تحفظ لي بيانات الحسابات في الملف وتظهر رسالة أنه تم الحفظ بنجاح مع رقم الهوية لاستخدامه في الدخول
    private <T> void saveData( ArrayList<T> newUserData){ 
        createAccountFileIfNotExist();
        java.util.List<T> list = this.currentAccounts();
 
        list.add((T) newUserData);

         try {
            FileWriter myWriter = new FileWriter("accounts.txt");
           
            for(T userData: list){
                myWriter.write(userData + "\n");
            }
            myWriter.close();
            JOptionPane.showMessageDialog(null,"تم فتح الحساب بنجاح \n رقم الهوية للدخول هو:"+newUserData.get(2));
          } catch (IOException e) {
              
            JOptionPane.showMessageDialog(null,"An error occurred.");
            e.printStackTrace();
          } 
    }
    
    
    
    
    
    
    
    private <T> ArrayList<T> currentAccounts(){ // تقرأ لي محتويات وبيانات ملف حسابات الطلاب
        ArrayList list =new ArrayList();
        try {
            File myObj = new File("accounts.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                T line = (T) myReader.nextLine();
                list.add(line);
            }
            myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        return list;
    }

    //---------------------------------------------------------------------------
    
    public void go(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        frame.setLocation(350, 150);
        frame.setSize(1200,700); //set frame size
        frame.setVisible(true); //display frame

        MyDrawPanel drawPanel = new MyDrawPanel();
        drawPanel.setLayout(null);
        frame.add(drawPanel);

        //This is where the action is
        for (int i = 0; i < 150; i++) { //repeat this 150 tines
            x++; //increment the x-coordinate
            y--;  //decrement the y-coordinate
            drawPanel.repaint(); //Tell the panel to repaint itself 
            try {
                Thread.sleep (10); //speed(slow it down a little)
            } catch (Exception ex){}
        }
              
        JLabel label1 = new JLabel("تسجيل حساب جديد");
        label1.setFont(new Font("Time",Font.BOLD,50));
        label1.setSize(400, 120);
        label1.setLocation(685, 30);
        drawPanel.add(label1);
        
        JLabel label2 = new JLabel("اسم المستخدم: ");
        label2.setFont(new Font("Time",Font.BOLD,20));
        label2.setSize(400, 120);
        label2.setLocation(950, 140);
        drawPanel.add(label2);
        
        tname = new JTextField(16); 
        tname.setBackground(new Color(255,127,64));
        tname.setBounds(630 , 180 , 300, 40);
        tname.setFont(new Font("Time",Font.LAYOUT_RIGHT_TO_LEFT,20));
        tname.setHorizontalAlignment(SwingConstants.CENTER);
        drawPanel.add(tname);
        
        JLabel label3 = new JLabel("العمر: ");
        label3.setFont(new Font("Time",Font.BOLD,20));
        label3.setSize(400, 120);
        label3.setLocation(1000, 240);
        drawPanel.add(label3);
        
        tage = new JTextField(); 
        tage.setBackground(new Color(255,127,64));
        tage.setBounds(630 , 280 , 300, 40);
        tage.setFont(new Font("Time",Font.LAYOUT_RIGHT_TO_LEFT,20));
        tage.setHorizontalAlignment(SwingConstants.CENTER);
        drawPanel.add(tage);
        
        JLabel label4 = new JLabel("رقم الهوية: ");
        label4.setFont(new Font("Time",Font.BOLD,20));
        label4.setSize(400, 120);
        label4.setLocation(970, 340);
        drawPanel.add(label4);
        
        tnumber = new JTextField(10); 
        tnumber.setBackground(new Color(255,127,64));
        tnumber.setBounds(630 , 380 , 300, 40);
        tnumber.setFont(new Font("Time",Font.LAYOUT_RIGHT_TO_LEFT,20));
        tnumber.setHorizontalAlignment(SwingConstants.CENTER);
        drawPanel.add(tnumber);
        
        JLabel label5 = new JLabel("كلمة المرور: ");
        label5.setFont(new Font("Time",Font.BOLD,20));
        label5.setSize(400, 120);
        label5.setLocation(958, 440);
        drawPanel.add(label5);
        
        tp = new JPasswordField(); 
        tp.setBackground(new Color(255,127,64));
        tp.setBounds(630 , 480 , 300, 40);
        tp.setFont(new Font("Time",Font.LAYOUT_RIGHT_TO_LEFT,20));
        tp.setHorizontalAlignment(SwingConstants.CENTER);
        drawPanel.add(tp);
        
        B1 = new JButton("تسجيل"); 
        B1.setBounds(770 , 560 , 120, 60);
        B1.setBackground(new Color(57,106,80));
        B1.setFont(new Font("Time",Font.BOLD,25));
        B1.setForeground(new Color(253,242,214));
        B1.setBorderPainted(false);
        B1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ArrayList list =new ArrayList();
 
                String name =tname.getText();
                String age =tage.getText();
                String number=tnumber.getText();
                String pass=tp.getText();
                
                list.add(name);
                list.add(age);
                list.add(number);
                list.add(pass);

                saveData(list);
                frame.setVisible(false);
                UI1_SignIn ui1 = new UI1_SignIn();
                ui1.go();   
            }
        });
        drawPanel.add(B1);
       
        Icon arrow1 = new ImageIcon ("arrow.png");
        JButton Buttonarrow1 = new JButton (arrow1);
        Buttonarrow1.setBounds(1080 , 20 , 70, 40);
        Buttonarrow1.setBorderPainted(false);
        Buttonarrow1.setBackground(new Color(253,250,243));
        drawPanel.add(Buttonarrow1);
        Buttonarrow1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                UI1_SignIn ui1 = new UI1_SignIn();
                ui1.go();}
        });         
    }
    
    class MyDrawPanel extends JPanel{ //It is an inner class
            
        public void paintComponent (Graphics g) {
            
            Graphics2D g2d= (Graphics2D )g; //used Graphics2D class
            //Use the continually updated x and y coordinates of the outer class
            //Draw background
            g.setColor (new Color(253,250,243));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
            //Draw
            g.setColor (new Color(251,208,78)); //set new drawing color using RGB integers
            g.fillRect(0, 0, 450, 655); //draw fill rectangle
            
             g.setColor(new Color(253,250,243));
            //استدعاء الدالة التي تنفذ recursion
            drawCircles(220, 220, 200, 3, g);
            drawCircles(220, 620, 200, 3, g);
            
            g.setColor (new Color(255,127,64));
            g.fillOval(100,100, 250, 250);
            
            g.setColor (new Color(253,242,214));
            g2d.setFont(new Font("Time",Font.BOLD,50));
            g2d.drawString("الخوارزمي", 135, 210); 
            g2d.drawString("الصغير", 160, 290);
            
            g.setColor (new Color(57,106,80));
            g2d.setFont(new Font("Time",Font.BOLD,100));
            g2d.drawString("۱", x, y+200); 
            g2d.drawString("٤", 260, y+420); 
            g2d.drawString("۲", 100, y+240); 
            g2d.drawString("٧ ", x+90, y+240);
            g2d.drawString("۹", 125, y+420);
           
            g2d.setFont(new Font("Time",Font.BOLD,30));
            g2d.drawString("لتعلم الأرقام من ۰ إلى۹  ", 90, 400);
            
            g2d.setPaint(new Color(251,208,78));
            g2d.setStroke (new BasicStroke(5.0f));
            g2d.draw(new Rectangle2D.Double(460, 1, 710, 645)); 
        }
        
        //recursion function
        private void drawCircles(int x, int y, int radius, int times, Graphics g) {
            //System.out.printf("x=%d, y=%d, r=%d, times=%d\n", x, y, radius, times);

            if (times > 0) {
                drawMidCircle(x, y, radius, g);
                drawCircles(x + radius / 2, y, radius / 2, times - 1, g); //recursion
                drawCircles(x - radius / 2, y, radius / 2, times - 1, g); //recursion
            }
        }

        private void drawMidCircle(int x, int y, int radius, Graphics g) {
            g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
        }
    }//Close inner class   
}
