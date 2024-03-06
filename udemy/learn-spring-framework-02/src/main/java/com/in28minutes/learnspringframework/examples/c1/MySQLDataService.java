package com.in28minutes.learnspringframework.examples.c1;

import org.springframework.stereotype.Component;

/**
 * PackageName    : com.in28minutes.learnspringframework.examples.c1
 * Author         : circle
 * Date           : 3/6/24
 * FileName       : IntelliJ IDEA
 * Name           : MySQLDataService
 * Description    :
 */
@Component
public class MySQLDataService implements DataService{
	@Override
	public int[] retrieveData() {
		return new int[] {1, 2, 3, 4, 5};
	}
}
