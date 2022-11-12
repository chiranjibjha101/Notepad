import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstSession implements ActionListener {
    JFrame frame;
    JTextArea myarea;
    JButton button;
    FirstSession()
    {
        // Creating frame
        frame=new JFrame("First Session");
        frame.setBounds(250,250,300,300);
        frame.setBackground(Color.black);
        frame.getContentPane().setBackground(Color.black);
        // creating button
        button=new JButton("Click");
        button.setBounds(120,20,50,20);
        // adding function to the button
        button.addActionListener(this);
        // Creating my text area
        myarea=new JTextArea("Welcome to the TextArea");
        myarea.setBounds(50,50,200,200);
        myarea.setBackground(Color.RED);
        //adding button to my frame
        frame.add(button);
        // adding textArea to frame
        frame.add(myarea);
        // rest of these are just frame stuff
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String arg[])
    {
        FirstSession object=new FirstSession();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}