package io;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class buffer {
        public static void main(String[] args) {
            //分配内存大小为11的整型缓存区
            IntBuffer buffer = IntBuffer.allocate(11);
            //往buffer里写入2个整型数据
            for (int i = 0; i < 2; ++i) {
                int randomNum = new SecureRandom().nextInt();
                buffer.put(randomNum);
            }
            //将Buffer从写模式切换到读模式
            buffer.flip();
            System.out.println("position >> " + buffer.position()
                    + "limit >> " + buffer.limit()
                    + "capacity >> " + buffer.capacity());
            //读取buffer里的数据
            while (buffer.hasRemaining()) {
                System.out.println(buffer.get());
            }
            System.out.println("position >> " + buffer.position()
                    + "limit >> " + buffer.limit()
                    + "capacity >> " + buffer.capacity());
        }
}
