package org.matsim.project;

import org.matsim.api.core.v01.population.Person;
import org.matsim.core.population.PersonUtils;
import scala.util.Random;

public class SetterAge {

	public void calculateAge (Person person) { // Altersverteilung in Anlehnung an Statistik für BS, nur 18-65
		
		int age = 0; 
		Random randomCohort = new Random();
		int cohortcount = randomCohort.nextInt(100);
		
		if (cohortcount <= 14) {
			double randomAge = Math.random();
			double ageD = randomAge * 7 + 18;
			age = (int) ageD;
			}
		else if (cohortcount <= 39) {
			double randomAge = Math.random();
			double ageD = randomAge * 10 + 25;
			age = (int) ageD;
		}
		else if (cohortcount <= 59) {
			double randomAge = Math.random();
			double ageD = randomAge * 10 + 35;
			age = (int) ageD;
		}
		else if (cohortcount <= 80) {
			double randomAge = Math.random();
			double ageD = randomAge * 10 + 45;
			age = (int) ageD;
		}
		else if (cohortcount <= 100) {
			double randomAge = Math.random();
			double ageD = randomAge * 10 + 55;
			age = (int) ageD;
		}
		
		PersonUtils.setAge(person, age);
	}
		
	}


