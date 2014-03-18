
import java.io.File;
import java.util.ArrayList;
import javax.swing.UIManager;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;

// Android App Manager
// Dylan Yates

// GUI for the main window of the program
public class MainGUI extends javax.swing.JFrame {

    public Preferences prefs;
    private PreferencesGUI prefsWindow;
    private HelpGUI helpWindow;
    private ArrayList<APK> APKfiles = new ArrayList<APK>();

    public MainGUI() {
        prefs = new Preferences();
        initComponents();
        helpWindow = new HelpGUI(this, rootPaneCheckingEnabled, this);
        if (prefs.Load() == false) {
            prefsWindow = new PreferencesGUI(this, rootPaneCheckingEnabled, this, true);
            prefsWindow.display();
            helpWindow.display();
        } else {
            prefsWindow = new PreferencesGUI(this, rootPaneCheckingEnabled, this, false);
        }
        getAPKs();
    }

    // Gets a list of .apk files in the "APK Files" folder
    private void getAPKs() {
        APKfiles.clear();
        File apks = new File("APK Files");
        if (apks.exists() == false) {
            apks.mkdir();
        }
        
        for (File apk : apks.listFiles()) {
            if (apk.isFile() && apk.getName().substring(apk.getName().lastIndexOf(".")).equalsIgnoreCase(".apk")) {
                APK a = new APK(apk);
                APKfiles.add(a);
            }
        }
        UpdateList();
    }

