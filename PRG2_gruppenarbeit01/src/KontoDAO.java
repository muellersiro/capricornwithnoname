import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class KontoDAO {
   List<Konto> all = new LinkedList<Konto>();
   
   public KontoDAO(){//diese Konten sollen existieren
      all.add(new Konto(333444, 50000.0,"9988", 4444));
      all.add(new Konto(333445, 60000.0,"9977", 4444));
      all.add(new Konto(333446, 70000.0,"9966", 4443));
      all.add(new Konto(333446, 50000.0,"9967", 4444));
   }
   
   //alle auf einmal
   public List<Konto> getAll(){
      LinkedList<Konto> rc = new LinkedList<Konto>(all);
      Collections.sort(rc);
      return rc;
   }
   
   //ein ganz bestimmter Kunde, falls dieser existert (null, falls nicht)
   public Konto getKonto( int kontoNr ){
      Konto rc = null;
      for( Konto k : all )
         if(k.getKontoNr()==kontoNr)
            return k;
      return rc;
   }

}
