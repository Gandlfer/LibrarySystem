package wmich.edu.cs1120.LA3_Lee;

public class Books extends LibraryItem {
	private String name, author, genre;
	public void setName(String s) {name=s;}
	public void setAuthor(String s) {author=s;}
	public void setGenre(String s) {genre=s;}
	
	public String toString() {
		return super.toString()+"\nName: "+name+"\nAuthor: "+author+"\nGenre: "+genre+super.checked();
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
