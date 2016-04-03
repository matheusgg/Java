package com.testepackage;

public class App{
	public static void main(String[] args){
		Say_Hello h = new Say_Hello();
		h.go();
	}
}

class Say_Hello{
	public void go(){
		System.out.println("Hello!!!");
	}
}
		