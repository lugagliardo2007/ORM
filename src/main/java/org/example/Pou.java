package org.example;
import jakarta.persistence.*;

@Entity
public class Pou {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int hambre;
    private int felicidad;
    private int suciedad;
    private int energia;

    public Pou() {}

    public Pou(String nombre) {
        this.nombre = nombre;
        this.hambre = 50;
        this.felicidad = 50;
        this.suciedad = 20;
        this.energia = 70;
    }

    public void ajustarLimites() {
        this.hambre = Math.max(0, Math.min(100, this.hambre));
        this.felicidad = Math.max(0, Math.min(100, this.felicidad));
        this.suciedad = Math.max(0, Math.min(100, this.suciedad));
        this.energia = Math.max(0, Math.min(100, this.energia));
    }


    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getHambre() { return hambre; }
    public void setHambre(int hambre) { this.hambre = hambre; }
    public int getFelicidad() { return felicidad; }
    public void setFelicidad(int felicidad) { this.felicidad = felicidad; }
    public int getSuciedad() { return suciedad; }
    public void setSuciedad(int suciedad) { this.suciedad = suciedad; }
    public int getEnergia() { return energia; }
    public void setEnergia(int energia) { this.energia = energia; }}