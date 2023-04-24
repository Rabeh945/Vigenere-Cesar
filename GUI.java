package SI_Projet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    TextArea result;
    JTextField textF = new JTextField();
    JTextField cleF = new JTextField();
    JButton cesarChiff,cesarDeChiff,vigChiff,vigDechiff;

    JButton [] fnBtn = new JButton[4];
    JPanel mainPanel;
    JPanel inputPanel,btnPanel,resultPanel;
    JPanel textPanel,clePanel,cesarBtnPanel,vigBtnPanel;
    public GUI(){
        Functions fn = new Functions();
        this.setVisible(true);
        this.setPreferredSize(new Dimension(598,750));
        this.setResizable(true);
        this.setTitle("SI Projet Khene Rabeh");


        //
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2,1));
        inputPanel.setPreferredSize(new Dimension(500,50));
        inputPanel.setBackground(Color.RED);
        textPanel = new JPanel();

        JLabel textL = new JLabel("Enter Text : ");
        textL.setFont(new Font(Font.SERIF, Font.ITALIC,  18));

        textF.setFont(new Font(Font.SERIF, Font.PLAIN,  23));
        textF.setPreferredSize(new Dimension(500,40));
        textPanel.add(textL);
        textPanel.add(textF);
        //
        clePanel = new JPanel();
        clePanel.setLayout(new FlowLayout());
        cleF = new JTextField();
        JLabel cleL = new JLabel("Enter Cle :  ");
        cleL.setFont(new Font(Font.SERIF, Font.ITALIC,  18));
        cleF.setFont(new Font(Font.SERIF, Font.PLAIN,  23));
        cleF.setPreferredSize(new Dimension(500,40));
        //
        ////////////////////////////////////Buttons/////////////////
        btnPanel = new JPanel();
        cesarBtnPanel = new JPanel();
        vigBtnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(1,2,10,15));
        cesarBtnPanel.setLayout(new GridLayout(2,1,10,15));
        vigBtnPanel.setLayout(new GridLayout(2,1,10,15));

        cesarChiff = new JButton("Cesar Chiffer");
        vigChiff = new JButton("Vigenere Chiffer");
        cesarDeChiff = new JButton("Cesar DeChiffer");
        vigDechiff = new JButton("Vigenere DeChiffer");
        fnBtn[0] = cesarChiff;
        fnBtn[1] = vigChiff;
        fnBtn[2] = cesarDeChiff;
        fnBtn[3] = vigDechiff;

        for (int i = 0 ; i <= fnBtn.length-1; i++){
            fnBtn[i].addActionListener(this);
            fnBtn[i].setBackground(Color.darkGray);
            fnBtn[i].setFont(new Font("Roboto",Font.BOLD,17));
            fnBtn[i].setForeground(Color.white);

        }


        result = new TextArea();
        result.setFont(new Font("",Font.PLAIN,16));
        //result.setSize(new Dimension(400,400));

        resultPanel = new JPanel();
        resultPanel.add(result);

        cesarBtnPanel.add(cesarChiff);
        cesarBtnPanel.add(cesarDeChiff);

        vigBtnPanel.add(vigChiff);
        vigBtnPanel.add(vigDechiff);

        btnPanel.add(cesarBtnPanel);
        btnPanel.add(vigBtnPanel);


        clePanel.add(cleL);
        clePanel.add(cleF);

        inputPanel.add(textPanel);
        inputPanel.add(clePanel);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3,1,15,15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,12,10,12));
        mainPanel.add(inputPanel);
        mainPanel.add(btnPanel);
        mainPanel.add(resultPanel);

        this.add(mainPanel);
        this.pack();


    }
    public boolean isString (){
        Boolean flag = true;
        for (int p =0 ; p <= cleF.getText().length()-1 ; p++){
            if (Character.isDigit(cleF.getText().charAt(p))){
                flag = false;
            }
        }
        return flag;
    }
    public boolean textIsString (){
        Boolean flag = true;
        for (int p =0 ; p <= textF.getText().length()-1 ; p++){
            if (Character.isDigit(textF.getText().charAt(p))){
                flag = false;
            }
        }
        return flag;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int i = 0 ;
        Functions fn = new Functions();
    if (!textF.getText().isEmpty() && !cleF.getText().isEmpty()) {
        /*if (e.getSource() == vigChiff && isString() && textIsString()) {
            result.setText(fn.Vigenere(textF.getText(), cleF.getText()));
        }*/
        if (e.getSource() == vigChiff ) {
            result.setText(fn.Vigenere2(textF.getText(), cleF.getText()));
        }
        if (e.getSource() == vigDechiff ) {
            result.setText(fn.VigenereD(textF.getText(), cleF.getText()));
        }
        if (e.getSource() == cesarChiff && !isString()) {
            result.setText(fn.cesar(textF.getText(), Integer.parseInt(cleF.getText())));
        }
        if (e.getSource() == cesarDeChiff && !isString()) {
            result.setText(fn.cesarD(textF.getText(), Integer.parseInt(cleF.getText())));
        }
        if (e.getSource() == cesarDeChiff && isString()) {
            JOptionPane.showMessageDialog(this, "يجب ان يكون Cle عبارة عن ارقام");
        }
        if (e.getSource() == cesarChiff && isString()) {
            JOptionPane.showMessageDialog(this, "يجب ان يكون Cle عبارة عن ارقام");
        }
        /*if (e.getSource() == vigChiff && isString() && !textIsString()) {
            JOptionPane.showMessageDialog(this, "يجب ان لايحتوي TEXT على ارقام");
        }
        if (e.getSource() == vigChiff && !isString() && textIsString()) {
            JOptionPane.showMessageDialog(this, "يجب ان لايحتوي Cle على ارقام");
        }
        if (e.getSource() == vigChiff && !isString() && !textIsString()) {
            JOptionPane.showMessageDialog(this, "يجب ان لايحتوي Cle و Text على ارقام");
        }
        if (e.getSource() == vigDechiff && isString() && !textIsString()) {
            JOptionPane.showMessageDialog(this, "يجب ان لايحتوي TEXT على ارقام");
        }
        if (e.getSource() == vigDechiff && !isString() && textIsString()) {
            JOptionPane.showMessageDialog(this, "يجب ان لايحتوي Cle على ارقام");
        }
        if (e.getSource() == vigDechiff && !isString() && !textIsString()) {
            JOptionPane.showMessageDialog(this, "يجب ان لايحتوي Cle و Text على ارقام");
        }*/
    }
    }
 }

