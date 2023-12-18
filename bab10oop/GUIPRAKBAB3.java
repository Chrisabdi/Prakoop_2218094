package bab10oop;
import ProjectPraktikum2023.GUI_Mahasiswa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author CHRISABDI
 */

public class GUIPRAKBAB3 extends javax.swing.JFrame {

    /**
     * Creates new form GUIPRAKBAB3
     */
    public GUIPRAKBAB3() {
        initComponents();
        tampil();
    }
       public Connection conn;
       String menu, pilmenu;
    
       public void itempilih() {
        porsi.getText();
        harga.getText();
        total.getText();
        if (rb1.isSelected()) {
            pilmenu ="Ikan Bakar";
            
        } else if(rb2.isSelected()) {
            pilmenu = "Ayam Panggang";
        } else {
                pilmenu = "Roested Beef";
                } 
    }

    public void koneksi() throws SQLException {
        try {
            conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/oop_2218094?user=root&password=");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUIPRAKBAB3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(GUIPRAKBAB3.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception es) {
            Logger.getLogger(GUIPRAKBAB3.class.getName()).log(Level.SEVERE, null, es);
        }
    }
public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("Menu");
        tabelhead.addColumn("Pilihan");
        tabelhead.addColumn("Porsi");
        tabelhead.addColumn("Harga");
        tabelhead.addColumn("Total Bayar");
        try {
            koneksi();
            String sql = "SELECT * FROM tb_jualmakan";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6),});
            }
            tabelpesan.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }
public void batal() {
        porsi.setText("");
        harga.setText("");
        total.setText("");
        
    }


public void update() {
        String Porsi = porsi.getText();
        String Price = harga.getText();
        String Totb = total.getText();
        String pilmenu="";
        String jenis="";
        String food = (String) combomenu.getSelectedItem();
        if (rb1.isSelected()) {
            pilmenu = "Ikan Bakar";
            
        } else if(rb2.isSelected()) {
            pilmenu = "Ayam Panggang";
        } else {
                pilmenu = "Roested Beef";
                }        
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE tb_jualmakan SET `Menu`='" + jenis + "'," + "`Pilihan`='" + pilmenu + "',"
                    + "`Porsi`='" + Porsi + "'" + "`Harga`='" + Price + "'`Total Bayar`='" + Totb + "'");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Update Berhasil!");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        refresh();
    }
public void refresh() {
        new GUIPRAKBAB3().setVisible(true);
        this.setVisible(false);
    }
