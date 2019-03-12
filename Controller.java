package wmich.edu.cs1120.LA3_Lee;

import java.io.IOException;
import java.io.*;
import java.util.Scanner;

public class Controller implements IController {
	private Scanner scan;
	private Periodical periodicals[];
	private Books books[];
	
	public Controller(Scanner scan) {
		// TODO Auto-generated constructor stub
		this.scan= scan;
	}
	
	@Override
	public void displayCollection() {
		// TODO Auto-generated method stub
		System.out.println("Books: \n");
		for(int i=0;i<books.length;i++) {
			System.out.println(books[i].toString()+"\n");
		}
		System.out.println("-----------------------------------------");
		System.out.println("Periodicals: \n");
		for(int i=0;i<periodicals.length;i++) {
			System.out.println(periodicals[i].toString()+"\n");
		}
	}

	@Override
	public void checkoutMaterials() {
		// TODO Auto-generated method stub
		System.out.print("Enter the call number: ");
		String s=scan.nextLine();
		if(findItem(s)==null) {
			System.out.println("Item not Found");
		}
		else {
			findItem(s).checkOut();
		}
	}

	@Override
	public ILibrary findItem(String callNum) {
		// TODO Auto-generated method stub
		for(int i=0;i<books.length;i++) {
			if(books[i].getCallNumber().equalsIgnoreCase(callNum)) {
				return books[i];
			}
		}
		for(int i=0;i<periodicals.length;i++) {
			if(periodicals[i].getCallNumber().equalsIgnoreCase(callNum)) {
				return periodicals[i];
			}
		}
		return null;
	}

	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("----------Menu----------");
		System.out.println("1) Display collection");
		System.out.println("2) Check Out Materials");
		System.out.println("3) Quit");
		System.out.println("-----------------------");
		System.out.print("Please enter an option: ");
	}
	
	public void readInput(String fileName) throws IOException{
		Scanner readFile= new Scanner(new File(fileName));
		String data="";
		int counterBook=0;
		int counterPeriodical=0;

		while(readFile.hasNextLine()) {
			data=data+readFile.nextLine()+"#";
		}
		readFile.close();
		String tempSplited[]=data.split("#");
		books=new Books [Integer.parseInt(tempSplited[0])];
		periodicals=new Periodical [Integer.parseInt(tempSplited[1])];
		
		for(int i=2;i<tempSplited.length;i++) {
			if(tempSplited[i].charAt(0)== 'B') {
				books[counterBook]=new Books();
				books[counterBook].setDays(21);
				String splited[]=tempSplited[i].split(",");
				books[counterBook].setCallNum(splited[1]);
				books[counterBook].setName(splited[2]);
				books[counterBook].setAuthor(splited[3]);
				books[counterBook].setGenre(splited[4]);
				counterBook++;
			}
			else {
				periodicals[counterPeriodical]=new Periodical();
				periodicals[counterPeriodical].setDays(7);
				String splited[]=tempSplited[i].split(",");
				periodicals[counterPeriodical].setCallNum(splited[1]);
				periodicals[counterPeriodical].setTitle(splited[2]);
				periodicals[counterPeriodical].setVolume(Integer.parseInt(splited[3]));
				periodicals[counterPeriodical].setIssue(Integer.parseInt(splited[4]));
				periodicals[counterPeriodical].setSubject(splited[5]);
				counterPeriodical++;
			}
		}
	}
}
