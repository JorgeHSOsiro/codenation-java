package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TEste {
    public static void main(String[] args) {
        DesafioMeuTimeApplication ds = new DesafioMeuTimeApplication();
        ds.incluirTime(1L,"alpha", LocalDate.now(), "red", "blue");
        ds.incluirTime(2L,"beta", LocalDate.now(), "red", "blue");
        ds.incluirTime(3L,"gama", LocalDate.now(), "red", "blue");
        ds.incluirJogador(1L, 1L,"Jorge", LocalDate.of(1988, 10, 30),7, BigDecimal.TEN);
        ds.incluirJogador(2L, 1L,"Lucas", LocalDate.of(1987, 10, 30),8, BigDecimal.TEN);
        ds.incluirJogador(3L, 1L,"Fred", LocalDate.of(1987, 10, 30),6, BigDecimal.TEN);
        ds.incluirJogador(4L, 1L,"Gabriel", LocalDate.of(1987, 10, 30),4, BigDecimal.TEN);
        ds.incluirJogador(5L, 1L,"Jose", LocalDate.of(1987, 10, 30),2, BigDecimal.TEN);
        ds.incluirJogador(6L, 1L,"Felipe", LocalDate.of(1987, 10, 30),3, BigDecimal.TEN);
        ds.incluirJogador(7L, 1L,"Luis", LocalDate.of(1987, 10, 30),9, BigDecimal.TEN);
        ds.incluirJogador(8L, 1L,"Pedro", LocalDate.of(1987, 10, 30),10, BigDecimal.TEN);
        ds.buscarTopJogadores(3);
    }
}
