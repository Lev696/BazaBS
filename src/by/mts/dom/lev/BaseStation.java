package by.mts.dom.lev;

public class BaseStation {

    int number;
    String oblast;
    String rayon;
    String adres;
    String konstrukciya;

    public BaseStation(int num) {
        this.number=num;
    }

    @Override
    public String toString() {
        return "BaseStation{" +
                "Number=" + number +
                ", Oblast='" + oblast + '\'' +
                ", Rayon='" + rayon + '\'' +
                ", Adres='" + adres + '\'' +
                ", Konstrukciya='" + konstrukciya + '\'' +
                '}';
    }

    public BaseStation(int num, String obl, String ray, String adr, String konstrukt) {
        this.number = num;   // этот this говорит, что мы обращаемся к конкретно этому элементу класса
        this.oblast = obl;
        this.rayon = ray;
        this.adres = adr;
        this.konstrukciya = konstrukt;
         
    }
}
