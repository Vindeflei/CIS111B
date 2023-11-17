/**
*A class for holding data on the varieties of a pokemon, because the API
*used nested objects for this information.
*
*@author Cat Weidner
*/
public class Variety{
   /**
   *The name object of the pokemon variant
   */
   private NameValue pokemon;
   /**
   *Returns the ID name used by the API for the variant
   *
   *@return ID name
   */
   public String getName(){
      return pokemon.getName();
   }
}