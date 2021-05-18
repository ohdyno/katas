package duplicates;

public class Song {
    public StringBuffer song = new StringBuffer();

    public void sing(String line) {
        song.append(line + "\n");
    }
}
