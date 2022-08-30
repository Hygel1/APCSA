public class FileOutputEC {
    //Sets variables to be used throughout class
    private static String name;
    private static int age;
    private static double favoriteDecimal;
    private static String likesIceCream;
    private static char favoriteLetter;

    public FileOutputEC(String theName, int theAge, double theFavoriteDecimal, boolean doesLikeIceCream, char theFavoriteLetter){
        // Sets class variables to parameters taken when called
        name=theName;
        age=theAge;
        favoriteDecimal=theFavoriteDecimal;
        if(doesLikeIceCream) likesIceCream="Yes"; //Converts boolean parameter to readable Yes/No answer
        else likesIceCream="No";
        favoriteLetter=theFavoriteLetter;
    }
    public  String toString(){
        return "Name: "+name+". Age: "+age+". Favorite Decimal: "+favoriteDecimal+". Do they like Ice Cream: "+likesIceCream+". Favorite Letter: "+favoriteLetter; //Converts data from variables into readable string
    }
}