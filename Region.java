
public class Region{
   private String name;
   private NameValue[] pokedexes;
   public String getName(){
      return name;
   }
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