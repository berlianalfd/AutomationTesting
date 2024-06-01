# Final Project Automation Testing untuk pengujian API dan WEB Application Kelompok A8
## Description

Proyek ini merupakan tugas akhir untuk mata kuliah Praktikum Pengujian Perangkat Lunak, yang bertujuan untuk  mengimplementasikan pengujian otomatis pada API dan aplikasi web. Proyek ini mencakup pembuatan dan pelaksanaan skrip pengujian otomatis menggunakan berbagai alat dan metode yang telah dipelajari selama perkuliahan.
Software under test Web yang digunakan adalah web Swag labs (https://www.saucedemo.com/). Pengujian difokuskan pada semua fungsi, yaitu login, dashboard, detail produk, cart, checkout, hingga menu menggunakan environment pengujian web otomatis yang sudah disiapkan sebelumnya. Kemudian, membuat script test untuk pengujian fungsionalitas secara otomatis. 
Sedangkan Software under test API yang digunakan adalah dummy API (https://dummyapi.io/docs). Pengujian difokuskan pada semua method, yaitu Create, Get, Update, dan Deletemenggunakan environment pengujian web otomatis yang sudah disiapkan sebelumnya. Kemudian, membuat script test untuk pengujian secara otomatis.

## Member

- 211524004 | Berliana Elfada [@berlianalfd](https://github.com/berlianalfd)
- 211524005 | Cintia Ningsih [@cintianingsih](https://github.com/cintianingsih)
- 211524029 | Yane Pradita [@yanepradita](https://github.com/yanepradita)

## Testing Tools

- IDE : visual studio code
- Alat build otomatis : Apache Maven
- Tools buat runing : Terminal
- Sistem operasi : Window
- Framework testing : JUnit, Cucumber 
- Library automation testing : Selenium dan Rest Assured
- Bahasa pemrograman : Java

## Struktur File Program
Berikut merupakan struktur file dari projek script testing yang Kami buat

<img width="235" alt="foldersite" src="https://github.com/berlianalfd/AutomationTesting/assets/95121218/ddac5b73-196f-4e82-ad79-b8e3b9d069f4">

1. **main/java/**

   Folder ini berisi kode sumber Java inti untuk aplikasi project java.
   
2. **test/java/API**
   Merupakan subfolder yang menyimpan file script test untuk API
   - **stepDefinitions** merupakan package yang menyimpan definisi langkah untuk pengujian Gherkin. Dimana di dalamnya terdapat class - class untuk setiap method pengujian API.
   - **TestRunner** merupakan package yang menyimpan running pengujian untuk pengujian Gherkin. Dimana di dalamnya terdapat class, yaitu
         - **TestRunnerAPI.java**
     
      <img width="475" alt="foldersite" src="https://github.com/berlianalfd/AutomationTesting/assets/95121218/85a7ea69-6111-4a6b-9504-a1e047617b89">

3. **test/java/WEB**
   Merupakan subfolder yang menyimpan file script test untuk WEB
    - **pages** merupakan package yang berisikan class - class untuk setiap halaman atau bagian antarmuka pengguna.
   - **stepDefinitions** merupakan package yang menyimpan definisi langkah untuk pengujian Gherkin. Dimana di dalamnya terdapat class - class untuk setiap fungsi pengujian WEB.
   - **TestRunner** merupakan package yang menyimpan running pengujian untuk pengujian Gherkin. Dimana di dalamnya terdapat class, yaitu
         - **TestRunnerWEB.java**
     
      <img width="475" alt="foldersite" src="https://github.com/berlianalfd/AutomationTesting/assets/95121218/de667ded-8fe5-475a-a3f6-494236e13153">

4. **test/java/resources/features**
   Package features yang berisikan file .feature untuk mendefinisikan skenario pengujian menggunakan sintaks Gherkin.
   - **API**
     Package ini berisikan skenario pengujian API yang terdiri dari Create, Get, Update, dan Delete.
   - **WEB**
     Package ini berisikan skenario pengujian WEB yang terdiri dari Login, Logout, Menu, ProductDetail, Dashboard, Cart, dan Checkout.

5. **target**

   Folder ini digunakan oleh sistem build Java untuk menyimpan file class yang dikompilasi dan artefak lain yang dihasilkan atau dibuat secara otomatis selama proses build. 

7. **pom.xml**

   File ini adalah project object model (POM) untuk project Java Kami. Ini menentukan dependensi project pada library dan framework lain, serta pengaturan                       konfigurasi untuk proses build. 

## Test the program

Berikut merupakan perintah yang dapat di gunakan untuk melakukan test program menggunakan maven pada terminal.
1. Perintah dibawah digunakan untuk menguji semua package sekaligus
   
   ```sh
   mvn test
   ```

2. Perintah di bawah digunakan untuk menguji salah satu package
   - Perintah untuk pengujian semua class yang berada di package **API**
       ```sh
       mvn test -Dtest=API.TestRunner.TestRunnerAPI
       ```

   - Perintah untuk pengujian semua class yang berada di package **WEB**
       ```sh
       mvn test -Dtest=WEB.TestRunner.TestRunnerWEB
       ```

3. Perintah di bawah digunakan untuk menguji satu skenario test yang terdapat pada satu class test dalam satu package.
   - Perintah untuk pengujian satu test case yang berada di package **API**
       - contoh pada Delete.feature dengan tags scenario **TC0.3.1**
         ```sh
           mvn test -Dcucumber.filter.tags="@TC0.3.1" -Dtest=.API.TestRunner.TestRunnerAPI
           ```
   - Perintah untuk pengujian satu test case yang berada di package **WEB**
       - contoh pada Login.feature dengan tags scenario **TC0.1.1**
          ```sh
           mvn test -Dcucumber.filter.tags="@TC0.1.1" -Dtest=WEB.TestRunner.TestRunnerWEB

## Generate report by tools

1. Berikut merupakan perintah untuk generate report 

   ```sh
   mvn verify -DskipTests
   ```

2. Hasil dari generate report tersebut akan membuat folder site didalam folder target bernama **cucumber-report-web.html** dan **cucumber-report-web.html**


         
  
