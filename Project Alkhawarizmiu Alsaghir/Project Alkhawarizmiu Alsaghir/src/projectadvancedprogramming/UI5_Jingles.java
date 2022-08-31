
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
import javax.swing.SwingUtilities;

public class UI5_Jingles extends JFrame{
    
    //تعريف المتغيرات
    private JHyperlink zero = new JHyperlink("الأنشودة الأولى");
    private JHyperlink one = new JHyperlink("الأنشودة الثانية");
    private JHyperlink two = new JHyperlink("الأنشودة الثالثة");
    
    public UI5_Jingles() throws HeadlessException {
        setTitle("لتعلم الارقام ");
        setLayout(null);
  //اضافة للمتغير  الرابط والاسم واضافة له خصائص 
         // the links
        zero.setURL("https://youtu.be/gr3XKopIsVA");
        zero.setToolTipText("سيتم تحويلك لليوتيوب للتعلم من الأنشودة الأولى");
        zero.setBounds(680, 230, 10, 10);
        zero.setSize(200, 100);
        zero.setForeground(new Color(253,242,214));
        zero.setFont(new Font("Time",Font.BOLD,40));

        one.setURL("https://youtu.be/LlpwFIkwl2A");
        one.setToolTipText("سيتم تحويلك لليوتيوب للتعلم من الأنشودة الثانية");
        one.setBounds(320, 230, 10, 10);
        one.setSize(200, 100);
        one.setForeground(new Color(253,242,214));
        one.setFont(new Font("Time",Font.BOLD,40));
        
         two.setURL("https://youtu.be/knXXvL1bOAM");
        two.setToolTipText("سيتم تحويلك لليوتيوب للتعلم من الأنشودة الثالثة");
        two.setBounds(500, 430, 10, 10);
        two.setSize(200, 100);
        two.setForeground(new Color(253,242,214));
        two.setFont(new Font("Time",Font.BOLD,40));      
        
       //line one 
        getContentPane().add(two);
        getContentPane().add(one);
        getContentPane().add(zero);
        
        getContentPane().setBackground(new Color(253,250,243));
        
        JLabel label1 = new JLabel("اختر يا صغيري الأنشودة التي تريد التعلم منها");
        label1.setFont(new Font("Time",Font.BOLD,40));
        label1.setSize(600, 120);
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
        labelOrange1.setBounds(630 , 200 , 300, 150);
        labelOrange1.setSize(300, 150);
        getContentPane().add(labelOrange1);
        
        Icon Orange2 = new ImageIcon ("image2.png");
        JLabel labelOrange2 = new JLabel(Orange2);
        labelOrange2.setBounds(270 , 200 , 100, 150);
        labelOrange2.setSize(300, 150);
        getContentPane().add(labelOrange2);
        
        Icon Orange3 = new ImageIcon ("image2.png");
        JLabel labelOrange3 = new JLabel(Orange3);
        labelOrange3.setBounds(450 , 400 , 100, 150);
        labelOrange3.setSize(300, 150);
        getContentPane().add(labelOrange3);
        
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
