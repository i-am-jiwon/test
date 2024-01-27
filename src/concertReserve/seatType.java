package concertReserve;

import java.util.Scanner;

public class seatType {
    private char type;
    private Seat[] aSeat;

    public seatType(char type, int num){
        this.type = type;
        aSeat = new Seat[num];

        for (int i = 0; i<aSeat.length; i++) {
            aSeat[i] = new Seat();
        }
    }

    public boolean seatReserve() {
        Scanner in = new Scanner(System.in);
        int seatNum;
        String name;
        show();
        System.out.print("이름 : ");
        name = in.next();
        System.out.print("좌석 번호 : ");
        seatNum = in.nextInt();

        if(seatNum < 1 || seatNum > aSeat.length){
            System.out.println("잘못된 좌석번호 입니다.");
            return false;
        }
        if (aSeat[seatNum-1].isOccupied()){
            System.out.println("이미 예약된 좌석번호 입니다.");
            return false;
        }
        aSeat[seatNum-1].reserveName(name);
        return true;
    }

    public boolean cancel() {
        Scanner in = new Scanner(System.in);
        show();
        System.out.print("이름 : ");
        String name = in.next();

        if (name != null){
            for(int i = 0; i < aSeat.length; i++){
                if(aSeat[i].match(name)){
                    aSeat[i].cancel();
                    return true;
                }
            }
            System.out.println("예약자 이름을 찾을 수 없습니다.");
        }
        return false;
    }

    public void show() {
        System.out.println(type + "석 예약 : ");

        for (int i = 0; i<aSeat.length; i ++){
            if(aSeat[i].isOccupied())
                System.out.print(aSeat[i].getName());
            else
                System.out.print("---");
            System.out.print(" ");
        }
    }
}
