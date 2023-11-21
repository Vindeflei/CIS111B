/**
*A class for holding pokemon species information called from the 
*pokemon-species endpoint of the PokeAPI
*
*@author Cat Weidner
*/
public class PokemonSpecies{
   /**
   *The ID name used by the API
   */
   private String name;
   /**
   *The pokemon's previous form
   */
   private NameValue evolves_from_species;
   /**
   *A list of the pokemon's genus in various languages
   */
   private GenusValue[] genera; 
   /**
   *A list of the pokemon's display name in various languages
   */
   private NameValue[] names;
   /**
   *A list of Variety objects, because the JSON was like that
   */
   private Variety[] varieties;
   /**
   *True if a Pokemon has different sprites for males and
   *females, false if males and females appear identical.
   */
   private boolean has_gender_differences;
   /**
   *Returns the ID name used by the API
   *
   *@return ID name
   */
   public String getIDName(){
      return name;
   }
   /**
   *Returns the pokemon's previous evolution/form, if it has one, otherwise
   *returns "None" to prevent null String problems.
   *
   *@return previous evolution
   */
   public String getPrevEvol(){
      if(evolves_from_species==null) return "None";
      else return evolves_from_species.getName();
   }
   /**
   *Returns the pokemon's genus, in English
   *
   *@return genus
   */
   public String getGenus(){
      return genera[7].getName();
   }
   /**
   *Returns the pokemon's display name, in English
   *
   *@return display name
   */
   public String getDisplayName(){
      return names[8].getName();
   }
   /**
   *Returns a list of varieties of the pokemon converted out of the
   *Variety objects
   *
   *@return list of varieties
   */
   public String[] getVarieties(){
      String[] temp= new String[varieties.length];
      for(int i = 0; i<varieties.length;i++){
         temp[i]=varieties[i].getName();
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
      return has_gender_differences;
   }
}