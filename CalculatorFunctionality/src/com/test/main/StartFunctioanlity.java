package src.com.test.main;

import src.com.test.service.Layout;
import javax.swing.JFrame;

import src.com.test.service.CalculatorService;

public class StartFunctioanlity {

	public static void main(String args[]) {

		Layout layout = Layout.getLayout();
		final int width = layout.getwidth();
		int hight = layout.gethight();
        CalculatorService calculatorInstance = CalculatorService.getInstance();
		calculatorInstance.setLayouts();
		calculatorInstance.setVisible(true);
		calculatorInstance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
System.out.println(hight);
System.out.println(width);
calculatorInstance.setSize(width, hight);
	}
}