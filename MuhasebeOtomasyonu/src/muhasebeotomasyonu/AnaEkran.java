
package muhasebeotomasyonu;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/*
 Muhasebe sınıfı, ABilgiler arayüzünü implement eden ve IDataBase arayüzünü kullanarak
 çalışan bilgilerini yöneten sınıf
*/
class Muhasebe extends ABilgiler implements IDataBase  {

    // Polymorphism
    // Calisan sınıfı tipinde bir ArrayList, çalışanların bilgilerini tutmak için kullanılır
    private ArrayList<Calisan> calisanListesi;
    
    
    /**
     * Muhasebe sınıfının parametreli constructor'ı. 
     * @param calisanListesi Muhasebe sınıfına ait çalışan listesi
     * @param anaEkran Muhasebe sınıfının bağlı olduğu AnaEkran nesnesi
     */
    public Muhasebe(ArrayList<Calisan> calisanListesi,AnaEkran anaEkran) {
        this.calisanListesi = calisanListesi;
    }

    
    
    /**
     * interface sınıfıdan alınmış override edilmilş metot
     * Calisan eklemek icin kullanilan metot. Calisan bilgilerini alarak calisanListesi'ne ekler.
     * @param isim Calisanin ismi
     * @param telefon Calisanin telefon numarasi
     * @param departman Calisanin calistigi departman
     * @param maas Calisanin maasi
     * @param gun Calisanin calistigi gun sayisi
     */
    @Override
    public void calisan_ekle(String isim, String telefon, String departman, int maas, int gun){
                
        
        System.out.println("DENEME");
            
            
       try {
                    
            // Telefon numarasi uzunlugu kontrol edilir.
            if( telefon.length() != 10){
                 
                // Numara 10karakter değilse hata fırlat
                throw new MyException("Telefon Numarası 10 Haleni Olmalıdır!!!\nTelefon Numarasını 'Bilgileri Güncelle' butonundan güncelleyebilrisin...");
                        
            }else{
                        
                calisanListesi.add(new Calisan(isim, telefon, departman, maas, gun));
            }
                    
        } catch (MyException e) {
            System.out.println(e);
        }
      
            
        System.out.println("DENEME");
            

    }




    /**
     * Abstract sınıftan Calisan bilgilerini ekrana yazdırmak icin kullanilan metot.
     */
    @Override
    public void bilgileriGoster() {
        System.out.println("\n-----------------Calisan Bigileri-------------------");
        

        if (calisanListesi.isEmpty()) {
        System.out.println("Calisan listesi bos.");
    } else {
        for (Calisan calisan : calisanListesi) {
                     
            System.out.println("\nCalisan isim-soyisim: " + calisan.getIsim_soyisim());
            System.out.println("Calistigi departman: " + calisan.getDepartman());
            System.out.println("Calisan Maasi : " + calisan.getMaas());
            System.out.println("Telefon numarasi :" + calisan.getTelefon());
            System.out.println("Calistigi gun sayisi: " + calisan.getGun_sayisi());
        }
    }

    }
    
}



/**
 * AnaEkran sınıfı, kullanıcı arayüzünü oluşturan ve 
 * Muhasebe işlemlerini gerçekleştirmek için gerekli metodları içeren bir sınıftır.
 */
