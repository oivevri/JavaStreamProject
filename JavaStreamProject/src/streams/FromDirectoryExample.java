package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromDirectoryExample {
	public static void main(String[] args) {
		Path path = Paths.get("c:/program files");
		try {
			Stream<Path> stream = Files.list(path);
			stream.forEach(t -> System.out.println(t.getFileName()));
			// 그 경로에 있는 파일 이름들을 출력하자
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
