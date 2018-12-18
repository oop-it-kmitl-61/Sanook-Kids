/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern;

import static Pattern.Ch6PatternMedium.HEIGHT;
import static Pattern.Ch6PatternMedium.WIDTH;
import Sounds.CorrectSound;
import static Subtraction.Ch4SubEasy1.TITLE;
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
public class Ch6PatternHard extends javax.swing.JFrame {

    /**
     * Creates new form Ch6PatternHard
     */
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 480;

    private int scoreEarn = 0;
    private int scoreFalse = 0;
    private int checkNum = 1;
    private int check = 1;
    private static final int scoreEnd = 10;

    private List<Pattern.QuestionHard> questionHard;
    private Pattern.QuestionHard qstShow;

    private String[] options = {"OK"};
    
    public Ch6PatternHard() {
        initComponents();
        setTitle(TITLE);
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        createQuestion();
        qstShow = randomQuestionHard();

        Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH);
        Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH);
        Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH);

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

    private void createQuestion() {
        questionHard = new ArrayList<Pattern.QuestionHard>();

        ImageIcon iconQuestion;

        ImageIcon iconAnswer1;
        ImageIcon iconAnswer2;
        ImageIcon iconAnswer3;
        ImageIcon iconAnswer;
        
        // Question 1
        iconQuestion = new ImageIcon(getClass().getResource("/res/pattern/easy/21.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/pattern/button/21-incorrect-1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/pattern/button/21-correct.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/pattern/button/21-incorrect-2.png"));
        Pattern.QuestionHard qsth1 = new Pattern.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer2, "2");
        questionHard.add(qsth1);
         // Question 2
        iconQuestion = new ImageIcon(getClass().getResource("/res/pattern/easy/22.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/pattern/button/22-incorrect-2.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/pattern/button/22-incorrect-1.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/pattern/button/22-correct.png"));
        Pattern.QuestionHard qsth2 = new Pattern.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer3, "3");
        questionHard.add(qsth2);
        
        // Question 3
        iconQuestion = new ImageIcon(getClass().getResource("/res/pattern/easy/23.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/pattern/button/23-correct.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/pattern/button/23-incorrect-2.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/pattern/button/23-incorrect-1.png"));
        Pattern.QuestionHard qsth3 = new Pattern.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1,"1");
        questionHard.add(qsth3);
        
        // Question 4
        iconQuestion = new ImageIcon(getClass().getResource("/res/pattern/easy/24.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/pattern/button/24-incorrect-1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/pattern/button/24-correct.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/pattern/button/24-incorrect-2.png"));
        Pattern.QuestionHard qsth4 = new Pattern.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer2,"2");
        questionHard.add(qsth4);
        
        // Question 5
        iconQuestion = new ImageIcon(getClass().getResource("/res/pattern/easy/25.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/pattern/button/25-incorrect-1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/pattern/button/25-incorrect-2.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/pattern/button/25-correct.png"));
        Pattern.QuestionHard qsth5 = new Pattern.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer3,"3");
        questionHard.add(qsth5);
        
        // Question 6
        iconQuestion = new ImageIcon(getClass().getResource("/res/pattern/easy/26.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/pattern/button/26-correct.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/pattern/button/26-incorrect-1.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/pattern/button/26-incorrect-2.png"));
        Pattern.QuestionHard qsth6 = new Pattern.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1,"1");
       questionHard.add(qsth6);
        
        // Question 7
        iconQuestion = new ImageIcon(getClass().getResource("/res/pattern/easy/27.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/pattern/button/27-incorrect-1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/pattern/button/27-correct.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/pattern/button/27-incorrect-2.png"));
        Pattern.QuestionHard qsth7 = new Pattern.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer2,"2");
        questionHard.add(qsth7);
        
        // Question 8
        iconQuestion = new ImageIcon(getClass().getResource("/res/pattern/easy/28.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/pattern/button/28-incorrect-2.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/pattern/button/28-incorrect-1.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/pattern/button/28-correct.png"));
        Pattern.QuestionHard qsth8 = new Pattern.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer3,"3");
        questionHard.add(qsth8);
        
        // Question 9
        iconQuestion = new ImageIcon(getClass().getResource("/res/pattern/easy/29.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/pattern/button/29-correct.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/pattern/button/29-incorrect-1.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/pattern/button/29-incorrect-2.png"));
        Pattern.QuestionHard qsth9 = new Pattern.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1,"1");
        questionHard.add(qsth9);
        
        // Question 10
        iconQuestion = new ImageIcon(getClass().getResource("/res/pattern/easy/30.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/pattern/button/30-incorrect-1.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/pattern/button/30-correct.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/pattern/button/30-incorrect-2.png"));
        Pattern.QuestionHard qsth10 = new Pattern.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer2,"2");
        questionHard.add(qsth10);
        
    }
    
    
    int randHard;
    Timer timer;

    private Pattern.QuestionHard randomQuestionHard() {
        Pattern.QuestionHard qstshard;
        randHard = (int) (Math.random() * (10 - 1));
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
        frame = new javax.swing.JLabel();
        symbn1 = new javax.swing.JLabel();
        home = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        sc = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        wrong = new javax.swing.JLabel();
        bn3 = new javax.swing.JButton();
        bn2 = new javax.swing.JButton();
        bn1 = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(symbn3);
        symbn3.setBounds(620, 300, 150, 140);
        getContentPane().add(symbn2);
        symbn2.setBounds(390, 310, 150, 140);
        getContentPane().add(frame);
        frame.setBounds(50, 100, 690, 160);
        getContentPane().add(symbn1);
        symbn1.setBounds(140, 310, 150, 140);

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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/scoreFalse.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(670, 10, 40, 40);

        wrong.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 0, 36)); // NOI18N
        getContentPane().add(wrong);
        wrong.setBounds(710, 10, 60, 50);

        bn3.setBackground(new java.awt.Color(24, 32, 47));
        bn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn3ActionPerformed(evt);
            }
        });
        getContentPane().add(bn3);
        bn3.setBounds(580, 320, 160, 90);

        bn2.setBackground(new java.awt.Color(24, 32, 47));
        bn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn2ActionPerformed(evt);
            }
        });
        getContentPane().add(bn2);
        bn2.setBounds(310, 320, 160, 90);

        bn1.setBackground(new java.awt.Color(24, 32, 47));
        bn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn1ActionPerformed(evt);
            }
        });
        getContentPane().add(bn1);
        bn1.setBounds(50, 320, 150, 90);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/bg_subtraction.png"))); // NOI18N
        getContentPane().add(bg);
        bg.setBounds(0, -30, 880, 530);

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
                    AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/correct-answer.wav"));
                    correct.open(audio);
                    correct.start();
                    Thread.sleep(900);
                    correct.close();
                } catch (Exception ex) {
                    Logger.getLogger(Ch6PatternHard.class.getName()).log(Level.SEVERE, null, ex);
                }

                int choice = JOptionPane.showOptionDialog(null, "Correct and Finish", "Correct", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
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
                        Logger.getLogger(Ch6PatternHard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JLabel label = new JLabel("คำตอบที่ถูกต้องก็คือ   ข้อ " + qstShow.getAns() + "     ");
                    label.setFont(new Font("BoonJot", Font.PLAIN, 20));
                    JOptionPane.showMessageDialog(null, label, "เฉลย", JOptionPane.INFORMATION_MESSAGE, icon);

                    int choice = JOptionPane.showOptionDialog(null, "Correct and Finish", "Wrong", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    if (choice == 0) {
                        Choose c = new Choose();
                        c.setVisible(true);
                        close();

                        //                        scoreFalse += 1;
                        //                        wrong.setText(scoreFalse + "");
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
                            Logger.getLogger(Ch6PatternHard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        timer = new Timer(700, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                symbn3.setVisible(false);
                                timer.stop();
                            }
                        });
                        timer.start();
                        checkNum = 1;
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
                    Logger.getLogger(Ch6PatternHard.class.getName()).log(Level.SEVERE, null, ex);
                }

                timer = new Timer(800, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        symbn3.setVisible(false);
                        qstShow = randomQuestionHard();
                        checkNum = 1;

                        Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                        Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH);
                        Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH);
                        Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH);

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
                        Logger.getLogger(Ch6PatternHard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JLabel label = new JLabel("คำตอบที่ถูกต้องก็คือ   ข้อ " + qstShow.getAns() + "     ");
                    label.setFont(new Font("BoonJot", Font.PLAIN, 20));
                    JOptionPane.showMessageDialog(null, label, "เฉลย", JOptionPane.INFORMATION_MESSAGE, icon);

                    timer = new Timer(800, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            symbn3.setVisible(false);
                            qstShow = randomQuestionHard();

                            Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                            Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH);
                            Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH);
                            Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH);

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
                        Logger.getLogger(Ch6PatternHard.class.getName()).log(Level.SEVERE, null, ex);
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
                    AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/correct-answer.wav"));
                    correct.open(audio);
                    correct.start();
                    Thread.sleep(900);
                    correct.close();
                } catch (Exception ex) {
                    Logger.getLogger(Ch6PatternHard.class.getName()).log(Level.SEVERE, null, ex);
                }

                int choice = JOptionPane.showOptionDialog(null, "Correct and Finish", "Correct", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
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
                        Logger.getLogger(Ch6PatternHard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JLabel label = new JLabel("คำตอบที่ถูกต้องก็คือ   ข้อ " + qstShow.getAns() + "     ");
                    label.setFont(new Font("BoonJot", Font.PLAIN, 20));
                    JOptionPane.showMessageDialog(null, label, "เฉลย", JOptionPane.INFORMATION_MESSAGE, icon);

                    int choice = JOptionPane.showOptionDialog(null, "Correct and Finish", "Wrong", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    if (choice == 0) {
                        Choose c = new Choose();
                        c.setVisible(true);
                        close();

                        //                        scoreFalse += 1;
                        //                        wrong.setText(scoreFalse + "");
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
                            Logger.getLogger(Ch6PatternHard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        timer = new Timer(700, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                symbn2.setVisible(false);
                                timer.stop();
                            }
                        });
                        timer.start();
                        checkNum = 1;
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
                    Logger.getLogger(Ch6PatternHard.class.getName()).log(Level.SEVERE, null, ex);
                }

                timer = new Timer(800, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        symbn2.setVisible(false);
                        qstShow = randomQuestionHard();
                        checkNum = 1;

                        Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                        Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH);
                        Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH);
                        Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH);

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
                        Logger.getLogger(Ch6PatternHard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JLabel label = new JLabel("คำตอบที่ถูกต้องก็คือ   ข้อ " + qstShow.getAns() + "     ");
                    label.setFont(new Font("BoonJot", Font.PLAIN, 20));
                    JOptionPane.showMessageDialog(null, label, "เฉลย", JOptionPane.INFORMATION_MESSAGE, icon);

                    timer = new Timer(800, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            symbn1.setVisible(false);
                            qstShow = randomQuestionHard();

                            Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                            Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH);
                            Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH);
                            Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH);

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
                        Logger.getLogger(Ch6PatternHard.class.getName()).log(Level.SEVERE, null, ex);
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
                    AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/correct-answer.wav"));
                    correct.open(audio);
                    correct.start();
                    Thread.sleep(900);
                    correct.close();
                } catch (Exception ex) {
                    Logger.getLogger(Ch6PatternHard.class.getName()).log(Level.SEVERE, null, ex);
                }

                int choice = JOptionPane.showOptionDialog(null, "Correct and Finish", "Correct", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
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
                        Logger.getLogger(Ch6PatternHard.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    JLabel label = new JLabel("คำตอบที่ถูกต้องคือ   ข้อ " + qstShow.getAns() +"    ");
                    label.setFont(new Font("BoonJot", Font.PLAIN, 20));
                    JOptionPane.showMessageDialog(null, label, "เฉลย", JOptionPane.INFORMATION_MESSAGE, icon);

                    int choice = JOptionPane.showOptionDialog(null, "Correct and Finish", "Wrong", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
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
                        AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/wrong-sound.wav"));
                        correct.open(audio);
                        correct.start();
                        Thread.sleep(800);
                        correct.close();
                    } catch (Exception ex) {
                        Logger.getLogger(Ch6PatternHard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    timer = new Timer(700, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            symbn1.setVisible(false);
                            timer.stop();
                        }
                    });
                    timer.start();
                    checkNum = 1;
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
                    Logger.getLogger(Ch6PatternHard.class.getName()).log(Level.SEVERE, null, ex);
                }

                timer = new Timer(800, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        symbn1.setVisible(false);
                        qstShow = randomQuestionHard();
                        checkNum = 1;

                        Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                        Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH);
                        Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH);
                        Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH);

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
                        Logger.getLogger(Ch6PatternHard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JLabel label = new JLabel("คำตอบที่ถูกต้องคือ   ข้อ " + qstShow.getAns() + "    ");
                    label.setFont(new Font("BoonJot", Font.PLAIN, 20));
                    JOptionPane.showMessageDialog(null, label, "เฉลย", JOptionPane.INFORMATION_MESSAGE, icon);

                    timer = new Timer(800, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            symbn1.setVisible(false);
                            qstShow = randomQuestionHard();

                            Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
                            Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH);
                            Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH);
                            Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH);

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
                        Logger.getLogger(Ch6PatternHard.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Ch6PatternHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ch6PatternHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ch6PatternHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ch6PatternHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ch6PatternHard().setVisible(true);
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
