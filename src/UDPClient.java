import java.net.*;
public class UDPClient {
    String sentence;
    String ip;
    String port;
    public void UDPGo(String sentence, String ip, String port) throws Exception {
        this.sentence = sentence;
        this.ip = ip;
        this.port = port;
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName(ip);
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        sendData = sentence.getBytes();
        DatagramPacket sendPacket =
                new DatagramPacket(sendData, sendData.length, IPAddress, Integer.parseInt(port));
        clientSocket.send(sendPacket);
        DatagramPacket receivePacket =
                new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence =
                new String(receivePacket.getData());
        System.out.println("FROM SERVER:" + modifiedSentence);
        clientSocket.close();
    }
}
