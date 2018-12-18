/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subtraction;

import Sounds.CorrectSound;

import static Subtraction.Ch4SubEasy1.HEIGHT;
import static Subtraction.Ch4SubEasy1.TITLE;
import static Subtraction.Ch4SubEasy1.WIDTH;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import oop.Choose;
import sun.applet.Main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JLabel;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 *
 * @author Husna
 */
public class Ch4SubHard extends javax.swing.JFrame {

    /**
     * Creates new form Ch4SubHard
     */
    public static final String TITLE = "สนุก Kids";
    public static final int WIDTH = 800;
    public static final int HEIGHT = 480;

    private int scoreEarn = 0;
    private int scoreFalse = 0;
    private int checkNum = 1;
    private int check = 1;
    private static final int scoreEnd = 10;

    private List<Subtraction.QuestionHard> questionHard;
    private Subtraction.QuestionHard qstShow;
    private String[] options = {"OK"};


    public Ch4SubHard() {
        initComponents();
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);

        createQuestion();
        qstShow = randomQuestionHard();

        Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(130, 120, Image.SCALE_SMOOTH);
        Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(130, 120, Image.SCALE_SMOOTH);
        Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(130, 120, Image.SCALE_SMOOTH);

        frame.setIcon(new ImageIcon(imageQuestion));
        bn1.setIcon(new ImageIcon(answer1));
        bn2.setIcon(new ImageIcon(answer2));
        bn3.setIcon(new ImageIcon(answer3));
        sc.setText(scoreEarn + "");
        wrong.setText(scoreFalse + "");

    }
    public String[] getImages() {
        File file = new File(getClass().getResource("/res").getFile());
        String[] imagesList = file.list();
        return imagesList;
    }

    private void createQuestion() {
        questionHard = new ArrayList<Subtraction.QuestionHard>();

        ImageIcon iconQuestion;

        ImageIcon iconAnswer1;
        ImageIcon iconAnswer2;
        ImageIcon iconAnswer3;
        ImageIcon iconAnswer;

        // Question 1
        iconQuestion = new ImageIcon(getClass().getResource("/res/sub/hardNew/10.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/10-correct.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/10-incorrect-1.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/10-incorrect-2.png"));
        Subtraction.QuestionHard qsth1 = new Subtraction.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1, "14-4");
        questionHard.add(qsth1);
        // Question 2
        iconQuestion = new ImageIcon(getClass().getResource("/res/sub/hardNew/11.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/11-incorrect-1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/11-correct.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/11-incorrect-2.png"));
        Subtraction.QuestionHard qsth2 = new Subtraction.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer2, "20-9");
        questionHard.add(qsth2);
        // Question 3
        iconQuestion = new ImageIcon(getClass().getResource("/res/sub/hardNew/12.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/12-incorrect-1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/12-incorrect-2.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/12-correct.png"));
        Subtraction.QuestionHard qsth3 = new Subtraction.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer3, "21-9");
        questionHard.add(qsth3);
        // Question 4
        iconQuestion = new ImageIcon(getClass().getResource("/res/sub/hardNew/13.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/13-correct.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/13-incorrect-1.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/13-incorrect-2.png"));
        Subtraction.QuestionHard qsth4 = new Subtraction.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1, "19-6");
        questionHard.add(qsth4);
        // Question 5
        iconQuestion = new ImageIcon(getClass().getResource("/res/sub/hardNew/14.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/14-incorrect-1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/14-correct.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/14-incorrect-2.png"));
        Subtraction.QuestionHard qsth5 = new Subtraction.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer2, "19-5");
        questionHard.add(qsth5);
        // Question 6
        iconQuestion = new ImageIcon(getClass().getResource("/res/sub/hardNew/15.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/15-incorrect-1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/15-incorrect-2.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/15-correct.png"));
        Subtraction.QuestionHard qsth6 = new Subtraction.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer3, "21-6");
        questionHard.add(qsth6);
        // Question 7
        iconQuestion = new ImageIcon(getClass().getResource("/res/sub/hardNew/16.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/16-correct.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/16-incorrect-1.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/16-incorrect-2.png"));
        Subtraction.QuestionHard qsth7 = new Subtraction.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1, "19-3");
        questionHard.add(qsth7);
        // Question 8
        iconQuestion = new ImageIcon(getClass().getResource("/res/sub/hardNew/17.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/17-incorrect-1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/17-correct.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/17-incorrect-2.png"));
        Subtraction.QuestionHard qsth8 = new Subtraction.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer2, "22-5");
        questionHard.add(qsth8);
        // Question 9
        iconQuestion = new ImageIcon(getClass().getResource("/res/sub/hardNew/18.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/18-incorrect-1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/18-incorrect-2.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/18-correct.png"));
        Subtraction.QuestionHard qsth9 = new Subtraction.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer3, "23-5");
        questionHard.add(qsth9);
        // Question 10
        iconQuestion = new ImageIcon(getClass().getResource("/res/sub/hardNew/19.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/19-correct.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/19-incorrect-1.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/19-incorrect-2.png"));
        Subtraction.QuestionHard qsth10 = new Subtraction.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1, "25-6");
        questionHard.add(qsth10);
        // Question 11
        iconQuestion = new ImageIcon(getClass().getResource("/res/sub/hardNew/20.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/20-incorrect-1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/20-correct.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/20-incorrect-2.png"));
        Subtraction.QuestionHard qsth11 = new Subtraction.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer2, "29-9");
        questionHard.add(qsth11);
        // Question 12
        iconQuestion = new ImageIcon(getClass().getResource("/res/sub/hardNew/7.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/7-incorrect-1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/7-incorrect-2.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/7-correct.png"));
        Subtraction.QuestionHard qsth12 = new Subtraction.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer3, "21-14");
        questionHard.add(qsth12);
        // Question 13
        iconQuestion = new ImageIcon(getClass().getResource("/res/sub/hardNew/8.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/8-correct.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/8-incorrect-1.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/8-incorrect-2.png"));
        Subtraction.QuestionHard qsth13 = new Subtraction.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1, "10-2");
        questionHard.add(qsth13);
        // Question 14
        iconQuestion = new ImageIcon(getClass().getResource("/res/sub/hardNew/9.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/9-incorrect-1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/9-correct.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/sub/hardNew/bn/9-incorrect-2.png"));
        Subtraction.QuestionHard qsth14 = new Subtraction.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer2, "13-4");
        questionHard.add(qsth14);

    }

    int randHard;
    Timer timer;

    private Subtraction.QuestionHard randomQuestionHard() {
        Subtraction.QuestionHard qstshard;
        randHard = (int) (Math.random() * (14 - 1));
        qstshard = questionHard.get(randHard);

        System.out.println(randHard);

        symbn1.setVisible(false);
        symbn2.setVisible(false);
        symbn3.setVisible(false);

        return qstshard;
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

        symbn3 = new javax.swing.JLabel();
        symbn2 = new javax.swing.JLabel();
        symbn1 = new javax.swing.JLabel();
        bn1 = new javax.swing.JButton();
        bn2 = new javax.swing.JButton();
        bn3 = new javax.swing.JButton();
        home = new javax.swing.JButton();
        frame = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sc = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        wrong = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(symbn3);
        symbn3.setBounds(640, 300, 180, 160);
        getContentPane().add(symbn2);
        symbn2.setBounds(400, 290, 190, 180);
        getContentPane().add(symbn1);
        symbn1.setBounds(150, 290, 180, 170);

        bn1.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 1, 80)); // NOI18N
        bn1.setOpaque(false);
        bn1.setContentAreaFilled(false);
        bn1.setBorderPainted(false);
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
        bn1.setBounds(40, 270, 180, 150);

        bn2.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 1, 80)); // NOI18N
        bn2.setOpaque(false);
        bn2.setContentAreaFilled(false);
        bn2.setBorderPainted(false);
        bn2.setForeground(new java.awt.Color(255, 255, 255));
        bn2.setMargin(new java.awt.Insets(17, 20, 4, 14));
        bn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn2ActionPerformed(evt);
            }
        });
        getContentPane().add(bn2);
        bn2.setBounds(290, 270, 180, 150);

        bn3.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 1, 80)); // NOI18N
        bn3.setOpaque(false);
        bn3.setContentAreaFilled(false);
        bn3.setBorderPainted(false);
        bn3.setForeground(new java.awt.Color(255, 255, 255));
        bn3.setMargin(new java.awt.Insets(17, 20, 4, 14));
        bn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn3ActionPerformed(evt);
            }
        });
        getContentPane().add(bn3);
        bn3.setBounds(540, 270, 170, 150);

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
        getContentPane().add(frame);
        frame.setBounds(250, 70, 320, 190);

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/bgsub.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -40, 990, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                    AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/sounds/correct-answer.wav"));
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
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/sounds/wrong-sound.wav"));
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