    // Updates the JList with all of the APK files
    public void UpdateList() {
        ArrayList<String> listdata = new ArrayList<String>();
        for (APK a : APKfiles) {
            listdata.add(a.toString());
        }
        AppList.setListData(listdata.toArray());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonPanel = new javax.swing.JPanel();
        SignButton = new javax.swing.JButton();
        AlignButton = new javax.swing.JButton();
        InstallButton = new javax.swing.JButton();
        PrefsPanel = new javax.swing.JPanel();
        PreferencesButton = new javax.swing.JButton();
        SpacePanel = new javax.swing.JPanel();
        HelpPanel = new javax.swing.JPanel();
        HelpButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ListPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AppList = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        ConsoleOutput = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Android App Manager");
        setMinimumSize(new java.awt.Dimension(400, 300));
        setPreferredSize(new java.awt.Dimension(640, 480));
        getContentPane().setLayout(new java.awt.BorderLayout(10, 10));

        ButtonPanel.setMinimumSize(new java.awt.Dimension(309, 80));
        ButtonPanel.setPreferredSize(new java.awt.Dimension(309, 80));
        ButtonPanel.setLayout(new java.awt.GridLayout(2, 3, 30, 5));

        SignButton.setText("Sign App");
        SignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignButtonActionPerformed(evt);
            }
        });
        ButtonPanel.add(SignButton);

        AlignButton.setText("Align App");
        AlignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlignButtonActionPerformed(evt);
            }
        });
        ButtonPanel.add(AlignButton);

        InstallButton.setText("Install App");
        InstallButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstallButtonActionPerformed(evt);
            }
        });
        ButtonPanel.add(InstallButton);

        PreferencesButton.setText("Preferences...");
        PreferencesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreferencesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PrefsPanelLayout = new javax.swing.GroupLayout(PrefsPanel);
        PrefsPanel.setLayout(PrefsPanelLayout);
        PrefsPanelLayout.setHorizontalGroup(
            PrefsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrefsPanelLayout.createSequentialGroup()
                .addComponent(PreferencesButton)
                .addGap(0, 85, Short.MAX_VALUE))
        );
        PrefsPanelLayout.setVerticalGroup(
            PrefsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PrefsPanelLayout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(PreferencesButton))
        );

        ButtonPanel.add(PrefsPanel);

        javax.swing.GroupLayout SpacePanelLayout = new javax.swing.GroupLayout(SpacePanel);
        SpacePanel.setLayout(SpacePanelLayout);
        SpacePanelLayout.setHorizontalGroup(
            SpacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );
        SpacePanelLayout.setVerticalGroup(
            SpacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        ButtonPanel.add(SpacePanel);

        HelpButton.setText("Help...");
        HelpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HelpPanelLayout = new javax.swing.GroupLayout(HelpPanel);
        HelpPanel.setLayout(HelpPanelLayout);
        HelpPanelLayout.setHorizontalGroup(
            HelpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HelpPanelLayout.createSequentialGroup()
                .addGap(0, 123, Short.MAX_VALUE)
                .addComponent(HelpButton))
        );
        HelpPanelLayout.setVerticalGroup(
            HelpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HelpPanelLayout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(HelpButton))
        );

        ButtonPanel.add(HelpPanel);

        getContentPane().add(ButtonPanel, java.awt.BorderLayout.PAGE_END);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("APK List");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Console Output");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 471, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        ListPanel.setLayout(new java.awt.GridLayout(1, 0, 30, 0));

        AppList.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        AppList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        AppList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        AppList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AppListMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AppListMousePressed(evt);
            }
        });
        AppList.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                AppListFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(AppList);

        ListPanel.add(jScrollPane1);

        ConsoleOutput.setEditable(false);
        jScrollPane3.setViewportView(ConsoleOutput);

        ListPanel.add(jScrollPane3);

        getContentPane().add(ListPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Attempts to sign the selected app
    private void SignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignButtonActionPerformed
        if (AppList.getSelectedIndex() > -1) {
            AndroidSigner s = new AndroidSigner(prefs, APKfiles.get(AppList.getSelectedIndex()));
            ConsoleOutput.setText(ConsoleOutput.getText() + "Signing " + APKfiles.get(AppList.getSelectedIndex()).name + "...\n");
            ConsoleOutput.update(ConsoleOutput.getGraphics());
            ConsoleOutput.setText(ConsoleOutput.getText() + s.Sign() + "\n");
        }

    }//GEN-LAST:event_SignButtonActionPerformed

    // Attempts to align the selected app
    private void AlignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlignButtonActionPerformed
        if (AppList.getSelectedIndex() > -1) {
            AndroidAligner a = new AndroidAligner(prefs, APKfiles.get(AppList.getSelectedIndex()));
            ConsoleOutput.setText(ConsoleOutput.getText() + "Aligning " + APKfiles.get(AppList.getSelectedIndex()).name + "...\n");
            ConsoleOutput.update(ConsoleOutput.getGraphics());
            ConsoleOutput.setText(ConsoleOutput.getText() + a.Align() + "\n");
        }
    }//GEN-LAST:event_AlignButtonActionPerformed

    // Attempts to install the selected app
    private void InstallButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstallButtonActionPerformed
        if (AppList.getSelectedIndex() > -1) {
            AndroidInstaller i = new AndroidInstaller(prefs, APKfiles.get(AppList.getSelectedIndex()));
            ConsoleOutput.setText(ConsoleOutput.getText() + "Installing " + APKfiles.get(AppList.getSelectedIndex()).name + "...\n");
            ConsoleOutput.update(ConsoleOutput.getGraphics());
            String output = i.Install();
    
            ConsoleOutput.setText(ConsoleOutput.getText() + output + "\n");

        }
    }//GEN-LAST:event_InstallButtonActionPerformed

    // Displays the preferences window
    private void PreferencesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreferencesButtonActionPerformed
        prefsWindow.display();
    }//GEN-LAST:event_PreferencesButtonActionPerformed

    // Displays the help window
    private void HelpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpButtonActionPerformed
        helpWindow.display();
    }//GEN-LAST:event_HelpButtonActionPerformed

    private void AppListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AppListMouseClicked

    }//GEN-LAST:event_AppListMouseClicked

    private void AppListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AppListMousePressed

    }//GEN-LAST:event_AppListMousePressed

    // Updates the list of APKs when the user clicks on the App List
    private void AppListFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AppListFocusGained
        int selectedIndex = -1;
        if (AppList.getSelectedIndex() > -1) {
            selectedIndex = AppList.getSelectedIndex();
        }
        getAPKs();
        AppList.setSelectedIndex(selectedIndex);
    }//GEN-LAST:event_AppListFocusGained

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainGUI main = new MainGUI();
                main.setLocationRelativeTo(null);
                main.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AlignButton;
    private javax.swing.JList AppList;
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JTextPane ConsoleOutput;
    private javax.swing.JButton HelpButton;
    private javax.swing.JPanel HelpPanel;
    private javax.swing.JButton InstallButton;
    private javax.swing.JPanel ListPanel;
    private javax.swing.JButton PreferencesButton;
    private javax.swing.JPanel PrefsPanel;
    private javax.swing.JButton SignButton;
    private javax.swing.JPanel SpacePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
