/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ROT13;
import DashBoard.frmDashBoard;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Ben
 */
public class frmROT13 extends javax.swing.JFrame {

    /**
     * Creates new form frmROT13
     */
    public frmROT13() {
        initComponents();
       
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPlainText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCipherText = new javax.swing.JTextField();
        btnAction = new javax.swing.JButton();
        btnAction1 = new javax.swing.JButton();
        btnChoose = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblFileChoose = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("PlainText");

        jLabel2.setText("CipherText");

        btnAction.setText("Action");
        btnAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionActionPerformed(evt);
            }
        });

        btnAction1.setText("Save");
        btnAction1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAction1ActionPerformed(evt);
            }
        });

        btnChoose.setText("Choose File");
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setText("ROT13");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(142, 142, 142))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAction, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(btnChoose))
                            .addComponent(txtPlainText)
                            .addComponent(txtCipherText, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAction1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)))
                .addComponent(lblFileChoose)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPlainText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCipherText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAction)
                    .addComponent(btnChoose)
                    .addComponent(lblFileChoose))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAction1)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionActionPerformed
         
         if("".equals(txtPlainText.getText())){
            JOptionPane.showMessageDialog(rootPane,"Hãy nhập PlainText");
        }
        else{
        txtCipherText.setText(cipherText(txtPlainText.getText()));
         }
    }//GEN-LAST:event_btnActionActionPerformed

    private void btnAction1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAction1ActionPerformed
       try{   
        writeFile();
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null, "Lưu thất bại");
        }
    }//GEN-LAST:event_btnAction1ActionPerformed

    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseActionPerformed
         try{   
        readFile();
        JOptionPane.showMessageDialog(null, "Mở thành công");
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null, "Mở thất bại");
        }
        
    }//GEN-LAST:event_btnChooseActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        frmDashBoard jfrm2= new frmDashBoard();
       this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        jfrm2.setSize(768, 400); 
        jfrm2.setVisible(true);
    }//GEN-LAST:event_formWindowClosing
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
                
                 txtPlainText.setEditable(false);
              
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(rootPane,"Không thể mở");          
            }
        }
        lblFileChoose.setText( f.getName());
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
                JOptionPane.showMessageDialog(null, "Lưu thành công");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(rootPane,"cannot open file");

            }
    }
    }
    /**
     * @param args the command line arguments
     */
    private int getIndex(String s){
        
        int i = 0;
        for (; i < alphabet.length; i++) {
            if (s.equalsIgnoreCase(alphabet[i]))
                return i;
        }
        return i;
    }
    private boolean isAlphabet(String s)
    {
        for (int i = 0 ; i < alphabet.length; i++) {
            if (s.equalsIgnoreCase(alphabet[i]))
                return true;
        }
        return false;
    }
    private String maHoaROT13(String s){
        int index;
        if(getIndex(s)/13 == 0)
            index = getIndex(s)+13;
        else 
            index = getIndex(s)-13;
         if(s.codePointAt(0) >64 && s.codePointAt(0) < 91)
        {
            return ALPHABET[index];
        }
        return alphabet[index];
    }
     
      
    private String cipherText(String s){
        String []as = s.split("");
        StringBuilder ex = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(isAlphabet(as[i]))
            ex.append(maHoaROT13(as[i]));
            else
            ex.append(as[i]);
        }
        return ex.toString();
    }
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
            java.util.logging.Logger.getLogger(frmROT13.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmROT13.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmROT13.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmROT13.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmROT13().setVisible(true);
            }
        });
    }
     private String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
     private String[] ALPHABET = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAction;
    private javax.swing.JButton btnAction1;
    private javax.swing.JButton btnChoose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblFileChoose;
    private javax.swing.JTextField txtCipherText;
    private javax.swing.JTextField txtPlainText;
    // End of variables declaration//GEN-END:variables
}
