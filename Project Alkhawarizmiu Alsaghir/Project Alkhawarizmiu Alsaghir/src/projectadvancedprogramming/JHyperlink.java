
package projectadvancedprogramming;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
 
import javax.swing.JLabel;
import javax.swing.JOptionPane;
 
// This class extends and can be used like a JLable and provides a clickable text in order to navigate to a Link

public class JHyperlink extends JLabel {
    private String url;
    private String html = "<html><a href=''>%s</a></html>";//link html 
     
    public JHyperlink(String text) {       
        this(text, null, null);
    }
     
    public JHyperlink(String text, String url) {
        this(text, url, null);
    }
     
    public void setURL(String url) {
        this.url = url;
    }  
     
    public JHyperlink(String text, String url, String tooltip) {
        super(text);
        this.url = url;
         
        setForeground(Color.ORANGE.darker());
        setBackground(new Color(255,127,64));       
        setToolTipText(tooltip);       
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
         
        addMouseListener(new MouseAdapter() {
             //ظهور حدث عند تمرير الماوس (نص)
            @Override
            public void mouseEntered(MouseEvent e) {
                setText(String.format(html, text));
            }
             
            @Override
            public void mouseExited(MouseEvent e) {
                setText(text);
            }
             
            @Override
            public void mouseClicked(MouseEvent e) {//لفتح الرابط واذا الرابط غير صالح يطبع الجمله 
                try {
                     
                    Desktop.getDesktop().browse(new URI(JHyperlink.this.url));
                     
                } catch (IOException | URISyntaxException e1) {
                    JOptionPane.showMessageDialog(JHyperlink.this,
                            "Could not open the hyperlink. Error: " + e1.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }              
            }
             
        });
         
    }
}