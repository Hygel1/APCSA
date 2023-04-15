package Chapter19.MovieIndex;

public class Person implements Comparable<Person>{
    private String name;

    public Person(String name){
        this.name=name;
    }
    public boolean equals(Person a){
        return a.name.equals(name);
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return name;
    }
    public int compareTo(Person p){
        int num=name.substring(name.indexOf(" ")).compareTo(p.name.substring(p.name.indexOf(" ")));
        return num==0?name.substring(0,name.indexOf(" ")).compareTo(p.name.substring(0,name.indexOf(" "))):num;
    }
}
