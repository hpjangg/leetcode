package naver;

public class No2 {

    public static void main(String[] args) {
        new No2().solution(new int[]{-3,-14,-5,7,8,32,8,3});
        new No2().solution(new int[]{2,-3,3,1,10,8,2,5,13,-5,3,-18});
    }

    public String solution(int[] T) {

        SeasonState seasonState = new SeasonState(Season.WINTER); // 계절 상태

        int maxAmplitude = 0; // 최대 진폭

        String season = seasonState.getSeasonName(); // 계절

        int tempCount = getTempCount(T.length);

        for (int i = 0; i < T.length; i += tempCount) {
            MinMax minMax = getMinMax(T, i, tempCount);
            int amplitude = minMax.getAmplitude();
            if (maxAmplitude < amplitude) {
                maxAmplitude = amplitude;
                season = seasonState.getSeasonName();
            }
            seasonState.next();
        }

        return season;
    }

    /**
     * 한 계절에 존재하는 온도 값 개수
     */
    private int getTempCount(int length) {
        return length / 4;
    }

    /**
     * 한 계절에 존재하는 온도 값 중에서 최솟값과 최댓값
     */
    private MinMax getMinMax(int T[], int seasonIdx, int tempCount) {
        MinMax minMax = new MinMax(T[seasonIdx]);
        for (int j = seasonIdx+1; j < seasonIdx+tempCount; j++) {
            minMax.changeSmallerValue(T[j]);
            minMax.changeBiggerValue(T[j]);
        }
        return minMax;
    }


}

class SeasonState {

    private Season season;

    public SeasonState(Season firstSeason) {
        this.season = firstSeason;
    }

    public String getSeasonName() {
        return this.season.name();
    }

    public void next() {
        if (Season.WINTER.equals(this.season)) {
            this.season = Season.SPRING;
        } else if (Season.SPRING.equals(this.season)) {
            this.season = Season.SUMMER;
        } else if (Season.SUMMER.equals(this.season)) {
            this.season = Season.AUTUMN;
        } else {
            this.season = Season.WINTER;
        }
    }

}

class MinMax {
    private int min;
    private int max;

    public MinMax(int initValue) {
        this.min = initValue;
        this.max = initValue;
    }

    public void changeSmallerValue(int value) {
        if (this.min > value) {
            this.min = value;
        }
    }

    public void changeBiggerValue(int value) {
        if (this.max < value) {
            this.max = value;
        }
    }

    public int getAmplitude() {
        return Math.abs(this.max-this.min);
    }
}

enum Season {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN
}