
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.w3c.dom.Text;

public class Main extends JFrame implements ActionListener {
    
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functiButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton, equButton, clrButton , DelButton, decButton;
    JPanel panel;
    double num1=0, num2=0, result=0;
    char operator;
    

    Main(){

        setTitle("Basic Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(new Font("Ink Free", Font.BOLD, 30));
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(textField);

        addButton = new JButton("+");
        addButton.setBackground(Color.blue);
        subButton = new JButton("-");
        subButton.setBackground(Color.blue);
        mulButton = new JButton("*");
        mulButton.setBackground(Color.blue);
        divButton = new JButton("/");
        divButton.setBackground(Color.blue);
        equButton = new JButton("=");
        equButton.setBackground(Color.green);
        decButton = new JButton(".");
        decButton.setBackground(Color.blue);
        clrButton = new JButton("C");
        clrButton.setBackground(Color.RED);
        DelButton = new JButton("Del");
        DelButton.setBackground(Color.ORANGE);

        functiButtons[0] = addButton;
        functiButtons[1] = subButton;
        functiButtons[2] = mulButton;
        functiButtons[3] = divButton;
        functiButtons[4] = equButton;
        functiButtons[5] = decButton;
        functiButtons[6] = clrButton;
        functiButtons[7] = DelButton;

        for(int i=0 ; i<8 ; i++){
            functiButtons[i].addActionListener(this);
            functiButtons[i].setFont(new Font("Ink Free", Font.BOLD, 30));
        }

        for(int i=0 ; i<10 ; i++){
            numberButtons[i] = new JButton(i+"");
            numberButtons[i].setFont(new Font("Ink Free", Font.BOLD, 30));
            numberButtons[i].setBackground(Color.white);
            numberButtons[i].addActionListener(this);
        }

        clrButton.setBounds(50,430,145,50);
        DelButton.setBounds(205,430,145,50);
       

        add(clrButton);
        add(DelButton);

        panel = new JPanel();
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBounds(50, 100, 300, 300);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 20));
        add(panel);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);


    }

   

    public static void main(String[] args) {
        Main m = new Main();
        m.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(int i=0 ; i<10 ; i++){
            if(e.getSource()== numberButtons[i]){
                textField.setText(textField.getText().concat(i+""));
            }
        }
        if(e.getSource()==decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()==addButton){
            num1=Double.parseDouble(textField.getText());
            operator='+';
            textField.setText("");
        }
        if(e.getSource()==subButton){
            num1=Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
        }
        if(e.getSource()==mulButton){
            num1=Double.parseDouble(textField.getText());
            operator='*';
            textField.setText("");
        }
        if(e.getSource()==divButton){
            num1=Double.parseDouble(textField.getText());
            operator='/';
            textField.setText("");
        }
        if(e.getSource()==equButton){
            num2=Double.parseDouble(textField.getText());
            switch(operator){
             case '+':
             result=num1+num2;
                break;
                case '-':
                result=num1-num2;
                break;
                case '*':
                result=num1*num2;
                break;
                case '/':
                if(num2!=0){
                    result=num1/num2;
                } else {
                    textField.setText("Error");
                    return;
                }
            }
            textField.setText(result+"");
        }
        if(e.getSource()==clrButton){
            textField.setText("");
            num1=0;
            num2=0;
            result=0;
            operator=' ';
        }
        if(e.getSource()==DelButton){
            String text = textField.getText();
            if(text.length()>0){
                textField.setText(text.substring(0, text.length()-1));
            }

        }


    }

}
