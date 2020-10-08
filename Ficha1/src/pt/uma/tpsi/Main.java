package pt.uma.tpsi;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //System.out.println("Hello World");
        int perimeter = calculatePerimeter(2,4);
        int volume = calculateVolume(2, 4, 6);
        float temperature = convertToCelsius(100);
        int time = transformToSeconds(1, 10, 30);
        int intArray[] = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
        float media = calculateMedia(intArray);

        System.out.println("O perimetro do rectangulo e: " + perimeter);
        System.out.println("O volume do paralelepipedo e: " + volume);
        System.out.println("A temperatura em Celsius e: " + temperature);
        System.out.println("O tempo em segundos e: " + time);
        System.out.println("max: " + maximum);
    }

    private static float calculateMedia(int[] intArray) {
        float soma = 0;
        for (int i = 0; i != intArray.length; i++) {
            soma+=intArray[i];
        }
        float media = soma/intArray.length;
        return media;
    }


    private static int transformToSeconds(int horas, int minutos, int segundos) {
        int time = horas * 3600 + minutos * 60 + segundos;
        return time;
    }

    private static float convertToCelsius(float farenheit) {
        float temperature = (farenheit - 32) * 5 / 9;
        return temperature;
    }

    private static int calculateVolume(int comprimento, int altura, int largura) {
        int volume = comprimento * altura * largura;
        return volume;
    }

    private static int calculatePerimeter(int base, int altura) {
        int perimeter = 2 * (base + altura);
        return perimeter;
    }
}
