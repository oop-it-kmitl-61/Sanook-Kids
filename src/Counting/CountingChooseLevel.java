/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Counting;

import static Pattern.Ch6ChooseLevel.HEIGHT;
import static Pattern.Ch6ChooseLevel.TITLE;
import static Pattern.Ch6ChooseLevel.WIDTH;
import oop.Choose;

/**
 *
 * @author Husna
 */
public class CountingChooseLevel extends javax.swing.JFrame {

    /**
     * Creates new form CountingChooseLevel
     */
    
     public static final String TITLE = "สนุก Kids";
    public static final int WIDTH = 800;
    public static final int HEIGHT = 480;
    
    
    public CountingChooseLevel() {
        initComponents();
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    public void close() {
        this.setVisible(false);
        this.dispose();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bnEasy = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        bnMedium = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bnHard = new javax.swing.JButton();
        home = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/avatar2 (1)_1.gif"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, -10, 300, 450);

        jLabel4.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Easy ง่าย");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(390, 100, 130, 30);

        bnEasy.setBackground(new java.awt.Color(130, 173, 155));
        bnEasy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/choose/level/5-easy.png"))); // NOI18N
        bnEasy.setOpaque(false);
        bnEasy.setContentAreaFilled(false);
        bnEasy.setBorderPainted(false);
        bnEasy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnEasyActionPerformed(evt);
            }
        });
        getContentPane().add(bnEasy);
        bnEasy.setBounds(280, 60, 460, 110);

        jLabel3.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Medium ปานกลาง");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(360, 220, 200, 40);

        bnMedium.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/choose/level/5-medium.png"))); // NOI18N
        bnMedium.setOpaque(false);
        bnMedium.setContentAreaFilled(false);
        bnMedium.setBorderPainted(false);
        bnMedium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnMediumActionPerformed(evt);
            }
        });
        getContentPane().add(bnMedium);
        bnMedium.setBounds(280, 190, 460, 100);

        jLabel1.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hard ยาก");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(390, 340, 130, 40);

        bnHard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/choose/level/5-hard.png"))); // NOI18N
        bnHard.setOpaque(false);
        bnHard.setContentAreaFilled(false);
        bnHard.setBorderPainted(false);
        bnHard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnHardActionPerformed(evt);
            }
        });
        getContentPane().add(bnHard);
        bnHard.setBounds(280, 310, 460, 100);

        home.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 0, 18)); // NOI18N
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/home_4.png"))); // NOI18N
        home.setOpaque(false);
        home.setContentAreaFilled(false);
        home.setBorderPainted(false);
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        getContentPane().add(home);
        home.setBounds(0, 0, 70, 70);

        bg.setBackground(new java.awt.Color(204, 255, 204));
        bg.setForeground(new java.awt.Color(255, 0, 51));
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/choose/level/bg-level.png"))); // NOI18N
        getContentPane().add(bg);
        bg.setBounds(0, -10, 950, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bnEasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnEasyActionPerformed
        CountingEasy e = new CountingEasy();
        e.setVisible(true);
        close();
    }//GEN-LAST:event_bnEasyActionPerformed

    private void bnMediumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnMediumActionPerformed
        CountingMedium m = new CountingMedium();
        m.setVisible(true);
        close();
    }//GEN-LAST:event_bnMediumActionPerformed

    private void bnHardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnHardActionPerformed
        CountingHard h = new CountingHard();
        h.setVisible(true);
        close();
    }//GEN-LAST:event_bnHardActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        Choose c = new Choose();
        c.setVisible(true);
        close();
    }//GEN-LAST:event_homeActionPerformed

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
            java.util.logging.Logger.getLogger(CountingChooseLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CountingChooseLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CountingChooseLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CountingChooseLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CountingChooseLevel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton bnEasy;
    private javax.swing.JButton bnHard;
    private javax.swing.JButton bnMedium;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}