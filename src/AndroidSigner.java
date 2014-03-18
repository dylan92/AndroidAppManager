
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

// Android App Manager
// Dylan Yates

// Runs the commands to sign an Android app
public class AndroidSigner {

    private static Process cmd;
    private static InputStream cmdInput;
    private static PrintStream cmdOutput;
    private Preferences prefs;
    private APK apk;

    // Constructor requires the Preferences class and an Android APK
    public AndroidSigner(Preferences p, APK a) {
        prefs = p;
        apk = a;
    }

    // Attempts to install the APK file
    // Returns a string of either a detailed error message or that the app was installed successfully
    public String Sign() {

        System.out.print("Looking for JDK...");
        File jdk = new File(prefs.jdkPath);
        if (jdk.exists()) {
            System.out.println(" found JDK!\n");
        } else {
            System.out.println("Error finding JDK.  Make sure the path is correct.");
            return "ERROR:  Could not find JDK.  Make sure the path is correct.\n";
        }

        System.out.print("Looking for keystore...");
        File keystore = new File(prefs.keyStorePath);
        if (keystore.exists()) {
            System.out.println(" found keystore!\n");
        } else {
            System.out.println("Error finding keystore.  Make sure the path is correct.");
            return "ERROR:  Could not find keystore.  Make sure the path is correct.\n";
        }
        System.out.print("Looking for APK file...");
        File apkFile = new File(apk.path);
        if (apkFile.exists()) {
            System.out.println(" found " + apk.name);
        } else {
            System.out.println("Error finding file.  Make sure the .apk file is in the designated folder.");
            return "ERROR:  Could not find .apk file.  Make sure the .apk file is in the designated folder.\n";
        }
        try {
            cmd = Runtime.getRuntime().exec("cmd");
        } catch (IOException ex) {
            Logger.getLogger(AndroidSigner.class.getName()).log(Level.SEVERE, null, ex);
        }
        cmdInput = new BufferedInputStream(cmd.getInputStream());
        cmdOutput = new PrintStream(new BufferedOutputStream(cmd.getOutputStream()));
        Thread display = new Thread(new StreamHandler(cmdInput, ""));
        display.setDaemon(true);
        display.start();
        try {
            // Commands for signing an app
            runWndCommand("cd /");
            runWndCommand("cd " + jdk.getPath() + "\\bin\\");
            runWndCommand("jarsigner.exe -verbose -keystore \"" + keystore.getAbsolutePath() + "\"" + " \"" + apkFile.getAbsolutePath() + "\" " + prefs.keyStorePassword);
            runWndCommand(prefs.keyAlias);
            runWndCommand(prefs.keyPassword);
            runWndCommand("exit");
            cmdOutput.close();
            cmd.waitFor();
            System.out.println("\nApp Successfully Signed!");
            return apk.name + " successfully signed!\n";

        } catch (IOException ex) {
            Logger.getLogger(AndroidSigner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(AndroidSigner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "App signing failed.\n";
    }

    // Function to run a command line command
    public void runWndCommand(String cmd) throws IOException, InterruptedException {
        cmdOutput.println(cmd);
        cmdOutput.flush();
    }
}
