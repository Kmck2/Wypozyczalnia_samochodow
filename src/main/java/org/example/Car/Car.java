package org.example.Car;

public class Car {

    String kolor;
    String model;
    String marka;
    String data_wyp;
    String data_od;
    float cena;
    int moc;

    Car(String kolor, String model, String marka, float cena, int moc, String data_wyp, String data_od)
    {
        this.kolor = kolor;
        this.model = model;
        this.marka = marka;
        this.data_wyp = data_wyp;
        this.data_od = data_od;
        this.cena = cena;
        this.moc = moc;
    }

    //Gettery
    public String Getkolor() {return kolor;}

    public String Getmodel() {return model;}

    public String Getmarka() {return marka;}

    public String Getdata_wyp() {return data_wyp;}

    public String data_od() {return data_od;}

    public float Getcena() {return cena;}

    public int Getmoc() {return moc;}

    //Settery
    public void Setkolor(String kolor){this.kolor = kolor;}

    public void Setmodel(String model){this.model = model;}

    public void Setmarka(String marka){this.marka = marka;}

    public void Setdata_wyp(String data_wyp){this.data_wyp = data_wyp;}

    public void Setdata_od(String data_od){this.data_od = data_od;}

    public void Setcena(float cena){this.cena = cena;}

    public void Setmoc(int moc){this.moc = moc;}


}
