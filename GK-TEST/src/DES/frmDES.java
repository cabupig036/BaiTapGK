/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DES;

import static java.lang.Integer.parseInt;
import java.util.Arrays;

/**
 *
 * @author Tu Khuyen
 */
public class frmDES extends javax.swing.JFrame {

    /**
     * Creates new form frmDES
     */
    public frmDES() {
        initComponents();
        String[] stubResultEboxes = {"0","1","1","0","1","0","1","1","0","1","0","1","0","0","0","1","1","1","0","1","0","0","1","0","1","1","0","0","1","1","0","0",
     
        String a = "0111010100101000011110000011100101110100100100111100101101110000";
        String[] s = a.split("");
        String[] PC1 = PC1Performed(s);
        setCD(PC1);
        System.out.println("------------------------------------------------");
        String[] C = CDNumber( C0,6);
        String[] D = CDNumber( D0,6);
        System.out.println(Arrays.toString(keyNumber(C, D)));
        /*
        String a = "1001001";
        String[] s= a.split("");
       System.out.println(Arrays.toString(s));
        System.out.println(Arrays.toString(shift1(s)));
        */
        
        
        
       /* String[] stubResultEboxes = {"0","1","1","0","1","0","1","1","0","1","0","1","0","0","0","1","1","1","0","1","0","0","1","0","1","1","0","0","1","1","0","0",
        "1","0","1","1","0","1","1","0","0","0","0","1","1","0","1","0"};
        
        String[] sBoxesStub = sBoxesPerform(stubResultEboxes);
        String[] pBoxesStub = pBoxesPerform(sBoxesStub);
        RPTFinal(pBoxesStub);
        */
    }
    String[] RPT  = new String[32];
    String[] LPT = new String[32];
    String[] swapRPT = new String[32];
    String[] C0 = new String[28];
    String[] D0 = new String[28];
    final int[][] SBOX_0 = {
        {14,4,13,1,2,15,11,8,3,10,6,12,5,9,0,7},
        {0,15,7,4,14,2,13,1,10,6,12,11,9,5,3,8},
        {4,1,14,8,13,6,2,11,15,12,9,7,3,10,5,0},
        {15,12,8,2,4,9,1,7,5,11,3,14,10,0,6,13}
    };
    final int[][] SBOX_1 = {
        {15,1,8,14,6,11,3,4,9,7,2,13,12,0,5,10},
        {3,13,4,7,15,2,8,14,12,0,1,10,6,9,11,5},
        {0,14,7,11,10,4,13,1,5,8,12,6,9,3,2,15},
        {13,8,10,1,3,15,4,2,11,6,7,12,0,5,14,9}
    };
    final int[][] SBOX_2 = {
        {10,0,9,14,6,3,15,5,1,13,12,7,11,4,2,8},
        {13,7,0,9,3,4,6,10,2,8,5,14,12,11,15,1},
        {13,6,4,9,8,15,3,0,11,1,2,12,5,10,14,7},
        {1,10,13,0,6,9,8,7,4,15,14,3,11,5,2,12}
    };
    final int[][] SBOX_3 = {
        {7,13,14,3,0,6,9,10,1,2,8,5,11,12,4,15},
        {13,8,11,5,6,15,0,3,4,7,2,12,1,10,14,9},
        {10,6,9,0,12,11,7,13,15,1,3,14,5,2,8,4},
        {3,15,0,6,10,1,13,8,9,4,5,11,12,7,2,14}
    };
    final int[][] SBOX_4 = {
        {2,12,4,1,7,10,11,6,8,5,3,15,13,0,14,9},
        {14,11,2,12,4,7,13,1,5,0,15,10,3,9,8,6},
        {4,2,1,11,10,13,7,8,15,9,12,5,6,3,0,14},
        {11,8,12,7,1,14,2,13,6,15,0,9,10,4,5,3}
    };
    final int[][] SBOX_5 ={
        {12,1,10,15,9,2,6,8,0,13,3,4,14,7,5,11},
        {10,15,4,2,7,12,9,5,6,1,13,14,0,11,3,8},
        {9,14,15,5,2,8,12,3,7,0,4,10,1,13,11,6},
        {4,3,2,12,9,5,15,10,11,14,1,7,6,0,8,13}
    };
    final int[][] SBOX_6 = {
        {4,11,2,14,15,0,8,13,3,12,9,7,5,10,6,1},
        {13,0,11,7,4,9,1,10,14,3,5,12,2,15,8,6},
        {1,4,11,13,12,3,7,14,10,15,6,8,0,5,9,2},
        {6,11,13,8,1,4,10,7,9,5,0,15,14,2,3,12}
    };
    final int[][] SBOX_7 = {
        {13,2,8,4,6,15,11,1,10,9,3,14,5,0,12,7},
        {1,15,13,8,10,3,7,4,12,5,6,11,0,14,9,2},
        {7,11,4,1,9,12,14,2,0,6,10,13,15,3,5,8},
        {2,1,14,7,4,10,8,13,15,12,9,0,3,5,6,11}
    };
    final int[] P_BOX = {
        16,7,20,21,29,12,28,17,1,15,23,26,5,18,31,10,2,8,24,14,32,27,3,9,19,13,30,
        6,22,11,4,25
    };
    final int[] IP ={
        58,50,42,34,26,18,10,2,60,52,44,36,28,20,12,4,62,54,46,38,30,22,16,6,64,56,48,40,32,24,16,8,57,49,41,33,25,17,9,1,
        59,51,43,35,27,19,11,3,61,53,45,37,29,21,13,5,63,55,47,39,31,23,15,7
    };
    final int[] PC1 ={
        57,49,41,33,25,17,9,1,58,50,42,34,26,18,10,2,59,51,43,35,27,19,11,3,60,52,
        44,36,63,55,47,39,31,23,15,7,62,54,46,38,30,22,14,6,61,53,45,37,29,21,13,5,28,20,12,4
    };
    final int[] PC2 ={
       14,17,11,24,1,5,3,28,15,6,21,10,23,19,12,4,26,8,16,7,27,20,13,2,
        41,52,31,37,47,55,30,40,51,45,33,48,44,49,39,56,34,53,46,42,50,36,29,32
    };
    private void RPTFinal(String[] pBoxResult)
    {
        for (int i = 0; i < pBoxResult.length; i++) {
            RPT[i] = XOR(pBoxResult[i], LPT[i]);
        }
    }
    private String[] sBoxesPerform(String[] eBoxesResult){
        String[] resultSBoxes = new String[32];
        int currentIndexResult = 0;
        for (int i = 0; i < eBoxesResult.length; i++) {
            String[] currentSbox = new String[6];
            for (int j = i; j < i+6; j++) {
                currentSbox[j%6] = eBoxesResult[j]; 
            }
            i = i+ 5;
            int row = parseInt(currentSbox[0]) + parseInt(currentSbox[5]);
            int column = parseInt(currentSbox[1])*(2*2*2)+parseInt(currentSbox[2])*(2*2)+parseInt(currentSbox[3])*(2)+parseInt(currentSbox[4]);
            int[][] boxName = getSBoxNameByIndex(i);
            int element = boxName[row][column];
            
            String[] convertElement = convertElementSboxToBinary(element);
            for (int index = 0; index < convertElement.length; index++) {
                resultSBoxes[currentIndexResult] = convertElement[index];
                currentIndexResult++;
            }
        }
        return resultSBoxes;
    }
    
    private String[] pBoxesPerform(String[] sBoxesResult){
        String[] result = new String[32];
        for (int i = 0; i < P_BOX.length; i++) {
            result[i] = sBoxesResult[P_BOX[i]-1];
        }
        return result;
    }
    
    private int[][] getSBoxNameByIndex(int lastIndexFromEbox){
        int indexSBox = lastIndexFromEbox / 6;
        int[][] nameBox = {};
        switch (indexSBox){
            case 0:
                nameBox =  SBOX_0;
                break;
            case 1:
                nameBox =  SBOX_1;
                break;
            case 2:
                nameBox =  SBOX_2;
                break;
            case 3:
                nameBox =  SBOX_3;
                break;
            case 4:
                nameBox =  SBOX_4;
                break;
            case 5:
                 nameBox = SBOX_5;
                 break;
            case 6:
                nameBox = SBOX_6;
                break;
            case 7:
                nameBox =  SBOX_7;
                break;
        }
        return nameBox;
    }
    
    private void twoHavlesPT(String[] ipResult){
        for (int i = 0; i < ipResult.length / 2; i++) {
            LPT[i] = ipResult[i];
            RPT[i+32] = ipResult[i+32];
        }
        swapRPT = RPT;
    }
    
    
    private String XOR(String firstChar, String secondChar){
        return String.valueOf(parseInt(firstChar) ^ parseInt(secondChar));
    }
    
    private String[] convertElementSboxToBinary(int elementConvertInt){
        
        int[] result = {0,0,0,0};
        int index = 0;
        while(elementConvertInt != 0){
            result[index] = elementConvertInt % 2;
            elementConvertInt = elementConvertInt / 2;
            index++;
        }
        int temp = result[3];
        result[3] = result[0];
        result[0] = temp;
        
        temp = result[2];
        result[2] = result[1];
        result[1] = temp;
        
        String[] binaryReturn = {
            String.valueOf(result[0]),
            String.valueOf(result[1]),
            String.valueOf(result[2]),
            String.valueOf(result[3])
        };
        return binaryReturn;
    }
    // <editor-fold defaultstate="collapsed" desc="Tri">  
    
    private void swapLeftAndRightPlainText(){
        String temp;
        for(int i = 0; i < 32; i++){
            temp = LPT[i];
            LPT[i] = RPT[i];
            RPT[i] = temp;
        }
    }
    private String finalPermutationPerform(String round16Result){
        String result = "";
        int[] finalPermutaionTable = new int[]{
                                    40,8,48,16,56,24,64,32,
                                    39,7,47,15,55,23,63,31,
                                    38,6,46,14,54,22,62,30,
                                    37,5,45,13,53,21,61,29,
                                    36,4,44,12,52,20,60,28,
                                    35,3,43,11,51,19,59,27,
                                    34,2,42,10,50,18,58,26,
                                    33,1,41, 9,49,17,57,25};
        for(int i : finalPermutaionTable){
            result += round16Result.charAt(i);
        }
        return result;
    }
    private String EBoxPerform(){
       String result = "";
       int[] eBoxTable = new int[]{
                                   32, 1, 2, 3, 4, 5,
                                    4, 5, 6, 7, 8, 9,
                                    8, 9,10,11,12,13,
                                   12,13,14,15,16,17,
                                   16,17,18,19,20,21,
                                   20,21,22,23,24,25,
                                   24,25,26,27,28,29,
                                   28,29,30,31,32, 1};
       for(int i : eBoxTable){
           result += RPT[i];
       }
       return result;
    }
    private String EboxXorKey(String eboxResult, String key){
        String result = "";
        for(int i = 0; i < 48; i++){
            result += XOR(String.valueOf(eboxResult.charAt(i)) , String.valueOf(key.charAt(i)));
        }
        return  result;
    }
    // </editor-fold> 
    //Dau
    private String[] IPPerformed (String[] plainText){
        String[] result = new String[64];
        for (int i = 0; i <IP.length; i++) {
            int index = IP[i]-1;
            result[i] = plainText[index];
        }
        return result;
        
    }
    private String[] PC1Performed (String[] key)
    {
        String[] result = new String[56];
           for (int i = 0; i <PC1.length; i++) {
            int index = PC1[i]-1;
            result[i] = key[index];
        }
        return result;
    }
     private String[] PC2Performed (String[] key)
    {
        String[] result = new String[48];
           for (int i = 0; i <PC2.length; i++) {
            int index = PC2[i]-1;
            result[i] = key[index];
        }
        return result;
    }
    private void setCD(String[] PC1){
        int j = 0;
        for (int i = 0; i < PC1.length; i++) {
            if(i<28)
                C0[i] = PC1[i];
            else{
            D0[j] = PC1[i];
            j++;
            }
        }
    }
    private String[] merge(String[] C,String[] D)
    {
        int j =0;
        String[] result = new String[56];
        for (int i = 0; i < 56; i++) {
            if(i<28)
            result[i] = C[i];
            else
            {
                result[i] = D[j];
                j++;
            }
        }
        return result;
    }
    private String[] CDNumber(String[] CD,int index){
        String[] CDPre = new String[28];
        CDPre = CD;
        for (int i = 1; i <= index; i++) {
              CDPre = shiftCD(CDPre, i);
        }
        return CDPre;
    }
    private String[] keyNumber(String[] CNumber,String[] DNumber)
    {
        String[] key56 = new String[56];
        key56 =  merge(CNumber, DNumber);
        String[] key48 = new String[48];
        key48 = PC2Performed(key56);
        return key48;
    }
 
    private String[] shiftCD(String[] CD,int index)
    {
        String[] result = new String[28];
        if(index == 1 || index == 2|| index == 9 || index==16)
        {
            result = shift1(CD);         
        }
        else
        {
            result = shift2(CD);
        }
        return result;
    }
   
            
    private String[] shift1(String[] s){
        String[] result = new String[s.length];
        
        for (int i = 0; i < s.length-1 ; i++) {
            result[i] = s[i+1];
        }
        result[s.length-1] = s[0];;
        return result;
    }
     private String[] shift2(String[] s){
         return   shift1(shift1(s));
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
        txtKey = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPlainText = new javax.swing.JTextField();
        btnEncryption = new javax.swing.JButton();
        btnDecryption = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCipher = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Key");

        txtKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKeyActionPerformed(evt);
            }
        });

        jLabel2.setText("Plaintext");

        txtPlainText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlainTextActionPerformed(evt);
            }
        });

        btnEncryption.setText("Encryption");
        btnEncryption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncryptionActionPerformed(evt);
            }
        });

        btnDecryption.setText("Decryption");
        btnDecryption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecryptionActionPerformed(evt);
            }
        });

        jLabel3.setText("CipherText");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEncryption)
                        .addGap(84, 84, 84)
                        .addComponent(btnDecryption))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPlainText, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                            .addComponent(txtKey))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(507, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(57, 57, 57)
                .addComponent(txtCipher, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(176, 176, 176))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCipher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPlainText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEncryption)
                    .addComponent(btnDecryption))
                .addContainerGap(226, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKeyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKeyActionPerformed

    private void txtPlainTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlainTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlainTextActionPerformed

    private void btnEncryptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEncryptionActionPerformed

    private void btnDecryptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecryptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDecryptionActionPerformed

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
            java.util.logging.Logger.getLogger(frmDES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDES().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDecryption;
    private javax.swing.JButton btnEncryption;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtCipher;
    private javax.swing.JTextField txtKey;
    private javax.swing.JTextField txtPlainText;
    // End of variables declaration//GEN-END:variables
}
