
import java.io.*;

// Android App Manager
// Dylan Yates

// Utility for sending an receiving data to the cmd program
class StreamHandler extends Thread {

    InputStream is;
    String type;
    OutputStream os;
    String stream = "";

    StreamHandler(InputStream is, String type) {
        this(is, type, null);
    }

    StreamHandler(InputStream is, String type, OutputStream redirect) {
        this.is = is;
        this.type = type;
        this.os = redirect;
    }

    /**
     * Creates readers to handle the text created by the external program
     */
    public void run() {
        try {
            PrintWriter pw = null;
            if (os != null) {
                pw = new PrintWriter(os);
            }

            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                stream += line + "\n";
                if (pw != null) {
                    pw.println(line);
                }
                System.out.println(type + ">" + line);
            }
            if (pw != null) {
                pw.flush();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    public String getStream() {
        return stream;
    }
}