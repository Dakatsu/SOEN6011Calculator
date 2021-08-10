package com.calculator.main;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


// TODO: Auto-generated Javadoc
/**
 * The Class SuperCalculator.
 */
public class SuperCalculator  extends JFrame{


		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;

		/** The text field input. */
		private static JTextField textFieldInput;

		/** The txt error. */
		private JTextField txtError;

		/** The button zero. */
		private JButton buttonZero;

		/** buttonOne. */
		private JButton buttonOne;

		/** buttonTwo. */
		private JButton buttonTwo;

		/** buttonThree. */
		private JButton buttonThree;

		/** buttonFour. */
		private JButton buttonFour;

		/** buttonFive. */
		private JButton buttonFive;

		/** buttonSix. */
		private JButton buttonSix;

		/** buttonSeven. */
		private JButton buttonSeven;

		/** buttonEight. */
		private JButton buttonEight;

		/** buttonNine. */
		private JButton buttonNine;

		/** button for subtraction. */
		private JButton buttonTangent;

		/** button for multiply. */
		private JButton buttonGamma;

		/** button for division. */
		private JButton buttonExponent;

		/** button for division. */
		private JButton buttonPower;

		/** button for the dot sign. */
		private JButton buttonDot;

		/** button for the equal sign. */
		private JButton buttonEqual;

		/** button for the back sign. */
		private JButton btnBack;

		/** label for arithmetic use. */
		private JLabel label;

		/** variable used in arithmeticOperation method. */
		double input;

		/** variable used in arithmeticOperation method. */
		double output;

		/** condition variables used in arithmeticOperation method. */
		int calculation;

		/** The power function. */
		PowerFunction powerFunction = new PowerFunction();
		
		/** The tangent function. */
		TangentFunction tangentFunction = new TangentFunction();
		

		/**
		 * The main method.
		 *
		 * @param args the arguments
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						SuperCalculator frame = new SuperCalculator();

						// textField get focus
						frame.addWindowFocusListener(new WindowAdapter() {
							public void windowGainedFocus(WindowEvent e) {
								textFieldInput.requestFocusInWindow();
							}
						});
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Checks if is negative integer for double.
		 *
		 * @param d the d
		 * @return true, if is negative integer for double
		 */
		public static boolean isNegativeIntegerForDouble(double d) {
			double eps = 1e-10;
			return d - Math.floor(d) < eps && d < 0;
		}

		/**
		 * Checks if is numeric.
		 *
		 * @param str the str
		 * @return true, if is numeric
		 */
		public static boolean isNumeric(String str) {
			String checkString;
			try {
				checkString = new BigDecimal(str).toString();
			} catch (Exception e) {
				return false;
			}
			return true;
		}


		/**
		 * Arithmetic operation.
		 *
		 * @param str the str
		 */
		public void arithmeticOperation(String str) {
			switch (calculation) {
			case 1:// Tangent
				String outputwer = tangentFunction.calculate(Double.parseDouble(str));
				textFieldInput.setText(outputwer);
				break;

			case 2:// SinH
				output = SinhLibraries.sinh(str);
				textFieldInput.setText(Double.toString(output));
				break;

			case 3:// Exponent
				output = input * Double.parseDouble(str);
				textFieldInput.setText(Double.toString(output));
				break;

			case 4:// Power
				output = powerFunction.calculate(input, Double.parseDouble(str));
				textFieldInput.setText(Double.toString(output));
				break;

			default:
				txtError.setText("Incorrect Choice");
				txtError.setVisible(true);
				break;
			}
		}

