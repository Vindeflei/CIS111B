/**
*A class for storing Pokemon information for the application
*
*@author Cat Weidner
*/
public class Pokemon {
   /**
   *The ID name used by the API
   */
   private String idName;
   /**
   *The Pokemon's previous/child form
   */
   private String prevEvol;
   /**
   *The Pokemon's genus
   */
   private String genus;
   /**
   *The Pokemon's displayed name
   */
   private String displayName;
   /**
   *The varieties of this Pokemon
   */
   private String[] varieties;
   /**
   *The sprites for this Pokemon
   */
   private PokemonSprites[] sprites;
   /**
   *True if a Pokemon has different sprites for males and
   *females, false if males and females appear identical.
   */
   private boolean genderDiff;
   /**
   *The constructor.
   *Takes information from the two separate endpoints
   *and combines them for easier use.
   *
   *@param species the information from the pokemon-species call
   *@param sprites the sprite information from the pokemon call, as an array to
   *include possible varieties
   */   
   public Pokemon(PokemonSpecies species, PokemonSprites[] s){
      this.idName = species.getIDName();
      this.prevEvol = species.getPrevEvol();
      this.genus = species.getGenus();
      this.displayName = species.getDisplayName();
      this.varieties = species.getVarieties();
      this.sprites = s;
      this.genderDiff = species.getGenderDiff();
   }
   /**
   *Returns the API ID name
   *
   *@return ID name
   */
   public String getIDName(){
      return idName;
   }
   /**
   *Returns the previous evolution/form
   *
   *@return previous evolution
   */
   public String getPrevEvol(){
      return prevEvol;
   }
   /**
   *Returns the genus
   *
   *@return the genus
   */
   public String getGenus(){
      return genus;
   }
   /**
   *Returns the display name
   *
   *@return the display name
   */
   public String getDisplayName(){
      return displayName;
   }
   /**
   *Returns the varieties of the pokemon
   *
   *@return the varieties
   */
   public String[] getVarieties(){
      return varieties;
   }
   /**
   *Returns all of the sprite links as a single array
   *
   *@return sprite links
   */
   public String[] getSprites(){
      int l = 0;
      for(PokemonSprites p:this.sprites){
         l+=p.getSprites().length;
      }
      String[] temp = new String[l];
      int i = 0;
      for(PokemonSprites p:this.sprites){
         for(String s:p.getSprites()){
            temp[i]=s;
            i++;
         }
      }
      return temp;
   }
   /**
   *Returns if the sprites are different based on
   *gender, true or false.
   *
   *@return if different sprites for gender
   */
   public boolean getGenderDiff(){
      return genderDiff;
   }
}