public class AnaEkran extends javax.swing.JFrame {
    
    
    /**
     * AnaEkran sınıfının parametresiz constructor'ı. Kullanıcı arayüzünü başlatır.
     */
    public AnaEkran() {
        initComponents();
    }
    /**
     * Kullanıcı arayüzünün bileşenlerini tanımlayan ve yerleştiren metod.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        calisan_ekle_butonu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        calisan_tablosu = new javax.swing.JTable();
        cikis_butonu = new javax.swing.JButton();
        maas_hesapla_butonu = new javax.swing.JButton();
        calisan_sil_butonu = new javax.swing.JButton();
        bilgileri_guncelle_butonu = new javax.swing.JButton();
        gun_alani = new javax.swing.JTextField();
        maas_alani = new javax.swing.JTextField();
        Telefon_alani = new javax.swing.JTextField();
        isim_soyisim_alani = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        mesaj_alani = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cb_departman = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Muhasebe Sistemi");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        calisan_ekle_butonu.setBackground(new java.awt.Color(51, 102, 255));
        calisan_ekle_butonu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        calisan_ekle_butonu.setText("Çalışan Ekle");
        calisan_ekle_butonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calisan_ekle_butonuActionPerformed(evt);
            }
        });

        calisan_tablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "İsim Soyisim", "Telefon Numarası", "Departman", "Maaş", "Gün"
            }
        ));
        calisan_tablosu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calisan_tablosuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(calisan_tablosu);

        cikis_butonu.setBackground(new java.awt.Color(255, 51, 51));
        cikis_butonu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cikis_butonu.setText("Çıkış Yap");
        cikis_butonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cikis_butonuActionPerformed(evt);
            }
        });

        maas_hesapla_butonu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        maas_hesapla_butonu.setText("Maaş Hesapla");
        maas_hesapla_butonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maas_hesapla_butonuActionPerformed(evt);
            }
        });

        calisan_sil_butonu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        calisan_sil_butonu.setText("Çalışan Sil");
        calisan_sil_butonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calisan_sil_butonuActionPerformed(evt);
            }
        });

        bilgileri_guncelle_butonu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bilgileri_guncelle_butonu.setText("Bilgileri Güncelle");
        bilgileri_guncelle_butonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bilgileri_guncelle_butonuActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("İsim - Soyisim :");

        mesaj_alani.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mesaj_alani.setForeground(new java.awt.Color(255, 0, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Telefonu Numarası :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Maaş :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Departman :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Gün Sayısı:");

        cb_departman.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cb_departman.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yazılım Geliştirme ", "Test ", "Müşteri Destek", "Satış ve Pazarlama", "Proje Yönetimi", "İnsan Kaynakları", "Finans", "Ar-Ge" }));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Ekran görüntüsü 2023-12-29 130251.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mesaj_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Telefon_alani, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(isim_soyisim_alani, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(maas_alani, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(gun_alani, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_departman, javax.swing.GroupLayout.Alignment.LEADING, 0, 193, Short.MAX_VALUE))
                                .addGap(68, 68, 68)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cikis_butonu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(calisan_ekle_butonu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(16, 16, 16))
                                .addComponent(bilgileri_guncelle_butonu)
                                .addComponent(maas_hesapla_butonu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(calisan_sil_butonu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cikis_butonu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gun_alani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(isim_soyisim_alani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(Telefon_alani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(cb_departman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(maas_alani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)))
                .addGap(27, 27, 27)
                .addComponent(mesaj_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(calisan_ekle_butonu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(bilgileri_guncelle_butonu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(maas_hesapla_butonu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(calisan_sil_butonu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    // ... (Oluşturulan bileşenlerin tanımlanması)

        /**
         * Çalışan ekleme butonuna tıklandığında çağrılan metod.
         */
    
    
    private void calisan_ekle_butonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calisan_ekle_butonuActionPerformed
        
        // CalisanListesi nesnesi oluşturuluyor.
        ArrayList<Calisan> calisanListesi= new ArrayList<Calisan>();
        
        
       
                
        mesaj_alani.setText(""); // Mesaj alanını temizle
        
        // JTable bileşeninin modelini alarak bir DefaultTableModel nesnesine atama yapılır.
        // Calisan tablosu modelini al
        DefaultTableModel model = (DefaultTableModel)calisan_tablosu.getModel();
        
        
        // Çalışan bilgileri alınıyor
            String isim_soyisim = isim_soyisim_alani.getText();
            String departman = cb_departman.getSelectedItem().toString();
            String telefon = Telefon_alani.getText();
            
