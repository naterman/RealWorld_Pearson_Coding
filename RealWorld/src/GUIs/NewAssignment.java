/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import Design.Colors;
import GUIs.NewAssignmentAssets.QuestionBar;
import com.firebase.client.AuthData;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.security.token.TokenGenerator;
import firebase.FullAssignmentData;
import firebase.Question;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.UUID;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.SwingXUtilities;
import org.jdesktop.swingx.painter.MattePainter;

/**
 *
 * @author Nathan Smith
 */
public class NewAssignment extends JXPanel {

    /**
     * Creates new form NewAssignment
     */
    FullAssignmentData fullAssignment;
    HashMap<String, Question> questions = new HashMap<>();
    HashMap<String, QuestionBar> bars = new HashMap<>();
    String currentQuestionID = "";
    int currentQuestionNumber = 0;

    /**
     *
     * @param f
     * @param isItNew
     */
    public NewAssignment(FullAssignmentData f, boolean isItNew) {
        this.fullAssignment = f;
        initComponents();

        if (fullAssignment.getAssignment().isEnable()) {
            enableCheckBox.setSelected(true);
        }

        questionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (isItNew == false) {
            createButton.setText("Update");
            createButton.repaint();
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
                            answerTextBox.setText(newQuestion.getAnswer());
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
        }

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
        enableCheckBox = new javax.swing.JCheckBox();
        saveButton = new org.jdesktop.swingx.JXButton();
        deleteButton = new org.jdesktop.swingx.JXButton();
        save_newButton = new org.jdesktop.swingx.JXButton();
        cancelButton = new org.jdesktop.swingx.JXButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        questionPanel = new org.jdesktop.swingx.JXPanel();
        createButton = new org.jdesktop.swingx.JXButton();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();

        scenarioTextBox.setBorder(null);
        scenarioTextBox.setColumns(20);
        scenarioTextBox.setLineWrap(true);
        scenarioTextBox.setRows(5);
        scenarioTextBox.setText("Add New Scenario");
        scenarioTextBox.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        jScrollPane1.setViewportView(scenarioTextBox);

        questionTextBox.setBorder(null);
        questionTextBox.setColumns(20);
        questionTextBox.setLineWrap(true);
        questionTextBox.setRows(5);
        questionTextBox.setText("Add New Question");
        questionTextBox.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jScrollPane2.setViewportView(questionTextBox);

        answerTextBox.setText("Answer");
        answerTextBox.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N

        enableCheckBox.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        enableCheckBox.setText("Enable?");
        enableCheckBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

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

        deleteButton.setBackground(Colors.Red.color());
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/TrashCan.png"))); // NOI18N
        deleteButton.setText("   Delete");
        deleteButton.setToolTipText("");
        deleteButton.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        save_newButton.setBackground(Colors.ButtonColorOrange.color());
        save_newButton.setForeground(new java.awt.Color(255, 255, 255));
        save_newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/saveNewIcon.png"))); // NOI18N
        save_newButton.setText("   Save/New");
        save_newButton.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        save_newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_newButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(Colors.Black.color());
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancelIcon.png"))); // NOI18N
        cancelButton.setText(" Cancel");
        cancelButton.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        questionPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout questionPanelLayout = new javax.swing.GroupLayout(questionPanel);
        questionPanel.setLayout(questionPanelLayout);
        questionPanelLayout.setHorizontalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );
        questionPanelLayout.setVerticalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(questionPanel);

