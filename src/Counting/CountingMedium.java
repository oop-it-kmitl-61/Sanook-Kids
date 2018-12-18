/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Counting;

import static Pattern.Ch6Pattern.HEIGHT;
import static Pattern.Ch6Pattern.WIDTH;
import Sounds.CorrectSound;
import static Subtraction.Ch4SubEasy1.TITLE;
import Subtraction.Ch4SubHard;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import oop.Choose;

/**
 *
 * @author Husna
 */
public class CountingMedium extends javax.swing.JFrame {

    /**
     * Creates new form CountingMedium
     */
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 480;

    private int scoreEarn = 0;
    private int scoreFalse = 0;
    private int checkNum =1;
    private int check = 1;
    private static final int scoreEnd = 10;

    private List<Counting.QuestionMedium> questionmedium;
    

    private Counting.QuestionMedium qstShow;
    

    private String[] options = {"OK"};
    
    public CountingMedium() {
        initComponents();
        setTitle(TITLE);
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        createQuestionMedium();
        qstShow = randomQuestionMedium();
        
        Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(90, 70, Image.SCALE_SMOOTH);
        Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(90, 70, Image.SCALE_SMOOTH);
        Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(90, 70, Image.SCALE_SMOOTH);

        frame.setIcon(new ImageIcon(imageQuestion));
        bn1.setIcon(new ImageIcon(answer1));
        bn2.setIcon(new ImageIcon(answer2));
        bn3.setIcon(new ImageIcon(answer3));
        sc.setText(scoreEarn + "");
        wrong.setText(scoreFalse+"");
    }
    
    public String[] getImages() {
        File file = new File(getClass().getResource("/res").getFile());
        String[] imagesList = file.list();
        return imagesList;
    }
    
 
    private void createQuestionMedium() {
        questionmedium = new ArrayList<Counting.QuestionMedium>();
        
        ImageIcon iconQuestion;
        ImageIcon iconAnswer1;
        ImageIcon iconAnswer2;
        ImageIcon iconAnswer3;
        
        // Question 1
        iconQuestion = new ImageIcon(getClass().getResource("/res/counting/medium/1.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/1_1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/2_1.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/3_1.png"));
        Counting.QuestionMedium qstm1 = new Counting.QuestionMedium(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1, "1");
        questionmedium.add(qstm1);
        
        
        // Question 2
         iconQuestion = new ImageIcon(getClass().getResource("/res/counting/medium/2.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/3_1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/2_1.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/1_1.png"));
        Counting.QuestionMedium qstm2= new Counting.QuestionMedium(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer2, "2");
        questionmedium.add(qstm2);
        
        
       // Question 3
        iconQuestion = new ImageIcon(getClass().getResource("/res/counting/medium/3.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/3_1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/5_1.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/4_1.png"));
        Counting.QuestionMedium qstm3= new Counting.QuestionMedium(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1, "1");
        questionmedium.add(qstm3);
        
        // Question 4
        iconQuestion = new ImageIcon(getClass().getResource("/res/counting/medium/4.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/3_1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/6_1.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/4_1.png"));
        Counting.QuestionMedium qstm4= new Counting.QuestionMedium(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer3, "3");
        questionmedium.add(qstm4);
        
        // Question 5
        iconQuestion = new ImageIcon(getClass().getResource("/res/counting/medium/5.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/4_1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/5_1.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/6_1.png"));
        Counting.QuestionMedium qstm5= new Counting.QuestionMedium(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer2, "2");
        questionmedium.add(qstm5);
        
        
       // Question 6
        iconQuestion = new ImageIcon(getClass().getResource("/res/counting/medium/6.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/5_1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/7_1.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/6_1.png"));
        Counting.QuestionMedium qstm6= new Counting.QuestionMedium(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer3, "3");
        questionmedium.add(qstm6);
        
        iconQuestion = new ImageIcon(getClass().getResource("/res/counting/medium/7.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/7_1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/8.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/6.png"));
        Counting.QuestionMedium qstm7= new Counting.QuestionMedium(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1, "1");
        questionmedium.add(qstm7);
        
        iconQuestion = new ImageIcon(getClass().getResource("/res/counting/medium/8.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/8_1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/9_1.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/7_1.png"));
        Counting.QuestionMedium qstm8= new Counting.QuestionMedium(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1, "1");
        questionmedium.add(qstm8);
        
        iconQuestion = new ImageIcon(getClass().getResource("/res/counting/medium/9.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/8_1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/7_1.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/counting/medium/bn/9_1.png"));
        Counting.QuestionMedium qstm9= new Counting.QuestionMedium(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer3, "3");
        questionmedium.add(qstm9);
    }
    
