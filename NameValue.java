/**
*A class for use with the PokeAPI and GSON, as there are many cases
*where the JSON defines something as an object but all that is needed
*by this program is a String.
*
*@author Cat Weidner
*/
public class NameValue{
   /**
   *The String needed, called name by the API
   */
   private String name;
   /**
   *Returns the name field
   *
   *@return the name value
   */
   public String getName(){
      return name;
   }
}