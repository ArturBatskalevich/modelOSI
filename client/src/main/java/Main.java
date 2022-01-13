import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8990;
        Scanner scanner = new Scanner(System.in);

        try {
            Socket clientSocket = new Socket(host,port);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String name = in.readLine();
            System.out.println(name);
            String result = scanner.nextLine();
            out.println(result);

            String childYes = in.readLine();
            System.out.println(childYes);
            String result1 = scanner.nextLine();
            out.println(result1);

            String serverResult = in.readLine();
            System.out.println(serverResult);

//            out.println("Netology");
//            String resp = in.readLine();
//            System.out.println(resp);

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
