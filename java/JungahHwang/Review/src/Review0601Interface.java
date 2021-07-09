// 인터페이스 작성법
//  interface + 인터페이스명(일종의 클래스) + {메소드 포로토타입}
//       (프로토타입: 메소드으 접근제한자, 리턴타입, 메소드 이름, 입력 등)
interface Remocon {
    public void turnOn();
    public void turnOff();
    // 인터페이스 메소드는 클래스 메소드 처럼 {중괄호} 가 필요 없음
}


// 추상화란?
// 객체 <<<=== 대표적인 추상화의 예
// 객체 <<<=== 현 시점에서 우리는 무엇을 생각하는가 ?
//             new, 메모리에 올라간 데이터들 혹은 정보들 ...
// 단어가 어떤 함축된 의미를 포함해버렸음(우리는 알게 모르게 사용하고 있었고)
// 객체란 단어만 보고도 이것이 어떻게 어떻게 형성되었는지 등이 이미 뇌리에 스치고 있음

// KKK사의 컴퓨터를 킨다.
// GH사의 라디오를 킨다.
// A사의 리모콘을 킨다.    =======> 킨다(뭔진 모르겠지만)
// B사의 리모콘을 킨다.
// ................
// Z사의 리모콘을 킨다.

// OOP(객체지향)에서 제일 중요시 여기는 것이 바로 추상화다.
// 현재까지의 내용을 토대로 추상화란 궁극적으로 무엇을 추구하는것인가 ?

// 복잡하고 어렵고 토나오는것은 우리가 해줄게
// (자바 라이브러리 개발자 진영 및 스프링 프레임워크 개발 진영)
// 라이브러리 사용자들은 편하게 API 사용해서 개발만 하세요 ~
// 이런 입력 ----> Black Box(블랙 박스) ---> 요런 출력이 나와요

// sout() ===> System.out.println()

class AbstractTest {
    Remocon rc = new Remocon() {
        @Override
        public void turnOn() {
            System.out.println("나는 RC 자동차용 리모콘이야! RF 송수신기가 지금 활성화되었어!");
        }
        @Override
        public void turnOff() {
                System.out.println("이제 헤어질 시간이야! RF 송수신기 신호 출력을 차단할게!");
            }
    };
        Remocon radio = new Remocon() {
            @Override
            public void turnOn() {
                System.out.println("나는 라디오야! 지금부터 주파수 채널 매칭을 시작할게!");
            }

            @Override
            public void turnOff() {
                System.out.println("이젠 안녕! 주파수 채널 매칭을 끊을게!");
            }
        };

        public void testMethod() {
            Remocon tv = new Remocon() {
                @Override
                public void turnOn() {
                    System.out.println("나는 TV야! AM/FM 신호를 수신할게! 이제부터 방송을 보자!");
                }

                @Override
                public void turnOff() {
                    System.out.println("AM/FM 신호를 차단할게! 내일 또 보자!");
                }
            };
            tv.turnOn();
            radio.turnOff();
        }

        public void testMethod2() {
            rc.turnOn();
            radio.turnOff();
        }
    }


    public class Review0601Interface {
        public static void main(String[] args) {
            AbstractTest at = new AbstractTest();

            at.testMethod();
            at.testMethod2();
        }
    }
