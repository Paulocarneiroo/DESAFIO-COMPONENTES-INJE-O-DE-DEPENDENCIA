package com.desafio.desafioFdm;

import com.desafio.entities.Order;
import com.desafio.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.desafio"})
public class DesafioFdmApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(DesafioFdmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		System.out.println("ENTER DATA:");
		System.out.print("Code: ");
		int code = sc.nextInt();
		System.out.print("Basic Value: ");
		double basicValue = sc.nextDouble();
		System.out.print("Discount: ");
		double discount = sc.nextDouble();


		Order order = new Order(code, basicValue, discount);

		System.out.println();
		System.out.println("CODE ORDER: " + order.getCode());
		System.out.println("Total Value: " + String.format("%.2f", orderService.total(order)));
		sc.close();
	}
}
