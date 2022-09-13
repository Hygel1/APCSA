
public class APClassroomPractice{
    public static void main(String args[]){
        System.out.println(scrambleWord("CRAD"));
    }
public static String scrambleWord(String word){
    int place=word.indexOf("A");
    while(place!=-1&&place!=word.length()-1){
        word=word.substring(0,place)+word.charAt(place+1)+"A"+word.substring(place+2);
        place=word.indexOf("A",place);
        }
    return word;
    }
}