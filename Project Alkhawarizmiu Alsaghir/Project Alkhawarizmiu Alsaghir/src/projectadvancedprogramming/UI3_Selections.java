
package projectadvancedprogramming;

import javax.swing.*; //Import the all classes in package swing
import java.awt.*; //Import the all classes in package awt
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

public class UI3_Selections {
    
    public void go(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        frame.setLocation(350, 150);
        frame.setSize(1200,700); //set frame size
        frame.setVisible(true); //display frame
        
        
        MyDrawPanel drawPanel = new MyDrawPanel();
        drawPanel.setLayout(null);
        frame.add(drawPanel);
        
        JLabel label1 = new JLabel("اختر يا صغيري ما تريد تعلمه");
        label1.setFont(new Font("Time",Font.BOLD,50));
        label1.setSize(700, 120);
        label1.setForeground(new Color(57,106,80));
        label1.setLocation(350, 35);
        drawPanel.add(label1);
        
        JButton B1 = new JButton("تعلم الأرقام"); 
        B1.setBounds(710 , 300 , 150, 50);
        B1.setBackground(new Color(255,127,64));
        B1.setFont(new Font("Time",Font.BOLD,30));
        B1.setForeground(new Color(253,242,214));
        B1.setBorderPainted(false);
        drawPanel.add(B1);
        B1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
              
                frame.setVisible(false);
                SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new UI4_Lessons().setVisible(true);
                }
            });
        }
        });
        
        Icon icon1 = new ImageIcon ("learn.png");
        JLabel labelicon = new JLabel(icon1);
        labelicon.setBounds(635 , 200 , 300, 100);
        drawPanel.add(labelicon);
        
        JButton B2 = new JButton("أنشودة الأرقام"); 
        B2.setBounds(299 , 300 , 171, 50);
        B2.setBackground(new Color(255,127,64));
        B2.setFont(new Font("Time",Font.BOLD,30));
        B2.setForeground(new Color(253,242,214));
        B2.setBorderPainted(false);
        drawPanel.add(B2);
        B2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
              
                frame.setVisible(false);
                SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new UI5_Jingles().setVisible(true);
                }
            });
        }
        });
         
        Icon icon2 = new ImageIcon ("microphone.png");
        JLabel labelicon2 = new JLabel(icon2);
        labelicon2.setBounds(235 , 200 , 300, 100);
        drawPanel.add(labelicon2);
        
        JButton B3 = new JButton("اختبار الأرقام"); 
        B3.setBounds(495 , 525 , 165, 50);
        B3.setBackground(new Color(255,127,64));
        B3.setFont(new Font("Time",Font.BOLD,30));
        B3.setForeground(new Color(253,242,214));
        B3.setBorderPainted(false);
        drawPanel.add(B3);
        B3.addActionListener((ActionEvent e) -> {
            frame.setVisible(false);
            new UI6_EXam().setVisible(true);;
        });         

        Icon icon3 = new ImageIcon ("questions.png");
        JLabel labelicon3 = new JLabel(icon3);
        labelicon3.setBounds(430 , 430 , 300, 100);
        drawPanel.add(labelicon3);
        
        Icon icon4 = new ImageIcon ("animation1.gif");
        JLabel labelicon4 = new JLabel(icon4);
        labelicon4.setBounds(0 , 0 , 190, 430);
        labelicon4.setSize(200, 650);
        drawPanel.add(labelicon4);
        
        Icon icon5 = new ImageIcon ("animation1.gif");
        JLabel labelicon5 = new JLabel(icon5);
        labelicon5.setBounds(0 , 0 , 190, 430);
        labelicon5.setSize(2160, 650);
        drawPanel.add(labelicon5);
                  
        Icon arrow1 = new ImageIcon ("arrow.png");
        JButton Buttonarrow1 = new JButton (arrow1);
        Buttonarrow1.setBounds(890 , 20 , 70, 40);
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
            g.fillRect(0, 0, 200, 655); //draw fill rectangle
            
            g.setColor (new Color(251,208,78)); //set new drawing color using RGB integers
            g.fillRect(990, 0, 200, 655); //draw fill rectangle
            
            g.setColor (new Color(255,127,64));
            g.fillOval(280,180, 215, 215);
            
            g.setColor (new Color(255,127,64));
            g.fillOval(680,180, 215, 215);
            
            g.setColor (new Color(255,127,64));
            g.fillOval(470,400, 215, 215);
            
            g2d.setPaint(new Color(251,208,78));
            g2d.setStroke (new BasicStroke(5.0f));
            g2d.draw(new Rectangle2D.Double(210, 1, 770, 645));    
        }
    }//Close inner class  
}
