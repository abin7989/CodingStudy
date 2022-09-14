
public class DBClose {
	public static void close(AutoCloseable... autoCloseable){
		for(int i = 0, size = autoCloseable.length ; i <size;i++ ) {
			try {
				if(autoCloseable[i]!=null)
					autoCloseable[i].close();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
}
