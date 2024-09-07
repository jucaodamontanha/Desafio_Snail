import java.util.ArrayList;
import java.util.List;

public class Snail {
    // Função para percorrer a matriz em padrão de caracol no sentido horário
    public static List<Integer> percorrerMatriz(int[][] matriz) {
        List<Integer> resultado = new ArrayList<>();

        // Verificar se a matriz está vazia ou nula
        if (matriz == null || matriz.length == 0) {
            return resultado;
        }

        // Inicializa os limites da matriz
        int linhaInicio = 0, linhaFim = matriz.length - 1;
        int colunaInicio = 0, colunaFim = matriz[0].length - 1;

        // Percorre a matriz enquanto os limites forem válidos
        while (linhaInicio <= linhaFim && colunaInicio <= colunaFim) {
            // Percorre a linha superior da esquerda para a direita
            for (int i = colunaInicio; i <= colunaFim; i++) {
                resultado.add(matriz[linhaInicio][i]);
            }
            linhaInicio++;

            // Percorre a coluna direita de cima para baixo
            for (int i = linhaInicio; i <= linhaFim; i++) {
                resultado.add(matriz[i][colunaFim]);
            }
            colunaFim--;

            // Verifica se ainda há linhas para percorrer
            if (linhaInicio <= linhaFim) {
                // Percorre a linha inferior da direita para a esquerda
                for (int i = colunaFim; i >= colunaInicio; i--) {
                    resultado.add(matriz[linhaFim][i]);
                }
                linhaFim--;
            }

            // Verifica se ainda há colunas para percorrer
            if (colunaInicio <= colunaFim) {
                // Percorre a coluna esquerda de baixo para cima
                for (int i = linhaFim; i >= linhaInicio; i--) {
                    resultado.add(matriz[i][colunaInicio]);
                }
                colunaInicio++;
            }
        }

        // Retorna a lista com os elementos na ordem de caracol
        return resultado;
    }

    // Função principal para testar a função percorrerMatriz
    public static void main(String[] args) {
        int[][] matriz1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matriz2 = {
                {1, 2, 3},
                {4, 10, 12},
                {6, 7, 33}
        };

        // Imprime os resultados das matrizes de teste
        System.out.println(percorrerMatriz(matriz1)); // [1, 2, 3, 6, 9, 8, 7, 4, 5]
        System.out.println(percorrerMatriz(matriz2)); // [1, 2, 3, 12, 33, 7, 6, 4, 10]
    }
}
