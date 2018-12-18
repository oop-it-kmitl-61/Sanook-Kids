/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Counting;

import static Counting.CountingHard.HEIGHT;
import static Counting.CountingHard.WIDTH;
import Sounds.CorrectSound;
import static Subtraction.Ch4SubEasy1.TITLE;
import Subtraction.Ch4SubHard;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
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
public class CountingHard extends javax.swing.JFrame {

    /**
     * Creates new form CountingHard
     */
    public static final int WIDTH = 800;
    public static final int HEIGHT = 480;

    private int scoreEarn = 0;
    private int scoreFalse = 0;
    private int checkNum = 1;
    private int check = 1;
    private static final int scoreEnd = 10;

    private List<Counting.QuestionHard> questionhard;

    private Counting.QuestionHard qstShow;

    private String[] options = {"OK"};

    public CountingHard() {
        initComponents();
        setTitle(TITLE);
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        createQuestionHard();
        qstShow = randomQuestionHard();

        Image imageLeft = qstShow.getImageLeft().getImage().getScaledInstance(frame_left.getWidth(), frame_left.getHeight(), Image.SCALE_SMOOTH);
        Image imageRight = qstShow.getImageRight().getImage().getScaledInstance(frame_right.getWidth(), frame_right.getHeight(), Image.SCALE_SMOOTH);
        frame_left.setIcon(new ImageIcon(imageLeft));
        frame_right.setIcon(new ImageIcon(imageRight));
        bn1.setText(qstShow.getAnswer1());
        bn2.setText(qstShow.getAnswer2());
        bn3.setText(qstShow.getAnswer3());
        sc.setText(scoreEarn + "");
        wrong.setText(scoreFalse + "");
    }

    public String[] getImages() {
        File file = new File(getClass().getResource("/res").getFile());
        String[] imagesList = file.list();
        return imagesList;
    }

    private void createQuestionHard() {

        questionhard = new ArrayList<Counting.QuestionHard>();

        ImageIcon iconLeft_hard;
        ImageIcon iconRight_hard;

        // Question 1
        iconLeft_hard = new ImageIcon(getClass().getResource("/res/counting/hard_1.png"));
        iconRight_hard = new ImageIcon(getClass().getResource("/res/counting/Orange.png"));
        Counting.QuestionHard qsth1 = new Counting.QuestionHard(iconLeft_hard, iconRight_hard, "3", "4", "5", "5");
        questionhard.add(qsth1);

        // Question 2
        iconLeft_hard = new ImageIcon(getClass().getResource("/res/counting/hard_2.png"));
        iconRight_hard = new ImageIcon(getClass().getResource("/res/counting/apple4G.png"));
        Counting.QuestionHard qsth2 = new Counting.QuestionHard(iconLeft_hard, iconRight_hard, "6", "8", "10", "10");
        questionhard.add(qsth2);

        // Question 3
        iconLeft_hard = new ImageIcon(getClass().getResource("/res/counting/hard_2.png"));
        iconRight_hard = new ImageIcon(getClass().getResource("/res/counting/Strawberry.png"));
        Counting.QuestionHard qsth3 = new Counting.QuestionHard(iconLeft_hard, iconRight_hard, "5", "6", "7", "6");
        questionhard.add(qsth3);

        // Question 4
        iconLeft_hard = new ImageIcon(getClass().getResource("/res/counting/hard_3.png"));
        iconRight_hard = new ImageIcon(getClass().getResource("/res/counting/Strawberry.png"));
        Counting.QuestionHard qsth4 = new Counting.QuestionHard(iconLeft_hard, iconRight_hard, "5", "6", "7", "5");
        questionhard.add(qsth4);

        // Question 5
        iconLeft_hard = new ImageIcon(getClass().getResource("/res/counting/hard_3.png"));
        iconRight_hard = new ImageIcon(getClass().getResource("/res/counting/apple4G.png"));
        Counting.QuestionHard qsth5 = new Counting.QuestionHard(iconLeft_hard, iconRight_hard, "5", "6", "7", "5");
        questionhard.add(qsth5);

        // Question 6
        iconLeft_hard = new ImageIcon(getClass().getResource("/res/counting/hard_4.png"));
        iconRight_hard = new ImageIcon(getClass().getResource("/res/counting/Cherry.png"));
        Counting.QuestionHard qsth6 = new Counting.QuestionHard(iconLeft_hard, iconRight_hard, "9", "10", "11", "11");
        questionhard.add(qsth6);

        // Question 7
        iconLeft_hard = new ImageIcon(getClass().getResource("/res/counting/hard_4.png"));
        iconRight_hard = new ImageIcon(getClass().getResource("/res/counting/Mangosteen.png"));
        Counting.QuestionHard qsth7 = new Counting.QuestionHard(iconLeft_hard, iconRight_hard, "9", "10", "11", "9");
        questionhard.add(qsth7);
        
        // Question 8
        iconLeft_hard = new ImageIcon(getClass().getResource("/res/counting/hard_5.png"));
        iconRight_hard = new ImageIcon(getClass().getResource("/res/counting/Mango.png"));
        Counting.QuestionHard qsth8 = new Counting.QuestionHard(iconLeft_hard, iconRight_hard, "10", "12", "11", "12");
        questionhard.add(qsth8);
        
        // Question 9
        iconLeft_hard = new ImageIcon(getClass().getResource("/res/counting/hard_6.png"));
        iconRight_hard = new ImageIcon(getClass().getResource("/res/counting/Rambutan.png"));
        Counting.QuestionHard qsth9 = new Counting.QuestionHard(iconLeft_hard, iconRight_hard, "15", "14", "16", "15");
        questionhard.add(qsth9);
        
        // Question 10
        iconLeft_hard = new ImageIcon(getClass().getResource("/res/counting/hard_7.png"));
        iconRight_hard = new ImageIcon(getClass().getResource("/res/counting/MangoSteen.png"));
        Counting.QuestionHard qsth10 = new Counting.QuestionHard(iconLeft_hard, iconRight_hard, "11", "13", "12", "12");
        questionhard.add(qsth10);

    }

