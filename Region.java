/**
*A class for storing region data from the API
*
*@author Cat Weidner
*/
public class Region{
   /**
   *The ID name of the region used by the API
   */
   private String name;
   /**
   *The list of pokedexes used by this region in all of the games 
   *it appears in
   */
   private NameValue[] pokedexes;
   /**
   *Returns the ID name of the region
   *
   *@return ID name
   */
   public String getName(){
      return name;
   }
   /**
   *Returns a list of the ID names of the pokedexes used by this region
   *
   *@return pokedex list
   */
   public String[] getDexes(){
      String[] temp = new String[pokedexes.length];
      int i = 0;
      for(NameValue d:pokedexes){
         temp[i]=d.getName();
         i++;
      }
      return temp;
   }
}