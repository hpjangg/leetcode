package woowa;

import java.util.*;
import java.util.stream.Collectors;

public class No2 {

    public static void main(String[] args) {
        new No2Imp().solution("my.song.mp3 11b\n" +
                "greatSong.flac 1000b\n" +
                "not3.txt 5b\n" +
                "video.mp4 200b\n" +
                "game.exe 100b\n" +
                "mov!e.mkv 10000b");
    }

}

class No2Imp {

    public String solution(String S) {

        String[] arrS = S.split("\n");

        List<String> musicExtList = MusicType.getExtList();
        List<String> imageExtList = ImageType.getExtList();
        List<String> movieExtList = MovieType.getExtList();

        long musicByte = 0L;
        long imagesByte = 0L;
        long moviesByte = 0L;
        long otherByte = 0L;

        for (String file: arrS) {
            String[] splitFile = file.split(" ");
            String fileExt = getExt(splitFile[0]);
            int fileByte = getByte(splitFile[1]);

            if (musicExtList.contains(fileExt)) {
                musicByte += fileByte;
            } else if (imageExtList.contains(fileExt)) {
                imagesByte += fileByte;
            } else if (movieExtList.contains(fileExt)) {
                moviesByte += fileByte;
            } else {
                otherByte += fileByte;
            }
        }

        return getResult(musicByte, imagesByte, moviesByte, otherByte).toString();
    }

    private String getExt(String fileFullName) {
        String[] temp = fileFullName.split("\\.");
        return temp[temp.length-1];
    }

    private int getByte(String fileByte) {
        StringBuilder sb = new StringBuilder(fileByte);
        sb.deleteCharAt(sb.length()-1);
        return Integer.parseInt(sb.toString());
    }

    private StringBuilder getResult(long musicByte, long imagesByte, long moviesByte, long otherByte) {
        StringBuilder result = new StringBuilder();
        result.append("music ").append(musicByte).append("b\n");
        result.append("images ").append(imagesByte).append("b\n");
        result.append("movies ").append(moviesByte).append("b\n");
        result.append("other ").append(otherByte).append("b");
        return result;
    }
}

enum MusicType {
    MP3("mp3"),
    AAC("aac"),
    FLAC("flac");

    private final String ext;

    MusicType(String ext) {
        this.ext = ext;
    }

    public static List<String> getExtList() {
        return Arrays.stream(MusicType.values())
                .map(type -> type.ext)
                .collect(Collectors.toList());
    }
}

enum ImageType {
    JPG("jpg"),
    BMP("bmp"),
    GIF("gif");

    private final String ext;

    ImageType(String ext) {
        this.ext = ext;
    }

    public static List<String> getExtList() {
        return Arrays.stream(ImageType.values())
                .map(type -> type.ext)
                .collect(Collectors.toList());
    }
}

enum MovieType {
    MP4("mp4"),
    AVI("avi"),
    MKV("mkv");

    private final String ext;

    MovieType(String ext) {
        this.ext = ext;
    }

    public static List<String> getExtList() {
        return Arrays.stream(MovieType.values())
                .map(type -> type.ext)
                .collect(Collectors.toList());
    }
}
