package Chapter14.IndexMaker;
public class methodTest {
    public static void main(String[] args){
        testNew();
    }
    public static void testNew(){
        System.out.println(new IndexEntry("aa").equals(new IndexEntry("aa"))+" should be true");
        System.out.println(new IndexEntry("aaa").compareTo(new IndexEntry("bbb"))+" should be negative");
        System.out.println(new ComparatorAlphabetical(false).compare(new IndexEntry("a"),new IndexEntry("b"))+" should be negative");
        System.out.println(new ComparatorFrequency().compare(new IndexEntry("a"),new IndexEntry("b",12))+" should be negative");
        System.out.println(new ComparatorFrequency().compare(new IndexEntry("b",12),new IndexEntry("a",14))+" should be positive");
        sortList();
      }
      public static void sortList(){
        DocumentIndex d=new DocumentIndex();
        for(int i=0;i<(int)(Math.random()*100)+1;i++){ //create random DocumentIndex of max 100 entries
            String name=""; //init name String
            for(int n=0;n<10;n++){ //fill name String with max 10 random charachters
                name+=(char)(int)((Math.random()*26)+65); //select random character
            }
            d.add(new IndexEntry(name)); //create new IndexEntry with created name
            for(int q=0;q<(int)(Math.random()*10);q++){ //add max 10 random lines to search
                d.get(d.size()-1).addLineNum((int)(Math.random()*100)); //add random line to most recently added entry
            }
        }
        DocumentIndex d1=new DocumentIndex(d);d1.sort(new ComparatorFrequency());
        System.out.println("Frequency: "+d1);
        d1=new DocumentIndex(d);d1.sort(new ComparatorAlphabetical(false));
        System.out.println("Alphabetical: "+d1);
        d1=new DocumentIndex(d);d1.sort(new ComparatorAlphabetical(true));
        System.out.println("Reverse Alphabetical: "+d1);
        
      }
}
