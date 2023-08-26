package iloggedin;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class Open implements ActionListener {
    GUI guiMain;
    public Open(GUI parentGUI){
        guiMain = parentGUI;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser c = new JFileChooser();
        FileNameExtensionFilter f = new FileNameExtensionFilter("txt", "TXT", "txt");
        c.setFileFilter(f);
        int selection = c.showOpenDialog(c.getParent());
        if(selection == JFileChooser.APPROVE_OPTION){
            File file = c.getSelectedFile();
            if(file == null){
                return;
            }
            try {
                FileReader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);
                guiMain.ta.read( br, null );
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }
    }
}
