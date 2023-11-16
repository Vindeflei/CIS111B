
public class SpriteList{
   private String front_default;
   private String front_female;
   private String front_shiny;
   private String front_shiny_female;
   public String[] getSprites(){
      String[] temp;
      if(front_female==null){
         temp = new String[2];
         temp[1] = front_shiny;
      }
      else{
         temp = new String[4];
         temp[1] = front_female;
         temp[2] = front_shiny;
         temp[3] = front_shiny_female;
      }
      temp[0] = front_default;
      return temp;
   }
}