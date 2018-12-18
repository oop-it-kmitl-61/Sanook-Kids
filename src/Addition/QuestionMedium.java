/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Addition;

import javax.swing.ImageIcon;

/**
 *
 * @author Husna
 */
public class QuestionMedium {
    private ImageIcon imageLeft;
    private ImageIcon imageRight;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer;
    
    public QuestionMedium() {
        
    }
    
    public QuestionMedium(ImageIcon imageLeft, ImageIcon imageRight, String answer1, String answer2, String answer3, String answer) {
        this.imageLeft = imageLeft;
        this.imageRight = imageRight;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer = answer;
    }

    /**
     * @return the imageLeft
     */
    public ImageIcon getImageLeft() {
        return imageLeft;
    }

    /**
     * @param imageLeft the imageLeft to set
     */
    public void setImageLeft(ImageIcon imageLeft) {
        this.imageLeft = imageLeft;
    }

    /**
     * @return the imageRight
     */
    public ImageIcon getImageRight() {
        return imageRight;
    }

    /**
     * @param imageRight the imageRight to set
     */
    public void setImageRight(ImageIcon imageRight) {
        this.imageRight = imageRight;
    }

    /**
     * @return the answer1
     */
    public String getAnswer1() {
        return answer1;
    }

    /**
     * @param answer1 the answer1 to set
     */
    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    /**
     * @return the answer2
     */
    public String getAnswer2() {
        return answer2;
    }

    /**
     * @param answer2 the answer2 to set
     */
    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    /**
     * @return the answer3
     */
    public String getAnswer3() {
        return answer3;
    }

    /**
     * @param answer3 the answer3 to set
     */
    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    /**
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }
}
