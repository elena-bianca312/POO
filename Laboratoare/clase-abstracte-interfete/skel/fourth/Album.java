package fourth;

import java.util.ArrayList;

public abstract class Album {

    ArrayList<Song> songs = new ArrayList<Song>();

    abstract void addSong(Song song);

    void removeSong(Song song){
        for(int i = 0; i < songs.size(); i++){
            if(songs.get(i).equals(song)){
                songs.remove(songs.get(i));
            }
        }
    }

    @Override
    public String toString() {
        return "Album {" +
                "list = " + songs +
                '}';
    }
}
