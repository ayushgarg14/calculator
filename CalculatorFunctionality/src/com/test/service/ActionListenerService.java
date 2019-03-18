package src.com.test.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ActionListenerService  implements ActionListener {

	public void actionPerformed(ActionEvent e) {

		CalculatorService cal = CalculatorService.getInstance();
		final JTextField jTextField = cal.getTextField();
		String textField = new String();

		textField = jTextField.getText();

		String textonbutton = e.getActionCommand();

		if (textonbutton.equals("=")) {

			textField = textField + ")";
			ComutationService computationService = new ComutationService();
			textField = computationService.computeString(textField);

		} else if (textonbutton.equals("CE")) {
			textField = "";
		} else if (textonbutton.equals("<<<<")) {
			if (textField.equals("")) {
			} else {
				textField = textField.substring(0, textField.length() - 1);
			}
		} else {
			textField = textField + textonbutton;
		}

		jTextField.setText(textField);
	//	cal.setTextField(jTextField);
	}

}
