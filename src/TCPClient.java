import java.io.*;
import java.net.*;
public class TCPClient {
    String sentence;
    String ip;
    String port;
        public void TCPGo(String sentence, String ip, String port)throws Exception{
            this.sentence = sentence;
            this.ip = ip;
            this.port = port;
            String modifiedSentence;
            Socket clientSocket = new Socket(ip, Integer.parseInt(port));
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outToServer.writeBytes(sentence + '\n');
            modifiedSentence = inFromServer.readLine();
            System.out.println("FROM SERVER: " + modifiedSentence);
            clientSocket.close();
        }
}
