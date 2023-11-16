
public class Pokemon {
   private String idName;
   private String prevEvol;
   private String genus;
   private String displayName;
   private String[] varieties;
   private PokemonSprites[] sprites;
   public Pokemon(PokemonSpecies species, PokemonSprites[] s){
      this.idName = species.getIDName();
      this.prevEvol = species.getPrevEvol();
      this.genus = species.getGenus();
      this.displayName = species.getDisplayName();
      this.varieties = species.getVarieties();
      this.sprites = s;
   }
   public String getIDName(){
      return idName;
   }
   public String getPrevEvol(){
      return prevEvol;
   }
   public String getGenus(){
      return genus;
   }
   public String getDisplayName(){
      return displayName;
   }
   public String[] getVarieties(){
      return varieties;
   }
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
}