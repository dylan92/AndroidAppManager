
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

// Android App Manager
// Dylan Yates

// GUI for the preferences window
public class PreferencesGUI extends javax.swing.JDialog {

    public MainGUI gui;
    private boolean onStartup = false;

    public PreferencesGUI(java.awt.Frame parent, boolean modal, MainGUI g, boolean onStart) {
        super(parent, modal);
        gui = g;
        initComponents();
        populateTextFields();
    }
    
    // Sets JTextField text with data from the preferences class
    private void populateTextFields() {
        JDKTextField.setText(gui.prefs.jdkPath);
        SDKTextField.setText(gui.prefs.sdkPath);
        KeyStoreTextField.setText(gui.prefs.keyStorePath);
        KeyStorePasswordTextField.setText(gui.prefs.keyStorePassword);
        KeyAliasTextField.setText(gui.prefs.keyAlias);
        KeyPasswordTextField.setText(gui.prefs.keyPassword);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDKFolderChooser = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        ButtonPanel = new javax.swing.JPanel();
        CancelButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        TextFieldPanel = new javax.swing.JPanel();
        JDKTextField = new javax.swing.JTextField();
        SDKTextField = new javax.swing.JTextField();
        KeyStoreTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        KeyStorePasswordTextField = new javax.swing.JTextField();
        KeyAliasTextField = new javax.swing.JTextField();
        KeyPasswordTextField = new javax.swing.JTextField();
        SDKPathButton = new javax.swing.JButton();
        JDKPathButton = new javax.swing.JButton();
        KeyStorePathButton = new javax.swing.JButton();

        JDKFolderChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Preferences");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Preferences");

        ButtonPanel.setLayout(new java.awt.GridLayout(1, 0, 100, 0));

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });
        ButtonPanel.add(CancelButton);

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        ButtonPanel.add(SaveButton);

        jLabel2.setText("JDK Path");

        jLabel3.setText("Android SDK Path");

        jLabel4.setText("KeyStore Path");

        jLabel5.setText("KeyStore Password");

        jLabel6.setText("Key Alias");

        jLabel7.setText("Key Password");

        SDKPathButton.setText("...");
        SDKPathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SDKPathButtonActionPerformed(evt);
            }
        });

        JDKPathButton.setText("...");
        JDKPathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JDKPathButtonActionPerformed(evt);
            }
        });

        KeyStorePathButton.setText("...");
        KeyStorePathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeyStorePathButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TextFieldPanelLayout = new javax.swing.GroupLayout(TextFieldPanel);
        TextFieldPanel.setLayout(TextFieldPanelLayout);
        TextFieldPanelLayout.setHorizontalGroup(
            TextFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TextFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TextFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(KeyStoreTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SDKTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KeyAliasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KeyPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JDKTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KeyStorePasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TextFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SDKPathButton)
                    .addComponent(JDKPathButton)
                    .addComponent(KeyStorePathButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TextFieldPanelLayout.setVerticalGroup(
            TextFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanelLayout.createSequentialGroup()
                .addGroup(TextFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JDKTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(JDKPathButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TextFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SDKTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(SDKPathButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TextFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KeyStoreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(KeyStorePathButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TextFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KeyStorePasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TextFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KeyAliasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TextFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(KeyPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(TextFieldPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(TextFieldPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Closes the window
    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_CancelButtonActionPerformed

    // Gets data from text fields and saves the data to a text file
    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        if (JDKTextField.getText().length() > 0 && SDKTextField.getText().length() > 0 &&
                KeyStoreTextField.getText().length() > 0 && KeyStorePasswordTextField.getText().length() > 0
                && KeyAliasTextField.getText().length() > 0 && KeyPasswordTextField.getText().length() > 0) {
            gui.prefs.keyStorePassword = KeyStorePasswordTextField.getText();
            gui.prefs.keyAlias = KeyAliasTextField.getText();
            gui.prefs.keyPassword = KeyPasswordTextField.getText();
            try {
                gui.prefs.Save();
            } catch (IOException ex) {
                Logger.getLogger(PreferencesGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    // Opens a file chooser to locate the JDK
    private void JDKPathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JDKPathButtonActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            gui.prefs.jdkPath = f.getPath();
            JDKTextField.setText(f.getPath());
        }
    }//GEN-LAST:event_JDKPathButtonActionPerformed

    // Opens a file choose to locate the Android SDK
    private void SDKPathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SDKPathButtonActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            gui.prefs.sdkPath = f.getPath();
            SDKTextField.setText(f.getPath());
        }
    }//GEN-LAST:event_SDKPathButtonActionPerformed

    // Opens a file chooser to locate the keystore
    private void KeyStorePathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeyStorePathButtonActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            gui.prefs.keyStorePath = f.getPath();
            KeyStoreTextField.setText(f.getPath());
        }
    }//GEN-LAST:event_KeyStorePathButtonActionPerformed

    public void display() {
        try {
            UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PreferencesGUI dialog = new PreferencesGUI(new javax.swing.JFrame(), true, gui, onStartup);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        
                    }
                });
                dialog.pack();
                dialog.setLocationRelativeTo(gui);
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JButton CancelButton;
    private javax.swing.JFileChooser JDKFolderChooser;
    private javax.swing.JButton JDKPathButton;
    private javax.swing.JTextField JDKTextField;
    private javax.swing.JTextField KeyAliasTextField;
    private javax.swing.JTextField KeyPasswordTextField;
    private javax.swing.JTextField KeyStorePasswordTextField;
    private javax.swing.JButton KeyStorePathButton;
    private javax.swing.JTextField KeyStoreTextField;
    private javax.swing.JButton SDKPathButton;
    private javax.swing.JTextField SDKTextField;
    private javax.swing.JButton SaveButton;
    private javax.swing.JPanel TextFieldPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
