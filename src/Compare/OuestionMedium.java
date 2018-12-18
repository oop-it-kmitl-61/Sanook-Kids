/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compare;

import javax.swing.ImageIcon;

/**
 *
 * @author Husna
 */
public class OuestionMedium {
    private ImageIcon imageLeft;
    private ImageIcon imageRight;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer;

    public OuestionMedium() {
    }

    public OuestionMedium(ImageIcon imageLeft, ImageIcon imageRight, String answer1, String answer2, String answer3, String answer) {
        this.imageLeft = imageLeft;
        this.imageRight = imageRight;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer = answer;
    }

    public ImageIcon getImageLeft() {
        return imageLeft;
    }

    public void setImageLeft(ImageIcon imageLeft) {
        this.imageLeft = imageLeft;
    }

    public ImageIcon getImageRight() {
        return imageRight;
    }

    public void setImageRight(ImageIcon imageRight) {
        this.imageRight = imageRight;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer() {
        return answer;
    }

    
    
    
}
