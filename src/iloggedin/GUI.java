package iloggedin;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GUI extends JFrame {

    Open openAs;
    Counters counters;
    Save saveAs;

    public GUI() {
        saveAs = new Save(this);
        counters = new Counters(this);
        openAs = new Open(this);
    }
    JTextArea ta = new JTextArea();
    JSeparator separator = new JSeparator(SwingConstants.VERTICAL);

    JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));

    public void graphicalUser(){
        //Creating the Frame
        JFrame frame = new JFrame("Notes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Edit");
        JMenu m3 = new JMenu("Format");
        JMenu m4 = new JMenu("View");
        JMenu m5 = new JMenu("help");
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        mb.add(m4);
        mb.add(m5);
        JPanel statusPanel = new JPanel();
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        frame.add(statusPanel, BorderLayout.SOUTH);
        statusPanel.setPreferredSize(new Dimension(frame.getWidth(), 16));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        JLabel statusLabel = new JLabel("status");
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);


        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(openAs);
        JMenuItem save = new JMenuItem("Save As");
        save.addActionListener(saveAs);
        JMenuItem commands = new JMenuItem("Commands");
        m1.add(open);
        m1.add(save);
        m2.add(commands);
        JPanel panel = new JPanel();

        statusBar.setBorder(new CompoundBorder(new LineBorder(Color.DARK_GRAY), new EmptyBorder(5, 6, 6, 6)));
        counters.Charcounter();

        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.getContentPane().add(BorderLayout.SOUTH, statusBar);
        frame.setVisible(true);
    }
}
