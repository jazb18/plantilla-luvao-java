package com.luvao.mail;

import java.io.FileNotFoundException;
import java.io.IOException;

public class test {
	public static void main(String... args) throws FileNotFoundException, IOException{
		SendMailSSL mailSSL = new SendMailSSL(); 
		
		mailSSL.enviarMensaje("viktor", "vicktor@gmail.com", "mailing", "prueba");
		
	}
}
