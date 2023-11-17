/**
*A generic Pokedex class for use with the PokeAPI and GSON.
*
*@author Cat Weidner
*/
public class Pokedex{
   /**
   *The ID name of the Pokedex, used by the API to identify it.
   */
   private String name;
   /**
   *An array of names for the dex, in various languages.
   */
   private NameValue[] names;
   /**
   *An array of pokedex entries.
   */
   private Entry[] pokemon_entries;
   /**
   *Returns the ID name.
   *
   *@return the ID name of the pokedex
   */
   public String getIDName(){
      return name;
   }
   /**
   *Returns the display name of the pokedex, in English.
   *
   *@return the display name
   */
   public String getDisplayName(){
      return names[names.length-1].getName();
   }
   /**
   *Returns an array of the ID names of the pokemon in the dex.
   *
   *@return the ID names of the dex's pokemon
   */
   public String[] getPokeList(){
      String[]temp = new String[pokemon_entries.length];
      int i=0;
      for(Entry e:pokemon_entries){
         temp[i]=e.getName();
         i++;
      }
      return temp;
   }
}