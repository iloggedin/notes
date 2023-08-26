package iloggedin;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Counters {
    GUI guiMain;
    public Counters(GUI parentGUI){
        guiMain = parentGUI;
    }

    public void Charcounter(){
        final JLabel chars = new JLabel();
        JLabel words = new JLabel();
        words.setText("Words: ");
        chars.setText("Characters: ");
        guiMain.ta.getDocument().addDocumentListener(new DocumentListener() {
        public void changedUpdate(DocumentEvent e) {
            update();
        }

        public void removeUpdate(DocumentEvent e) {
            update();
        }

        public void insertUpdate(DocumentEvent e) {
            update();
        }
        public void update() {
            chars.setText("Characters: " + guiMain.ta.getText().replace(" ", "").length());
            words.setText("words: " + guiMain.ta.getText().split("\\s+").length);
            guiMain.statusBar.add(chars);
            guiMain.statusBar.add(guiMain.separator);
            guiMain.statusBar.add(words);
        }
    });
}
}