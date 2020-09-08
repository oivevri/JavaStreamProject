package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromFileExample {
	public static void main(String[] args) {
		String file = "list.txt";
		// D:\Dev\workspace\JavaStreamProject 에 만든 list.txt
		// 왜 바로오냐? 같은 프로젝트 안 바로 그 경로라서 그런가?

		String file2 = "src/streams/StreamExample.java";
		// 얘는 이클립스에서 만들었던 거. streams패키지에 있던애

		Path path = Paths.get(file); // 위치의 값을 불러오겠다
		try {
			Stream<String> stream = Files.lines(path);
			stream.forEach(s -> System.out.println(s));
			stream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
