package Chapter14;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.awt.Color;
/**
 * Sean McLoughlin
 * HONOR PLEDGE: All work here is honestly obtained and is my own. Sean McLoughlin
 * Date of Completion: 3/15/23
 * Assignment: Term 2 Exam Corrections
 */
public class T2ExamCorrections {
    public static void main(String args[]){
        T2ExamCorrections e=new T2ExamCorrections();
        //Problem 2 Test
        Album alb2=e.new Album("album", "artist", "genre", new ArrayList<Song>(), 12);
        Album alb3=e.new Album(alb2);
        System.out.println(alb2.equals(alb3));
        //Problem 4 Test
        Color[][] c=new Color[100][100];
        Screen s=e.new Screen(c);
        s.drawRectangle(10, 10, 10, 10);
        
    }
    /**
     * Exam problem 2, Album Class design heirarchy
     */
    public class Song{
        private String title;
        private double duration;
        public Song(){}
        public Song(String title){
            this.title=title;
        }
        public double getDuration(){
            return duration;
        }
    }
    public class Album implements Comparable<Album>{
        private String title, artist, genre;private ArrayList<Song> tracks;private int playingTime;
        public Album(String title,String artist, String genre, ArrayList<Song> tracks, int playingTime){
            this.title=title;this.artist=artist;this.genre=genre;this.tracks=tracks;this.playingTime=playingTime;
        }
        public Album(){
            title="";genre="";artist="";tracks=new ArrayList<Song>();playingTime=0;
        }
        public Album(Album cpy){
            title=cpy.title;genre=cpy.genre;artist=cpy.artist;playingTime=cpy.playingTime;tracks=new ArrayList<Song>();
            for(Song song:cpy.tracks) tracks.add(song);
        }
        public void setTitle(String t){
            title=t;
        }
        public int getPlayTime(){
            return playingTime;
        }
        public String toString(){
            return title+" by "+artist+": "+genre;
        }
        public int compareTo(Album o) {
            return new String(artist+title).compareTo(new String(o.artist+o.title));
        }
        public boolean equals(Object o){
            return compareTo((Album)o)==0;
        }
        private void newTime(){
            playingTime=0;
            for(Song track:tracks)playingTime+=track.getDuration();
        }
    }
    public class ComparePT implements Comparator<Album>{
        public ComparePT(){}
        public int compare(Album a1,Album a2){
            return a1.getPlayTime()-a2.getPlayTime();
        }
    }
    /**
     * Exam problem 4, 2d Array Rectangles
     */
    public class Screen{
        private final Color BLACK=Color.BLACK;
        private final Color WHITE=Color.WHITE;
        private Color[][] pixels;
        public Screen(Color[][] pixels){this.pixels=pixels;}
        public int getSize(){return pixels.length;}
        public void drawRectangle(int row, int col, int height, int width){
            for(int i=row;i<row+height&&i<getSize();i++){
                pixels[i][col]=BLACK;
                if(col+width>=pixels[0].length)pixels[i][col+width]=BLACK;
            }
            for(int i=col;i<col+width&&i<pixels[i].length;i++){
                pixels[row][i]=BLACK;
                if(row+height>pixels.length) pixels[row+height][i]=BLACK;
            }
        }
        public void print(){
            for(int i=0;i<pixels.length;i++){
                for(int n=0;n<pixels[i].length;n++){
                    if(pixels[i][n].equals(BLACK)) System.out.println(" O ");
                    else System.out.println(" I ");
                }
            }
        }
        public void fillRectangle(int row, int col){
            if(row>=0&&row<pixels.length&&col>=0&&col<pixels[0].length&&pixels[row][col].equals(WHITE)){
                pixels[row][col]=BLACK;
                fillRectangle(row+1, col);
                fillRectangle(row-1, col);
                fillRectangle(row, col+1);
                fillRectangle(row, col-1);
            }
        }
    }
    /**
     * Exam problem 5, LeastPopular Shows
     */
    public static int matches(List<String> shows, String title){
        int rtn=0;
        for(String t:shows) if(t.equals(title))rtn++;
        return rtn;
    }
    public static String leastPopular(List<String> shows){
        int r=0,f=1;//r=position in list, f=frequency (default to 1)
        for(int i=1;i<shows.size();i++){
            int h=0;
            for(int n=0;n<shows.size();n++) if(shows.get(i).equals(shows.get(n)))h++;
            if(f<h){r=i;f=h;}
        }
        return shows.get(r);
    }
    public static void removeLeastPopular(List<String> shows){
        String s=leastPopular(shows);int h=0;
        while(h<shows.size()){
            if(shows.get(h).equals(s)) shows.remove(h);
            else h++;
        }
    }
}
