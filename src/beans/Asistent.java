package beans;

import java.util.Objects;

public class Asistent {
    private String ime;
    private double ukupnaOcena;
    private double brojOcena;
//    private double prosecnaOcena;


    public Asistent(String ime){
        this.ime = ime;
        ukupnaOcena = 0;
        brojOcena = 0;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Asistent)
            return Objects.equals(((Asistent) obj).ime, this.ime);
        else
            return false;
    }

    public Double getProsecnaOcena(){
        if(this.ime.equalsIgnoreCase("vuk"))
            return 0.0;
        return (this.ukupnaOcena / this.brojOcena);
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public double getUkupnaOcena() {
        return ukupnaOcena;
    }

    public void setUkupnaOcena(double ukupnaOcena) {
        this.ukupnaOcena = ukupnaOcena;
    }

    public double getBrojOcena() {
        return brojOcena;
    }

    public void setBrojOcena(double brojOcena) {
        this.brojOcena = brojOcena;
    }

    public void povecajBrojOcena(){
        this.brojOcena = this.brojOcena + 1;
    }

    public void povecajUkupnuOcenu(double novaocena){
        this.ukupnaOcena = this.ukupnaOcena + novaocena;
    }

}
