
public class PokemonSpecies{
   private String name;
   private NameValue evolves_from_species;
   private GenusValue[] genera; 
   private NameValue[] names;
   private Variety[] varieties;
   public String getIDName(){
      return name;
   }
   public String getPrevEvol(){
      if(evolves_from_species==null) return "None";
      else return evolves_from_species.getName();
   }
   public String getGenus(){
      return genera[7].getName();
   }
   public String getDisplayName(){
      return names[8].getName();
   }
   public String[] getVarieties(){
      String[] temp= new String[varieties.length];
      for(int i = 0; i<varieties.length;i++){
         temp[i]=varieties[i].getName();
      }
      return temp;
   }
}