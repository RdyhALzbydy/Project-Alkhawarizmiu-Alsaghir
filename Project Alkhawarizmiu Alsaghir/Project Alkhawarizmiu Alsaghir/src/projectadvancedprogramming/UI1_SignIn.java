
package projectadvancedprogramming;

import javax.swing.*; //Import the all classes in package swing
import java.awt.*; //Import the all classes in package awt
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.geom.Rectangle2D;
import java.io.*;

public class UI1_SignIn {
    
    int x = 50; //The x-coordinate of the shapes
    int y = 100; //The y-coordinate of the shapes
    
    JTextField tnumber;
    JPasswordField tp;
    JButton B1 ;
    
    //----------------------------------------------------------------------------
    
     private String[] getUserData(String IDNumber){  // دالة للبحث عن رقم الحساب
        String[] userData = new String[4];
        userData[2] = "0";

        // Search
        for(String[] a : this.Accounts()){
           String account[] = (String []) a;
           if(account[2].equals(IDNumber)){
                userData = account; // معناه رقم الحساب موجود
           }
        }
        return userData;
    }
     
     private ArrayList<String []> Accounts(){
        ArrayList list =new ArrayList();
        try {
            File myObj = new File("accounts.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                list.add(line.replace("[", "").replace("]", "").split(", "));
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"An error occurred.");
            e.printStackTrace();
          }
        return list;
    }  
     
     private void saveData(String IDNumber){
          this.createAccountFileIfNotExist();
         try {
            FileWriter myWriter = new FileWriter("currentID.txt");
            myWriter.write(IDNumber);
            
            myWriter.close();
          } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"An error occurred.");
            e.printStackTrace();
          }
    }
        private void createAccountFileIfNotExist(){
          // Create file if not exist
        try {
         File myObj = new File("currentID.txt");
         if (myObj.createNewFile()) {
           System.out.println("File created: " + myObj.getName());
         } else {
           System.out.println("File already exists.");
         }
       } catch (IOException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
       }
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

        JLabel label1 = new JLabel("تسجيل الدخول");
        label1.setFont(new Font("Time",Font.BOLD,50));
        label1.setSize(400, 120);
        label1.setLocation(700, 80);
        drawPanel.add(label1);
        
        JLabel label2 = new JLabel("رقم الهوية: ");
        label2.setFont(new Font("Time",Font.BOLD,20));
        label2.setSize(400, 120);
        label2.setLocation(950, 200);
        drawPanel.add(label2);
        
        tnumber = new JTextField(10); 
        tnumber.setBackground(new Color(255,127,64));
        tnumber.setBounds(630 , 240 , 300, 40);
        tnumber.setFont(new Font("Time",Font.LAYOUT_RIGHT_TO_LEFT,20));
        tnumber.setHorizontalAlignment(SwingConstants.CENTER);
        drawPanel.add(tnumber);
        
        JLabel label3 = new JLabel("كلمة المرور: ");
        label3.setFont(new Font("Time",Font.BOLD,20));
        label3.setSize(400, 120);
        label3.setLocation(958, 300);
        drawPanel.add(label3);
        
        tp = new JPasswordField(); 
        tp.setBackground(new Color(255,127,64));
        tp.setBounds(630 , 340 , 300, 40);
        tp.setFont(new Font("Time",Font.LAYOUT_RIGHT_TO_LEFT,20));
        tp.setHorizontalAlignment(SwingConstants.CENTER);
        drawPanel.add(tp);
        
        B1 = new JButton("دخول"); 
        B1.setBounds(770 , 450 , 120, 60);
        B1.setBackground(new Color(57,106,80));
        B1.setFont(new Font("Time",Font.BOLD,25));
        B1.setForeground(new Color(253,242,214));
        B1.setBorderPainted(false);
        drawPanel.add(B1);
        B1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                String IDNumber = tnumber.getText();
                String password = tp.getText();
                String[] foundID = getUserData(IDNumber);

                if(foundID[2] == "0"){
                    JOptionPane.showMessageDialog(null,"رقم الهوية غير موجود\nقم بتسجيل حساب جديد");
                }else if(!foundID[3].equals(password)){
                    JOptionPane.showMessageDialog(null,"كلمة مرور خاطئة");
                }else{
                    JOptionPane.showMessageDialog(null,"مرحبا: "+foundID[0]);
                    saveData(foundID[2]);
                    
                    frame.setVisible(false);
                    UI3_Selections ui3 = new UI3_Selections();
                    ui3.go();
                }
            }
        });
        
        JLabel label4 = new JLabel("إذا لم يكن لديك حساب قم بـ: ");
        label4.setFont(new Font("Time",Font.BOLD,18));
        label4.setSize(400, 120);
        label4.setLocation(850, 550);
        drawPanel.add(label4);
        
        JButton B2 = new JButton("تسجيل حساب جديد"); 
        B2.setBounds(655 , 590 , 190, 30);
        B2.setBackground(new Color(57,106,80));
        B2.setFont(new Font("Time",Font.BOLD,25));
        B2.setForeground(new Color(253,242,214));
        B2.setBorderPainted(false);
        drawPanel.add(B2);
        B2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
              
                frame.setVisible(false);
                UI2_Register ui2 = new UI2_Register();
                ui2.go();}
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
            
            if (times > 0) {
                drawMidCircle(x, y, radius, g);
                drawCircles(x + radius / 2, y, radius / 2, times - 1, g); //recursion
                drawCircles(x - radius / 2, y, radius / 2, times - 1, g); // recursion
            }
        }

        private void drawMidCircle(int x, int y, int radius, Graphics g) {
            g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
        }

    }//Close inner class  
}
