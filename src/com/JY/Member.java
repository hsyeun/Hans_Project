package com.JY;

import lombok.Data;

@Data
public class Member {

	Behavior be;

	public void borrowView() {
		be.borrow();
	}

	public void returningView(){
		be.returning();
	}

	public void deleteView(){
		be.delete();
	}

	public void returnTryView(){
		be.returnTry();
	}

	public void reservebackView(){
		be.reserveback();
	}
}
