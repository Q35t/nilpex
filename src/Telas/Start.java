
package Telas;


import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import java.util.Properties;
import javax.swing.UIManager;

public class Start {
    public static void main (String[]args){
        
    
    try{
            Properties props = new Properties();
            props.put("logoString", " ");
            AluminiumLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            
           new ViewCadPrincipal().setVisible(true);
        }catch(Exception e){
            
        }
}
}