//                    scoreFalse += 1;
//                    wrong.setText(scoreFalse + "");
                } else {
                    try {
                        symbn1.setVisible(true);
                        symbn1.setIcon(symbnIncorrect);
                        Clip correct = AudioSystem.getClip();
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/sounds/wrong-sound.wav"));
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
                    AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/sounds/correct-answer.wav"));
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
                        qstShow = randomQuestionHard();
                        checkNum = 1;

                        Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                        Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(130, 120, Image.SCALE_SMOOTH);
                        Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(130, 120, Image.SCALE_SMOOTH);
                        Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(130, 120, Image.SCALE_SMOOTH);

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
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/sounds/wrong-sound.wav"));
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
                            qstShow = randomQuestionHard();

                            Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                            Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(130, 120, Image.SCALE_SMOOTH);
                            Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(130, 120, Image.SCALE_SMOOTH);
                            Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(130, 120, Image.SCALE_SMOOTH);

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
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/sounds/wrong-sound.wav"));
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
                    AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/sounds/correct-answer.wav"));
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
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/sounds/wrong-sound.wav"));
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
                }
                    
                    else {
                        try {
                            symbn2.setVisible(true);
                            symbn2.setIcon(symbnIncorrect);
                            Clip correct = AudioSystem.getClip();
                            AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/sounds/wrong-sound.wav"));
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
                    AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/sounds/correct-answer.wav"));
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
                        qstShow = randomQuestionHard();
                        checkNum = 1;

                        Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                        Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(130, 120, Image.SCALE_SMOOTH);
                        Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(130, 120, Image.SCALE_SMOOTH);
                        Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(130, 120, Image.SCALE_SMOOTH);

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
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/sounds/wrong-sound.wav"));
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
                            qstShow = randomQuestionHard();

                            Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                            Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(130, 120, Image.SCALE_SMOOTH);
                            Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(130, 120, Image.SCALE_SMOOTH);
                            Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(130, 120, Image.SCALE_SMOOTH);

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
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/sounds/wrong-sound.wav"));
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
                    AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/sounds/correct-answer.wav"));
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
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/sounds/wrong-sound.wav"));
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
                }
                    else {
                        try {
                            symbn3.setVisible(true);
                            symbn3.setIcon(symbnIncorrect);
                            Clip correct = AudioSystem.getClip();
                            AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/sounds/wrong-sound.wav"));
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
                    AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/sounds/correct-answer.wav"));
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
                        qstShow = randomQuestionHard();
                        checkNum = 1;

                        Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                        Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(130, 120, Image.SCALE_SMOOTH);
                        Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(130, 120, Image.SCALE_SMOOTH);
                        Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(130, 120, Image.SCALE_SMOOTH);

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
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/sounds/wrong-sound.wav"));
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
                            qstShow = randomQuestionHard();

                            Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                            Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(130, 120, Image.SCALE_SMOOTH);
                            Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(130, 120, Image.SCALE_SMOOTH);
                            Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(130, 120, Image.SCALE_SMOOTH);

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
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/sounds/wrong-sound.wav"));
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
            java.util.logging.Logger.getLogger(Ch4SubHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ch4SubHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ch4SubHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ch4SubHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ch4SubHard().setVisible(true);
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
    private javax.swing.JLabel sc;
    private javax.swing.JLabel symbn1;
    private javax.swing.JLabel symbn2;
    private javax.swing.JLabel symbn3;
    private javax.swing.JLabel wrong;
    // End of variables declaration//GEN-END:variables
}
