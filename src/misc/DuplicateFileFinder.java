package misc;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateFileFinder {
    static class FileInfo {
        String path;
        String content;
        FileInfo(String path, String content) {
            this.path = path;
            this.content = content;
        }
    }


    public static List<List<String>> findDuplicateFiles(List<FileInfo> files) {
        // Map to store content hash -> list of file paths
        Map<String, List<String>> hashMap = new HashMap<>();

        for (FileInfo fileInfo : files) {
            try {
                String contentString = fileInfo.content != null ? fileInfo.content : "";
                InputStream is = new ByteArrayInputStream(contentString.getBytes(StandardCharsets.UTF_8));
                String fileHash = generateHash256(is);
                hashMap.computeIfAbsent(fileHash, k -> new ArrayList<>()).add(fileInfo.path);
            } catch (Exception e) {
                System.err.println("Failed to process file: " + fileInfo.path);
            }
        }

        return hashMap.values().stream().filter(path -> path.size() > 1).
                collect(Collectors.toList());
    }

    private static String generateHash256(InputStream is) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead = is.read(buffer)) != -1) {
            digest.update(buffer, 0, bytesRead);
        }

        // Convert the digest bytes into a Hex string
        byte[] hashBytes = digest.digest();
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static void main(String[] args) {
        List<FileInfo> files = List.of(
                new FileInfo("/root/a.txt", "hello"),
                new FileInfo("/root/b.txt", "world"),
                new FileInfo("/root/c.txt", "hello"),
                new FileInfo("/root/d.txt", "hello")
        );

        List<List<String>> duplicates = findDuplicateFiles(files);
        System.out.println(duplicates);
        // Output: [[/root/a.txt, /root/c.txt, /root/d.txt]]
    }
}
