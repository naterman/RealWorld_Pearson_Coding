/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import Design.Colors;
import GUIs.NewAssignmentAssets.QuestionBar;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import firebase.FullAssignmentData;
import firebase.Question;
import firebase.StudentAnswers;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.SwingXUtilities;
import org.jdesktop.swingx.painter.MattePainter;

/**
 *
 * @author Nathan Smith
 */
public class StudentAssignmentPanel extends JXPanel {

    /**
     * Creates new form NewAssignment
     */
    FullAssignmentData fullAssignment;
    HashMap<String, Question> questions = new HashMap<>();
    HashMap<String, QuestionBar> bars = new HashMap<>();
    HashMap<String, StudentAnswers> studentAnswers = new HashMap<>();
    String currentQuestionID = null;
    int currentQuestionNumber = 0;

    /**
     *
     * @param f
     */
    public StudentAssignmentPanel(FullAssignmentData f) {
        this.fullAssignment = f;
        fullAssignment.setStudentsAnswers(studentAnswers);
        initComponents();

        questionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        final Firebase ref = new Firebase("https://glowing-inferno-9149.firebaseio.com/RealWorld/" + fullAssignment.getCourseID() + "/Data/Questions");
        Query queryRef = ref.orderByChild("questionnumber");
        queryRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
                Question newQuestion = snapshot.getValue(Question.class);
                if (newQuestion.getLinktoid().equals(fullAssignment.getAssignment().getId())) {
                    questions.put(newQuestion.getId(), newQuestion);
                    currentQuestionNumber++;

                    QuestionBar newBar = new QuestionBar(String.valueOf(newQuestion.getNumber()));
                    final String ID = newQuestion.getId();
                    newBar.addMouseListener(new MouseListener() {

                        @Override
                        public void mouseClicked(MouseEvent e) {
                            questionBarClicked(e, ID);
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
                            //not needed
                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {
                            //not needed
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
                            //not needed
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            //not needed                
                        }
                    });
                    bars.put(currentQuestionID, newBar);

                    questionPanel.add(newBar);
                    questionPanel.revalidate();
                    questionPanel.repaint();
                    if (newQuestion.getNumber() == 1) {
                        currentQuestionID = newQuestion.getId();
                        questionTextBox.setText(newQuestion.getQuestion());
                        scenarioTextBox.setText(newQuestion.getScenario());
                    }
                }
            }

            @Override
            public void onChildChanged(DataSnapshot snapshot, String previousChildName) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onChildRemoved(DataSnapshot snapshot) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onChildMoved(DataSnapshot snapshot, String previousChildName) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onCancelled(FirebaseError error) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        MattePainter backPaint = new MattePainter(Colors.BackgroundGray.color());
        this.setBackgroundPainter(backPaint);
        this.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        scenarioTextBox = new org.jdesktop.swingx.JXTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        questionTextBox = new org.jdesktop.swingx.JXTextArea();
        answerTextBox = new org.jdesktop.swingx.JXTextField();
        saveButton = new org.jdesktop.swingx.JXButton();
        dictionaryButton = new org.jdesktop.swingx.JXButton();
        cancelButton = new org.jdesktop.swingx.JXButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        questionPanel = new org.jdesktop.swingx.JXPanel();
        submitButton = new org.jdesktop.swingx.JXButton();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();

        scenarioTextBox.setEditable(false);
        scenarioTextBox.setBorder(null);
        scenarioTextBox.setColumns(20);
        scenarioTextBox.setLineWrap(true);
        scenarioTextBox.setRows(5);
        scenarioTextBox.setText("Add New Scenario");
        scenarioTextBox.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        jScrollPane1.setViewportView(scenarioTextBox);

        questionTextBox.setEditable(false);
        questionTextBox.setBorder(null);
        questionTextBox.setColumns(20);
        questionTextBox.setLineWrap(true);
        questionTextBox.setRows(5);
        questionTextBox.setText("Add New Question");
        questionTextBox.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jScrollPane2.setViewportView(questionTextBox);

        answerTextBox.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N

        saveButton.setBackground(Colors.ButtonGreen.color());
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/saveIcon.png"))); // NOI18N
        saveButton.setText("   Save");
        saveButton.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        dictionaryButton.setBackground(Colors.ButtonColorOrange.color());
        dictionaryButton.setForeground(new java.awt.Color(255, 255, 255));
        dictionaryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dictionaryIcon.png"))); // NOI18N
        dictionaryButton.setText("   Dictionary");
        dictionaryButton.setToolTipText("");
        dictionaryButton.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        dictionaryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dictionaryButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(Colors.Black.color());
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancelIcon.png"))); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        questionPanel.setBackground(new java.awt.Color(255, 255, 255));
        questionPanel.setPreferredSize(new java.awt.Dimension(265, 518));

        javax.swing.GroupLayout questionPanelLayout = new javax.swing.GroupLayout(questionPanel);
        questionPanel.setLayout(questionPanelLayout);
        questionPanelLayout.setHorizontalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );
        questionPanelLayout.setVerticalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(questionPanel);

