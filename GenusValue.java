/**
*A class for use with the PokeAPI and GSON, as the needed String field
*is called "genus" and not "name" in one case.
*
*@author Cat Weidner
*/
public class GenusValue extends NameLangValue{
   /**
   *The genus field saved from the API call
   */
   private String genus;
   /**
   *Returns the genus field
   *
   *@return the genus of a pokemon
   */
   @Override
   public String getName(){
      return genus;
   }
}