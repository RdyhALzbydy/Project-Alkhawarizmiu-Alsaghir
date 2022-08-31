
package projectadvancedprogramming;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class UI6_EXam extends JFrame implements ActionListener {
    
        Connection connection=null; PreparedStatement statement = null;//Connection of mysql
        public void Result() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");
             }
    	/*The serialVersionUID is a universal version identifier for a Serializable class.
        Deserialization uses this number to ensure that a loaded class corresponds exactly to a serialized object.
        If no match is found, then an InvalidClassException is thrown.*/
	private static final long serialVersionUID = 1L;

	JLabel label;
        JTextField idNumber;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[9];

	// create jFrame with radioButton and JButton
	UI6_EXam() {
		//super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
                
                JLabel labeID = new JLabel("أدخل رقم الهوية:");
                labeID.setFont(new Font("Time",Font.BOLD,20));
                labeID.setSize(400, 120);
                labeID.setLocation(680, 30);
                add(labeID);
                
                idNumber = new JTextField() ;//id number input of user 
                idNumber = new JTextField(10); 
                idNumber.setBackground(new Color(255,127,64));
                idNumber.setBounds(350 , 70 , 300, 40);
                idNumber.setFont(new Font("Time",Font.LAYOUT_RIGHT_TO_LEFT,20));
                idNumber.setHorizontalAlignment(SwingConstants.CENTER);
                add(idNumber);
                
                JLabel labe = new JLabel("اختر كم عدد الفواكة ");
                labe.setFont(new Font("Time",Font.BOLD,30));
                labe.setSize(400, 120);
                labe.setLocation(210, 150);
                add(labe);
                
                JLabel label = new JLabel(" في كل صورة؟");
                label.setFont(new Font("Time",Font.BOLD,30));
                label.setSize(400, 120);
                label.setLocation(250, 200);
                add(label);
                
                Icon arrow1 = new ImageIcon ("arrow.png");//An arrow to move to the master page UI3
                JButton Buttonarrow1 = new JButton (arrow1);
                Buttonarrow1.setBounds(890 , 20 , 70, 40);
                Buttonarrow1.setBorderPainted(false);
                Buttonarrow1.setBackground(new Color(253,250,243));
                add(Buttonarrow1);
                Buttonarrow1.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
              
                setVisible(false);
                UI3_Selections ui3 = new UI3_Selections();//An arrow to move to the master page UI3
                ui3.go();}
                });  
        
		btnNext = new JButton("التالي ");//Move to the next question
		btnBookmark = new JButton(" ");
		btnNext.addActionListener(this);
                btnNext.setBackground(new Color(57,106,80));
                btnNext.setFont(new Font("Time",Font.BOLD,25));
                btnNext.setForeground(new Color(253,242,214));
                btnNext.setBorderPainted(false);
		btnBookmark.addActionListener(this);
                btnBookmark.setBackground(new Color(57,106,80));
                btnBookmark.setFont(new Font("Time",Font.BOLD,25));
                btnBookmark.setForeground(new Color(253,242,214));
                btnBookmark.setBorderPainted(false);
		add(btnNext);
		add(btnBookmark);
		set();
                
                Icon icon4 = new ImageIcon ("image1.png");//image backgrund in page+Properties
                JLabel labelicon4 = new JLabel(icon4);
                labelicon4.setBounds(0 , 0 , 190, 430);
                labelicon4.setSize(190, 650);
                add(labelicon4);
        
                Icon icon5 = new ImageIcon ("image1.png");//image backgrund in page+Properties
                JLabel labelicon5 = new JLabel(icon5);
                labelicon5.setBounds(0 , 0 , 190, 430);
                labelicon5.setSize(2500, 650);
                add(labelicon5);
                
                Icon icon6 = new ImageIcon ("image3.png");//image backgrund in page+Properties
                JLabel labelicon6 = new JLabel(icon6);
                labelicon6.setBounds(0 , 0 , 1590, 430);
                labelicon6.setSize(1250, 650);
                add(labelicon6);
		
                //position option on the page
		radioButton[0].setBounds(240, 300, 150, 20);
		radioButton[1].setBounds(240, 340, 150, 20);
		radioButton[2].setBounds(240, 380, 150, 20);
		radioButton[3].setBounds(240, 420, 150, 20);
                 //position boutton next on the page
		btnNext.setBounds(400, 540, 120, 70);
                // //position boutton result on the page
		btnBookmark.setBounds(670, 540, 120, 70);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(350, 150);
		setVisible(true);
                super.setBackground(new Color(253,250,243));
		setSize(1200,700);
                
                
	}

	// handle all actions based on event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 8) {
				btnNext.setEnabled(false);
				btnBookmark.setText("النتائج");
			}
		}

		if (e.getActionCommand().equals("النتائج")) {
			if (check())
				count = count + 1;
			current++;//print the result in window 
			JOptionPane.showMessageDialog(this, "عدد الاجوبه الصحيحه من 9 هي  " + count);
                        setVisible(false);
                        UI3_Selections ui3 = new UI3_Selections();//After you are done, go to the main page
                        ui3.go();
                       datainsql();
                        
                        
		}
	}
        
        public void datainsql(){//Data to link databases to the test where the identity number and degree are stored
             try {
                 try (Connection connection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/results_of_exam?"
                         + "zeroDateTimeBehavior=convertToNull&serverTimezone=UTC", "root", "root")) {
                     System.out.println("Database connected");
                     String query ="INSERT INTO `results_of_exam`.`resultexam`" +"(`idNumber` ,`btnBookmark`)"+
                             "VALUES( '"  + idNumber.getText() +" ','"+ count+ "')" ;
                     statement = connection.prepareStatement(query);
                     statement.executeUpdate(query);
                     System.out.println("Successfully registered");
                 }
                        } catch (SQLException ex) {
                    ex.printStackTrace();
                        }
        }


	void set() {//Pictures (questions)-setIcon + 4 options-radioButton
		radioButton[4].setSelected(true);
		if (current == 0) {
                       label.setIcon(new ImageIcon(getClass().getResource("2.jpg")));
                       
			radioButton[0].setText(" ٠ ");
			radioButton[1].setText(" ٢ ");
			radioButton[2].setText(" ٤ ");
			radioButton[3].setText("  ٣ ");
		}
		if (current == 1) {
			label.setIcon(new ImageIcon(getClass().getResource("5.jpg")));
			radioButton[0].setText(" ٥ ");
			radioButton[1].setText(" ٣ ");
			radioButton[2].setText(" ٤ ");
			radioButton[3].setText("  ٧ ");
		}
		if (current == 2) {
			label.setIcon(new ImageIcon(getClass().getResource("8.jpg")));
                        radioButton[0].setText(" ٩ ");
			radioButton[1].setText(" ٨ ");
			radioButton[2].setText(" ٦ ");
			radioButton[3].setText("  ٧ ");
		}
		if (current == 3) {
		label.setIcon(new ImageIcon(getClass().getResource("6.jpg")));
		      radioButton[0].setText(" ٩ ");
			radioButton[1].setText(" ٨ ");
			radioButton[2].setText(" ٦ ");
			radioButton[3].setText("  ٧ ");
		}
		if (current == 4) {
			label.setIcon(new ImageIcon(getClass().getResource("1.jpg")));
		   	radioButton[0].setText(" ٠ ");
			radioButton[1].setText(" ٢ ");
			radioButton[2].setText(" ١ ");
			radioButton[3].setText("  ٣ ");
		}
		if (current == 5) {
			label.setIcon(new ImageIcon(getClass().getResource("9.jpg")));
		      radioButton[0].setText(" ٦  ");
			radioButton[1].setText(" ٨ ");
			radioButton[2].setText(" ١ ");
			radioButton[3].setText(" ٩");
		}
		if (current == 6) {
		label.setIcon(new ImageIcon(getClass().getResource("3.jpg")));
			radioButton[0].setText(" ٠ ");
			radioButton[1].setText(" ٣ ");
			radioButton[2].setText(" ١ ");
			radioButton[3].setText("  ٦ ");
		}
		if (current == 7) {
                    label.setIcon(new ImageIcon(getClass().getResource("7.jpg")));
                         radioButton[0].setText(" ٩ ");
			radioButton[1].setText(" ٨ ");
			radioButton[2].setText(" ٦ ");
			radioButton[3].setText("  ٧ ");
		}
		if (current == 8) {
		label.setIcon(new ImageIcon(getClass().getResource("4.jpg")));
                        radioButton[0].setText(" ٥ ");
			radioButton[1].setText(" ٣ ");
			radioButton[2].setText(" ٤ ");
			radioButton[3].setText("  ٧ ");
                        
		}
		//Image sizes and options
		label.setBounds(430, 180, 1000, 350);
                label.setSize(550, 300);
                
		for (int i = 0, j = 0; i <= 90; i += 40, j++)
			radioButton[j].setBounds(240, 300 + i, 150, 20);
             
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[1].isSelected());//The correct value Q1 in the index[1]
		if (current == 1)
			return (radioButton[0].isSelected());//The correct value Q2 in the index[0]
		if (current == 2)
			return (radioButton[1].isSelected());//The correct value Q3 in the index[1]
		if (current == 3)
			return (radioButton[2].isSelected());//The correct value Q4 in the index[2]
		if (current == 4)
			return (radioButton[2].isSelected());//The correct value Q5 in the index[2]
		if (current == 5)
			return (radioButton[3].isSelected());//The correct value Q6 in the index[3]
		if (current == 6)
			return (radioButton[1].isSelected());//The correct value Q7 in the index[1]
		if (current == 7)
			return (radioButton[3].isSelected());//The correct value Q8 in the index[3]
		if (current == 8)
			return (radioButton[2].isSelected());//The correct value Q9 in the index[2]
		
		return false;
	}
  
        public static void main(String s[]) {
	new UI6_EXam();
                
                
	}
}