package fourth;

import java.util.ArrayList;

public class ThrillerAlbum extends Album{

    ArrayList<Song> ThrillerAlbum = new ArrayList<Song>();

    public void addSong(Song song) {
        if(song.getComposer().equals("Michael Jackson") && (song.getId() / 2 == 0)) {
            ThrillerAlbum.add(song);
        }
    }

    @Override
    public String toString() {
        return "ThrillerAlbum{" +
                "ThrillerAlbum=" + ThrillerAlbum +
                '}';
    }
}
