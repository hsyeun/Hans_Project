package com.StrategyPattern;

public class NoSignUp implements PossessBehavior {

	@Override
	public void possess() {
		System.out.println("책을 등록하지 않았어");

	}

}
