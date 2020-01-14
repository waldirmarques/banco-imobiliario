package br.ufpb.sisBanco_Imobiliario;

public interface Cartas {
    
    //Método abstrato implementados por quem assina o contrato
    //com a interface.
    public abstract String status();

    @Override
    public abstract String toString();

}