public void insert() {
        String Porsi = porsi.getText();
        int Price =0;
        int Totb=0;
        String pilmenu="";
        String jenis="";
        abstractpesanan mkn = new penjualanmakanan3();
        if(combomenu.getSelectedIndex()==0){
            rb1.setText(mkn.ikan);
            rb2.setText(mkn.ayam);
            rb3.setText(mkn.beef);
            if (rb1.isSelected()) {
                pilmenu = mkn.pilih;
                jenis = mkn.ikan;
                Price = mkn.harga;
                harga.setText(Integer.toString(mkn.harga));
                Totb = mkn.hitungTotal();
            } else if(rb2.isSelected()) {
                pilmenu = mkn.pilih;
                jenis = mkn.ayam;
                Price = mkn.harga;
                harga.setText(Integer.toString(mkn.harga));
                Totb = mkn.hitungTotal();
            } else {
                pilmenu = mkn.pilih;
                jenis = mkn.beef;
                Price = mkn.harga;
                harga.setText(Integer.toString(mkn.harga));
                Totb = mkn.hitungTotal();
            } 
        }else if(combomenu.getSelectedIndex()==1){
            mkn = new Minuman();
            rb1.setText(mkn.Jus);
            rb2.setText(mkn.Air);
            rb3.setText(mkn.EsTeh);
            if (rb1.isSelected()) {
                    pilmenu = mkn.getPilihan();
                    jenis = mkn.Jus;
                    Price = mkn.harga;
                    harga.setText(Integer.toString(mkn.harga));
                    Totb = mkn.hitungTotal();
                } else if(rb2.isSelected()) {
                    pilmenu = mkn.getPilihan();
                    jenis = mkn.Air;
                    Price = mkn.harga;
                    harga.setText(Integer.toString(mkn.harga));
                    Totb = mkn.hitungTotal();
                } else {
                    pilmenu = mkn.getPilihan();
                    jenis = mkn.EsTeh;
                    Price = mkn.harga;
                    harga.setText(Integer.toString(mkn.harga));
                    Totb = mkn.hitungTotal();
                } 
        }else if(combomenu.getSelectedIndex()==2){
            mkn = new Dessert();
            rb1.setText(mkn.EsKrim);
            rb2.setText(mkn.Puding);
            rb3.setText(mkn.Donat);
            if (rb1.isSelected()) {
                pilmenu =mkn.getPilihan();
                jenis = mkn.EsKrim;
                Price = mkn.harga;
                harga.setText(Integer.toString(mkn.harga));
                Totb = mkn.hitungTotal();
            } else if(rb2.isSelected()) {
                pilmenu = mkn.getPilihan();
                jenis = mkn.Puding;
                Price = mkn.harga;
                harga.setText(Integer.toString(mkn.harga));
                Totb = mkn.hitungTotal();
            } else {
                pilmenu = mkn.getPilihan();
                jenis = mkn.Donat;
                Price = mkn.harga;
                harga.setText(Integer.toString(mkn.harga));
                Totb = mkn.hitungTotal();
            } 
        }
        try {
            koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO tb_jualmakan (`Menu`, `Pilihan`,`Porsi`, `Harga`, `Total Bayar`)"
                    + "VALUES('" + pilmenu + "','" + jenis + "','" + Porsi + "','" + Price + "','" + Totb +"')");
            statement.close();
            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Makanan!" + "\n" + pilmenu );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
        }
        refresh();
    }
public void delete() {
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                String sql = "DELETE FROM tb_jualmakan WHERE `Porsi`='" + porsi.getText() + "'";
                java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
                batal();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal di hapus");
            }
        }
        refresh();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rb1 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();
        rb3 = new javax.swing.JRadioButton();
        combomenu = new javax.swing.JComboBox<>();
        porsi = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelpesan = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Penjualan Makanan");

        jLabel2.setText("Pilih Menu");

        jLabel3.setText("Pilihan");

        jLabel4.setText("Porsi");

        jLabel5.setText("Harga/porsi");

        jLabel6.setText("Total Pembayaran");

        buttonGroup1.add(rb1);
        rb1.setText("Ikan Bakar");

        buttonGroup1.add(rb2);
        rb2.setText("Roasted Beef");
        rb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb3);
        rb3.setText("Ayam Panggang");

        combomenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Makanan", "Minuman", "Dessert" }));
        combomenu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combomenuItemStateChanged(evt);
            }
        });
        combomenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combomenuMouseClicked(evt);
            }
        });
        combomenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combomenuActionPerformed(evt);
            }
        });

        harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaActionPerformed(evt);
            }
        });

        total.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                totalInputMethodTextChanged(evt);
            }
        });
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        jButton1.setText("Cetak");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tabelpesan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Pesanan", "Banyak Pesanan", "Harga/Porsi", "Total Bayar"
            }
        ));
        jScrollPane2.setViewportView(tabelpesan);

        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Hapus Daftar Tabel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combomenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rb2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(porsi)
                    .addComponent(harga)
                    .addComponent(total))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButton4)
                        .addGap(29, 29, 29)
                        .addComponent(jButton2)
                        .addContainerGap(405, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jButton1)
                        .addGap(30, 30, 30)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(rb1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combomenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(porsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton2))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
