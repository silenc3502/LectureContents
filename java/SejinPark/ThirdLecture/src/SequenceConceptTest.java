class SequenceThread {
    final int MAX = 16;
    final int MAX_LOOP = 2000000000;

    private static int[] sequenceProcessingArr;

    public SequenceThread() {
        sequenceProcessingArr = new int[MAX];

        for (int i = 0; i < MAX; i++) {
            sequenceProcessingArr[i] = 1;
        }
    }

    /* 순차 vs 병렬 차이를 비교하기 좋은 연산을 하나 준비해올게요 ~
     *  cos() * sin() - 푸리에 급수
     * 실제 결과만 확인 가능한 형태로 하나 준비하면 좋을듯 합니다.
     * 요즘 컴퓨터 성능이 너무 좋아져서 옛날처럼 안됩니다 ㅠㅠ
     * 특히 Intel은 AVX나 SSE 라는 벡터화 처리 CPU 유닛이 있어서
     * 아래와 같은 다중 for문을 돌 때 CPU가 알아서
     * 명령을 4개 ~ 8개 동시에 처리해줍니다.
     * 이 부분 때문에 하드코딩을 하면 속도가 더 빨라지는 부분도 있습니다. */
    public void sequenceProcessing() {
        for (int i = 0; i < MAX_LOOP; i++) {
            for (int j = 0; j < MAX_LOOP; j++) {
                sequenceProcessingArr[0]++;
                sequenceProcessingArr[0]--;
                sequenceProcessingArr[1]++;
                sequenceProcessingArr[1]--;
                sequenceProcessingArr[2]++;
                sequenceProcessingArr[2]--;
                sequenceProcessingArr[3]++;
                sequenceProcessingArr[3]--;
                sequenceProcessingArr[4]++;
                sequenceProcessingArr[4]--;
                sequenceProcessingArr[5]++;
                sequenceProcessingArr[5]--;
                sequenceProcessingArr[6]++;
                sequenceProcessingArr[6]--;
                sequenceProcessingArr[7]++;
                sequenceProcessingArr[7]--;
                sequenceProcessingArr[8]++;
                sequenceProcessingArr[8]--;
                sequenceProcessingArr[9]++;
                sequenceProcessingArr[9]--;
                sequenceProcessingArr[10]++;
                sequenceProcessingArr[10]--;
                sequenceProcessingArr[11]++;
                sequenceProcessingArr[11]--;
                sequenceProcessingArr[12]++;
                sequenceProcessingArr[12]--;
                sequenceProcessingArr[13]++;
                sequenceProcessingArr[13]--;
                sequenceProcessingArr[14]++;
                sequenceProcessingArr[14]--;
                sequenceProcessingArr[15]++;
                sequenceProcessingArr[15]--;
                    /*
                    System.out.printf("안녕 나는 혼자 돌아가는 스레드야! 현재값은 %d 이다!\n",
                            sequenceProcessingArr[k]);
                     */
            }
        }
    }

    public static int[] getSequenceProcessingArr() {
        return sequenceProcessingArr;
    }
}

public class SequenceConceptTest {
    public static void main(String[] args) {
        System.out.println("지금부터 순차 처리를 시작합니다.");

        long startTime = System.currentTimeMillis();

        SequenceThread st = new SequenceThread();

        st.sequenceProcessing();

        for (int i = 0; i < 16; i++) {
            System.out.println("최종 결과 확인: " + SequenceThread.getSequenceProcessingArr()[i]);
        }

        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime + "ms");
    }
}
// 병렬처리시: 대략 745ms
// 순차처리시: 대략 