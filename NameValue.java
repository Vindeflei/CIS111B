/**
*A class for use with the PokeAPI and GSON, as there are many cases
*where the JSON defines something as an object but all that is needed
*by this program is a String.
*
*@author Cat Weidner
*/
public class NameValue{
   /**
   *
   */
   private String name;
   /**
   *
   */
   public String getName(){
      return name;
   }
}