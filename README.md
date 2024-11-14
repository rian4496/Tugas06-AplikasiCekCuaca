# Tugas06-AplikasiCekCuaca
 Tugas06-M. Rian Gunadi-2210010497

![gambar](https://github.com/user-attachments/assets/68ac1afe-eac3-42b5-8aef-a9a7d29738cd)

![gambar](https://github.com/user-attachments/assets/b2faa665-379f-404e-9ce2-5eb488ff4945)

![gambar](https://github.com/user-attachments/assets/28c8ceaf-367d-4865-bf42-c207c5597168)

# Aplikasi Cek Cuaca Sederhana

Aplikasi ini adalah aplikasi desktop berbasis Java Swing yang digunakan untuk menampilkan informasi cuaca terkini berdasarkan nama kota yang dimasukkan pengguna. Aplikasi ini menggunakan API dari OpenWeatherMap untuk mengambil data cuaca.

## Fitur Utama
1. **Cek Cuaca Berdasarkan Nama Kota**: Pengguna dapat memasukkan nama kota dan menekan tombol "Cek Cuaca" untuk melihat informasi cuaca terkini di kota tersebut.
2. **Kota Favorit**: Aplikasi menyimpan kota yang telah dicari ke dalam daftar kota favorit untuk akses yang lebih cepat.
3. **Tampilkan Gambar Ikon Cuaca**: Aplikasi menampilkan ikon cuaca yang relevan berdasarkan kondisi cuaca di kota tersebut.
4. **Simpan dan Muat Data ke/dari CSV**: Pengguna dapat menyimpan hasil pencarian cuaca ke dalam file CSV dan memuat data dari file CSV.

## Teknologi yang Digunakan
- **Java Swing** untuk GUI (Graphical User Interface).
- **OpenWeatherMap API** untuk mendapatkan data cuaca.
- **JSON** untuk parsing data cuaca dari API.

## Prasyarat
- **Java Development Kit (JDK)** versi 8 atau lebih tinggi.
- **Koneksi internet** untuk mengambil data cuaca dari API.

## Cara Menggunakan Aplikasi
1. **Masukkan Nama Kota**: Ketik nama kota di kolom yang disediakan.
2. **Klik "Cek Cuaca"**: Tekan tombol "Cek Cuaca" untuk mengambil informasi cuaca.
3. **Lihat Hasil di Tabel**: Informasi cuaca akan ditampilkan di tabel, bersama dengan ikon cuaca.
4. **Simpan dan Muat Data CSV**:
   - **Simpan CSV**: Tekan tombol "Save CSV" untuk menyimpan data cuaca dalam file CSV.
   - **Muat CSV**: Tekan tombol "Load CSV" untuk memuat data dari file CSV ke dalam tabel.

## Konfigurasi API Key
Aplikasi ini memerlukan API Key dari OpenWeatherMap. Ikuti langkah-langkah berikut untuk mendapatkannya:
1. Daftar dan buat akun di [OpenWeatherMap](https://openweathermap.org/).
2. Pergi ke **API Keys** dan salin kunci API Anda.
3. Ganti nilai `apiKey` pada baris kode berikut di file `AplikasiCekCuacaSederhana.java`:
   ```java
   private final String apiKey = "YOUR_API_KEY_HERE";
