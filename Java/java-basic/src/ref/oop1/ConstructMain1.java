package ref.oop1;

import java.util.Arrays;

public class ConstructMain1 {
    public static void main(String[] args) {
        MemberConstruct member1 = new MemberConstruct("user1", 15, 90);
        MemberConstruct member2 = new MemberConstruct("user2", 15);
        MemberConstruct[] member = {member1, member2};

        for(MemberConstruct s : member){
            System.out.println("이름: " + s.name + " 나이 : " + s.age + " 성적 : " + s.grade);
        }
    }
}
