package com.herbtalk.model;

/**
 * This class represents the mapper associated with various aggregation queries
 * related to strains.
 * 
 * @author zoheb.nawaz
 *
 */
public class StrainMapper {

	private Strain strain;
	private Double count;

	public StrainMapper(Strain strain, Double count) {
		super();
		this.strain = strain;
		this.count = count;
	}

	public StrainMapper() {
		super();
	}

	public Strain getStrain() {
		return strain;
	}

	public Double getCount() {
		return count;
	}
}