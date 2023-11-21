/**
*A class for holding generation data from the API.
*Built for use with GSON.
*
*@author Cat Weidner
*/
public class Generation{
   /**
   *The ID name the API uses
   */
   private String name;
   /**
   *An array of the names for this generation
   *in various languages
   */
   private NameValue[] names;
   /**
   *An array of the names of the pokemon in
   *this generation
   */
   private NameValue[] pokemon_species;
   /**
   *Returns the ID name used by the API
   *
   *@return ID name
   */
   public String getIDName(){
      return name;
   }
   /**
   *Returns the display name of the generation,
   *in English
   *
   *@return display name
   */
   public String getDisplayName(){
      return names[6].getName(); 
   }
   /**
   *Returns a list of the names of the pokemon
   *in this generation
   *
   *@return list of pokemon names
   */
   public String[] getPokeList(){
      String[] temp = new String[pokemon_species.length];
      int i = 0;
      for(NameValue n:pokemon_species){
         temp[i] = n.getName();
         i++;
      }
      return temp;
   }
}