    public void close() {
        this.setVisible(false);
        this.dispose();
    }
    
    int randMedium;
    Timer timer;
    
    private Counting.QuestionMedium randomQuestionMedium() {
        Counting.QuestionMedium qstsmedium;
        randMedium = (int) (Math.random() * (6 - 1));
        qstsmedium = questionmedium.get(randMedium);

        System.out.println(randMedium);

        return qstsmedium;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        sc = new javax.swing.JLabel();
        symbn1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        symbn2 = new javax.swing.JLabel();
        wrong = new javax.swing.JLabel();
        frame = new javax.swing.JLabel();
        symbn3 = new javax.swing.JLabel();
        bn1 = new javax.swing.JButton();
        bn2 = new javax.swing.JButton();
        bn3 = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

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

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/scoreEarn.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(500, 10, 50, 40);

        sc.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 0, 36)); // NOI18N
        getContentPane().add(sc);
        sc.setBounds(550, 10, 60, 50);
        getContentPane().add(symbn1);
        symbn1.setBounds(140, 310, 150, 140);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/scoreFalse.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(670, 10, 40, 40);
        getContentPane().add(symbn2);
        symbn2.setBounds(390, 310, 150, 140);

        wrong.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 0, 36)); // NOI18N
        getContentPane().add(wrong);
        wrong.setBounds(710, 10, 60, 50);
        getContentPane().add(frame);
        frame.setBounds(210, 20, 340, 280);
        getContentPane().add(symbn3);
        symbn3.setBounds(620, 300, 150, 140);

        bn1.setBackground(new java.awt.Color(24, 32, 47));
        bn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn1ActionPerformed(evt);
            }
        });
        getContentPane().add(bn1);
        bn1.setBounds(50, 320, 150, 90);

        bn2.setBackground(new java.awt.Color(24, 32, 47));
        bn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn2ActionPerformed(evt);
            }
        });
        getContentPane().add(bn2);
        bn2.setBounds(310, 320, 160, 90);

        bn3.setBackground(new java.awt.Color(24, 32, 47));
        bn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn3ActionPerformed(evt);
            }
        });
        getContentPane().add(bn3);
        bn3.setBounds(580, 320, 160, 90);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/bgsub.png"))); // NOI18N
        getContentPane().add(bg);
        bg.setBounds(0, 0, 810, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        Choose c = new Choose();
        c.setVisible(true);
        close();
    }//GEN-LAST:event_homeActionPerformed

    
    
     ImageIcon symbnCorrect = new ImageIcon(getClass().getResource("/res/correct.png"));
    ImageIcon symbnIncorrect = new ImageIcon(getClass().getResource("/res/incorrect.png"));
    ImageIcon icon = new ImageIcon(getClass().getResource("/res/light.png"));
    
    private void bn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bn1ActionPerformed

        if ((scoreEarn + scoreFalse) >= 9) {
            if (qstShow.getAnswer1().equals(qstShow.getAnswer())) {
                try {
                    symbn1.setVisible(true);
                    symbn1.setIcon(symbnCorrect);
                    Clip correct = AudioSystem.getClip();
                    AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/correct-answer.wav"));
                    correct.open(audio);
                    correct.start();
                    Thread.sleep(900);
                    correct.close();
                } catch (Exception ex) {
                    Logger.getLogger(Ch4SubHard.class.getName()).log(Level.SEVERE, null, ex);
                }

                scoreEarn += 1;
                sc.setText(scoreEarn + "");

                JLabel label1 = new JLabel("ตอบถูก  " + scoreEarn + " ข้อ        " + "ตอบผิด  " + scoreFalse + " ข้อ");
                label1.setFont(new Font("BoonJot", Font.PLAIN, 20));

                int choice = JOptionPane.showOptionDialog(null, label1, "คะแนนรวม", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                if (choice == 0) {
                    Choose c = new Choose();
                    c.setVisible(true);
                    close();
                }

            } else {
                if (checkNum == 2) {
                    try {
                        symbn1.setVisible(true);
                        symbn1.setIcon(symbnIncorrect);
                        Clip correct = AudioSystem.getClip();
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/wrong-sound.wav"));
                        correct.open(audio);
                        correct.start();
                        Thread.sleep(800);
                        correct.close();
                    } catch (Exception ex) {
                        Logger.getLogger(Ch4SubHard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    scoreFalse += 1;
                    wrong.setText(scoreFalse + "");

                    JLabel label = new JLabel("คำตอบที่ถูกต้องคือ   " + qstShow.getAns() + "   ");
                    label.setFont(new Font("BoonJot", Font.PLAIN, 20));
                    JOptionPane.showMessageDialog(null, label, "เฉลย", JOptionPane.INFORMATION_MESSAGE, icon);

                    JLabel label1 = new JLabel("ตอบถูก  " + scoreEarn + " ข้อ        " + "ตอบผิด  " + scoreFalse + " ข้อ");
                    label1.setFont(new Font("BoonJot", Font.PLAIN, 20));

                    int choice = JOptionPane.showOptionDialog(null, label1, "คะแนนรวม", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    if (choice == 0) {
                        Choose c = new Choose();
                        c.setVisible(true);
                        close();
                    }
                } else {
                    try {
                        symbn1.setVisible(true);
                        symbn1.setIcon(symbnIncorrect);
                        Clip correct = AudioSystem.getClip();
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/wrong-sound.wav"));
                        correct.open(audio);
                        correct.start();
                        Thread.sleep(800);
                        correct.close();
                    } catch (Exception ex) {
                        Logger.getLogger(Ch4SubHard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    timer = new Timer(700, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            symbn1.setVisible(false);
                            timer.stop();
                        }
                    });
                    timer.start();
                    checkNum += 1;
                }
            }
        } else {
            if (qstShow.getAnswer1().equals(qstShow.getAnswer())) {
                try {
                    symbn1.setVisible(true);
                    symbn1.setIcon(symbnCorrect);
                    Clip correct = AudioSystem.getClip();
                    AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/correct-answer.wav"));
                    correct.open(audio);
                    correct.start();
                    Thread.sleep(900);
                    correct.close();
                } catch (Exception ex) {
                    Logger.getLogger(Ch4SubHard.class.getName()).log(Level.SEVERE, null, ex);
                }

                timer = new Timer(800, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        symbn1.setVisible(false);
                        qstShow = randomQuestionMedium();
                        checkNum = 1;

                        Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                        Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);
                        Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);
                        Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);

                        frame.setIcon(new ImageIcon(imageQuestion));
                        bn1.setIcon(new ImageIcon(answer1));
                        bn2.setIcon(new ImageIcon(answer2));
                        bn3.setIcon(new ImageIcon(answer3));
                        timer.stop();
                    }
                });
                timer.start();

                scoreEarn += 1;
                sc.setText(scoreEarn + "");
                check += 1;

            } else {
                if (checkNum == 2) {
                    try {
                        symbn1.setVisible(true);
                        symbn1.setIcon(symbnIncorrect);
                        Clip correct = AudioSystem.getClip();
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/wrong-sound.wav"));
                        correct.open(audio);
                        correct.start();
                        Thread.sleep(800);
                        correct.close();
                    } catch (Exception ex) {
                        Logger.getLogger(Ch4SubHard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JLabel label = new JLabel("คำตอบที่ถูกต้องคือ   " + qstShow.getAns() + "   ");
                    label.setFont(new Font("BoonJot", Font.PLAIN, 20));
                    JOptionPane.showMessageDialog(null, label, "เฉลย", JOptionPane.INFORMATION_MESSAGE, icon);

                    timer = new Timer(800, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            symbn1.setVisible(false);
                            qstShow = randomQuestionMedium();

                            Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                            Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);
                            Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);
                            Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);

                            frame.setIcon(new ImageIcon(imageQuestion));
                            bn1.setIcon(new ImageIcon(answer1));
                            bn2.setIcon(new ImageIcon(answer2));
                            bn3.setIcon(new ImageIcon(answer3));
                            timer.stop();
                        }
                    });
                    timer.start();

                    scoreFalse += 1;
                    wrong.setText(scoreFalse + "");
                    checkNum = 1;
                } else {
                    try {
                        symbn1.setVisible(true);
                        symbn1.setIcon(symbnIncorrect);
                        Clip correct = AudioSystem.getClip();
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/wrong-sound.wav"));
                        correct.open(audio);
                        correct.start();
                        Thread.sleep(800);
                        correct.close();
                    } catch (Exception ex) {
                        Logger.getLogger(Ch4SubHard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    timer = new Timer(700, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            symbn1.setVisible(false);
                            timer.stop();
                        }
                    });
                    timer.start();
                    checkNum += 1;
                }
            }
        }
    }//GEN-LAST:event_bn1ActionPerformed

    private void bn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bn2ActionPerformed
        if ((scoreEarn + scoreFalse) >= 9) {
            if (qstShow.getAnswer2().equals(qstShow.getAnswer())) {
                try {
                    symbn2.setVisible(true);
                    symbn2.setIcon(symbnCorrect);
                    Clip correct = AudioSystem.getClip();
                    AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/correct-answer.wav"));
                    correct.open(audio);
                    correct.start();
                    Thread.sleep(900);
                    correct.close();
                } catch (Exception ex) {
                    Logger.getLogger(Ch4SubHard.class.getName()).log(Level.SEVERE, null, ex);
                }

                scoreEarn += 1;
                sc.setText(scoreEarn + "");

                JLabel label1 = new JLabel("ตอบถูก  " + scoreEarn + " ข้อ        " + "ตอบผิด  " + scoreFalse + " ข้อ");
                label1.setFont(new Font("BoonJot", Font.PLAIN, 20));

                int choice = JOptionPane.showOptionDialog(null, label1, "คะแนนรวม", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                if (choice == 0) {
                    Choose c = new Choose();
                    c.setVisible(true);
                    close();
                }

            } else {
                if (checkNum == 2) {
                    try {
                        symbn2.setVisible(true);
                        symbn2.setIcon(symbnIncorrect);
                        Clip correct = AudioSystem.getClip();
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/wrong-sound.wav"));
                        correct.open(audio);
                        correct.start();
                        Thread.sleep(800);
                        correct.close();
                    } catch (Exception ex) {
                        Logger.getLogger(Ch4SubHard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    scoreFalse += 1;
                    wrong.setText(scoreFalse + "");

                    JLabel label = new JLabel("คำตอบที่ถูกต้องคือ   " + qstShow.getAns() + "   ");
                    label.setFont(new Font("BoonJot", Font.PLAIN, 20));
                    JOptionPane.showMessageDialog(null, label, "เฉลย", JOptionPane.INFORMATION_MESSAGE, icon);

                    JLabel label1 = new JLabel("ตอบถูก  " + scoreEarn + " ข้อ        " + "ตอบผิด  " + scoreFalse + " ข้อ");
                    label1.setFont(new Font("BoonJot", Font.PLAIN, 20));

                    int choice = JOptionPane.showOptionDialog(null, label1, "คะแนนรวม", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    if (choice == 0) {
                        Choose c = new Choose();
                        c.setVisible(true);
                        close();
                    } else {
                        try {
                            symbn2.setVisible(true);
                            symbn2.setIcon(symbnIncorrect);
                            Clip correct = AudioSystem.getClip();
                            AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/wrong-sound.wav"));
                            correct.open(audio);
                            correct.start();
                            Thread.sleep(800);
                            correct.close();
                        } catch (Exception ex) {
                            Logger.getLogger(Ch4SubHard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        timer = new Timer(700, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                symbn2.setVisible(false);
                                timer.stop();
                            }
                        });
                        timer.start();
                        checkNum += 1;
                    }
                }
            }

        } else {
            if (qstShow.getAnswer2().equals(qstShow.getAnswer())) {
                try {
                    symbn2.setVisible(true);
                    symbn2.setIcon(symbnCorrect);
                    Clip correct = AudioSystem.getClip();
                    AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/correct-answer.wav"));
                    correct.open(audio);
                    correct.start();
                    Thread.sleep(900);
                    correct.close();
                } catch (Exception ex) {
                    Logger.getLogger(Ch4SubHard.class.getName()).log(Level.SEVERE, null, ex);
                }

                timer = new Timer(800, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        symbn2.setVisible(false);
                        qstShow = randomQuestionMedium();
                        checkNum = 1;

                        Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                        Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);
                        Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);
                        Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);

                        frame.setIcon(new ImageIcon(imageQuestion));
                        bn1.setIcon(new ImageIcon(answer1));
                        bn2.setIcon(new ImageIcon(answer2));
                        bn3.setIcon(new ImageIcon(answer3));
                        timer.stop();
                    }
                });
                timer.start();

                scoreEarn += 1;
                sc.setText(scoreEarn + "");
                check += 1;

            } else {
                if (checkNum == 2) {
                    try {
                        symbn2.setVisible(true);
                        symbn2.setIcon(symbnIncorrect);
                        Clip correct = AudioSystem.getClip();
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/wrong-sound.wav"));
                        correct.open(audio);
                        correct.start();
                        Thread.sleep(800);
                        correct.close();
                    } catch (Exception ex) {
                        Logger.getLogger(Ch4SubHard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JLabel label = new JLabel("คำตอบที่ถูกต้องคือ   " + qstShow.getAns() + "   ");
                    label.setFont(new Font("BoonJot", Font.PLAIN, 20));
                    JOptionPane.showMessageDialog(null, label, "เฉลย", JOptionPane.INFORMATION_MESSAGE, icon);

                    timer = new Timer(800, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            symbn1.setVisible(false);
                            qstShow = randomQuestionMedium();
                            

                            Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                            Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);
                            Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);
                            Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);

                            frame.setIcon(new ImageIcon(imageQuestion));
                            bn1.setIcon(new ImageIcon(answer1));
                            bn2.setIcon(new ImageIcon(answer2));
                            bn3.setIcon(new ImageIcon(answer3));
                            timer.stop();
                        }
                    });
                    timer.start();

                    scoreFalse += 1;
                    wrong.setText(scoreFalse + "");
                    checkNum = 1;
                } else {
                    try {
                        symbn2.setVisible(true);
                        symbn2.setIcon(symbnIncorrect);
                        Clip correct = AudioSystem.getClip();
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/wrong-sound.wav"));
                        correct.open(audio);
                        correct.start();
                        Thread.sleep(800);
                        correct.close();
                    } catch (Exception ex) {
                        Logger.getLogger(Ch4SubHard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    timer = new Timer(700, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            symbn2.setVisible(false);
                            timer.stop();
                        }
                    });
                    timer.start();
                    checkNum += 1;
                }
            }
        }
    }//GEN-LAST:event_bn2ActionPerformed

    private void bn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bn3ActionPerformed
        if ((scoreEarn + scoreFalse) >= 9) {
            if (qstShow.getAnswer3().equals(qstShow.getAnswer())) {
                try {
                    symbn3.setVisible(true);
                    symbn3.setIcon(symbnCorrect);
                    Clip correct = AudioSystem.getClip();
                    AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/correct-answer.wav"));
                    correct.open(audio);
                    correct.start();
                    Thread.sleep(900);
                    correct.close();
                } catch (Exception ex) {
                    Logger.getLogger(Ch4SubHard.class.getName()).log(Level.SEVERE, null, ex);
                }

                scoreEarn += 1;
                sc.setText(scoreEarn + "");


                JLabel label1 = new JLabel("ตอบถูก  " + scoreEarn + " ข้อ        " + "ตอบผิด  " + scoreFalse + " ข้อ");
                label1.setFont(new Font("BoonJot", Font.PLAIN, 20));
               

                int choice = JOptionPane.showOptionDialog(null, label1, "คะแนนรวม", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                if (choice == 0) {
                    Choose c = new Choose();
                    c.setVisible(true);
                    close();
                }

            } else {
                if (checkNum == 2) {
                    try {
                        symbn3.setVisible(true);
                        symbn3.setIcon(symbnIncorrect);
                        Clip correct = AudioSystem.getClip();
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/wrong-sound.wav"));
                        correct.open(audio);
                        correct.start();
                        Thread.sleep(800);
                        correct.close();
                    } catch (Exception ex) {
                        Logger.getLogger(Ch4SubHard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    scoreFalse += 1;
                wrong.setText(scoreFalse + "");
                
                    JLabel label = new JLabel("คำตอบที่ถูกต้องคือ   " + qstShow.getAns() + "   ");
                    label.setFont(new Font("BoonJot", Font.PLAIN, 20));
                    JOptionPane.showMessageDialog(null, label, "เฉลย", JOptionPane.INFORMATION_MESSAGE, icon);

                    


                JLabel label1 = new JLabel("ตอบถูก  " + scoreEarn + " ข้อ        " + "ตอบผิด  " + scoreFalse + " ข้อ");
                label1.setFont(new Font("BoonJot", Font.PLAIN, 20));
               

                int choice = JOptionPane.showOptionDialog(null, label1, "คะแนนรวม", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                if (choice == 0) {
                    Choose c = new Choose();
                    c.setVisible(true);
                    close();
                } 
                    
                    
                    else {
                        try {
                            symbn3.setVisible(true);
                            symbn3.setIcon(symbnIncorrect);
                            Clip correct = AudioSystem.getClip();
                            AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/wrong-sound.wav"));
                            correct.open(audio);
                            correct.start();
                            Thread.sleep(800);
                            correct.close();
                        } catch (Exception ex) {
                            Logger.getLogger(Ch4SubHard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        timer = new Timer(700, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                symbn3.setVisible(false);
                                timer.stop();
                            }
                        });
                        timer.start();
                        checkNum += 1;
                    }
                }
            }

        } else {
            if (qstShow.getAnswer3().equals(qstShow.getAnswer())) {
                try {
                    symbn3.setVisible(true);
                    symbn3.setIcon(symbnCorrect);
                    Clip correct = AudioSystem.getClip();
                    AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/correct-answer.wav"));
                    correct.open(audio);
                    correct.start();
                    Thread.sleep(900);
                    correct.close();
                } catch (Exception ex) {
                    Logger.getLogger(Ch4SubHard.class.getName()).log(Level.SEVERE, null, ex);
                }

                timer = new Timer(800, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        symbn3.setVisible(false);
                        qstShow = randomQuestionMedium();
                        checkNum = 1;

                        Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                        Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);
                        Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);
                        Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);

                        frame.setIcon(new ImageIcon(imageQuestion));
                        bn1.setIcon(new ImageIcon(answer1));
                        bn2.setIcon(new ImageIcon(answer2));
                        bn3.setIcon(new ImageIcon(answer3));
                        timer.stop();
                    }
                });
                timer.start();

                scoreEarn += 1;
                sc.setText(scoreEarn + "");
                check += 1;

            } else {
                if (checkNum == 2) {
                    try {
                        symbn3.setVisible(true);
                        symbn3.setIcon(symbnIncorrect);
                        Clip correct = AudioSystem.getClip();
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/wrong-sound.wav"));
                        correct.open(audio);
                        correct.start();
                        Thread.sleep(800);
                        correct.close();
                    } catch (Exception ex) {
                        Logger.getLogger(Ch4SubHard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JLabel label = new JLabel("คำตอบที่ถูกต้องคือ   " + qstShow.getAns() + "   ");
                    label.setFont(new Font("BoonJot", Font.PLAIN, 20));
                    JOptionPane.showMessageDialog(null, label, "เฉลย", JOptionPane.INFORMATION_MESSAGE, icon);

                    timer = new Timer(800, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            symbn3.setVisible(false);
                            qstShow = randomQuestionMedium();

                            Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                            Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);
                            Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);
                            Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);

                            frame.setIcon(new ImageIcon(imageQuestion));
                            bn1.setIcon(new ImageIcon(answer1));
                            bn2.setIcon(new ImageIcon(answer2));
                            bn3.setIcon(new ImageIcon(answer3));
                            timer.stop();
                        }
                    });
                    timer.start();

                    scoreFalse += 1;
                    wrong.setText(scoreFalse + "");
                    checkNum = 1;
                } else {
                    try {
                        symbn3.setVisible(true);
                        symbn3.setIcon(symbnIncorrect);
                        Clip correct = AudioSystem.getClip();
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/wrong-sound.wav"));
                        correct.open(audio);
                        correct.start();
                        Thread.sleep(800);
                        correct.close();
                    } catch (Exception ex) {
                        Logger.getLogger(Ch4SubHard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    timer = new Timer(700, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            symbn3.setVisible(false);
                            timer.stop();
                        }
                    });
                    timer.start();
                    checkNum += 1;
                }
            }
        }
    }//GEN-LAST:event_bn3ActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(CountingMedium.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CountingMedium.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CountingMedium.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CountingMedium.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CountingMedium().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton bn1;
    private javax.swing.JButton bn2;
    private javax.swing.JButton bn3;
    private javax.swing.JLabel frame;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel sc;
    private javax.swing.JLabel symbn1;
    private javax.swing.JLabel symbn2;
    private javax.swing.JLabel symbn3;
    private javax.swing.JLabel wrong;
    // End of variables declaration//GEN-END:variables
}
