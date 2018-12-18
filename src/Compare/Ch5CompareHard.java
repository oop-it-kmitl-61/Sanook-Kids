/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compare;

import static Compare.Ch5Compare.HEIGHT;
import static Compare.Ch5Compare.WIDTH;
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
public class Ch5CompareHard extends javax.swing.JFrame {

    /**
     * Creates new form Ch5CompareHard
     */
    public static final int WIDTH = 800;
    public static final int HEIGHT = 480;

    private int scoreEarn = 0;
    private int scoreFalse = 0;
    private int check = 1;
    private int checkNum = 1;
    private static final int scoreEnd = 10;
    private String[] options = {"OK"};

    private List<Compare.QuestionHard> questionH;
    private Compare.QuestionHard qstShow;

    public Ch5CompareHard() {
        initComponents();
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);

        createQuestion();
        qstShow = randomQuestion();

        Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(bn1.getWidth(), bn1.getHeight(), Image.SCALE_SMOOTH);
        Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(bn2.getWidth(), bn2.getHeight(), Image.SCALE_SMOOTH);
        Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(bn3.getWidth(), bn3.getHeight(), Image.SCALE_SMOOTH);

        frame.setIcon(new ImageIcon(imageQuestion));
        bn1.setIcon(new ImageIcon(answer1));
        bn2.setIcon(new ImageIcon(answer2));
        bn3.setIcon(new ImageIcon(answer3));
        sc.setText(scoreEarn + "");
        wrong.setText(scoreFalse + "");
    }

    public void close() {
        this.setVisible(false);
        this.dispose();
    }

    public String[] getImages() {
        File file = new File(getClass().getResource("/res").getFile());
        String[] imagesList = file.list();
        return imagesList;
    }

    private void createQuestion() {
        questionH = new ArrayList<Compare.QuestionHard>();

        ImageIcon imageQuestion;
        ImageIcon iconAnswer1;
        ImageIcon iconAnswer2;
        ImageIcon iconAnswer3;

        // Question 1
        imageQuestion = new ImageIcon(getClass().getResource("/res/compare/hard1/1.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/compare/hard/button/1-incorrect-1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/compare/hard/button/1-incorrect-2.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/compare/hard/button/1-correct.png"));
        Compare.QuestionHard qst1 = new Compare.QuestionHard(imageQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer3, "<");
        questionH.add(qst1);
        // Question 2
        imageQuestion = new ImageIcon(getClass().getResource("/res/compare/hard1/2.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/compare/hard/button/2-correct.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/compare/hard/button/2-incorrect-2.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/compare/hard/button/2-incorrect-1.png"));
        Compare.QuestionHard qst2 = new Compare.QuestionHard(imageQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1, ">");
        questionH.add(qst2);
        // Question 3
        imageQuestion = new ImageIcon(getClass().getResource("/res/compare/hard1/3.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/compare/hard/button/3-incorrect-1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/compare/hard/button/3-correct.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/compare/hard/button/3-incorrect-2.png"));
        Compare.QuestionHard qst3 = new Compare.QuestionHard(imageQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer2, "=");
        questionH.add(qst3);
        // Question 4
        imageQuestion = new ImageIcon(getClass().getResource("/res/compare/hard1/4.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/compare/hard/button/4-correct.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/compare/hard/button/4-incorrect-2.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/compare/hard/button/4-incorrect-1.png"));
        Compare.QuestionHard qst4 = new Compare.QuestionHard(imageQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1, ">");
        questionH.add(qst4);
        // Question 5
        imageQuestion = new ImageIcon(getClass().getResource("/res/compare/hard1/5.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/compare/hard/button/5-incorrect-1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/compare/hard/button/5-incorrect-2.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/compare/hard/button/5-correct.png"));
        Compare.QuestionHard qst5 = new Compare.QuestionHard(imageQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer3, "<");
        questionH.add(qst5);
        // Question 6
        imageQuestion = new ImageIcon(getClass().getResource("/res/compare/hard1/6.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/compare/hard/button/6-incorrect-1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/compare/hard/button/6-correct.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/compare/hard/button/6-incorrect-2.png"));
        Compare.QuestionHard qst6 = new Compare.QuestionHard(imageQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer2, "=");
        questionH.add(qst6);
        // Question 7
        imageQuestion = new ImageIcon(getClass().getResource("/res/compare/hard1/7.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/compare/hard/button/7-correct.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/compare/hard/button/7-incorrect-2.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/compare/hard/button/7-incorrect-1.png"));
        Compare.QuestionHard qst7 = new Compare.QuestionHard(imageQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1, ">");
        questionH.add(qst7);
        // Question 8
        imageQuestion = new ImageIcon(getClass().getResource("/res/compare/hard1/8.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/compare/hard/button/8-incorrect-1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/compare/hard/button/8-incorrect-2.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/compare/hard/button/8-correct.png"));
        Compare.QuestionHard qst8 = new Compare.QuestionHard(imageQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer3, "<");
        questionH.add(qst8);
        // Question 9
        imageQuestion = new ImageIcon(getClass().getResource("/res/compare/hard1/9.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/compare/hard/button/9-incorrect-1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/compare/hard/button/9-correct.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/compare/hard/button/9-incorrect-2.png"));
        Compare.QuestionHard qst9 = new Compare.QuestionHard(imageQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer2, "=");
        questionH.add(qst9);
        // Question 10
        imageQuestion = new ImageIcon(getClass().getResource("/res/compare/hard1/10.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/compare/hard/button/10-correct.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/compare/hard/button/10-incorrect-2.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/compare/hard/button/10-incorrect-1.png"));
        Compare.QuestionHard qst10 = new Compare.QuestionHard(imageQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1, ">");
        questionH.add(qst10);
        // Question 11
        imageQuestion = new ImageIcon(getClass().getResource("/res/compare/hard1/11.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/compare/hard/button/11-incorrect-1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/compare/hard/button/11-incorrect-2.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/compare/hard/button/11-correct.png"));
        Compare.QuestionHard qst11 = new Compare.QuestionHard(imageQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer3, "<");
        questionH.add(qst11);
        // Question 12
        imageQuestion = new ImageIcon(getClass().getResource("/res/compare/hard1/12.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/compare/hard/button/12-incorrect-1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/compare/hard/button/12-correct.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/compare/hard/button/12-incorrect-2.png"));
        Compare.QuestionHard qst12 = new Compare.QuestionHard(imageQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer2, "=");
        questionH.add(qst12);

    }

    int rand;
    Timer timer;

    private Compare.QuestionHard randomQuestion() {
        Compare.QuestionHard qsts;
        rand = (int) (Math.random() * (12 - 1));
        qsts = questionH.get(rand);

        System.out.println(rand);

        symbn1.setVisible(false);
        symbn2.setVisible(false);
        symbn3.setVisible(false);

        return qsts;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frame = new javax.swing.JLabel();
        home = new javax.swing.JButton();
        symbn2 = new javax.swing.JLabel();
        symbn3 = new javax.swing.JLabel();
        symbn1 = new javax.swing.JLabel();
        bn2 = new javax.swing.JButton();
        bn3 = new javax.swing.JButton();
        bn1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        sc = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        wrong = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(frame);
        frame.setBounds(40, 100, 360, 290);

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
        getContentPane().add(symbn2);
        symbn2.setBounds(640, 180, 150, 150);
        getContentPane().add(symbn3);
        symbn3.setBounds(650, 300, 140, 170);
        getContentPane().add(symbn1);
        symbn1.setBounds(640, 70, 160, 150);

        bn2.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 0, 72)); // NOI18N
        bn2.setForeground(new java.awt.Color(255, 255, 255));
        bn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/compare/hard/button/1-correct.png"))); // NOI18N
        bn2.setOpaque(false);
        bn2.setContentAreaFilled(false);
        bn2.setBorderPainted(false);
        bn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn2ActionPerformed(evt);
            }
        });
        getContentPane().add(bn2);
        bn2.setBounds(490, 220, 220, 80);

        bn3.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 0, 72)); // NOI18N
        bn3.setForeground(new java.awt.Color(255, 255, 255));
        bn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/compare/hard/button/1-incorrect-2.png"))); // NOI18N
        bn3.setOpaque(false);
        bn3.setContentAreaFilled(false);
        bn3.setBorderPainted(false);
        bn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn3ActionPerformed(evt);
            }
        });
        getContentPane().add(bn3);
        bn3.setBounds(490, 330, 220, 80);

        bn1.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 0, 72)); // NOI18N
        bn1.setForeground(new java.awt.Color(255, 255, 255));
        bn1.setOpaque(false);
        bn1.setContentAreaFilled(false);
        bn1.setBorderPainted(false);
        bn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/compare/hard/button/1-incorrect-1.png"))); // NOI18N
        bn1.setOpaque(false);
        bn1.setContentAreaFilled(false);
        bn1.setBorderPainted(false);
        bn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn1ActionPerformed(evt);
            }
        });
        getContentPane().add(bn1);
        bn1.setBounds(490, 100, 220, 80);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/scoreEarn.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(500, 10, 50, 40);

        sc.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 0, 36)); // NOI18N
        getContentPane().add(sc);
        sc.setBounds(550, 10, 60, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/scoreFalse.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(670, 10, 40, 40);

        wrong.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 0, 36)); // NOI18N
        getContentPane().add(wrong);
        wrong.setBounds(710, 10, 60, 50);
        getContentPane().add(lb1);
        lb1.setBounds(20, 384, 200, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/bgsub.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1030, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ImageIcon symbnCorrect = new ImageIcon(getClass().getResource("/res/correct.png"));
    ImageIcon symbnIncorrect = new ImageIcon(getClass().getResource("/res/incorrect.png"));
    ImageIcon icon = new ImageIcon(getClass().getResource("/res/light.png"));


    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        Choose c = new Choose();
        c.setVisible(true);
        close();
    }//GEN-LAST:event_homeActionPerformed


    private void bn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bn1ActionPerformed
        if ((scoreEarn + scoreFalse) >= 9) {
            if (qstShow.getAnswer1().equals(qstShow.getAns())) {
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

                    JLabel label = new JLabel("คำตอบที่ถูกต้องคือ   " + qstShow.getAns() + "  ");
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
                        qstShow = randomQuestion();
                        checkNum = 1;

                        Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                        Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(bn1.getWidth(), bn1.getHeight(), Image.SCALE_SMOOTH);
                        Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(bn2.getWidth(), bn2.getHeight(), Image.SCALE_SMOOTH);
                        Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(bn3.getWidth(), bn3.getHeight(), Image.SCALE_SMOOTH);

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
                    JLabel label = new JLabel("คำตอบที่ถูกต้องคือ   " + qstShow.getAns() + "  ");
                    label.setFont(new Font("BoonJot", Font.PLAIN, 20));
                    JOptionPane.showMessageDialog(null, label, "เฉลย", JOptionPane.INFORMATION_MESSAGE, icon);

                    timer = new Timer(800, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            symbn1.setVisible(false);
                            qstShow = randomQuestion();

                            Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                            Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(bn1.getWidth(), bn1.getHeight(), Image.SCALE_SMOOTH);
                            Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(bn2.getWidth(), bn2.getHeight(), Image.SCALE_SMOOTH);
                            Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(bn3.getWidth(), bn3.getHeight(), Image.SCALE_SMOOTH);

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

                    JLabel label = new JLabel("คำตอบที่ถูกต้องก็คือ   " + qstShow.getAns() + "   ");
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
                }
                    else {
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
                        qstShow = randomQuestion();
                        checkNum = 1;

                        Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                        Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(bn1.getWidth(), bn1.getHeight(), Image.SCALE_SMOOTH);
                        Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(bn2.getWidth(), bn2.getHeight(), Image.SCALE_SMOOTH);
                        Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(bn3.getWidth(), bn3.getHeight(), Image.SCALE_SMOOTH);

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
                    JLabel label = new JLabel("คำตอบที่ถูกต้องก็คือ   " + qstShow.getAns() + "   ");
                    label.setFont(new Font("BoonJot", Font.PLAIN, 20));
                    JOptionPane.showMessageDialog(null, label, "เฉลย", JOptionPane.INFORMATION_MESSAGE, icon);

                    timer = new Timer(800, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            symbn1.setVisible(false);
                            qstShow = randomQuestion();

                            Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                            Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(bn1.getWidth(), bn1.getHeight(), Image.SCALE_SMOOTH);
                            Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(bn2.getWidth(), bn2.getHeight(), Image.SCALE_SMOOTH);
                            Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(bn3.getWidth(), bn3.getHeight(), Image.SCALE_SMOOTH);

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
                
                
                    JLabel label = new JLabel("คำตอบที่ถูกต้องก็คือ   " + qstShow.getAns() + "   ");
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
                        qstShow = randomQuestion();
                        checkNum = 1;

                        Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                        Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(bn1.getWidth(), bn1.getHeight(), Image.SCALE_SMOOTH);
                        Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(bn2.getWidth(), bn2.getHeight(), Image.SCALE_SMOOTH);
                        Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(bn3.getWidth(), bn3.getHeight(), Image.SCALE_SMOOTH);

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
                    JLabel label = new JLabel("คำตอบที่ถูกต้องก็คือ   " + qstShow.getAns() + "   ");
                    label.setFont(new Font("BoonJot", Font.PLAIN, 20));
                    JOptionPane.showMessageDialog(null, label, "เฉลย", JOptionPane.INFORMATION_MESSAGE, icon);

                    timer = new Timer(800, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            symbn3.setVisible(false);
                            qstShow = randomQuestion();

                            Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                            Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(bn1.getWidth(), bn1.getHeight(), Image.SCALE_SMOOTH);
                            Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(bn2.getWidth(), bn2.getHeight(), Image.SCALE_SMOOTH);
                            Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(bn3.getWidth(), bn3.getHeight(), Image.SCALE_SMOOTH);

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
            java.util.logging.Logger.getLogger(Ch5CompareHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ch5CompareHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ch5CompareHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ch5CompareHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ch5CompareHard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bn1;
    private javax.swing.JButton bn2;
    private javax.swing.JButton bn3;
    private javax.swing.JLabel frame;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel sc;
    private javax.swing.JLabel symbn1;
    private javax.swing.JLabel symbn2;
    private javax.swing.JLabel symbn3;
    private javax.swing.JLabel wrong;
    // End of variables declaration//GEN-END:variables
}
