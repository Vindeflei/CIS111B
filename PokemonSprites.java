/**
*A class for holding sprite information called from the pokemon
*endpoint of the PokeAPI
*
*@author Cat Weidner
*/
public class PokemonSprites{
   /**
   *The ID name of the pokemon the sprites are for
   */
   private String name;
   /**
   *A list of sprite links
   */
   private SpriteList sprites;
   /**
   *Returns the ID name
   *
   *@return ID name
   */
   public String getName(){
      return name;
   }
   /**
   *Returns a list of sprite links
   *
   *@return sprite links
   */
   public String[] getSprites(){
      return this.sprites.getSprites();
   }
}