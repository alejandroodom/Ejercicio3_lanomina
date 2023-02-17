import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("¿Apellido de la persona?");
        String apellido = input.nextLine();

        System.out.println("¿Nombre de la persona?");
        String nombre = input.nextLine();

        System.out.println("¿Puesto?");
        System.out.println("1 - Agente de servicio");
        System.out.println("2 - Empleado de oficina");
        System.out.println("3 - Directivo");
        int puesto = input.nextInt();

        System.out.println("Número de horas trabajadas");
        int horas = input.nextInt();
        while(horas < 0){
            System.out.println("El número de horas no puede ser negativo");
            System.out.println("Número de horas trabajadas");
            horas = input.nextInt();
        }
        System.out.println("¿Tarifa horaria?");
        double tarifa = input.nextDouble();
        while(tarifa < 0){
            System.out.println("La tarifa horaria no puede ser negativa");
            System.out.println("¿Tarifa horaria?");
            tarifa = input.nextDouble();
        }

        System.out.println("¿Número de hijos?");
        int numHijos = input.nextInt();
        while(numHijos < 0){
            System.out.println("El número de hijos no puede ser negativo");
            System.out.println("¿Número de hijos?");
            numHijos = input.nextInt();
        }

        // Cálculo del salario bruto
        double salarioBruto;
        if (horas <= 169) {
            salarioBruto = horas * tarifa;
        } else if (horas > 169 && horas <= 180) {
            salarioBruto = 169 * tarifa + (horas - 169) * tarifa * 1.5;
        } else {
            salarioBruto = 169 * tarifa + 11 * tarifa * 1.5 + (horas - 180) * tarifa * 1.6;
        }

        // Cálculo de la prima familiar
        double primaFamiliar;
            if (numHijos == 1) {
                primaFamiliar = 20;
            } else if (numHijos == 2) {
                primaFamiliar = 50;
            } else if (numHijos > 2) {
                primaFamiliar = 70 + (numHijos - 2) * 20;
            } else {
                primaFamiliar = 0;
            }


        // Cálculo de las deducciones
        double deudaSocial = salarioBruto * 0.035;
        double contingenciasComunes = salarioBruto * 0.062;
        double seguroMedico = salarioBruto * 0.0095;
        double fondoPensiones = salarioBruto * 0.084;
        double seguroDesempleo = salarioBruto * 0.031;
        double pensionComplementaria = salarioBruto * 0.038;
        double jubilacionAnticipada = salarioBruto * 0.01;
        double deduccionesTotales = deudaSocial + contingenciasComunes + seguroMedico + fondoPensiones + seguroDesempleo + pensionComplementaria + jubilacionAnticipada;

        // Cálculo del salario neto
        double salarioNeto = salarioBruto - deduccionesTotales;

        // Cálculo del salario neto a pagar
        double salarioNetoAPagar = salarioNeto + primaFamiliar;

        // Mostrar la nómina simplificada
        System.out.println("\nNómina de " + nombre + " " + apellido);
        System.out.print("\nEstado: ");
        switch (puesto) {
            case 1:
                System.out.println("Agente de servicio");
                break;
            case 2:
                System.out.println("Empleado de oficina");
                break;
            case 3:
                System.out.println("Directivo");
                break;
            default:
                System.out.println("Sin especificar");
                break;
        }
        System.out.printf("\nSalario bruto: %.2f € (%d horas sin incremento, %d horas con incremento del 50 %%," +
                " %d horas con incremento del 60 %%)%n", salarioBruto, 169, horas - 169, horas - 180);

        System.out.println("\nCálculo de deducciones:\n" +
                "\nContribución para el pago de la deuda social y contingencias comunes imponible\n" + deudaSocial + "€" +
                "\n" +
                "\nContribución de contingencias comunes no imponible\n" + contingenciasComunes + "€" +
                "\n" +
                "\nSeguro médico\n" + seguroMedico + "€" +
                "\n" +
                "\nFondo de pensiones\n" + fondoPensiones + "€" +
                "\n" +
                "\nSeguro de desempleo\n" + seguroDesempleo + "€" +
                "\n" +
                "\nPensión complementaria (Entidad privada)\n" + pensionComplementaria + "€" +
                "\n" +
                "\nContribución de jubilación anticipada\n" + jubilacionAnticipada + "€" +
                "\n" +
                "\nDeducciones totales de los empleados: " + deduccionesTotales + "€" +
                "\n" +
                "\nSalario neto: " + salarioNeto + "€" +
                "\n" +
                "\nPrima familiar: " + primaFamiliar + "€" +
                "\n" +
                "\nSalario neto a pagar: " + salarioNetoAPagar + "€");
    }
}