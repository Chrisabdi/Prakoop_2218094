package bab10oop;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author CHRISABDI
 */
//public class penjualanmakanan3 extends abstractpesanan {
// String seafood, daging, ayam;
//    public penjualanmakanan3() {
//        this.seafood = "Ikan Bakar";
//        this.daging = "Roasted Beef";
//        this.ayam = "Ayam Panggang";
//        this.harga = 35000;
//    }
//    @Override
//    public String getPilih(){
//        return pilih;
//    }
//    
//    @Override
//    public int total() {
//        total = harga * porsi;
//        return total;
//    }
//
//    @Override
//    public String getpesan() {
//        return "Anda memesan makanan";
//    }
    public class penjualanmakanan3 extends abstractpesanan {
    protected String ikan,beef,ayam;
    
    public penjualanmakanan3() {
        this.ikan = "Ikan Bakar";
        this.beef = "Roasted Beef";
        this.ayam = "Ayam Panggang";
        this.harga = 35000;
    }

    @Override
    public String getPilihan() {
        return "Makanan";
    }

    @Override
    public int hitungTotal() {
        total = harga * porsi;
        return total;
    }

    @Override
    public String getDeskripsi() {
        return "Anda memesan makanan";
    }
    }  