insert();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
update();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb2ActionPerformed

    private void combomenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combomenuActionPerformed
            
    }//GEN-LAST:event_combomenuActionPerformed

    private void hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaActionPerformed
      
       
    }//GEN-LAST:event_hargaActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
     
    }//GEN-LAST:event_totalActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
delete();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void combomenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combomenuMouseClicked
   
    }//GEN-LAST:event_combomenuMouseClicked

    private void combomenuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combomenuItemStateChanged
     String Porsi = porsi.getText();
        int Price =0;
        int Totb;
        String pilmenu="";
        String jenis="";
        abstractpesanan mkn = new penjualanmakanan3();
        if(combomenu.getSelectedIndex()==0){
            mkn = new penjualanmakanan3();
            rb1.setText(mkn.ikan);
            rb2.setText(mkn.ayam);
            rb3.setText(mkn.beef);
            if (rb1.isSelected()) {
                pilmenu = mkn.pilih;
                jenis = mkn.ikan;
                Price = mkn.harga;
                harga.setText(Integer.toString(mkn.harga));
                Totb = mkn.harga * mkn.porsi;
               
            } else if(rb2.isSelected()) {
                pilmenu = mkn.pilih;
                jenis = mkn.ayam;
                Price = mkn.harga;
                harga.setText(Integer.toString(mkn.harga));
                Totb = mkn.harga * mkn.porsi;
            } else {
                pilmenu = mkn.pilih;
                jenis = mkn.beef;
                Price = mkn.harga;
                harga.setText(Integer.toString(mkn.harga));
                Totb = mkn.harga * mkn.porsi;                
            } 
            total.setText(Integer.toString(Totb));
        }else if(combomenu.getSelectedIndex()==1){
            mkn = new Minuman();
            rb1.setText(mkn.Jus);
            rb2.setText(mkn.Air);
            rb3.setText(mkn.EsTeh);
            if (rb1.isSelected()) {
                    pilmenu = mkn.getPilihan();
                    jenis = mkn.Jus;
                    Price = mkn.harga;
                    harga.setText(Integer.toString(mkn.harga));
                Totb = mkn.harga * mkn.porsi;                
                } else if(rb2.isSelected()) {
                    pilmenu = mkn.getPilihan();
                    jenis = mkn.Air;
                    Price = mkn.harga;
                    harga.setText(Integer.toString(mkn.harga));
                Totb = mkn.harga * mkn.porsi;                
              
                } else {
                    pilmenu = mkn.getPilihan();
                    jenis = mkn.EsTeh;
                    Price = mkn.harga;
                    harga.setText(Integer.toString(mkn.harga));
                Totb = mkn.harga * mkn.porsi;                
                    
                } 
            total.setText(Integer.toString(Totb));
        }else if(combomenu.getSelectedIndex()==2){
            mkn = new Dessert();
            rb1.setText(mkn.EsKrim);
            rb2.setText(mkn.Puding);
            rb3.setText(mkn.Donat);
            if (rb1.isSelected()) {
                pilmenu =mkn.getPilihan();
                jenis = mkn.EsKrim;
                Price = mkn.harga;
                harga.setText(Integer.toString(mkn.harga));
                Totb = mkn.harga * mkn.porsi;                
            } else if(rb2.isSelected()) {
                pilmenu = mkn.getPilihan();
                jenis = mkn.Puding;
                Price = mkn.harga;
                harga.setText(Integer.toString(mkn.harga));
                Totb = mkn.harga * mkn.porsi;                
            } else {
                pilmenu = mkn.getPilihan();
                jenis = mkn.Donat;
                Price = mkn.harga;
                harga.setText(Integer.toString(mkn.harga));
                Totb = mkn.harga * mkn.porsi;                
            } 
            total.setText(Integer.toString(Totb));
        }
    }//GEN-LAST:event_combomenuItemStateChanged

    private void totalInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_totalInputMethodTextChanged
    String Porsi = porsi.getText();
        int Price =0;
        int Totb;
        String pilmenu="";
        String jenis="";
        abstractpesanan mkn = new penjualanmakanan3();
        if(combomenu.getSelectedIndex()==0){
            mkn = new penjualanmakanan3();
            rb1.setText(mkn.ikan);
            rb2.setText(mkn.ayam);
            rb3.setText(mkn.beef);
            if (rb1.isSelected()) {
                pilmenu = mkn.pilih;
                jenis = mkn.ikan;
                Price = mkn.harga;
                harga.setText(Integer.toString(mkn.harga));
                Totb = mkn.harga * mkn.porsi;
                total.setText(Integer.toString(Totb));                
            } else if(rb2.isSelected()) {
                pilmenu = mkn.pilih;
                jenis = mkn.ayam;
                Price = mkn.harga;
                harga.setText(Integer.toString(mkn.harga));
                Totb = mkn.harga * mkn.porsi;
                total.setText(Integer.toString(Totb));                
            } else {
                pilmenu = mkn.pilih;
                jenis = mkn.beef;
                Price = mkn.harga;
                harga.setText(Integer.toString(mkn.harga));
                Totb = mkn.harga * mkn.porsi; 
                total.setText(Integer.toString(Totb));                
            } 
            total.setText(Integer.toString(Totb));
        }else if(combomenu.getSelectedIndex()==1){
            mkn = new Minuman();
            rb1.setText(mkn.Jus);
            rb2.setText(mkn.Air);
            rb3.setText(mkn.EsTeh);
            if (rb1.isSelected()) {
                    pilmenu = mkn.getPilihan();
                    jenis = mkn.Jus;
                    Price = mkn.harga;
                    harga.setText(Integer.toString(mkn.harga));
                    Totb = mkn.harga * mkn.porsi;          
                 total.setText(Integer.toString(Totb));                
                } else if(rb2.isSelected()) {
                    pilmenu = mkn.getPilihan();
                    jenis = mkn.Air;
                    Price = mkn.harga;
                    harga.setText(Integer.toString(mkn.harga));
                    Totb = mkn.harga * mkn.porsi;   
                    total.setText(Integer.toString(Totb));                

              
                } else {
                    pilmenu = mkn.getPilihan();
                    jenis = mkn.EsTeh;
                    Price = mkn.harga;
                    harga.setText(Integer.toString(mkn.harga));
                    Totb = mkn.harga * mkn.porsi; 
                    total.setText(Integer.toString(Totb));                

                    
                } 
            total.setText(Integer.toString(Totb));
        }else if(combomenu.getSelectedIndex()==2){
            mkn = new Dessert();
            rb1.setText(mkn.EsKrim);
            rb2.setText(mkn.Puding);
            rb3.setText(mkn.Donat);
            if (rb1.isSelected()) {
                pilmenu =mkn.getPilihan();
                jenis = mkn.EsKrim;
                Price = mkn.harga;
                harga.setText(Integer.toString(mkn.harga));
                Totb = mkn.harga * mkn.porsi;
                total.setText(Integer.toString(Totb));                
            } else if(rb2.isSelected()) {
                pilmenu = mkn.getPilihan();
                jenis = mkn.Puding;
                Price = mkn.harga;
                harga.setText(Integer.toString(mkn.harga));
                Totb = mkn.harga * mkn.porsi;
                total.setText(Integer.toString(Totb));
            } else {
                pilmenu = mkn.getPilihan();
                jenis = mkn.Donat;
                Price = mkn.harga;
                harga.setText(Integer.toString(mkn.harga));
                Totb = mkn.harga * mkn.porsi;
                total.setText(Integer.toString(Totb));                
                
            } 
        }
    }//GEN-LAST:event_totalInputMethodTextChanged

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIPRAKBAB3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPRAKBAB3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPRAKBAB3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPRAKBAB3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIPRAKBAB3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> combomenu;
    private javax.swing.JTextField harga;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField porsi;
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private javax.swing.JTable tabelpesan;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
