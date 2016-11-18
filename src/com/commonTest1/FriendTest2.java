package com.commonTest1;

import java.util.List;

import com.commonTest.FriendlyTest;

public interface FriendTest2<T> extends FriendlyTest<T>{
   
	List<T> getName();
}
