
package projectadvancedprogramming;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UI4_Lessons extends JFrame {
    //تعريف المتغيرات
    private JHyperlink zero = new JHyperlink("٠");
    private JHyperlink one = new JHyperlink("١");
    private JHyperlink two = new JHyperlink("٢");
    private JHyperlink three = new JHyperlink("٣");
    private JHyperlink four = new JHyperlink("٤");
    private JHyperlink five = new JHyperlink("٥");
    private JHyperlink six = new JHyperlink("٦");
    private JHyperlink seven = new JHyperlink("٧");
    private JHyperlink eight = new JHyperlink("٨");
    private JHyperlink nine = new JHyperlink("٩");
    
    public UI4_Lessons() throws HeadlessException {
        setTitle("لتعلم الارقام ");
        setLayout(null);
  //استدعاء المتغير واضافة له الخصائص والحجم واللون والخط 
         // the links
        zero.setURL("https://youtu.be/lNFMRh4U7us");
        zero.setToolTipText("سيتم تحويلك لليوتيوب لتعلم الرقم صفر");
        zero.setBounds(825, 220, 10, 10);
        zero.setSize(100, 100);
        zero.setForeground(new Color(253,242,214));
        zero.setFont(new Font("Time",Font.BOLD,90));

        one.setURL("https://youtu.be/CX_k0NXv99s");
        one.setToolTipText("سيتم تحويلك لليوتيوب لتعلم الرقم واحد");
        one.setBounds(695, 230, 10, 10);
        one.setSize(100, 100);
        one.setForeground(new Color(253,242,214));
        one.setFont(new Font("Time",Font.BOLD,90));
        
         two.setURL("https://youtu.be/4z-fgzGY7vM");
        two.setToolTipText("سيتم تحويلك لليوتيوب لتعلم الرقم اثنان");
        two.setBounds(565, 230, 10, 10);
        two.setSize(100, 100);
        two.setForeground(new Color(253,242,214));
        two.setFont(new Font("Time",Font.BOLD,90));
         
          three.setURL("https://youtu.be/sOeThGUSjzE");
        three.setToolTipText("سيتم تحويلك لليوتيوب لتعلم الرقم ثلاثه");
        three.setBounds(435, 230, 10, 10);
        three.setSize(100, 100);
        three.setForeground(new Color(253,242,214));
        three.setFont(new Font("Time",Font.BOLD,90));
        
        four.setURL("https://youtu.be/ZACmdFBKoOs");
        four.setToolTipText("سيتم تحويلك لليوتيوب لتعلم الرقم اربعه");
        four.setBounds(305, 230, 10, 10);
        four.setSize(100, 100);
        four.setForeground(new Color(253,242,214));
        four.setFont(new Font("Time",Font.BOLD,90));
        
         five.setURL("https://youtu.be/GMf91ZncyfA");
        five.setToolTipText("سيتم تحويلك لليوتيوب لتعلم الرقم خمسه");
        five.setBounds(825, 430, 10, 10);
        five.setSize(100, 100);
        five.setForeground(new Color(253,242,214));
        five.setFont(new Font("Time",Font.BOLD,90));
        
          six.setURL("https://youtu.be/NhcQl6dydqA");
        six.setToolTipText("سيتم تحويلك لليوتيوب لتعلم الرقم سته");
        six.setBounds(695, 430, 10, 10);
        six.setSize(100, 100);
        six.setForeground(new Color(253,242,214));
        six.setFont(new Font("Time",Font.BOLD,90));
        
          seven.setURL("https://youtu.be/Tbk6DhhVqVw");
        seven.setToolTipText("سيتم تحويلك لليوتيوب لتعلم الرقم سبعه");
        seven.setBounds(565, 430, 10, 10);
        seven.setSize(100, 100);
        seven.setForeground(new Color(253,242,214));
        seven.setFont(new Font("Time",Font.BOLD,90));
        
          eight.setURL("https://youtu.be/4xJRDJkKxfo");
        eight.setToolTipText("سيتم تحويلك لليوتيوب لتعلم الرقم ثمانيه");
        eight.setBounds(435, 430, 10, 10);
        eight.setSize(100, 100);
        eight.setForeground(new Color(253,242,214));
        eight.setFont(new Font("Time",Font.BOLD,90));
        
        nine.setURL("https://youtu.be/qSF56A4IEaw");
        nine.setToolTipText("سيتم تحويلك لليوتيوب لتعلم تسعه ");
        nine.setBounds(305, 430, 10, 10);
        nine.setSize(100, 100);
        nine.setForeground(new Color(253,242,214));
        nine.setFont(new Font("Time",Font.BOLD,90));
        
        
       //line one 
        getContentPane().add(two);
        getContentPane().add(one);
        getContentPane().add(zero);
          
          //line two
        getContentPane().add(five);
        getContentPane().add(four);
        getContentPane().add(three);
      
         // line three
        getContentPane().add(eight);
        getContentPane().add(seven);
        getContentPane().add(six);
     
       //line four
        getContentPane().add(nine);
        
        getContentPane().setBackground(new Color(253,250,243));
        
        JLabel label1 = new JLabel("اختر يا صغيري الرقم الذي تريد تعلمه");
        label1.setFont(new Font("Time",Font.BOLD,50));
        label1.setSize(700, 120);
        label1.setForeground(new Color(57,106,80));
        label1.setBackground(Color.yellow);
        label1.setLocation(298, 35);
        getContentPane().add(label1);
        
        
        Icon icon1 = new ImageIcon ("animation1.gif");
        JLabel labelicon1 = new JLabel(icon1);
        labelicon1.setBounds(0 , 0 , 190, 430);
        labelicon1.setSize(200, 650);
        getContentPane().add(labelicon1);
        
        Icon icon2 = new ImageIcon ("image1.png");
        JLabel labelicon2 = new JLabel(icon2);
        labelicon2.setBounds(0 , 0 , 190, 430);
        labelicon2.setSize(200, 650);
        getContentPane().add(labelicon2);
        
        Icon icon3 = new ImageIcon ("animation1.gif");
        JLabel labelicon3 = new JLabel(icon3);
        labelicon3.setBounds(0 , 0 , 190, 430);
        labelicon3.setSize(2160, 650);
        getContentPane().add(labelicon3);
        
        Icon icon4 = new ImageIcon ("image1.png");
        JLabel labelicon4 = new JLabel(icon4);
        labelicon4.setBounds(0 , 0 , 190, 430);
        labelicon4.setSize(2460, 650);
        getContentPane().add(labelicon4);
        // المستطيلات البرتقالية
        Icon Orange1 = new ImageIcon ("image2.png");
        JLabel labelOrange1 = new JLabel(Orange1);
        labelOrange1.setBounds(800 , 200 , 100, 150);
        labelOrange1.setSize(100, 150);
        getContentPane().add(labelOrange1);
        
        Icon Orange2 = new ImageIcon ("image2.png");
        JLabel labelOrange2 = new JLabel(Orange2);
        labelOrange2.setBounds(670 , 200 , 100, 150);
        labelOrange2.setSize(100, 150);
        getContentPane().add(labelOrange2);
        
        Icon Orange3 = new ImageIcon ("image2.png");
        JLabel labelOrange3 = new JLabel(Orange3);
        labelOrange3.setBounds(540 , 200 , 100, 150);
        labelOrange3.setSize(100, 150);
        getContentPane().add(labelOrange3);
        
        Icon Orange4 = new ImageIcon ("image2.png");
        JLabel labelOrange4 = new JLabel(Orange4);
        labelOrange4.setBounds(410 , 200 , 100, 150);
        labelOrange4.setSize(100, 150);
        getContentPane().add(labelOrange4);
        
         Icon Orange5 = new ImageIcon ("image2.png");
        JLabel labelOrange5 = new JLabel(Orange5);
        labelOrange5.setBounds(280 , 200 , 100, 150);
        labelOrange5.setSize(100, 150);
        getContentPane().add(labelOrange5);
        
        Icon Orange6 = new ImageIcon ("image2.png");
        JLabel labelOrange6 = new JLabel(Orange6);
        labelOrange6.setBounds(800 , 400 , 100, 150);
        labelOrange6.setSize(100, 150);
        getContentPane().add(labelOrange6);
        
        Icon Orange7 = new ImageIcon ("image2.png");
        JLabel labelOrange7 = new JLabel(Orange7);
        labelOrange7.setBounds(670 , 400 , 100, 150);
        labelOrange7.setSize(100, 150);
        getContentPane().add(labelOrange7);
        
        Icon Orange8 = new ImageIcon ("image2.png");
        JLabel labelOrange8 = new JLabel(Orange8);
        labelOrange8.setBounds(540 , 400 , 100, 150);
        labelOrange8.setSize(100, 150);
        getContentPane().add(labelOrange8);
        
        Icon Orange9 = new ImageIcon ("image2.png");
        JLabel labelOrange9 = new JLabel(Orange9);
        labelOrange9.setBounds(410 , 400 , 100, 150);
        labelOrange9.setSize(100, 150);
        getContentPane().add(labelOrange9);
        
         Icon Orange10 = new ImageIcon ("image2.png");
        JLabel labelOrange10 = new JLabel(Orange10);
        labelOrange10.setBounds(280 , 400 , 100, 150);
        labelOrange10.setSize(100, 150);
        getContentPane().add(labelOrange10);
        
        Icon arrow1 = new ImageIcon ("arrow.png");
        JButton Buttonarrow1 = new JButton (arrow1);
        Buttonarrow1.setBounds(890 , 20 , 70, 40);
        Buttonarrow1.setBorderPainted(false);
        Buttonarrow1.setBackground(new Color(253,250,243));
        getContentPane().add(Buttonarrow1);
        Buttonarrow1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
              
                setVisible(false);
                UI3_Selections ui3 = new UI3_Selections();
                ui3.go();}
        });  
        
        setSize(1200,700);
        setVisible(true);
        setLocation(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        super.setBackground(new Color(251,208,78));
 
    }
}