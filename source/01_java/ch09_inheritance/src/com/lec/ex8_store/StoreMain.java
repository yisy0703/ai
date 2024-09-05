package com.lec.ex8_store;
public class StoreMain {
	public static void main(String[] args) {
		HeadQuarterStore[] stores = { 
				new HeadQuarterStore("= = 본사 = ="),
				new Store1("= = 주택가 1호점 = ="),
				new Store2("= = 대학가 2호점 = ="),
				new Store3("= = 증권가 3호점 = =")
		};
		for(int idx=0 ; idx<stores.length ; idx++) {
			System.out.println(stores[idx]);
			stores[idx].kimchi();
			stores[idx].bude();
			stores[idx].bibim();
			stores[idx].sunde();
			stores[idx].gongi();
		} // 일반for
//		HeadQuarterStore head = new HeadQuarterStore("= = 본사 = =");
//		Store1 st1 = new Store1("= = 주택가 1호점 = =");
//		Store2 st2 = new Store2("= = 대학가 2호점 = =");
//		Store3 st3 = new Store3("= = 증권가 3호점 = =");
//		HeadQuarterStore[] stores = {head, st1, st2, st3};
	}
}
