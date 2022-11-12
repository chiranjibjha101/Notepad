import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.*;

public class notepad1 implements ActionListener {
    JFrame frame;
    JTextArea textArea;
    JMenuBar menuBar;
    notepad1(){
        //frame
        frame=new JFrame("Text Editor");
        frame.setVisible(true);
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //text Area
        textArea=new JTextArea();
        frame.add(textArea);
        //menu bar
        menuBar=new JMenuBar();
        //menu
        JMenu file=new JMenu("File");
        JMenu edit =new JMenu("Edit");
        //file menu items
        JMenuItem openFile=new JMenuItem("Open file");
        JMenuItem saveFile=new JMenuItem("Save file");
        JMenuItem printFile=new JMenuItem("Print file");
        JMenuItem newFile=new JMenuItem("New file");
        file.add(openFile);
        file.add(saveFile);
        file.add(printFile);
        file.add(newFile);
        //file menu action
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        printFile.addActionListener(this);
        newFile.addActionListener(this);
        //edit menu
        JMenuItem copy=new JMenuItem("Copy");
        JMenuItem cut=new JMenuItem("Cut");
        JMenuItem paste=new JMenuItem("Paste");
        JMenuItem close=new JMenuItem("Close");
        edit.add(copy);
        edit.add(paste);
        edit.add(close);
        edit.add(cut);
        //edit menu action
        copy.addActionListener(this);
        paste.addActionListener(this);
        close.addActionListener(this);
        cut.addActionListener(this);

        //adding menu bar to frame
        menuBar.add(file);
        menuBar.add(edit);
        frame.add(menuBar);
        frame.setJMenuBar(menuBar);
    }
    public static void main(String args[]) {
        notepad1 notepad=new notepad1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String call=e.getActionCommand();
        if(call=="Copy"){
            textArea.copy();
        }
        else if (call=="Cut") {
            textArea.cut();
        }
        else if (call=="Paste") {
            textArea.paste();
        }
        else if (call=="New File") {
            textArea.setText("");
        }
        else if (call=="Close") {
            frame.setVisible(false);
        }
        else if (call=="Save file") {
            JFileChooser jFileChooser=new JFileChooser("C:");
            int ans=jFileChooser.showOpenDialog(null);
            if(ans==jFileChooser.APPROVE_OPTION){
                File files= new File(jFileChooser.getSelectedFile().getAbsolutePath());
                BufferedWriter writer=null;
                try {
                    writer=new BufferedWriter(new FileWriter(files,false));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    writer.write(textArea.getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    writer.flush();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    writer.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        else if (call =="Open file") {
            JFileChooser jFileChooser1=new JFileChooser("C:");
            int ans=jFileChooser1.showOpenDialog(null);
            if(ans==JFileChooser.APPROVE_OPTION);
            {
                File file=new File(jFileChooser1.getSelectedFile().getAbsolutePath());
                String s1="",s2="";
                try {
                    BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
                    s2=bufferedReader.readLine();
                    while ((s1=bufferedReader.readLine())!=null){
                        s2+=s1+"\n";
                    }
                    textArea.setText(s2);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        else if (call=="Print file") {
            try {
                textArea.print();
            } catch (PrinterException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}

