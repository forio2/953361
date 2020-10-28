import java.util.Scanner;

class Main {
    public static void main(String[] args)throws Exception {
        //-x 622115026 -t tcp or udp -s 127.0.0.1 -p 1234
       String sentence = " ";
       String type = " ";
       String ip = " ";
       String port = " ";
       Scanner in = new Scanner(System.in);
       String text = in.nextLine();
       String[] keep = text.split(" ");
       for(int i=0;i< keep.length;i++){
           if (keep[i].equals("-x")){
               sentence = keep[i+1];
           }
           else if (keep[i].equals("-t")){
               type = keep[i+1];
           }
           else if (keep[i].equals("-s")){
               ip = keep[i+1];
           }
           else if (keep[i].equals("-p")){
               port = keep[i+1];
           }
       }
        if (type.equals("tcp")){
            TCPClient TCP = new TCPClient();
            TCP.TCPGo(sentence, ip, port);
        } else if (type.equals("udp")){
            UDPClient UDP = new UDPClient();
            UDP.UDPGo(sentence, ip, port);
        }
    }
}