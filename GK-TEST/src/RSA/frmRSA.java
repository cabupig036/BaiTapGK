/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSA;

import DashBoard.frmDashBoard;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Ben
 */
public class frmRSA extends javax.swing.JFrame {

    /**
     * Creates new form frmRSA
     */
    public frmRSA() {
        initComponents();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
     private void readFile(){
         JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(this);
        File f = chooser.getSelectedFile();
        String out = "";
        if(f != null){
            try {
                Scanner sc = new Scanner(f);
                
                while(sc.hasNext()){
                    out += sc.nextLine();
                }
                txtPlainText.setText(out);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(rootPane,"cannot open file");          
            }
        }
    }
    private void writeFile(){
    
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(this);
        //file select
        File f = chooser.getSelectedFile();
        
        if(f != null){
            Formatter saveFile;
            try {
                String input = txtCipherText.getText();
                saveFile = new Formatter(f);
                saveFile.format("%s", input);
                saveFile.close();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(rootPane,"cannot open file");

            }
        
    }
    }
    // <editor-fold defaultstate="collapsed" desc="Global variable"> 
       int p = randomNumber();
       int q = randomNumber();
       int e = gcd(p, q);
       int N = getN(p, q);
       int n = getPhiN(p, q);
       int d = calculateD(e, n);
       int[] Kpublic = new int[]{e,N};
       int[] Kprivate = new int[]{d,N};
       String privateKey;
    // </editor-fold> 
    
     // <editor-fold defaultstate="collapsed" desc="Function"> 
    private int randomNumber() {
        Random rand = new Random();
        int limit = 10;
        int value = rand.nextInt(limit) + 1;
        return value;
    }

    private int getN(int p, int q) {
        return p * q;
    }

    private int getPhiN(int p, int q) {
        return (p - 1) * (q - 1);
    }

    private int gcd(int e, int N) { //UCLN
        int r;
        while (N != 0) {
            r = e % N;
            e = N;
            N = r;
        }
        return e;
    }
    private int calculateD(int e, int n) {
        int i = 0;
        while (true) {
            if ((i * n + 1) % e == 0) {
                return (i * n + 1) / e;
            }
            i++;
        }
    }
// </editor-fold> 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPlainText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCipherText = new javax.swing.JTextField();
        btnEncryptFile = new javax.swing.JButton();
        btnDecrypt = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPrivateKey = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPublicKey = new javax.swing.JTextField();
        lblFileChoose = new javax.swing.JLabel();
        btnEncrypt = new javax.swing.JButton();
        btnDecryptFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("PlainText");

        jLabel2.setText("CipherText");

        btnEncryptFile.setText("EncryptFile");
        btnEncryptFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncryptFileActionPerformed(evt);
            }
        });

        btnDecrypt.setText("Decrypt");
        btnDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecryptActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("RSA ");

        jLabel4.setText("Private Key");

        jLabel5.setText("Public Key");

        btnEncrypt.setText("Encrypt");
        btnEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncryptActionPerformed(evt);
            }
        });

        btnDecryptFile.setText("DecryptFile");
        btnDecryptFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecryptFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(lblFileChoose)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addComponent(txtPlainText))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtCipherText))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtPrivateKey, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnEncryptFile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDecryptFile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEncrypt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDecrypt))
                            .addComponent(txtPublicKey, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPlainText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrivateKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtPublicKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEncryptFile, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDecrypt)
                        .addComponent(btnEncrypt)
                        .addComponent(btnDecryptFile)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCipherText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(lblFileChoose)
                .addGap(76, 76, 76))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEncryptFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptFileActionPerformed
       JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(this);
        File f = chooser.getSelectedFile();

        try {
            String[] fileName = f.toString().split("[.]");
            String extension = fileName[fileName.length - 1];
            KeyPair keyPair = generateKey();
            PublicKey keyPublic = keyPair.getPublic();
            txtPublicKey.setText(encodePublicKey(keyPublic));
            PrivateKey keyPrivate = keyPair.getPrivate();
            txtPrivateKey.setText(encodePrivateKey(keyPrivate));
            byte[] encrypt = encryptFile(f, keyPublic);
            byte[] privateByteKey = keyPrivate.getEncoded();
            File path = new File("encryptRSA." + extension);
            FileUtils.writeByteArrayToFile(new File("encryptRSA." + extension), encrypt);
            
            privateKey = encodePrivateKey(keyPrivate);
            FileUtils.writeByteArrayToFile(new File("keyPrivateRSA." + extension), privateByteKey);          
            JOptionPane.showMessageDialog(null, "File đã được mã hóa và lưu lại ở " + path.getAbsolutePath());

        } catch (IOException ex) {
            System.out.println("err");
        }
    }//GEN-LAST:event_btnEncryptFileActionPerformed

    private void btnDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecryptActionPerformed
        if("".equals(txtCipherText.getText())){
            JOptionPane.showMessageDialog(rootPane,"Hãy nhập CipherText");
        }
        else{
            PrivateKey keyPrivate = decodePrivateKey(txtPrivateKey.getText());
            String cipherText = txtCipherText.getText();
            String plainText = decryptText(cipherText, keyPrivate);
            txtPlainText.setText(plainText);
        }
    }//GEN-LAST:event_btnDecryptActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        frmDashBoard jfrm2= new frmDashBoard();
       this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        jfrm2.setSize(768, 400); 
        jfrm2.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void btnEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptActionPerformed
       KeyPair keyPair = generateKey();
      PublicKey keyPublic = keyPair.getPublic();
      txtPublicKey.setText(encodePublicKey(keyPublic));
      PrivateKey keyPrivate = keyPair.getPrivate();
      txtPrivateKey.setText(encodePrivateKey(keyPrivate));
      String plainText = txtPlainText.getText();
      String cipherText = encryptText(plainText, keyPublic);
      txtCipherText.setText(cipherText);
    }//GEN-LAST:event_btnEncryptActionPerformed

    private void btnDecryptFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecryptFileActionPerformed
       JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(this);
        File f = chooser.getSelectedFile();

        try {
            String[] fileName = f.toString().split("[.]");
            String extension = fileName[fileName.length - 1];
           
            String privateKeyLocal = txtPrivateKey.getText();
            if(txtPrivateKey.getText().isEmpty()){
              privateKeyLocal = this.privateKey;
            }
            byte[] decrypt = decryptFile(f, decodePrivateKey(privateKeyLocal));
            File path = new File("decryptRSA." + extension);
            FileUtils.writeByteArrayToFile(new File("decryptRSA." + extension), decrypt);
            JOptionPane.showMessageDialog(null, "File đã được giải mã và lưu lại ở " + path.getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("err");
        }
    }//GEN-LAST:event_btnDecryptFileActionPerformed
                                             
