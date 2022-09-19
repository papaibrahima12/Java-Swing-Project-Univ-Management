package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.UIManager;

/**
 * cette classe permet de voir l'interface utilisateur
 */
public class UI {
    Object optionPaneBackground;
    Object PanelBackground;
    public UI(){
        optionPaneBackground = UIManager.get("OptionPane.background");
        PanelBackground = UIManager.get("Panel.background");
    }
    public void SetRed(){
        UIManager.put("OptionPane.background", Color.red);
        UIManager.put("Panel.background", Color.white);
        UIManager.put("Button.background", new Color(9,119,185));
        UIManager.put("Button.foreground", Color.white);
        UIManager.put("OptionPane.minimumSize", new Dimension(500,250));
        UIManager.put("OptionPane.messageFont", new Font("Arial",Font.BOLD,18));
        UIManager.put("OptionPane.buttonFont", new Font("Arial",Font.BOLD,18));
    }
    public void ResetUI(){
        UIManager.put("OptionPane.background",optionPaneBackground);
        UIManager.put("Panel.background", PanelBackground);
    }
}