    int randHard;
    Timer timer;

    private Counting.QuestionHard randomQuestionHard() {
        Counting.QuestionHard qstshard;
        randHard = (int) (Math.random() * (10 - 1));
        qstshard = questionhard.get(randHard);
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

        symbn2 = new javax.swing.JLabel();
        symbn1 = new javax.swing.JLabel();
        frame_left = new javax.swing.JLabel();
        symbn3 = new javax.swing.JLabel();
        frame_right = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bn1 = new javax.swing.JButton();
        bn2 = new javax.swing.JButton();
        bn3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        sc = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        wrong = new javax.swing.JLabel();
        home = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(symbn2);
        symbn2.setBounds(380, 290, 200, 160);
        getContentPane().add(symbn1);
        symbn1.setBounds(160, 280, 180, 170);
        getContentPane().add(frame_left);
        frame_left.setBounds(100, 70, 320, 230);
        getContentPane().add(symbn3);
        symbn3.setBounds(620, 280, 180, 160);

        frame_right.setFont(new java.awt.Font("Angsana New", 2, 48)); // NOI18N
        frame_right.setForeground(new java.awt.Color(240, 240, 240));
        getContentPane().add(frame_right);
        frame_right.setBounds(420, 110, 100, 80);

        jLabel2.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 0, 48)); // NOI18N
        jLabel2.setText("มีกี่ผลเอ่ย ?");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(530, 130, 170, 57);

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
        bn1.setBounds(80, 310, 130, 90);

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
        bn2.setBounds(330, 310, 130, 90);

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
        bn3.setBounds(580, 310, 130, 90);

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

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/bgsub.png"))); // NOI18N
        getContentPane().add(bg);
        bg.setBounds(0, 0, 800, 480);

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
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/sounds/wrong-sound.wav"));
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
                            qstShow = randomQuestionHard();

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
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/sounds/wrong-sound.wav"));
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
                            qstShow = randomQuestionHard();

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
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/res/sounds/wrong-sound.wav"));
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
                            qstShow = randomQuestionHard();

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
            java.util.logging.Logger.getLogger(CountingHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CountingHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CountingHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CountingHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CountingHard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton bn1;
    private javax.swing.JButton bn2;
    private javax.swing.JButton bn3;
    private javax.swing.JLabel frame_left;
    private javax.swing.JLabel frame_right;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel sc;
    private javax.swing.JLabel symbn1;
    private javax.swing.JLabel symbn2;
    private javax.swing.JLabel symbn3;
    private javax.swing.JLabel wrong;
    // End of variables declaration//GEN-END:variables
}
