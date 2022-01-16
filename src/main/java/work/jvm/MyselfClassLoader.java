package work.jvm;

import work.Constants;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * 题目：
 * 自定义一个 Classloader,
 * 加载一个 Hello.xlass 文件，执行 Hello 方法，
 * 此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件
 */

/**
 * @Description: 类加载器
 * @Author: wangyuanyuan32
 * @Date: 2022/1/5 16:35
 */
public class MyselfClassLoader extends ClassLoader {

    public static void main(String[] arg) throws Exception {
        final String className = "Hello";
        final String methodName = "hello";
        Class<?> clazz = new MyselfClassLoader().findClass(className);
        // 创建对象
        Object instance = clazz.getDeclaredConstructor().newInstance();
        // 调用实例方法
        Method method = clazz.getMethod(methodName);
        method.invoke(instance);
    }

    @Override
    protected Class<?> findClass(String name){
        byte[] bytes = decode(loadSourceFile(Constants.SOURCE_FILE_ADDRESS));
        return defineClass(name, bytes, 0, bytes.length);
    }

    /**
     * 解码：每个字节取反码
     * @param sourceFile
     * @return
     */
    private byte[] decode(byte[] sourceFile) {
        byte[] res = new byte[sourceFile.length];
        for (int i = 0; i < sourceFile.length; i++) {
            res[i] = (byte) ~ sourceFile[i];
        }

        return res;
    }

    /**
     * 加载源文件
     * @param sourceFileAddress
     * @return
     */
    private byte[] loadSourceFile(String sourceFileAddress) {
        try {
            Path path = Paths.get(sourceFileAddress);
            byte[] bytes = Files.readAllBytes(path);
            return bytes;
        }catch (Exception e) {
            System.out.println("loadSourceFile error!");
        }
        return new byte[0];
    }
}
