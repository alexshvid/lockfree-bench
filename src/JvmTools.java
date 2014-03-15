
public class JvmTools {

	static {
	    System.loadLibrary("jvmtools");
	}
	   
	public static native void usleep(long nanoSeconds);
	
	
	public static void main(String[] args) {
		
		usleep(123L);
		
	}
	
}
