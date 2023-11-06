import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //inicializo la matriz de 6x6
        String[][] sospechosoADN = new String[6][6];

        //SI POSEE UNA CADENA DE ADN PREVIA...
        //COMENTE LA SIGUIENTE LINEA ↓↓↓
        sospechosoADN = llenaADN();
        //LUEGO DESCOMENTE EL SIGUIENTE FRAGMENTO DE CODIGO ↓↓↓
        /*
         * sospechosoADN = {
         *      {"A", "T", "G", "C", "G", "A"},
         *      {"C", "A", "G", "T", "G", "C"},
         *      {"T", "T", "A", "T", "G", "T"},
         *      {"A", "G", "A", "A", "G", "G"},
         *      {"C", "C", "C", "C", "T", "A"},
         *      {"T", "C", "A", "C", "T", "G"}
         * };
         */

        /*
         *      SI NO POSEE CADENAS DE ADN NO TOQUE NADA.
         *                                       GRACIAS.
         */

        //imprimo el ADN del sujeto
        System.out.println("ADN del sujeto: \n");
        for (int i=0; i< sospechosoADN.length; i++){
            for (int j=0; j< sospechosoADN.length; j++){
                System.out.print("[" + sospechosoADN [i][j] + "]");
            }
            System.out.println();
        }
        System.out.println();
        //llamo a la funcion que me dice si el ADN es de mutante o no...
        boolean esMutante = esMutante(sospechosoADN);
        if(esMutante){              //si la funcion me devuelve "true"...
            System.out.println("ADN MUTANTE ENCONTRADO...");    //imprimo el mensaje correspondiente
        }else {                     //sino (funcion devuelve "false")...
            System.out.println("ADN no mutante encontrado");    //imprimo el mensaje correspondiente
        }
    }

    //procedimiento que me llena la matriz de ADN
    public static String[][] llenaADN(){
        //inicializo la matriz
        String[][] cadADN = new String[6][6];
        //limito las letras posibles a "A", "T", "C", "G"
        String[] letras = {"A", "T", "C", "G"};
        Random rand = new Random();             //inicio la funcion RANDOM
        for (int i=0; i<cadADN.length; i++){        //recorro la matriz...
            for(int j=0; j< cadADN.length; j++){
                int randomIndex = rand.nextInt(letras.length);  //lleno la matriz con una
                cadADN[i][j] = letras[randomIndex];             // letra aleatoria de las disponibles
            }
        }
        return cadADN;  //devuelvo la matriz llena
    }

    //funcion que me dice si se trata de ADN mutante o no
    public static boolean esMutante(String[][] dna) {
        //inicializo "n" igual a la longitud de la matriz para no volver a analizar lo ya analizado
        int n = dna.length;
        int count = 0; //contador de cantidad de secuencias

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Verifico horizontalmente
                if (j + 3 < n) {
                    if (dna[i][j].equals(dna[i][j + 1]) &&
                            dna[i][j].equals(dna[i][j + 2]) &&
                            dna[i][j].equals(dna[i][j + 3])) {
                        count++;
                    }
                }
                // Verifico verticalmente
                if (i + 3 < n) {
                    if (dna[i][j].equals(dna[i + 1][j]) &&
                            dna[i][j].equals(dna[i + 2][j]) &&
                            dna[i][j].equals(dna[i + 3][j])) {
                        count++;
                    }
                }
                // Verifico en diagonal hacia la derecha (en paralelo a la diagonal principal)
                if (i + 3 < n && j + 3 < n) {
                    if (dna[i][j].equals(dna[i + 1][j + 1]) &&
                            dna[i][j].equals(dna[i + 2][j + 2]) &&
                            dna[i][j].equals(dna[i + 3][j + 3])) {
                        count++;
                    }
                }
                // Verifico en diagonal hacia la izquierda (en paralelo a la diagonal secundaria)
                if (i + 3 < n && j - 3 >= 0) {
                    if (dna[i][j].equals(dna[i + 1][j - 1]) &&
                            dna[i][j].equals(dna[i + 2][j - 2]) &&
                            dna[i][j].equals(dna[i + 3][j - 3])) {
                        count++;
                    }
                }
            }
        }

        return count > 1; // Si se encuentran más de una secuencia, el humano es mutante.
    }
}
