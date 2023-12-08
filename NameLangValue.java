/**
*A class for use with the PokeAPI and GSON, as some arrays contain
*languages and the program needs to be able to check for English.
*
*@author Cat Weidner
*/
public class NameLangValue{
   /**
   *The needed String from the API call
   */
   private String name;
   /**
   *A NameValue that hold the language information
   */
   private NameValue language;
   /**
   *Returns the name field
   *
   *@return the name value
   */
   public String getName(){
      return name;
   }
   /**
   *Returns the language of the name field
   *
   *@return the language of the name
   */
   public String getLang(){
      return language.getName();
   }
}