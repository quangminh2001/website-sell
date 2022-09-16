package com.devpro.karma.component;

import com.github.slugify.Slugify;

public class Utilities {
	public static String slugify(String name) {
		return new Slugify().slugify(name)+System.currentTimeMillis();
	}
	public static void main(String[] args) {
		
		for(int i = 0; i < 10; i++) {
			System.out.println(System.currentTimeMillis()+i);
		}
	}
}

