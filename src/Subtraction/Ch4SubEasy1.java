/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subtraction;

import Sounds.CorrectSound;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ButtonType;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static oop.Opening.HEIGHT;
import static oop.Opening.WIDTH;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import oop.Choose;

/**
 *
 * @author Husna
 */
public class Ch4SubEasy1 extends javax.swing.JFrame {

    /**
     * Creates new form Ch4SubEasy1
     */
    public static final String TITLE = "สนุก Kids";
    public static final int WIDTH = 800;
    public static final int HEIGHT = 480;

    private int scoreEarn = 0;
    private int scoreFalse = 0;
    private int check = 1;

    private int checkNum = 1;

    private List<Question> question;
    private Question qstShow;

    private String[] options = {"OK"};

    public Ch4SubEasy1() {
        initComponents();

        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);

        createQuestion();
        qstShow = randomQuestion();

        Image imageLeft = qstShow.getImageLeft().getImage().getScaledInstance(frame_left.getWidth(), frame_left.getHeight(), Image.SCALE_SMOOTH);
        Image imageRight = qstShow.getImageRight().getImage().getScaledInstance(frame_right.getWidth(), frame_right.getHeight(), Image.SCALE_SMOOTH);
        frame_left.setIcon(new ImageIcon(imageLeft));
        frame_right.setIcon(new ImageIcon(imageRight));
        bn1.setText(qstShow.getAnswer1());
        bn2.setText(qstShow.getAnswer2());
        bn3.setText(qstShow.getAnswer3());
        sc.setText(scoreEarn + "");
        wrong.setText(scoreFalse + "");
        play();
    }

    public String[] getImages() {
        File file = new File(getClass().getResource("/res").getFile());
        String[] imagesList = file.list();
        return imagesList;
    }

    public void play() {
        try {
            File file = new File("mario-s-way.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void createQuestion() {
        question = new ArrayList<Question>();

        ImageIcon iconLeft;
        ImageIcon iconRight;

        // Question 1
        iconLeft = new ImageIcon(getClass().getResource("/res/sub/2.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/sub/1.png"));
        Question qst = new Question(iconLeft, iconRight, "2", "1", "3", "1");
        question.add(qst);
        // Question 2
        iconLeft = new ImageIcon(getClass().getResource("/res/sub/3.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/sub/2.png"));
        Question qst1 = new Question(iconLeft, iconRight, "3", "2", "1", "1");
        question.add(qst1);

        // Question 3
        iconLeft = new ImageIcon(getClass().getResource("/res/sub/5.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/sub/3.png"));
        Question qst2 = new Question(iconLeft, iconRight, "2", "3", "1", "2");
        question.add(qst2);
        // Question 4
        iconLeft = new ImageIcon(getClass().getResource("/res/sub/4.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/sub/2.png"));
        Question qst3 = new Question(iconLeft, iconRight, "3", "1", "2", "2");
        question.add(qst3);

        // Question 5
        iconLeft = new ImageIcon(getClass().getResource("/res/sub/5.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/sub/2.png"));
        Question qst4 = new Question(iconLeft, iconRight, "3", "2", "1", "3");
        question.add(qst4);
        // Question 6
        iconLeft = new ImageIcon(getClass().getResource("/res/sub/4.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/sub/1.png"));
        Question qst5 = new Question(iconLeft, iconRight, "2", "3", "4", "3");
        question.add(qst5);

        // Question 7
        iconLeft = new ImageIcon(getClass().getResource("/res/sub/5.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/sub/1.png"));
        Question qst6 = new Question(iconLeft, iconRight, "4", "5", "3", "4");
        question.add(qst6);

        // Question 8
        iconLeft = new ImageIcon(getClass().getResource("/res/sub/5.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/sub/4.png"));
        Question qst7 = new Question(iconLeft, iconRight, "3", "2", "1", "1");
        question.add(qst7);

        // Question 9
        iconLeft = new ImageIcon(getClass().getResource("/res/sub/4.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/sub/3.png"));
        Question qst8 = new Question(iconLeft, iconRight, "1", "2", "3", "1");
        question.add(qst8);

        // Question 10
        iconLeft = new ImageIcon(getClass().getResource("/res/sub/5.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/sub/5.png"));
        Question qst9 = new Question(iconLeft, iconRight, "5", "0", "1", "0");
        question.add(qst9);

        // Question 11
        iconLeft = new ImageIcon(getClass().getResource("/res/sub/4.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/sub/4.png"));
        Question qst10 = new Question(iconLeft, iconRight, "8", "4", "0", "0");
        question.add(qst10);

        // Question 12
        iconLeft = new ImageIcon(getClass().getResource("/res/sub/3.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/sub/3.png"));
        Question qst11 = new Question(iconLeft, iconRight, "0", "6", "3", "0");
        question.add(qst11);

        // Question 13
        iconLeft = new ImageIcon(getClass().getResource("/res/sub/2.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/sub/2.png"));
        Question qst12 = new Question(iconLeft, iconRight, "2", "4", "0", "0");
        question.add(qst12);

        // Question 14
        iconLeft = new ImageIcon(getClass().getResource("/res/sub/1.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/sub/1.png"));
        Question qst13 = new Question(iconLeft, iconRight, "1", "0", "2", "0");
        question.add(qst13);

        // Question 15
        iconLeft = new ImageIcon(getClass().getResource("/res/sub/3.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/sub/1.png"));
        Question qst14 = new Question(iconLeft, iconRight, "1", "4", "2", "2");
        question.add(qst14);

    }
    int rand;
    Timer timer;

    private Question randomQuestion() {
        Question qsts;
        rand = (int) (Math.random() * (15 - 1));
        qsts = question.get(rand);

        System.out.println(rand);

        symbn1.setVisible(false);
        symbn2.setVisible(false);
        symbn3.setVisible(false);

        return qsts;
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

        jPanel1 = new javax.swing.JPanel();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        symbn3 = new javax.swing.JLabel();
        symbn2 = new javax.swing.JLabel();
        symbn1 = new javax.swing.JLabel();
        frame_left = new javax.swing.JLabel();
        sc = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        frame_right = new javax.swing.JLabel();
        home = new javax.swing.JButton();
        wrong = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bn1 = new javax.swing.JButton();
        bn2 = new javax.swing.JButton();
        bn3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(symbn3);
        symbn3.setBounds(620, 290, 180, 160);
        getContentPane().add(symbn2);
        symbn2.setBounds(380, 300, 200, 160);
        getContentPane().add(symbn1);
        symbn1.setBounds(160, 290, 180, 170);
        getContentPane().add(frame_left);
        frame_left.setBounds(60, 80, 260, 210);

        sc.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 0, 36)); // NOI18N
        getContentPane().add(sc);
        sc.setBounds(550, 10, 60, 50);

        jLabel2.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 1, 200)); // NOI18N
        jLabel2.setText("-");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(360, 160, 100, 70);
        getContentPane().add(frame_right);
        frame_right.setBounds(460, 90, 260, 210);

        home.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 0, 18)); // NOI18N
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/home_4.png"))); // NOI18N
        home.setOpaque(false);
        home.setContentAreaFilled(false);
        home.setBorderPainted(false);
        home.setToolTipText("");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        getContentPane().add(home);
        home.setBounds(0, 0, 70, 70);

        wrong.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 0, 36)); // NOI18N
        getContentPane().add(wrong);
        wrong.setBounds(710, 10, 60, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/scoreFalse.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(670, 10, 40, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/scoreEarn.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(500, 10, 50, 40);

        bn1.setBackground(new java.awt.Color(120, 80, 160));
        bn1.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 1, 80)); // NOI18N
        bn1.setForeground(new java.awt.Color(255, 255, 255));
        bn1.setAlignmentY(5.0F);
        bn1.setAutoscrolls(true);
        bn1.setMargin(new java.awt.Insets(17, 20, 4, 14));
        bn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn1ActionPerformed(evt);
            }
        });
        getContentPane().add(bn1);
        bn1.setBounds(80, 320, 130, 90);

        bn2.setBackground(new java.awt.Color(120, 80, 160));
        bn2.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 1, 80)); // NOI18N
        bn2.setForeground(new java.awt.Color(255, 255, 255));
        bn2.setMargin(new java.awt.Insets(17, 20, 4, 14));
        bn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn2ActionPerformed(evt);
            }
        });
        getContentPane().add(bn2);
        bn2.setBounds(330, 320, 130, 90);

        bn3.setBackground(new java.awt.Color(120, 80, 160));
        bn3.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 1, 80)); // NOI18N
        bn3.setForeground(new java.awt.Color(255, 255, 255));
        bn3.setMargin(new java.awt.Insets(17, 20, 4, 14));
        bn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn3ActionPerformed(evt);
            }
        });
        getContentPane().add(bn3);
        bn3.setBounds(580, 320, 130, 90);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/bgsub.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 820, 480);

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

