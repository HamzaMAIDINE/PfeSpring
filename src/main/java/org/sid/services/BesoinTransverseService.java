package org.sid.services;

import org.sid.entities.BesoinTransverse;

public interface BesoinTransverseService {

	public BesoinTransverse addBT(String id, BesoinTransverse bt);

	public BesoinTransverse editBT(String id, BesoinTransverse bt);

	public void deleteBt(int id);

}