//     private void readFile(){
//         JFileChooser chooser = new JFileChooser();
//        chooser.showOpenDialog(this);
//        File f = chooser.getSelectedFile();
//        String out = "";
//        if(f != null){
//            try {
//                Scanner sc = new Scanner(f);
//                
//                while(sc.hasNext()){
//                    out += sc.nextLine();
//                }
//                txtPlainText.setText(out);
//                 txtPlainText.setEditable(false);
//              
//            } catch (FileNotFoundException ex) {
//                JOptionPane.showMessageDialog(rootPane,"Không thể mở");          
//            }
//        }
//        lblFileChoose.setText( f.getName());
//    }
    
//    private void writeFile(){
//    
//        // TODO add your handling code here:
//        JFileChooser chooser = new JFileChooser();
//        chooser.showSaveDialog(this);
//        //file select
//        File f = chooser.getSelectedFile();
//        
//        if(f != null){
//            Formatter saveFile;
//            try {
//                String input = txtCipherText.getText();
//                saveFile = new Formatter(f);
//                saveFile.format("%s", input);
//                saveFile.close();
//                 JOptionPane.showMessageDialog(null, "Lưu thành công");
//            } catch (FileNotFoundException ex) {
//                JOptionPane.showMessageDialog(rootPane,"cannot open file");
//
//            }
//        
//    }
//    }

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
            java.util.logging.Logger.getLogger(frmRSA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRSA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRSA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRSA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRSA().setVisible(true);
            }
        });
    }
    
    // <editor-fold defaultstate="collapsed" desc="File">
    private KeyPair generateKey( ){
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(1024);
            KeyPair pair = keyGen.generateKeyPair();
            
            return pair;
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(frmRSA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    private String encodePublicKey ( PublicKey key ){
        String encodedKey = "";
        if(key != null){
            encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
        }
        return encodedKey;
    }
    
    private PublicKey decodePublicKey (String encodeKey ){
        
        PublicKey publicKey = null;
        try{
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(encodeKey.getBytes()));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return publicKey;
    }
    private String encodePrivateKey ( PrivateKey key ){
        String encodedKey = "";
        if(key != null){
            encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
        }
        return encodedKey;
    }
    private PrivateKey decodePrivateKey(String key){
        PrivateKey privateKey = null;
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(key.getBytes()));
        KeyFactory keyFactory = null;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            privateKey = keyFactory.generatePrivate(keySpec);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return privateKey;
    }
    
    private byte[] encryptFile(File file, PublicKey key){
        
        Cipher desCipher;
        try {
            byte[] fileContent = Files.readAllBytes(file.toPath());
            
            desCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            desCipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] textEncrypted = desCipher.doFinal(fileContent);
            return  textEncrypted;
            
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IOException ex) {
            System.out.println("err");
        }
        return  null;
    }
    
    private byte[] decryptFile(File file, PrivateKey key){
        Cipher desCipher;
        try {
            byte[] fileContent = Files.readAllBytes(file.toPath());
            
            desCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            
            desCipher.init(Cipher.DECRYPT_MODE, key);
            
            byte[] textDecrypted = desCipher.doFinal(fileContent);
            
            return  textDecrypted;
            
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IOException ex) {
            System.out.println("err");
        }
        return  null;
    }
    private String encryptText(String text, PublicKey key){
        Cipher cipher;
        String cipherText="";
        try {
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[]cipherArray = cipher.doFinal(text.getBytes());
            cipherText = convertByteArrayToString(cipherArray);
            
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(frmRSA.class.getName()).log(Level.SEVERE, null, ex);
        }
	
	return cipherText;
    }
    private String decryptText (String text, PrivateKey key){
        Cipher cipher;
        String plainText="";
        byte[]textArr = convertStringToByteArray(text);
        try {
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            
            cipher.init(Cipher.DECRYPT_MODE, key);
            
            byte[]cipherArray = cipher.doFinal(textArr);
            
            plainText = convertByteArrayToString(cipherArray);
            
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(frmRSA.class.getName()).log(Level.SEVERE, null, ex);
        }
	
	return plainText;
    }
    private String convertByteArrayToString(byte[] array){
        String result = "";
        
        for(int i = 0; i < array.length; i++){
            result += (char) array[i];
        }
        
        return result;
    }
    private byte [] convertStringToByteArray(String str){
        
        byte[]array = new byte[str.length()];
        for(int i = 0; i < array.length; i++){
            array[i] = (byte) str.charAt(i);
        }
        return array;
    }
//    private void demo(){
//        JFileChooser chooser = new JFileChooser();
//        chooser.showOpenDialog(this);
//        File f = chooser.getSelectedFile();
//        
//        try {
//            
//            String extension = f.toString().split("[.]")[1];
//            
//            
//            SecretKey key = generateKey();
//            
//            byte[] textEncrypt = encryptFile(f, key);
//            
//            FileUtils.writeByteArrayToFile(new File("E:\\encrypt."+extension), textEncrypt);
//            
//            byte[] textDecrypt = decryptFile(new File("E:\\encrypt."+extension), key);
//            
//            FileUtils.writeByteArrayToFile(new File("E:\\decrypt."+extension), textDecrypt);
//            
//        } catch (IOException ex) {
//            System.out.println("err");
//        }
//    }
    // </editor-fold>  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDecrypt;
    private javax.swing.JButton btnDecryptFile;
    private javax.swing.JButton btnEncrypt;
    private javax.swing.JButton btnEncryptFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblFileChoose;
    private javax.swing.JTextField txtCipherText;
    private javax.swing.JTextField txtPlainText;
    private javax.swing.JTextField txtPrivateKey;
    private javax.swing.JTextField txtPublicKey;
    // End of variables declaration//GEN-END:variables
}