        submitButton.setBackground(Colors.ButtonColorOrange.color());
        submitButton.setForeground(new java.awt.Color(255, 255, 255));
        submitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/submitIcon.png"))); // NOI18N
        submitButton.setText("Submit");
        submitButton.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        jXLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/studentheading.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dictionaryButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(answerTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(answerTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dictionaryButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        saveCurrentQuestion();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        JXFrame mainFrame = SwingXUtilities.getAncestor(JXFrame.class, this);
        saveCurrentQuestion();

        String message = "Are you sure you want to submit? ";

        if (studentAnswers.size() != questions.size()) {
            message = message + "all the questions have not been answered!";
        }

        int confirm = JOptionPane.showConfirmDialog(mainFrame, message, "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            double results = fullAssignment.calculateResults();
            JOptionPane.showMessageDialog(mainFrame, "Score: " + String.format("%.2f", results));
            mainFrame.dispose();
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel? (All Progress will be lost)", "Confirm Cancel", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            JXFrame mainFrame = SwingXUtilities.getAncestor(JXFrame.class, this);
            mainFrame.dispose();
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void dictionaryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dictionaryButtonActionPerformed

        JXFrame dFrame = new JXFrame();
        dFrame.add(new DictionaryPanel());
        dFrame.setStartPosition(JXFrame.StartPosition.CenterInScreen);
        dFrame.setDefaultCloseOperation(JXFrame.DISPOSE_ON_CLOSE);

        dFrame.setSize(800, 500);
        dFrame.setVisible(true);

    }//GEN-LAST:event_dictionaryButtonActionPerformed

    private void questionBarClicked(MouseEvent evt, String ID) {

        saveCurrentQuestion();

        currentQuestionID = ID;
        questionTextBox.setText(questions.get(ID).getQuestion());
        scenarioTextBox.setText(questions.get(ID).getScenario());
        if (studentAnswers.containsKey(ID)) {
            answerTextBox.setText(studentAnswers.get(ID).getStudentAnswer());
        } else {
            answerTextBox.setText("");
        }
    }

    /**
     *
     * called to save a currently selected question
     *
     */
    public void saveCurrentQuestion() {
        Question cQuestion = questions.get(currentQuestionID);
        studentAnswers.put(currentQuestionID, new StudentAnswers(cQuestion.getAnswer(), answerTextBox.getText()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXTextField answerTextBox;
    private org.jdesktop.swingx.JXButton cancelButton;
    private org.jdesktop.swingx.JXButton dictionaryButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXPanel questionPanel;
    private org.jdesktop.swingx.JXTextArea questionTextBox;
    private org.jdesktop.swingx.JXButton saveButton;
    private org.jdesktop.swingx.JXTextArea scenarioTextBox;
    private org.jdesktop.swingx.JXButton submitButton;
    // End of variables declaration//GEN-END:variables
}
