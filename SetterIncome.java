package org.matsim.project;

import java.util.Random;
import org.matsim.api.core.v01.population.Person;

public class SetterIncome {
		
		public void calculateIncome (Person person) {
			
			int age;	
			Random rand = new Random();		
	
			age = (int) person.getAttributes().getAttribute("age");

			if ( age >=0 && age <= 25 ) {
				int zufall = (int) (rand.nextDouble()*100)+1;			
				if ( zufall <=4) {
					person.getAttributes().putAttribute("income", "very low");	
				}
				if ( zufall >=5 && zufall <=13 ) {
					person.getAttributes().putAttribute("income", "low");	
				}
				if ( zufall >=14 && zufall <=55 ) {
					person.getAttributes().putAttribute("income", "medium");
				}
				if ( zufall >=56 && zufall <=93 ) {
					person.getAttributes().putAttribute("income", "high");
				}
				if ( zufall >=94 && zufall <=100 ) {
					person.getAttributes().putAttribute("income", "very high");

				}	
			}
			
			if ( age >=26 && age <= 35 ) {
				int zufall = (int) (rand.nextDouble()*100)+1;			
				if ( zufall <=3) {
					person.getAttributes().putAttribute("income", "very low");
				}
				if ( zufall >=4 && zufall <=13 ) {
					person.getAttributes().putAttribute("income", "low");
				}
				if ( zufall >=14 && zufall <=48 ) {
					person.getAttributes().putAttribute("income", "medium");
				}
				if ( zufall >=49 && zufall <=92 ) {
					person.getAttributes().putAttribute("income", "high");
				}
				if ( zufall >=93 && zufall <=100 ) {
					person.getAttributes().putAttribute("income", "very high");
				}	
			}
			
			if ( age >=36 && age <= 45 ) {
				int zufall = (int) (rand.nextDouble()*100)+1;			
				if ( zufall <=3) {
					person.getAttributes().putAttribute("income", "very low");
				}
				if ( zufall >=4 && zufall <=13 ) {
					person.getAttributes().putAttribute("income", "low");
				}
				if ( zufall >=14 && zufall <=45 ) {
					person.getAttributes().putAttribute("income", "medium");
				}
				if ( zufall >=46 && zufall <=90 ) {
					person.getAttributes().putAttribute("income", "high");
				}
				if ( zufall >=91 && zufall <=100 ) {
					person.getAttributes().putAttribute("income", "very high");
				}	
			}
			
			if ( age >=46 && age <= 55 ) {
				int zufall = (int) (rand.nextDouble()*100)+1;			
				if ( zufall <=2) {
					person.getAttributes().putAttribute("income", "very low");
				}
				if ( zufall >=3 && zufall <=9 ) {
					person.getAttributes().putAttribute("income", "low");
				}
				if ( zufall >=10 && zufall <=48 ) {
					person.getAttributes().putAttribute("income", "medium");
				}
				if ( zufall >=49 && zufall <=90 ) {
					person.getAttributes().putAttribute("income", "high");
				}
				if ( zufall >=91 && zufall <=100 ) {
					person.getAttributes().putAttribute("income", "very high");
				}	
			}
			
			if ( age >=56 && age <= 65 ) {
				int zufall = (int) (rand.nextDouble()*100)+1;			
				if ( zufall <=2) {
					person.getAttributes().putAttribute("income", "very low");
				}
				if ( zufall >=3 && zufall <=7 ) {
					person.getAttributes().putAttribute("income", "low");
				}
				if ( zufall >=8 && zufall <=54 ) {
					person.getAttributes().putAttribute("income", "medium");
				}
				if ( zufall >=55 && zufall <=90 ) {
					person.getAttributes().putAttribute("income", "high");
				}
				if ( zufall >=91 && zufall <=100 ) {
					person.getAttributes().putAttribute("income", "very high");
				}	
			}	
	}
}
