import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Calculator implements ActionListener{

	JFrame frame;
	JTextField textField;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subButton, multButton, divButton;
	JButton equalButton, decButton, delButton, clearButton, negButton;
	JPanel panel;
	
	Font font = new Font("Arial", Font.ITALIC, 28);
	
	double num1=0, num2=0,result=0;
	char operator;
	
	
	Calculator(){
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(50, 25, 300, 50);
		textField.setFont(font);
		textField.setEditable(false);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		multButton = new JButton("x");
		divButton = new JButton("/");
		equalButton = new JButton("=");
		decButton = new JButton(".");
		delButton = new JButton("DEL");
		clearButton = new JButton("CLR");
		negButton = new JButton("(-)");

		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = multButton;
		functionButtons[3] = divButton;
		functionButtons[4] = equalButton;
		functionButtons[5] = decButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clearButton;
		functionButtons[8] = negButton;

		
		for(int i=0; i<9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setFont(font);
		}
		
		for(int i=0; i<10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFocusable(false);
			numberButtons[i].setFont(font);
		}

		negButton.setBounds(50, 410, (int) 67.5, (int)67.5);
		delButton.setBounds((int)127.5, 410,(int) 106.25,(int) 67.5);
		clearButton.setBounds((int) 243.75, 410,(int) 106.25, (int)67.5);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));

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
		panel.add(multButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equalButton);
		panel.add(divButton);

		
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clearButton);
		frame.add(textField);
		frame.setVisible(true);
		
		
	}
	
	public static void main (String args[]) {
		
		Calculator calc = new Calculator();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for(int i=0; i<10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decButton) {
			textField.setText(textField.getText().concat("."));
			
		}
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText(null);
		}
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText(null);
		}
		if(e.getSource() == multButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText(null);
		}
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText(null);
		}
		if(e.getSource() == equalButton) {
			num2 = Double.parseDouble(textField.getText());
			switch(operator) {
			case'+':
				result = num1 + num2;
				break;
			case'-':
				result = num1 - num2;
				break;
			case'*':
				result = num1 * num2;
				break;
			case'/':
				result = num1 / num2;
				break;
			
			}
			textField.setText(String.valueOf(result));
			num1 = result;
		}
		if(e.getSource() == clearButton) {
			textField.setText(null);
		}
		if(e.getSource() == delButton) {
			String string = textField.getText();
			textField.setText(null);
			for(int i =0; i<string.length()-1; i++) {
				textField.setText(textField.getText()+string.charAt(i));
			}
			
		}
		if(e.getSource() == negButton) {
			double temp = Double.parseDouble(textField.getText());
			temp *=-1;
			textField.setText(String.valueOf(temp));
		}
		
		
	}
	
}
