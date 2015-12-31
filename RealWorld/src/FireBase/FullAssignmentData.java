/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FireBase;

import java.util.LinkedList;

/**
 *
 * @author Nathan Smith
 */
public class FullAssignmentData {
    
    Assignment assignment;
    LinkedList<Question> questions = new LinkedList<>();
    LinkedList<Trigger> triggers = new LinkedList<>();
    
    /**
     *
     * @param a
     */
    public FullAssignmentData(Assignment a)
    {
        this.assignment = a;
    }
    
    /**
     *
     * @return
     */
    public Assignment getAssignment()
    {
        return assignment;
    }

    /**
     *
     * @param a
     */
    public void setAssignment(Assignment a)
    {
        this.assignment = a;
    }
    
    /**
     *
     * @return
     */
    public LinkedList<Question> geQuestions()
    {
        return this.questions;
    }
    
    /**
     *
     * @param i
     * @return
     */
    public Question getOneQuestions(int i)
    {
        return this.questions.get(i);
    }
    
    /**
     *
     * @param newQuestions
     */
    public void addAllQuestions(LinkedList<Question> newQuestions)
    {
        this.questions = newQuestions;
    }
    
    /**
     *
     * @param item
     */
    public void addOneQuestion(Question item)
    {
        this.questions.add(item);
    }
    
    /**
     *
     * @return
     */
    public LinkedList<Trigger> getAllTriggers()
    {
        return this.triggers;
    }
    
    /**
     *
     * @param i
     * @return
     */
    public Trigger getOneTrigger(int i)
    {
        return this.triggers.get(i);
    }
    
    /**
     *
     * @param newTriggers
     */
    public void setAllTriggers(LinkedList<Trigger> newTriggers)
    {
        this.triggers = newTriggers;
    }
    
    /**
     *
     * @param newTrigger
     */
    public void addOneTrigger(Trigger newTrigger)
    {
        this.triggers.add(newTrigger);
                
    }
}
