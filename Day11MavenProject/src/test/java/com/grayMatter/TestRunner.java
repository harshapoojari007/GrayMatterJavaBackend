package com.grayMatter;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@SuiteClasses({AppTest.class,CalculatorTest.class})
@IncludeCategory(MarkerInterface.class)
@RunWith(Categories.class)
public class TestRunner {

}
