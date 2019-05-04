package constxiong.interview;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Iterator;

public class TestNioFiles {

	public static void main(String[] args) throws IOException {
//		testIsExecutable();
//		testIsSymbolicLink();
//		testIsSameFile();
//		testIsReadable();
//		testIsDirectory();
//		testIsHidden();
//		testIsWritable();
//		testIsRegularFile();
//		testGetPosixFilePermissions();
//		testGetOwner();
	}
	
	public static void testIsExecutable() {
		Path path_txt = Paths.get("C:/Users/dell/Desktop/questions.txt");
		Path path_bat = Paths.get("C:/Users/dell/Desktop/startWX.bat");
		System.out.println(Files.isExecutable(path_txt));
		System.out.println(Files.isExecutable(path_bat));
	}
	
	public static void testIsSymbolicLink() {
		Path path_txt = Paths.get("C:/Users/dell/Desktop/questions.txt");
		Path path_bat = Paths.get("C:/Users/dell/Desktop/startWX.bat");
		System.out.println(Files.isSymbolicLink(path_txt));
		System.out.println(Files.isSymbolicLink(path_bat));
	}
	
	public static void testIsSameFile() throws IOException {
		Path path_txt = Paths.get("C:/Users/dell/Desktop/questions.txt");
		Path path_bat = Paths.get("C:/Users/dell/Desktop/startWX.bat");
		System.out.println(Files.isSameFile(path_txt, path_bat));
	}
	
	public static void testIsReadable() throws IOException {
		Path path_txt = Paths.get("C:/Users/dell/Desktop/questions.txt");
		Path path_bat = Paths.get("C:/Users/dell/Desktop/startWX.bat");
		System.out.println(Files.isReadable(path_txt));
		System.out.println(Files.isReadable(path_bat));
	}
	
	public static void testIsDirectory() throws IOException {
		Path path_txt = Paths.get("C:/Users/dell/Desktop/questions.txt");
		Path dir = Paths.get("C:/Users/dell/Desktop/");
		System.out.println(Files.isDirectory(path_txt));
		System.out.println(Files.isDirectory(dir));
	}
	
	public static void testIsHidden() throws IOException {
		Path path_txt = Paths.get("C:/Users/dell/Desktop/questions.txt");
		Path path_bat = Paths.get("C:/Users/dell/Desktop/startWX.bat");
		System.out.println(Files.isHidden(path_txt));
		System.out.println(Files.isHidden(path_bat));
	}
	
	public static void testIsWritable() throws IOException {
		Path path_txt = Paths.get("C:/Users/dell/Desktop/questions.txt");
		Path dir = Paths.get("C:/Users/dell/Desktop/");
		System.out.println(Files.isWritable(path_txt));
		System.out.println(Files.isWritable(dir));
	}
	
	public static void testIsRegularFile() throws IOException {
		Path path_txt = Paths.get("C:/Users/dell/Desktop/questions.txt");
		Path dir = Paths.get("C:/Users/dell/Desktop/");
		System.out.println(Files.isRegularFile(path_txt));
		System.out.println(Files.isRegularFile(dir));
	}
	
	public static void testGetPosixFilePermissions() throws IOException {
		Path path_txt = Paths.get("C:/Users/dell/Desktop/questions.txt");
		for (PosixFilePermission p :  Files.getPosixFilePermissions(path_txt)) {
			System.out.println(p);
		}
	}
	
	public static void testGetOwner() throws IOException {
		Path path_js = Paths.get("/Users/handsome/Desktop/xo.js");
		System.out.println(Files.getOwner(path_js));
	}
	
	public static void test() throws IOException {
		Path path = Paths.get("C:/Users/dell/Desktop/questions.txt");
		Path path_ = Paths.get("C:/Users/dell/Desktop/questions_.txt");
		Path dir = Paths.get("C:/Users/dell/Desktop/");
		Path dirs = Paths.get("C:/Users/dell/Desktop/a/b/c");
		
		System.out.println(Files.exists(path));
		
		InputStream is = Files.newInputStream(path);//创建一个输入流
		is.close();
		
		OutputStream os = Files.newOutputStream(path);//创建一个输出流
		os.close();
		
		SeekableByteChannel channel = Files.newByteChannel(path);
		ByteBuffer bb = ByteBuffer.allocate(10);
		channel.read(bb);
		byte[] array = bb.array();
		for (byte b : array) {
			System.out.println(b);
		}
		
		DirectoryStream<Path> dirStream = Files.newDirectoryStream(dir);
		Iterator<Path> ite = dirStream.iterator();
		while (ite.hasNext()) {
			Path p = ite.next();
			System.out.println(p);
		}
		
		Files.createFile(path_);
		Files.createDirectories(dirs);
		
	}
}