		/**
		 * Instantiates a new super calculator.
		 */
		public SuperCalculator() {
			setResizable(false);
			setFont(new Font("Dialog", Font.BOLD, 14));
			setTitle("Super Calculator");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(300, 300, 515, 415);
			getContentPane().setLayout(null);

			textFieldInput = new JTextField();
			textFieldInput.setHorizontalAlignment(SwingConstants.RIGHT);
			textFieldInput.setFont(new Font("Tahoma", Font.BOLD, 20));
			textFieldInput.setBounds(21, 35, 472, 35);
			textFieldInput.setBorder(null);	
			getContentPane().add(textFieldInput);
			textFieldInput.setColumns(10);
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			buttonDot = new JButton(".");
			buttonDot.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textFieldInput.setText(textFieldInput.getText() + ".");
				}
			});
			buttonDot.setFont(new Font("Tahoma", Font.BOLD, 20));
			buttonDot.setBounds(87, 290, 56, 35);
			getContentPane().add(buttonDot);
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			buttonZero = new JButton("0");
			buttonZero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textFieldInput.setText(textFieldInput.getText() + "0");
				}
			});
			buttonZero.setFont(new Font("Tahoma", Font.BOLD, 20));
			buttonZero.setBounds(21, 290, 56, 35);
			getContentPane().add(buttonZero);
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			buttonOne = new JButton("1");
			buttonOne.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textFieldInput.setText(textFieldInput.getText() + "1");
				}
			});
			buttonOne.setFont(new Font("Tahoma", Font.BOLD, 20));
			buttonOne.setBounds(21, 235, 56, 35);
			getContentPane().add(buttonOne);
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			buttonTwo = new JButton("2");
			buttonTwo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textFieldInput.setText(textFieldInput.getText() + "2");
				}
			});
			buttonTwo.setFont(new Font("Tahoma", Font.BOLD, 20));
			buttonTwo.setBounds(87, 235, 56, 35);
			getContentPane().add(buttonTwo);
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			buttonThree = new JButton("3");
			buttonThree.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textFieldInput.setText(textFieldInput.getText() + "3");
				}
			});
			buttonThree.setFont(new Font("Tahoma", Font.BOLD, 20));
			buttonThree.setBounds(153, 235, 56, 35);
			getContentPane().add(buttonThree);
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			buttonFour = new JButton("4");
			buttonFour.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textFieldInput.setText(textFieldInput.getText() + "4");
				}
			});
			buttonFour.setFont(new Font("Tahoma", Font.BOLD, 20));
			buttonFour.setBounds(21, 187, 56, 35);
			getContentPane().add(buttonFour);
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			buttonFive = new JButton("5");
			buttonFive.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textFieldInput.setText(textFieldInput.getText() + "5");
				}
			});
			buttonFive.setFont(new Font("Tahoma", Font.BOLD, 20));
			buttonFive.setBounds(87, 187, 56, 35);
			getContentPane().add(buttonFive);
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			buttonSix = new JButton("6");
			buttonSix.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textFieldInput.setText(textFieldInput.getText() + "6");
				}
			});
			buttonSix.setFont(new Font("Tahoma", Font.BOLD, 20));
			buttonSix.setBounds(153, 187, 56, 35);
			getContentPane().add(buttonSix);
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			buttonSeven = new JButton("7");
			buttonSeven.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textFieldInput.setText(textFieldInput.getText() + "7");
				}
			});
			buttonSeven.setFont(new Font("Tahoma", Font.BOLD, 20));
			buttonSeven.setBounds(21, 141, 56, 35);
			getContentPane().add(buttonSeven);
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			buttonEight = new JButton("8");
			buttonEight.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textFieldInput.setText(textFieldInput.getText() + "8");
				}
			});
			buttonEight.setFont(new Font("Tahoma", Font.BOLD, 20));
			buttonEight.setBounds(87, 141, 56, 35);
			getContentPane().add(buttonEight);
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			buttonNine = new JButton("9");
			buttonNine.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textFieldInput.setText(textFieldInput.getText() + "9");
				}
			});
			buttonNine.setFont(new Font("Tahoma", Font.BOLD, 20));
			buttonNine.setBounds(153, 141, 56, 35);
			getContentPane().add(buttonNine);
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			buttonTangent = new JButton("Tan");
			buttonTangent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					// clear error message
					txtError.setVisible(false);

					// get focus
					textFieldInput.requestFocus();
					String str = textFieldInput.getText();

					// Check whether it is empty, else if Check if it is a number,else not a number
					if (isNumeric(str)) {
						input = Double.parseDouble(textFieldInput.getText());
						calculation = 1;
						label.setText(" Tan(" + input + ")");
						arithmeticOperation(textFieldInput.getText());
					} else {
						txtError.setText("please input a real number except negative integer");
						txtError.setVisible(true);
					}
				}
			});
			buttonTangent.setFont(new Font("Tahoma", Font.BOLD, 15));
			buttonTangent.setBounds(395, 141, 106, 35);
			getContentPane().add(buttonTangent);
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			buttonGamma = new JButton("SinH");
			buttonGamma.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					// clear error message
					txtError.setVisible(false);

					// get focus
					textFieldInput.requestFocus();
					String str = textFieldInput.getText();

					// Check whether it is empty, else if Check if it is a number,else not a number
					if (str.contains(" ") || str.equals("")) {
						txtError.setText("please input a real number except negative integer");
						txtError.setVisible(true);
					} 
					else {
						try {
							calculation = 2;
							arithmeticOperation(textFieldInput.getText());
							input = Double.parseDouble(textFieldInput.getText());
							label.setText(" SinH(" + input + ")");
						} catch (NumberFormatException ex) {
							txtError.setText("please input a real number");
							txtError.setVisible(true);
						}
					} 
				}
			});
			buttonGamma.setFont(new Font("Tahoma", Font.BOLD, 15));
			buttonGamma.setBounds(229, 141, 155, 35);
			getContentPane().add(buttonGamma);
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			buttonExponent = new JButton("Exponent-ab^y");
			buttonExponent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// If the input is a number
					if (isNumeric(textFieldInput.getText())) {
						input = Double.parseDouble(textFieldInput.getText());
						calculation = 3;
						textFieldInput.setText("");
						label.setText(input + "^");
					} else {
						txtError.setText("please input a real number except negative integer");
						txtError.setVisible(true);
					}
				}
			});
			buttonExponent.setFont(new Font("Tahoma", Font.BOLD, 15));
			buttonExponent.setBounds(229, 189, 155, 35);
			getContentPane().add(buttonExponent);
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			buttonPower = new JButton("Power-^");
			buttonPower.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// If the input is a number
					if (isNumeric(textFieldInput.getText())) {
						input = Double.parseDouble(textFieldInput.getText());
						calculation = 4;
						textFieldInput.setText("");
						label.setText(input + "^");
					} else {
						txtError.setText("please input a real number except negative integer");
						txtError.setVisible(true);
					}
				}
			});
			buttonPower.setFont(new Font("Tahoma", Font.BOLD, 15));
			buttonPower.setBounds(395, 189, 106, 35);
			getContentPane().add(buttonPower);
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			buttonEqual = new JButton("=");
			buttonEqual.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtError.setText("");
					// if the textfield value is a real number
					if (isNumeric(textFieldInput.getText())) {
						String str = textFieldInput.getText();
						textFieldInput.setText("");
						arithmeticOperation(str);
						label.setText("");
					} else {
						txtError.setText("please enter a value >= 0");
						txtError.setVisible(true);
					}
				}
			});
			buttonEqual.setBounds(153, 290, 204, 35);
			getContentPane().add(buttonEqual);
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			JButton btnClear = new JButton("Clear");
			// Add action to the clear button
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					label.setText("");
					textFieldInput.setText("");
					textFieldInput.requestFocus();
					textFieldInput.setText("");
					txtError.setVisible(false);
				}
			});
			btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnClear.setBounds(21, 82, 72, 45);
			getContentPane().add(btnClear);
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int length = textFieldInput.getText().length();
					int number = textFieldInput.getText().length() - 1;
					if (length > 0) {
						StringBuilder sbBuilder = new StringBuilder(textFieldInput.getText());
						sbBuilder.deleteCharAt(number);
						textFieldInput.setText(sbBuilder.toString());
					}
				}
			});
			btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnBack.setBounds(103, 82, 72, 45);
			getContentPane().add(btnBack);
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			txtError = new JTextField();
			txtError.setVisible(false);
			txtError.setBorder(null);
			txtError.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtError.setEditable(false);
			txtError.setText("Negative integer is not acceptable, try other numbers");
			txtError.setBounds(21, 335, 515, 34);
			getContentPane().add(txtError);
			txtError.setColumns(10);
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			label = new JLabel("");
			label.setFont(new Font("Tahoma", Font.BOLD, 15));
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setForeground(new Color(192, 57, 43));
			label.setBounds(335, 11, 128, 25);
			getContentPane().add(label);
		}
	}

