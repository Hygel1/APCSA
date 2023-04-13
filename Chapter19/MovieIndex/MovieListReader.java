package Chapter19.MovieIndex;
import java.util.LinkedList;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
public class MovieListReader {
    public static void main(String[] args){
        LinkedList<Movie> movies=readMovieFile("Chapter19\\MovieIndex\\movie_data\\movies.txt");
        System.out.println(movies);
        makeMovieFile(movies);
    }
    public static LinkedList<Movie> readMovieFile(String path){
        LinkedList<Movie> rtn=new LinkedList<>();
        try{
            File f=new File(path);
            Scanner s=new Scanner(f);
            while(s.hasNextLine()){
                rtn.add(new Movie(s.nextLine()));
            }
            s.close();
        }catch(Exception e){e.printStackTrace();}
        return rtn;
    }
    public static void makeMovieFile(LinkedList<Movie> movies){
        try{
            File file=new File("Chapter19\\MovieIndex\\movie_data\\movieOut.txt");
            FileWriter writer=new FileWriter(file);
            for(Movie m:movies){
                writer.write(m+"");
            }
            writer.close();
        }catch(Exception e){System.out.println("writer crashed :(");}
    }
}
