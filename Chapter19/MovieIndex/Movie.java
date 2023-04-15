package Chapter19.MovieIndex;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Comparator;
public class Movie implements Comparable<Movie>{
    private static LinkedList<Person> lstAllPerson=new LinkedList<>();
    private static TreeSet<Person> lstAllActr=new TreeSet<Person>(new actorComp());
    private int date;
    private String title;
    private Person[] actors;
    private Person[] directors;
    /**
     * this works better if there are no bounds on length of each field, but is mroe complicated if there is a strict bound for each)
     * @param str
     * @param param
     */
    public Movie(String str, boolean param){
        try{
            date=Integer.parseInt(str.substring(0,4));
            int i=str.indexOf("  ");
            title=str.substring(5,i);
            int n=str.indexOf("Dir:");
            String[] personArr=str.substring(i,n).trim().split(", ");
            actors=makePeople(personArr);
            personArr=str.substring(n+4).trim().split(", ");
            directors=makePeople(personArr);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("uh oh :(");
        }
    }
    /**
     * this version is simpler but only works if the format is strict (length of every field other than directors is bound to a character count)
     * @param str
     */
    public Movie(String str){
        date=Integer.parseInt(str.substring(0,4));
        title=str.substring(5,38).trim();
        actors=makePeople(str.substring(38,84).trim().split(", "));
        directors=makePeople(str.substring(str.indexOf("Dir:")+4).trim().split(", "));
    }
    private static Person[] makePeople(String[] actorArr){
        ArrayList<Person> rtn=new ArrayList<>();
        for(String s:actorArr){
            boolean b=false;
            for(int i=0;i<lstAllPerson.size();i++){
                if(lstAllPerson.get(i).getName().equals(s)){
                    b=true;
                    rtn.add(lstAllPerson.get(i));
                    break;
                }
            }
            if(!b){
                Person a=new Person(s);
                rtn.add(a);
                lstAllPerson.add(a);
                lstAllActr.add(a);
            }
        }
        return rtn.toArray(new Person[rtn.size()]);
    }
    public static TreeSet<Person> getActors(){
        return lstAllActr;
    }
    public String toString(){
        return title+" ("+date+") A: "+arrStr(actors)+" D: "+arrStr(directors)+"\n";
    }
    public String arrStr(Object[] arr){
        String rtn="[";
        for(Object a:arr){
            rtn+=a+", ";
        }
        return rtn.substring(0,rtn.length()-2)+"]";
    }
    public int compareTo(Movie o) {
        return title.compareTo(o.title);
    }
    public Person[] getDirectors(){
        return directors;
    }
    public static class actorComp implements Comparator<Person>{
        public int compare(Person o1, Person o2) {
            int num=o1.getName().substring(o1.getName().indexOf(" ")).compareTo(o2.getName().substring(o2.getName().indexOf(" ")));
            return num==0?o1.getName().substring(0,o1.getName().indexOf(" ")).compareTo(o2.getName().substring(0,o2.getName().indexOf(" "))):num;
        }
    }
}
