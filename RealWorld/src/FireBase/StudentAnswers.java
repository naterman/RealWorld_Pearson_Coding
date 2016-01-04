/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firebase;

/**
 *
 * @author Nathan Smith
 */
public class StudentAnswers {

    private String correctAnswer;
    private String studentAnswer;

    /**
     *
     * @param cA
     * @param sA
     */
    public StudentAnswers(String cA, String sA) {
        this.correctAnswer = cA;
        this.studentAnswer = sA;
    }

    /**
     * @return the correctAnswer
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * @param correctAnswer the correctAnswer to set
     */
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    /**
     * @return the studentAnswer
     */
    public String getStudentAnswer() {
        return studentAnswer;
    }

    /**
     * @param studentAnswer the studentAnswer to set
     */
    public void setStudentAnswer(String studentAnswer) {
        this.studentAnswer = studentAnswer;
    }
}
