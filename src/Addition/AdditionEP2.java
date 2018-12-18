package Addition;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import static Subtraction.Ch4SubHard.HEIGHT;
//import static Subtraction.Ch4SubHard.TITLE;
//import static Subtraction.Ch4SubHard.WIDTH;
import Sounds.CorrectSound;
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
 * @author smytt
 */
public class AdditionEP2 extends javax.swing.JFrame {

    /**
     * Creates new form AdditionEP2
     */
    public static final String TITLE = "สนุก Kids";
    public static final int WIDTH = 800;
    public static final int HEIGHT = 480;

    private int scoreEarn = 0;
    private int scoreFalse = 0;
    private int checkNum = 1;
    private int check = 1;
    private static final int scoreEnd = 10;

    private List<Addition.QuestionHard> questionHard;
    private Addition.QuestionHard qstShow;
    private String[] options = {"OK"};

    public AdditionEP2() {
        initComponents();
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);

        createQuestion();
        qstShow = randomQuestionHard();

        Image imageQuestion = qstShow.getImageQuestion().getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        Image answer1 = qstShow.getAnswer1().getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);
        Image answer2 = qstShow.getAnswer2().getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);
        Image answer3 = qstShow.getAnswer3().getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);

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
        questionHard = new ArrayList<Addition.QuestionHard>();

        ImageIcon iconQuestion;

        ImageIcon iconAnswer1;
        ImageIcon iconAnswer2;
        ImageIcon iconAnswer3;
        ImageIcon iconAnswer;

        // Question 1
        iconQuestion = new ImageIcon(getClass().getResource("/res/addition/hard/basket24.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/11+13.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/16+5.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/13+10.png"));
        Addition.QuestionHard qsth1 = new Addition.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1, "11+13");
        questionHard.add(qsth1);
        // Question 2
        iconQuestion = new ImageIcon(getClass().getResource("/res/addition/hard/basket26.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/13+13.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/15+12.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/14+8.png"));
        Addition.QuestionHard qsth2 = new Addition.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1, "13+13");
        questionHard.add(qsth2);
        // Question 3
        iconQuestion = new ImageIcon(getClass().getResource("/res/addition/hard/basket12.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/12+9.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/6+9.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/8+4.png"));
        Addition.QuestionHard qsth3 = new Addition.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer3, "8+4");
        questionHard.add(qsth3);
        // Question 4
        iconQuestion = new ImageIcon(getClass().getResource("/res/addition/hard/basket20.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/14+6.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/10+7.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/11+8.png"));
        Addition.QuestionHard qsth4 = new Addition.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1, "14+6");
        questionHard.add(qsth4);
        // Question 5
        iconQuestion = new ImageIcon(getClass().getResource("/res/addition/hard/basket18.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/19+3.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/13+5.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/15+6.png"));
        Addition.QuestionHard qsth5 = new Addition.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer2, "13+5");
        questionHard.add(qsth5);
        // Question 6
        iconQuestion = new ImageIcon(getClass().getResource("/res/addition/hard/basket27.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/10+5.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/17+9.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/14+13.png"));
        Addition.QuestionHard qsth6 = new Addition.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer3, "14+13");
        questionHard.add(qsth6);
        // Question 7
        iconQuestion = new ImageIcon(getClass().getResource("/res/addition/hard/basket25.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/14+13.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/13+12.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/11+18.png"));
        Addition.QuestionHard qsth7 = new Addition.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer2, "13+12");
        questionHard.add(qsth7);
        // Question 8
        iconQuestion = new ImageIcon(getClass().getResource("/res/addition/hard/basket27.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/18+11.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/18+14.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/15+12.png"));
        Addition.QuestionHard qsth8 = new Addition.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer3, "15+12");
        questionHard.add(qsth8);
        // Question 9
        iconQuestion = new ImageIcon(getClass().getResource("/res/addition/hard/basket30.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/15+15.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/14+13.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/18+11.png"));
        Addition.QuestionHard qsth9 = new Addition.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1, "15+15");
        questionHard.add(qsth9);
        // Question 10
        iconQuestion = new ImageIcon(getClass().getResource("/res/addition/hard/basket28.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/12+8.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/19+9.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/13+5.png"));
        Addition.QuestionHard qsth10 = new Addition.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer2, "19+9");
        questionHard.add(qsth10);
        // Question 11
        iconQuestion = new ImageIcon(getClass().getResource("/res/addition/hard/basket21.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/15+6.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/19+9.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/13+5.png"));
        Addition.QuestionHard qsth11 = new Addition.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1, "15+6");
        questionHard.add(qsth11);
        // Question 12
        iconQuestion = new ImageIcon(getClass().getResource("/res/addition/hard/basket28.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/13+15.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/15+12.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/13+13.png"));
        Addition.QuestionHard qsth12 = new Addition.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1, "13+15");
        questionHard.add(qsth12);
        // Question 13
        iconQuestion = new ImageIcon(getClass().getResource("/res/addition/hard/basket22.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/11+11.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/13+10.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/13+13.png"));
        Addition.QuestionHard qsth13 = new Addition.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1, "11+11");
        questionHard.add(qsth13);
        // Question 14
        iconQuestion = new ImageIcon(getClass().getResource("/res/addition/hard/basket23.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/13+12.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/19+9.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/13+10.png"));
        Addition.QuestionHard qsth14 = new Addition.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer3, "13+10");
        questionHard.add(qsth14);
        // Question 15
        iconQuestion = new ImageIcon(getClass().getResource("/res/addition/hard/basket29.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/11+18.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/14+13.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/15+12.png"));
        Addition.QuestionHard qsth15 = new Addition.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer1, "11+18");
        questionHard.add(qsth15);
        // Question 16
        iconQuestion = new ImageIcon(getClass().getResource("/res/addition/hard/basket23.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/13+12.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/19+9.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/13+10.png"));
        Addition.QuestionHard qsth16 = new Addition.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer3, "13+10");
        questionHard.add(qsth16);
        // Question 17
        iconQuestion = new ImageIcon(getClass().getResource("/res/addition/hard/basket21.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/16+6.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/17+9.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/16+5.png"));
        Addition.QuestionHard qsth17 = new Addition.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer3, "16+5");
        questionHard.add(qsth17);
        // Question 18
        iconQuestion = new ImageIcon(getClass().getResource("/res/addition/hard/basket20.png"));
        iconAnswer1 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/11+8.png"));
        iconAnswer2 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/14+6.png"));
        iconAnswer3 = new ImageIcon(getClass().getResource("/res/addition/hard/bn/12+8.png"));
        Addition.QuestionHard qsth18 = new Addition.QuestionHard(iconQuestion, iconAnswer1, iconAnswer2, iconAnswer3, iconAnswer3, "12+8");
        questionHard.add(qsth18);

    }

    int randHard;
    Timer timer;

    private Addition.QuestionHard randomQuestionHard() {
        Addition.QuestionHard qstshard;
        randHard = (int) (Math.random() * (12 - 1));
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

        jPanel1 = new javax.swing.JPanel();
        symbn1 = new javax.swing.JLabel();
        symbn2 = new javax.swing.JLabel();
        symbn3 = new javax.swing.JLabel();
        bn1 = new javax.swing.JButton();
        bn2 = new javax.swing.JButton();
        bn3 = new javax.swing.JButton();
        frame = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sc = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        wrong = new javax.swing.JLabel();
        home = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);
        jPanel1.add(symbn1);
        symbn1.setBounds(140, 300, 190, 140);
        jPanel1.add(symbn2);
        symbn2.setBounds(380, 300, 190, 140);
        jPanel1.add(symbn3);
        symbn3.setBounds(610, 290, 190, 150);

        bn1.setOpaque(false);
        bn1.setContentAreaFilled(false);
        bn1.setBorderPainted(false);
        bn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn1ActionPerformed(evt);
            }
        });
        jPanel1.add(bn1);
        bn1.setBounds(40, 280, 200, 140);

        bn2.setOpaque(false);
        bn2.setContentAreaFilled(false);
        bn2.setBorderPainted(false);
        bn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn2ActionPerformed(evt);
            }
        });
        jPanel1.add(bn2);
        bn2.setBounds(290, 280, 200, 140);

        bn3.setOpaque(false);
        bn3.setContentAreaFilled(false);
        bn3.setBorderPainted(false);
        bn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bn3ActionPerformed(evt);
            }
        });
        jPanel1.add(bn3);
        bn3.setBounds(540, 280, 200, 140);
        jPanel1.add(frame);
        frame.setBounds(280, 70, 210, 160);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/scoreEarn.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(500, 10, 50, 40);

        sc.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 0, 36)); // NOI18N
        jPanel1.add(sc);
        sc.setBounds(550, 10, 60, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/scoreFalse.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(670, 10, 40, 40);

        wrong.setFont(new java.awt.Font("Layiji MaHaNiYom V1.61", 0, 36)); // NOI18N
        jPanel1.add(wrong);
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
        jPanel1.add(home);
        home.setBounds(0, 0, 70, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/bgsub.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, -10, 900, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

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
            java.util.logging.Logger.getLogger(AdditionEP2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdditionEP2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdditionEP2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdditionEP2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdditionEP2().setVisible(true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel sc;
    private javax.swing.JLabel symbn1;
    private javax.swing.JLabel symbn2;
    private javax.swing.JLabel symbn3;
    private javax.swing.JLabel wrong;
    // End of variables declaration//GEN-END:variables
}
