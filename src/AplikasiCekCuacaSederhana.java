
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author HADI PC
 */
public class AplikasiCekCuacaSederhana extends javax.swing.JFrame {

    private final String apiKey = "07df57ec686790b155da3f0b59a7c39a";  // Ganti dengan API Key Anda

    // Fungsi untuk mengecek cuaca
    private void cekCuaca(String city) {
        if (city.isEmpty()) {
            return;  // Jika input kota kosong, tidak lanjutkan
        }

        // Ambil data cuaca dari API OpenWeatherMap
        String weatherData = getWeatherData(city);
        if (weatherData != null) {
            updateUI(weatherData, city);  // Update UI dengan data cuaca
            addCityToFavorites(city);
        }
    }

    // Fungsi untuk menambahkan kota ke dalam JComboBox tanpa duplikat
    private void addCityToFavorites(String city) {
        // Cek apakah kota sudah ada dalam JComboBox
        boolean isDuplicate = false;
        for (int i = 0; i < cbbKotaFavorit.getItemCount(); i++) {
            if (cbbKotaFavorit.getItemAt(i).equalsIgnoreCase(city)) {
                isDuplicate = true;
                break;
            }
        }

        // Jika tidak ada duplikat, tambahkan kota ke JComboBox
        if (!isDuplicate) {
            cbbKotaFavorit.addItem(city);
        }
    }

