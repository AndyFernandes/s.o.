/**
 * Client program requesting current date from server.
 *
 */
 
import java.net.*;
import java.io.*;

public class DateClientOperacao
{
	public static void main(String[] args) throws IOException {
		InputStream in = null;
		BufferedReader bin = null;
		Socket sock = null;

		try {
			sock = new Socket("127.0.0.1",6013);
			
			PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);
			pout.println("/:25:5");
			
			in = sock.getInputStream();
			bin = new BufferedReader(new InputStreamReader(in));

			String line;
			while( (line = bin.readLine()) != null){
				System.out.println(line);
			}

			pout.close();
		}
		catch (IOException ioe) {
				System.err.println(ioe);
		}
                finally {
                    sock.close();
                }
	}
}