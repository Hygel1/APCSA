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
        return name.compareTo(p.name);
    }
}
