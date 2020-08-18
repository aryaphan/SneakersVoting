package com.arya.dao;

import java.sql.Blob;
import java.util.List;

import com.arya.model.Sneaker;

public interface GetSneakers {
	public List<Sneaker> getAllSneakers();
	public Blob getPhotoById(int id);

}
