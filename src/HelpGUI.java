
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import java.awt.Desktop;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.UIManager;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

// Android App Manager
// Dylan Yates

// GUI for the help window
public class HelpGUI extends javax.swing.JDialog {

    public MainGUI gui;

    public HelpGUI(java.awt.Frame parent, boolean modal, MainGUI g) {
        super(parent, modal);
        gui = g;
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        HelpPane = new javax.swing.JTextPane();
        CloseButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Android App Manager Quick Start Guide");

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        HelpPane.setEditable(false);
        HelpPane.setContentType("text/html");
        HelpPane.setText("<html><body><b>Prerequisites:</b><br>\n<ul>\n<li>Install the Java Development Kit</li>\n<li>Install the Android SDK</li>\n<li>Generate a keystore for your developer account</li>\n<li>Develop an Android app</li>\n</ul><br>\n<b>How to use the Android App Manager:</b><br>\n<ul>\n<li>Fill in the appropriate information in the Preferences window</li>\n<li>Place your apps in the “APK Files” folder</li>\n<li>Select an app and select the “Sign” button</li>\n<li>Once the app is signed, select the “Align” button</li>\n<li>Upload your app to Google Play or install it to your device with<br>the “Install” button</li>\n</ul></body>\n</html>");
        jScrollPane1.setViewportView(HelpPane);

        CloseButton.setText("Close");
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(CloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CloseButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_CloseButtonActionPerformed

    public void display() {
        try {
            UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HelpGUI dialog = new HelpGUI(new javax.swing.JFrame(), true, gui);
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
    private javax.swing.JButton CloseButton;
    private javax.swing.JTextPane HelpPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
