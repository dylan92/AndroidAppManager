
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

// Runs the commands to install an Android app to an Android device
public class AndroidInstaller {

    private static Process cmd;
    private static InputStream cmdInput;
    private static PrintStream cmdOutput;

    private Preferences prefs;
    private APK apk;

    // Constructor requires the Preferences class and an Android APK
    public AndroidInstaller(Preferences p, APK a) {
        prefs = p;
        apk = a;
    }

    // Attempts to install the APK file
    // Returns a string of either a detailed error message or that the app was installed successfully
    public String Install() {
        try {
            System.out.print("Looking for Android SDK...");
            File sdk = new File(prefs.sdkPath + "\\platform-tools");
            if (sdk.exists() && sdk.isDirectory()) {
                System.out.println("Found SDK!");
            } else {
                System.out.println("Error finding Android SDK.  Make sure your SDK path is correct.");
                return "ERROR: Unable to find Android SDK.  Make sure your SDK path is correct.\n";
            }
            try {
                cmd = Runtime.getRuntime().exec("cmd");
            } catch (IOException ex) {
                Logger.getLogger(AndroidInstaller.class.getName()).log(Level.SEVERE, null, ex);
            }
            cmdInput = new BufferedInputStream(cmd.getInputStream());
            cmdOutput = new PrintStream(new BufferedOutputStream(cmd.getOutputStream()));
            StreamHandler stream = new StreamHandler(cmdInput, "");
            Thread display = new Thread(stream);
            display.setDaemon(true);
            display.start();
            // Check for devices
            runWndCommand("cd /");
            runWndCommand("cd " + sdk.getAbsolutePath());
            runWndCommand("adb devices");
            runWndCommand("taskkill /f /im adb.exe");
            runWndCommand("exit");
            cmd.waitFor();
            // If no devices are found throw an error
            String[] lines = stream.getStream().split("\n");
            for (int i = 0; i < lines.length; i++) {
                if (lines[i].contains("List of devices attached")) {
                    if (lines[i+1].length() <= 1) {
                        return "ERROR:  No Android device recognized.\n";
                    }
                }
            }
            
            try {
                cmd = Runtime.getRuntime().exec("cmd");
            } catch (IOException ex) {
                Logger.getLogger(AndroidInstaller.class.getName()).log(Level.SEVERE, null, ex);
            }
            cmdInput = new BufferedInputStream(cmd.getInputStream());
            cmdOutput = new PrintStream(new BufferedOutputStream(cmd.getOutputStream()));
            stream = new StreamHandler(cmdInput, "");
            display = new Thread(stream);
            display.setDaemon(true);
            display.start();
            runWndCommand("cd /");
            runWndCommand("cd " + sdk.getAbsolutePath());
            runWndCommand("adb devices");
            runWndCommand("adb install " + " \"" + apk.path + "\"");
            runWndCommand("taskkill /f /im adb.exe");
            runWndCommand("exit");
            cmdOutput.close();
            cmd.waitFor();
            
            System.out.println("\nApp Successfully Installed!");
            return apk.name + " successfully installed!\n";
        } catch (IOException ex) {
            Logger.getLogger(AndroidInstaller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(AndroidInstaller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "App installation failed.\n";

    }

    // Function to run a command line command
    public void runWndCommand(String cmd) throws IOException, InterruptedException {
        cmdOutput.println(cmd);
        cmdOutput.flush();
    }
}
