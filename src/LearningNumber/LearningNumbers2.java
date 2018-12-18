/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LearningNumber;

import static Addition.AdditionEP2.HEIGHT;
import static Addition.AdditionEP2.TITLE;
import static Addition.AdditionEP2.WIDTH;
import Sounds.CorrectSound;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JOptionPane;

import sun.audio.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author smytt
 */
public class LearningNumbers2 extends javax.swing.JFrame {
    public static final String TITLE = "สนุก Kids";
    public static final int WIDTH = 800;
    public static final int HEIGHT = 480;

    /**
     * Creates new form LearningNumbers1
     */
    public LearningNumbers2() {
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
    
        
//    public String[] getImages() {
//        File file = new File(getClass().getResource("/res/learnnumber").getFile());
//        String[] imagesList = file.list();
//        return imagesList;
//    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        three = new javax.swing.JButton();
        four = new javax.swing.JButton();
        five = new javax.swing.JButton();
        one = new javax.swing.JButton();
        two = new javax.swing.JButton();
        next = new javax.swing.JButton();
        next1 = new javax.swing.JButton();
        next2 = new javax.swing.JButton();
        next3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        three.setOpaque(false);
        three.setContentAreaFilled(false);
        three.setBorderPainted(false);
        three.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/learnnumber/9.png"))); // NOI18N
        three.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        three.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threeActionPerformed(evt);
            }
        });
        jPanel1.add(three);
        three.setBounds(50, 270, 210, 180);

        four.setOpaque(false);
        four.setContentAreaFilled(false);
        four.setBorderPainted(false);
        four.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/learnnumber/10.png"))); // NOI18N
        four.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        four.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fourActionPerformed(evt);
            }
        });
        jPanel1.add(four);
        four.setBounds(300, 260, 210, 180);

        five.setOpaque(false);
        five.setContentAreaFilled(false);
        five.setBorderPainted(false);
        five.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/learnnumber/11.png"))); // NOI18N
        five.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        five.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveActionPerformed(evt);
            }
        });
        jPanel1.add(five);
        five.setBounds(530, 120, 240, 290);

        one.setOpaque(false);
        one.setContentAreaFilled(false);
        one.setBorderPainted(false);
        one.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/learnnumber/7.png"))); // NOI18N
        one.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        one.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneActionPerformed(evt);
            }
        });
        jPanel1.add(one);
        one.setBounds(50, 70, 210, 180);

        two.setOpaque(false);
        two.setContentAreaFilled(false);
        two.setBorderPainted(false);
        two.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/learnnumber/8.png"))); // NOI18N
        two.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        two.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twoActionPerformed(evt);
            }
        });
        jPanel1.add(two);
        two.setBounds(300, 70, 210, 180);

        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/learnnumber/next.png"))); // NOI18N
        next.setOpaque(false);
        next.setContentAreaFilled(false);
        next.setBorderPainted(false);
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        jPanel1.add(next);
        next.setBounds(740, 10, 40, 60);

        next1.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 0, 24)); // NOI18N
        next1.setText("ถัดไป");
        next1.setOpaque(false);
        next1.setContentAreaFilled(false);
        next1.setBorderPainted(false);
        next1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next1ActionPerformed(evt);
            }
        });
        jPanel1.add(next1);
        next1.setBounds(650, 20, 130, 40);

        next2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/learnnumber/previous.png"))); // NOI18N
        next2.setOpaque(false);
        next2.setContentAreaFilled(false);
        next2.setBorderPainted(false);
        next2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next2ActionPerformed(evt);
            }
        });
        jPanel1.add(next2);
        next2.setBounds(20, 10, 40, 60);

        next3.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 0, 24)); // NOI18N
        next3.setText("ก่อนหน้า");
        next3.setOpaque(false);
        next3.setContentAreaFilled(false);
        next3.setBorderPainted(false);
        next3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next3ActionPerformed(evt);
            }
        });
        jPanel1.add(next3);
        next3.setBounds(30, 20, 130, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/bgsub.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 810, 480);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void threeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threeActionPerformed
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/learnnumber/sound9.wav"));
            clip.open(audio);
            clip.start();
            Thread.sleep(1500);
            clip.close();
            
        } catch (Exception ex) {
            Logger.getLogger(LearningNumbers1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_threeActionPerformed

    private void fiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveActionPerformed
        // TODO add your handling code here:
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/learnnumber/sound11.wav"));
            clip.open(audio);
            clip.start();
            Thread.sleep(1500);
            clip.close();
            
        } catch (Exception ex) {
            Logger.getLogger(LearningNumbers1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_fiveActionPerformed

    private void fourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourActionPerformed
        // TODO add your handling code here:
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/learnnumber/sound10.wav"));
            clip.open(audio);
            clip.start();
            Thread.sleep(1500);
            clip.close();
            
        } catch (Exception ex) {
            Logger.getLogger(LearningNumbers1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_fourActionPerformed

    private void twoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twoActionPerformed
        // TODO add your handling code here:
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/learnnumber/sound8.wav"));
            clip.open(audio);
            clip.start();
            Thread.sleep(1500);
            clip.close();
            
        } catch (Exception ex) {
            Logger.getLogger(LearningNumbers1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_twoActionPerformed

    private void oneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oneActionPerformed
        // TODO add your handling code here:
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/learnnumber/sound7.wav"));
            clip.open(audio);
            clip.start();
            Thread.sleep(1500);
            clip.close();
            
        } catch (Exception ex) {
            Logger.getLogger(LearningNumbers1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_oneActionPerformed

    private void next1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next1ActionPerformed
      LearningNumbers3 t = new LearningNumbers3();
        t.setVisible(true);
        close();
    }//GEN-LAST:event_next1ActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        LearningNumbers3 t = new LearningNumbers3();
        t.setVisible(true);
        close();
    }//GEN-LAST:event_nextActionPerformed

    private void next3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next3ActionPerformed
        LearningNumbers1 t = new LearningNumbers1();
        t.setVisible(true);
        close();
    }//GEN-LAST:event_next3ActionPerformed

    private void next2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next2ActionPerformed
        LearningNumbers1 t = new LearningNumbers1();
        t.setVisible(true);
        close();
    }//GEN-LAST:event_next2ActionPerformed

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
            java.util.logging.Logger.getLogger(LearningNumbers2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LearningNumbers2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LearningNumbers2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LearningNumbers2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LearningNumbers2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton five;
    private javax.swing.JButton four;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton next;
    private javax.swing.JButton next1;
    private javax.swing.JButton next2;
    private javax.swing.JButton next3;
    private javax.swing.JButton one;
    private javax.swing.JButton three;
    private javax.swing.JButton two;
    // End of variables declaration//GEN-END:variables
}