package iloggedin;


import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;
import java.awt.*;

public class GUI extends JFrame {
    Open openAs;
    StatusLine statusLine;
    Save saveAs;
    private static JTextArea lines;


    public GUI() {
        saveAs = new Save(this);
        statusLine = new StatusLine(this);
        openAs = new Open(this);
    }
    JTextArea ta = new JTextArea();
    JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JFrame frame = new JFrame("Notes");

    public void graphicalUser(){
        //Creating the Frame
        JPanel statusPanel = new JPanel();
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
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        frame.add(statusPanel, BorderLayout.SOUTH);
        statusPanel.setPreferredSize(new Dimension(frame.getWidth(), 16));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        JLabel statusLabel = new JLabel();
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

        statusBar.setBorder(new CompoundBorder(new LineBorder(Color.DARK_GRAY), new EmptyBorder(5, 6, 6, 2)));
        statusLine.Charcounter();

        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.getContentPane().add(BorderLayout.SOUTH, statusBar);
        frame.setVisible(true);
    }
    public void createAndShowGUI(){
        JScrollPane jsp = new JScrollPane();
        lines = new JTextArea("1");
        lines.setEditable(false);
        ta.getDocument().addDocumentListener(new DocumentListener()    {
            public String getText(){
                int caretPosition = ta.getDocument().getLength();
                Element root = ta.getDocument().getDefaultRootElement();
                StringBuilder text = new StringBuilder("1" + System.getProperty("line.separator"));
                for(int i = 2; i < root.getElementIndex(caretPosition) + 2; i++){
                    text.append(i).append(System.getProperty("line.separator"));
                }
                return text.toString();
            }
            @Override
            public void changedUpdate(DocumentEvent de) {
                lines.setText(getText());
            }

            @Override
            public void insertUpdate(DocumentEvent de) {
                lines.setText(getText());
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                lines.setText(getText());
            }

        });

        jsp.getViewport().add(ta);
        jsp.setRowHeaderView(lines);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.getContentPane().add(jsp);
    }
}
