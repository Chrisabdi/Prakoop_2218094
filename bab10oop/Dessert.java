package bab10oop;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author CHRISABDI
 */
public class Dessert extends abstractpesanan {
    public Dessert() {
        this.EsKrim = "Ice Cream";
        this.Puding = "Pudding Coklat";
        this.Donat = "Donat";
        this.harga = 15000;
    }
    @Override
    public String getPilihan() {
        return "Dessert";
    }

    @Override
    public int hitungTotal() {
        total = harga * porsi;
        return total;
    }

    @Override
    public String getDeskripsi() {
        return "Anda memesan Dessert";
    }
}
