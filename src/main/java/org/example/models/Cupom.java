package org.example.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Cupom {
    public String nomeFantasia;
    public Endereco endereco;
    public String cpf;
    public String ie;
    public String im;
    public LocalDate data;
    public LocalTime hora;
    public Integer ccf;
    public Integer cdd;
    public List<CupomItem> itens = new ArrayList<>();
}
