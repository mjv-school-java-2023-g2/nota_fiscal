# Atividade Nota Fiscal
Proposta: Refatorar a classe ImpressorCupom
````
public class ImpressorCupom {
    public void imprimir(Cupom cupom){
        StringBuilder conteudo = new StringBuilder();
        conteudo.append(tracos());
        conteudo.append(cupom.nomeFantasia + "\n"); //preencher com espaços até ter 50 caracteres de comprimento
        Endereco end = cupom.endereco;
        conteudo.append(end.logradouro + " N. " + end.numero + " " + end.complemento + " " + end.bairro + " " + end.cidade + "-" + end.uf + "\n"); //como formatar vários campos
        conteudo.append("CPF/CNPJ:" + cupom.cpf + " " + cupom.data + "\n");//calcular os respectivos comprimentos e aplicar alinhamento
        conteudo.append("IE:" + cupom.ie + " " + cupom.hora + "\n");//calcular os respectivos comprimentos e aplicar alinhamento
        conteudo.append("IM:" + cupom.im + " " +  "CCF:" + cupom.ccf + "\n");//calcular os respectivos comprimentos e aplicar alinhamento
        conteudo.append("CDD:" + cupom.cdd + "\n");//aplicar alinhamento à direita
        conteudo.append(tracos());
        conteudo.append("CUPOM FISCAL\n");
        //modelo para ser replicado
        conteudo.append(String.format("ITEM COD. %-30s%10s\n","DESCRIÇÃO","VALOR"));
        for(CupomItem item:cupom.itens){
            conteudo.append("DESCRICAO DE ACORDO COM CADA ITEM EXISTENTE\n");
        }
        conteudo.append(tracos());
        System.out.println(conteudo.toString());
        //em caso de resolver explorar algumas formas de apresentação
        //return conteudo.toString();
    }
    private String tracos(){
        String repeated = new String(new char[50]).replace("\0", "-");
        return repeated + "\n";
    }
    private String cpfCnpj(String cpfCnpj){
        String newCnpj = "";
        if(cpfCnpj.length()==11)
            newCnpj = cpfCnpj.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        else
            newCnpj = cpfCnpj.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
        return newCnpj;
    }
}
````

![image](https://github.com/mjv-school-java-2023-g2/nota_fiscal/assets/70302908/4e27acd4-a377-4252-a436-1884551c3fa4)

Resultado:

![image](https://github.com/mjv-school-java-2023-g2/nota_fiscal/assets/70302908/86e5cf3b-e458-4333-a73d-a6baca87f2bb)


