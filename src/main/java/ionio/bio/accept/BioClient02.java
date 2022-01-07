package ionio.bio.accept;

import java.io.IOException;
import java.net.Socket;

/**
 * @author hsfxuebao
 * Created on 2021-12-28
 */
public class BioClient02 {

    public static void main(String[] args) throws IOException {
        System.out.println("------RedisClient01 start");
        Socket socket = new Socket("127.0.0.1", 6380);
    }

}
