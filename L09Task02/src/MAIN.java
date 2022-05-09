public class MAIN {

    public static void main(String[] args){
        AdvanceMediaPlayer advanceMediaPlayer = new Vlc();
        advanceMediaPlayer.playVlc();
        advanceMediaPlayer.playmp4();

        System.out.println();

        advanceMediaPlayer = new Mp4();
        advanceMediaPlayer.playmp4();
        advanceMediaPlayer.playVlc();
    }

}