        createButton.setBackground(Colors.ButtonGreen.color());
        createButton.setForeground(new java.awt.Color(255, 255, 255));
        createButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/createIcon.png"))); // NOI18N
        createButton.setText(" Create");
        createButton.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        jXLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/TeacherEditHeader.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(answerTextBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(save_newButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enableCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(answerTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(save_newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enableCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        if (currentQuestionID == "") {
            saveNewQuestion();

        } else {
            saveCurrentQuestion();
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void save_newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_newButtonActionPerformed
        if (currentQuestionID == "") {
            saveNewQuestion();
        } else {
            saveCurrentQuestion();
        }

        currentQuestionID = "";
        questionTextBox.setText("");
        answerTextBox.setText("");
    }//GEN-LAST:event_save_newButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
       
        JOptionPane.showMessageDialog(scenarioTextBox, "Not Implemented Yet");
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        final JXFrame mainFrame = SwingXUtilities.getAncestor(JXFrame.class, this);

        if (currentQuestionID == "" && !questionTextBox.getText().equals("")) {
            saveNewQuestion();
        } else if (!questionTextBox.getText().equals("")) {
            saveCurrentQuestion();
        }

        fullAssignment.getAssignment().setEnable(enableCheckBox.isSelected());

        final Firebase ref = new Firebase("https://glowing-inferno-9149.firebaseio.com/RealWorld");
        UUID id = UUID.randomUUID();
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("uid", id.toString());

        TokenGenerator tokenGenerator = new TokenGenerator("5o0SAwAWTiOLYdfoLXKgqRATnYWQzIqmV9fuqDNq");
        String token = tokenGenerator.createToken(payload);
        ref.authWithCustomToken(token, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticationError(FirebaseError error) {
                System.err.println("Login Failed! " + error.getMessage());
            }

            @Override
            public void onAuthenticated(AuthData authData) {

                Firebase assignmentsRef = ref.child(fullAssignment.getCourseID()).child("Assignments").child(fullAssignment.getAssignment().getId());
                assignmentsRef.setValue(fullAssignment.getAssignment());

                for (Question question : questions.values()) {
                    Firebase questionRef = ref.child(fullAssignment.getCourseID()).child("Data").child("Questions").child(question.getId());
                    questionRef.setValue(question);
                }

                mainFrame.dispose();

            }
        });
    }//GEN-LAST:event_createButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel?", "Confirm Cancel", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            JXFrame mainFrame = SwingXUtilities.getAncestor(JXFrame.class, this);
            mainFrame.dispose();
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void questionBarClicked(MouseEvent evt, String ID) {

        if (currentQuestionID == "" && !questionTextBox.getText().equals("")) {
            saveNewQuestion();
        } else if (!questionTextBox.getText().equals("")) {
            saveCurrentQuestion();
        }

        try {
            currentQuestionID = ID;
            questionTextBox.setText(questions.get(ID).getQuestion());
            answerTextBox.setText(questions.get(ID).getAnswer());
            scenarioTextBox.setText(questions.get(ID).getScenario());
        }
        catch (NullPointerException nex)
        {
            JOptionPane.showMessageDialog(scenarioTextBox, "That Question No Longer Exists");
            currentQuestionID = "";
        }
        

    }

    /**
     *
     * Called to save a new question
     *
     */
    public void saveNewQuestion() {

        currentQuestionNumber++;

        Question newQuestion = new Question();
        newQuestion.setQuestion(questionTextBox.getText());
        newQuestion.setAnswer(answerTextBox.getText());
        currentQuestionID = UUID.randomUUID().toString();
        newQuestion.setId(currentQuestionID);
        newQuestion.setLinktoid(fullAssignment.getAssignment().getId());
        newQuestion.setScenario(scenarioTextBox.getText());
        newQuestion.setNumber(currentQuestionNumber);
        newQuestion.setScenario(scenarioTextBox.getText());
        questions.put(currentQuestionID, newQuestion);
        QuestionBar newBar = new QuestionBar(String.valueOf(currentQuestionNumber));
        final String ID = currentQuestionID;
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

    }

    /**
     *
     * called to save a currently selected question
     *
     */
    public void saveCurrentQuestion() {
        Question cQuestion = questions.get(currentQuestionID);
        cQuestion.setAnswer(answerTextBox.getText());
        cQuestion.setQuestion(questionTextBox.getText());
        cQuestion.setScenario(scenarioTextBox.getText());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXTextField answerTextBox;
    private org.jdesktop.swingx.JXButton cancelButton;
    private org.jdesktop.swingx.JXButton createButton;
    private org.jdesktop.swingx.JXButton deleteButton;
    private javax.swing.JCheckBox enableCheckBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXPanel questionPanel;
    private org.jdesktop.swingx.JXTextArea questionTextBox;
    private org.jdesktop.swingx.JXButton saveButton;
    private org.jdesktop.swingx.JXButton save_newButton;
    private org.jdesktop.swingx.JXTextArea scenarioTextBox;
    // End of variables declaration//GEN-END:variables
}
