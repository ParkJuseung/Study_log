package ref.oop1;

public class MusicPlayerMain4 {
    public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer();
        //플레이어 켜기
        musicPlayer.On();
        musicPlayer.VolumeUp();
        musicPlayer.VolumeDown();
        musicPlayer.showStatus();
        musicPlayer.Off();

    }
}
