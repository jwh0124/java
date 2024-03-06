package com.in28minutes.learnspringframework.examples.c1;

import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * PackageName    : com.in28minutes.learnspringframework.examples.c1
 * Author         : circle
 * Date           : 3/6/24
 * FileName       : IntelliJ IDEA
 * Name           : BusinessCalculationService
 * Description    :
 */
@Component
public class BusinessCalculationService {

	private DataService dataService;

	public BusinessCalculationService(DataService dataService) {
		this.dataService = dataService;
	}

	public int fineMax() {
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}
}
