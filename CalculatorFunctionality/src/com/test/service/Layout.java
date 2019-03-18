package src.com.test.service;

public class Layout {
	private Layout() {
	}

	private static Layout layout = new Layout();

	private int numberofoperand = 11;
	private int hightofbutton = 50;
	private int widthofbutton = 60;
	private int hightoftextfild = 50;
	private int hight = hightofbutton * ((numberofoperand / 3) + this.gettemp()) + (4 * hightofbutton) + hightoftextfild;
	private int width = (4 * widthofbutton) + 16;
	private int widthoftextfild = width-16;

	public static Layout getLayout() {
		return layout;
	}

	public int getnumberofoperand() {
		return (numberofoperand);
	}

	public int gethightofbutton() {
		return (hightofbutton);
	}

	public int getwidthofbutton() {
		return widthofbutton;
	}

	public int gethightoftextfild() {
		return hightoftextfild;
	}

	public int getwidthoftextfild() {
		return widthoftextfild;
	}

	public int gethight() {
		return hight;
	}

	public int getwidth() {
		return width;
	}

	public int gettemp() {
		if ((numberofoperand % 3) == 0) {
			return 0;
		} else {
			System.out.println("aayush    1");

			return 1;
		}
	}

}