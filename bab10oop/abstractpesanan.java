/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bab10oop;

/**
 *
 * @author CHRISABDI
 */
//public abstract class abstractpesanan {
//protected String bahan,pilih;
//protected int harga,porsi;
//protected int total;
//    public abstract String getpesan();
//    public abstract int total();  
//    public abstract String getPilih();
//
//    public void setPilih(String pilih) {
//        this.pilih = pilih;
//    }
//
//    public int getTotal() {
//        return total;
//    } 
    public abstract class abstractpesanan {
    protected String pilih,ayam,beef,ikan;
    protected String Jus, Air, EsTeh;
    protected String EsKrim, Puding, Donat;
    protected int harga;
    protected int porsi;
    protected int total;

    public abstract String getPilihan();
    public abstract int hitungTotal();
    public abstract String getDeskripsi();
    }

