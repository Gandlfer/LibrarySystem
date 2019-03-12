package wmich.edu.cs1120.LA3_Lee;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class LibraryItem implements ILibrary {
	GregorianCalendar dateCheckedOut,dateDue;
	private String callNum="";
	private int days=0;
	private boolean checkedOut=false;
	
	public void setDays(int i) {days=i;}
	public void setCallNum(String s) {callNum=s;}
	
	@Override
	public void checkOut() {
		checkedOut=true;
		getDateCheckedOut();
		getDateDue();
	}
    
	@Override
    public String toString() {
		return "Call Number: "+ callNum;
	}
	
	@Override
    public String getCallNumber() {return callNum;}
	
	@Override
    public boolean isCheckedOut() {return checkedOut;}
	
	@Override
    public GregorianCalendar getDateCheckedOut() {
		dateCheckedOut= new GregorianCalendar();
		return dateCheckedOut;
	}
	
	@Override
    public GregorianCalendar getDateDue() {
		setDateDue(dateCheckedOut);
		return dateDue;
	}
    
	@Override
    public void setDateDue(GregorianCalendar dateDue) {
		this.dateDue=(GregorianCalendar)dateDue.clone();
		this.dateDue.add(Calendar.DAY_OF_YEAR, days);
	}
	
	public String checked() {
		if(isCheckedOut()==true) {
			return "\nChecked Out: Yes\nDate Out: "+String.format("Date Out: %tD\n", dateCheckedOut)+"Date Due: "+String.format("Date Out: %tD\n", dateDue);
		}
		else {
			return "\nChecked Out: NO";
		}
	}
}
