package iloggedin;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
public class Save implements ActionListener{

    GUI guiMain;
    public Save(GUI parentGUI){
        guiMain = parentGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "TXT", "txt");
        fileChooser.setFileFilter(filter);
        int userSelection = fileChooser.showSaveDialog(fileChooser.getParent());
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (file == null) {
                return;
            }
            if (!file.getName().toLowerCase().endsWith(".txt")) {
                file = new File(file.getParentFile(), file.getName() + ".txt");
            }
            try {
                guiMain.ta.write(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
                Desktop.getDesktop().open(file);
            } catch (Exception x) {
                x.printStackTrace();
            }

        }
    }
}