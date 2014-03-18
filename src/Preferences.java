
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Android App Manager
// Dylan Yates

// Contains a list of preferences set by the user
public class Preferences {

    public String jdkPath = "";
    public String sdkPath = "";
    public String keyStorePath = "";
    public String keyStorePassword = "";
    public String keyAlias = "";
    public String keyPassword = "";

    // Saves preferences to a text file
    public void Save() throws IOException {
        BufferedWriter output = new BufferedWriter(new FileWriter("Prefs.txt"));
        try {
            output.write("JDKPATH|" + jdkPath);
            output.newLine();
            output.write("SDKPATH|" + sdkPath);
            output.newLine();
            output.write("KEYSTOREPATH|" + keyStorePath);
            output.newLine();
            output.write("KEYSTOREPASSWORD|" + keyStorePassword);
            output.newLine();
            output.write("KEYALIAS|" + keyAlias);
            output.newLine();
            output.write("KEYPASSWORD|" + keyPassword);
        } catch (IOException e) {
        } finally {
            output.close();
        }
        System.out.println("Preferences Saved!");
    }

    // Loads preferences from a text file
    public boolean Load() {
        try {
            BufferedReader input = new BufferedReader(new FileReader("Prefs.txt"));
            try {
                String line = null;
                while ((line = input.readLine()) != null) {
                    if (line.contains("JDKPATH|")) {
                        jdkPath = line.substring(line.indexOf("|") + 1);
                    }
                    if (line.contains("SDKPATH|")) {
                        sdkPath = line.substring(line.indexOf("|") + 1);
                    }
                    if (line.contains("KEYSTOREPATH|")) {
                        keyStorePath = line.substring(line.indexOf("|") + 1);
                    }
                    if (line.contains("KEYSTOREPASSWORD|")) {
                        keyStorePassword = line.substring(line.indexOf("|") + 1);
                    }
                    if (line.contains("KEYALIAS|")) {
                        keyAlias = line.substring(line.indexOf("|") + 1);
                    }
                    if (line.contains("KEYPASSWORD|")) {
                        keyPassword = line.substring(line.indexOf("|") + 1);
                    }
                }
            } finally {
                input.close();
            }
        } catch (IOException ex) {
            System.out.println("Missing Prefs file.");
            return false;
        }

        return true;
    }
}
