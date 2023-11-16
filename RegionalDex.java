import java.net.URL;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashSet;
import java.net.MalformedURLException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class RegionalDex{
   private String name;
   private Pokemon[] pokemon;
   public RegionalDex(Region r)throws MalformedURLException, IOException{
      URL url;
      Scanner scan;
      String rawData;
      Pokedex dex;
      HashSet<String> pokeList = new HashSet<String>();
      PokemonSpecies tempSpec;
      PokemonSprites[] tempPics;
      int i;
      int j;
      Pokemon tempMon;
      Gson gson = new Gson();
      for(String dexName:r.getDexes()){
         url = new URL("https://pokeapi.co/api/v2/pokedex/"+dexName);
         scan = new Scanner(url.openStream());
         rawData = scan.nextLine();
         dex = gson.fromJson(rawData,Pokedex.class);
         for(String poke:dex.getPokeList()){
            pokeList.add(poke);
         }
      }
      ArrayList<String> pokeListSorted = new ArrayList<String>(pokeList);
      Collections.sort(pokeListSorted);
      pokemon = new Pokemon[pokeList.size()];
      i=0;
      for(String poke:pokeListSorted){
         url = new URL("https://pokeapi.co/api/v2/pokemon-species/"+poke);
         scan = new Scanner(url.openStream());
         rawData = scan.nextLine();
         tempSpec = gson.fromJson(rawData,PokemonSpecies.class);
         tempPics = new PokemonSprites[tempSpec.getVarieties().length];
         j = 0;
         for(String var:tempSpec.getVarieties()){
            url = new URL("https://pokeapi.co/api/v2/pokemon/"+var);
            scan = new Scanner(url.openStream());
            rawData = scan.nextLine();
            PokemonSprites temp = gson.fromJson(rawData,PokemonSprites.class);
            tempPics[j] = temp;
            j++;
         }
         tempMon=new Pokemon(tempSpec,tempPics);
         pokemon[i]=tempMon;
         i++;
      }
   }
   public void testPrintMonName(int n){
      System.out.println(pokemon[n].getDisplayName());
   }
}