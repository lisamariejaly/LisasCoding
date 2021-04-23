package org.matsim.project;

import java.util.Random;

import org.locationtech.jts.geom.Geometry;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.population.Person;
import org.matsim.core.population.PersonUtils;

public class SetterSex {

	public void calculateSex (String key, Person person) {	
		
		
//		home = c.getHome(); // oder lieber Setter-Methode?
//		String relation;
//		relation = CreatingDemand(getRelation());
//		
		// relation = (String) person.getAttributes().getpersonId("toFromPrefix");
		String sex = null; 	
		Random randomSex = new Random();
		int sexCount = randomSex.nextInt(100);
		
		if (key.contains("BS-BS")) {
			if (sexCount <= 50) {
				sex = "male"; }
			else {sex = "female"; }}
		
		if (key.contains("BS-WOB")) {
			if (sexCount <= 73) {
			sex = "male"; }
			else {sex = "female"; }}
	
		if (key.contains("BS-SZ")) {
			if (sexCount <= 72) {
				sex = "male"; }
			else {sex = "female"; }}
			
		if (key.contains("BS-WF")) {
			if (sexCount <= 44) {
					sex = "male"; }
			else {sex = "female"; }}
			
		if (key.contains("BS-GF")) {
			if (sexCount <= 65) {
					sex = "male"; }
			else {sex = "female"; }}
			
		if (key.contains("BS-H")) {
			if (sexCount <= 57) {
					sex = "male"; }
			else {sex = "female"; }}
		
		if (key.contains("BS-PE")) {
			if (sexCount <= 58) {
					sex = "male"; }
			else {sex = "female"; }}
			
		if (key.contains("BS-HE")) {
			if (sexCount <= 46) {
					sex = "male"; }
			else {sex = "female"; }}
			
		if (key.contains("BS-HI")) {
			if (sexCount <= 57) {
					sex = "male"; }
			else {sex = "female"; }}
			
		if (key.contains("BS-HH")) {
			if (sexCount <= 63) {
					sex = "male"; }
			else {sex = "female"; }}
			
		if (key.contains("BS-GS")) {
			if (sexCount <= 50) {
					sex = "male"; }
			else {sex = "female"; }}
			
		if (key.contains("WF-BS")) {
			if (sexCount <= 52) {
					sex = "male"; }
			else {sex = "female"; }}
				
		if (key.contains("PE-BS")) {
			if (sexCount <= 54) {
					sex = "male"; }
			else {sex = "female"; }}
					
		if (key.contains("GF-BS")) {
			if (sexCount <= 51) {
					sex = "male"; }
			else {sex = "female"; }}
			
		if (key.contains("SZ-BS")) {
			if (sexCount <= 53) {
					sex = "male"; }
			else {sex = "female"; }}
			
		if (key.contains("HE-BS")) {
			if (sexCount <= 55) {
					sex = "male"; }
			else {sex = "female"; }}
			
		if (key.contains("H-BS")) {
			if (sexCount <= 62) {
					sex = "male"; }
			else {sex = "female"; }}
			
		if (key.contains("WOB-BS")) {
			if (sexCount <= 49) {
					sex = "male"; }
			else {sex = "female"; }}
			
		if (key.contains("GS-BS")) {
			if (sexCount <= 56) {
					sex = "male"; }
			else {sex = "female"; }}
			
		if (key.contains("HK-BS")) {
			if (sexCount <= 66) {
					sex = "male"; }
			else {sex = "female"; }}
			
		if (key.contains("HI-BS")) {
			if (sexCount <= 64) {
					sex = "male"; }
			else {sex = "female"; }}
		
		
		PersonUtils.setSex(person, sex);
	}}


