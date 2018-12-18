/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Counting;

import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


import javax.swing.ImageIcon;

/**
 *
 * @author Husna
 */
public class Question {
    private ImageIcon image;
    private String answer1;
    private String answer2;
    private String answer3;
   
    private String answer;
    
    public Question() {
        
    }

    public Question(ImageIcon image, String answer1, String answer2, String answer3, String answer) {
        this.image = image;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer = answer;
    }

    public ImageIcon getImage() {
        return image;
    }

    /**
     * @return the imageLeft
     */
    public void setImage(ImageIcon image) {    
        this.image = image;
    }

    /**
     * @return the imageRight
   

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
