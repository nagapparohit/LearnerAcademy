package com.nagappa.comparator;

import java.util.Comparator;

import com.nagappa.model.ClassEntity;

public class ClassComparator implements Comparator<ClassEntity> {

	@Override
	public int compare(ClassEntity o1, ClassEntity o2) {
		// TODO Auto-generated method stub
		if(o1.getValue() == o2.getValue()) {
			return Character.compare(o1.getSection(), o2.getSection());
		}else {
			return o1.getValue() - o2.getValue();
		}
	}

	
}
