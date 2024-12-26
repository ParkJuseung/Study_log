package ref.oop1;

public class MusicPlayer {
    int volume;
    boolean isON;

    void On(){
        isON = true;
        System.out.println("음악플레이어를 시작합니다.");
    }
    void Off(){
        isON = false;
        System.out.println("음악플레이어를 종료합니다.");
    }

    void VolumeUp(){
        volume++;
        System.out.printf("음악플레이어 볼륨 : %d%n", volume);
    }

    void VolumeDown(){
        volume--;
        System.out.printf("음악플레이어 볼륨 : %d%n", volume);
    }
    void showStatus(){
        if(isON){
            System.out.println("음악 플레이어 ON, 볼륨 : " + volume);
        }
        else System.out.println("음악 플레이어 OFF");
    }

}
