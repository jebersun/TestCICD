package com.ibm.qe;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Categories.class)
@IncludeCategory(TestInterface.class)
@Suite.SuiteClasses({TestNationwide.class, TestFailedScenario.class})
public class TestSuite {

}
