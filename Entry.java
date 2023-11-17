/**
*A class for use with the PokeAPI and GSON, as the entries in Pokedex JSON
*are objects with a name object nested inside.
*
*@author Cat Weidner
*/
public class Entry{
   /**
   *The name object nested in the entry object
   */
   private NameValue pokemon_species;
   /**
   *Returns the name of the pokemon of this entry used to call the API
   *
   *@return the pokemon's ID name
   */
   public String getName(){
      return pokemon_species.getName();
   }
}