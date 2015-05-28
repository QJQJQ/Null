import java.io.BufferedReader;
import java.io.IOException;

public class ServerThread extends Thread {
 
    private String usermsg = "";
    private BufferedReader clientin;
 
    @SuppressWarnings("unused")
    private ServerThread() {
        // can't use Constructor
    }
 
    public ServerThread(BufferedReader in) {
        clientin = in;// ���i�ӳB�z
    }
 
    @Override
    public void run() {
        // loop to listen User's input
        while (true) {
            try {
                usermsg = clientin.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("�ϥΪ̻�:" + usermsg);
             
            if (usermsg=="�A��"||usermsg=="bye"){
                System.out.println("���_�s��");
                try {
                    clientin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(500); // ��0.5��
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
             
        }
    }
 
}