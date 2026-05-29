package org.example;
import jakarta.persistence.*;
@Entity
public class Alimento {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String nombre;
        private int aportaHambre;
        private int aportaFelicidad;
        private int aportaSuciedad;
        private int aportaEnergia;


        public Alimento() {}

        public Alimento(String nombre, int aportaHambre, int aportaFelicidad, int aportaSuciedad, int aportaEnergia) {
            this.nombre = nombre;
            this.aportaHambre = aportaHambre;
            this.aportaFelicidad = aportaFelicidad;
            this.aportaSuciedad = aportaSuciedad;
            this.aportaEnergia = aportaEnergia;
        }


        public int getId() { return id; }
        public String getNombre() { return nombre; }
        public int getAportaHambre() { return aportaHambre; }
        public int getAportaFelicidad() { return aportaFelicidad; }
        public int getAportaSuciedad() { return aportaSuciedad; }
        public int getAportaEnergia() { return aportaEnergia; }

}
