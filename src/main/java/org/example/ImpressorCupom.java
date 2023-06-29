package org.example;

import org.example.models.Cupom;
import org.example.models.CupomItem;
import org.example.models.Endereco;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ImpressorCupom {
    public void imprimir(Cupom cupom){
        /**
         vamos somente impimir o resultado no console
         mas este mesmo conteúdo poderá proporicionar várias saidas
         logo a variável conteudo deveria ser retornada para outros "processadores"
         como gerador de arquivo txt, pdf ou até mesmo envio por e-mail
         */

        /*
        CONSIDERE O COMPRIMENTO MÁXIMO DE 50 CARACTERES EM CADA LINHA
        E APLIQUE O RESPECTIVO ALINHAMENTO
         */
        List<CupomItem> itens = cupom.itens;

        Endereco end = cupom.endereco;
        String conteudo = String.format("""
                        %s
                        %30s
                        %s Nº %s %s %s %s %s 
                        CPF/CNPJ:%-30s%s
                        IE: %-35s%s
                        IM: %-35s%s
                        CDD: %-40s
                        %s
                        CUPOM FISCAL
                        ITEM COD. %-30s%10s
                        """
                ,tracos()
                ,cupom.nomeFantasia
                ,end.logradouro, end.numero, end.complemento, end.bairro, end.cidade, end.uf
                ,cpfCnpj(cupom.cpf), cupom.data
                ,cupom.ie, cupom.hora.toString()
                ,cupom.im, cupom.ccf.toString()
                ,cupom.cdd.toString()
                ,tracos()
                ,"DESCRIÇÃO","VALOR"
        );

        System.out.println(conteudo.concat(getItens(itens)));
    }
    private String tracos(){
        String repeated = new String(new char[50]).replace("\0", "-");
        return repeated;
    }
    private String cpfCnpj(String cpfCnpj){
        String newCnpj = "";
        if(cpfCnpj.length()==11)
            newCnpj = cpfCnpj.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        else
            newCnpj = cpfCnpj.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
        return newCnpj;
    }

    private String getItens(List<CupomItem> itens){
        StringBuilder cf = new StringBuilder();
        itens.stream().map(
                item-> String.format("%-5s%-5s%-30s%10.2f \n",
                                item.ordem,
                                item.sku,
                                item.descricao,
                                item.preco*item.quantidade
                )
        ).forEach(cf::append);
        cf.append(tracos());
        return cf.toString();
    }
}
