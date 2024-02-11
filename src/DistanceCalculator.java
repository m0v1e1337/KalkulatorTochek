import java.util.Scanner;

public class DistanceCalculator {

    private static final double EARTH_RADIUS = 6371.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите широту первой точки (в градусах): ");
        double firstPointLatitude = scanner.nextDouble();

        System.out.println("Введите долготу первой точки (в градусах): ");
        double firstPointLongitude = scanner.nextDouble();

        System.out.println("Введите широту второй точки (в градусах): ");
        double secondPointLatitude = scanner.nextDouble();

        System.out.println("Введите долготу второй точки (в градусах): ");
        double secondPointLongitude = scanner.nextDouble();

        double distance = calculateDistance(firstPointLatitude, firstPointLongitude, secondPointLatitude, secondPointLongitude);
        System.out.println("Расстояние между двумя точками: " + distance + " км");

        scanner.close();
    }

    public static double calculateDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
        double latitude1Radians = Math.toRadians(latitude1);
        double longitude1Radians = Math.toRadians(longitude1);
        double latitude2Radians = Math.toRadians(latitude2);
        double longitude2Radians = Math.toRadians(longitude2);

        double deltaLatitude = latitude2Radians - latitude1Radians;
        double deltaLongitude = longitude2Radians - longitude1Radians;

        double a = Math.sin(deltaLatitude / 2) * Math.sin(deltaLatitude / 2) +
                Math.cos(latitude1Radians) * Math.cos(latitude2Radians) *
                        Math.sin(deltaLongitude / 2) * Math.sin(deltaLongitude / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }
}