package week1_design_pattern_cts;

public class FinancialForecastingExercise {

    // Averages the last few data points to smooth out noise and estimate what's next
    public static double calculateMovingAverage(double[] pastValues, int windowSize) {
        int start = pastValues.length - windowSize;
        double sum = 0;
        for (int i = start; i < pastValues.length; i++) {
            sum += pastValues[i];
        }
        return sum / windowSize;
    }

    // How much (in %) the value changed from the first to the last data point
    public static double calculateGrowthRate(double[] pastValues) {
        double first = pastValues[0];
        double last = pastValues[pastValues.length - 1];
        return ((last - first) / first) * 100;
    }

    public static void main(String[] args) {
        double[] monthlyRevenue = {120.0, 135.0, 128.0, 150.0, 160.0, 155.0};

        System.out.println("Monthly Revenue Data:");
        for (int i = 0; i < monthlyRevenue.length; i++) {
            System.out.println("Month " + (i + 1) + ": $" + monthlyRevenue[i] + "k");
        }

        int windowSize = 3;
        double forecast = calculateMovingAverage(monthlyRevenue, windowSize);
        System.out.println("\nForecasted next month's revenue (3-month average): $" + forecast + "k");

        double growthRate = calculateGrowthRate(monthlyRevenue);
        System.out.printf("Overall growth rate from Month 1 to Month 6: %.2f%%\n", growthRate);
    }
}
