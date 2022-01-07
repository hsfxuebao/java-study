package ionio.bio.accept;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hsfxuebao
 * Created on 2021-12-28
 */
public class BioServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(6380);

        while(true)
        {
            System.out.println("模拟RedisServer启动-----111 等待连接");
            Socket socket = serverSocket.accept();
            System.out.println("-----222 成功连接");
            System.out.println();
        }
    }

}
