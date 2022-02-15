package View;

import Controller.Controller;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;


public class View {

    //GUI________________________________________________________________________________
    private final int WINDOW_WIDTH = 200;
    private final int WINDOW_HEIGHT = 300;

    private JFrame frame1;
    private JLabel label1;
    private JLabel label2;

    private JLabel labelEmpty;

    private JButton button1;

    private JTextField textfield1;
    private static JTextField textfield2;

    private JPanel panel1;

    public static void main(String[] args) {
        new View().GUI_Create();
    }
    public View() {

        frame1 = new JFrame("Frame");

        label1 = new JLabel("Sciezka dostepu do pliku", SwingConstants.CENTER);
        label2 = new JLabel("Wynik", SwingConstants.CENTER);

        labelEmpty = new JLabel();

        textfield1 = new JTextField(15);

        textfield2 = new JTextField(15);

        panel1 = new JPanel();

        button1 = new JButton("JButton");

    }


    public void GUI_Create() {

        frame1.getContentPane().add(BorderLayout.CENTER, panel1);

        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        //Row1
        panel1.add(label1); //Column 1
        panel1.add(textfield1); //Column 2

        //Row2
        panel1.add(label2); //Column 1
        panel1.add(textfield2); //Column 2


        //Row4
        panel1.add(button1); //Column 1
        panel1.add(labelEmpty); //Column 2

        button1.addActionListener(new Button1_Action());

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        frame1.setLocationRelativeTo(null);
        frame1.pack();
        frame1.setVisible(true);
    }


    //Actions
    class Button1_Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String row = "";
            String sciezka = textfield1.getText();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(sciezka));

                while((row = reader.readLine()) != null) {
                    Controller.setRowValueFromView(row);
                    Thread.sleep(100);
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }

            //Controller.setRowValueFromView(sciezka);
        }

    }

    //Set text______________________________________________
    public static void setTextfield2_Text(String result) {
        textfield2.setText(result);
    }

    //_____________________________________________________
}

