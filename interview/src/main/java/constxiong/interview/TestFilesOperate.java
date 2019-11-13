package constxiong.interview;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * JDK 1.7 文件操作
 * @author ConstXiong
 * @date 2019-11-13 14:17:35
 */
public class TestFilesOperate {

	public static void copyFolder(String srcFolder, String destFolder) throws IOException {
		final Path srcPath = Paths.get(srcFolder);
		final Path destPath = Paths.get(destFolder);
		if (Files.notExists(srcPath)) {
			throw new IllegalArgumentException("参数错误");
		}
		// 如果目标目录不存在，则创建
		if (Files.notExists(destPath)) {
			Files.createDirectories(destPath);
		}
		Files.walkFileTree(srcPath, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				Path dest = destPath.resolve(srcPath.relativize(file));
				// 如果说父路径不存在，则创建
				if (Files.notExists(dest.getParent())) {
					Files.createDirectories(dest.getParent());
				}
				Files.copy(file, dest);
				return FileVisitResult.CONTINUE;
			}
		});
	}

	// 删除文件夹
	public static void deleteFolder(String Foleder) throws IOException {
		Path start = Paths.get(Foleder);
		if (Files.notExists(start)) {
			throw new IOException("文件夹不存在！");
		}

		Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				Files.delete(file);
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException e) throws IOException {
				if (e == null) {
					Files.delete(dir);
					return FileVisitResult.CONTINUE;
				} else {
					throw e;
				}
			}
		});
	}

	public static void main(String[] args) throws IOException {
//		copyFolder("E:/a", "E:/a_");
		deleteFolder("E:/a_");
	}

}
