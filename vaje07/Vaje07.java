package P02.vaje07;

public class Vaje07 {

    public static void main(String[] args) {
        Banka banka = new Banka();
        banka.dodajTekociRacun(9368, 49.5600595733366);
        banka.polog(9368, 32.3123123);
        banka.dodajTekociRacun(4522, 44.9801438758871);
        banka.polog(4522, 48.312312313);
        banka.dodajTekociRacun(5891, 59.59085279963842);
        banka.polog(5891, 52.3213123);
        banka.dodajTekociRacun(8278, 44.9570265245065);
        banka.polog(8278, 12.23123);
        banka.izpisiTekoceRacune();

        banka.dodajVarcevalniRacun(3831, 0.002435151971189825);
        banka.polog(3831, 50);
        banka.dodajVarcevalniRacun(1262, 9.499420270531956);
        banka.polog(1262, 100);
        banka.izpisiVarcevalneRacune();
        banka.dodajObresti();
        banka.izpisiVarcevalneRacune();
        banka.dvig(3831, 100);
        banka.izpisiVarcevalneRacune();
    }

}

class VarcevalniRacun extends Racun{
    private double obresti;

    VarcevalniRacun(int stevilka, double obresti) {
        super(stevilka);
        this.obresti = obresti;
    }
    //Overrida metodo iz razreda Racun
    @Override
    public void dodajObresti(){
        polog(dobiStanje() * obresti);
    }
    public String toString(){
        return "Varcevalni racun " + super.toString() + ": obrestna mera = " + obresti;
    }

}

class TekociRacun extends Racun{
    private double limit;

    TekociRacun(int stevilka, double limit){
        super(stevilka);
        this.limit = limit;

    }

    public void dvig(double znesek){
        if(znesek < limit){
            super.dvig(znesek);
        }
    }
    public String toString(){
        return "Tekoci racun " + super.toString() + ": limit = " + limit;
    }

}

class Banka {
     public Racun[] racuni = new Racun[100];

    public void dodajTekociRacun(int stevilka, double limit) {
        for (int i = 0; i < this.racuni.length; i++)
            if(this.racuni[i] == null){
                this.racuni[i] = new TekociRacun(stevilka, limit);
                break;
            }
    }

    public void dodajVarcevalniRacun(int stevilka, double obresti) {
        for (int i = 0; i < this.racuni.length; i++)
            if(this.racuni[i] == null){
                this.racuni[i] = new  VarcevalniRacun(stevilka, obresti);
                break;
            }
    }

    public void dodajObresti() {
        for (int i = 0; i < this.racuni.length; i++) {
            if(this.racuni[i] == null)
                break;
            if(this.racuni[i] instanceof VarcevalniRacun){
                racuni[i].dodajObresti();
            }
        }
    }

    public void dvig(int stevilka, double znesek){
        for (Racun racun : racuni) {
            if (racun == null)
                break;
            if (racun.dobiStevilkoRacuna() == stevilka) {
                racun.dvig(znesek);
                break;
            }
        }
    }

    public void polog(int stevilka, double znesek){
        for (Racun racun : racuni) {
            if (racun == null)
                break;
            if (racun.dobiStevilkoRacuna() == stevilka) {
                racun.polog(znesek);
                break;
            }
        }
    }

    public void izpisiVarcevalneRacune(){
        System.out.print("\nVarcevalni racuni:\n");
        for (Racun racun : racuni){
            if (racun == null)
                break;
            if(racun instanceof VarcevalniRacun){
                System.out.println(racun);
            }
        }
    }

    void izpisiTekoceRacune(){
        System.out.print("\nTekoci racuni:\n");
        for (Racun racun : racuni){
            if (racun == null)
                break;
            if(racun instanceof TekociRacun){
                System.out.println(racun);
            }
        }
    }
}




