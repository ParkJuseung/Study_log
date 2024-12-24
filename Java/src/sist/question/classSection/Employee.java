package sist.question.classSection;

import org.w3c.dom.ls.LSOutput;

public class Employee {
    private String name;
    private String department;
    private String position;
    private String tel;
    private Employee boss;

    //getter, setter 구현

    public String getName() {
        return name;
    }

    //한글
    // 2~5자 이내
    public void setName(String name) {
        int checkBoolean = 0;
        if(name.length()>=2 && name.length()<=5){
            for(int i =0; i<name.length(); i++) {
                if (name.charAt(i) >= '가' && name.charAt(i) <= '힣') {
                    checkBoolean++;
                }
            }
        }
        if(name.length() == checkBoolean){
            this.name = name;
        }else System.out.println("올바른 입력이 아닙니다.");
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if(department.equals("영업부") || department.equals("기획부")|| department.equals("총무부") || department.equals("개발부") || department.equals("홍보부") ){
            this.department = department;
        }else System.out.println("잘못된 부서입니다.");

    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if(position.equals("부장") || position.equals("과장")|| position.equals("대리") || position.equals("사원")) {
            this.position = position;
        } else System.out.println("잘못된 직책입니다.");
    }

    public String getTel() {
        return tel;
    }

    // 010-XXXX-XXXX 형식 확인
    public void setTel(String tel) {
        tel = tel.trim(); // 공백 제거

        if (tel.length() == 13 && tel.charAt(4) == '-' && tel.charAt(9) == '-') {
            String trimmedTel = tel.replace("-", "");
            boolean isInteger = true;

            // 숫자인지 확인
            for (char c : trimmedTel.toCharArray()) {
                if (!Character.isDigit(c)) {
                    isInteger = false;
                    break; // 숫자가 아닌 문자가 발견되면 루프 종료
                }
            }

            // 숫자 검사 결과 처리
            if (isInteger) {
                this.tel = tel; // 전화번호 설정
                System.out.println("전화번호가 설정되었습니다: " + tel);
            } else {
                System.out.println("잘못된 형식의 숫자입니다.");
            }
        }
        else {
            // 기본 형식이 잘못된 경우
            System.out.println("잘못된 형식의 입력입니다. 010-XXXX-XXXX으로 입력해주세요.");
        }
    }


    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }

    public String info() {
        String output = "";

        output += String.format("[%s]\n",name);
        output += String.format("부서 : %s\n",department);
        output += String.format("직위 : %s\n",position);
        output += String.format("연락처 : %s\n",tel);
        output += String.format("직속상사 : %s\n",boss);

        return output;
    }
}
