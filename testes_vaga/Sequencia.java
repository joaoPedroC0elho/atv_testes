import java.util.Scanner;

public class Sequencia {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Informe um número: ");
        int numero = scanner.nextInt();

        
        if (pertenceFibonacci(numero)) {
            System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + numero + " NÃO pertence à sequência de Fibonacci.");
        }

        scanner.close();
    }

    
    public static boolean pertenceFibonacci(int num) {
        if (num == 0 || num == 1) {
            return true; 
        }

        int fib1 = 0, fib2 = 1;
        int fibAtual = fib1 + fib2;

        
        while (fibAtual <= num) {
            if (fibAtual == num) {
                return true; 
            }
            fib1 = fib2;
            fib2 = fibAtual;
            fibAtual = fib1 + fib2;
        }

        return false; 
    }
}
    

