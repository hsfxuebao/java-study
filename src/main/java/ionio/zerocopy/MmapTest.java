package ionio.zerocopy;

import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author hsfxuebao
 * Created on 2022-01-06
 */
public class MmapTest {

    public static void main(String[] args) {
        try {

            // 分配堆外内存
            // ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

            FileChannel readChannel = FileChannel.open(Paths.get("./cscw.txt"), StandardOpenOption.READ);
            FileChannel writeChannel = FileChannel.open(Paths.get("./siting.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            MappedByteBuffer data = readChannel.map(FileChannel.MapMode.READ_ONLY, 0, 1024 * 1024 * 40);
            //数据传输
            writeChannel.write(data);
            readChannel.close();
            writeChannel.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
