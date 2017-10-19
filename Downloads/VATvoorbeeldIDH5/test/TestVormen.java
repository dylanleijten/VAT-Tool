import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import domain.*;
/**
 *
 * @author mgchaper
 */
public class TestVormen extends TestCase {
   
   public void testBerekenInhoudBlok() {
       
       double expected = 6.0;
       
       KlVorm b1 = new KlBlok(1.0,2.0,3.0);
       
       double actual = b1.geefInhoud();
       assertEquals( expected, actual );
   
   } 
   
   public void testBerekenInhoudBol () {
       //nog implementeren
   }

   public void testBerekenInhoudCilinder() {
       //nog implementeren
   }
   
}
    
    
    

