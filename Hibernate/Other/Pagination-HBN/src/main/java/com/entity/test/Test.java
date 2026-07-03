package com.entity.test;
import org.hibernate.Session;


import com.dao.Crud;
public class Test {
	public static void main(String args[]) {
		Session connection = new Crud().connection();
		new Crud().insert();
	}
}
