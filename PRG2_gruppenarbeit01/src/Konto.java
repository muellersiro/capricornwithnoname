
public class Konto {
	
	private int kontoNr;
	private int iban;
	private int kontoArt;
	
	public String toString(){
		return kontoArt + " (" + iban + ")";
	}
	
	 public boolean equals(Object o){
	    if( o==this ) return true;
	    if( o==null || o.getClass()!=getClass() ) return false;
	    Konto that = (Konto)o;
	    return kontoNr==that.kontoNr;
	 }
	 public int hashCode(){
	    return kontoNr;
	 }
}
