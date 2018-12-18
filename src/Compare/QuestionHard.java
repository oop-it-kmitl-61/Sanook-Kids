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
public class QuestionHard {

    private ImageIcon imageQuestion;
    private ImageIcon answer1;
    private ImageIcon answer2;
    private ImageIcon answer3;
    private ImageIcon answer;
    private String ans;

    public QuestionHard() {

    }

    public QuestionHard(ImageIcon imageQuestion, ImageIcon answer1, ImageIcon answer2, ImageIcon answer3, ImageIcon answer, String ans) {
        this.imageQuestion = imageQuestion;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer = answer;
        this.ans = ans;
    }

   
    
    

    public ImageIcon getImageQuestion() {
        return imageQuestion;
    }

    public void setImageQuestion(ImageIcon imageQuestion) {
        this.imageQuestion = imageQuestion;
    }

    public ImageIcon getAnswer1() {
        return answer1;
    }

    public void setAnswer1(ImageIcon answer1) {
        this.answer1 = answer1;
    }

    public ImageIcon getAnswer2() {
        return answer2;
    }

    public void setAnswer2(ImageIcon answer2) {
        this.answer2 = answer2;
    }

    public ImageIcon getAnswer3() {
        return answer3;
    }

    public void setAnswer3(ImageIcon answer3) {
        this.answer3 = answer3;
    }

    public ImageIcon getAnswer() {
        return answer;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

   

    

    

}
