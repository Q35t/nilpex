
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.smart.SmartLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaStandardLookAndFeel;
import java.util.Properties;
import javax.swing.UIManager;
import view.ViewPrincipal;
import view.ViewSplash;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wellington
 */
public class Start {
    
    public static void main(String args[]){
        try {
			Properties props = new Properties();
			props.put("logoString", " ");
                        props.put("windowDecoration","");
			AluminiumLookAndFeel.setCurrentTheme(props);
                        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
                        //SmartLookAndFeel.setCurrentTheme(props);
			//UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
                        //TextureLookAndFeel.setCurrentTheme(props);
			//UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
                       //AluminiumLookAndFeel.setCurrentTheme(props);
                       //UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
                       //UIManager.setLookAndFeel(new SyntheticaStandardLookAndFeel());

	  
        } catch (Exception e) {
	  e.printStackTrace();
        }
        
        System.out.println(System.getProperty("os.name"));
        new ViewSplash().setVisible(true);

        
    }
    
}
