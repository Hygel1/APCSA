public class GuitarHero {
    static String keyboardString="qwe4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    static GuitarString[] gS;
    public static void main(String[] args){
        for(int i=0;i<37;i++){
            gS[i]=new GuitarString(440*2*(i-24)/12);
        }
    }
}
