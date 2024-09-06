import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Distribuidora {

    public static <JSONArray> void main(String[] args) {
        try {
            
            String conteudo = new String(Files.readAllBytes(Paths.get("dados.json")));
            JSONArray faturamentoMensal = new JSONArray(conteudo);

            
            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            double soma = 0.0;
            int diasComFaturamento = 0;

           
            for (int i = 0; i < faturamentoMensal.length(); i++) {
                JSONObject diaFaturamento = faturamentoMensal.getJSONObject(i);
                double valor = diaFaturamento.getDouble("valor");

                
                if (valor > 0) {
                    
                    if (valor < menorValor) {
                        menorValor = valor;
                    }
                    if (valor > maiorValor) {
                        maiorValor = valor;
                    }
                    soma += valor;
                    diasComFaturamento++;
                }
            }

           
            double mediaMensal = soma / diasComFaturamento;

            
            int diasAcimaDaMedia = 0;
            for (int i = 0; i < faturamentoMensal.length(); i++) {
                JSONObject diaFaturamento = faturamentoMensal.getJSONObject(i);
                double valor = diaFaturamento.getDouble("valor");

                if (valor > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }

            
            System.out.println("Menor valor de faturamento: " + menorValor);
            System.out.println("Maior valor de faturamento: " + maiorValor);
            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
