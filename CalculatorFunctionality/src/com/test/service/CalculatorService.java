package src.com.test.service;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import src.com.test.service.Layout;

public class CalculatorService extends JFrame {

	Layout layout = Layout.getLayout();

	private static CalculatorService calService = new CalculatorService();
	private JTextField jTextField;
	private JButton jButton[] = new JButton[200];
	private JButton jButtonoperator[] = new JButton[100];
	private JButton jButtn = new JButton();
	private String[] specialSymbolArray = { "<<<<", "(", ")", "^", "CE", "/", "*", "-", "+", "=", "." };

	private int totalNumeric = layout.getnumberofoperand();
	private int numberofoperand = layout.getnumberofoperand();
	private int hightofbutton = layout.gethightofbutton();
	private int widthofbutton = layout.getwidthofbutton();
	private int hightoftextfild = layout.gethightoftextfild();
	private int widthoftextfild = layout.getwidthoftextfild();
	
	private int hight = layout.gethight();

	static int numberofoperator = 10;

	private CalculatorService() {
		super("GARG's");
	}

	public static CalculatorService getInstance() {
		return calService;
	}

	public JTextField getTextField() {
		return jTextField;
	}

	public void setTextField(JTextField jTextField) {
		this.jTextField = jTextField;
	}

	public JButton[] getButton() {
		return jButton;
	}

	public JButton[] getButtonoperator() {
		return jButtonoperator;
	}

	public JButton getjbutton() {
		return jButtn;
	}

	//ComutationService qqqq = new ComutationService();
	String s = new String();
	ActionListenerService actionListener = new ActionListenerService();

	private static final long serialVersionUID = 1L;

	public void setLayouts() {
		setLayout(null);

		jTextField = new JTextField("");

		// Create Numeric Buttons
		int buttonNumber = 0;
		for (int count = 0; count <= totalNumeric; count++) {
			jButton[buttonNumber++] = new JButton(String.valueOf(count)); // create button object
		}

		// Set Symbols
		buttonNumber = 0;
		for (String symbol : specialSymbolArray) {
			jButtonoperator[buttonNumber++] = new JButton(symbol);
		}
		jButton[0].setBounds(0, hight - (2 * hightofbutton), widthofbutton * 2, hightofbutton);
		jButtonoperator[10].setBounds(widthofbutton * 2, hight - 2 * hightofbutton, widthofbutton, hightofbutton);
		jButtonoperator[8].setBounds(3 * widthofbutton, hightoftextfild + 2 * hightofbutton, widthofbutton,
				(hightofbutton * (1 + (numberofoperand / 3) + layout.gettemp())) / 2);
		jButtonoperator[9].setBounds(3 * widthofbutton,
				hight - ((hightofbutton * (1 + (numberofoperand / 3) + layout.gettemp())) / 2) - hightoftextfild,
				widthofbutton, (hightofbutton * (1 + (numberofoperand / 3) + layout.gettemp())) / 2);
		int temp = numberofoperand;
		int j, i;
		if (layout.gettemp() != 0) {
			for (i = 0; temp % 3 != 0; i++) {
				temp--;
			
			}
			temp++;
		} else {
			temp = temp - 2;
		}

		for (i = 0; i < (numberofoperand / 3) + layout.gettemp(); i++) {

			if (layout.gettemp() != 0) {

				for (j = 0; j < 3; j++) {
					if (temp <= numberofoperand) {
						jButton[temp].setBounds(j * widthofbutton,
								hightoftextfild + (2 * hightofbutton) + (i * hightofbutton), widthofbutton,
								hightofbutton);
						temp++;
					} else {
						break;
					}
				}
				temp = temp - j;
				temp = temp - 3;
			} else {

				for (j = 0; j < 3; j++) {

					jButton[temp].setBounds(j * widthofbutton,
							hightoftextfild + (2 * hightofbutton) + (i * hightofbutton), widthofbutton, hightofbutton);
					temp++;

				}

				temp = temp - 6;

			}
		}

		buttonNumber = 0;
		for (i = 0; i < 2; i++) {
			for (j = 0; j < 4; j++) {
				jButtonoperator[buttonNumber++].setBounds(j * widthofbutton, (hightoftextfild) + (i * hightofbutton),
						widthofbutton, hightofbutton);
			}
		}
		for (int count = 0; count < 11; count++) {
			add(jButtonoperator[count]);
			jButtonoperator[count].addActionListener(actionListener);
		}
		// jButtonoperator[8].setBounds();
		jTextField.setBounds(0, 0, widthoftextfild, hightoftextfild);
		add(jTextField);

		add(jTextField);

		for (int count = 0; count < totalNumeric + 1; count++) // add object and call action listener
		{
			add(jButton[count]);
			jButton[count].addActionListener(actionListener);
		}
	}
}
