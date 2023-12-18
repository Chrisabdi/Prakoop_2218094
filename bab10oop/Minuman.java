package bab10oop;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author CHRISABDI
 */
public class Minuman extends abstractpesanan {
    public Minuman() {
        this.Jus = "Jus Buah";
        this.Air = "Air putih";
        this.EsTeh = "Es Teh Manis";
        this.harga = 25000;
    }
    @Override
    public String getPilihan() {
        return "Minuman";
    }

    @Override
    public int hitungTotal() {
        total = harga * porsi;
        return total;
    }

    @Override
    public String getDeskripsi() {
        return "Anda memesan minuman";
    }
}
