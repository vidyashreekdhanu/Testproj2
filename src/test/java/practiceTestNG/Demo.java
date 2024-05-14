package practiceTestNG;

import java.util.Date;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		System.out.println(time);
	}

}
