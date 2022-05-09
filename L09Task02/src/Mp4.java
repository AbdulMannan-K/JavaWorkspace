public class Mp4 implements AdvanceMediaPlayer{

    @Override
    public void playVlc() {
        System.out.println("Can't play VLC");
    }

    @Override
    public void playmp4() {
        System.out.println("Playing Mp4");
    }
}
