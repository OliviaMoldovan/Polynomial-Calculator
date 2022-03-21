package Model;

public class Monom {
    private double c;
    private double p;

    public Monom(double c, double p){

        this.c = c;
        this.p = p;
    }

    public void setCoeficient(double x){

        c = x;
    }

    public void setPutere(double x){

        p = x;
    }

    public double getCoeficient(){

        return c;
    }

    public double getPutere(){

        return p;
    }
}
