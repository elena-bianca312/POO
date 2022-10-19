package fourth;

import java.util.ArrayList;

public class BadAlbum extends Album{

    ArrayList<Song> BadAlbum = new ArrayList<Song>();

    private boolean isPalindrome(int number) {
        boolean flag = false;

        int reverse = 0;
        int remainder;
        int copy = number;

        while(copy != 0){
            remainder = copy % 10;
            reverse = reverse * 10 + remainder;
            copy /= 10;
        }

        if(number == reverse)
            flag = true;

        return flag;
    }

    public void addSong(Song song){
        if((song.getName().length() == 3) && (isPalindrome(song.getId()))){
            BadAlbum.add(song);
        }
    }

    @Override
    public String toString() {
        return "BadAlbum{" +
                "BadAlbum=" + BadAlbum +
                '}';
    }
}