    // Fungsi untuk mengambil data cuaca dari API OpenWeatherMap
    private String getWeatherData(String city) {
        try {
            String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric&lang=id";
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } catch (Exception e) {
            // Jika terjadi error, tampilkan pesan error
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mengambil data cuaca: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Fungsi untuk memperbarui UI dengan data cuaca
    private void updateUI(String weatherData, String city) {
        try {
            // Parse data cuaca dari API (JSON)
            JSONObject jsonObject = new JSONObject(weatherData);
            String weatherMain = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            String weatherDescription = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
            String iconCode = jsonObject.getJSONArray("weather").getJSONObject(0).getString("icon");

            // Update label cuaca dan keterangan di UI
            labelCuaca.setText(weatherMain);
            labelKeterangan.setText(weatherDescription);

            // Mengambil dan menampilkan gambar cuaca
            String iconUrl = "http://openweathermap.org/img/wn/" + iconCode + "@2x.png";
            ImageIcon icon = new ImageIcon(new URL(iconUrl));
            labelGambarCuaca.setIcon(new ImageIcon(icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));

            // Tambahkan data cuaca ke tabel
            addWeatherDataToTable(city, weatherMain, weatherDescription);
        } catch (Exception e) {
            // Menampilkan error dalam bentuk dialog
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mengambil data cuaca: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Creates new form AplikasiCekCuacaSederhana
     */
    public AplikasiCekCuacaSederhana() {
        initComponents();

        // Contoh setup DefaultTableModel untuk tbHasil
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama Kota");
        model.addColumn("Cuaca");
        model.addColumn("Keterangan");
        tbHasil.setModel(model);

    }

    private void addWeatherDataToTable(String city, String weatherMain, String weatherDescription) {
        // Menambahkan data cuaca ke dalam tabel
        DefaultTableModel model = (DefaultTableModel) tbHasil.getModel();
        model.addRow(new Object[]{city, weatherMain, weatherDescription});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        tbHasil = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelCuaca = new javax.swing.JLabel();
        labelKeterangan = new javax.swing.JLabel();
        txtKota = new javax.swing.JTextField();
        cbbKotaFavorit = new javax.swing.JComboBox<>();
        labelGambarCuaca = new javax.swing.JLabel();
        btnCekCuaca = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(324, 120));

        tbHasil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbHasil);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Nama Kota");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Kota Favorit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanel1.add(jLabel2, gridBagConstraints);

        labelCuaca.setText("Cuaca...");
        labelCuaca.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanel1.add(labelCuaca, gridBagConstraints);

        labelKeterangan.setText("Keterangan...");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanel1.add(labelKeterangan, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanel1.add(txtKota, gridBagConstraints);

        cbbKotaFavorit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Banjarmasin", "Banjarbaru" }));
        cbbKotaFavorit.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbKotaFavoritItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanel1.add(cbbKotaFavorit, gridBagConstraints);

        labelGambarCuaca.setPreferredSize(new java.awt.Dimension(80, 80));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel1.add(labelGambarCuaca, gridBagConstraints);

        btnCekCuaca.setText("Cek Cuaca");
        btnCekCuaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekCuacaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        jPanel1.add(btnCekCuaca, gridBagConstraints);

        jButton1.setText("Load CSV");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        jPanel1.add(jButton1, gridBagConstraints);

        jButton2.setText("Save CSV");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        jPanel1.add(jButton2, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCekCuacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekCuacaActionPerformed
        cekCuaca(txtKota.getText());
    }//GEN-LAST:event_btnCekCuacaActionPerformed

    private void cbbKotaFavoritItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbKotaFavoritItemStateChanged
        txtKota.setText((String) cbbKotaFavorit.getSelectedItem());
    }//GEN-LAST:event_cbbKotaFavoritItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Menampilkan JFileChooser untuk memilih lokasi dan nama file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Simpan Data Cuaca");
        fileChooser.setSelectedFile(new java.io.File("data_cuaca.csv"));  // Nama default untuk file

        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            java.io.File fileToSave = fileChooser.getSelectedFile();
            try (FileWriter csvWriter = new FileWriter(fileToSave)) {
                // Menulis header tabel
                DefaultTableModel model = (DefaultTableModel) tbHasil.getModel();
                for (int i = 0; i < model.getColumnCount(); i++) {
                    csvWriter.append(model.getColumnName(i));
                    if (i < model.getColumnCount() - 1) {
                        csvWriter.append(",");
                    }
                }
                csvWriter.append("\n");

                // Menulis data dari tabel
                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        csvWriter.append(model.getValueAt(i, j).toString());
                        if (j < model.getColumnCount() - 1) {
                            csvWriter.append(",");
                        }
                    }
                    csvWriter.append("\n");
                }

                // Menutup FileWriter
                csvWriter.flush();

                // Menampilkan dialog sukses
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan ke file " + fileToSave.getAbsolutePath(), "Sukses", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Gagal menyimpan data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Menampilkan JFileChooser untuk memilih file yang akan dimuat
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Pilih File CSV");

        int userSelection = fileChooser.showOpenDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            java.io.File fileToOpen = fileChooser.getSelectedFile();
            try (BufferedReader csvReader = new BufferedReader(new FileReader(fileToOpen))) {
                String row;
                DefaultTableModel model = (DefaultTableModel) tbHasil.getModel();

                // Menghapus data lama di tabel sebelum memuat data baru
                model.setRowCount(0);
                model.setColumnCount(0);

                // Membaca header kolom
                if ((row = csvReader.readLine()) != null) {
                    String[] columns = row.split(",");
                    for (String column : columns) {
                        model.addColumn(column);
                    }
                    addCityToFavorites(columns[0]);
                }

                // Membaca data baris dari file CSV
                while ((row = csvReader.readLine()) != null) {
                    String[] data = row.split(",");
                    model.addRow(data);
                }

                // Menampilkan dialog sukses
                JOptionPane.showMessageDialog(null, "Data berhasil dimuat dari file " + fileToOpen.getAbsolutePath(), "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Gagal memuat data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AplikasiCekCuacaSederhana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplikasiCekCuacaSederhana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplikasiCekCuacaSederhana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplikasiCekCuacaSederhana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplikasiCekCuacaSederhana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCekCuaca;
    private javax.swing.JComboBox<String> cbbKotaFavorit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCuaca;
    private javax.swing.JLabel labelGambarCuaca;
    private javax.swing.JLabel labelKeterangan;
    private javax.swing.JTable tbHasil;
    private javax.swing.JTextField txtKota;
    // End of variables declaration//GEN-END:variables
}
