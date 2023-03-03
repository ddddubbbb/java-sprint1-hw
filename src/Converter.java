public class Converter {

    int convertToKm(int steps) {
        int oneStep = 75;
        int stepsToKm = steps * oneStep / 100000;
        return stepsToKm;
    }

    int convertStepsToKilocalories( int steps){
        int oneStep = 50;
        int stepsToKk = steps * oneStep / 1000;
        return stepsToKk;
    }
}