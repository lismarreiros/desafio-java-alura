import java.util.Scanner;

public class Main {
    private static Double balance;
    static Scanner read = new Scanner(System.in);
    private static int option;

    public static void main(String[] args) {
        String name = "Lando Norris";
        String typeOfAccount = "Corrente";
        balance = 4500.00;

        String statement = """
                **********************************************
                Dados iniciais do cliente:
                
                Nome do cliente:     %s
                Tipo de conta:       %s
                Saldo inicial:    R$ %f
                **********************************************
                """.formatted(name, typeOfAccount, balance);

        String menu = """
                Operações
                
                1 - Consultar saldos
                2 - Receber valor
                3 - Transferir valor
                4 - Sair
                
                Digite a opção desejada:
                """;

        System.out.println(statement);

        while (option != 4) {
            System.out.println(menu);
            int option = read.nextInt();
            if (option == 1) {
                balance();
            } else if (option == 2) {
                deposit();
            } else if (option == 3) {
                transfer();
            } else {
                break;
            }
        }
    }

    public static void balance() {
        System.out.println("O saldo atual é R$ " + balance);
    }

    public static void deposit() {
        System.out.println("Informe o valor a receber:");
        double valueIn = read.nextDouble();
        balance += valueIn;
        System.out.println("Saldo atualizado R$" + balance);
    }

    public static void transfer() {
        System.out.println("Informe o valor a que deseja transferir:");
        double valueOut = read.nextDouble();
        if (balance >= valueOut) {
            balance = balance - valueOut;
            System.out.println("Saldo atualizado R$" + balance);
        } else {
            System.out.println("Você não há saldo suficiente para fazer essa transferência.");
        }
    }
}