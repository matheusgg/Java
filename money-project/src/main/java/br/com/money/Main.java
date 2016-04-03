package br.com.money;

import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryOperator;
import javax.money.format.AmountFormatQuery;
import javax.money.format.AmountFormatQueryBuilder;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.RoundedMoney;
import org.javamoney.moneta.format.CurrencyStyle;
import org.javamoney.moneta.function.MonetaryUtil;

public class Main {

	/**
	 * Todos os objetos da nova API monetária são Thread Safe e imutáveis, ou
	 * seja, cada opração retorna um novo objeto sem alterar o antigo.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Locale br = new Locale("pt", "BR");
		CurrencyUnit real = Monetary.getCurrency(br);

		MonetaryAmount doisReais = Money.of(2.00, real);
		MonetaryAmount dezReais = Money.of(10.00, real);

		// Adição
		System.out.println(doisReais.add(dezReais));

		// Subtração
		System.out.println(dezReais.subtract(doisReais));

		// Divisão
		System.out.println(dezReais.divide(2));

		// Multiplicação
		System.out.println(doisReais.multiply(5));

		// Negação
		MonetaryAmount menosDoisReais = doisReais.negate();
		System.out.println(menosDoisReais);
		System.out.println(menosDoisReais.negate());

		// Resto da divisão
		System.out.println(menosDoisReais.remainder(2));

		// 10% de um valor monetário
		MonetaryAmount cemReais = FastMoney.of(100, real);
		System.out.println(cemReais.with(MonetaryUtil.percent(10)));

		// Obtendo apenas os centavos
		System.out.println(cemReais.with(MonetaryUtil.minorPart()));

		// Obtendo o valor inteiro
		System.out.println(cemReais.with(MonetaryUtil.majorPart()));

		// Aplicando operacoes customizadas
		MonetaryOperator desconto = (amount) -> amount.isGreaterThan(cemReais) ? amount.subtract(dezReais) : amount;
		MonetaryAmount trezentosReais = RoundedMoney.of(300, real, desconto);
		System.out.println(trezentosReais.add(FastMoney.of(100, real)));
		System.out.println(trezentosReais.subtract(FastMoney.of(250, real)));

		// Formatação
		AmountFormatQuery formatQuery = AmountFormatQueryBuilder.of(br).set(CurrencyStyle.SYMBOL).build();
		MonetaryAmountFormat formatter = MonetaryFormats.getAmountFormat(formatQuery);
		System.out.println(formatter.format(cemReais));

		// Conversão entre moedas
		// Locale us = new Locale("en", "US");
		// CurrencyUnit dolar = Monetary.getCurrency(us);

		// MonetaryAmount doisDolares = Money.of(2, dolar);

		/*
		 * Lancará uma exceção, pois todas as operações devem ser realizadas com
		 * moedas do mesmo tipo
		 */
		// System.out.println(dezReais.add(doisDolares));

		// Conversão utilizando a cotação do Banco Central Europeu
		// Convertendo real em dolar
		// ExchangeRateProvider exchanger =
		// MonetaryConversions.getExchangeRateProvider(ExchangeRateType.ECB);
		// CurrencyConversion dollarConversor =
		// exchanger.getCurrencyConversion(dolar);
		// MonetaryAmount dezReaisConvertidosParaDolar =
		// dollarConversor.apply(dezReais);
		// System.out.println(dezReaisConvertidosParaDolar.add(doisDolares));

	}

}
