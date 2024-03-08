package com.study.mvc.diAndIoc;

import java.util.List;

public class DiService {

    private DiRepository diRepository; // 서비스의 주소와 같아진다.
                                        // 결합도가 높은 상태
                                    // 베터리 넣는 공간

    public DiService(DiRepository diRepository) { // 배터리
        this.diRepository = diRepository; // 생성자 외부에서 가져 오겠다.
                                            // 배터리 장착
    }
    // Service가 Repository를 의존한다.
    // 의존성과 결합도는 별개

    public int getTotal() {
        int total = 0;
        List<Integer> scoreList = diRepository.getScoreList();
        // 호출을 할때마다 생성을 하고 생성을 할때마다 메모리 주소를 할당받는다.
        for (Integer score : scoreList) {
            total += score;
        }

        return total;
    }

    public double getAverage() {

        double avg = 0;
        int total = 0;
        List<Integer> scoreList = diRepository.getScoreList();

        for (Integer score : scoreList) {
            total += score;
        }

        avg = total / scoreList.size();

        return avg;
    }
}
