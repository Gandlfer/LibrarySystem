package wmich.edu.cs1120.LA3_Lee;

public class Periodical extends LibraryItem {
	private String title="",subject="";
	private int volume, issue;
	
	public void setTitle(String s) {title=s;}
	public void setSubject(String s) {subject=s;}
	public void setVolume(int v) {volume=v;}
	public void setIssue(int i) {issue=i;}

	public String toString() {
		return super.toString()+"\nName: "+title+"\nVolume: "+Integer.toString(volume)+"\nIssue: "+Integer.toString(issue)
				+"\nSubject: "+subject+super.checked();
	}
	
	public void checkOut() {
		if(super.isCheckedOut()==false) {
			super.checkOut();
			System.out.println("\n"+this.toString());
		}
		else {
			System.out.println("Item not available.");
		}
	}
}
