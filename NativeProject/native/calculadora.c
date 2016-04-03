#include <stdio.h>
#include "calculadora_Calculadora.h"
 
/*
 * Método que executa a soma
 */
int soma(int num1, int num2){
    return num1 + num2;
}
 
/*
 * Método com a mesma assinatura do calculadora_Calculadora.h
 */
JNIEXPORT jint JNICALL Java_calculadora_Calculadora_soma(JNIEnv * env, jobject jobj, jint num1, jint num2){
    return soma(num1, num2);
}