/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Addition;

import Sounds.CorrectSound;
import Subtraction.Ch4SubHard;
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
import javax.swing.JOptionPane;
import javax.swing.Timer;
import oop.Choose;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Husna
 */
public class AdditionEp3 extends javax.swing.JFrame {

    /**
     * Creates new form AdditionEp3
     */
    
    private int scoreEarn = 0;
    private int check = 1;
    private int scoreFalse = 0;
    private int checkNum = 1;
    private static final int scoreEnd = 10;

    private List<Addition.QuestionMedium> questionmedium;

   
    private Addition.QuestionMedium qstShow;

    private String[] options = {"OK"};
    
    public AdditionEp3() {
        initComponents();
        setSize(800,480);
        setResizable(false);
        setLocationRelativeTo(null);

        createQuestion();
        qstShow = randomQuestionMedium();

        
        Image imageLeft = qstShow.getImageLeft().getImage().getScaledInstance(frame_left.getWidth(), frame_left.getHeight(), Image.SCALE_SMOOTH);
        Image imageRight = qstShow.getImageRight().getImage().getScaledInstance(frame_right.getWidth(), frame_right.getHeight(), Image.SCALE_SMOOTH);
        frame_left.setIcon(new ImageIcon(imageLeft));
        frame_right.setIcon(new ImageIcon(imageRight));
        bn1.setText(qstShow.getAnswer1());
        bn2.setText(qstShow.getAnswer2());
        bn3.setText(qstShow.getAnswer3());
        sc.setText(scoreEarn + "");
        wrong.setText(scoreFalse+"");
    }
    
    public String[] getImages() {
        File file = new File(getClass().getResource("/res").getFile());
        String[] imagesList = file.list();
        return imagesList;
    }

    private void createQuestion() {
        questionmedium = new ArrayList<Addition.QuestionMedium>();

        ImageIcon iconLeft;
        ImageIcon iconRight;

        // Question 1
        iconLeft = new ImageIcon(getClass().getResource("/res/addition/easy/8.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/addition/easy/6.png"));
        Addition.QuestionMedium qstm = new Addition.QuestionMedium(iconLeft, iconRight, "14", "19", "12", "14");
        questionmedium.add(qstm);
        // Question 2
        iconLeft = new ImageIcon(getClass().getResource("/res/addition/easy/7.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/addition/easy/num3.png"));
        Addition.QuestionMedium qstm2 = new Addition.QuestionMedium(iconLeft, iconRight, "12", "11", "10", "10");
        questionmedium.add(qstm2);
        // Question 3
        iconLeft = new ImageIcon(getClass().getResource("/res/addition/easy/9.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/addition/easy/num3.png"));
        Addition.QuestionMedium qstm3 = new Addition.QuestionMedium(iconLeft, iconRight, "14", "12", "11", "12");
        questionmedium.add(qstm3);
        // Question 4
        iconLeft = new ImageIcon(getClass().getResource("/res/addition/easy/6.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/addition/easy/7.png"));
        Addition.QuestionMedium qstm4 = new Addition.QuestionMedium(iconLeft, iconRight, "15", "14", "13", "13");
        questionmedium.add(qstm4);

        // Question 5
        iconLeft = new ImageIcon(getClass().getResource("/res/addition/easy/5.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/addition/easy/num5.png"));
       Addition.QuestionMedium qstm5 = new Addition.QuestionMedium(iconLeft, iconRight, "12", "9", "10", "10");
        questionmedium.add(qstm5);
        // Question 6
        iconLeft = new ImageIcon(getClass().getResource("/res/addition/easy/8.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/addition/easy/num4.png"));
        Addition.QuestionMedium qstm6 = new Addition.QuestionMedium(iconLeft, iconRight, "10", "13", "12", "12");
        questionmedium.add(qstm6);

        // Question 7
        iconLeft = new ImageIcon(getClass().getResource("/res/addition/easy/10.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/addition/easy/num1.png"));
        Addition.QuestionMedium qstm7 = new Addition.QuestionMedium(iconLeft, iconRight, "17", "11", "15", "11");
        questionmedium.add(qstm7);
        // Question 8
        iconLeft = new ImageIcon(getClass().getResource("/res/addition/easy/7.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/addition/easy/num5.png"));
        Addition.QuestionMedium qstm8 = new Addition.QuestionMedium(iconLeft, iconRight, "10", "12", "14", "12");
        questionmedium.add(qstm8);

        // Question 9
        iconLeft = new ImageIcon(getClass().getResource("/res/addition/easy/num6.png"));
        iconRight = new ImageIcon(getClass().getResource("/res/addition/easy/num9.png"));
        Addition.QuestionMedium qstm9 = new Addition.QuestionMedium(iconLeft, iconRight, "10", "14", "15", "15");
        questionmedium.add(qstm9);
    }
    int randMedium;
    Timer timer;

    private Addition.QuestionMedium randomQuestionMedium() {
        Addition.QuestionMedium qstsmedium;
        randMedium = (int) (Math.random() * (9 - 1));
        qstsmedium = questionmedium.get(randMedium);

        System.out.println(randMedium);
        
        symbn1.setVisible(false);
        symbn2.setVisible(false);
        symbn3.setVisible(false);

        return qstsmedium;
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

        frame_right = new javax.swing.JLabel();
        symbn3 = new javax.swing.JLabel();
        frame_left = new javax.swing.JLabel();
        symbn2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        symbn1 = new javax.swing.JLabel();
        home = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        sc = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        wrong = new javax.swing.JLabel();
        bn3 = new javax.swing.JButton();
        bn2 = new javax.swing.JButton();
        bn1 = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(frame_right);
        frame_right.setBounds(470, 70, 240, 210);
        getContentPane().add(symbn3);
        symbn3.setBounds(620, 290, 180, 160);
        getContentPane().add(frame_left);
        frame_left.setBounds(70, 70, 240, 210);
        getContentPane().add(symbn2);
        symbn2.setBounds(380, 300, 200, 160);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/addition/easy/plus.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(330, 120, 110, 100);
        getContentPane().add(symbn1);
        symbn1.setBounds(160, 290, 180, 170);

        home.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 0, 18)); // NOI18N
        home.setOpaque(false);
        home.setContentAreaFilled(false);
        home.setBorderPainted(false);
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/home_4.png"))); // NOI18N
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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/scoreFalse.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(670, 10, 40, 40);

        wrong.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 0, 36)); // NOI18N
        getContentPane().add(wrong);
        wrong.setBounds(710, 10, 60, 50);

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

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/bgsub.png"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, -80, 930, 640);

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
                        qstShow = randomQuestionMedium();
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
                            qstShow = randomQuestionMedium();

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
                        qstShow = randomQuestionMedium();
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
                            qstShow = randomQuestionMedium();

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
                        qstShow = randomQuestionMedium();
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
                            qstShow = randomQuestionMedium();

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
            java.util.logging.Logger.getLogger(AdditionEp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdditionEp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdditionEp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdditionEp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdditionEp3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton bn1;
    private javax.swing.JButton bn2;
    private javax.swing.JButton bn3;
    private javax.swing.JLabel frame_left;
    private javax.swing.JLabel frame_right;
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
