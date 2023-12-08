/**
*A class for holding sprite data, because the JSON files nest an object
*in an object for sprite information.
*
*@author Cat Weidner
*/
public class SpriteList{
   /**
   *The sprite link for the pokemon, facing forward
   */
   private String front_default;
   /**
   *The sprite link for the female version of the pokemon, facing forward
   */
   private String front_female;
   /**
   *The sprite link for the shiny version of the pokemon, facing forward
   */
   private String front_shiny;
   /**
   *The sprite link for the female shiny version of the pokemon, facing forward
   */
   private String front_shiny_female;
   /**
   *Returns an array of sprite links, not counting the null ones in cases where
   *male and female versions are visually identical.
   *
   *@return sprite links
   */
   public String[] getSprites(){
      String[] temp;
      if(front_female==null){
         temp = new String[2];
      }
      else{
         temp = new String[4];
         temp[2] = front_female;
         temp[3] = front_shiny_female;
      }
      temp[0] = front_default;
      temp[1] = front_shiny;
      return temp;
   }
}