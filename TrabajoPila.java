//PRESENTADO POR:
//JOSE ALEJANDRO IDROBO
// JUAN NANUEL IDROBO
import java.util.Scanner;

public class TrabajoPila {
    private int tamaño;    // Tamaño máximo de la pila
    private int[] pila;    // Array para almacenar los elementos de la pila
    private int tope;      // Índice del tope de la pila

    // Constructor para inicializar la pila con un tamaño determinado
    TrabajoPila(int tamaño) {
        this.tamaño = tamaño;
        this.pila = new int[tamaño];
        this.tope = -1;  // La pila comienza vacía
    }

    // Método para apilar o insertar un elemento en la pila
    public void apilar(int valor) {
        if (tope == tamaño - 1) {
            System.out.println("La pila está llena.");
        } else {
            tope++;
            pila[tope] = valor;
            System.out.println("Elemento " + valor + " apilado.");
        }
    }

    // Método para desapilar un elemento de la pila
    public void desapilar() {
        if (estaVacia()) {
            System.out.println("La pila está vacía, no se puede desapilar.");
        } else {
            int valor = pila[tope];
            tope--;
            System.out.println("Elemento " + valor + " desapilado.");
        }
    }

    // Método para obtener el elemento que está en el tope de la pila
    public int obtenerTope() {
        if (!estaVacia()) {
            return pila[tope];
        } else {
            System.out.println("La pila está vacía.");
            return -1;  // Retorno -1 si la pila está vacía
        }
    }

    // Método para mostrar los elementos de la pila
    public void mostrarElementos() {
        if (!estaVacia()) {
            System.out.println("Elementos en la pila:");
            for (int i = 0; i <= tope; i++) {
                System.out.println(pila[i]);
            }
        } else {
            System.out.println("La pila está vacía.");
        }
    }

    // Método para verificar si la pila está vacía
    public boolean estaVacia() {
        return tope == -1;
    }

    // Método para verificar si la pila está llena
    public boolean estaLlena() {
        return tope == tamaño - 1;
    }

    // Método para obtener el tamaño de la pila (número de elementos apilados)
    public int obtenerTamaño() {
        return tope + 1;
    }

    // Método para vaciar la pila
    public void vaciar() {
        tope = -1;
        System.out.println("La pila ha sido vaciada.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("Ingrese el tamaño de la pila:");
        int tamaño = scanner.nextInt();  // Tamaño de la pila definido por el usuario
        TrabajoPila pila = new TrabajoPila(tamaño);

        do {
            System.out.println("==== Menú ====");
            System.out.println("Selecciona una opción:");
            System.out.println("1. Apilar un elemento");
            System.out.println("2. Desapilar un elemento");
            System.out.println("3. Mostrar el tope de la pila");
            System.out.println("4. Mostrar los elementos de la pila");
            System.out.println("5. Verificar si la pila está vacía");
            System.out.println("6. Verificar si la pila está llena");
            System.out.println("7. Obtener el tamaño de la pila");
            System.out.println("8. Vaciar la pila");
            System.out.println("9. SALIR DEL PROGRAMA");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    if (!pila.estaLlena()) {
                        System.out.println("Ingresa el valor a apilar:");
                        int valor = scanner.nextInt();
                        pila.apilar(valor);
                    } else {
                        System.out.println("La pila está llena, no puedes apilar más elementos.");
                    }
                    break;
                case 2:
                    pila.desapilar();
                    break;
                case 3:
                    int tope = pila.obtenerTope();
                    if (tope != -1) {
                        System.out.println("El tope de la pila es: " + tope);
                    }
                    break;
                case 4:
                    pila.mostrarElementos();
                    break;
                case 5:
                    System.out.println("¿La pila está vacía? " + pila.estaVacia());
                    break;
                case 6:
                    System.out.println("¿La pila está llena? " + pila.estaLlena());
                    break;
                case 7:
                    System.out.println("El tamaño actual de la pila es: " + pila.obtenerTamaño());
                    break;
                case 8:
                    pila.vaciar();
                    break;
                case 9:
                    System.out.println("SALIENDO DEL PROGRAMA...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 9);

        scanner.close();
    }
}
