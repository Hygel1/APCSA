package Chapter19.MovieIndex;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
/**
 * Sean McLoughlin
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin
 * Date of Completion: 4/13/23
 * Assignment: IMDB Movies Project
 * 
 * General Description: Takes a data file and parses/sorts data inside
 * 
 * Advanced: prints results to file
 *           stores all people in a static list, which eliminates duplicates and creates potential for listing movies by people associated with them
 */
public class MovieListReader {
    public static void main(String[] args){
        LinkedList<Movie> movies=readMovieFile("Chapter19\\MovieIndex\\movie_data\\movies.txt");
        makeMovieFile(movies);
        //System.out.println(movies);
        
    }
    public static LinkedList<Movie> readMovieFile(String path){
        LinkedList<Movie> rtn=new LinkedList<Movie>();
        try{
            File f=new File(path);
            Scanner s=new Scanner(f);
            while(s.hasNextLine()){
                rtn.add(new Movie(s.nextLine()));
            }
            s.close();
        }catch(Exception e){e.printStackTrace();}
        Collections.sort(rtn);
        return rtn;
    }
    public static void makeMovieFile(LinkedList<Movie> movies){
        try{
            File file=new File("Chapter19\\MovieIndex\\movie_data\\movieOut.txt");
            FileWriter writer=new FileWriter(file);
            writer.write("Compared By Movie Title\n");
            for(Movie m:movies){
                writer.write(m+"");
            }
            writer.write("\nCompared By Director Name\n");
            movies.sort(new dirNameComp());
            for(Movie m:movies){
                writer.write(m+"");
            }
            
            writer.write("Actor List\n");
                for(Person a:Movie.getActors()){
                    writer.write(a+"\n");
                }
            writer.close();
        }catch(Exception e){System.out.println("writer crashed :(");}
    }
    public static class dirNameComp implements Comparator<Movie>{
        public int compare(Movie o1, Movie o2) {
            Person[] a1=o1.getDirectors();
            Person[] a2=o2.getDirectors();
            if(a1.length+a2.length>2) return -1;
            int num=a1[0].toString().substring(a1[0].toString().indexOf(" ")).compareTo(a2[0].toString().substring(a2[0].toString().indexOf(" ")));
            return num==0?a1[0].toString().substring(0,a1[0].toString().indexOf(" ")).compareTo(a2[0].toString().substring(0,a2[0].toString().indexOf(" "))):num;
        }
    }
}
