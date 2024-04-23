package domain;

import java.util.Scanner;

import exception.ParametrosInvalidosException;

public class Contador {

    private static final String ENTRADA_INVALIDA = "Entrada inválida. Digite um número inteiro:";
    private static final String MESSAGE = "O valor final deve ser maior que o valor inicial";

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("-------------------Desafio Controle de fluxo---------------------");
        System.out.println("Digite dois valores para saber o número de interações entre eles.");
        System.out.println("valor inicial : ");
        var parametroInicial = lerInteiro(input);

        System.out.println("valor final : ");
        var parametroFinal = lerInteiro(input);

        try {
            contar(parametroInicial, parametroFinal);
        } catch (ParametrosInvalidosException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void contar(Integer parametroInicial, Integer parametroFinal) throws ParametrosInvalidosException {

        if (parametroInicial.compareTo(parametroFinal) >= 0) {
            throw new ParametrosInvalidosException(MESSAGE);
        } else {
            var diferenca = parametroFinal - parametroInicial;
            for (int i = 1; i <= diferenca; ++i) {
                System.out.println("Imprimindo a " + i + "ª interação: " + i);
            }
        }
    }

    public static int lerInteiro(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(ENTRADA_INVALIDA);
            }
        }
    }
}
