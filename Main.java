import java.net.URL;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//Saving for easy copy-paste: https://pokeapi.co/api/v2/
public class Main{

   
   public static void main(String[] args) throws Exception {
      //Testing current classes
      Gson gson = new Gson();
      //Pyroar      
      URL url = new URL("https://pokeapi.co/api/v2/pokemon-species/668");
      URL urlSprites;
      Scanner scan = new Scanner(url.openStream());
      Scanner sprites;
      String rawData = scan.nextLine();
      String rawDataSprites;
      PokemonSpecies pyroarSpecies = gson.fromJson(rawData,PokemonSpecies.class);
      PokemonSprites[] pyroarPics = new PokemonSprites[pyroarSpecies.getVarieties().length];
      for(int i=0;i<pyroarSpecies.getVarieties().length;i++){
         url = new URL("https://pokeapi.co/api/v2/pokemon/"+pyroarSpecies.getVarieties()[i]);
         scan = new Scanner(url.openStream());
         rawData = scan.nextLine();
         PokemonSprites temp = gson.fromJson(rawData,PokemonSprites.class);
         pyroarPics[i] = temp;
      }
      Pokemon pyroar = new Pokemon(pyroarSpecies,pyroarPics);
      System.out.println(pyroar.getIDName());
      System.out.println(pyroar.getDisplayName()+" is known as the "+pyroar.getGenus()+" and it evolves from "+pyroar.getPrevEvol());
      System.out.println("There are "+pyroar.getVarieties().length+" varieties of "+pyroar.getDisplayName());
      System.out.println("There are "+pyroar.getSprites().length+" sprites for "+pyroar.getDisplayName());
      System.out.println();
      //Wormadam
      url = new URL("https://pokeapi.co/api/v2/pokemon-species/413");
      scan = new Scanner(url.openStream());
      rawData = scan.nextLine();
      PokemonSpecies wormSpecies = gson.fromJson(rawData,PokemonSpecies.class);
      PokemonSprites[] wormPics = new PokemonSprites[wormSpecies.getVarieties().length];
      for(int i=0;i<wormSpecies.getVarieties().length;i++){
         System.out.println(wormSpecies.getVarieties()[i]);
         url = new URL("https://pokeapi.co/api/v2/pokemon/"+wormSpecies.getVarieties()[i]);
         scan = new Scanner(url.openStream());
         rawData = scan.nextLine();
         PokemonSprites temp = gson.fromJson(rawData,PokemonSprites.class);
         wormPics[i] = temp;
      }
      System.out.println();
      Pokemon worm = new Pokemon(wormSpecies,wormPics);
      System.out.println(worm.getIDName());
      System.out.println(worm.getDisplayName()+" is known as the "+worm.getGenus()+" and it evolves from "+worm.getPrevEvol());
      System.out.println("There are "+worm.getVarieties().length+" varieties of "+worm.getDisplayName());
      System.out.println("There are "+worm.getSprites().length+" sprites for "+worm.getDisplayName());
      for(String s:worm.getSprites()){
         System.out.println(s);
      }
      //Kanto region
      url = new URL("https://pokeapi.co/api/v2/region/1");
      scan = new Scanner(url.openStream());
      rawData = scan.nextLine();
      Region test = gson.fromJson(rawData,Region.class);
      System.out.println("Building Regional Dex");
      RegionalDex kanto = new RegionalDex(test);
      System.out.println(kanto.getName());
      for(String s:kanto.getPokeList()){
         System.out.println(s);
      }
      System.out.println("There are "+kanto.getPokeList().length+" Pokemon in this dex.");
      kanto.testPrintMonName(0);
      //Takes about 45.5 seconds from start run to here
      //Generation 2
      url = new URL("https://pokeapi.co/api/v2/generation/2");
      scan = new Scanner(url.openStream());
      rawData = scan.nextLine();
      Generation testGen = gson.fromJson(rawData,Generation.class);
      System.out.println("Building Generational Dex");
      GenerationalDex two = new GenerationalDex(testGen);
      System.out.println(two.getName());
      for(String s:two.getPokeList()){
         System.out.println(s);
      }
      System.out.println("There are "+two.getPokeList().length+" Pokemon in this dex.");
      System.out.println(two.getPokemon(0).getDisplayName());
      //Takes about 69 seconds from start run to operation complete, 
      //about 23.5 seconds from "Building Generational Dex" to operation complete
   }
}