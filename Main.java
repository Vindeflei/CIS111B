import java.net.URL;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//For testing, remove eventually:
import java.lang.Math;
//Saving for easy copy-paste: https://pokeapi.co/api/v2/
public class Main{

   
   public static void main(String[] args) throws Exception {
      //Testing current classes
      Gson gson = new Gson();
      //Pokemon test 1      
      URL url = new URL("https://pokeapi.co/api/v2/pokemon-species/194");
      Scanner scan = new Scanner(url.openStream());
      String rawData = scan.nextLine();
      PokemonSpecies testSpecies1 = gson.fromJson(rawData,PokemonSpecies.class);
      PokemonSprites[] testPics1 = new PokemonSprites[testSpecies1.getVarieties().length];
      for(int i=0;i<testSpecies1.getVarieties().length;i++){
         url = new URL("https://pokeapi.co/api/v2/pokemon/"+testSpecies1.getVarieties()[i]);
         scan = new Scanner(url.openStream());
         rawData = scan.nextLine();
         PokemonSprites temp = gson.fromJson(rawData,PokemonSprites.class);
         testPics1[i] = temp;
      }
      System.out.println("API ID:"+testSpecies1.getIDName());
      System.out.println(testSpecies1.getDisplayName()+" is known as the "+testSpecies1.getGenus()+".");
      System.out.println("There are "+testSpecies1.getVarieties().length+" varieties of "+testSpecies1.getDisplayName());
      int picsLength = 0;
      for(PokemonSprites sp:testPics1){
         picsLength+=sp.getSprites().length;
      }
      System.out.println("There are "+picsLength+" sprites for "+testSpecies1.getDisplayName());
      System.out.println();
      
      //Pokemon test 2
      url = new URL("https://pokeapi.co/api/v2/pokemon-species/493");
      scan = new Scanner(url.openStream());
      rawData = scan.nextLine();
      PokemonSpecies testSpecies2 = gson.fromJson(rawData,PokemonSpecies.class);
      PokemonSprites[] testPics2 = new PokemonSprites[testSpecies2.getVarieties().length];
      for(int i=0;i<testSpecies2.getVarieties().length;i++){
         System.out.println(testSpecies2.getVarieties()[i]);
         url = new URL("https://pokeapi.co/api/v2/pokemon/"+testSpecies2.getVarieties()[i]);
         scan = new Scanner(url.openStream());
         rawData = scan.nextLine();
         PokemonSprites temp = gson.fromJson(rawData,PokemonSprites.class);
         testPics2[i] = temp;
      }
      System.out.println("API ID:"+testSpecies2.getIDName());
      System.out.println(testSpecies2.getDisplayName()+" is known as the "+testSpecies2.getGenus()+".");
      System.out.println("There are "+testSpecies2.getVarieties().length+" varieties of "+testSpecies2.getDisplayName());
      picsLength = 0;
      for(PokemonSprites sp:testPics2){
         picsLength+=sp.getSprites().length;
      }
      System.out.println("There are "+picsLength+" sprites for "+testSpecies2.getDisplayName());
      
      //Region test
      url = new URL("https://pokeapi.co/api/v2/region/7");
      scan = new Scanner(url.openStream());
      rawData = scan.nextLine();
      Region test = gson.fromJson(rawData,Region.class);
      System.out.println("Building Regional Dex");
      RegionalDex testRegion = new RegionalDex(test);
      System.out.println(testRegion.getName());
      System.out.println("There are "+testRegion.getPokeList().length+" Pokemon in this dex.");
      int randomPoke =(int)(Math.random()*testRegion.getPokeList().length);
      System.out.println("The test pokemon is number "+randomPoke+".");
      url = new URL("https://pokeapi.co/api/v2/pokemon-species/"+testRegion.getPokeList()[randomPoke]);
      scan = new Scanner(url.openStream());
      rawData = scan.nextLine();
      PokemonSpecies ranSpecies = gson.fromJson(rawData,PokemonSpecies.class);
      scan = new Scanner(System.in);
      System.out.println("There are "+ranSpecies.getVarieties().length+" varieties of the chosen pokemon. Please pick which variety to see sprites for:");
      int varNum = scan.nextInt();
      String chosenVar = ranSpecies.getVarieties()[varNum-1];
      url = new URL("https://pokeapi.co/api/v2/pokemon/"+chosenVar);
      scan = new Scanner(url.openStream());
      rawData = scan.nextLine();
      PokemonSprites ranSprites = gson.fromJson(rawData,PokemonSprites.class);
      System.out.println("The sprite links are:\n"+ranSpecies.getDisplayName()+": "+ranSprites.getSprites()[0]+"\n"
      +ranSpecies.getDisplayName()+" Shiny Ver: "+ranSprites.getSprites()[1]);
      

      //Generation test
      url = new URL("https://pokeapi.co/api/v2/generation/7");
      scan = new Scanner(url.openStream());
      rawData = scan.nextLine();
      Generation testGen = gson.fromJson(rawData,Generation.class);
      System.out.println("Building Generational Dex");
      System.out.println(testGen.getDisplayName());
      System.out.println("There are "+testGen.getPokeList().length+" Pokemon in this dex.");
      randomPoke =(int)(Math.random()*testGen.getPokeList().length);
      System.out.println("The test pokemon is number "+randomPoke+".");
      url = new URL("https://pokeapi.co/api/v2/pokemon-species/"+testGen.getPokeList()[randomPoke]);
      scan = new Scanner(url.openStream());
      rawData = scan.nextLine();
      ranSpecies = gson.fromJson(rawData,PokemonSpecies.class);
      scan = new Scanner(System.in);
      System.out.println("There are "+ranSpecies.getVarieties().length+" varieties of the chosen pokemon. Please pick which variety to see sprites for:");
      varNum = scan.nextInt();
      chosenVar = ranSpecies.getVarieties()[varNum-1];
      url = new URL("https://pokeapi.co/api/v2/pokemon/"+chosenVar);
      scan = new Scanner(url.openStream());
      rawData = scan.nextLine();
      ranSprites = gson.fromJson(rawData,PokemonSprites.class);
      System.out.println("The sprite links are:\n"+ranSpecies.getDisplayName()+": "+ranSprites.getSprites()[0]+"\n"
      +ranSpecies.getDisplayName()+" Shiny Ver: "+ranSprites.getSprites()[1]);
   }
}