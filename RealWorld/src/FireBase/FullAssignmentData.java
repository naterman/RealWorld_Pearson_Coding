/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firebase;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Nathan Smith
 */
public class FullAssignmentData {

    Assignment assignment;
    LinkedList<Question> questions = new LinkedList<>();
    private String courseID;
    private HashMap<String, StudentAnswers> studentsAnswers = new HashMap<>();

    /**
     *
     * @param a
     */
    public FullAssignmentData(Assignment a) {
        this.assignment = a;
    }

    /**
     *
     * @return
     */
    public Assignment getAssignment() {
        return assignment;
    }

    /**
     *
     * @param a
     */
    public void setAssignment(Assignment a) {
        this.assignment = a;
    }

    /**
     *
     * @return
     */
    public LinkedList<Question> getQuestions() {
        return this.questions;
    }

    /**
     *
     * @param i
     * @return
     */
    public Question getOneQuestions(int i) {
        return this.questions.get(i);
    }

    /**
     *
     * @param newQuestions
     */
    public void addAllQuestions(LinkedList<Question> newQuestions) {
        this.questions = newQuestions;
    }

    /**
     *
     * @param item
     */
    public void addOneQuestion(Question item) {
        if (item.getLinktoid().equals(assignment.getId())) {
            this.questions.add(item);
        }

    }

    /**
     *
     * @return
     */
    public long questionCount() {
        return this.questions.size();
    }

    /**
     * @return the courseID
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * @param courseID the courseID to set
     */
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    /**
     * @return the studentsAnswers
     */
    public HashMap<String, StudentAnswers> getStudentsAnswers() {
        return studentsAnswers;
    }

    /**
     * @param studentsAnswers the studentsAnswers to set
     */
    public void setStudentsAnswers(HashMap<String, StudentAnswers> studentsAnswers) {
        this.studentsAnswers = studentsAnswers;
    }

    /**
     *
     * @return
     */
    public double calculateResults() {
        double correct = 0;
        double totalQuestions = studentsAnswers.size();

        for (String CorrectAnswer : studentsAnswers.keySet()) {
            if (CorrectAnswer.equals(studentsAnswers.get(CorrectAnswer))) {
                correct++;
            }
        }

        double score = (correct / totalQuestions) * 100;
        return score;
    }
}
