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
   *An array of the names for this generation
   *in various languages
   */
   private NameLangValue[] names;
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
   public String getIDName(){
      return name;
   }
   /**
   *Returns the display name of the region,
   *in English
   *
   *@return display name
   */
   public String getDisplayName(){
      String tempName = "English not found";
      for(NameLangValue n:names){
         if(n.getLang().equals("en")){
            tempName = n.getName();
         }
      }
      return tempName;
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