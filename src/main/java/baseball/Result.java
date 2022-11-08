package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Result {
    private final int strikeCnt;
    private final int ballCnt;

    public Result(int strikeCnt, int ballCnt) {
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
    }

    public static Result compareBall(String userInputNumber, String randomBall) {
        List <String> randomNumList = Arrays.stream(randomBall.split("")).collect(Collectors.toList());


        int strike = 0;
        int ball = 0;
        int idx = 0;

        for (String digit : userInputNumber.split("")) {
            if (randomNumList.contains(digit) && digit.equals(randomNumList.get(idx))) {
                strike++;
                idx++;
                continue;
            }

            if (randomNumList.contains(digit)) {
                ball++;
            }

            idx++;
        }
        return new Result(strike, ball);
    }

    public void printResult() {
        String res = "";
        if (this.strikeCnt == 0 && this.ballCnt == 0) {
            res = "낫싱";
        }

        if (this.ballCnt != 0) {
            res = this.ballCnt + "볼 ";
        }

        if (strikeCnt != 0) {
            res += this.strikeCnt + "스트라이크";
        }

        System.out.println(res.trim());
    }

    public boolean isAllStrike() {
        return strikeCnt == 3;
    }
}
