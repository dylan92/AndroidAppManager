
import java.io.File;

// Android App Manager
// Dylan Yates

// Wrapper class for storing information about an Android .apk file
public class APK {
    public boolean isSigned = false;
    public boolean isAligned = false;
    public String name;
    public String path;
    
    public APK (File f) {
        path = f.getAbsolutePath();
        name = f.getName();
    }
    
    public String toString() {
        return name;
    }
}
