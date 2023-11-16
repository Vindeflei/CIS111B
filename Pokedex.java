
public class Pokedex{
   private String name;
   private NameValue[] names;
   private Entry[] pokemon_entries;
   
   public String getIDName(){
      return name;
   }
   public String getDisplayName(){
      return names[names.length-1].getName();
   }
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