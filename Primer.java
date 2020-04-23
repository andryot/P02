package P02;

public class Primer {
    public static void main(String[] args) {
        Stevilo a = new Stevilo(100);

        System.out.println(a.x);
        Stevilo b = new Stevilo(20);
        a.povecajX(5);
        System.out.println(a.kolikoJeX());
        b.povecajX(10);
        System.out.println(a.kolikoJeX());

        stevilo2 st2 = new stevilo2(6);

        st2.neki();
    }



}

class Stevilo {
    static int x;
    int b;
    Stevilo(int a){
        this.b = a;
    }
    public int kolikoJeX(){
        return x;
    }

    public void povecajX(int a){
        x+=a;
    }

}
class stevilo2 extends Stevilo {

    stevilo2(int n){
        super(n);
    }

    void izpis()
    {
        System.out.println(super.b);
    }

    void neki()
    {
        System.out.println("Blablabla");
    }
    
}