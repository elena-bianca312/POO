package fourth;

import java.util.ArrayList;

public class DangerousAlbum extends Album{

    ArrayList<Song> DangerousAlbum = new ArrayList<Song>();

    private boolean isPrime(int number) {
        boolean flag = false;
        int i;
        for(i = 2; i <= number/2; i++){
            if(number % i == 0) {
                flag = true;
                return !flag;
            }
        }
        return !flag;
    }

    public void addSong(Song song) {
        if(isPrime(song.getId())){
            DangerousAlbum.add(song);
        }
    }

    @Override
    public String toString() {
        return "DangerousAlbum{" +
                "DangerousAlbum=" + DangerousAlbum +
                '}';
    }
}