//                TotalScore t = new TotalScore();
//                t.setVisible(true);
//                close();
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

                    JLabel label = new JLabel("คำตอบที่ถูกต้องก็คือ     " + qstShow.getAnswer() + "     ");
                    label.setFont(new Font("BoonJot", Font.PLAIN, 20));
                    JOptionPane.showMessageDialog(null, label, "เฉลย", JOptionPane.INFORMATION_MESSAGE, icon);

                    JLabel label1 = new JLabel("ตอบถูก  " + scoreEarn + " ข้อ       " + "ตอบผิด  " + scoreFalse + " ข้อ");
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

                        Image imageLeft = qstShow.getImageLeft().getImage().getScaledInstance(frame_left.getWidth(), frame_left.getHeight(), Image.SCALE_SMOOTH);
                        Image imageRight = qstShow.getImageRight().getImage().getScaledInstance(frame_right.getWidth(), frame_right.getHeight(), Image.SCALE_SMOOTH);
                        frame_left.setIcon(new ImageIcon(imageLeft));
                        frame_right.setIcon(new ImageIcon(imageRight));
                        bn1.setText(qstShow.getAnswer1());
                        bn2.setText(qstShow.getAnswer2());
                        bn3.setText(qstShow.getAnswer3());
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
                    JLabel label = new JLabel("คำตอบที่ถูกต้องก็คือ     " + qstShow.getAnswer() + "     ");
                    label.setFont(new Font("BoonJot", Font.PLAIN, 20));
                    JOptionPane.showMessageDialog(null, label, "เฉลย", JOptionPane.INFORMATION_MESSAGE, icon);

                    timer = new Timer(800, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            symbn1.setVisible(false);
                            qstShow = randomQuestion();

                            Image imageLeft = qstShow.getImageLeft().getImage().getScaledInstance(frame_left.getWidth(), frame_left.getHeight(), Image.SCALE_SMOOTH);
                            Image imageRight = qstShow.getImageRight().getImage().getScaledInstance(frame_right.getWidth(), frame_right.getHeight(), Image.SCALE_SMOOTH);
                            frame_left.setIcon(new ImageIcon(imageLeft));
                            frame_right.setIcon(new ImageIcon(imageRight));
                            bn1.setText(qstShow.getAnswer1());
                            bn2.setText(qstShow.getAnswer2());
                            bn3.setText(qstShow.getAnswer3());
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

                    JLabel label = new JLabel("คำตอบที่ถูกต้องก็คือ     " + qstShow.getAnswer() + "     ");
                    label.setFont(new Font("BoonJot", Font.PLAIN, 20));
                    JOptionPane.showMessageDialog(null, label, "เฉลย", JOptionPane.INFORMATION_MESSAGE, icon);

                    JLabel label1 = new JLabel("ตอบถูก  " + scoreEarn + " ข้อ     " + "ตอบผิด  " + scoreFalse + " ข้อ");
                    label1.setFont(new Font("BoonJot", Font.PLAIN, 20));

                    int choice = JOptionPane.showOptionDialog(null, label1, "คะแนนรวม", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    if (choice == 0) {
                        Choose c = new Choose();
                        c.setVisible(true);
                        close();
                    }

//                    scoreFalse += 1;
//                    wrong.setText(scoreFalse + "");
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

                        Image imageLeft = qstShow.getImageLeft().getImage().getScaledInstance(frame_left.getWidth(), frame_left.getHeight(), Image.SCALE_SMOOTH);
                        Image imageRight = qstShow.getImageRight().getImage().getScaledInstance(frame_right.getWidth(), frame_right.getHeight(), Image.SCALE_SMOOTH);
                        frame_left.setIcon(new ImageIcon(imageLeft));
                        frame_right.setIcon(new ImageIcon(imageRight));
                        bn1.setText(qstShow.getAnswer1());
                        bn2.setText(qstShow.getAnswer2());
                        bn3.setText(qstShow.getAnswer3());
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
                    JLabel label = new JLabel("คำตอบที่ถูกต้องก็คือ     " + qstShow.getAnswer() + "     ");
                    label.setFont(new Font("BoonJot", Font.PLAIN, 20));
                    JOptionPane.showMessageDialog(null, label, "เฉลย", JOptionPane.INFORMATION_MESSAGE, icon);

                    timer = new Timer(800, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            symbn2.setVisible(false);
                            qstShow = randomQuestion();

                            Image imageLeft = qstShow.getImageLeft().getImage().getScaledInstance(frame_left.getWidth(), frame_left.getHeight(), Image.SCALE_SMOOTH);
                            Image imageRight = qstShow.getImageRight().getImage().getScaledInstance(frame_right.getWidth(), frame_right.getHeight(), Image.SCALE_SMOOTH);
                            frame_left.setIcon(new ImageIcon(imageLeft));
                            frame_right.setIcon(new ImageIcon(imageRight));
                            bn1.setText(qstShow.getAnswer1());
                            bn2.setText(qstShow.getAnswer2());
                            bn3.setText(qstShow.getAnswer3());
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

                    JLabel label = new JLabel("คำตอบที่ถูกต้องก็คือ     " + qstShow.getAnswer() + "     ");
                    label.setFont(new Font("BoonJot", Font.PLAIN, 20));
                    JOptionPane.showMessageDialog(null, label, "เฉลย", JOptionPane.INFORMATION_MESSAGE, icon);

                    JLabel label1 = new JLabel("ตอบถูก  " + scoreEarn + " ข้อ       " + "ตอบผิด  " + scoreFalse + " ข้อ");
                    label1.setFont(new Font("BoonJot", Font.PLAIN, 20));

                    int choice = JOptionPane.showOptionDialog(null, label1, "คะแนนรวม", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    if (choice == 0) {
                        Choose c = new Choose();
                        c.setVisible(true);
                        close();
                    }
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

                        Image imageLeft = qstShow.getImageLeft().getImage().getScaledInstance(frame_left.getWidth(), frame_left.getHeight(), Image.SCALE_SMOOTH);
                        Image imageRight = qstShow.getImageRight().getImage().getScaledInstance(frame_right.getWidth(), frame_right.getHeight(), Image.SCALE_SMOOTH);
                        frame_left.setIcon(new ImageIcon(imageLeft));
                        frame_right.setIcon(new ImageIcon(imageRight));
                        bn1.setText(qstShow.getAnswer1());
                        bn2.setText(qstShow.getAnswer2());
                        bn3.setText(qstShow.getAnswer3());
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
                    JLabel label = new JLabel("คำตอบที่ถูกต้องก็คือ     " + qstShow.getAnswer() + "     ");
                    label.setFont(new Font("BoonJot", Font.PLAIN, 20));
                    JOptionPane.showMessageDialog(null, label, "เฉลย", JOptionPane.INFORMATION_MESSAGE, icon);

                    timer = new Timer(800, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            symbn3.setVisible(false);
                            qstShow = randomQuestion();

                            Image imageLeft = qstShow.getImageLeft().getImage().getScaledInstance(frame_left.getWidth(), frame_left.getHeight(), Image.SCALE_SMOOTH);
                            Image imageRight = qstShow.getImageRight().getImage().getScaledInstance(frame_right.getWidth(), frame_right.getHeight(), Image.SCALE_SMOOTH);
                            frame_left.setIcon(new ImageIcon(imageLeft));
                            frame_right.setIcon(new ImageIcon(imageRight));
                            bn1.setText(qstShow.getAnswer1());
                            bn2.setText(qstShow.getAnswer2());
                            bn3.setText(qstShow.getAnswer3());
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
            java.util.logging.Logger.getLogger(Ch4SubEasy1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ch4SubEasy1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ch4SubEasy1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ch4SubEasy1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ch4SubEasy1().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bn1;
    private javax.swing.JButton bn2;
    private javax.swing.JButton bn3;
    private javax.swing.JLabel frame_left;
    private javax.swing.JLabel frame_right;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JLabel sc;
    private javax.swing.JLabel symbn1;
    private javax.swing.JLabel symbn2;
    private javax.swing.JLabel symbn3;
    private javax.swing.JLabel wrong;
    // End of variables declaration//GEN-END:variables
}
