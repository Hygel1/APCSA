
public class APClassroomPractice{
    public static void main(String args[]){
        System.out.println(scrambleWord("CRAD"));
    }
public static String scrambleWord(String word){
    for(int i=0;i<word.length()-2;i++){
        if(word.indexOf("A",i)!=-1){
            word=word.substring(0,word.indexOf("A"))+word.charAt(word.indexOf("A")+1)+"A"+word.substring(word.indexOf("A")+1);
        }
    }
    return word;
    }
}