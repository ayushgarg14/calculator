package src.com.test.service;

public class ComutationService {

	String queue[] = new String[100];
	String stack[] = new String[100];
	String atempchararray1[] = new String[100];
	char tempchararray1[] = new char[100];
	char tempchararray2[] = new char[100];
	int toperatoeofstack, toperatoeofqueue, i,temp, temp2 ;
	float result;
	float topElement,secoundTopElement ;
	int operatoe, brac, operand;

	public String computeString(String s1) // function to convert pre to operandst
	{

		{
			toperatoeofstack = 0; // initalization block
			stack[0] = "(";
			toperatoeofqueue = -1;
			temp2 = brac = operand = operatoe =temp= 0;
			 tempchararray1 = s1.toCharArray();
		}

		for (i = 1; i < s1.length(); i++) // looperatoeerator for convert char array to string array
		{
			if ((tempchararray1[i] == '+' || tempchararray1[i] == '-' || tempchararray1[i] == '*' || tempchararray1[i] == '/' || tempchararray1[i] == ')' || tempchararray1[i] == '(' || tempchararray1[i] == '^')
					&& tempchararray1[i - 1] != '(') {

				if (temp2 != i) {
					atempchararray1[temp++] = new String(s1.substring(temp2, i));
					temp2 = i;

				}
				atempchararray1[temp++] = new String(s1.substring(temp2, i + 1));
				temp2++;
			}
		}
		atempchararray1[temp + 1] = ")";

		temp2=0;
		
		for (i = 0; i < temp; i++) {
			 tempchararray2 = atempchararray1[i].toCharArray();

			for (int j = 0; j <  tempchararray2.length; j++) // looperatoe for cheak no any character like A,b are in string
			{

				if (((int) tempchararray2[j] >= 40 && (int) tempchararray2[j] <= 57 && (int) tempchararray2[j] != 44) || (int) tempchararray2[j] == 94) {

					if (tempchararray2[j] == '.') // cheak no any double .. in a number
					{
						temp2++;
					}
				} else {
					temp2 = 2;
				}
			}
			if (temp2 > 1) {
				break;
			}
		}
		if (temp2 > 1) {
			System.out.println("ayuh1");
			return ("not a valid data");
		} else // now start convert infix to operandst
		{
			for (i = 0; atempchararray1[i] != null; i++) {

				if (atempchararray1[i].equals("+") || atempchararray1[i].equals("-") || atempchararray1[i].equals("*") || atempchararray1[i].equals("/")
						|| atempchararray1[i].equals("^")) {
					if (i == 0) { // cheack operatoeerater is not at first
						brac = -2;
						break;
					} else {
						if (atempchararray1[i - 1].equals("+") || atempchararray1[i - 1].equals("-") || atempchararray1[i - 1].equals("*")
								|| atempchararray1[i - 1].equals("/") || atempchararray1[i - 1].equals("^") || atempchararray1[i - 1].equals("(")) {
							brac = -2;
							break; // cheack tow operatoeerater are not togather
						}
					}
					operatoe++;

					if (stack[toperatoeofstack].equals("(")) {
						toperatoeofstack++;
						stack[toperatoeofstack] = atempchararray1[i];

					} else // for cheack precidance of operatoeerater
					{
						int r;
						r = -1;
						for (int j = toperatoeofstack; stack[j] != "("; j--) {
							r++;

							if (atempchararray1[i].equals("+") || atempchararray1[i].equals("-")) {
								toperatoeofqueue++;
								queue[toperatoeofqueue] = stack[j];

							} else if (atempchararray1[i].equals("^")) {
								if (stack[toperatoeofstack].equals("^")) {
									toperatoeofqueue++;
									queue[toperatoeofqueue] = stack[j];

								} else {
									toperatoeofstack++;
								}
							} else {

								if (stack[j].equals("*") || stack[j].equals("/") || stack[j].equals("^")) {
									toperatoeofqueue++;
									queue[toperatoeofqueue] = stack[j];
									toperatoeofstack--;
								} else {
									toperatoeofstack++;
								}

							}
							if (r != 0) {
								toperatoeofstack--;
							}

						}
						stack[toperatoeofstack] = atempchararray1[i];
					}
				} else if (atempchararray1[i].equals("(")) {
					brac++;
					if (atempchararray1[i - 1].equals("+") || atempchararray1[i - 1].equals("-") || atempchararray1[i - 1].equals("*") || atempchararray1[i - 1].equals("/")
							|| atempchararray1[i - 1].equals("^")) {
						toperatoeofstack++;
						stack[toperatoeofstack] = "(";
					} else { // if there is no operatoeerater before so add *
						operatoe++;
						toperatoeofstack++;
						stack[toperatoeofstack] = "*";
						toperatoeofstack++;
						stack[toperatoeofstack] = "(";
					}
				} else if (atempchararray1[i].equals(")")) {
					if (atempchararray1[i - 1].equals("+") || atempchararray1[i - 1].equals("-") || atempchararray1[i - 1].equals("*") || atempchararray1[i - 1].equals("/")
							|| atempchararray1[i - 1].equals("^")) {
						brac = 2;
					} else {
						brac--;
						for ( temp = toperatoeofstack; stack[toperatoeofstack] != "("; temp--) {
							toperatoeofqueue++;
							queue[toperatoeofqueue] = stack[toperatoeofstack];
							toperatoeofstack--;
						
						}
						toperatoeofstack--;

					}
				} else {
					operand++;
					toperatoeofqueue++;
					queue[toperatoeofqueue] = atempchararray1[i];
				}
			}
		}

		// check balance of operatoeerater and brackets
		if (operatoe == operand - 1 && brac == -1 && operand > 0) {

			return qwe();
		} else {
			return "not a valid data ";
		}
	}// end

	// function to START EVALUATE
	public String qwe() {

		int toperatoeofstacks = -1;
		for (i = 0; queue[i] != null; i++) {
			if (queue[i].equals("+") || queue[i].equals("-") || queue[i].equals("*") || queue[i].equals("/") || queue[i].equals("^")) {
				topElement = Float.parseFloat(stack[toperatoeofstacks]);
				secoundTopElement  = Float.parseFloat(stack[toperatoeofstacks - 1]);
				result = solve(secoundTopElement , topElement, queue[i]);
				toperatoeofstacks = toperatoeofstacks - 1;
				stack[toperatoeofstacks] = String.valueOf(result);

			} else {
				toperatoeofstacks++;
				stack[toperatoeofstacks] = queue[i];
			}
		}
		if (toperatoeofstacks != -1) {
			return (stack[toperatoeofstacks]);
		} else
			return null;

	}

	public float solve(float operand1, float operand2, String opertor) {
		float result= 0;
		switch (opertor) {
		case "+":
			result= operand1 +operand2;
			break;
		case "-":
			result= operand1- operand2;
			break;
		case "*":
			result = operand1* operand2;
			break;
		case "/":
			result = operand1 / operand2;
			break;
		case "^":
			result = (int) Math.pow(operand1, operand2);
			break;

		}
		return result;

	}

}
