package wmich.edu.cs1120.LA3_Lee;
import java.io.*;
import java.util.Scanner;

public class LA3Test {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	    
		Scanner keyboard = new Scanner(System.in);
		IController control = new Controller(keyboard);
	    control.readInput("input.txt");
        String response = "";
        boolean quitFlag = false;
        
        while (!quitFlag) {
            control.showMenu();
            response = keyboard.nextLine();
            System.out.println();
            switch (response) {
                case "1":
                    control.displayCollection();
                    break;
                case "2":
                    control.checkoutMaterials();
                    break;
                case "3":
                    quitFlag = true;
                    break;
            }
        }

		 System.out.println("Good bye!");
        keyboard.close();
	}

}	// End of main class