        if(isim_soyisim_alani.getText().equals("")){
            mesaj_alani.setText("Çalışan ismi alanı boş bırakılamaz");
        }else{
            
            
            try {
                // Kullanıcıdan gelen string ifadeyi sayıya dönüştür
                
                int maas =  Integer.parseInt(maas_alani.getText());
                int gun_sayisi = Integer.parseInt(gun_alani.getText());
                
                // Muhasebe nesnesi oluşturuluyor
                Muhasebe muhasebe= new Muhasebe(calisanListesi,this);
            
                // Çalışan eklemek için muhasebe sınıfının ilgili metodu çağrılıyor
                muhasebe.calisan_ekle(isim_soyisim,telefon,departman,maas,gun_sayisi);
                
                // Çalışan bilgilerini göstermek için muhasebe sınıfının ilgili metodu çağrılıyor
                muhasebe.bilgileriGoster();
                
                // Dönüşüm başarılıysa burada işlemler yapılabilir
                
            } catch (NumberFormatException  e) {
                
                System.err.println("Hata: Geçersiz bir sayısal değer girişi !!!!\nBilgileri Güncelleyiniz.");
                mesaj_alani.setText("Hata: Geçersiz bir sayısal değer girişi !!!!\nBilgileri Güncelleyiniz.");
            }
            
            
            
            // Tabloya yeni çalışan ekleniyor.
            Object[] eklenecek = {isim_soyisim_alani.getText(),Telefon_alani.getText(),cb_departman.getSelectedItem().toString(),maas_alani.getText(),gun_alani.getText()   };
            model.addRow(eklenecek);
            JOptionPane.showMessageDialog(this, isim_soyisim_alani.getText()+ "  başariyla eklendi...");
            
            
            
            
       
        }
   
    }//GEN-LAST:event_calisan_ekle_butonuActionPerformed

    /**
    * Çalışan bilgilerini güncellemek için kullanılan actionPerformed metodu.
    */
    private void bilgileri_guncelle_butonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bilgileri_guncelle_butonuActionPerformed

        mesaj_alani.setText("");
        
        // Calisan tablosu modelini al
        DefaultTableModel model = (DefaultTableModel)calisan_tablosu.getModel();
        
        // Seçili satırın indeksini al
        int secili_row = calisan_tablosu.getSelectedRow();
        
        // Seçili satır kontrolü
        
        if( secili_row == -1){
            
            
            if(calisan_tablosu.getRowCount() == 0){
                mesaj_alani.setText("Calisan tablosu şuanda boş...");
            }else{
                mesaj_alani.setText("Lütfen güncellecek çalışan bilgilerini seçin...");
            }
        }else{
             // Seçili satırdaki değerleri güncelle
            model.setValueAt(isim_soyisim_alani.getText(), secili_row, 0);
            model.setValueAt(Telefon_alani.getText(), secili_row, 1);
            model.setValueAt(cb_departman.getSelectedItem(), secili_row, 2);
            model.setValueAt(maas_alani.getText(), secili_row, 3);
            model.setValueAt(gun_alani.getText(), secili_row, 4);
            
            // Bilgi mesajlarıyla kullanıcıyı bilgilendir
            mesaj_alani.setText("Çalışan biligileri başarıyla güncellendi...");
            JOptionPane.showMessageDialog(this, isim_soyisim_alani.getText()+" biligileri başarıyla güncellendi...");
        }


    }//GEN-LAST:event_bilgileri_guncelle_butonuActionPerformed
    
    
    /**
    * Çalışan tablosundan bir satıra tıklandığında çalışanın bilgilerini alan ve ilgili alanlara yerleştiren metod.
    */
    private void calisan_tablosuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calisan_tablosuMouseClicked

        // Calisan tablosu modelini al
        DefaultTableModel model = (DefaultTableModel)calisan_tablosu.getModel();
            
        // Seçili satırın indeksini al
        int secili_row = calisan_tablosu.getSelectedRow();
        
        // Seçili satırdaki değerleri ilgili alanlara yerleştir
        isim_soyisim_alani.setText(model.getValueAt(secili_row, 0).toString());
        Telefon_alani.setText(model.getValueAt(secili_row, 1).toString());
        cb_departman.setSelectedItem(model.getValueAt(secili_row, 2).toString());
        maas_alani.setText(model.getValueAt(secili_row, 3).toString());
        gun_alani.setText(model.getValueAt(secili_row, 4).toString());
        





    }//GEN-LAST:event_calisan_tablosuMouseClicked
    
    /**
    * Çalışan silme işlemini gerçekleştiren actionPerformed metodu.
    */
    private void calisan_sil_butonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calisan_sil_butonuActionPerformed

            
        // Calisan tablosu modelini al
        DefaultTableModel model = (DefaultTableModel)calisan_tablosu.getModel();
        
        // Seçili satırın indeksini al
        int secili_row  = calisan_tablosu.getSelectedRow();
        
        // Seçili satır kontrolü
        if(secili_row == -1){
            if(calisan_tablosu.getRowCount() == 0){
                mesaj_alani.setText("Çlaışan tablosu şaun boş...");
            }else{
                mesaj_alani.setText("Lütfen silinecek çalışanı seçin...");
            }
        }else{
            // Seçili satırı tablodan kaldır
            
            model.removeRow(secili_row);
            mesaj_alani.setText("Çalışan başariyla silindi...");
            
            JOptionPane.showMessageDialog(this, isim_soyisim_alani.getText()+ " başariyla silindi...");
            JOptionPane.showMessageDialog(this, "Çalışanın maaşını 'Maaş Hesapla'\nbutonuna tıklayarak hesaplayabilirisiniz. ");
        }
        

    }//GEN-LAST:event_calisan_sil_butonuActionPerformed
    /**
    *   Çıkış butonuna tıklandığında çağrılan actionPerformed metodu.
     */
    private void cikis_butonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cikis_butonuActionPerformed
        // Çıkış işlemini onayla
        int cevap = JOptionPane.showConfirmDialog(this, "Sistemden Çıkışınızı Onayliyor musunuz? ", "Çıkış Onayı", JOptionPane.YES_NO_OPTION);

        if (cevap == JOptionPane.YES_OPTION) {
             // Kullanıcı "Evet" düğmesine tıkladıysa çıkış yapılır.
        setVisible(false);
        } else {
            // Kullanıcı "Hayır" düğmesine tıkladıysa işleme devam edilir.
            // İsterseniz burada başka bir şey yapabilirsiniz.
            System.out.println("Çıkış iptal edildi. İşleme devam ediliyor...");
        }
        
        

    }//GEN-LAST:event_cikis_butonuActionPerformed

    /**
    * Maaş Hesapla butonuna tıklandığında çağrılan actionPerformed metodu.
    */
    private void maas_hesapla_butonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maas_hesapla_butonuActionPerformed


        mesaj_alani.setText("");// Mesaj alanını temizle
        
        // MaasHesapla sınıfından bir nesne oluştur ve görünür yap
        MaasHesapla maasHesapla = new MaasHesapla();
        
        maasHesapla.setVisible(true);
        
        maasHesapla.pack();
        maasHesapla.setLocationRelativeTo(null);
        
        

    }//GEN-LAST:event_maas_hesapla_butonuActionPerformed

   /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(GirisEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GirisEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GirisEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GirisEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        // AnaEkran sınıfını başlat
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnaEkran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Telefon_alani;
    private javax.swing.JButton bilgileri_guncelle_butonu;
    private javax.swing.JButton calisan_ekle_butonu;
    private javax.swing.JButton calisan_sil_butonu;
    private javax.swing.JTable calisan_tablosu;
    private javax.swing.JComboBox<String> cb_departman;
    private javax.swing.JButton cikis_butonu;
    private javax.swing.JTextField gun_alani;
    private javax.swing.JTextField isim_soyisim_alani;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField maas_alani;
    private javax.swing.JButton maas_hesapla_butonu;
    private javax.swing.JLabel mesaj_alani;
    // End of variables declaration//GEN-END:variables
}
