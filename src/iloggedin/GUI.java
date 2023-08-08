package iloggedin;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    JTextArea ta = new JTextArea();
    Save saveAs;
    Open openAs = new Open(this);

    public GUI() {
        saveAs = new Save(this);
    }
    public void graphicalUser(){
        //Creating the Frame
        JFrame frame = new JFrame("Notes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(openAs);
        JMenuItem save = new JMenuItem("Save As");
        save.addActionListener(saveAs);
        JMenuItem commands = new JMenuItem("Commands");
        m1.add(open);
        m1.add(save);
        m2.add(commands);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter text");
        //adding text field and all the buttons it comes with
        JTextField tf = new JTextField();
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label);
        panel.add(tf);
        panel.add(send);
        panel.add(reset);
        //reset and send logic (I feel like putting em here as they're just one line really
        reset.addActionListener(e -> tf.setText(""));
        send.addActionListener(e -> ta.append(tf.getText() + "\n"));
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
    }
}
