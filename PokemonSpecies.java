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
   *A list of the pokemon's genus in various languages
   */
   private GenusValue[] genera; 
   /**
   *A list of the pokemon's display name in various languages
   */
   private NameLangValue[] names;
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
   *Returns the pokemon's genus, in English
   *
   *@return genus
   */
   public String getGenus(){
      String tempGen="English not found";
      for(GenusValue gen:genera){
         if(gen.getLang().equals("en")){
            tempGen = gen.getName();
         }
      }
      return tempGen;
   }
   /**
   *Returns the pokemon's display name, in English
   *
   *@return display name
   */
   public String getDisplayName(){
      String tempName="English not found";
      for(NameLangValue n:names){
         if(n.getLang().equals("en")){
            tempName = n.getName();
         }
      }
      return tempName;
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