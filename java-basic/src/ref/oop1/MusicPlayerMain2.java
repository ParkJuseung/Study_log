package ref.oop1;

public class MusicPlayerMain2 {
    public static void main(String[] args) {
        MusicPlayerData data = new MusicPlayerData();

        On(data);
        VolumeUp(data);
        VolumeDown(data);
        showStatus(data);
        Off(data);
    }
    static void On(MusicPlayerData data){
        data.isON = true;
        System.out.println("음악플레이어를 시작합니다.");
    }
    static void Off(MusicPlayerData data){
        data.isON = false;
        System.out.println("음악플레이어를 종료합니다.");
    }

    static void VolumeUp(MusicPlayerData data){
        data.volume++;
        System.out.printf("음악플레이어 볼륨 : %d%n", data.volume);
    }

    static void VolumeDown(MusicPlayerData data){
        data.volume--;
        System.out.printf("음악플레이어 볼륨 : %d%n", data.volume);
    }
    static void showStatus(MusicPlayerData data){
        if(data.isON){
            System.out.println("음악 플레이어 ON, 볼륨 : " + data.volume);
        }
        else System.out.println("음악 플레이어 OFF");
    }
}
