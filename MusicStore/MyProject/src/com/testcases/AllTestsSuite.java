package com.testcases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Demo1.class, Demo2.class, Ex03Top5SellingAlbums.class,
		Ex04SearchBlackSabbath.class, Ex04SearchMetallica.class })
public class AllTestsSuite {

}
