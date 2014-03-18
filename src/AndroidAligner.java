
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

// Runs the commands to align an Android app
public class AndroidAligner {

    private static Process cmd;
    private static InputStream cmdInput;
    private static PrintStream cmdOutput;
    private Preferences prefs;
    private APK apk;

    // Constructor requires the Preferences class and an Android APK
    public AndroidAligner(Preferences p, APK a) {
        prefs = p;
        apk = a;
    }

    // Attempts to align the APK file
    // Returns a string of either a detailed error message or that the app was aligned successfully
    public String Align() {
        try {
            // Make sure the SDK is installed
            System.out.print("Looking for Android SDK...");
            File sdk = new File(prefs.sdkPath);
            if (sdk.exists()) {
                System.out.println(" found Android SDK!\n");
            } else {
                System.out.println("Error finding Android SDK.  Make sure the path is correct.");
                return "ERROR:  Unable to find Android SDK.  Make sure the path is correct.\n";
            }
            try {
                cmd = Runtime.getRuntime().exec("cmd");
            } catch (IOException ex) {
                Logger.getLogger(AndroidAligner.class.getName()).log(Level.SEVERE, null, ex);
            }
            cmdInput = new BufferedInputStream(cmd.getInputStream());
            cmdOutput = new PrintStream(new BufferedOutputStream(cmd.getOutputStream()));
            Thread display = new Thread(new StreamHandler(cmdInput, ""));
            display.setDaemon(true);
            display.start();
            
            String alignedFile = apk.path.replace(".apk", "Aligned.apk");
            
            // Commands for aligning an app
            runWndCommand("cd /");
            runWndCommand("cd " + sdk.getAbsolutePath() + "\\tools\\");
            runWndCommand("zipalign -v 4" + " \"" + apk.path + "\"" + " \"" + alignedFile + "\"");
            runWndCommand(prefs.keyAlias);
            runWndCommand(prefs.keyPassword);
            runWndCommand("exit");
            cmdOutput.close();
            cmd.waitFor();
            
            // Overwrites the existing APK file with this new one
            File oldAPK = new File(apk.path);
            oldAPK.delete();
            File newAPK = new File(alignedFile);
            newAPK.renameTo(new File(apk.path));
            
            System.out.println("\nApp Successfully Aligned!");
            return apk.name + " successfully aligned!\n";
        } catch (IOException ex) {
            Logger.getLogger(AndroidAligner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(AndroidAligner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "App aligning failed.\n";
    }

    // Function to run a command line command
    public void runWndCommand(String cmd) throws IOException, InterruptedException {
        cmdOutput.println(cmd);
        cmdOutput.flush();
    }
}
